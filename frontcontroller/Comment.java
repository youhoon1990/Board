package travel1.frontcontroller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import travel1.model.CommentVO;
import travel1.model.boardVO;
import travel1.model.travelDAO;

@WebServlet("/Comment")
public class Comment extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public Comment() {
		super();
		// TODO Auto-generated constructor stub
	}

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		PrintWriter out = response.getWriter();

		String num = request.getParameter("num");
		System.out.println("현재 게시글 번호는 "+num);

		travelDAO dao = new travelDAO();

		// 댓글 가지고 오기
		ArrayList<CommentVO> vo1 = dao.CommentList(num);

		System.out.println(vo1.size());
		request.setAttribute("vo1", vo1);

		Gson gson = new Gson();
		String list1 = gson.toJson(vo1);
		System.out.println("들어오니...."+list1);
		out.print(list1);
	}

}
