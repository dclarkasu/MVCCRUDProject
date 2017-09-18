<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!-- page should be rendered obsolete once "Remove" button sends data via url to remove method
Will send to jsp that says ""Student removed" and has nav bar -->

<!DOCTYPE html>
<html>
<head>
<link rel="stylesheet" type="text/css" href="styles.css">
<meta charset="UTF-8">
<title>Student Removal</title>
</head>
<body>
<jsp:include page="navBarPartial.jsp"></jsp:include> 
<h2>Student Removed</h2>
<h2>Current List of Students</h2>
<jsp:include page="currentList.jsp"></jsp:include>

</body>
</html>