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
										StudentDtls sd = (StudentDtls)request.getAttribute("studentdetails");
										
									
										%>
										<h2 align="center">STUDENT DETAILS </h2>
										<table align="center" border="1" bordercolor="black">
										<tr><td>StudentId</td><td><%= sd.getsId()%></td></tr>
										<tr><td>FirstName</td><td><%=sd.getSfName()%></td></tr>
										<tr><td>SecondName</td><td><%=sd.getSlName()%></td></tr>
										<tr><td>ADDRESS</td><td><%=sd.getsAddress()%></td></tr>	
										<tr><td>City</td><td><%=sd.getsCity()%></td></tr>						
                                        <tr><td>Contact No</td><td><%=sd.getsContact() %></td></tr>   
                                        <tr><td>Year of Graduation</td><td><%=sd.getsYear() %></td></tr>
                                        <tr><td>Commited Amount</td><td><%=sd.getsCamt() %></td></tr>
                                        <tr><td>Bank Name</td><td><%=sd.getsBname() %></td></tr>
                                        <tr><td>Acc NO</td><td><%=sd.getsAcno() %></td></tr>
                                        <tr><td>Start Date</td><td><%=sd.getsStart() %></td></tr>
                                        

</table>
</form>
</body>
</html>