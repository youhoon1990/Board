package travel1.frontcontroller;

public class ControllerTest {
	


//	public static void main(String[] args) {
//		
//		int num = hap("901009");
//
//	}
	
	public int hap(String birth){
		String[] birthday;
		//birth = "901009";
		int hap = 0;
		birthday = birth.split("");
		
		for(int i=0; i<birthday.length; i++) {
			hap = hap + Integer.parseInt(birthday[i]);
		}
		System.out.println(birth.length());
		System.out.println(hap);
		
		
		return hap;
	}

}
