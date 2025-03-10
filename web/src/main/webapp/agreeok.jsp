<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Part2</title>
</head>
<body>
<form id="frm" method="post" action="http://172.30.1.99:8080/web/step_3.do" enctype="multipart/form-data">
회원가입 정보 입력 [간편가입]<br>
아이디 <input type="text" name="mid"><br>
고객명 <input type="text" name="mname"><br>
이메일 <input type="text" name="mmail"><br>
비밀번호 <input type="text" name="mpassword"><br>
전화번호 <input type="text" name="mnumber"><br>
이미지 <input type="file" name="mfiles" accept="image/*"><br>
<button type="button" onclick="ap()">가입완료</button> 
</form>
<script>
function ap() {
	frm.submit();
	console.log("check");
}
</script>
</body>
</html>