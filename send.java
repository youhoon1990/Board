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
 * Servlet implementation class send
 */
@WebServlet("/send")
public class send extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		
		Gmail gmail = new Gmail();
		
		String where = request.getParameter("email");
		String birth = request.getParameter("birth");
		System.out.println(where);
		String mail = "youhoon1990@naver.com";
		String title = "���� �ڵ� �Դϴ�.";
		
		//�ڵ����  ��������� ���� ���ϴ� ��
		ControllerTest ct = new ControllerTest();
		int num = ct.hap(birth);						
		String content = num+"";  
		
		try {
			gmail.send("youhoon1990@gmail.com", "fbgnsgml1@", "youhoon1990@gmail.com", where, title, content);
			System.out.println("���Ϻ����� ����, �ڵ�� = "+ content);
		} catch (Exception e) {
			System.out.println("���Ϻ����� ����");
		}
		
		
		//���� �����ָ� ���� �ϼ� �� �Ѱ�?  
	      

	}

}
