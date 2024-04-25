package com.sathya;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class dbconnection {
	public static Connection createConnection() {
	    Connection connection=null;
	    try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			connection=DriverManager.getConnection("jdbc:oracle:thin:@Localhost:1521:xe","rajes","welcome");

		} catch (ClassNotFoundException  | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	    	return connection;
	    
		}

}
