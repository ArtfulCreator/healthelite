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

public class NormalAccessFilter implements Filter {


	/**
	 * Default constructor.
	 */
	public NormalAccessFilter() {
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

		System.out.println(request);
    	if (request instanceof HttpServletRequest) {
			HttpServletRequest req = (HttpServletRequest) request;
			 String url = req.getRequestURI().substring(req.getContextPath().length());
			 System.out.println("normal filter: "+url);
			 RequestDispatcher dispatcher = filterConfig.getServletContext().getRequestDispatcher(url);
			 dispatcher.forward(request,response);	
		}
		else {
			System.out.println("not a HttpServletRequest. Forwarding to login");
			RequestDispatcher dispatcher = filterConfig.getServletContext().getRequestDispatcher("/login");
			 dispatcher.forward(request,response);
		}

     }

}
