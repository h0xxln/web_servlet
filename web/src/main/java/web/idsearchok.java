package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class idsearchok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    		request.setCharacterEncoding("utf-8");
    		response.setContentType("text/html");
    		response.setCharacterEncoding("utf-8");
    		PrintWriter pw = response.getWriter();
    		
    		try {	
    				String cna = request.getParameter("cosname");
    	            String cnu = request.getParameter("cosnumber");
    	            String ce = request.getParameter("cosemail");
    	            String id = "";

    	            if(cna.equals("홍길동") && cnu.equals("01010041919") && ce.equals("hong@naver.com") ){
    	            	id = "hong2025";
    	            	//입력값이여서 equals 대신 == 을 사용할 경우 맞게 입력을 해도 가입정보가 확인 되지 않습니다라고 출력 된다.
    	            }
    	            else{
    	            	id = "가입정보가 확인 되지 않습니다";
    	            }
    	            request.setAttribute("id", id);
    	            
    	            RequestDispatcher rd = request.getRequestDispatcher("/idsearchok.jsp");
    	            rd.forward(request, response);
    			
    		}catch (Exception e) {
    			pw.write("<script>"
    					+ "alert('올바른 값이 전달되지 않았습니다.');"
    					+ "history.go(-1);"
    					+ "</script>");
			}
    		
    	}

}
