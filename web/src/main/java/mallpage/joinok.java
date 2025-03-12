package mallpage;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import mallpage.insert_join;


@WebServlet("/mallpage/joinok.do")
public class joinok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	PrintWriter pw = null;
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");
		
		PrintWriter pw = response.getWriter(); // 여기서 PrintWriter 초기화
		
		String mid = request.getParameter("mid");
		String mpass = request.getParameter("mpass");
		String mname = request.getParameter("mname");
		String memail = request.getParameter("memail");
		String mtel = request.getParameter("mtel");
	
		//checkbox
		String event_mail = request.getParameter("event_mail");
		String event_sms = request.getParameter("event_sms");
		
		if(event_mail == null) {
			event_mail = "N";
		}
		if(event_sms == null) {	
			event_sms = "N";
		}
		
		m_member dto = new m_member();
		dto.setMid(mid);
		dto.setMpass(mpass);
		dto.setMname(mname);
		dto.setMemail(memail);
		dto.setMtel(mtel);
		dto.setEvent_mail(event_mail);
		dto.setEvent_sms(event_sms);
		
		
		Integer result = new insert_join().insert_member(dto);
		
		if(result>0) {
			pw.write("<script>"
					+ "alert('정상적으로 가입 하셨습니다');"
					+ "location.href='./login.do'"
					+ "</script>");
			
		}
		else {
			pw.write("<script>"
					+ "alert('시스템 점검으로 인하여 가입이 되지 않았습니다.');"
					+ "history.go(-1);"
					+ "</script>");
		}
		this.pw.close();
	}

}
