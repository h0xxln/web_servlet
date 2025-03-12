package ajax;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class ajax_postok extends HttpServlet {
	private static final long serialVersionUID = 1L;

	PrintWriter pw = null;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//CORS 해결 방법 !!!/////////////////////////////////
		/*
		 해당 Orgin, Credentials를 사용하여 도메인이 다르게 접근하더라고
		 ajax 통신이 되도록 허락을 하는 명령어
		 "*"
		 */
		
		response.addHeader("Access-Control-Allow-Origin","*"); // *는 모든 IP를 다 받겠다는것
		response.addHeader("Access-Control-Allow-Credentials","true");
		//////////////////////////////////////////////////
		String userid = request.getParameter("userid");
		String usermail = request.getParameter("usermail");
		System.out.println(userid);
		System.out.println(usermail);
		String msg = "";	//ok : 정상 아이디, no : 아이디 오류 , error : 
		
		this.pw = response.getWriter();
		if(userid.equals("hong") && usermail.equals("hong@nate.com")) {
			msg = "no";
		}
		else {
			msg = "ok";
		}
		this.pw.print(msg);
				
	}

}
