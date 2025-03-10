package web;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class productsale extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		response.setContentType("text/html");
		
		String p_price =  request.getParameter("product_price");
		String p_sale = request.getParameter("discountCode");
		PrintWriter pw = response.getWriter();
		
		try {			
			int pr_price = Integer.parseInt(p_price);	
			
			if(p_sale.equals("SALE10")) {
				pr_price = pr_price - ((pr_price * 10)/100); 
			}
			else if(p_sale.equals("SALE20")) {
				pr_price = pr_price - ((pr_price * 20)/100);
			}
			else if(p_sale.equals("VIP")) {
				pr_price = pr_price - ((pr_price * 30)/100);
			}
			else {
				 pw.write("<script>"
	                        + "alert('해당 코드는 없는 코드입니다.');"
	                        + "history.go(-1);"
	                        + "</script>");
	                return; // 페이지 이동을 막기 위해 return 추가
			}
			request.setAttribute("pr_price", pr_price);
			
			RequestDispatcher rd = request.getRequestDispatcher("/productsale.jsp");
			rd.forward(request, response);
					
			
				
		} catch (Exception e) {
			System.out.println(e);
			pw.write("<script>"
					+ "alert('값이 잘못 입력 되었습니다');"
					+ "</script>"	
					);
		}
		
					
		}
		
	

}
