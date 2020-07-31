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
						Active Plan Templates
						<form:form method="post" action="managePlanTemplates" commandName="deactivatePlanTemplates">
						<div id="list-panel"
							style="text-align: left; width: 627px;  border: 1px solid rgb(229, 229, 229);">
							
							<ul style="list-style: none;">
								
								<c:forEach var="planInfo" items="${coachInfo.planInfos}">
									<c:if test="${planInfo.isActive()}">
									<li>
											
											<input type="checkbox" name="selectedId" value="${planInfo.planInfoId}"/>
											<a href="planTemplateDetails?selectedId=${planInfo.planInfoId}">${planInfo.getName()}</a>
											<a href="viewPlanTemplate?selectedId=${planInfo.planInfoId}">View</a>
											
									</li>
									</c:if>
								
								</c:forEach>
									
							</ul>
							
								<div style="text-align:right;"><button name="planTemplateAction" value="deActivatePlanTemplates" type="submit">De-Activate Selected Plans</button></div>
							
							
							
						</div>
						</form:form>
						<div 
							style=" width: 627px;  height: 10px"></div>
						
					Inactive Plan Templates
					
					<form:form method="post" action="managePlanTemplates" name="activatePlanTemplates">
						<div id="list-panel"
							style="text-align: left; width: 627px;  border: 1px solid rgb(229, 229, 229);">

							<ul style="list-style: none;">
							
								<c:forEach var="planInfo" items="${coachInfo.planInfos}">
									<c:if test="${!planInfo.isActive()}">
									<li>
											
											<input type="checkbox" name="selectedId" value="${planInfo.planInfoId}"/>
											<a href="planTemplateDetails?selectedId=${planInfo.planInfoId}">${planInfo.getName()}</a>
											<a href="viewPlanTemplate?selectedId=${planInfo.planInfoId}">View</a>
											
									</li>
									</c:if>
								</c:forEach>

							</ul>
							<div style="text-align:right;">
							<button name="planTemplateAction" value="deletePlanTemplates" type="submit">Delete Selected Plan Templates</button>
							<button name="planTemplateAction" value="activatePlanTemplates" type="submit">Activate Selected Plan Templates</button></div>
						
						</div>
					</form:form>	
						<div 
							style=" width: 627px;  height: 10px"></div>
	
					Upload a Plan Template
					<div style="text-align: left; width: 627px;  border: 1px solid rgb(229, 229, 229);" >
								<br>
								<ul style="list-style: none;">
								<li>

								<form method="post" action="uploadPlanTemplate" enctype="multipart/form-data">
						            Name: <input type="text" name="name"/> 
						            Path: <input type="file" name="file"/> 
						            
						           </li> 
						            <li>
						            <div style="text-align:left; width: 627px;">
						            Description:
						            <br>
						            
						            <textarea name="description" cols="50"></textarea> <input type="submit" value="Upload"/>
						            </div>
						            </li></ul>
						        </form>

						        
					</div>

					</td>
					<td style="width: 19px; height: 19px; text-align: center;"><br>
					</td>
					<td style="text-align: center;"><br></td>
				</tr>
				</tbody>
</table>

