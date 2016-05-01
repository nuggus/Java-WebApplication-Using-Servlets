<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1" import="com.nsep.dom.* , java.util.*;"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Insert title here</title>
<script type="text/javascript">
  function edit()
  {
	  document.getElementById("cname").disabled=false;
	 
	  document.getElementById("spocname").disabled=false;
	  document.getElementById("spocno").disabled=false;
	  
	
  }
  function collreg()

  {
     
    var cname=document.forms["collegeregform"]["Cname"].value;
    var citybox=document.getElementById("city1").value;
    var sname=document.forms["collegeregform"]["SPOCname"].value;
    var sno=document.forms["collegeregform"]["SPOCcontactno"].value;
    var affil=document.getElementById("aff").value;
    var chks= document.getElementsByName('courses');
    var hasChecked = false;
    var count=0;
    var check;
    var dbox=document.forms["collegeregform"]["disablebox"].value;
   
   

  if(cname=="" || cname==null)
  alert("Enter College Name!");

 
  else if(sname=="" || sname==null || !isNaN(sname))
  alert("Enter Valid SPOC Contact Person Name!");

  else if(sno=="" || sno==null || isNaN(sno))
  alert("Enter Valid SPOC Contact Person Contact No!");
   
  else
	  alert("success");
  
}
  </script>
</head>
<body>
<%
ColDtls cd = (ColDtls)request.getAttribute("college details update");		
									
%>
<div class="row2">
<h2 align="center">College Details</h2>
<form name="collegeregform" method="post" action="CollegeUpdates">
<table border="1" align="center">
<tr>
<td>

   College Id:<font color="red"><sub>*</sub></font></td><td>
   <input type="lable" size="20" maxlength="20" name="cid" id="cid" value='<%=cd.getcId()%>'></input></td>

</tr>
<tr>
<td>

   College Name:<font color="red"><sub>*</sub></font></td><td>
   <input type="text" size="20" maxlength="20" name="Cname" disabled="true" id="cname" value='<%=cd.getcName() %>'/></td>

</tr>



<tr>

   <td>
    SPOC Person Name:<font color="red"><sub>*</sub></font></td><td>
    <input type="text" size="20" maxlength="20" name="SPOCname" disabled="true" id="spocname" value='<%=cd.getCspocName() %>'/>
   </td>
</tr>

<tr>
  <td>
    SPOC Contact No:<font color="red"><sub>*</sub></font></td><td>
    <input type="text" size="20" maxlength="10" name="SPOCcontactno" disabled="true" id="spocno"value='<%=cd.getCmobileNo() %>'/>
   </td>

</tr>



<tr> <td>&nbsp;</td>     
 <td><input type="button" value="EDIT" onClick="edit()"/><input type="submit" value="UPDATE"  /> </td>
</tr>
</table>
</form>
	

</div>
</body>
</html>