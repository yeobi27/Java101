package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Vector;

import DTO.Orders;
import DTO.Product;
import DTO.Product_Type;
import DTO.Product_View;

//PRODUCT 목록 조회시 PRODUCT_VIEW 테이블 사용
public class ProductDAO {
	private ProductDAO() {
	}

	private static ProductDAO instance = new ProductDAO();

	public static ProductDAO getInstance() {
		return instance;
	}

	public ArrayList<Product_View> select_View_All() {
		ArrayList<Product_View> list = new ArrayList<Product_View>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from Product_View";

		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();

			while (rs.next()) {
				Product_View pt = new Product_View();
				pt.setNo(rs.getInt("no"));
				pt.setName(rs.getString("name"));
				pt.setPurchase_date(rs.getString("purchase_date"));
				pt.setPrice(rs.getInt("price"));
				pt.setType(rs.getString("type"));
				pt.setStock(rs.getInt("stock"));
				list.add(pt);

				// int n=ps.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return list;
	}

	public ArrayList<Product> selectAll() {
		ArrayList<Product> list = new ArrayList<Product>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from Product_View";

		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
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

				// int n=ps.executeUpdate();

			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return list;
	}

	public int SearchP_no(String name) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		int no=0;
		String sql = "select no from Product where name=?";

		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			rs = ps.executeQuery();
			if(rs.next()) {
				no=rs.getInt("no");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return no;
	}
	public String SearchP_name(int no) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String name="";
		String sql = "select name from Product where no=?";

		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			if(rs.next()) {
				name=rs.getString("name");
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return name;
	}
	
	public Product selectOne(int no) {
		Product ptt = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select *from Product where no=?";

		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			rs = ps.executeQuery();
			while (rs.next()) {
				ptt = new Product();
				ptt.setNo(rs.getInt("no"));
				ptt.setName(rs.getString("name"));
				ptt.setPurchase_date(rs.getString("purchase_date"));
				ptt.setPrice(rs.getInt("price"));
				ptt.setType(rs.getInt("type"));
				ptt.setStock(rs.getInt("stock"));
				ptt.setImgaddress(rs.getString("imgaddress"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return ptt;
	}

	public int insert(Product pt) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into Product value(Product sq.nextval,?,?,?,?)";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);

			ps.setString(2, pt.getName());
			ps.setString(3, pt.getPurchase_date());
			ps.setInt(4, pt.getPrice());
			ps.setInt(5, pt.getType());
			ps.setInt(6, pt.getStock());
			ps.setString(7, pt.getImgaddress());

			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}

		return n;
	}

	public Vector selectType() {
		Vector st = new Vector();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from product_type";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product_Type pt = new Product_Type();
				String str = rs.getString("type");
				st.add(str);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}

		return st;
	}

	public ArrayList<Product_Type> selectAll2() {
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
				pt.setNo(rs.getInt("no"));
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

	public int productupdate(int no, int quantity) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "update product set stock=stock+? where no=?";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, quantity);
			ps.setInt(2, no);

			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {

		}
		return n;

	}

	public ArrayList<Product_Type> viewType() {
		// TODO Auto-generated method stub
		ArrayList<Product_Type> list = new ArrayList<Product_Type>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from product_type order by no";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Product_Type pt = new Product_Type();
				pt.setNo(rs.getInt("no"));
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

	public void deletetype(int no) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "delete from product_type where no=?";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}

	}

	public void insertType(int no, String str) {
		// TODO Auto-generated method stub
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into product_type (no,type) values(?,?)";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, no);
			ps.setString(2, str);
			ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}

	}

	public int deletePro(int no) {
		// TODO Auto-generated method stub
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM Product WHERE no=?";
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

	public int InsertPro(String name, int prices, int type, int stocks) {
		// TODO Auto-generated method stub
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "INSERT INTO product (no,name,price,type,stock)VALUES(product_SEQ.NEXTVAL,?,?,?,?)";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setInt(2, prices);
			ps.setInt(3, type);
			ps.setInt(4, stocks);
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
