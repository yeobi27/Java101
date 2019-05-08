package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import javax.swing.JOptionPane;

import DTO.PC_In_Use;
import DTO.PC_In_Use_View;
import DTO.PC_Used_View;

public class PC_In_UseDAO {
	private PC_In_UseDAO() {
	}

	private static PC_In_UseDAO instance = new PC_In_UseDAO();

	public static PC_In_UseDAO getInstance() {
		return instance;
	}
	public int getTime(int no,String id) {
		int time=0;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT p_time FROM PC_IN_USE WHERE id=? AND c_no=?";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			ps.setInt(2, no);
			rs = ps.executeQuery();
			if (rs.next()) {
				time=rs.getInt("p_time");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}

		return time;
	}
	public int DonePc_in_use(int no, int time, int price) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE (SELECT * FROM pc_in_use WHERE status='USE') SET status='DONE',P_TIME=? ,s_price=? WHERE  c_no=? ";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, time);
			ps.setInt(2, price);
			ps.setInt(3, no);
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}
		return n;
	}
	public int WaitPc_in_use(int no, int time, int price) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE (SELECT * FROM pc_in_use WHERE status='USE') SET status='WAIT',P_TIME=? ,s_price=? WHERE  c_no=? ";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, time);
			ps.setInt(2, price);
			ps.setInt(3, no);
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}
		return n;
	}
	public int DonePc_in_use(int no) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "UPDATE (SELECT * FROM pc_in_use WHERE status='USE' or status='WAIT') SET status='DONE' WHERE  c_no=? ";
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

	public int insertPc_in_use(PC_In_Use input) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO PC_IN_USE (NO,ID, C_NO,TYPE,P_TIME,S_PRICE)VALUES(PC_IN_USE_SEQ.NEXTVAL,?,?,?,?,?)";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, input.getId());
			ps.setInt(2, input.getC_no());
			ps.setString(3, input.getType());
			ps.setInt(4, input.getP_time());
			ps.setInt(5, input.getS_price());

			n = ps.executeUpdate();
		} catch (Exception e) {
			JOptionPane.showMessageDialog(null, e.toString(), "No.", JOptionPane.INFORMATION_MESSAGE, null);
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}
		return n;
	}

	public ArrayList<PC_In_Use_View> selectAll() {
		ArrayList<PC_In_Use_View> list = new ArrayList<PC_In_Use_View>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PC_IN_USE_VIEW ORDER BY no";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				PC_In_Use_View tmp = new PC_In_Use_View();
				tmp.setId(rs.getString("id"));
				tmp.setNo(rs.getInt("no"));
				tmp.setType(rs.getString("type"));
				tmp.setS_time(rs.getString("s_time"));
				tmp.setP_time(rs.getInt("p_time"));
				tmp.setS_price(rs.getInt("s_price"));
				tmp.setStatus(rs.getString("status"));
				tmp.setC_status(rs.getString("c_status"));
				list.add(tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}

		return list;
	}
	public ArrayList<PC_In_Use> selectWhole() {
		ArrayList<PC_In_Use> list = new ArrayList<PC_In_Use>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PC_IN_USE ORDER BY no";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				PC_In_Use tmp = new PC_In_Use();
				tmp.setId(rs.getString("id"));
				tmp.setNo(rs.getInt("no"));
				tmp.setType(rs.getString("type"));
				tmp.setU_date(rs.getString("u_date"));
				tmp.setS_time(rs.getString("s_time"));
				tmp.setP_time(rs.getInt("p_time"));
				tmp.setS_price(rs.getInt("s_price"));
				list.add(tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}

		return list;
	}
	
	public ArrayList<PC_Used_View> selectAll2(){
		ArrayList<PC_Used_View> list = new ArrayList<PC_Used_View>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PC_Used_View ORDER BY no";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				PC_Used_View tmp = new PC_Used_View();
				tmp.setNo(rs.getInt("no"));
				tmp.setId(rs.getString("id"));
				tmp.setC_no(rs.getInt("c_no"));
				tmp.setType(rs.getString("type"));
				tmp.setS_time(rs.getString("s_time"));
				tmp.setP_time(rs.getInt("p_time"));
				tmp.setU_date(rs.getString("u_date"));
				tmp.setS_price(rs.getInt("s_price"));
				list.add(tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}

		return list;
	}
	public ArrayList<PC_Used_View> selectDay(String dt){
		ArrayList<PC_Used_View> list =new ArrayList<PC_Used_View>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PC_Used_View Where u_date = ? ORDER BY no";
		
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dt);
			rs = ps.executeQuery();
			while (rs.next()) {
				PC_Used_View tmp = new PC_Used_View();
				tmp.setNo(rs.getInt("no"));
				tmp.setId(rs.getString("id"));
				tmp.setC_no(rs.getInt("c_no"));
				tmp.setType(rs.getString("type"));
				tmp.setS_time(rs.getString("s_time"));
				tmp.setP_time(rs.getInt("p_time"));
				tmp.setU_date(rs.getString("u_date"));
				tmp.setS_price(rs.getInt("s_price"));
				list.add(tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		
		
		
		return list;
	}
	
	public ArrayList<PC_Used_View> selectYear(String y){
		ArrayList<PC_Used_View> list =new ArrayList<PC_Used_View>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PC_Used_View Where u_date like ? ORDER BY no";
		
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, y+"/%");
			rs = ps.executeQuery();
			while (rs.next()) {
				PC_Used_View tmp = new PC_Used_View();
				tmp.setNo(rs.getInt("no"));
				tmp.setId(rs.getString("id"));
				tmp.setC_no(rs.getInt("c_no"));
				tmp.setType(rs.getString("type"));
				tmp.setS_time(rs.getString("s_time"));
				tmp.setP_time(rs.getInt("p_time"));
				tmp.setU_date(rs.getString("u_date"));
				tmp.setS_price(rs.getInt("s_price"));
				list.add(tmp);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		
		
		
		return list;
	}
	public ArrayList<PC_Used_View> selectMonth(String y){
		ArrayList<PC_Used_View> list =new ArrayList<PC_Used_View>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM PC_Used_View Where u_date like ? ORDER BY no";

		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, y + "/%");
			rs = ps.executeQuery();
			while (rs.next()) {
				PC_Used_View tmp = new PC_Used_View();
				tmp.setNo(rs.getInt("no"));
				tmp.setId(rs.getString("id"));
				tmp.setC_no(rs.getInt("c_no"));
				tmp.setType(rs.getString("type"));
				tmp.setS_time(rs.getString("s_time"));
				tmp.setP_time(rs.getInt("p_time"));
				tmp.setU_date(rs.getString("u_date"));
				tmp.setS_price(rs.getInt("s_price"));
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
