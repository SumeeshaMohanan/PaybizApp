package com.obsqura.utilities;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtility {

	
	
	public void getCurrenDate() {
		DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy ");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);
		 
		 // Print the Date
		 System.out.println(date1);
	}
	
	
	public void getDateTime() {
		// Create object of SimpleDateFormat class and decide the format
		 DateFormat dateFormat = new SimpleDateFormat("MM/dd/yyyy HH:mm:ss");
		 
		 //get current date time with Date()
		 Date date = new Date();
		 
		 // Now format the date
		 String date1= dateFormat.format(date);

		 // Print the Date
		 System.out.println("Current date and time is " +date1);
	}
	
	public void getDateonly() {
		// here we are only capturing current date, which you can use for your automated scripts.
				DateFormat dateFormat = new SimpleDateFormat("dd");
				 
				 //get current date time with Date()
				 Date date = new Date();
				 
				 // Now format the date
				 String date1= dateFormat.format(date);
				 
				 System.out.println(date1);
	}
}
