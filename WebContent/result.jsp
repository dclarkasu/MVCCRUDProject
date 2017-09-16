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
				<li>${student.firstName }</li>
				<li>${student.lastName }</li>
				<li>${student.grade }</li>
			</ul>
		</c:when>
		<c:otherwise>
			<p>No student found</p>
		</c:otherwise>
	</c:choose>
	<jsp:include page="currentList.jsp"></jsp:include>
</body>
</html>