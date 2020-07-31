package com.healthElite.controller;

import java.io.ByteArrayInputStream;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.servlet.http.HttpServletResponse;

import org.apache.commons.io.IOUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import com.healthElite.model.CoachInfo;
import com.healthElite.model.CoachTraineeAssociation;
import com.healthElite.model.Login;
import com.healthElite.model.Plan;
import com.healthElite.model.PlanInfo;
import com.healthElite.model.TraineeInfo;
import com.healthElite.model.FileRecord;
import com.healthElite.service.CoachInfoServiceImpl;
import com.healthElite.service.PlanInfoServiceImpl;
import com.healthElite.service.TraineeInfoServiceImpl;

@Controller
@SessionAttributes({ "coachInfo", "traineeInfo", "login" })
public class HealthEliteController {

	private static final String ROLE_COACH = "1";
	private static final String ROLE_TRAINEE = "2";

	@Autowired
	PlanInfoServiceImpl planInfoService;
	@Autowired
	CoachInfoServiceImpl coachInfoService;
	@Autowired
	TraineeInfoServiceImpl traineeInfoService;

	@RequestMapping(value = "/")
	public ModelAndView home(Model model) {
		// If coach logs in then divert to coach menus
		UserDetails userDetails = getUserDetails();
		if (userDetails != null) {
			Collection<GrantedAuthority> authorities = (Collection<GrantedAuthority>) userDetails.getAuthorities();
			String userName = userDetails.getUsername();
			String redirect = "initial/Welcome";
			if (isRolePresent(authorities, ROLE_COACH)) {
				redirect = "redirect:coachLanding";
			} else if (isRolePresent(authorities, ROLE_TRAINEE)) {
				redirect = "redirect:traineeLanding";
			}
			return new ModelAndView(redirect, "userName", userName);
		}
		return new ModelAndView("initial/Welcome");
	}

	@RequestMapping(value = "/welcome")
	public ModelAndView welcome() {
		return new ModelAndView("initial/Welcome");
	}

	@RequestMapping(value = "/coachLanding")
	@PreAuthorize("hasRole(ROLE_COACH)")
	private ModelAndView coachLanding(
			@ModelAttribute(value = "userName") String userName, Model model) {
		CoachInfo coachInfo = coachInfoService.findByUserName(userName);
		model.addAttribute(coachInfo);
		Login login = coachInfo.getRoles().getLogin();
		model.addAttribute(login);
		//Default tab when coach opens page. Future will be to set it based on user preferences.
		model.addAttribute("traineeTab", "active");
		ModelAndView coachModelView = new ModelAndView("secure/CoachLanding",
				"coachInfo", coachInfo);

		return coachModelView;
	}

	@RequestMapping(value = "/traineeLanding")
	@PreAuthorize("hasRole(ROLE_TRAINEE)")
	private ModelAndView traineeLanding(String userName, Model model) {
		TraineeInfo traineeInfo = traineeInfoService.findByUserName(userName);
		Login login = traineeInfo.getRoles().getLogin();
		model.addAttribute(login);
		return new ModelAndView("secure/TraineeLanding", "traineeInfo",
				traineeInfo);
	}

	@RequestMapping(value = "/addCoach")
	@PreAuthorize("hasRole(ROLE_TRAINEE)")
	public ModelAndView addCoach(
			@ModelAttribute(value = "traineeInfo") TraineeInfo traineeInfo,
			@ModelAttribute(value = "coachInfo") CoachInfo coachInfo,
			org.springframework.web.context.request.WebRequest webRequest,
			Model model) {
		CoachTraineeAssociation cta = new CoachTraineeAssociation();
		cta.setCoachInfo(coachInfo);
		cta.setTraineeInfo(traineeInfo);
		cta.setActive(false);
		coachInfo.getCoachTraineeAssociations().add(cta);
		coachInfoService.save(coachInfo);
		return new ModelAndView("secure/CoachDetails", "coachInfo", coachInfo);
	}

	@RequestMapping(value = "/manageTrainees")
	@PreAuthorize("hasRole(ROLE_COACH)")
	public ModelAndView manageTrainees(
			@ModelAttribute(value = "coachInfo") CoachInfo coachInfo,
			@ModelAttribute(value = "login") Login login,
			org.springframework.web.context.request.WebRequest webRequest,
			Model model) {

		String traineeAction = webRequest.getParameter("traineeAction");
		String[] selectedIds = webRequest.getParameterValues("selectedId");

		if (traineeAction != null && selectedIds != null) {

			Set<CoachTraineeAssociation> coachTraineeAssociation = coachInfo
					.getCoachTraineeAssociations();
			List<Integer> activateTraineesList = new ArrayList<Integer>();
			for (String id : selectedIds) {
				Integer intId = Integer.parseInt(id);
				for (CoachTraineeAssociation assn : coachTraineeAssociation) {
					if (intId.intValue() == assn.getTraineeInfo()
							.getTraineeInfoId()) {
						if (traineeAction.equals("ActivateTrainees")) {
							assn.setActive(true);
						} else if (traineeAction.equals("DeActivateTrainees")) {
							assn.setActive(false);
						}
					}
				}
				activateTraineesList.add(intId);

				coachInfoService.save(coachInfo);

			}
		}
		model.addAttribute("traineeTab", "active");	
		return new ModelAndView("secure/CoachLanding");
	}

