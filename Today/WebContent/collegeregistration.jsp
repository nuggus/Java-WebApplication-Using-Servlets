<%@ page language="java" import="java.io.*,java.sql.*,java.util.*,com.db.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<html>
<head>

<title>College Module</title>
<script type="text/javascript">

 function change()
{
  var citybox2=document.getElementById("city1").value;
  if(citybox2==12)
{
   document.collegeregform.disablebox.style.visibility="visible";
   alert("Enter City not Mentioned in List");
}

else if(citybox2!=12)
document.collegeregform.disablebox.style.visibility="hidden";

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
       var code=document.forms["collegeregform"]["code"].value;
       var c=0;
       for (var i = 0; i < chks.length; i++)
    {
        
        if (chks[i].checked)
     {
       hasChecked =true;
       count++;
      }
              
      }
  
     if(cname=="" || cname==null)
     {
     alert("Enter College Name!");
     c=1;
     document.collegeregform.Cname.value="";
     document.collegeregform.Cname.focus();
     return false;
     }

     if(code=="" || code==null)
     {
         alert("Enter VALID COLLEGE CODE");
         c=1;
         document.collegeregform.code.value="";
         document.collegeregform.code.focus();
         return false;
         }
     
     if(citybox==0)
     {
     alert("Enter City!");
     c=1;
     document.collegeregform.city1.value="0";
     document.collegeregform.city1.focus();
     return false;
     }
    
     if(sname=="" || sname==null || !isNaN(sname))
     {
     alert("Enter Valid SPOC Contact Person Name!");
     c=1;
     document.collegeregform.SPOCname.value="";
     document.collegeregform.SPOCname.focus();
     return false;
     }
  
     if(sno=="" || sno==null || isNaN(sno) || sno.length !=10)
     {
     alert("Enter Valid SPOC Contact Person Contact No!");
     c=1;
     document.collegeregform.SPOCcontactno.value="";
     document.collegeregform.SPOCcontactno.focus();
     return false;
     }
     
      if(affil==0)
      {
     alert("Enter Affiliation Status!");
     c=1;
     document.collegeregform.aff.value="0";
     document.collegeregform.aff.focus();
     return false;
     }
  
      
  
      if(affil==1 && count<10)
      {
       alert("Select Atleast 10Courses"); 
       c=1;
       return false; 
      }
  
      if(affil==2 && count<5)
      {
          c=1;
          alert("Select Atleast 5 Courses"); 
         
        return false;
      }
   
     
     if(c==0)
     {
         alert("hi");
    	 document.collegeregform.action="CollegeServlet";
         document.collegeregform.submit(); 
     }
}
   
      </script>
<link href="default.css" rel="stylesheet" type="text/css" />
<link href="css/main.css" rel="stylesheet" type="text/css" />
<link href="style1.css" rel="stylesheet" type="text/css" />
</head>
<body>

  

<div class="row2">
<h2 align="center">College Registration</h2>
<form name="collegeregform" onsubmit="return collreg()" method="post" >
<table border="1" align="center">
<tr>
<td>

   College Name:<font color="red"><sub>*</sub></font></td><td>
   <input type="text" size="20" maxlength="20" name="Cname"/></td>

</tr>
<tr>

   <td>
    College Code<font color="red"><sub>*</sub></font></td><td>
    <input type="text" size="20" maxlength="20" name="code"/>
   </td>
</tr>
<tr>

  <td>
    College Location:<font color="red"><sub>*</sub></font></td><td> 
   
     <select name="city" id="city1" onchange="change()">
  <option value=0>Select City</option>
  <%    Class.forName("oracle.jdbc.driver.OracleDriver");
	     String url="jdbc:oracle:thin:@//172.25.192.71:1521/javadb";
	     String username="H01ORAUSER8D";
	     String password="tcshyd";
	     Connection con=DriverManager.getConnection(url,username,password); 
	     Statement st=con.createStatement();
	     ResultSet rs=st.executeQuery("select * from CITY");
	    
	     while(rs.next())
	      {
	    	
   %>
    <option value="<%=rs.getString("cname") %>">  <%=rs.getString("cname") %>     </option>	     
   <% } %>
  
  </select><input type="text" name="disablebox" id="Textbox1" style="visibility:hidden"/>

  </td>

</tr>

<tr>

   <td>
    SPOC Person Name:<font color="red"><sub>*</sub></font></td><td>
    <input type="text" size="20" maxlength="20" name="SPOCname"/>
   </td>
</tr>

<tr>
  <td>
    SPOC Contact No:<font color="red"><sub>*</sub></font></td><td>
    <input type="text" size="20" maxlength="10" name="SPOCcontactno"/>
   </td>

</tr>

<tr>

  <td> Affiliated:<font color="red"><sub>*</sub></font></td>
  <td>
  <select name="affiliated" id="aff">
  <option value=0>Select</option>
  <option value="1">Yes</option>
  <option value="2">no</option>
  </select>

</td>
</tr>
<tr>
<td>Select Courses :<font color="red"><sub>*</sub></font></td>
<td><input type="checkbox" name="courses" value="Course01"/>Course01<input type="checkbox" name="courses" value="Course02"/>Course02<br>
      <input type="checkbox" name="courses" value="Course03"/>Course03<input type="checkbox" name="courses" value="Course04"/>Course04<br>
      <input type="checkbox" name="courses" value="Course05"/>Course05<input type="checkbox" name="courses" value="Course06"/>Course06<br>
       <input type="checkbox" name="courses" value="Course07"/>Course07<input type="checkbox" name="courses" value="Course08"/>Course08<br>
      <input type="checkbox" name="courses" value="Course09"/>Course09<input type="checkbox" name="courses" value="Course10"/>Course10<br>
      <input type="checkbox" name="courses" value="Course11"/>Course11<input type="checkbox" name="courses" value="Course12"/>Course12<br>
      <input type="checkbox" name="courses" value="Course13"/>Course13<input type="checkbox" name="courses" value="Course14"/>Course14<br>
      <input type="checkbox" name="courses" value="Course15"/>Course15<input type="checkbox" name="courses" value="Course16"/>Course16<br>
      <input type="checkbox" name="courses" value="Course17"/>Course17<input type="checkbox" name="courses" value="Course18"/>Course18<br>
     <input type="checkbox" name="courses" value="Course19"/>Course19<input type="checkbox" name="courses" value="Course20"/>Course20<br>
</td>
</tr>
<tr>      
 <td><br></br></td>
   <td><input type="submit" value="REGISTER" >
 </td>
</tr>
</table>
</form>
	

</div>
</body>
</html>