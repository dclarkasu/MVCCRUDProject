<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Students</title>
<jsp:include page="navBarPartial.jsp"></jsp:include>
</head>
<body>
	<div class="result">
		<c:choose>
			<c:when test="${! empty student }">
				<!-- <ul> -->
					${student.firstName}, ${student.lastName}<br />
					Grade: ${student.grade }
				<!-- </ul> -->
			</c:when>
			<c:otherwise>
				<p>No student found</p>
			</c:otherwise>
		</c:choose>
		<form action="EditExistingStudent.do" method="POST">
			<input type="hidden" name="id" value="${student.id}" />
			<input type="submit" name="editStudent" value="Edit Student">
		</form>
		<form action="RemoveStudent.do" method="POST">
			<input type="hidden" name="id" value="${student.id}" />
			<input type="submit" name="removeStudent" value="Remove Student">
		</form>
		<jsp:include page="currentList.jsp"></jsp:include>
	</div>
</body>
</html>

<!-- On this page: form with buttons that allow delete and edit -->