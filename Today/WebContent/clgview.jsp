<%@page import="com.nsep.dom.* , java.util.*;"%> 
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<form>
<%
										ColDtls cd = (ColDtls)request.getAttribute("collegedetails");
										
									
										%>
										<h1 align="center">College Details</h1>
<table align="center" border="2">
										<tr><td>COLLEGE ID</td><td><%=cd.getcId()%></td></tr>
										<tr><td>COLLEGE NAME</td><td><%=cd.getcName() %></td></tr>
										<tr><td>COLLEGE LOCATION</td><td><%=cd.getcLocation() %></td><td>
										
								        <tr><td>SPOC NAME</td><td><%=cd.getCspocName() %></td><td>																					
										<tr><td>SPOC MOBILE</td><td><%=cd.getCmobileNo() %></td><td>	
										
</table>
										
																		
</form>
</body>
</html>