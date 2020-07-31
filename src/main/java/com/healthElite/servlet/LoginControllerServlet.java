package com.healthElite.servlet;

import java.io.IOException;
import java.util.Enumeration;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.healthElite.service.UserManager;

/**
 * Servlet implementation class HealthEliteServlet
 */
public class LoginControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * Default constructor.
	 */
	public LoginControllerServlet() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
			
			HttpSession session = request.getSession(false);
			System.out.println(session);
			Enumeration enumer = session.getAttributeNames();
			while(enumer.hasMoreElements()){
				String name = enumer.nextElement().toString();
				System.out.println("Session Name :" + name +"Session Value: "+session.getAttribute(name));
			}
			
			if(session==null) {
				System.out.println("session was null");
				session = request.getSession(true);
			}
			
			String username = (String) session.getAttribute("username");
			String password = (String) session.getAttribute("password");
			username = request.getParameter("username");
			password = request.getParameter("password");

			session.setAttribute("username", username);
			session.setAttribute("password", password);

			session.setAttribute("password",null);
			session.setAttribute("loggedin", "false");
			String dispatchURL = "/login";
			
			System.out.println("Username: "+username+" Password: "+password);
			
			if (UserManager.checkLogin(username, password)) {
				session.setAttribute("loggedin", "true");
				System.out.println("loggedin");
				dispatchURL = request.getRequestURI();
				if(dispatchURL == null || dispatchURL.equals("/HealthEliteV/loginController")) {
					dispatchURL = "/hv";
				}
				

			} else {
				System.out.println("Loggin failed");
				session.setAttribute("loggedin","false");
				session.invalidate();
				request.setAttribute("message", "Invalid Username or Password");

			}
			
			System.out.println("dispatch: "+dispatchURL);
			
			RequestDispatcher dispatcher = getServletContext().getRequestDispatcher(dispatchURL);
			dispatcher.forward(request, response);


	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		doPost(request, response);
	}

}
