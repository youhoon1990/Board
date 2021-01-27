package travel1.frontcontroller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel1.controller.BoardListController;
import travel1.controller.ContentController;
import travel1.controller.Controller;
import travel1.controller.MemberInsertController;
import travel1.controller.MemberInsertController2;
import travel1.model.travelDAO;


@WebServlet("*.do")
public class allController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String reqPath = request.getRequestURI();
	      // System.out.println(reqPath);
	      String contextPath = request.getContextPath();
	      // System.out.println(contextPath);
	      String command = reqPath.substring(contextPath.length());
	      // client�� ��û(command) command ����?�� ���⼭ ����
	      System.out.println(command);
	      // ��û�� ���� ó��(�б� �۾��̶�� �θ�)
	      Controller controller =null;
	      String nextPage = null;
	      travelDAO dao = new travelDAO();
	      if (command.equals("/Board.do")) {
	         controller = new BoardListController();
	         nextPage=controller.requestHandler(request, response) ;

	         RequestDispatcher rd = request.getRequestDispatcher(nextPage);
	         rd.forward(request, response);
			} else if (command.equals("/MemberInsert.do")) {

				controller = new MemberInsertController();
				nextPage = controller.requestHandler(request, response);
				response.sendRedirect(nextPage);

			}else if (command.equals("/MemberInsert2.do")) {

				controller = new MemberInsertController2();
				nextPage = controller.requestHandler(request, response);
				response.sendRedirect(nextPage);

			}else if(command.equals("/Content.do")) {
		         controller = new ContentController();
		         nextPage=controller.requestHandler(request, response) ;

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
//	         RequestDispatcher rd = request.getRequestDispatcher(nextPage); //�Ƿ� = ��ü ���ε�
//	         rd.forward(request, response);
//	         
//
//	      }else if (command.equals("/MemberUpdate.do")) {
//	         controller= new MemberUpdateController();
//	         nextPage=controller.requestHandler(request, response) ;
//	         
//	         
//	         response.sendRedirect(nextPage);
//	            //������   /web/memberList.do ���� �޵��� �������� �ٲٴ� �۾��� ���� ��
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