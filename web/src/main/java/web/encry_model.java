package web;

import java.security.MessageDigest;
import java.util.Base64;
import java.util.Base64.Decoder;
import java.util.Base64.Encoder;

//문자를 암호화 변경 하는 Module
public class encry_model {
	public String dataencode(String word) { // base64 암호화
		Encoder ec = Base64.getEncoder();
		String security = ec.encodeToString(word.getBytes());
		return security;
	}

	public String datadecode(String word) {
		Decoder dc = Base64.getDecoder();
		/*
		 * byte dec[] = dc.decode(word); String security = new String(dec); return
		 * security;
		 */
		String security = new String(dc.decode(word));
		return security;
	}
	
	//MD5 : %02x 기본 => %ㅌ
	//sha-1 : 16진수 40자로 생성되는 암호화 기술 (%01x, %02x)
	//sha-2 : sha-224, sha-256, sha-284, sha-512
	//sha-3 : 
	
	//복합 암호화 기술 => base64 => md5
	//복합 암호화 기술 => md5 + sha-2
	public String md5_encode(String word) {
		String security = "";
		
		try {
			//MessageDigest : 암호화 클래스 구성 형태를 가지고 있는 라이브러리
			MessageDigest md = MessageDigest.getInstance("sha3-256");
			md.update(word.getBytes());	//해당 암호화 기준으로 바이트로 문자를 변환
			byte md5byte[] = md.digest();	//원사배열에 해당 암호화된 바이트로 저장
			
			StringBuilder sb = new StringBuilder();	//문자열 클래스로 연속화
			for(byte s : md5byte) {
				sb.append(String.format("%02x", s));
				//%02x => 2자리 문자 => 1234 => 01, 02, 03, 04
				//%01x => 2자리 문자 => 1234 => 1, 2, 3, 4
				//%05x => 5자리 문자 => 1234 => 00001, 00002
			}
			security = String.valueOf(sb);
			
		} catch (Exception e) {
			security = "MD5 Error!!";
		}
		return security;
		
	}
}



















