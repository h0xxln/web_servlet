package notice;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import shop.m_dbinfo;

//DB에 있는 모든 데이터를 가져오는 역활 (Model)
public class m_noticelist {
	Connection con = null;
	PreparedStatement ps = null;
	ResultSet rs = null;
	m_dbinfo db = new m_dbinfo();
	String sql; //SQL Query
	
	ArrayList<String> data = null; //1차배열 각 컬럼별 값을 저장
	ArrayList<ArrayList<String>> alldata = null;	//Database 전체 데이터를 저장
	
	int spage = 0; //첫번째 배열값
	int ea = 3;	//한페이지 당 게시물을 3개씩 출력
	
	public m_noticelist(int s){
		
		if(s > 0) {	//1번 페이징 번호 외에 번호를 클릭 했을 경우
			//(페이지번호 -1) * 한 페이지당 출력할 갯수
			this.spage = (s - 1) * ea;
		}
		else {
			this.spage = s;	//sql query문의 limit를 사용하기 위함			
		}
	
	}
	
	
	public ArrayList<ArrayList<String>> db_data(){
		try {
			this.con = db.getConnection();
			//필요한 컬럼만 지정하여 select 문법으로 데이터를 가져오는 코드
			this.sql = "select nidx,subject,writer,nview,ndate,(select count(*)from notice)as total"
					+ " from notice order by nidx desc limit ?,?";	//0,3
			this.ps = this.con.prepareStatement(this.sql);
			this.ps.setInt(1, this.spage);
			this.ps.setInt(2, this.ea);
			
			this.rs = this.ps.executeQuery(); //select 
			
			this.alldata = new ArrayList<ArrayList<String>>();
			//반복문으로 table에 있는 컬럼을 1차 배열로 이관 후 2차 배열에 담는 코드
			while(this.rs.next()) {
				this.data = new ArrayList<String>();
				this.data.add(this.rs.getString("nidx"));
				this.data.add(this.rs.getString("subject"));
				this.data.add(this.rs.getString("writer"));
				this.data.add(this.rs.getString("nview"));
				this.data.add(this.rs.getString("ndate"));
				this.data.add(this.rs.getString("total"));	//게시물 전체 갯수를 저장한 배열값
				this.alldata.add(this.data);
			}
			System.out.println(this.alldata);
			
		} catch (Exception e) {
			System.out.println(e);
			this.alldata = null;
		}finally {
			try {
				this.ps.close();
				this.con.close();				
			}
			catch (Exception e2) {
				System.out.println(e2);
				this.alldata = null;
			}
		}
		//Model에서 Controller로 데이터를 회신함
		return this.alldata;
	}
	
	
}