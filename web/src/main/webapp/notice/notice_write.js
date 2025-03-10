//게시물 등록시 체크 하는 함수
function writeck(){
	if(frm.subject.value == ""){
		alert("제목을 입력하셔야 합니다.");
		frm.subject.focus();
	}
	else if(frm.writer.value == ""){
		alert("글쓴이를 입력하셔야 합니다.");
		frm.writer.focus();
	}
	else if(frm.pw.value == ""){
		alert("패스워드를 입력하세요.");
		frm.pw.focus();
	}
	else{	//에디터 장착 해서 다르다.
		//CKEDITOER.instances.html id이름.getData() : ckeditor를 로드 
		var txt = CKEDITOR.instances.editor.getData();
		if(txt == ""){
			alert("내용을 입력하셔야 합니다.");
		}
		else if(txt.length < 40){
			alert("최소 내용이 40자 이상이여야 합니다.");
		}
		else{
			frm.submit();
			alert("저장되었습니다!");
		}
	}

}