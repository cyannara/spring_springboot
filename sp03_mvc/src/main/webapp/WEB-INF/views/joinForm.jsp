<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<html>
<head>
    <title>회원가입</title>
    <style>
        .error { color: red; font-size: 0.9em; }
    </style>
</head>
<body>
    <h2>회원가입 폼</h2>

    <form:form modelAttribute="member" 
               action="/join" method="post">
        <p>
            이름: <form:input path="name" />
            <form:errors path="name" cssClass="error" />
        </p>

        <p>
            이메일: <form:input path="email" />
            <form:errors path="email" cssClass="error" />
        </p>
        <input type="submit" value="회원가입" />
    </form:form>
</body>
</html>
