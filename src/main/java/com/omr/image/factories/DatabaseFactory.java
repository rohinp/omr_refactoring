package com.omr.image.factories;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import java.sql.Statement;

public class DatabaseFactory {
	private static int counter = 1;

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
				+ "(rollnum, l1,l2,l3,l4,l5,l6,l7,l8,l9,l10) " + "VALUES" + "("
				+ createInsertString(values) + ")";
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

	public static String createInsertString(String values) {
		String[] lecturesAttended = values.split(" ");
		int[] lecturesTotal = new int[10];
		String result = "" + counter ++;
		for (int attended = 0; attended < lecturesAttended.length; attended++) {
			int lectureNum = Integer.parseInt(lecturesAttended[attended]);
			for (int loop = 0; loop < 10; loop++) {
				if(loop == lectureNum)
					lecturesTotal[loop] = 1;
				else
					lecturesTotal[loop] = 0;
			}
		}
		for(int a : lecturesTotal)
			result += "," + a;
		return result;
	}

	public static class MySQLConnectionFailed extends RuntimeException {
		public MySQLConnectionFailed(String message) {
			super(message);
		}

		private static final long serialVersionUID = 1L;
	}
}
