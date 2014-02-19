package com.omr.image.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;

public class DatabaseFactory {
	public static Connection createConnection() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection conn = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/omr", "root", "root");
			return conn;
		} catch (ClassNotFoundException | SQLException e) {
			throw new MySQLConnectionFailed(e.getMessage());
		}
	}

	public static void insertRecord(String field, String values) {
		Statement statement = null;
		String insertTableSQL = "INSERT INTO test"
				+ "(rollnum, l1,l2,l3,l4,l5,l6,l7,l8,l9,10) " + "VALUES"
				+ "("+ createInsertString(values) +")";
		System.out.println(insertTableSQL);
		Connection conn = createConnection();
		try {
			statement = conn.createStatement();
			statement.executeUpdate(insertTableSQL);
		} catch (SQLException e) {
			throw new MySQLConnectionFailed(e.getMessage());
		} finally {
			try {
				statement.close();
				conn.close();
			} catch (SQLException e) {
				throw new MySQLConnectionFailed(e.getMessage());
			}

		}
	}
	
	public static String createInsertString(String values){
		String[] lectures = values.split(" ");
		String result = "1";
		for(int loop = 0; loop < lectures.length; loop++) {
			result += "," + lectures[loop];  
		}
		return result;
	}

	public static class MySQLConnectionFailed extends RuntimeException {
		public MySQLConnectionFailed(String message) {
			super(message);
		}

		private static final long serialVersionUID = 1L;
	}
}
