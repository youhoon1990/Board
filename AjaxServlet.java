package travel1.frontcontroller;


import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.google.gson.JsonObject;
//import com.google.gson.*;


/**
 * Servlet implementation class AjaxServlet
 */
@WebServlet("/AjaxServlet")
public class AjaxServlet extends HttpServlet {
   private static final long serialVersionUID = 1L;

   public AjaxServlet() {
      super();
   }

   /**
 *
 */
protected void service(HttpServletRequest request, HttpServletResponse response)
         throws ServletException, IOException {
	  request.setCharacterEncoding("UTF-8");
      response.setContentType("text/html; charset=UTF-8");
      PrintWriter out = response.getWriter();
      String num = request.getParameter("num");
      System.out.println("¿äÃ»ÀÌ µé¾î¿È....");
      System.out.println(num);
      /*
       * out.print(num); out.print("Á¦ÀÌÄõ¸®");
       */

      JsonObject jsonObj = new JsonObject();
      jsonObj.addProperty("num", 1234);
      jsonObj.addProperty("str", "j-query");
      System.out.println(jsonObj.toString());

      String data = "{\"num\":1234, \"str\":\"jquery\" }";
      out.print(data);

   }

}