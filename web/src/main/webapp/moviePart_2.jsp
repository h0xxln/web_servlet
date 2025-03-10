<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	ArrayList<String> al = (ArrayList<String>)request.getAttribute("al");
	String mname = al.get(0);
	String mtel = al.get(1);
	String movie = al.get(2);
	String moviedate = al.get(3);

	/*
	String mname = (String)request.getAttribute("mname");
	String mtel = (String)request.getAttribute("mtel");
	String movie = (String)request.getAttribute("movie");
	String moviedate = (String)request.getAttribute("moviedate");
	*/
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>영화 예매 확인</title>
</head>
<body>
<form id="frm" method="post" action="./moviePart_3.do">
영화 예매 확인<br><br>
고객명 : <%=mname%><br><br>
연락처 : <%=mtel%><br><br>
영화선택 : <%=movie%><br><br>
예매일자 : <%=moviedate%><br><br>
<input type="button" value="확인" onclick="check()">
</form>
</body>
<script>
function check() {
frm.submit();	
}
</script>
</html>