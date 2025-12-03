package JDBCsessions;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.sql.Blob;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class ReteriveImage {
	
	public static final String DBURL = "jdbc:mysql://localhost:3306/person_img";
	public static final String USERNAME = "demo_user";
	public static final String PASSWORD = "demo_pass";
	
	public static final String SHOW = "select * from person_img.persondata3";

	public static void main(String[] args) throws SQLException, IOException {
Connection con = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
		
		PreparedStatement pstmt = con.prepareStatement(SHOW);
		
		ResultSet rs = pstmt.executeQuery();
		if(rs.next()== true) {
			
			Blob blob = rs.getBlob("image");
			InputStream is = blob.getBinaryStream();
			FileOutputStream fos = new FileOutputStream("C:\\Users\\rohit\\OneDrive\\Desktop\\Get Image\\getimg.webp");
			//byte[] buffer = new byte[1024];
			int by;
			while ((by=is.read())!=-1) {
				fos.write(by);
			}
		}
		System.out.println("image is retrieved in give path folder.......");
		
	}

}
