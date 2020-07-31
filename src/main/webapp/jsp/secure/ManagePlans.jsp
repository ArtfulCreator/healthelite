<%@ page language="java"
	import="com.healthElite.servlet.*,
									com.healthElite.model.*, 
									java.util.*,com.healthElite.service.*,
									org.springframework.web.context.*,
									org.springframework.web.context.support.WebApplicationContextUtils"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<table>
	<tbody>
				
				<tr>
					<td style="width: 196px; height: 19px; text-align: center;"><br>
					</td>
					<td style="width: 163px; height: 19px; text-align: left;"
						colspan="3" rowspan="1">
						Plans
						<form:form method="post" action="managePlans" commandName="deletePlans">
						<div id="list-panel"
							style="text-align: left; width: 627px;  border: 1px solid rgb(229, 229, 229);">
							
							<ul style="list-style: none;">
								
								<c:forEach var="plan" items="${traineeInfo.plans}">

									<li>
											
											<input type="checkbox" name="selectedId" value="${plan.planInfo.planInfoId}"/>
											<a href="planDetails?selectedId=${plan.planInfo.planInfoId}">${planInfo.getName()}</a>
											<a href="viewPlan?selectedId=${plan.planInfo.planInfoId}">View</a>
											
									</li>

								
								</c:forEach>
									
							</ul>
							
								<div style="text-align:right;"><button name="planAction" value="deActivatePlans" type="submit">Delete Selected Plans</button></div>
							
							
							
						</div>
						</form:form>
						<div 
							style=" width: 627px;  height: 10px"></div>
								
					Select from Plan Template 
					<div style="text-align: left; width: 627px;  border: 1px solid rgb(229, 229, 229);" >
					
					
						<form:form method="post" action="managePlans" commandName="createPlanFromTemplate">
								<ul style="list-style: none;">
								
								
									
									<li>
									Choose a Template 
											<select name="selectedPlanInfoId" style="width: 200px">
											<c:forEach var="planInfo" items="${coachInfo.planInfos}">
												<c:if test="${planInfo.isActive()}">
													<option value="${planInfo.planInfoId}"/>${planInfo.getName()}</option>
												</c:if>
											</c:forEach>
											</select>
											
											<button name="planAction" value="createPlanFromTemplate" type="submit"> Create Plan from Template</button>
											
									</li>
									
								
								
									
							</ul>
							
							</form:form>	
							

						        
					</div>			
											<div 
							style=" width: 627px;  height: 20px"></div>
							
					Add a New Plan (A plan template will automatically be created)
					<div style="text-align: left; width: 627px;  border: 1px solid rgb(229, 229, 229);" >
								<br>
								
								<form:form method="post" action="managePlans" commandName="createPlanFromNewTemplate" enctype="multipart/form-data">
								
								<ul style="list-style: none;">
								<li>

								
						            
						            Name: <input type="text" name="name"/> 
						            Path: <input type="file" name="file"/> 
						            
						           </li> 
						            <li>
						            <div style="text-align:left; width: 627px;">
						            Description:
						            <br>
						            
						            <textarea name="description" cols="50"></textarea> <button name="planAction" value="createPlanFromNewTemplate" type="submit">Upload</button>
						            </div>
						            </li></ul>
						            
						        </form:form>

					</div>

					</td>
					<td style="width: 19px; height: 19px; text-align: center;"><br>
					</td>
					<td style="text-align: center;"><br></td>
				</tr>
				</tbody>
</table>

