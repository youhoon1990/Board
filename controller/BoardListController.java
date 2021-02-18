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
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		
		int temp = 0;
		int ten =1;  //10�ڸ��� ����
		int num = 0; //������������ ����Ʈ ����� ���� ����
		
		
		String pnum =request.getParameter("pnum");
		System.out.println("pnum�� = " + pnum);
		if(pnum==null) {
			num = 1;
			pnum = "1";	
		}else {
			
			num = Integer.parseInt(request.getParameter("pnum"));
			
		}	
		
		
		System.out.println("num�� = "+num);
		
		travelDAO dao = new travelDAO();
		ArrayList<boardVO> vo = dao.boardList();
		
		ArrayList<boardVO> vo1 = new ArrayList();
		System.out.println(vo.size());
		for(int i=(num-1)*20; i<(num-1)*20+20; i++) {
			
			try {
				vo1.add(vo.get(i)); //�̷��� �ϸ�  �ѰԽñ��� 21�� �����Ƿ� 2page ���鶧 out of bounds ��
				//System.out.println("�迭 "+i+"��° ����");
				
			} catch (Exception e) {
				//System.out.println("�迭 "+i+"��°�� ĳġ�����ο�");
				for(i=i; i<vo.size(); i++) {
					vo1.add(vo.get(i));
					//System.out.println("ĳġ���ȿ��� �迭�� �����");
				}
				break;
			}
		}
		request.setAttribute("pnum", num); //����������
		System.out.println("pnum�� �� �� = "+num);
		while(num!=0 ) {
			num = num/10;
			temp++;
		}
		
		for(int i=1; i<temp; i++) {
			ten = ten*10;
			
		}
				
		System.out.println("ten�� = "+ten);
		System.out.println("temp�� ="+temp);
		request.setAttribute("ten", ten);
		request.setAttribute("cnt", vo.size()/20+1); //�� ������
		//request.setAttribute("cnt", vo.size()); //�� ������
		//request.setAttribute("vo1", vo); // was�� �մ� data ���� 

		
		
		
		request.setAttribute("vo", vo1);  //
		return "member/BoardList.jsp";
	}

}
