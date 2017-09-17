<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Students</title>
</head>
<body>
<jsp:include page="navBarPartial.jsp"></jsp:include>
	<c:choose>
		<c:when test="${! empty student }">
			<ul>
				<li>${student.firstName}, ${student.lastName} </li>
				<li>Grade: ${student.grade }</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No student found</p>
		</c:otherwise>
	</c:choose>
	<form action="EditExistingStudent.do" method="POST">
		<input type="submit" name="editStudent" value="Edit Student">
		<input type="submit" name="editStudent" value="Remove Student">
		<%-- <input type=“hidden” value="${student.id}" /> --%>
	</form>
	<jsp:include page="currentList.jsp"></jsp:include>
</body>
</html>

<!-- On this page: form with buttons that allow delete and edit -->