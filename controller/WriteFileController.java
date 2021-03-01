package travel1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel1.model.travelDAO;

public class WriteFileController implements Controller{
	//�۾��� ���� �����ϴ� ��?
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		HttpSession session=request.getSession();
		String name = (String) session.getAttribute("id");
		
		System.out.println("���� : "+title);
		System.out.println("���� : "+content);

		
		travelDAO dao = new travelDAO();
		int cnt = dao.BoardInsert(title, content, name);
		
		if(cnt!=0) {
			System.out.println("�Է� ����");
		}else {
			System.out.println("�Է� ����");
			
		}
		
		
		//�������� ��� üũ�� �Ǿ depth  1��  (������ ���Ͽø��� �����ϱ�?)
		
		return "Board.do";
	}




}
