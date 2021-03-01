package travel1.controller;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import travel1.model.travelDAO;

public class KakaoController implements Controller {

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");

		String code = request.getParameter("code");
		System.out.println("īī������ ������ �ڵ�� " + code);

		String endpoint = "https://kauth.kakao.com/oauth/token";
		URL url = new URL(endpoint);
		String bodyData = "grant_type=authorization_code&";
		bodyData += "client_id=020c086d2f07c389f780777fec4cf86d&";
		bodyData += "redirect_uri=http://smhousegrid.com:8083/travel1/Kakao.do&";
		bodyData += "code=" + code;

		// Stream ����
		HttpsURLConnection conn = (HttpsURLConnection) url.openConnection();

		// http header �� �ֱ�
		conn.setRequestMethod("POST");
		conn.setRequestProperty("Content-Type", "application/x-www-form-urlencoded;charset=utf-8");
		conn.setDoOutput(true);

		// request �ϱ�
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(conn.getOutputStream(), "UTF-8"));
		bw.write(bodyData);
		bw.flush();

		BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
		String input = "";
		StringBuilder sb = new StringBuilder();
		while ((input = br.readLine()) != null) {
			sb.append(input);
		}

		
		String pretk = sb.toString();
		//System.out.println("pretk�� "+pretk);
		//System.out.println("sb.toString() : "+sb.toString());

		
		String endpoint2="https://kapi.kakao.com/v2/user/me";
		URL url2 =new URL(endpoint2);
		
		HttpsURLConnection conn2=(HttpsURLConnection)url2.openConnection();
		//�Ʒ��� ���� �ڵ� ���� ��ū �־����.
		JsonParser parser = new JsonParser(); // json Ÿ�� ��Ʈ������ �ٲ����
		
		JsonElement element0 = parser.parse(pretk);
		//JsonObject access_token = element0.getAsJsonObject().get("access_token").getAsJsonObject();
		String access_token = element0.getAsJsonObject().get("access_token").getAsString();
		//String tk =access_token.getAsJsonObject().get("access_token").getAsString();
		String tk = access_token;
		//System.out.println("��ū�� "+tk);
		
		
		
		
		conn2.setRequestProperty("Authorization", "Bearer "+tk);
		conn2.setDoOutput(true);
		
		BufferedReader br2=new BufferedReader(new InputStreamReader(conn2.getInputStream(),"UTF-8"));
		String input2="";
		StringBuilder sb2=new StringBuilder();
		while((input2=br2.readLine())!=null) {
			sb2.append(input2);
		}
		String sb3 = sb2.toString();
		//System.out.println("sb3�� "+sb3);
		//System.out.println("sb2.toString() : "+sb2.toString());
		

        
        JsonElement element = parser.parse(sb3);
        
        //JsonObject properties = element.getAsJsonObject().get("properties").getAsJsonObject();
        JsonObject kakao_account = element.getAsJsonObject().get("kakao_account").getAsJsonObject();
        //System.out.println("kakao account�� "+kakao_account);
        //String nickname = properties.getAsJsonObject().get("nickname").getAsString();
        String email = kakao_account.getAsJsonObject().get("email").getAsString();
        System.out.println("�̸����� "+email);
        //userInfo.put("nickname", nickname);
        //userInfo.put("email", email);
		
		// ���⿡ ���� �ؼ� īī�� ���̵� �����ؾ��� �׸��� ���ǰ��� ����Ȱ� �����ͼ� xxx�� �ȳ��ϼ��� �ϸ� ��
        
        HttpSession session=request.getSession();
		// ������ ��������� ��� ������
		session.setAttribute("id", email);
        session.setAttribute("tk", tk);
		
        
		return "Board.do";
	}

}
