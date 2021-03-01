package travel1.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel1.controller.AnswerController;
import travel1.controller.BoardDelete2Controller;
import travel1.controller.BoardDeleteController;
import travel1.controller.BoardListController;
import travel1.controller.CommentController;
import travel1.controller.ContentController;
import travel1.controller.Controller;
import travel1.controller.EditController;
import travel1.controller.EditController2;
import travel1.controller.KakaoController;
import travel1.controller.LogOutController;
import travel1.controller.LoginController;
import travel1.controller.LoginController2;
import travel1.controller.ManageController;
import travel1.controller.MemberInsertController;
import travel1.controller.MemberInsertController2;
import travel1.controller.SearchController;
import travel1.controller.WriteController;
import travel1.controller.WriteController2;
import travel1.controller.WriteFileController;
import travel1.model.travelDAO;

@WebServlet("*.do")
public class allController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String reqPath = request.getRequestURI();
		// System.out.println(reqPath);
		String contextPath = request.getContextPath();
		// System.out.println(contextPath);
		String command = reqPath.substring(contextPath.length());
		// client의 요청(command) command 패턴?이 여기서 나옴
		System.out.println(command);
		// 요청에 따른 처리(분기 작업이라고 부름)
		Controller controller = null;
		String nextPage = null;
		travelDAO dao = new travelDAO();
		if (command.equals("/Board.do")) {
			controller = new BoardListController();
			nextPage = controller.requestHandler(request, response);

			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		} else if (command.equals("/MemberInsert.do")) {

			controller = new MemberInsertController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);

		} else if (command.equals("/MemberInsert2.do")) {

			controller = new MemberInsertController2();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);

		} else if (command.equals("/Content.do")) {
			controller = new ContentController();
			nextPage = controller.requestHandler(request, response);

			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}else if (command.equals("/Login.do")) {

			controller = new LoginController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);

		}else if (command.equals("/Login2.do")) {

			controller = new LoginController2();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);

		}else if (command.equals("/LogOut.do")) {

			controller = new LogOutController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);

		}else if (command.equals("/Comment.do")) {
			//댓글작성?
			controller = new CommentController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);

		}else if (command.equals("/Search.do")) {
			controller = new SearchController();
			nextPage = controller.requestHandler(request, response);

			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}else if (command.equals("/Manage.do")) {
			controller = new ManageController();
			nextPage = controller.requestHandler(request, response);

			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}else if (command.equals("/Delete.do")) {
			controller = new BoardDeleteController();
			nextPage = controller.requestHandler(request, response);

			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}else if (command.equals("/Edit.do")) {
			controller = new EditController();
			nextPage = controller.requestHandler(request, response);

			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}else if (command.equals("/Edit2.do")) {
			controller = new EditController2();
			nextPage = controller.requestHandler(request, response);

			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}else if (command.equals("/Answer.do")) {
			controller = new AnswerController();
			nextPage = controller.requestHandler(request, response);

			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}else if (command.equals("/Write.do")) {

			controller = new WriteController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);

		}else if (command.equals("/Write2.do")) {
			// 글쓰기 화면으로 전송
			controller = new WriteController2();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);

		}else if (command.equals("/WriteFile.do")) {

			controller = new WriteFileController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);

		}else if (command.equals("/Kakao.do")) {

			controller = new KakaoController();
			nextPage = controller.requestHandler(request, response);
			response.sendRedirect(nextPage);

		}else if (command.equals("/Delete2.do")) {
			controller = new BoardDelete2Controller();
			nextPage = controller.requestHandler(request, response);

			RequestDispatcher rd = request.getRequestDispatcher(nextPage);
			rd.forward(request, response);
		}

		else {

		}


	}

}