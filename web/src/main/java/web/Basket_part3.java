package web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class Basket_part3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html; charset=utf-8");

		try {
			String card = request.getParameter("card");
			String totalprice = request.getParameter("totalprice");
			String mway = "";
			

			if(card.equals("y0")) {
				mway = "신용카드";
			}
			else if(card.equals("y1")) {
				mway = "가상계좌";
			}
			else if(card.equals("y2")) {
				mway = "휴대폰 결제";
			}
			else if(card.equals("y3")) {
				mway = "무통장 입금";
			}
			 
			System.out.println(mway);
			System.out.println(totalprice);
			
			request.setAttribute("mway", mway);
			request.setAttribute("totalprice", totalprice);
			
			RequestDispatcher rd = request.getRequestDispatcher("./Basket_part3.jsp");
			rd.forward(request, response);
		} catch (Exception e) {

		}
		finally {
			
		}
		
	}

}
