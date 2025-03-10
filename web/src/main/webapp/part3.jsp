<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
String mid = (String)request.getAttribute("mid");
String mname = (String)request.getAttribute("mname");
String mmail = (String)request.getAttribute("mmail");
String mnumber = (String)request.getAttribute("mnumber");
String image = (String)request.getAttribute("image");

//substring(문자배열번호 0부터시작, 문자열 1부터 ~)
//String mtel = mnumber.substring(4,8);

//length : 원시배열, length() : 문자열, size() : 클래스배열
out.print(mnumber.length());

if(mnumber.length() ==11){
	mnumber = mnumber.substring(0,3) + " **** " + mnumber.substring(7,11);
}
else if(mnumber.length() == 10){
	mnumber = mnumber.substring(0,3) + " **** " + mnumber.substring(6,11);
}
%>    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>회원가입이 완료 되었습니다.</p>
아이디 : <%= mid%><br>
고객명 : <%= mname%><br>
이메일 : <%= mmail%><br>
전화번호 : <%= mnumber%><br>
<%
if(image!=""){
%>
<img src="./user/ <%=image%>" style="width:100px; height: 100px;">
<%
}
%>	
</body>
</html>