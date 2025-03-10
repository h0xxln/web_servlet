package mail;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import shop.m_dbinfo;


public class mailok extends HttpServlet {
	private static final long serialVersionUID = 1L;
    Connection con = null;
    ResultSet rs = null;
    PreparedStatement ps = null;
    PrintWriter pw = null;
    m_dbinfo db = null;
    
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	request.setCharacterEncoding("utf-8");
	response.setContentType("text/html;charset=utf-8");
	this.db = new m_dbinfo();
	try {
		this.con = db.getConnection();
		String mname = request.getParameter("mname");
		String mmail = request.getParameter("mmail");
		String mtitle = request.getParameter("mtitle");
		String mtexts = request.getParameter("mtexts");
		
		String sql ="insert into m_mail values('0',?,?,?,?,now())";
		this.ps = this.con.prepareStatement(sql);
		this.ps.setString(1, mname);
		this.ps.setString(2, mmail);
		this.ps.setString(3, mtitle);
		this.ps.setString(4, mtexts);
		this.ps.executeUpdate();
		
	} catch (Exception e) {

	}
	
	}
}










