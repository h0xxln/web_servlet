package web;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class encry extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String password = "a123456";
		encry_model em = new encry_model();	//암호화 model 클래스를 로드함
		String result = em.dataencode(password);	//해당 메소드에 문자값을 전달
		System.out.println(result);	//최종 암호화된 사항을 출력
	
		//base64로 변환된 문자를 decode(복호화) 이용하여 원본 문자로 변환
		String repasswd = "YTEyMzQ1Ng==";
		String result2 = em.datadecode(repasswd);
		System.out.println(result2);
		
		
		//md5 암호화 알고리즘
		String result3 = em.md5_encode(password);
		System.out.println(result3);
	
}}
