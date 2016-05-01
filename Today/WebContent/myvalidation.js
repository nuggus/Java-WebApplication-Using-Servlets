//function to validate Radio Buttons

function valButton(btn) 
{
    var cnt = -1;

    for (var i=btn.length-1; i > -1; i--)

 {
     
     if (btn[i].checked) 
      
     {
     
      cnt = i; i = -1;
     
      }
    
 }

    if (cnt > -1) 
 
    return btn[cnt].value;
    
    else return null;
}

//function to validate form


function myvalidation()
{

  //variables
  var count=0;
  var fname=document.forms["form"]["firstname"].value;

  var lname=document.forms["form"]["lastname"].value;
  
  var am=document.forms["form"]["amount"].value;

  var acno=document.forms["form"]["acno"].value;

  var pno=document.forms["form"]["contact"].value;

  var btn = valButton(form.sex);

  var btn1=valButton(form.qualification);

  var citybox=document.getElementById("city").value;
 
  var yearbox=document.getElementById("year").value;

  var ambox=document.getElementById("amount").value;

  var statebox=document.getElementById("state").value;
  var college=document.getElementById("college").value;
  var bankbox=document.getElementById("bank").value;
  var start=document.getElementById("start").value;
  var address=document.form.add.value;
  var x=document.forms["form"]["email"].value;
  var atpos=x.indexOf("@");
  var dotpos=x.lastIndexOf(".");
  

 //end of Variables

if(fname=="" || fname==null || !isNaN(fname))
{
alert("Enter Your Valid First Name!");
count=1;
document.form.firstname.value="";
document.form.firstname.focus();
return false;
}
if(lname=="" || fname==null || !isNaN(lname))
{
	alert("Enter Your Second Name!");
count=1;
document.form.lastname.value="";
document.form.lastname.focus();
return false;
}
if(btn==null)
{
alert("Enter Your Gender!");
count=1;
document.form.sex.unchecked="unchecked";
document.form.sex.focus();
return false;
}
if(address=="" || address.length<20)
{
alert("Enter Your Valid Address,it Should Contain Atleast 20 Characters!");
count=1;
document.form.add.value="";
document.form.add.focus();
return false;
}

if(citybox==0)
{
alert("Please select a City!");
count=1;
document.form.city.value="0";
document.form.city.focus();
return false;
}

if(statebox==0)
{
alert("Please select a State!");
count=1;
document.form.state.value="0";
document.form.state.focus();
return false;
}


if(college==0)
{
alert("Please select a College!");
count=1;
document.form.college.value="0";
document.form.college.focus();
return false;
}
if(pno==null || isNaN(pno) || pno.length!=10)
{
alert("Enter valid phone number");
count=1;
document.form.contact.value="";
document.form.contact.focus();
return false;
}

if (atpos<1 || dotpos<atpos+2 || dotpos+2>=x.length)
{

alert("Not a valid e-mail address");
count=1;
document.form.email.value="";
document.form.email.focus();
return false;
}


if (btn1 == null) 
{
alert('Please Select your qualification');
count=1;
document.form.qualification.value="";
document.form.qualification.focus();
return false;
}

if(yearbox==0)
{
alert("Select Your Year of Graduation!");
count=1;
document.form.year.value="";
document.form.year.focus();
return false;
}
if(ambox==0)
{
alert("Select amount Commited!");
count=1;
document.form.amount.value="";
document.form.amount.focus();
return false;
}
 if(bankbox==0)
{
alert("Select Your Bank!");
count=1;
document.form.bank.value="";
document.form.bank.focus();
return false;
}
 if(acno==null || isNaN(acno) || acno.length !=12)
{
alert("Enter Your Valid Account No!");
count=1;
document.form.acno.value="";
document.form.acno.focus();
return false;
}
 if(start==null || start=="")
{
	alert("enter Starting date");
	count=1;
	document.form.start.value="";
	document.form.start.focus();
	return false;
	}	

if(count==0)
{
	document.form.action="StudentServlet";
    document.form.submit();
}
}

