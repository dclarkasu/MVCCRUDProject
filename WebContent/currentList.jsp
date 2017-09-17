<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<link rel="stylesheet" type="text/css" href="styles.css">
<h2>Current Student List</h2>
	<c:forEach var="student" items="${students}">
		<a href="findStudent.do?id=${student.id}"> ${student.firstName }
		${student.lastName }
		<%-- ${student.grade } --%>
		</a>
		<br />
	</c:forEach>
