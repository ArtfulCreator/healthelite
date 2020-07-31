<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    
    
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>
	<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>
				<tr>
					<td
						style="vertical-align: top; height: 33px; width: 196px; text-align: center;"><br>
					</td>
					<td
						style="height: 33px; width: 163px; text-align: center; background-color: rgb(238, 238, 238);"><a href="/healthelite/welcome">Home</a><br>
					</td>
					<td
						style="vertical-align: middle; height: 33px; width: 173px; text-align: center; background-color: rgb(238, 238, 238);">Health Elite<br>
					</td>
					<td
						style="vertical-align: middle; height: 33px; width: 159px; text-align: center; background-color: rgb(238, 238, 238);">
										<security:authorize access="isAnonymous()">
											<a
											href="login">Sign In</a> or <a href="register">Register</a>
				
										</security:authorize>
										<security:authorize access="isAuthenticated()">
    										<a href="<c:url value="/j_spring_security_logout" />">
    											<c:if test="${not empty login}">
    												${login.getFirstName()} 
    											</c:if>
    											
    										</a>
										</security:authorize>
										
										<br>
					</td>
					<td style="vertical-align: top; width: 19px; height: 33px;"><br>
					</td>
					<td style="vertical-align: top; width: 216px; height: 33px;"><br>
					</td>
				</tr>