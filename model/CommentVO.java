package travel1.model;

public class CommentVO {

	private int num;
	private int boardnum;
	private String reply;
	private int groupno;
	private int groupod;
	private String day;
	private String name;
	
	
	public CommentVO(int boardnum) {
		super();
		this.boardnum = boardnum;
	}

	public CommentVO(String reply, String day) {
		super();
		this.reply = reply;
		this.day = day;
	}
	
	

	public CommentVO(String reply, String day, String name) {
		super();
		this.reply = reply;
		this.day = day;
		this.name = name;
	}

	public CommentVO(int boardnum, String reply, String name) {
		super();
		this.boardnum = boardnum;
		this.reply = reply;
		this.name = name;
	}

	public int getNum() {
		return num;
	}

	public void setNum(int num) {
		this.num = num;
	}

	public int getBoardnum() {
		return boardnum;
	}

	public void setBoardnum(int boardnum) {
		this.boardnum = boardnum;
	}

	public String getReply() {
		return reply;
	}

	public void setReply(String reply) {
		this.reply = reply;
	}

	public int getGroupno() {
		return groupno;
	}

	public void setGroupno(int groupno) {
		this.groupno = groupno;
	}

	public int getGroupod() {
		return groupod;
	}

	public void setGroupod(int groupod) {
		this.groupod = groupod;
	}

	public String getDay() {
		return day;
	}

	public void setDay(String day) {
		this.day = day;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	

	
}
