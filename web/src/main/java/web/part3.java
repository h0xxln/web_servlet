package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;


@MultipartConfig(
	fileSizeThreshold = 1024 * 1024 * 2,	//파일 한개의 최대 용량 2MB
	maxRequestSize = 1024 * 1024 * 100 		//여러개의 파일을 전송시 총 용량 : 100MB
)

public class part3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	//회원가입 완료
	PrintWriter pw = null;
	String url = null;	//웹 경로를 저장하는 변수
	String filenm = null;	//파일명을 저장하는 변수
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		try {
			this.pw = response.getWriter();
			String mid= request.getParameter("mid");			
			String mname = request.getParameter("mname");			
			String mmail = request.getParameter("mmail");			
			String mpass = request.getParameter("mpassword");
			String mnumber = request.getParameter("mnumber");
			Part mfile = request.getPart("mfile"); //첨부파일
		
			if(mid.equals("") || mname.equals("") || mmail.equals("") ||mnumber.equals("")) {
				this.pw.write("<script>"
						+ "alert('올바른 데이터 접근이 아닙니다.');"
						+ "history.go(-1);"
						+ "</script>");
			}
			else {
				if(this.filenm != null && this.filenm != "") {
					long size = mfile.getSize();
					if(size > 2097152) {
						this.pw.write("<script>"
								+ "alert('첨부파일은 최대 2MB까지 입니다.');"
								+ "history.go(-1);"
								+ "</script>");
					}else {//첨부파일 용량 2MB 이하일 경우 서버에 저장
						this.filenm = mfile.getSubmittedFileName(); //파일 명
						this.url = request.getServletContext().getRealPath("");
						System.out.println(url);
						mfile.write(this.url + this.filenm);
								
						
					}
				}
			}
			//jsp에 값을 전달
			
			request.setAttribute("mid", mid);
			request.setAttribute("mname", mname);
			request.setAttribute("mmail", mmail);
			request.setAttribute("mnumber", mnumber);
			request.setAttribute("image", this.filenm);
			
			
			RequestDispatcher rd = request.getRequestDispatcher("./part3.jsp");
			rd.forward(request, response);
		} 
		catch (Exception e) {

		}finally {
			this.pw.close();
		}
		
	}

}
