package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class part2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	PrintWriter pw = null; 
	
	//part1에서 get으로 전송하므로 doGet만 설정함
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		try {
			this.pw = response.getWriter();
			//getParameterValues => 배열
			String agree[] = request.getParameterValues("agree");
			int ea = agree.length;
			int ckcount = 0;
			int w = 0;
			
			while(w < ea) {
				if(agree[w].equals("Y0") || agree[w].equals("Y1") || agree[w].equals("Y2")) {
					System.out.println("정상적인 약관 동의");
					ckcount++;
				}
				w++;
			}
			System.out.println(ckcount);
			if(ckcount < 3) {
				this.pw.write("<script>"
						+ "alert('올바른 접근 방식이 아닙니다. 약관의 동의가 필요합니다.');"
						+ "location.href='./part1.jsp';"
						+ "</script>");
			}
			else {//해당 조건이 맞을 경우 part2.jsp 로드
				RequestDispatcher rd = request.getRequestDispatcher("./part2.jsp");
				rd.forward(request, response);
			}
			
		}catch (Exception e) {
			this.pw.write("<script>"
					+ "alert('시스템 오류');"
					+ "location.href='./part1.jsp';"
					+ "</script>");
		}finally {
			this.pw.close();
		}
	}

}
