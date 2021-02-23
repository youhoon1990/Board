package travel1.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel1.controller.BoardDeleteController;
import travel1.controller.BoardListController;
import travel1.controller.CommentController;
import travel1.controller.ContentController;
import travel1.controller.Controller;
import travel1.controller.LogOutController;
import travel1.controller.LoginController;
import travel1.controller.LoginController2;
import travel1.controller.ManageController;
import travel1.controller.MemberInsertController;
import travel1.controller.MemberInsertController2;
import travel1.controller.SearchController;
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

		}else if (command.equals("/Write.do")) {

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
		}

		else {

		}
//	      else if (command.equals("/MemberInsert.do")) {
//
//	         controller= new MemberInsertController();
//	         nextPage=controller.requestHandler(request, response) ;
//	         response.sendRedirect(nextPage);
//	         
//	      } else if (command.equals("/memberDelete.do")) {
//	         
//	         controller= new MemberDeleteController();
//	         nextPage=controller.requestHandler(request, response) ;
//	            response.sendRedirect("/MVC2/MemberList.do");
//	            
//	      } else if (command.equals("/MemberContent.do")) {
//	         controller= new MemberContentController();
//	         nextPage=controller.requestHandler(request, response) ;
//	         RequestDispatcher rd = request.getRequestDispatcher(nextPage); //의뢰 = 객체 바인딩
//	         rd.forward(request, response);
//	         
//
//	      }else if (command.equals("/MemberUpdate.do")) {
//	         controller= new MemberUpdateController();
//	         nextPage=controller.requestHandler(request, response) ;
//	         
//	         
//	         response.sendRedirect(nextPage);
//	            //응답을   /web/memberList.do 에서 받도록 페이지를 바꾸는 작업을 해준 것
//	      }else if(command.equals("/MemberLoginForm.do")) {
//	         controller= new MemberLoginFormController();
//	         nextPage=controller.requestHandler(request, response) ;
//	         response.sendRedirect(nextPage);
//	      }else if(command.equals("/memberLogin.do")) {
//	         controller= new MemberLoginController();
//	         nextPage=controller.requestHandler(request, response) ;
//	         response.sendRedirect(nextPage);
//	         
//	      }

	}

}