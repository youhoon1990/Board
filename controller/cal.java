package travel1.controller;

import java.util.Calendar;

public class cal {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
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
	      
	      String num = dataSet; 
	      num = num.substring(0, 10);
	      System.out.println(num);
	      
	      
	}

}
