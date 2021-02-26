package travel1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel1.model.travelDAO;

public class WriteFileController implements Controller{
	//글쓰고 파일 저장하는 것?
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		HttpSession session=request.getSession();
		String name = (String) session.getAttribute("id");
		
		System.out.println("제목 : "+title);
		System.out.println("내용 : "+content);

		
		travelDAO dao = new travelDAO();
		int cnt = dao.BoardInsert(title, content, name);
		
		if(cnt!=0) {
			System.out.println("입력 성공");
		}else {
			System.out.println("입력 실패");
			
		}
		
		
		//공지글의 경우 체크가 되어서 depth  1로  (공지만 파일올릴수 있으니까?)
		
		return "Board.do";
	}




}
