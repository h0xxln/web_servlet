package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class payok extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
	//Controller
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");	
		PrintWriter pw = response.getWriter();
		
		try {
			//Front-end 값을 받는 역활을 함
			String m = request.getParameter("money");
			String s = request.getParameter("sales");
			String p = request.getParameter("point");
			
			//해당 데이터를 숫자로 변환 후 사칙연산
			int product_m = Integer.valueOf(m);
			int product_s = Integer.valueOf(s);
			int product_p = Integer.valueOf(p);
			int total = (product_m -(product_m * product_s)/100) - product_p;
			
			//Controller => View(.jsp에서 사용할 수 있도록 함)
			request.setAttribute("total", total);
			request.setAttribute("product_m", product_m);
			request.setAttribute("product_s", product_s);
			request.setAttribute("product_p", product_p);
			
			//RequestDispatcher : View를 선언하여 웹페이지에 출력 되도록 설정
			RequestDispatcher rd = request.getRequestDispatcher("/payok.jsp");
			rd.forward(request, response);	//Controller에서 사용된 정보를 jsp로 이관
			
		}
		catch (Exception e) {	//Front-end 값이 숫자로 변환시 비정상적일 경우 해당 스크립 실행됨
			pw.write("<script>"
					+ "alert('올바른 값이 전달되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
	}

}












