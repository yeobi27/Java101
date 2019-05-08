package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.Computer;
import DTO.PC_In_Use;

public class ComputerDAO {
	private ComputerDAO() {
	}

	private static ComputerDAO instance = new ComputerDAO();

	public static ComputerDAO getInstance() {
		return instance;
	}

	public int insertCom(String input_ip, int input_port) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO computer (NO,Ip,port)VALUES(computer_SEQ.NEXTVAL,?,?)";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, input_ip);
			ps.setInt(2, input_port);
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}
		return n;
	}

	public int deleteCom(int no) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM computer WHERE no=?";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			n = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}
		return n;
	}

	public int updateCom(int no, int col, String update) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "";
		System.out.println(no);
		System.out.println(col);
		System.out.println(update);
		switch (col) {
		case 1:
			sql = "UPDATE computer SET ip=? WHERE  no=? ";
			break;
		case 2:
			sql = "UPDATE computer SET port=? WHERE  no=? ";
			break;
		case 4:
			sql = "UPDATE computer SET status=? WHERE  no=? ";
			break;
		}
		System.out.println("1" + sql);
		if (!sql.equals("")) {
			try {
				conn = DB_Connection.getConnection();
				ps = conn.prepareStatement(sql);
				ps.setString(1, update);
				ps.setInt(2, no);
				n = ps.executeUpdate();
			} catch (Exception e) {
				e.printStackTrace();
			} finally {
				DB_Connection.close(conn, ps);
			}
		}
		return n;
	}

	public int searchPort(String ip) {
		int port = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT port FROM computer WHERE ip=?";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ip);
			rs = ps.executeQuery();
			if (rs.next()) {
				port = rs.getInt("port");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}
		return port;
	}

	public String searchIp(int no) {
		String ip = "";
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT ip FROM computer WHERE no=?";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if (rs.next()) {
				ip = rs.getString("ip");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}
		return ip;
	}

	public int searchPort(int no) {
		int port = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT port FROM computer WHERE no=?";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if (rs.next()) {
				port = rs.getInt("port");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}
		return port;
	}

	public int searchCom(String ip) {
		int no = 0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT no FROM computer WHERE ip=?";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, ip);
			rs = ps.executeQuery();
			if (rs.next()) {
				no = rs.getInt("no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}
		return no;
	}

	public ArrayList<Computer> selectAll() {
		ArrayList<Computer> list = new ArrayList<Computer>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM computer ORDER BY no";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Computer tmp = new Computer();
				tmp.setNo(rs.getInt("no"));
				tmp.setIp(rs.getString("ip"));
				tmp.setPort(rs.getInt("port"));
				tmp.setPurchase_date(rs.getString("purchase_date"));
				tmp.setStatus(rs.getString("status"));
				list.add(tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}

		return list;
	}

}
