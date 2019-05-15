package com.barmgn.www;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DBConnection {
	// DBConnection Master Class

	private DBConnection() {
	}

//	public static Connection dbConn;
	private static DBConnection db = new DBConnection();

	public static DBConnection getInstance() {
		return db;
	}

	private Connection getConnection() {
		String url = "jdbc:oracle:thin:@localhost:1521:XE";	// url : db����
		String user = "ksy";	// ����
		String password = "ksy";
		String driver = "oracle.jdbc.driver.OracleDriver";
		Connection conn = null;
		
		try {
			// �ݵ�� �ε����
			Class.forName(driver);
			conn = DriverManager.getConnection(url, user, password);
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return conn;
	}

	// Bring data on DB to JAVA

	public ArrayList<Product> select() {
		ArrayList<Product> list = new ArrayList<>();

		Connection conn = null; // session statement
		PreparedStatement pstm = null; // sql sentence.
		// Statement : Sending Interface.
		// PreparedStatement : Same as Statement. Moving query order.
		ResultSet rs = null; // receive query data
		String quary = "SELECT * FROM b_product";
		
		try {
			conn = getConnection(); // Connection Statement
			pstm = conn.prepareStatement(quary); // Send query for DB			
			rs = pstm.executeQuery(); // Result

			while (rs.next()) {

				Product p = new Product();
				p.setPno(rs.getInt("pno"));
				p.setPname(rs.getString("pname"));
				p.setPrice(rs.getInt("price"));
				p.setCategory(rs.getString("category"));
				p.setDetail(rs.getString("detail"));
            	p.setImage(rs.getBlob("image"));
				list.add(p);
			}
			

		} catch (SQLException sqle) {
			System.out.println("no result");
			sqle.printStackTrace();

		} finally {
			// Close connection
			dbClose(conn, pstm, rs);

		}
		return list;
	}

	public ArrayList<Product> selectPno(String pname) {
		ArrayList<Product> list = new ArrayList<>();

		Connection conn = null; // session statement
		PreparedStatement pstm = null; // sql sentence.
		// Statement : Sending Interface.
		// PreparedStatement : Same as Statement. Moving query order.
		ResultSet rs = null; // receive query data
		String quary = "SELECT pno FROM b_product WHERE pname=?";
		
		try {
			conn = getConnection(); // Connection Statement
			pstm = conn.prepareStatement(quary); // Send query for DB			
			pstm.setString(1, pname);
			
			rs = pstm.executeQuery(); // Result

			while (rs.next()) {

				Product p = new Product();
				p.setPno(rs.getInt("pno"));
//				p.setPname(rs.getString("pname"));
//				p.setPrice(rs.getInt("price"));
//				p.setCategory(rs.getString("category"));
//				p.setDetail(rs.getString("detail"));
//            	p.setImage(rs.getBlob("image"));
				list.add(p);
			}
			

		} catch (SQLException sqle) {
			System.out.println("no result");
			sqle.printStackTrace();

		} finally {
			// Close connection
			dbClose(conn, pstm, rs);

		}
		return list;
	}
	
	public void insert(Order order) {
		// �ݵ�� NULL ������ �־�����Ѵ�.
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO b_order VALUES(?,?,?,?,?,?,?,?)";

		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, order.getOrdnum()); // java > sql �� �Է½� int ������ �ֱ�
			ps.setDate(2, order.getC_date()); // java > sql �� �Է½� String ������ �ֱ�
			ps.setInt(3, order.getTno());
			ps.setInt(4, order.getPno());
			ps.setString(5, order.getPname());
			ps.setInt(6, order.getPrice());
			ps.setInt(7, order.getQuantity());
			ps.setInt(8, order.getTot_sales());
			
//			System.out.println(order.toString());
			
			int n = ps.executeUpdate(); 

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, ps);
		}
	}

	public void update(Order order) {
		// �ݵ�� NULL ������ �־�����Ѵ�.
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE b_order SET pname=?, dept=? WHERE ordnum=?";

		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
//			ps.setString(1, s.getName());	// java > sql �� �Է½� String ������ �ֱ�
//			ps.setString(2, s.getDept());
//			ps.setInt(3, s.getSno());

			int n = ps.executeUpdate(); // n �� �ԷµǴ� ���� ���� �Է��̳� ����, ������ ������ ��ȯ����

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, ps);
		}
	}

	public void delete(Stock stock) {
		// �ݵ�� NULL ������ �־�����Ѵ�.
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM b_order WHERE ordnum=?";

		try {
			conn = getConnection();
			ps = conn.prepareStatement(sql);
//			ps.setInt(1, no);

			ps.executeQuery();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			dbClose(conn, ps);
		}
	}

	private void dbClose(Connection conn, PreparedStatement pstm, ResultSet rs) {
		try {
			if (rs != null)
				rs.close();
			if (pstm != null)
				pstm.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private void dbClose(Connection conn, PreparedStatement pstm) {
		try {
			if (pstm != null)
				pstm.close();
			if (conn != null)
				conn.close();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}