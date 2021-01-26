package travel1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel1.model.boardVO;
import travel1.model.memberVO;
import travel1.model.travelDAO;

public class BoardListController implements Controller {
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		travelDAO dao = new travelDAO();
		ArrayList<boardVO>vo = dao.boardList();
		request.setAttribute("vo", vo); // was에 잇는 data 저장
		return "member/BoardList.jsp";
	}

}
