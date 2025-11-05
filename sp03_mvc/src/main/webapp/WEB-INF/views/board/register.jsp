<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<h3>게시글등록</h3>
<form method="post"
      action="/board/register">
  제목 <input name="title">
  작성자 <input name="writer">
  내용 <textarea name="content"></textarea>
  <button>등록</button>
</form>
</body>
</html>