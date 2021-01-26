package travel1.model;

import java.sql.*;
import java.util.ArrayList;
public class travelDAO {
	  private Connection conn;
	   private PreparedStatement ps;
	   private ResultSet rs;

	   private void getConnetct() {
	      String URL = "jdbc:oracle:thin:@localhost:1521:XE";
	      String user = "hr";
	      String password = "hr";

	      try {
	         Class.forName("oracle.jdbc.driver.OracleDriver");
	         // 동적로딩 왜 하는가?

	         conn = DriverManager.getConnection(URL, user, password);
	      } catch (ClassNotFoundException | SQLException e) {

	         e.printStackTrace();
	      }

	   }

	   private void dbClose() {
	      try {

	         if (rs != null)
	            rs.close();
	         if (ps != null)
	            ps.close();
	         if (conn != null)
	            conn.close();

	      } catch (Exception e) {
	         e.printStackTrace();
	      }
	   }

	public ArrayList<boardVO> boardList() {
		getConnetct();
		System.out.println("연결됨");
		String SQL = "select * from board order by groupno desc, groupod asc ";
		ArrayList<boardVO> list = new ArrayList<boardVO>();
		
		try {
	         ps = conn.prepareStatement(SQL);
	         rs = ps.executeQuery();
	         while (rs.next()) {
	            
	            int num = rs.getInt("num");
	            String title = rs.getString("title");
	            String name = rs.getString("name");
	            String day = rs.getString("day");
	            int click = rs.getInt("click");
	            int rec = rs.getInt("rec");
	            
	            boardVO vo = new boardVO(num, title, name, day, click, rec);
//	            
	            list.add(vo);
	            System.out.println(title);
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         dbClose();
	      }
	      return list;
	   }

}
