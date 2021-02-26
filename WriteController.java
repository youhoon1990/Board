package travel1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel1.model.travelDAO;

public class WriteController implements Controller{
	//답글다는 컨트롤러
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		String groupno = request.getParameter("groupno");
		String groupod = request.getParameter("groupod");

		
		System.out.println("제목 : "+title);
		System.out.println("내용 : "+content);
		System.out.println("no : "+groupno);
		System.out.println("od : "+groupod);
		
		travelDAO dao = new travelDAO();
		int cnt = dao.AnswerInsert(title, content, groupno, groupod);
		
		if(cnt!=0) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");
			
		}
		return "Board.do";
	}


}
