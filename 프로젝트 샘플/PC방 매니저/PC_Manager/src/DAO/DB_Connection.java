package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DB_Connection {
	public static Connection getConnection() {
		Connection conn = null;

		String url = "jdbc:oracle:thin:@192.168.0.38:1521:xe";
		String user = "PC_MANAGER";
		String pw = "1234";
		String driver = "oracle.jdbc.driver.OracleDriver";

		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, pw);
		} catch (Exception e) {

			e.printStackTrace();
		}
		return conn;
	}

	public static void close(Connection c, PreparedStatement p) {

		try {
			if (c != null)
				c.close();
			if (p != null)
				p.close();

		} catch (SQLException e) {

			e.printStackTrace();
		}

	}

	public static void close(Connection c, PreparedStatement p, ResultSet r) {

		try {
			if (c != null)
				c.close();
			if (p != null)
				p.close();
			if (r != null)
				r.close();
		} catch (SQLException e) {

			e.printStackTrace();
		}

	}
}
