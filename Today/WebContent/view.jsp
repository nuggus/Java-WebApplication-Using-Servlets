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
BankDtls bd = (BankDtls)request.getAttribute("bankdetails");		
									
%>
<h1 align="center">Bank Details</h1>
<table align="center" border="1">
										<tr><td>BankId</td><td><%=bd.getBankId()%></td></tr>
										<tr><td>BankName</td><td><%=bd.getBankName()%></td></tr>
										<tr><td>BankLocation</td><td><%=bd.getBankLocation()%></td></tr>
										<tr><td>Nationalized</td><td><%=bd.getBankType()%></td><td>
								        <tr><td>Accounts Offered</td><td><%=bd.getTypeOfAccounts()%></td><td>																					
										<tr><td>SPOC NAME	</td><td><%=bd.getSpocName()%></td><td>	
										<tr><td>SPOC Contact No</td><td><%=bd.getMobileNo()%></td><td>					

</table>
</form>
</body>
</html>