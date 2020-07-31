package com.healthElite.service;


import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.healthElite.service.db.DatabaseManager;



public class UserManager implements UserDetailsService{
	
	
	
	/**
	 * @deprecated. Use Spring Security below.
	 * @param username
	 * @param password
	 * @return
	 */
	public static boolean checkLogin (String username, String password) {
		
		DatabaseManager dm = new DatabaseManager();
		ResultSet results;
		
		results = (ResultSet)dm.runSQL("SELECT PASSWORD FROM LOGIN where USER_NAME="+
				        		   		"'"+username+"'");

         try {
			while(results.next()){
				 if(results.getString("PASSWORD").equals(password)){
					 return true;
				 }
			 }
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         
        dm.close();

		return false;
	}
	
	public static boolean register (String firstName, String lastName, String username, String password, String email, int roleID) throws Exception{
		System.out.println("here");
		DatabaseManager dm = new DatabaseManager ();
	
		String sql = "INSERT into LOGIN (USER_NAME, PASSWORD, FIRST_NAME, LAST_NAME, EMAIL) VALUES " + "(?,?,?,?,?)";
		String selectLoginSQL = "SELECT LOGIN_ID from LOGIN WHERE USER_NAME = '"+username+"'";
		String roleSql = "INSERT into ROLES (LOGIN_ID, ROLE_ID) VALUES " +"(?,?)";
		
		System.out.println(sql);
		Object [] values = {username, password, firstName, lastName, email};
		dm.runSQL(sql, values);
		
		dm.runSQL(selectLoginSQL);
		Object obj = dm.runSQL(selectLoginSQL);
		
		int loginID = 0;
		if(obj!=null) {
			
			ResultSet results = (ResultSet) obj;
			results.next();
			loginID = results.getInt("LOGIN_ID");
		}
		
		Object [] roleValues = new Object [] {new Integer(loginID), new Integer(roleID)};
		dm.runSQL(roleSql, roleValues );
		dm.close();
		return false;
		
	}


	public UserDetails loadUserByUsername(String username)
			throws UsernameNotFoundException {
		
		DatabaseManager dm = new DatabaseManager();
		User user = null;
		String sql = "SELECT LOGIN_ID, PASSWORD FROM LOGIN where USER_NAME="+"'"+username+"'";
		String roleSql = "SELECT ROLE_DESCRIPTION_ID FROM ROLES WHERE LOGIN_ID=";
		
		
		Object res = (ResultSet)dm.runSQL(sql);
		 System.out.println("here");
		if(res instanceof ResultSet) {
			
			ResultSet results = (ResultSet) res;
		
			try {
				while(results.next()){
					 //get roles
					 roleSql = roleSql+results.getInt("LOGIN_ID");
					 Object roleRes = dm.runSQL(roleSql);
					 if(roleRes instanceof ResultSet) {
						 ResultSet roleResults = (ResultSet)roleRes;
						 
						 List<GrantedAuthority> authList = new ArrayList<GrantedAuthority>();
						 while(roleResults.next()) {
							 authList.add (new SimpleGrantedAuthority(""+roleResults.getInt("ROLE_DESCRIPTION_ID")));
						 }
						
						 return new User(username, results.getString("PASSWORD"), true, true, true, true,authList);
					 }
					 
				 }
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		}
         
        dm.close();
		return user;
        
       
        
	}
	

}
