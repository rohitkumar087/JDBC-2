package JDBCsessions;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertImageIntoDtbs {
	public static final String DBURL = "jdbc:mysql://localhost:3306/person_img";
	public static final String USERNAME = "demo_user";
	public static final String PASSWORD = "demo_pass";
	
	public static final String INSERT = "insert into Persondata3 values(?,?,?)";
	public static void main(String[] args) throws SQLException, IOException {
		Connection con = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
		
		PreparedStatement pstmt = con.prepareStatement(INSERT);
		pstmt.setInt(1, 101);
		pstmt.setString(2, "Rohit Kumar");
		
		FileInputStream fis = new FileInputStream("C:\\Users\\rohit\\OneDrive\\Desktop\\MyImage.webp");
		pstmt.setBinaryStream(3, fis,fis.available());
		int r = pstmt.executeUpdate();
		System.out.println(r);
		
	}

}
