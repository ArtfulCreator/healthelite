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
<title>HealthElite - Plan Information</title>
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
				<jsp:include page="/jsp/initial/MenuBar.jsp"/>
				<tr>
					<td style="vertical-align: top; height: 60px;"><br></td>
					<td style="vertical-align: top; height: 60px;"><br></td>
					<td style="vertical-align: top; height: 60px;"><br></td>
					<td style="vertical-align: top; height: 60px;"><br></td>
					<td style="vertical-align: top; height: 60px;"><br></td>
					<td style="vertical-align: top; height: 60px;"><br></td>
				</tr>
				<tr>
					<td style="height: 143px; width: 196px;"><br></td>
					<td colspan="3" rowspan="1"
						style="height: 143px; width: 163px; text-align: center;"><img
						style="width: 216px; height: 40px;" alt="Health Elite"
						src="static/images/HealthEliteLogo.jpg"></td>
					<td style="vertical-align: top; width: 19px; height: 143px;"><br>
					</td>
					<td style="height: 143px;" colspan="1" rowspan="1"><br></td>
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
						<form name="planDetailsForm" method="post", action="planDetails">
							<table
								style="text-align: center; height: 100px; margin-right: auto; width: 516px; margin-left: 0px;"
								cellpadding="2" cellspacing="2">

								<tbody>
									<tr><td> <input type="hidden" name="selectedId"></td></tr>
									<tr style="background-color: #CCCCCC;">
										<td>Plan Name</td>
										<td>Plan Description</td>
										<td>Coach</td>
									</tr>

										<tr name="selectedRow"
											onmouseover="this.className='yellowThing';"
											onMouseOut="this.className='whiteThing';">

											<td><a name="selectedView" href="#"
												onClick="javascript:document.planDetailsForm.selectedId.value='${planInfo.getPlanInfoId().toString()}';document.planDetailsForm.submit();return false;">
													${planInfo.getName()}</a></td>

											<td>${planInfo.getDescription()}</td>
											<td>${planInfo.getCoachInfo().getRoles().getLogin().getFirstName()}</td>
										</tr>

								</tbody>
							</table>
						</form>

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

