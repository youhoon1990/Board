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
import com.google.gson.JsonObject;

import travel1.model.memberVO;
import travel1.model.travelDAO;

/**
 * Servlet implementation class IdCheck
 */
@WebServlet("/IdCheck")
public class IdCheck extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public IdCheck() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		  request.setCharacterEncoding("UTF-8");
	      response.setContentType("text/html; charset=UTF-8");
	      PrintWriter out = response.getWriter();
	      String id = request.getParameter("id");
	      System.out.println("¿äÃ»ÀÌ µé¾î¿È....");
	      System.out.println(id);
	      /*
	       * out.print(num); out.print("Á¦ÀÌÄõ¸®");
	       */
	      travelDAO dao = new travelDAO();
	      memberVO vo = new memberVO(id);
	      boolean tf = dao.idCheck(vo);
	      
	      if(tf==true) {
	    	  System.out.println("true");
	      }else {
	    	  System.out.println("false");

	      }
	      
	      Gson gson = new Gson();
	      JsonObject jsonObj = new JsonObject();
	      jsonObj.addProperty("boolean", tf);
	      String json = gson.toJson(jsonObj);
	      
//	      jsonObj.addProperty("str", "j-query");
//	      System.out.println(jsonObj.toString());
//
//	      String data = "{\"num\":1234, \"str\":\"jquery\" }";
	      out.print(json);

	   }

}
