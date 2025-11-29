package PreparedStmt;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;



public class Test {
	public static final String DBURL = "jdbc:mysql://localhost:3306/data";
	public static final String USERNAME = "demo_user";
	public static final String PASSWORD = "demo_pass";
	
	public static final String INSERT = "insert into demo values(?,?,?)";
	
	public static void main(String[] args) throws SQLException {
		Connection con = DriverManager.getConnection(DBURL, USERNAME, PASSWORD);
		PreparedStatement pstmt = con.prepareStatement(INSERT);
		
		System.out.println("Enter details :- ");
		Scanner sc = new Scanner(System.in);
		
		System.out.println("Enter id : ");
		int id = sc.nextInt();
		
		System.out.println("Enter name : ");
		sc.next();
		String name = sc.nextLine();
		
		System.out.println("Enter city : ");
		String city = sc.nextLine();
		
		pstmt.setInt(1, id);
		pstmt.setString(2, name);
		pstmt.setString(3, city);
		
		int rowaffected = pstmt.executeUpdate();
		
		System.out.println("rows affected : "+rowaffected);
		
		con.close();
		
	}
}
