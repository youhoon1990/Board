package travel1.controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import travel1.model.travelDAO;

public class LoginController2 implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html; charset=UTF-8");
		String id = request.getParameter("id");
		String pass = request.getParameter("pass");
		travelDAO dao = new travelDAO();
		String nextPage= "";
		boolean succ = dao.isLogin(id,pass);
		if(succ) {
			HttpSession session=request.getSession();
			// 동일한 브라우져라면 계속 유지됨
			session.setAttribute("id", id);
			
			nextPage = "Board.do";
		}else {
			nextPage = "member/LoginForm.jsp";
		}
		return nextPage;
	}







}
