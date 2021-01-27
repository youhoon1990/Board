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

//	public ArrayList<memberVO> idCheck(memberVO vo) {
//		getConnetct();
//		String SQL = "select * from trmember where id=?";
//		
//		ArrayList<memberVO> list = new ArrayList<memberVO>();
//		try {
//	         ps = conn.prepareStatement(SQL);
//	         ps.setString(1, vo.getId());
//	         rs = ps.executeQuery();
//	         while (rs.next()) {
//	            
//	            
//	            String id = rs.getString("id");
//	            memberVO vo1 = new memberVO(id);
//	            
//	            list.add(vo1);
//	            
//	         }
//	      } catch (Exception e) {
//	         e.printStackTrace();
//	      } finally {
//	         dbClose();
//	      }
//		return list;
//	}

	public boolean idCheck(memberVO vo) {
		getConnetct();
		String SQL = "select * from trmember where id=?";
		boolean tf = false;
		
		try {
	         ps = conn.prepareStatement(SQL);
	         ps.setString(1, vo.getId());
	         rs = ps.executeQuery();
	         if (rs.next()) {
	            tf =  true;
	           

	           
	            
	         }else {
	        	 tf =  false;
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         dbClose();
	      }
		return tf;
	}

	public memberVO ContentList(String id) {
		getConnetct();
		String SQL = "select content from board where id=?";
		boolean tf = false;
		
		try {
	         ps = conn.prepareStatement(SQL);
	         ps.setString(1, id);
	         rs = ps.executeQuery();
	         if (rs.next()) {
	            tf =  true;
	           

	           
	            
	         }else {
	        	 tf =  false;
	         }
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         dbClose();
	      }
		return null;
	}

	public int memberInsert(memberVO vo) {
		getConnetct();
		String SQL = "insert into trmember values( mem_seq.nextval, ?, ?, ?, ?,sysdate,?)";
		int cnt = 0;
		try {
	         ps = conn.prepareStatement(SQL);
	         ps.setString(1, vo.getId());
	         ps.setString(2, vo.getPass());
	         ps.setString(3, vo.getBirth());
	         ps.setString(4, vo.getTel());
	         ps.setString(5, vo.getName());
	         
	         System.out.println(vo.getId());
	         System.out.println(vo.getPass());
	         System.out.println(vo.getBirth());
	         System.out.println(vo.getTel());
	         System.out.println(vo.getName());
	         cnt = ps.executeUpdate();
	         
	      } catch (Exception e) {
	         e.printStackTrace();
	      } finally {
	         dbClose();
	      }
		return cnt;
	}


}
