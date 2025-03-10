<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
Integer totalprice = (Integer) request.getAttribute("pr_price");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>상품 세일 할인 값</title>
</head>
<body>
할인된 상품 값 : <%= totalprice %>
</body>
</html>