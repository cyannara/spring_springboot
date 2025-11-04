<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html><html><head><title>  </title></head>
<body>

<h3>사원조회</h3>

    <div>사번: ${emp.employeeId} </div>
    <div>이름: ${emp.firstName}  ${emp.lastName} </div>
    <div>입사일자: ${emp.hireDate}</div>
    <div>급여: ${emp.salary}</div>
</body>
</html>