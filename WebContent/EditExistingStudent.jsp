<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<link rel="stylesheet" type="text/css" href="styles.css">
<title>Edit Existing Student</title>
<jsp:include page="navBarPartial.jsp"></jsp:include> 
</head>
<body>
	<h2>Edit Student</h2>
	<!-- <div class="New_Student_Form">-->
	<form action="editedStudent.do" method="POST">
		First Name:
		<input type="text" name="firstName" value="${student.firstName}"/>
		Last Name:
		<input type="text" name="lastName" value="${student.lastName}"/>
		Grade Number:
		<input type="text" name="grade" value="${student.grade}"/>
		<input type="hidden" name="id" value="${student.id}" />
		<input type="submit" value="Edit Student"/>
	</form>
	<!-- </div> -->

</body>
</html>