package web;

import java.io.IOException;
import java.util.ArrayList;

import javax.security.auth.message.callback.PrivateKeyCallback.Request;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class moviePart_2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
     ArrayList<String> al = null;


	protected void doPost(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
		req.setCharacterEncoding("utf-8");
		res.setContentType("text/html;charset=utf-8");
		
		
		try {
			String mname = req.getParameter("mname");
			String mtel = req.getParameter("mtel");
			String movie = req.getParameter("movie");
			String moviedate = req.getParameter("moviedate");
			//클래스배열
			this.al = new ArrayList<String>();
			al.add(mname);
			al.add(mtel);
			al.add(movie);
			al.add(moviedate);
			
			req.setAttribute("al", al);
			
			/*
			req.setAttribute("mname", mname);
			req.setAttribute("mtel", mtel);
			req.setAttribute("movie", movie);
			req.setAttribute("moviedate", moviedate);
			*/
			RequestDispatcher rd = req.getRequestDispatcher("./moviePart_2.jsp");
			rd.forward(req, res);
			
		} catch (Exception e) {
			
		}
	}

}
