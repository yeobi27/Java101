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

	public Connection getConnection() {
		Connection conn = null;
		try {
			String user = "ksy";
			String pw = "ksy";
			String url = "jdbc:oracle:thin:@192.168.0.78:1521:xe";
			// IP address, port number, DBname (default : orcl)

			Class.forName("oracle.jdbc.driver.OracleDriver");
			// Loading JDBC Driver(ojdbc6.jar)
			conn = DriverManager.getConnection(url, user, pw);

			System.out.println("Now you connected Db.\n");

		} catch (Exception e) { // Fail Loading
			e.printStackTrace();
		}
		return conn;
	}

	// Bring data on DB to JAVA

	public ArrayList<Product> select(Product product) {
		ArrayList<Product> list = new ArrayList<Product>();

		Connection conn = null; // session statement
		PreparedStatement pstm = null; // sql sentence.
		// Statement : Sending Interface.
		// PreparedStatement : Same as Statement. Moving query order.
		ResultSet rs = null; // receive query data

		try {
			String quary = "SELECT pname, price FROM b_product WHERE pname=? and price=?";

			conn = getConnection(); // Connection Statement
			pstm = conn.prepareStatement(quary); // Send query for DB
			pstm.setString(1, product.getPname());	// java > sql �� �Է½� int ������ �ֱ� 
			pstm.setInt(2, product.getPrice());	// java > sql �� �Է½� String ������ �ֱ�
			
			rs = pstm.executeQuery(); // Result

			while (rs.next()) {

				Product p = new Product();
				p.setPno(rs.getInt("pno"));
				p.setPname(rs.getString("pname"));
				p.setPrice(rs.getInt("price"));
//            p.setCategory(rs.getString("category"));
//            p.setDetail(rs.getString("detail"));
//            p.setImage(rs.getString("image"));
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
			ps.setString(2, order.getC_date()); // java > sql �� �Է½� String ������ �ֱ�
			ps.setInt(3, order.getTno());
			ps.setInt(4, order.getPno());
			ps.setString(5, order.getPname());
			ps.setInt(6, order.getPrice());
			ps.setInt(7, order.getQuantity());
			ps.setInt(8, order.getTot_sales());

			int n = ps.executeUpdate(); // n �� �ԷµǴ� ���� ���� �Է��̳� ����, ������ ������ ��ȯ����

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