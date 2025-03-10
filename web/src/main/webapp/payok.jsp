<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	//getAttribute : Contriller에서 setAttribute로 생성된 값을 이관 받음
	int total = (int)request.getAttribute("total");
	int money = (int)request.getAttribute("product_m");
	int salse = (int)request.getAttribute("product_s");
	int point = (int)request.getAttribute("product_p");
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>결제 진행 사항</title>
</head>
<body>
상품금액 :<%=money%> <br> <%-- 상품금액 :<% out.print(money)%> --%>  
할인율 : <%=salse%><br>
적립금 : <%=point%><br>
최종 결제 금액 : <%=total%> <br>
<input type="button" value="결제하기">
</body>
</html>