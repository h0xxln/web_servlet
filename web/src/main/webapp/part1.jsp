<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원가입[약관동의]</title>
</head>
<body>
<!-- id는 중복 사용 불가 name은 가능 -->
<form id="frm" method="post" action="./part2.do">
<p>회원가입 약간</p>
<input type="checkbox" id="all" onclick="all_check(this.checked)">전체선택<br>
<input type="checkbox" name="agree" value="Y0" onclick="ag_check()">서비스 이용약관 동의(필수)<br>
<input type="checkbox" name="agree" value="Y1" onclick="ag_check()">개인정보 수집 및 이용(필수)<br>
<input type="checkbox" name="agree" value="Y2" onclick="ag_check()">이메일 정보 수신 약관(필수)<br>
<input type="checkbox" name="agree" value="Y3" onclick="ag_check()">광고성 정보 수신 약관(선택)<br>
<input type="button" value="회원가입" onclick="go_page()">
</form>
</body>
<script>
function go_page() {	//part2.do 전송
	if(frm.agree[0].checked == true && frm.agree[1].checked==true && frm.agree[2].checked==true){
		frm.submit();
	}
	else{
		alert("필수 조건은 무조건 동의 하셔야만 회원가입이 진행 됩니다.");
	}
}

var all_check = function(z) {
	var ob = frm.agree;	//form태그 안에서 agree라는 name명을 가진 오브젝트 전체
	var ea = ob.length;
	var w = 0;
	do{
		ob[w].checked = z;
		w++;
	}while(w < ea);
}


//하나라도 false 일 경우 전체 선택 해제 또는 모두 체크가 되었을 때 전체 선택
function ag_check() {
	var ob = frm.agree;	//form태그 안에서 agree라는 name명을 가진 오브젝트 전체
	var ea = ob.length;
	var w = 0;
	var count = 0;
	do{
		if(ob[w].checked == true){
			count++;
		}
		w++;
	}while(w < ea);
	if(ea == count){
		document.getElementById("all").checked = true;		
	}else{
		document.getElementById("all").checked = false;
	}
		
}





</script>
</html>