<%@ page language="java" import="java.io.*,java.sql.*,java.util.*,com.db.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <html>

<head>

<title>Bank Module</title>
  <script type="text/javascript">
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
      
     document.bankform.action="BankServlet";
     document.bankform.submit();


}

   </script>
<link href="default.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="style1.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css">
</head>
  
<body>
<div class="row2">
<h2 align="center">Bank Registration</h2>
<form name="bankform" method="post">
<table border="1" align="center">
<tr>
<td>

   Bank Name:<font color="red"><sub>*</sub></font></td><td>
   <input type="text" size="20" maxlength="15" name="Bname"/></td>

</tr>

<tr>

  <td>
    Branch Location:<font color="red"><sub>*</sub></font></td><td> 
   
     <select name="city" id="city1" onchange="change()">
     <option selected value=0>Select City</option>
  <option value="Banglore">Banglore</option>
  <option value="Bhuvaneshwar">Bhuvaneshwar</option>
  <option value="Chennai">Chennai</option>
  <option value="Delhi">Delhi</option>
 <option value="Hyderabad">Hyderabad</option>
  <option value="Tirupathi">Tirupathi</option>
  <option value="Tiruvananthapuram">Thiruvananthapuram</option>
  <option value="Vijayawada">Vijayawada</option>
  <option value="Vishakapatnam">Vishakapatnam</option>
  <option value="12">Other</option>
  
  </select><input type="text" name="disablebox" id="Textbox1" style="visibility:hidden"/>

  </td>

</tr>

<tr>
  
 <td>SPOC Name:<font color="red"><sub>*</sub></font></td>
 <td>
 <input type="text" size="20" maxlength="15" name="Sname"/></td>

</tr>

<tr>
  <td>SPOC Contact NO:<font color="red"><sub>*</sub></font></td><td>
  <input type="text" size="20" maxlength="15" name="Scontact"/></td>
</tr>

<tr>

 <td>Type Of Accounts Supported:<font color="red"><sub>*</sub></font></td><td>
 <input type="checkbox"  name="actype" value="Savings"/>Savings&nbsp;&nbsp;
 <input type="checkbox"  name="actype" value="Current"/>Current</td>
 
</tr>

<tr><td></td>

 <td><input type="checkbox"  name="actype" value="Salary"/>Salary&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;
 <input type="checkbox"  name="actype" value="Demat"/>Demat</td>

</tr>

<tr><td></td>

 <td><input type="checkbox"  name="actype" value="Recurring"/>Recurring
 <input type="checkbox"  name="actype" value="Fixed"/>Fixed</td>

</tr>

<tr>

  <td> Nationalised:<font color="red"><sub>*</sub></font></td>
   <td>
  <select name="national" id="nat">
  <option value=0>select</option>
  <option value="yes">Yes</option>
  <option value="no">No</option>
  </select>
   </td>
</tr>

<tr>      
 <td><br></br></td>
   <td><input type="button" value="submit" onClick="validatebank()"/> 
 </td>
</tr>
</table>
</form>
</div>
</body>
</html>