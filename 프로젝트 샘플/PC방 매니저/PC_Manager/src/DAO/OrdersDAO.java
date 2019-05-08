package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.Orders;
import DTO.Orders_View;

//거래 내역 조회시 ORDERS_VIEW 사용
public class OrdersDAO {
	private OrdersDAO() {
	}

	private static OrdersDAO instance = new OrdersDAO();

	public static OrdersDAO getInstance() {
		return instance;
	}

	public ArrayList<Orders_View> selectAll() {
		ArrayList<Orders_View> list = new ArrayList<Orders_View>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from orders_view";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Orders_View ov = new Orders_View();
				ov.setNo(rs.getInt("no"));
				ov.setId(rs.getString("id"));
				ov.setName(rs.getString("name"));
				ov.setType(rs.getString("type"));
				ov.setQuantity(rs.getInt("quantity"));
				ov.setPrice(rs.getInt("price"));
				ov.setS_date(rs.getString("s_date"));
				list.add(ov);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return list;

	}

	public ArrayList<Orders_View> selectDay(String dt) {
		ArrayList<Orders_View> list = new ArrayList<Orders_View>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from orders_view where s_date like ? ";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dt);
			rs = ps.executeQuery();
			while (rs.next()) {
				Orders_View ov = new Orders_View();
				ov.setNo(rs.getInt("no"));
				ov.setId(rs.getString("id"));
				ov.setName(rs.getString("name"));
				ov.setType(rs.getString("type"));
				ov.setQuantity(rs.getInt("quantity"));
				ov.setPrice(rs.getInt("price"));
				ov.setS_date(rs.getString("s_date"));
				list.add(ov);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return list;

	}

	public ArrayList<Orders_View> selectYear(String dt) {
		ArrayList<Orders_View> list = new ArrayList<Orders_View>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from orders_view where s_date like ? order by s_date ";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dt + "/%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Orders_View ov = new Orders_View();
				ov.setNo(rs.getInt("no"));
				ov.setId(rs.getString("id"));
				ov.setName(rs.getString("name"));
				ov.setType(rs.getString("type"));
				ov.setQuantity(rs.getInt("quantity"));
				ov.setPrice(rs.getInt("price"));
				ov.setS_date(rs.getString("s_date"));
				list.add(ov);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return list;

	}

	public ArrayList<Orders_View> selectMonth(String dt) {
		ArrayList<Orders_View> list = new ArrayList<Orders_View>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from orders_view where s_date like ? order by s_date ";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, dt + "/%");
			rs = ps.executeQuery();
			while (rs.next()) {
				Orders_View ov = new Orders_View();
				ov.setNo(rs.getInt("no"));
				ov.setId(rs.getString("id"));
				ov.setName(rs.getString("name"));
				ov.setType(rs.getString("type"));
				ov.setQuantity(rs.getInt("quantity"));
				ov.setPrice(rs.getInt("price"));
				ov.setS_date(rs.getString("s_date"));
				list.add(ov);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return list;

	}
	public int insertOrdersDAO(Orders input) {
		int n=-1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into orders(no,id,p_no,quantity) values(order_seq.nextval,?,?,?)";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, input.getId());
			ps.setInt(2, input.getP_no());
			ps.setInt(3, input.getQuantity());
			
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}
		return n;
	}
	public Orders selectOne(int no){
		Orders ptt=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs= null;
		String sql = "select *from Orders where p_no=?";
		
		try {
			conn=DB_Connection.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs=ps.executeQuery();
			while(rs.next()) {
				ptt = new Orders();
				ptt.setP_no(rs.getInt("p_no"));
				ptt.setId(rs.getString("id"));
				ptt.setNo(rs.getInt("no"));
				ptt.setQuantity(rs.getInt("quantity"));
				
			}
			}catch(Exception e) {
				e.printStackTrace();
			}finally {
				DB_Connection.close(conn,ps,rs);
			}
		return ptt;
		}
}
