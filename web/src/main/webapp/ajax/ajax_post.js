function ajaxs(){	//전송 버튼 클릭시 이벤트 함수
	var mid = document.getElementById("mid");
	var memail = document.getElementById("memail");
	if(mid.value == ""){
		alert("아이디를 입력하세요.");
	}
	else{
		//ajax post 통신을 위한 함수호출
		this.ajax_post(mid.value,memail.value);
	}
}
//ajax post로 전송하는 함수
function ajax_post(mid,memail){
	var http, result;	//http : Back-end통신 , result : Back-end 제공한 데이터
	http = new XMLHttpRequest();
	http.onreadystatechange = function(){
		if(http.readyState == 4 && http.status == 200){
			console.log(this.response);
		}
		else if(http.status == 404){
			console.log("경로 오류 발생!!");
		}
		else if(http.status == 405){
			console.log("통신 규격 오류 발생");
		}
			
	
	}
	//GET 통신	
	//http.open("get","./ajax_postok.do?mid="+mid,true); get방식
	//http.send();
	
	//POST 통신
	http.open("post","http://172.30.1.80:8080/web/ajax/ajax_postok.do",true);
	//ajax post 전송시 content-type 적용하여 urlencoded 적용해야만 정상적으로 Back-end에게 값을 전송함
	http.setRequestHeader("content-type","application/x-www-form-urlencoded");
	
	//http.send("userid="+mid); 데이터 한개 전송
	http.send("userid="+mid+"&usermail="+memail);// 한개 이상 부터 & 사용
	
	
}