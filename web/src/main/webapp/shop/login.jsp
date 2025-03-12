<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
HttpSession hs = request.getSession();
String mid = (String)hs.getAttribute("mid");
String mnm = (String)hs.getAttribute("mnm");

if(mid != null || mnm != null){	//로그인이 되어 있을 경우 다시 로그인 하지 못하도록 처리
	out.print("<script>"
	+"alert('이미 로그인 하셨습니다.');"
	+"location.href='./main.jsp';"
	+"</script>");
}
%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원 로그인</title>
</head>
<body>
<!-- 
onclick은 특정 버튼 클릭 시에만 실행되지만, 
onsubmit은 모든 제출 시도(버튼 클릭, Enter 키 등)를 감지하고 통제할 수 있기 때문
 -->
<form id="frm" method="post" action="./shop_loginok.do" onsubmit="return loginck()">
<p>[회원 로그인]</p>
<div>
<label>							<!-- 여기서 value를 소문자로 때리면 안된다. -->
<input type="radio" name="spart" value="P" onclick="partcheck(this.value)" checked>일반회원
</label>
<label>
<input type="radio" name="spart" value="C" onclick="partcheck(this.value)">사업자회원
</label>
<br>
<input type="text" name="sid" placeholder="아이디를 입력하세요"><br>
<input type="text" name="spw" placeholder="패스워드를 입력하세요"><br>
<span id="snoview" style="display:none;">
<input type="text" name="sno" placeholder="사업자 등록번호"><br>
</span>
<input type="submit" value="로그인">
</div>
</form>
</body>
<script src="./login.js?v=1"></script>

</html>