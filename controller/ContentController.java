package travel1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel1.model.boardVO;
import travel1.model.memberVO;
import travel1.model.travelDAO;

public class ContentController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String id = request.getParameter("id");
		System.out.println(id);
		travelDAO dao = new travelDAO();
		memberVO vo = dao.ContentList(id);
		request.setAttribute("vo", vo); // was에 잇는 data 저장
		return "member/Content.jsp";
	}



}
