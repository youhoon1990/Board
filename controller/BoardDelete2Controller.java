package travel1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel1.model.travelDAO;

public class BoardDelete2Controller implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		 String num =request.getParameter("num");
		 System.out.println("지울 게시글 번호는 "+num);
		 travelDAO dao = new travelDAO();
		 
		 dao.boardDelete(num);
		
		return "Board.do";
	}


}
