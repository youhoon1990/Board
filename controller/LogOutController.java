package travel1.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LogOutController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session=request.getSession();
		
		String tk = (String) session.getAttribute("tk");
		System.out.println("토큰값은 "+tk);
		// 세션에 저장한 토큰 가지고오기
		
		
		
		String endpoint = "https://kapi.kakao.com/v1/user/logout";
		try {
			URL url = new URL(endpoint);
			HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();
			conn.setRequestMethod("POST");
	        conn.setRequestProperty("Authorization", "Bearer " + tk);
	        
	        int responseCode = conn.getResponseCode();
	        System.out.println("responseCode : " + responseCode);
	        
	        BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	        
	        String result = "";
	        String line = "";
	        
	        while ((line = br.readLine()) != null) {
	            result += line;
	        }
	        System.out.println(result);
	        System.out.println("로그아웃 성공");
		} catch (Exception e) {
			System.out.println("로그아웃 실패");
		}
		
		session.invalidate();
		return "Board.do";
	}





}
