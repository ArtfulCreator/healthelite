<%@ page language="java"
	import="com.healthElite.servlet.*,
									com.healthElite.model.*, 
									java.util.*,com.healthElite.service.*,
									org.springframework.web.context.*,
									org.springframework.web.context.support.WebApplicationContextUtils"
	contentType="text/html; charset=ISO-8859-1" pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<link rel="stylesheet" href="http://localhost:8080/healthelite/static/styles.css" type="text/css"/>
<title>HealthElite - Welcome Coach</title>
<script src="static/tabs.js"></script>
</head>

<body>
	<center>

		<table style="text-align: left; width: 973px; height: 435px;"
			border="0" cellpadding="2" cellspacing="2">
			<tbody>
				<tr>
					<td style="vertical-align: top; height: 42px;"><br></td>
					<td style="vertical-align: top; height: 42px;"><br></td>
					<td style="vertical-align: top; height: 42px;"><br></td>
					<td style="vertical-align: top; height: 42px;"><br></td>
					<td style="vertical-align: top; height: 42px;"><br></td>
					<td style="vertical-align: top; height: 42px;"><br></td>
				</tr>
				<jsp:include page="../initial/MenuBar.jsp"/>
				<tr>
					<td style="vertical-align: top; height: 60px;"><br></td>
					<td style="vertical-align: top; height: 60px;"><br></td>
					<td style="vertical-align: top; height: 60px;"><br></td>
					<td style="vertical-align: top; height: 60px;"><br></td>
					<td style="vertical-align: top; height: 60px;"><br></td>
					<td style="vertical-align: top; height: 60px;"><br></td>
				</tr>
				
				<tr>
					<td style="vertical-align: top; height: 20px; width: 196px;"><br>
					</td>
					<td colspan="3" rowspan="1"
						style="vertical-align: top; height: 20px; width: 163px; text-align:left;">Welcome Coach ${coachInfo.roles.login.getFirstName()} !<br>
					</td>
					<td style="vertical-align: top; width: 19px; height: 20px;"><br>
					</td>
					<td style="vertical-align: top; width: 216px; height: 20px;"><br>
					</td>
				</tr>
				<tr>
					<td style="width: 196px; height: 19px; text-align: center;">
					</td>
					<td style="width: 163px; height: 19px; text-align: center;"
						colspan="3" rowspan="1">

						<div style="text-align: center;"></div>
						<div id="tabContainer">
							<div class="tabs">
											<ul style="list-style:none outside none;" >
												<li id="tabHeader_1" value="${traineeTab}">Trainees</li>
												<li id="tabHeader_2" value="${planTemplatesTab}">Plan Templates</li>
												<li id="tabHeader_3" value="inactive">Account</li>
											</ul>
							</div>
							<table style="text-align: left; width: 627px; height: 314px; border: 1px solid rgb(229, 229, 229);" 
																		cellpadding="2" cellspacing="2" 
												>
							<tbody>
								
								
								<tr>
									<td>
										<!-- tab "panes" -->
										<div class="tabscontent">
											<div class="tabpage" id="tabpage_1"><jsp:include page="ManageTrainees.jsp"/></div>
											<div class="tabpage" id="tabpage_2"><jsp:include page="ManagePlanTemplates.jsp"/></div>
											<div class="tabpage" id="tabpage_3">Account</div>
										</div>
									</td>
								</tr>

							</tbody>
						</table>
						</div>
					</td>
					<td style="width: 19px; height: 19px; text-align: center;"><br>
					</td>
					<td style="text-align: center;"><br></td>
				</tr>
				<tr>
					<td style="vertical-align: top; height: 146px; width: 196px;"><br>
						<%
							Object message = request.getAttribute("message");
							if (message != null) {
								out.println(message);
							}
						%></td>
					<td colspan="3" rowspan="1"
						style="vertical-align: top; height: 146px; width: 163px; text-align: right;">
					</td>
					<td style="vertical-align: top; width: 19px; height: 146px;"><br>
					</td>
					<td style="vertical-align: top; width: 216px; height: 146px;"><br>
					</td>
				</tr>
				<tr>
					<td colspan="1" rowspan="1"
						style="vertical-align: top; height: 0px;"><br></td>
					<td rowspan="1" colspan="3"
						style="vertical-align: top; height: 0px; text-align: center; font-family: monospace;"><font
						size="-1"><br> © Copyright HealthElite, LLC. 2013. All
							rights reserved.<br> </font></td>
					<td colspan="1" style="vertical-align: top; height: 0px;"><br>
					</td>
					<td style="vertical-align: top; height: 0px;"><br></td>
				</tr>
			</tbody>
		</table>
		<br> <br>
	</center>
</body>
</html>

