package travel1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.google.gson.JsonObject;

import travel1.frontcontroller.ControllerTest;

/**
 * Servlet implementation class confirm
 */
@WebServlet("/confirm")
public class confirm extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		String code = request.getParameter("code");  //입력한 인증코드
		String birth = request.getParameter("birth"); //난수생성위한 재료
		String code2 = "";
		System.out.println(code);
		System.out.println("생일은 " + birth);

		ControllerTest ct = new ControllerTest();

		int num = ct.hap(birth);
		code2= num+"";
		boolean tf = false;

		if (code.equals(code2)) {
			tf = true;
			System.out.println("코드맞춤");
		} else {
			tf = false;
			System.out.println("코드틀림");
		}

		
		Gson gson = new Gson();
		JsonObject jsonObj = new JsonObject();
		jsonObj.addProperty("boolean", tf);
		String json = gson.toJson(jsonObj);
		System.out.println(jsonObj.toString());

		out.print(json);
	}

}
