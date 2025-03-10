<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
	
	//String word = (String)request.getAttribute("abc");  	//null, ""
	//String word = request.getAttribute("abc").toString();	//""
	String word = String.valueOf(request.getAttribute("subject")); //null, ""
	out.print(word);
	
	String etc[] = (String[])request.getAttribute("etc");
	out.print(etc);
	
%>
    
    
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title> 설문조사 결과</title>
</head>
<body>
선택하신 과목 : <%=word %>
배우고 싶은 과목 <%
int w = 0; 
while(w < etc.length){	//Controller에서 원시배열로 받은 데이터를 뿌림
	out.print(etc[w] + " ");
	w++;
}

%>
</body>
</html>