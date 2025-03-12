package mallpage;

import java.sql.Connection;
import java.sql.PreparedStatement;


import shop.m_dbinfo;

//회원가입 처리 Model
public class insert_join {
	Connection con = null;
	PreparedStatement ps = null;
	String sql = null;
	m_dbinfo db = new m_dbinfo();
	Integer result = null;
	
	public Integer insert_member(m_member m) {
		System.out.println("모델에서 받은거 맞음 : "+m.getMname());
		
		try {
			//DTO에서 getter이용해서 db에 저장
			this.con = this.db.getConnection();
			this.sql = "insert into joins values('0',?,?,?,?,?,?,?,now())";
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setString(1,m.getMid());
			this.ps.setString(2,m.getMpass());
			this.ps.setString(3, m.getMname());
			this.ps.setString(4, m.getMemail());
			this.ps.setString(5, m.getMtel());
			this.ps.setString(6, m.getEvent_mail());
			this.ps.setString(7, m.getEvent_sms());
			
			this.result = this.ps.executeUpdate();
			
		} 
		catch (Exception e) {
			System.out.println(e);
		}
		finally {
			try {
				this.ps.close();
				this.con.close();
			} catch (Exception e2) {
				System.out.println(e2);
			}
		}
		
		return this.result;
	}
}
