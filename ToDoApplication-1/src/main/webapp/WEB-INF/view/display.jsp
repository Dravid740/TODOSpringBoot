<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Insert title here</title>
</head>
<body>
<div align="center">
        <table border="1" cellpadding="5">
            <caption><h2>List of users</h2></caption>
            <tr>
                <th>User ID</th>
                <th>First Name</th>
                <th>LastName</th>
                <th>age</th>
                <th>Email</th>
                <th>Password</th>
                <th>Phone Number</th>
            </tr>
            <c:forEach var="user" items="${s}">
                <tr>
                    <td><c:out value="${ user.getUid()}" /></td>
                    <td><c:out value="${ user.getUfname()}" /></td>
                    <td><c:out value="${ user.getUlname()}" /></td>
                    <td><c:out value="${ user.getUage()}" /></td>
                    <td><c:out value="${ user.getUemail()}" /></td>
                    <td><c:out value="${ user.getUpassword()}" /></td>
                    <td><c:out value="${ user.getUphoneNumber()}" /></td>
                </tr>
            </c:forEach>
        </table>
    </div>
</body>
</html>