package srp.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		
		String jdbcUrl = "jdbc:mysql://localhost:3306/hb-01-one-to-one-uni?useSSL=false";
		String usrname = "hbstudent";
		String pwd = "hbstudent";	// sanity check passess
		try {
			System.out.println("Connecting to database" + jdbcUrl);
			
			Connection myConn = DriverManager.getConnection(jdbcUrl, usrname, pwd);
			
			System.out.println("Connection successful!");
		} catch (Exception e) {
			e.printStackTrace();
		}
			
		
	}

}
