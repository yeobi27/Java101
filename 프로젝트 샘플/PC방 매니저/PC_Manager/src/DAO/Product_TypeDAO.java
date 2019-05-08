package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import DTO.Product;
import DTO.Product_Type;

public class Product_TypeDAO {

	private static Product_TypeDAO instance = new Product_TypeDAO();

	public static Product_TypeDAO getInstance() {
		return instance;
	}

	public ArrayList<Product_Type> selectAll() {
		ArrayList<Product_Type> list = new ArrayList<Product_Type>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select *from Product_Type";

		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product_Type pt = new Product_Type();
				pt.setNo(rs.getInt("id"));
				pt.setType(rs.getString("type"));

				list.add(pt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return list;
	}

	public Product_Type selectOne(int no) {
		Product_Type ptt = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select *from Product_Type where no=?";

		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			while (rs.next()) {
				ptt = new Product_Type();
				ptt.setNo(rs.getInt("no"));
				ptt.setType(rs.getString("type"));

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return ptt;
	}

	public int insert(Product_Type pt) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into Product_Type value(Product_Type sq.nextval,?)";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, pt.getNo());
			ps.setString(2, pt.getType());

			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}

		return n;
	}

	public ArrayList<Product> selectType(int type) {
		ArrayList<Product> list = new ArrayList<Product>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select *from Product where type =?";

		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, type);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product pt = new Product();
				pt.setNo(rs.getInt("no"));
				pt.setName(rs.getString("name"));
				pt.setPurchase_date(rs.getString("purchase_date"));
				pt.setPrice(rs.getInt("price"));
				pt.setType(rs.getInt("type"));
				pt.setStock(rs.getInt("stock"));
				pt.setImgaddress(rs.getString("imgaddress"));
				list.add(pt);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return list;
	}
}
