package session;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class session3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession se = request.getSession();
		//se.invalidate();//session에 저장된 값들을 null 값으로 즉, 삭제를 시켜버림 (session을 초기화 시킴)
		//모든 session의 값을 초기화(삭제)
		se.removeAttribute("tel");	//특정 session 값만 삭제를 할 수 있음.
		
	}	
}
