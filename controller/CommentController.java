package travel1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel1.model.CommentVO;
import travel1.model.boardVO;
import travel1.model.travelDAO;

public class CommentController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html; charset=UTF-8");
		String reply = request.getParameter("comment"); //���
		int num = Integer.parseInt(request.getParameter("num"));  //�Խñ۹�ȣ
		System.out.println(reply);
		HttpSession session=request.getSession();  //��� �ۼ��� ���̵�
		String name = (String) session.getAttribute("id");
		System.out.println("���� ����� id��  "+name);
		travelDAO dao = new travelDAO();
		
		CommentVO list = new CommentVO(num, reply, name);
		int cnt = dao.CommentInsert(list);
		String nextPage = null;
		if(cnt!=0) {
			nextPage = "Board.do";
			System.out.println("��۾��� ����");
		}else {
			nextPage = "Board.do";
			System.out.println("��۾��� ����");
		}
		
		//��� ������ ����
		 
		
		
		 
		return nextPage;
	}



}
