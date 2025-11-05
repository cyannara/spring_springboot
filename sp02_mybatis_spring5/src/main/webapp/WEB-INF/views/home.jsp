<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@taglib uri="http://www.springframework.org/tags" prefix="spring" %>

<html>
<head>
	<title>Home</title>
</head>
<body>
${empVO.firstName } : ${evo.lastName }
<h1>
	Hello world! 
</h1>

<P>  The time on the server is ${serverTime}. </P>
<a href="emp?employeeId=100">100번사원조회</a>
</body>
</html>
