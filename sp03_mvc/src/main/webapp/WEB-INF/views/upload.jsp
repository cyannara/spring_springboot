<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
	<form action="/file" enctype="multipart/form-data" method="post">
		<input name="username" type="text">
		<input name="profile" type="file">
		<input name="contract" type="file">
		<button>등록</button>		
	</form> 
</body>
</html>