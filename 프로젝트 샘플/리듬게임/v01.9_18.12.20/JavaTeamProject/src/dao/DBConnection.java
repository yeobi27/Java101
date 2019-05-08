package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBConnection {
	public static Connection getConnection() {
		Connection conn = null;
		String url = "jdbc:oracle:thin:@192.168.0.42:1521:xe"; // DB url
		String driver = "oracle.jdbc.driver.OracleDriver";
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(url, "nyp", "1234"); // DB연결
			System.out.println("DB 연결 성공 ...");
		} catch (Exception e) {
			System.out.println("DB 연결 실패 ...");
			e.printStackTrace();
		}
		return conn;
	}

	public static void Close(Connection conn, PreparedStatement ps) {
		try {
			if (conn != null)
				conn.close();
			if (ps != null)
				ps.close();
		} catch (Exception e) {
		}
	}

	public static void Close(Connection conn, PreparedStatement ps, ResultSet rs) {
		try {
			if (conn != null)
				conn.close();
			if (ps != null)
				ps.close();
			if (rs != null)
				rs.close();
		} catch (Exception e) {
		}
	}
}
