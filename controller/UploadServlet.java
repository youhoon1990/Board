package travel1.controller;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.oreilly.servlet.MultipartRequest;
import com.oreilly.servlet.multipart.DefaultFileRenamePolicy;


@WebServlet("/upload.do")
public class UploadServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       

    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }


	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		response.setContentType("text/html; charset=UTF-8");
		PrintWriter out = response.getWriter();
		
		String savePath ="upload";
		int uploadFileSizeLimit = 5*1024*1024;
		String encType="UTF-8";
		
		ServletContext context = getServletContext();
		String uploadFilePath = context.getRealPath(savePath);
		System.out.println("�������� ���� ���丮");
		System.out.println(uploadFilePath);
		
		try {
			
			MultipartRequest multi = new MultipartRequest(
					request,
					uploadFilePath,
					uploadFileSizeLimit,
					encType,
					new DefaultFileRenamePolicy());
					
			String fileName = multi.getFilesystemName("uploadFile");
			
			if(fileName ==null) {
				System.out.println("������ ���ε� ���� �ʾ���");
			}else {
				out.print("<br> �۾��� : " + multi.getParameter("name"));
				out.print("<br> �� &nbsp; �� : " + multi.getParameter("title"));
				
			}
					
			System.out.println("���� �޾���");
			
		} catch (Exception e) {
			System.out.println("���� �߻� : "+e);
		}
	}

}

/*  jsp�� �־��ָ� �Ǵ� ��
 * <form action="/travel1/upload.do" method="post" enctype="multipart/form-data">
                       			<input type = "file" name = "uploadFile"><br>
                       			<input type="submit" value="����">
                       			
                       		</form>
                       		<br>
 * */
