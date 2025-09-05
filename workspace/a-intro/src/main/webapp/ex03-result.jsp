<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Ex03 - result</title>
</head>
<body>
    <p><strong>과일 이름:</strong> <%= request.getParameter("fruitName") %></p>
    <p><strong>과일 가격:</strong> <%= request.getParameter("fruitPrice") %>원</p>
    <p><strong>요약 정보:</strong> <%= request.getParameter("fruitInfo") %></p>
</body>
</html>