	@RequestMapping(value = "/managePlanTemplates")
	@PreAuthorize("hasRole(ROLE_COACH)")
	public ModelAndView managePlanTemplates(
			@ModelAttribute(value = "coachInfo") CoachInfo coachInfo,
			org.springframework.web.context.request.WebRequest webRequest,
			Model model) {
		
		String planAction = webRequest.getParameter("planTemplateAction");
		String[] selectedIds = webRequest.getParameterValues("selectedId");
		
		if (planAction != null && selectedIds != null) {

			Set<PlanInfo> planInfos = coachInfo.getPlanInfos();
			Set<PlanInfo> planInfosToBeDeleted = new HashSet<PlanInfo>();
			for (String id : selectedIds) {
				Integer intId = Integer.parseInt(id);
				for (PlanInfo planInfo : planInfos) {
					if (intId.equals(planInfo.getPlanInfoId())) {
						if (planAction.equals("activatePlanTemplates")) {
							planInfo.setActive(true);
						} else if (planAction.equals("deActivatePlanTemplates")) {
							planInfo.setActive(false);
						}
						else if (planAction.equals("deletePlanTemplates")) {
							planInfosToBeDeleted.add(planInfo);
						}
					}
				}
			}
			coachInfo.getPlanInfos().removeAll(planInfosToBeDeleted);
			coachInfoService.save(coachInfo);
			
		}
		//This tells which tab to display after each action. Set this to appropriate tab for use within this tabset.
		model.addAttribute("planTemplatesTab", "active");	
		return new ModelAndView("secure/CoachLanding");
	}
	
	
	@RequestMapping(value = "/managePlans")
	@PreAuthorize("hasRole(ROLE_COACH)")
	public ModelAndView managePlans(
			@ModelAttribute(value = "traineeInfo") TraineeInfo traineeInfo,
			@ModelAttribute(value = "coachInfo") CoachInfo coachInfo,
			@RequestParam(value="name",required=false) String name,
			@RequestParam(value="description", required=false) String description,
			@RequestParam(value="file", required=false) MultipartFile file,
			org.springframework.web.context.request.WebRequest webRequest,
			Model model) {
		
		String planAction = webRequest.getParameter("planAction");
		String selectedPlanInfoId = webRequest.getParameter("selectedPlanInfoId");
		System.out.println("Plan Action is "+planAction);
		if (planAction != null ) {
			/**Creates plan from existing template. Get the plan templates that belong to the coach and then find the plan info. Using plan info create
			 the plan and associate with the trainee 
			 **/ 
			if(planAction.equals("createPlanFromTemplate") && selectedPlanInfoId != null) {
				Set <PlanInfo> planTemplates = coachInfo.getPlanInfos();
				PlanInfo planInfo = planInfoService.findPlanInfoByPlanInfoId(new Integer(selectedPlanInfoId));
	
				//check if plan template belongs to coach
				if(planTemplates.contains(planInfo)) {	
					Plan plan = new Plan();
					plan.setPlanInfo(planInfo);
					plan.setTraineeInfo(traineeInfo);
					traineeInfo.getPlans().add(plan);
					planInfo.getPlans().add(plan);
					traineeInfoService.save(traineeInfo);
				}
				else {
					//TODO: raise an error message!
					System.out.println("Error");
				}
			}
			System.out.println("Plan Action "+planAction);
			/**
			 * Creates plan from a new template. First create the template and then use the template to create the plan.
			 */
			if(planAction.equals("createPlanFromNewTemplate")) { 
				System.out.println("here");
				PlanInfo planInfo = createPlanInfo(name, description, coachInfo, file);
				Plan plan = new Plan();
				plan.setPlanInfo(planInfo);
				plan.setTraineeInfo(traineeInfo);
				traineeInfo.getPlans().add(plan);
				System.out.println("Plan Info plans "+planInfo.getPlans());
				planInfo.getPlans().add(plan);
				traineeInfoService.save(traineeInfo);

			}
		}
		//This tells which tab to display after each action. Set this to appropriate tab for use within this tabset.
		model.addAttribute("planTab", "active");	
		return new ModelAndView("secure/TraineeDetails");
	}
	
