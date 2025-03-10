package web;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Arrays;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class agreeok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		response.setCharacterEncoding("utf-8");
		PrintWriter pw = response.getWriter();
		
		try {
			String mid = request.getParameter("mid");
			String mname = request.getParameter("mname");
			String mmail = request.getParameter("mmail");
			String mnumber = request.getParameter("mnumber");
			
			request.setAttribute("mid", mid);
			request.setAttribute("mname", mname);
			request.setAttribute("mmail", mmail);
			request.setAttribute("mnumber", mnumber);
			
			RequestDispatcher rd = request.getRequestDispatcher("/step_3.jsp");
			rd.forward(request, response);
		
		} catch (Exception e) {
			pw.write("<script>"
					+ "alert('올바른 접근이 아닙니다.');"
					+ "</script>");		
		}finally {
			pw.close();
			
		}
	}

}
