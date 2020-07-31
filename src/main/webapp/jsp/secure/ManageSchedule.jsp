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
						Active Trainees
						<form:form method="post" action="manageTrainees" commandName="deactivateTrainees">
						<div id="list-panel"
							style="text-align: left; width: 627px;  border: 1px solid rgb(229, 229, 229);">

							<ul style="list-style: none;">
							
								<c:forEach var="association" items="${coachInfo.coachTraineeAssociations}">
									<c:if test="${association.isActive()}">
									<li>
											
											<input type="checkbox" name="selectedId" value="${association.traineeInfo.traineeInfoId}"/>
											<a href="traineeDetails?selectedId=${association.traineeInfo.traineeInfoId}">${association.traineeInfo.roles.login.getLastName()}, ${association.traineeInfo.roles.login.getFirstName()}</a>
											
											
									</li>
									</c:if>
								</c:forEach>

							</ul>
							
							<div style="text-align:right;"><button  name="traineeAction" value="DeActivateTrainees" type="submit">De-Activate Selected Trainees</button></div>

						</div>
						</form:form>
						<div 
							style=" width: 627px;  height: 30px"></div>
						
					Trainee Requests
					
					<form:form method="post" action="manageTrainees" commandName="activateTrainees">
						<div id="list-panel"
							style="text-align: left; width: 627px;  border: 1px solid rgb(229, 229, 229);">

							<ul style="list-style: none;">
							
								<c:forEach var="association" items="${coachInfo.coachTraineeAssociations}">
									<c:if test="${!association.isActive()}">
									<li>

											<input type="checkbox" name="selectedId" value="${association.traineeInfo.traineeInfoId}"/>
											<a href="traineeDetails?selectedId=${association.traineeInfo.traineeInfoId}">${association.traineeInfo.roles.login.getLastName()}, ${association.traineeInfo.roles.login.getFirstName()}</a>
										
									</li>
									</c:if>
								</c:forEach>

							</ul>
							<div style="text-align:right;"><button name="traineeAction" value="ActivateTrainees" type="submit">Activate Selected Trainees</button></div>
						</div>
					</form:form>	
						<div 
							style=" width: 627px;  height: 30px"></div>
	

					</td>
					<td style="width: 19px; height: 19px; text-align: center;"><br>
					</td>
					<td style="text-align: center;"><br></td>
				</tr>
</tbody>
</table>

