package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DbConn {
	static public Connection getConnection()
	{
		Connection conn=null;
		String url="jdbc:oracle:thin:@localhost:1521:xe";
		String id="game";
		String pw="1234";
		String driver="oracle.jdbc.driver.OracleDriver";

//		 Class.forName("oracle.jdbc.driver.OracleDriver");
	
		try {
			Class.forName(driver);
			conn=DriverManager.getConnection(url, id, pw);
			
			System.out.println("DB에 연결 완료");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return conn;
	}
	
	static public void close(Connection conn, PreparedStatement ps, ResultSet rs)
	{
		try {
			if(rs!=null)	rs.close();
			if(ps!=null)	ps.close();
			if(conn!=null)	conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	static public void close(Connection conn, PreparedStatement ps)
	{
		try {
			if(ps!=null)	ps.close();
			if(conn!=null)	conn.close();
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
