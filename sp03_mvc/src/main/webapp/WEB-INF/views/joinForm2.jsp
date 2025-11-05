<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!-- JSTL (Jakarta 버전) -->
<%@ taglib prefix="c" uri="jakarta.tags.core" %>

<!-- Spring Form 태그 -->
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>

<!-- Spring 일반 태그 -->
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.8/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-sRIl4kxILFvY47J16cr9ZwB07vP4J8+LH7qKQnuqkuIAvNWLzeN8tE5YBujZqJLB"
	crossorigin="anonymous">
<style>
	.error { color:red;}
</style>	
</head>
<body>

	<div class="container">
 		<form:form modelAttribute="member" 
                    action="/join"  method="post">
            <table class="table">
                <tr>
                    <td>Name:</td>
                    <td><input type="text" path="name" /></td>
                    <td class="text-danger"><form:errors path="name" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Email:</td>
                    <td><input type="text" path="email" /></td>
                    <td class="text-danger"><form:errors path="email" cssClass="error"/><br></td>
                </tr>                
                <tr>
                    <td>Age:</td>
                    <td><input type="text" path="age" /></td>
                    <td class="text-danger"><form:errors path="age" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Working:</td>
                    <td><input type="checkbox" path="working" value="true"/></td>
                    <td class="text-danger"><form:errors path="working" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>Phone:</td>
                    <td><input type="text" path="phone" /></td>
                    <td class="text-danger"><form:errors path="phone" cssClass="error"/></td>
                </tr>
                <tr>
                    <td>WorkingDuration:</td>
                    <td><input type="date" path="startdate" /><input type="date" path="enddate" /></td>
                	<td class="text-danger"><form:errors path="endDateAfterStartDate" cssClass="error"/></td>
                </tr>
                <tr>
                    <td colspan="2"><button type="submit">회원가입</button></td>
                </tr>
            </table>
        </form:form>
	</div>
</body>
</html>