package com.healthElite.servlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import com.healthElite.service.UserManager;

/**
 * RegistrationControllerServlet
 */
public class RegistrationControllerServlet extends HttpServlet {
	

    /**
	 * 
	 */
	private static final long serialVersionUID = 7325722958435486461L;

	/**
     * Default constructor. 
     */
    public RegistrationControllerServlet() {
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String firstName = request.getParameter("firstName");
		String lastName = request.getParameter("lastName");
		String email = request.getParameter("email");
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String role = request.getParameter("role");
		//Default is the Trainee role and don't allow sys admin or other roles
		//coach is 2 and trainee is 3.
		int roleID = 3;
		if(role!=null && role.equals("coach")) {
			roleID = 2;
		}
		try {
			UserManager.register(firstName, lastName, username, password, email, new Integer(roleID).intValue());
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//refactor to direct it to coach or trainee area
		RequestDispatcher dispatcher = getServletContext().getRequestDispatcher("/");
		dispatcher.forward(request, response);


	}
	
	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}
    

}
