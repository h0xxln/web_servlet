<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <title>Shop Bag</title>
    <meta charset="utf-8" />
    <link href="./index.css" rel="stylesheet" />
    <link href="./menu.css?v=1" rel="stylesheet"/>
  </head>
<body>
<!-- 상단 로고 & 메뉴-->
<%@include file="./top.jsp" %> <!-- include에서 .do를 사용할 수 없다. -->
<!-- 상단 로고 & 메뉴 -->
 <main>
 <!-- 베너 -->
<%@include file="./banner.jsp" %>
 <!-- 베너 --> 
 <!-- 신상품 -->
 <%@include file="./product.jsp" %>   
    <!-- 신상품 -->
</main>
<!-- 카피라이터 및 하단 -->
<footer>
 <%@include file="./footer.jsp" %>   
</footer>
<!-- 카피라이터 및 하단 -->
  </body>

</html>