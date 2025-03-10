package notice;

import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.Part;

import shop.m_dbinfo;
import shop.m_md5;

//공지사항 게시판 파일을 저장 하는 Model
public class m_notice extends HttpServlet{
	Connection con = null;
	PreparedStatement ps = null;
	PrintWriter pwr = null;
	//Model
	m_dbinfo db = new m_dbinfo();	//DB 접솓정 
	
	String sql = "";
	int result = 0;
	
	m_md5 md5 = new m_md5();	//MD5 암호화
	
	String msg = ""; //Model에서 처리된 값을 Controller에 반환하는 역활
	
	String subject,writer,pw,texts;
	
	
	//즉시 실행 메소드에서 첨부파일을 저장하는 역활만 합니다.
	public m_notice(Part nfile,String subject,String writer,String pw,String texts,HttpServletRequest request)throws Exception{
		this.subject = subject;
		this.writer = writer;
		this.pw = pw;
		this.texts = texts;
		
		//파일 용량
		long filesize = nfile.getSize();
		//파일 명
		String filenm = nfile.getSubmittedFileName();
		
		System.out.println(filenm);
		System.out.println(request.getServletContext().getRealPath(""));
		//첨부파일 저장될 web Directory 설정
		String url = request.getServletContext().getRealPath("/notice_file/");
		
		try {
			nfile.write(url + filenm);	//웹에 저장
			this.fileok(filenm);	//정상적으로 저장 되었을 경우
		} catch (Exception e) {
			try{
				this.fileok("error");	//비정상적으로 해당 디렉토리에 파일이 저장되지 않을 경우	
			} 
			catch (Exception e2) {
				
			}
		}
		
	}
	//DB로 저장 및 Controller로 결과값을 return하는 메소드
	private String fileok(String data) throws Exception{
		if(data.equals("error")) {
			this.msg = "error";
		}
		else {	//파일 정상적으로 저장 되었을 경우
			try {
				this.con = this.db.getConnection();	
				this.sql = "insert into notice(nidx,subject,writer,pw,texts,filenm,nfile,ndate)"
						+ "values('0',?,?,?,?,?,?,now())";
				this.ps = this.con.prepareStatement(this.sql);
				this.ps.setString(1, this.subject);
				this.ps.setString(2, this.writer);
				this.ps.setString(3, this.pw);
				this.ps.setString(4, this.texts);
				this.ps.setString(5, data);
				this.ps.setString(6, data);
				this.result = this.ps.executeUpdate();
				if(this.result > 0) {
					this.msg = "ok";
				}
				
				
			}
			catch (Exception e) {
				this.msg = "error";
			}
			finally {
				this.ps.close();
				this.con.close();				
			}
		}
		return this.msg;	//controller로 보내는 값	
	}
	
}





