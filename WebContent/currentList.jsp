<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<h2>Current Student List</h2>
	<c:forEach var="student" items="${students}">
		${student.firstName }
		${student.lastName }
		${student.grade }
	</c:forEach>
