package admin;

import java.io.IOException;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class main extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /*
     	하나의 컨트롤러에하나의 뷰 적용
     	단, 해당 뷰 안에 여러개의 인클루드 (jsp)가 있는 상황
     */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String corp = "에이핑크 사단법인(사)";
		
		request.setAttribute("corp", corp);
		
		RequestDispatcher rd = request.getRequestDispatcher("./main.jsp");
		rd.forward(request, response);
	}

}
