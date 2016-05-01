<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.nsep.dom.* , java.io.*,java.sql.*,java.util.*,com.db.*,com.nsep.dao.*,java.util.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
</head>


<head>

<title>Bank Module</title>
  <script type="text/javascript">
  function edit()
  {
	  document.getElementById("bname").disabled=false;
	  document.getElementById("bcity").disabled=false;
	  document.getElementById("scontact").disabled=false;
	  document.getElementById("bname").disabled=false;
	  document.getElementById("sname").disabled=false;
	  document.getElementById("nation").disabled=false;
	 
  }
  
   function change()
{
  var citybox2=document.getElementById("city1").value;
  if(citybox2==12)
{
   document.bankform.disablebox.style.visibility="visible";
   alert("Enter City not Mentioned in List");
}

else if(citybox2!=12)
document.bankform.disablebox.style.visibility="hidden";

}
   function validatebank()

  {
  
   var bname=document.forms["bankform"]["Bname"].value;
   var sname=document.forms["bankform"]["Sname"].value;
   var chks = document.getElementsByName('actype');
   var hasChecked = false;
   var citybox1=document.getElementById("city1").value;
   var nbank=document.getElementById("nat").value;
   var scontact=document.forms["bankform"]["Scontact"].value; 
   var check;
   var dbox=document.forms["bankform"]["disablebox"].value;
  
for (var i = 0; i < chks.length; i++)
{
if (chks[i].checked)
{
hasChecked = true;
break;
}
}
if (hasChecked == false)
{
check=1;
} 

if(bname=="" || bname==null || !isNaN(bname))
alert("Enter  Valid Bank Name!");

else if(citybox1==0)
alert("Please select a City!");


else if(sname=="" || sname==null || !isNaN(sname))
alert("Enter Valid SPOC Person Name!");

else if(scontact=="" || scontact==null || isNaN(scontact) )
alert("Enter Valid Phone Number!");

else if(check==1)
alert("Enter account type!");

else if(nbank==0)
alert("Select weather nationalised or not!");

 else if (citybox1==12 && (dbox=="" || dbox==null))
    
            alert("Enter Other City!");
 else
 {  
     alert('Sucess');

 }
}

   </script>


<link href="css/main.css" rel="stylesheet" type="text/css">
</head>
  
<body>
<div class="row2">
<h2 align="center">Bank Registration</h2>


<form name="bankform" onsubmit="return change()" method="post" action="BankUpdates">
<%
BankDtls bd = (BankDtls)request.getAttribute("bankdetailsupdate");		
									
%>
<table border="1" align="center">
<tr>
<td>
   Bank ID:<font color="red"><sub>*</sub></font></td><td>
   <input type="lable" name="Bid" id="bid" value='<%=bd.getBankId()%>'/></td>

</tr>
<tr>
<td>
   Bank Name:<font color="red"><sub>*</sub></font></td><td>
   <input type="text" size="20" maxlength="15" name="Bname" disabled="true" id="bname" value='<%=bd.getBankName()%>'/></td>

</tr>
<br>
<tr>

  <td>
    Branch Location:<font color="red"><sub>*</sub></font></td><td> 
   
     <select name="city" disabled="true" id="bcity" onchange="change()"<%=bd.getBankLocation()%> >
     <option selected value=0>Select City
     <%    Class.forName("oracle.jdbc.driver.OracleDriver");
	     String url="jdbc:oracle:thin:@//172.25.192.71:1521/javadb";
	     String username="H01ORAUSER8D";
	     String password="tcshyd";
	     Connection con=DriverManager.getConnection(url,username,password); 
	     Statement st=con.createStatement();
	     ResultSet rs=st.executeQuery("select * from city");
	    
	     while(rs.next())
	      {
	    	
   %>
    <option value="<%=rs.getString("cname") %>">  <%=rs.getString("cname") %>     </option>	     
   <% } %>
  
  
  </select>
  </td>

</tr>

<tr>
  
 <td>SPOC Name:<font color="red"><sub>*</sub></font><td>
 <input type="text" size="20" maxlength="15" name="Sname" disabled="true" id="sname" value='<%=bd.getSpocName()%>'/></td>

</tr>

<tr>
  <td>SPOC Contact NO:<font color="red"><sub>*</sub></font></td><td>
  <input type="text" size="20" maxlength="15" name="Scontact" disabled="true" id="scontact" value='<%=bd.getMobileNo()%>'/></td>
</tr>
<br>




<tr>

  <td> Nationalised:<font color="red"><sub>*</sub></font></td>
   <td>
  <select name="national"  disabled="true" id="nation" value='<%=bd.getBankType()%>'>
  <option value=0>select
  <option value="yes">Yes</option>
  <option value="no">No</option>
   </td>
</tr>

<tr> <td>&nbsp;</td>     
 <td><input type="button" value="EDIT" onClick="edit()"/><input type="submit" value="submit" /> </td>
   
 
</tr>
</table>
</form>
	

</div>
</body>
</html>


