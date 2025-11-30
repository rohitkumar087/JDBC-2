package Ex1BatchOperation;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class Demo {
	private static final String DBURL = "jdbc:mysql://localhost:3306/data";
	private static final String DBUSERNAME = "demo_user";
	private static final String DBPASSWORD = "demo_pass";
	
	public static void main(String[] args) throws SQLException {
		
		Connection con = DriverManager.getConnection(DBURL,DBUSERNAME,DBPASSWORD);
		Statement stmt = con.createStatement();
		
		stmt.addBatch("insert into demo values(1,'Abhi','Karnataka')");
		stmt.addBatch("insert into demo values(2,'Subh','Goa')");
		stmt.addBatch("insert into demo values(1,'Kartik','Karnataka')");
		stmt.addBatch("insert into demo values(1,'Tarun','Rajasthan')");
		stmt.addBatch("insert into demo values(1,'Ronit','Mumbai')");
		
		int[] ss = stmt.executeBatch();

		System.out.println("Ras affected :"+ss.length);
		con.close();
		
		System.out.println("Execution commpleted!");
		con.close();
		
	}

}
