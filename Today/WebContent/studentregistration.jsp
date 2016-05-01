<%@ page language="java" import="java.io.*,java.sql.*,java.util.*,com.db.*" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <html>
<head>

<title>Student Module</title>



<script type="text/javascript" src="myvalidation.js">
</script>
</head>


<body>
<div class="row2">

<h2 align="center">STUDENT REGISTRATION FORM</h2>
<br>
  <form name="form" onsubmit="return myvalidation()" method="post">

<table border="1" align="center">
<tr>
<td>
   First name:<font color="red"><sub>*</sub></font></td><td><input type="text" size="20" maxlength="15" name="firstname"/></td>

</tr>

<tr>

  <td>
    Last name:<font color="red"><sub>*</sub></font></td><td> <input type="text" size="20" maxlength="15" name="lastname" />
  </td>
</tr>

<tr>

  <td> Gender:<font color="red"><sub>*</sub></font></td><td><input type="radio" name="sex" value="male" id="s1" checked/>Male<input type="radio" name="sex" value="female" id="s2"/> Female</td>
</tr>

<tr>

 <td>

  Address:<font color="red"><sub>*</sub></font>
 </td>

 <td>
  <textarea rows="3" cols="16" name="add">
  </textarea>

 </td>

</tr>

<tr>

 <td>

  City:<font color="red"><sub>*</sub></font>
 
 </td>

 <td>

  <select name="city" id="city" size="1">
  <option selected value="0">Select your City</option>
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
  
  
</select>
</td>
</tr>
<tr>

 <td>

  State:<font color="red"><sub>*</sub></font>
 
 </td>

 <td>

  <select name="state" id="state">
 <option selected value="0">- - - Select your State- - -</option>
   <%  
       
        ResultSet rs1=st.executeQuery("select * from STATE");
	    
	     while(rs1.next())
	      {
	    	
   %>
    <option value="<%=rs1.getString("sname") %>">  <%=rs1.getString("sname") %>     </option>	     
   <% } %>
  </select>
</tr>
<tr>

 <td>

  College Name:<font color="red"><sub>*</sub></font>
 
 </td>

 <td>

  <select name="college" id="college" size="1">
  <option selected value="0">Select your College</option>
  <%    
	     
	     ResultSet rs3=st.executeQuery("select * from clg_dtls");
	    
	     while(rs3.next())
	      {
	    	
   %>
    <option value="<%=rs3.getString("cname") %>">  <%=rs3.getString("cname") %>     </option>	     
   <% } %>
  
  
</select>
</td>
</tr>
<tr>
<td>Contact No<font color="red"><sub>*</sub></font></td><td><input type="text" size="20" maxlength="10" name="contact"/></td>
</tr>

<tr>
<td>E-mail:<font color="red"><sub>*</sub></font></td><td><input type="text" size="20" maxlength="50" name="email"/></td>
</tr>

<tr>
  <td>Qualification:<font color="red"><sub>*</sub></font></td><td><input type="radio" name="qualification" value="UGraduation" checked/>UG<input type="radio" name="qualification" value="Graduation" />Graduation</td>

 </tr>
<tr>

 <td>

  Year Of Graduation:<font color="red"><sub>*</sub></font>
 
 </td>

 <td>

  <select name="year" id="year">
 <option selected>Select year</option>
  <option value="I">I</option>
  <option value="II">II</option>
  <option value="III">III</option>
  
   </select>
</tr>

<tr>

  <td>Committed amount:<font color="red"><sub>*</sub></font></td>

  <td><select name="amount" id="amount">
 <option selected>Select amount</option>
  <option value="1000">1000</option>
  <option value="2000">2000</option>
  <option value="3000">3000</option>
   <option value="4000">4000</option>
  <option value="5000">5000</option>
  
   </select>
   </td>
</tr>
<tr>
<td>Bank Name:<font color="red"><sub>*</sub></font></td><td>
<select name="bank" id="bank">
 <option selected>Select your Bank</option>
  <%  
       
        ResultSet rs2=st.executeQuery("select * from bank_details");
	    
	     while(rs2.next())
	      {
	    	
   %>
    <option value="<%=rs2.getString("BANK_NAME") %>">  <%=rs1.getString("BANK_NAME") %>     </option>	     
   <% } %>
  
   </select>
</tr>

<tr>

  <td>Account Number:<font color="red"><sub>*</sub></font></td><td><input type="text" size="20" maxlength="12" name="acno"/></td>
</tr>
<tr>

  <td>Start Date:<font color="red"><sub>*</sub></font></td><td><input type="text" size="20" maxlength="12" name="start" id="start"/></td>
</tr>

<tr>      
 <td><br></br></td><td>
   <input type="submit" value="Submit"/>
 </td>
</tr>
</table>
</form>




</div>	

</body>
</html>