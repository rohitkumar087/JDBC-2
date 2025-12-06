package JDBCsessions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Scanner;

public class InsertDate {
	private static final String DBURL = "jdbc:mysql://localhost:3306/userdata"; 
	private static final String DBUSERNAME ="demo_user";  
	private static final String DBPASSWORD = "demo_pass";
	
	private static final String GET = "select * from info";
	
	public static void main(String[] args) throws ParseException, SQLException {
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter the Date : dd-mm-yyyy");
		String date = sc.next();
		
		SimpleDateFormat sd = new SimpleDateFormat("dd-MM-yyyy");
		java.util.Date udate = sd.parse(date);
		
		long sdate = udate.getTime();
		java.sql.Date currDate = new java.sql.Date(sdate);
		
		Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);
//		PreparedStatement pstmt = con.prepareStatement(INSERT);
		Statement stmt = con.createStatement();
		ResultSet rs = stmt.executeQuery(GET);
		
		while(rs.next()){
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getDate(3));
		}
		
//		pstmt.setInt(1, 101);
//		pstmt.setString(2, "Rohit");
//		pstmt.setDate(3, currDate);
//		
//		int rawAffected = pstmt.executeUpdate();
//		System.out.println(rawAffected);
		
		con.close();
		
		
		
	}
}
