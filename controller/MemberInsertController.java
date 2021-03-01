package travel1.controller;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import travel1.model.boardVO;
import travel1.model.travelDAO;

public class MemberInsertController implements Controller{
	@Override
	public String requestHandler(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
				
		return "member/MemberInsert.jsp";
	}

}
