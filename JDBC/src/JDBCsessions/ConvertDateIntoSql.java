package JDBCsessions;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class ConvertDateIntoSql {

	public static void main(String[] args) throws ParseException {
		// Read the Unput form the user
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the date : (dd-mm-yyyy)");
		String sdate =  sc.next();
		
		// Convert the date from String to java.util.Date [Intermediate]
		SimpleDateFormat sdf = new SimpleDateFormat("dd-mm-yyyy"); // Here we define our specific date format 
		java.util.Date udate = sdf.parse(sdate);
		
		// Convert java.util.Data to java.sql.Date
		long value = udate.getTime();
		java.sql.Date date = new java.sql.Date(value);
		
		// Print all Date type 
		System.out.println(sdate);
		System.out.println(udate);
		System.out.println(date);
		
	}

}
