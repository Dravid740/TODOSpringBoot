<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<h1>Update Form</h1>
<form action="detail"  method="post" modelAttribute="user">
<label for="uid">User Id:</label><br>
  <input type="text" id="uid" name="uid" value="${ user.getUid()}" ><br>
  <label for="ufname">First Name:</label><br>
  <input type="text" id="ufname" name="ufname" value="${ user.getUfname()}" ><br>
  <label for="ulname">Last Name:</label><br>
  <input type="text" id="ulname" name="ulname" value="${ user.getUlname()}" ><br>
  <label for="age">Age:</label><br>
  <input type="text" id="age" name="uage" value="${ user.getUage()}" ><br><br>
  <label for="email">Email:</label><br>
  <input type="text" id="email" name="uemail" value="${ user.getUemail()}" ><br><br>
  <label for="passwd">Password:</label><br>
  <input type="text" id="passwd" name="upassword" value="${ user.getUpassword()}" ><br><br>
   <label for="phn_no">Phone Number:</label><br>
  <input type="text" id="phn_no" name="uphoneNumber" value="${ user.getUphoneNumber()}" ><br><br>
  <input type="submit" value="Submit">
</form> 
</body>
</html>
