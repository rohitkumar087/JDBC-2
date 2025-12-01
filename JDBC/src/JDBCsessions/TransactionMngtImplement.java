package JDBCsessions;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class TransactionMngtImplement {

	
		public static final String DBURL = "jdbc:mysql://localhost:3306/transaction";
		public static final String USERNAME = "demo_user";
		public static final String PASSWORD = "demo_pass";
		
		public static final String INSERT = "insert into data values(?,?,?)";
		
		public static void main(String[] args) throws SQLException {
			
			Connection con = DriverManager.getConnection(DBURL,USERNAME,PASSWORD);
			
			try {
				PreparedStatement pstmt = con.prepareStatement(INSERT);
				
				con.setAutoCommit(false);
				
				pstmt.setInt(1, 101);
				pstmt.setString(2, "Rohit Kumar");
				pstmt.setString(3, "Ratangarh");
				
				pstmt.executeUpdate();
				
				con.commit();
				
				System.out.println("Data successfully inserted.....");
			}
			catch(Exception e) {
				System.out.println("Transaction rollback.....");
			}
			
			con.close();
		}

	}


}
