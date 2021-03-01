package travel1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel1.model.travelDAO;

public class EditController implements Controller{

	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String content = request.getParameter("content");
		
		//굳이 배열이나 리스트에 담을 필요 없음
		request.setAttribute("num", num);
		request.setAttribute("title", title);
		request.setAttribute("content", content);
		
		return "/member/EditForm.jsp";
	}

}
