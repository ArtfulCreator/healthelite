
<%@ taglib prefix='c' uri='http://java.sun.com/jsp/jstl/core'%>

<%@ page import="org.springframework.security.web.authentication.ui.*"%>
<%@ page
	import="org.springframework.security.core.AuthenticationException"%>
	<%@ taglib prefix="security" uri="http://www.springframework.org/security/tags" %>

<%@ page session="false"%>
<html>
<head>
<LINK REL="StyleSheet" HREF="static/styles.css" TYPE="text/css"
	MEDIA="screen">
</head>
<body>

	<table class="hv-center"
		style="text-align: center; width: 973px; height: 435px;" border="0"
		cellpadding="2" cellspacing="2">
		<tbody>


			<tr>
				<td style="vertical-align: top; height: 42px;"><br></td>
				<td style="vertical-align: top; height: 42px;"><br></td>
				<td style="vertical-align: top; height: 42px;"><br></td>
				<td style="vertical-align: top; height: 42px;"><br></td>
				<td style="vertical-align: top; height: 42px;"><br></td>
				<td style="vertical-align: top; height: 42px;"><br></td>
			</tr>

			<jsp:include page="MenuBar.jsp" />
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

		</tr>
		<tr>
			<form method="post" action="search">
				<td style="vertical-align: top; width: 196px; height: 19px;"><br>
				</td>
				<td colspan="3" rowspan="1"
					style="vertical-align: top; width: 163px; height: 19px;"><br>
					<br>
					<div style="text-align: center; height: 41px;">
						<input style="font-size: 15px; width: 100%;" name="searchString"
							height="32">&nbsp;&nbsp; <br>
					</div>
					
					<div style="text-align: center; margin-top: 0px; height: 35px;">
						<button
							style="font-family: Arial, sans-serif; font-weight: bold; cursor: default; height: 29px; font-size: 11px;"
							type="submit" value="searchPlan" name="searchAction" >Search for a Plan</button>
	
						<button
							style="font-family: Arial, sans-serif; font-weight: bold; cursor: default; height: 29px; font-size: 11px;"
							type="submit" value="searchCoach" name="searchAction">Search for a Coach</button>
					</div> 
			
					<br> <br></td>
	
				<td style="vertical-align: top; width: 19px; height: 19px;"><br>
				</td>
				<td style="vertical-align: top;"><br></td>
			</form>
		</tr>
		<tr>
			<td style="vertical-align: top; height: 146px; width: 196px;"><br>
			</td>
			<td colspan="3" rowspan="1"
				style="vertical-align: top; height: 146px; width: 163px; text-align: right;">

				
				<br>
			</td>
			<td style="vertical-align: top; width: 19px; height: 146px;"><br>
			</td>
			<td style="vertical-align: top; width: 216px; height: 146px;"><br>
			</td>
		</tr>
		<tr>
			<td colspan="1" rowspan="1" style="vertical-align: top; height: 0px;"><br></td>
			<td rowspan="1" colspan="3"
				style="vertical-align: top; height: 0px; text-align: right; font-family: monospace;"><font
				size="-1"><br> (C) Copyright HealthElite, LLC. 2013. All
					rights reserved.<br> </font></td>
			<td colspan="1" style="vertical-align: top; height: 0px;"><br>
			</td>
			<td style="vertical-align: top; height: 0px;"><br></td>
		</tr>
		</tbody>

	</table>
</body>
</html>

