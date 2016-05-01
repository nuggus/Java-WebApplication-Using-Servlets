<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.nsep.dom.* , java.util.*;"%>
<html>
<head>
<title>Student Module</title>
<script type="text/javascript">
function edit()
{
	  
	  document.getElementById("firstname").disabled=false;
	  document.getElementById("lastname").disabled=false;
	  document.getElementById("contact").disabled=false;
	  document.getElementById("add").disabled=false;
	  document.getElementById("email").disabled=false;
	 
}
function myvalidation()
{

  //variables

  var fname=document.forms["form"]["firstname"].value;

  var lname=document.forms["form"]["lastname"].value;
  
  
  var pno=document.forms["form"]["contact"].value;
 
  var address=document.form.add.value;

 //end of Variables

if(fname=="" || fname==null || !isNaN(fname))
alert("Enter Your Valid First Name!");

else if(lname=="" || fname==null || !isNaN(lname))
alert("Enter Your Second Name!");


else if(address=="" || address.length<20)
alert("Enter Your Valid Address,it Should Contain Atleast 20 Characters!");


else if(pno==null || isNaN(pno))
alert("Enter valid phone number");



}
</script>
</head>
<body>
<div class="row2">

<h2 align="center">STUDENT REGISTRATION FORM</h2>
<br>
<%
StudentDtls sd = (StudentDtls)request.getAttribute("student details update");		
									
%>
<form name="form" onsubmit="return myvalidation()" method="post" action="StudentUpdates">
<table border="1" align="center">
 
 <tr>  <td> Student ID:<font color="red"><sub>*</sub></font></td>
   <td><input type="text" name="Sid" value='<%=sd.getsId()%>'></input></td>

</tr>
 
<tr>  <td> First name:<font color="red"><sub>*</sub></font></td>
   <td><input type="text" size="20" maxlength="15" name="firstname" disabled="true" id="firstname"  value='<%=sd.getSfName()%>'/></td>

</tr>

<tr>

  <td>
    Last name:<font color="red"><sub>*</sub></font></td><td> 
    <input type="text" size="20" maxlength="15" name="lastname" disabled="true" id="lastname" value='<%=sd.getSlName()%>'/>
  </td>
</tr>



<tr>

 <td>

  Address:<font color="red"><sub>*</sub></font>
 </td>

 <td>
  <textarea rows="3" cols="16" name="add" id="add" value='<%=sd.getsAddress()%>'>
  </textarea>

 </td>

</tr>


<tr>
<td>Contact No<font color="red"><sub>*</sub></font></td><td>
<input type="text" size="20" maxlength="10" name="contact" disabled="true" id="contact" value='<%=sd.getsContact()%>'/></td>
</tr>

<tr>
<td>E-mail:<font color="red"><sub>*</sub></font></td><td>
<input type="text" size="20" maxlength="20" name="email" disabled="true" id="email" value='<%=sd.getsEmail()%>'/></td>
</tr>

<tr>      
 <td>&nbsp</td><td><input type="button" value="EDIT" onClick="edit()"/>&nbsp;
   <input type="submit" value="UPDATE"/>
 </td>
</tr>


</table>
</form>

</div>	
</div>
</div>
</body>
</html>