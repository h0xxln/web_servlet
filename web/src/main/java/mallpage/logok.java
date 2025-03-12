package mallpage;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;


@WebServlet("/mallpage/logok.do")
public class logok extends HttpServlet {
	private static final long serialVersionUID = 1L;
       PrintWriter pw = null;
	
	m_member mb = new m_member();
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		this.pw = response.getWriter();
		response.setContentType("text/html;charset=utf-8");
		this.mb.setMid(request.getParameter("mid"));
		this.mb.setMpass(request.getParameter("mpass"));
		
		copyright cr = new copyright();
		//Controller => Model로 DTO
		String result =  cr.user_login(this.mb);
		
		//모델엥서 디티오를 생성한 값을 컨트롤러에 받는 역활
		m_member mb2 = cr.mb;	//모델에서 적용된 디티오값을 받아서 Session
		
		System.out.println(mb2.getMname());
	
		if(result == "ok") {
			//dto를 활용하여 session 적용
			//HttpSession : Controller (loginok, logout)에서만 설정
			HttpSession session = request.getSession();
			session.setAttribute("mid", mb2.getMid());
			session.setAttribute("mname", mb2.getMname());
			session.setAttribute("memail", mb2.getMemail());
			
			
			//디티오를 활용하여 세션을 생성
			this.pw.print("<script>"
					+ "alert('로그인 하셨습니다.');"
					+ "location.href='./index.do';"
					+ "</script>");
		}
		else {
			this.pw.print("<script>"
					+ "alert('아이디 및 패스워드를 확인 하세요..');"
					+ "history.go(-1);"
					+ "</script>");
		}
	}

}
