<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원정보 입력</title>
</head>
<body>
<form id="frm" method="post" action="./part3.do" enctype="multipart/form-data">

<p>회원가입 정보 입력 [간편가입]</p><br>
아이디 <input type="text" name="mid"><br>
고객명 <input type="text" name="mname"><br>
이메일 <input type="text" name="mmail"><br>
비밀번호 <input type="password" name="mpassword" maxlength="12">* 비밀번호 최소 6 ~ 12자리 입니다.<br>
전화번호 <input type="text" name="mnumber" maxlength="11">* "-"는 입력하지 않습니다.<br>
이미지 <input type="file" name="mfiles" accept="image/*">* 이미지 첨부는 최대 2MB 이하 입니다.<br>
<button type="button" onclick="gopage()">가입완료</button> 
</form>
<script>
function gopage() {
	if(frm.mid.value==""){
		alert("아이디를 입력하세요");
	}
	else if(frm.mname.value==""){
		alert("이름을 입력하세요");
	}
	else if(frm.mpassword.value==""){
		alert("비밀번호를 입력하세요");
	}
	else if(frm.mnumber.value==""){
		alert("메일을 입력하세요");
	}
	else if(frm.mfiles.value==""){
		alert("파일을 첨부하세요");
	}
	else{
		if(confirm("회원가입을 진행 하시겠습니까?")){ //확인
			frm.submit();					
		}
		else{
			history.go(-1);
		}
	}
	
}
</script>
</body>
</html>