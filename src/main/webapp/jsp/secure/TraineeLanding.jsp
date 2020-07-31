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
<title>HealthElite - Welcome</title>
</head>

<body>
	<center>
		<!--div class="menu">
			<ul>
				<li><a href="#">Home</a></li>
				<li><a href="#">Link</a></li>
				<li><a href="#">Link</a></li>
				<li><a href="#">Link</a></li>
				<li><a href="#">Link</a></li>
			</ul>
			<br style="clear: left" />
		</div-->
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
						style="vertical-align: top; height: 20px; width: 163px; text-align: right;"><br>
					</td>
					<td style="vertical-align: top; width: 19px; height: 20px;"><br>
					</td>
					<td style="vertical-align: top; width: 216px; height: 20px;"><br>
					</td>
				</tr>
				<tr>
					<td style="width: 196px; height: 19px; text-align: center;"><br>
					</td>
					<td style="width: 163px; height: 19px; text-align: center;"
						colspan="3" rowspan="1">



						<div style="text-align: center;"></div>

							<table style="text-align: left; width: 627px; height: 314px; border: 1px solid rgb(229, 229, 229);" 
																		cellpadding="2" cellspacing="2" 

																		>
							<tbody>
								<tr>
									<td style="vertical-align: top; width: 385px;">Welcome ${traineeInfo.roles.login.getFirstName()} !<br>
									</td>
								
								</tr>
								<tr>
									<td>
									<ul>
									<li><a href="welcome">Add Coaches</a></li>
									<li>Buy Plans</li>
									<li>Manage Account Information</li>
									</ul>
									</td>
								</tr>

							</tbody>
						</table>
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
						style="vertical-align: top; height: 0px; text-align: right; font-family: monospace;"><font
						size="-1"><br> © Copyright HealthElite, LLC. 2012. All
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