	@RequestMapping(value = "/viewPlanTemplate", method = RequestMethod.GET)
	@PreAuthorize("hasRole(ROLE_COACH)")
	public ModelAndView viewPlan(@RequestParam("selectedId") String planInfoId, HttpServletResponse response) {

	      // get your file as InputStream
		//TODO refactor to use the blob inputstream ??? Research on which is better to scale this
	      InputStream is = new ByteArrayInputStream(planInfoService.findPlanInfoByPlanInfoId(new Integer(planInfoId)).getFileRecord().getData());
	      // copy it to response's OutputStream
	      try {
			IOUtils.copy(is, response.getOutputStream());
			response.flushBuffer();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    
	      return new ModelAndView("secure/CoachLanding");

	}

	@RequestMapping(value = "/uploadPlanTemplate", method = RequestMethod.POST)
	@PreAuthorize("hasRole(ROLE_COACH)")
	public ModelAndView uploadFormTemplate(
			@ModelAttribute(value = "coachInfo") CoachInfo coachInfo,
			@RequestParam("name") String name,
			@RequestParam("description") String description,
			@RequestParam("file") MultipartFile file, Model model) {

		createPlanInfo(name,description, coachInfo, file);
		
		model.addAttribute("planTemplatesTab", "active");
		return new ModelAndView("secure/CoachLanding");
	}
	
	private PlanInfo createPlanInfo(String name, String description, CoachInfo coachInfo, MultipartFile file){
		PlanInfo planInfo = new PlanInfo();
		planInfo.setActive(false);
		planInfo.setName(name);
		planInfo.setCoachInfo(coachInfo);
		planInfo.setDescription(description);
		coachInfo.getPlanInfos().add(planInfo);
		//upload the file and set the file record on to the planInfo
		FileRecord fileRecord = uploadFile(name,file);
		planInfo.setFileRecord(fileRecord);
		planInfoService.save(planInfo);	
		return planInfo;
	}
	
	private FileRecord uploadFile (String name, MultipartFile file) {
		FileRecord fileRecord = new FileRecord();
		fileRecord.setName(name);
		byte[] data = null;
		try {
			data = file.getBytes();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if (data != null && data.length > 0) {
			fileRecord.setData(data);
		}
		return fileRecord;
	}

	@RequestMapping(value = "/search", method = RequestMethod.POST)
	public ModelAndView search(
			@RequestParam("searchAction") String searchAction,
			@RequestParam("searchString") String searchString, Model model) {

		searchString = searchString.trim();
		model.addAttribute("searchString", searchString);

		if (searchAction.equals("searchPlan")) {
			List<PlanInfo> planInfos = planInfoService.findByNameLike("%"
					+ searchString + "%");

			ModelAndView mav = new ModelAndView("initial/SearchPlan",
					"planInfos", planInfos);

			return mav;
		} else if (searchAction.equals("searchCoach")) {
			List<CoachInfo> coachInfos = coachInfoService
					.findByLastNameOrFirstNameLike("%" + searchString + "%");
			return new ModelAndView("initial/SearchCoach", "coachInfos",
					coachInfos);
		}

		return new ModelAndView("initial/Welcome");
	}

	@RequestMapping(value = "/planDetails")
	public ModelAndView planDetails(
			@RequestParam("selectedId") String planInfoIdString, Model model) {
		Integer planInfoId = Integer.parseInt(planInfoIdString);
		PlanInfo planInfo = planInfoService
				.findPlanInfoByPlanInfoId(planInfoId);
		return new ModelAndView("secure/PlanDetails", "planInfo", planInfo);
	}

	@RequestMapping(value = "/coachDetails", method = RequestMethod.POST)
	public ModelAndView coachDetails(
			@RequestParam("selectedId") String coachInfoIdString, Model model) {
		Integer coachInfoId = Integer.parseInt(coachInfoIdString);
		CoachInfo coachInfo = coachInfoService
				.findCoachInfoByCoachInfoId(coachInfoId);
		return new ModelAndView("secure/CoachDetails", "coachInfo", coachInfo);
	}

	@RequestMapping(value = "/traineeDetails", method = RequestMethod.GET)
	public ModelAndView traineeDetails(
			@RequestParam("selectedId") String traineeInfoIdString, Model model) {
		Integer traineeInfoId = Integer.parseInt(traineeInfoIdString);
		TraineeInfo traineeInfo = traineeInfoService
				.findTraineeInfoByTraineeInfoId(traineeInfoId);
		return new ModelAndView("secure/TraineeDetails", "traineeInfo",
				traineeInfo);
	}

	private UserDetails getUserDetails() {
		Object principal = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();

		UserDetails userDetails = null;

		if (principal != null && principal instanceof UserDetails) {
			userDetails = (UserDetails) principal;
		}

		return userDetails;
	}

	/**
	 * Check if a role is present in the authorities of current user
	 * 
	 * @param authorities
	 *            all authorities assigned to current user
	 * @param role
	 *            required authority
	 * @return true if role is present in list of authorities assigned to
	 *         current user, false otherwise
	 */
	private boolean isRolePresent(Collection<GrantedAuthority> authorities,
			String role) {
		boolean isRolePresent = false;
		for (GrantedAuthority grantedAuthority : authorities) {
			isRolePresent = grantedAuthority.getAuthority().equals(role);
			if (isRolePresent)
				break;
		}
		return isRolePresent;
	}

}
