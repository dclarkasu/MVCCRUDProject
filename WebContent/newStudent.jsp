<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Add Student</title>
<jsp:include page="navBarPartial.jsp"></jsp:include> 
</head>
<body>
	<h2>Add a Student</h2>
	<div class="New_Student_Form"></div>
	<form action="NewStudent.do" method="POST">
		First Name:
		<input type="text" name="firstName" value=""/>
		Last Name:
		<input type="text" name="lastName" value=""/>
		Grade Number:
		<input type="text" name="grade" value=""/>
		<input type="submit" value="Add Student"/>
	</form>
	</div>

</body>
</html>