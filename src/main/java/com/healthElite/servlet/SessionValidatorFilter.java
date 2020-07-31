package com.healthElite.servlet;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SessionValidatorFilter implements Filter {


	/**
	 * Default constructor.
	 */
	public SessionValidatorFilter() {
		// TODO Auto-generated constructor stub
	}

	protected FilterConfig filterConfig;

	
    public void init(FilterConfig filterConfig) throws ServletException {
       this.filterConfig = filterConfig;
    }
    public void destroy() {
       this.filterConfig = null;
    }
 
    public void doFilter(ServletRequest request,ServletResponse response, FilterChain chain) throws java.io.IOException, ServletException   {
    	
    	System.out.println("session validator");
    	boolean valid = false;
    	HttpSession session = ((HttpServletRequest)request).getSession(false);
    	if( session!=null) {
    		Object loggedin = session.getAttribute("loggedin");
    		if(loggedin!=null && loggedin.equals("true")){
    			valid = true;
    			
    		}

        }
    	
    	if(valid) { 
    		chain.doFilter(request, response);  
    	}
    	else {
    		
    		System.out.println("session invalid");
    		//session.invalidate();
    		RequestDispatcher dispatcher = filterConfig.getServletContext().getRequestDispatcher("/login");
    		dispatcher.forward(request,response);

    	

    	}
        

     }

}
