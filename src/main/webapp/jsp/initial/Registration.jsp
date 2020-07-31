<html>
<head>
<meta content="text/html; charset=ISO-8859-1" http-equiv="content-type">
<title>HealthElite - Registration</title>
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
						src="static/images/HealthEliteLogo.jpg">
					</td>
					<td style="vertical-align: top; width: 19px; height: 143px;"><br>
					</td>
					<td style="height: 143px;" colspan="1" rowspan="1"><br></td>
				</tr>
				<tr>
					<td style="width: 196px; height: 19px; text-align: center;"><br>
					</td>
					<td style="width: 163px; height: 19px; text-align: center;"
						colspan="3" rowspan="1">


						<form method="post" action="initial/registrationController">
							<div style="text-align: center;"></div>
							<table
								style="text-align: left; height: 100px; margin-right: auto; width: 516px; margin-left: 0px;"
								cellpadding="2" cellspacing="2">

								<tbody>
									<tr>
										<td
											style="vertical-align: top; width: 198px; text-align: right;">First
											Name<br>
										</td>
										<td style="vertical-align: top; width: 298px;"><input
											name="firstName"></td>
									</tr>
									<tr>
										<td
											style="vertical-align: top; text-align: right; width: 198px;">Last
											Name<br>
										</td>
										<td style="vertical-align: top; width: 298px;"><input
											name="lastName"></td>
									</tr>
									<tr>
										<td
											style="vertical-align: top; text-align: right; width: 198px;">E-Mail<br>
										</td>
										<td style="vertical-align: top; width: 298px;"><input
											name="email"></td>
									</tr>
									<tr>
										<td
											style="vertical-align: top; width: 198px; text-align: right;">Username</td>
										<td style="vertical-align: top; width: 298px;"><input
											name="username"></td>
									</tr>
									<tr>
										<td
											style="vertical-align: top; width: 198px; text-align: right;">Password</td>
										<td style="vertical-align: top; width: 298px;"><input
											name="password" type="password"></td>
									</tr>
									<tr>
										<td
											style="vertical-align: top; width: 198px; text-align: right;">Register as a Coach ? </td>
										<td style="vertical-align: top; width: 298px;"><input
											name="role" type="checkbox" value="coach"></td>
									</tr>
									<tr>
										<td style="vertical-align: top; width: 198px;"><br>
										</td>
										<td
											style=""vertical-align: top; text-align: right; width: 298px;"">&nbsp;<input
											name="submit" value="submit" type="submit"></td>
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
						style="vertical-align: top; height: 146px; width: 163px; text-align: right;">Already registered? <a href="login">Sign In</a><br>
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

