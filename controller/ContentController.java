package travel1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import travel1.model.CommentVO;
import travel1.model.boardVO;
import travel1.model.memberVO;
import travel1.model.travelDAO;

public class ContentController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html; charset=UTF-8");
		String num = request.getParameter("num");
		
		System.out.println(num);
		travelDAO dao = new travelDAO();
		//��ȸ�� ���������ֱ�
				dao.updateClick(num);
		boardVO vo = dao.ContentList(num);
		
		request.setAttribute("vo", vo); // was�� �մ� data ����
		int pre = dao.pre(num); //���� �Խñ� ��ȣ ������ ���� ���ϰ��� int�� �ƴ� int�迭�� �ؼ� �������� ������ �ð�
		
		request.setAttribute("pre", pre);
		//��� ������ ����
		ArrayList<CommentVO> vo1 = dao.CommentList(num); 
		
		System.out.println(vo1.size());
		request.setAttribute("vo1", vo1); 
		
		 Gson gson = new Gson();
		 String list1 = gson.toJson(vo1);
		 System.out.println(list1);


		return "member/Content.jsp";
	}



}
