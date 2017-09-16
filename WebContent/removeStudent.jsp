<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta charset="UTF-8">
<title>Student Removal</title>
</head>
<body>
<jsp:include page="navBarPartial.jsp"></jsp:include> 
<h2>Remove a Student</h2>
<form action="RemoveStudent.do" method="POST">
		First Name:
		<input type="text" name="firstName" value=""/>
		Last Name:
		<input type="text" name="lastName" value=""/>
		Grade Number:
		<input type="text" name="grade" value=""/>
		<input type="submit" value="Add Student"/>
</form>
<div action="editStudents.do" method="GET">
<jsp:include page="currentList.jsp"></jsp:include>
</div>
</body>
</html>