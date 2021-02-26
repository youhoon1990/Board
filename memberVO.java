package travel1.model;

public class memberVO {

	
	private int num;
	private String id;
	private String pass;
	private String birth;
	private String tel;
	private String day;
	private String name;
	
	
	


	public memberVO(String id, String pass, String birth, String tel, String name) {
		super();
		this.id = id;
		this.pass = pass;
		this.birth = birth;
		this.tel = tel;
		this.name = name;
	}


	public memberVO(int num, String id, String pass, String birth, String tel, String day, String name) {
		super();
		this.num = num;
		this.id = id;
		this.pass = pass;
		this.birth = birth;
		this.tel = tel;
		this.day = day;
		this.name = name;
	}


	public memberVO(String id) {
		super();
		this.id = id;
	}


	public int getNum() {
		return num;
	}


	public void setNum(int num) {
		this.num = num;
	}


	public String getId() {
		return id;
	}


	public void setId(String id) {
		this.id = id;
	}


	public String getPass() {
		return pass;
	}


	public void setPass(String pass) {
		this.pass = pass;
	}


	public String getBirth() {
		return birth;
	}


	public void setBirth(String birth) {
		this.birth = birth;
	}


	public String getTel() {
		return tel;
	}


	public void setTel(String tel) {
		this.tel = tel;
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
