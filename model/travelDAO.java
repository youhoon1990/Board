package travel1.model;

import java.sql.*;
import java.util.ArrayList;
import java.util.Calendar;

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
		
			Calendar cd = Calendar.getInstance();
		      int hour = cd.get(cd.HOUR_OF_DAY);
		      int min = cd.get(cd.MINUTE);
		      int sec = cd.get(cd.SECOND);

		      int year = cd.get(cd.YEAR);
		      int month = cd.get(cd.MONTH) + 1;
		      
		      String change_month = "";

		      if (month < 10) {
		         change_month = "0" + month;
		      } else {
		         change_month += month;
		      }

		      int date = cd.get(cd.DATE);
		      String dataSet = year + "-" + change_month + "-" 
		      + date;
		      
		      String today = dataSet; 
		      today = today.substring(0, 10);
		      
		
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
				String day2 = day.substring(0,10);
				if(day2.equals(today)) {
					day = day.substring(11, 16);
				}else {
					day = day2;
				}
				
				int click = rs.getInt("click");
				int rec = rs.getInt("rec");

				boardVO vo = new boardVO(num, title, name, day, click, rec);
//	            
				list.add(vo);

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
				tf = true;

			} else {
				tf = false;
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return tf;
	}

	public boardVO ContentList(String num) {
		getConnetct();
		String SQL = "select * from board where num=?";
		boardVO vo = null;

		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, num);
			rs = ps.executeQuery();
			if (rs.next()) {

				String title = rs.getString("title");
				String name = rs.getString("name");
				String day = rs.getString("day");
				int click = rs.getInt("click");
				int rec = rs.getInt("rec");
				String content = rs.getString("content");
				vo = new boardVO(Integer.parseInt(num), title, name, day, click, rec, content);

			} else {

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return vo;
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

	public boolean isLogin(String id, String pass) {
		getConnetct();
		String SQL = "select id from trmember where id=? and pass=? ";
		boolean succ = false;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, id);
			ps.setString(2, pass);
			rs = ps.executeQuery();
			if (rs.next()) {
				succ = true;
			} else {
				System.out.println("로그인 실패");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return succ;
	}
	
	
	//조회수 증가 밑 게시물 가져오기
	public ArrayList<CommentVO> CommentList(String num) {
		// int Click 도 받아와야함 getparameter로
		getConnetct();
		
		
		System.out.println("게시물 번호는 = "+ num);
		
		CommentVO vo1 = null;
		String SQL = "update board set click = ? where num=?";
		/*
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, 1);
			ps.setString(2, num);
			int cnt = ps.executeUpdate();
			if (cnt != 0) {
				System.out.println("조회수증가");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
		*/
		SQL = "select * from reply where boardnum=? order by groupno asc, groupod asc";

		// ArrayList<boardVO> list = new ArrayList<boardVO>();
		ArrayList<CommentVO> list = new ArrayList<CommentVO>();
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, num);
			rs = ps.executeQuery();

			while (rs.next()) {

				String name = rs.getString("name");
				String reply = rs.getString("reply");
				String day = rs.getString("day");

				vo1 = new CommentVO(reply, day, name);
				list.add(vo1);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}
		return list;
	}

	/*
	 * public ArrayList<CommentVO> CommentList(String num) { getConnetct(); String
	 * SQL =
	 * "select * from reply where boardnum=? order by groupno asc, groupod asc";
	 * CommentVO vo1 = null; //ArrayList<boardVO> list = new ArrayList<boardVO>();
	 * ArrayList<CommentVO> list = new ArrayList<CommentVO>(); try { ps =
	 * conn.prepareStatement(SQL); ps.setString(1, num); rs = ps.executeQuery();
	 * while (rs.next()) {
	 * 
	 * 
	 * String name = rs.getString("name"); String reply = rs.getString("reply");
	 * String day = rs.getString("day");
	 * 
	 * 
	 * 
	 * vo1 = new CommentVO(reply, day, name); list.add(vo1); } } catch (Exception e)
	 * { e.printStackTrace(); } finally { dbClose(); } return list; }
	 */

	public int CommentInsert(CommentVO list) {
		getConnetct();
		String SQL = "insert into reply values (cnum_seq.nextval, ?, ?, comment_seq.nextval, 0, sysdate, ?)";
		int cnt = 0;
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, list.getBoardnum());
			ps.setString(2, list.getReply());
			ps.setString(3, list.getName());

			cnt = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose();
		}

		return cnt;
	}

	public int pre(String num) {
		getConnetct();
		int pre = 0;
		String SQL = "select * from board order by groupno desc, groupod asc ";
		

		try {
			ps = conn.prepareStatement(SQL);
			rs = ps.executeQuery();
			while (rs.next()) {

				pre = rs.getInt("num");
				if(pre==Integer.parseInt(num)) {
					rs.next();
					pre=rs.getInt("num");
					break;
				}

			}
			
			System.out.println("이전 글 번호는 "+pre);
		} catch (Exception e) {
			e.printStackTrace();
			pre=0;
		} finally {
			dbClose();
		}
		return pre;
	}

	public ArrayList<boardVO> searchList(String category, String search) {
		
		Calendar cd = Calendar.getInstance();
	      int hour = cd.get(cd.HOUR_OF_DAY);
	      int min = cd.get(cd.MINUTE);
	      int sec = cd.get(cd.SECOND);

	      int year = cd.get(cd.YEAR);
	      int month = cd.get(cd.MONTH) + 1;
	      
	      String change_month = "";

	      if (month < 10) {
	         change_month = "0" + month;
	      } else {
	         change_month += month;
	      }

	      int date = cd.get(cd.DATE);
	      String dataSet = year + "-" + change_month + "-" 
	      + date;
	      
	      String today = dataSet; 
	      today = today.substring(0, 10);
	      
	
	getConnetct();
	System.out.println("연결됨");
	String theme = category;
	String SQL = "select * from board where "+theme +" like '%'||?||'%' order by groupno desc, groupod asc ";
	ArrayList<boardVO> list = new ArrayList<boardVO>();
	System.out.println("dao의 카테고리는="+theme+"공백없음");
	try {
		ps = conn.prepareStatement(SQL);
		//ps.setString(1, category);
		ps.setString(1, search);
		rs = ps.executeQuery();
		while (rs.next()) {

			int num = rs.getInt("num");
			String title = rs.getString("title");
			String name = rs.getString("name");
			String day = rs.getString("day");
			String day2 = day.substring(0,10);
			if(day2.equals(today)) {
				day = day.substring(11, 16);
			}else {
				day = day2;
			}
			
			int click = rs.getInt("click");
			int rec = rs.getInt("rec");

			boardVO vo = new boardVO(num, title, name, day, click, rec);
//            
			list.add(vo);

		}
	} catch (Exception e) {
		e.printStackTrace();
	} finally {
		dbClose();
	}
	return list;
}

	public void updateClick(String num) {
		getConnetct();
		int click = 0;

		
		
		System.out.println("게시물 번호는 = "+ num);
		
		
		String SQL = "select click from board where num=?";
		try {
			ps = conn.prepareStatement(SQL);
			ps.setString(1, num);
			rs = ps.executeQuery();
			while(rs.next()) {
				click = rs.getInt("click");
				System.out.println("조회성공, click은 ="+click);
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		click++;
		System.out.println("조회수 증가 ="+click);
		SQL = "update board set click = ? where num=?";
		try {
			ps = conn.prepareStatement(SQL);
			ps.setInt(1, click);
			ps.setString(2, num);
			int cnt = ps.executeUpdate();
			if (cnt != 0) {
				System.out.println("조회수증가");
			}

		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
