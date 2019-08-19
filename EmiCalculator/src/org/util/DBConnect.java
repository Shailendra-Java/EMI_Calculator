package org.util;
import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnect {
	private static Connection con = null;
	
	public static Connection getConnection() {
		try {
			Class.forName("org.h2.Driver");
			con = DriverManager.getConnection("jdbc:h2:~/bank;AUTO_SERVER=TRUE", "system", "123");
		}catch(Exception exception) {
			exception.printStackTrace();
		}
		return con;
	}
}
