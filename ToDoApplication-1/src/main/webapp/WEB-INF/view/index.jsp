<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>


<form action="details"  method="post" modelAttribute="user">
  <label for="ufname">First Name:</label><br>
  <input type="text" id="ufname" name="ufname" ><br>
  <label for="ulname">Last Name:</label><br>
  <input type="text" id="ulname" name="ulname" ><br>
  <label for="age">Age:</label><br>
  <input type="text" id="age" name="uage" ><br><br>
  <label for="email">Email:</label><br>
  <input type="text" id="email" name="uemail"><br><br>
  <label for="passwd">Password:</label><br>
  <input type="text" id="passwd" name="upassword"><br><br>
   <label for="phn_no">Phone Number:</label><br>
  <input type="text" id="phn_no" name="uphoneNumber"><br><br>
  <input type="submit" value="Submit">
</form> 


</body>
</html>