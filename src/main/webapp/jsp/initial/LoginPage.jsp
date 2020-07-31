
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<%@ page import="org.springframework.security.web.authentication.ui.*"%>
<%@ page
	import="org.springframework.security.core.AuthenticationException"%>

<%@ page session="false"%>
<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>HealthElite - Login</title>
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
					<td style="width: 196px; height: 19px; text-align: center;"><br>
					</td>
					<td style="width: 163px; height: 19px; text-align: center;"
						colspan="3" rowspan="1">


						<form method="post"
							action="<c:url value='j_spring_security_check'/>">

							<table
								style="text-align: left; width: 151px; height: 100px; margin-left: auto; margin-right: auto;"
								cellpadding="2" cellspacing="2">
								<tbody>
									<tr>
										<td style="vertical-align: top; width: 48px;">Username</td>
										<td style="vertical-align: top; width: 230px;"><input
											type='text' name='j_username'
											value='<c:if test="${not empty param.login_error}"><c:out value="${SPRING_SECURITY_LAST_USERNAME}"/></c:if>' /></td>
									</tr>
									<tr>
										<td style="vertical-align: top; width: 48px;">Password</td>
										<td style="vertical-align: top; width: 230px;"><input
											type='password' name='j_password'></td>
									</tr>
									<tr>
										<td style="vertical-align: top; width: 48px;"><br></td>
										<td
											style="vertical-align: top; text-align: right; width: 230px;">&nbsp;<input
											name="submit" value="submit" type="submit"></td>
									</tr>
									<tr>

										<td colspan="2" style="text-align: right;"><c:if
												test="${not empty param.login_error}">
												<font color="red"> The username or password you
													entered seems incorrect. </font>
											</c:if></td>

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
					<td
						style="vertical-align: top; height: 146px; width: 196px; text-align: right;">

					</td>
					<td colspan="3" rowspan="1"
						style="vertical-align: top; height: 146px; width: 163px; text-align: right;">Don't
						have a login? <a href="register">Register</a><br>
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

