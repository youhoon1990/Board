package travel1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class AnswerController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		String num = request.getParameter("num");
		String title = request.getParameter("title");
		String groupno = request.getParameter("groupno");
		String groupod = request.getParameter("groupod");
		
		System.out.println(num+"      "+ title);
		System.out.println("groupod¿Í num "+groupod+"¿Í"+groupno);
		request.setAttribute("num", num);
		request.setAttribute("title", title);
		request.setAttribute("groupno", groupno);
		request.setAttribute("groupod", groupod);
		
		return "/member/AnswerForm.jsp";

	}
}
