package travel1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel1.model.memberVO;
import travel1.model.travelDAO;

public class MemberInsertController2 implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("id");		
		String pass = request.getParameter("pass");
		String name =  request.getParameter("name");
		String birth = request.getParameter("birth");
		String tel = request.getParameter("tel");
		
		
		memberVO vo = new memberVO(id, pass, name, birth, tel); 
		travelDAO dao = new travelDAO();
		
		System.out.println(vo.getId()+"vo�� �־���");
		System.out.println(vo.getPass()+"vo�� �־���");
		
		
		int cnt = dao.memberInsert(vo);
		
		
		
		String nextPage = null;
		if(cnt>0) {
			nextPage = "Board.do";
			System.out.println("ȸ�����ԿϷ�");
		}else {
			
			nextPage = "member/MemberInsert.jsp";
		}
		
		return nextPage;
	}

}
