<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	String mway = (String)request.getAttribute("mway");
	String totalprice = (String)request.getAttribute("totalprice");	
	int mwayValue = 0;
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>payok</title>
</head>
<body>
<form id="frm" method="post" action="./mallok.do">
<%
if ("무통장 입금".equals(mway)) { 
	mwayValue = 0;
%>
    <p>최종 결제 금액: <%= totalprice %></p><br>
    <p>결제 수단: <%= mway %></p><br>
    <p>계좌번호: 02-1234-56789</p><br>
    <p>입금자명: <input id="mname" type="text" required></p>
	<button type="button" onclick="finish()">결제 완료</button>
<%
} else {
	mwayValue = 1;
%>
    <p>최종 결제 금액: <%= totalprice %></p>
    <p>결제 수단: <%= mway %></p>
    <button type="button" onclick="finish()">결제 완료</button>
<%
}
%> 
</form>
</body>
<script>

function finish() {
    <% if (mwayValue == 0) { %> // 무통장 입금인 경우
        var mname = document.getElementById("mname").value;
        if (mname == "" || mname == null) { //=== 엄격한(Strict) 비교 자료형까지 동일해야 같다고 판단
            alert("입금자명을 입력하세요!");
            return false; // 폼 제출 중지
        }
    <% } %>
    frm.submit();
}

</script>
</html>
