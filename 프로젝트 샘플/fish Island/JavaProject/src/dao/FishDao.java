package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Fish;

public class FishDao {
	private FishDao() {}
	private static FishDao instance=new FishDao();
	public static FishDao getInstance() {
		return instance;
	}
	
	public ArrayList<Fish> selectFish(int sea)
	{
		ArrayList<Fish> list=new ArrayList<Fish>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from fish where sea like '%"+sea+"%'";
		
		try {
			conn=DbConn.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next())
			{
				Fish f = new Fish();
				f.setFno(rs.getInt("fno"));
				f.setFname(rs.getString("fname"));
				f.setSea(rs.getString("sea"));
				f.setSaleprice(rs.getInt("saleprice"));
				f.setMovement(rs.getInt("movement"));
				list.add(f);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally {
			DbConn.close(conn, ps, rs);
		}
		
		return list;
	}
	
	public ArrayList<Fish> selectAll() {
		ArrayList<Fish> list = new ArrayList<Fish>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from fish";
		try {
			conn = DbConn.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Fish f = new Fish();
				f.setFno(rs.getInt("fno"));
				f.setFname(rs.getString("fname"));
				f.setSea(rs.getString("sea"));
				f.setSaleprice(rs.getInt("saleprice"));
				f.setMovement(rs.getInt("movement"));
				list.add(f);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConn.close(conn, ps, rs);
		}
		return list;
	}
	
	public Fish selectOne(int fno) {
		Fish fish = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from fish where fno=?";

		try {
			conn = DbConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, fno);
			rs = ps.executeQuery();
			if (rs.next()) {
				fish = new Fish();
				fish.setFno(rs.getInt("fno"));
				fish.setFname(rs.getString("fname"));
				fish.setSea(rs.getString("sea"));
				fish.setSaleprice(rs.getInt("saleprice"));
				fish.setMovement(rs.getInt("movement"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DbConn.close(conn, ps, rs);
		}
		return fish;
	}
	
	public int saleprice(Fish f) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs=null;
		String sql = "select saleprice from fish where fno=?";
		try {
			conn = DbConn.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setInt(1, f.getFno());
			rs=ps.executeQuery();
			if(rs.next()) {
				Fish fish=new Fish();
				fish.setSaleprice(rs.getInt("saleprice"));
			}
		} catch (Exception e) {
			e.getStackTrace();
		} finally {
			DbConn.close(conn, ps, rs);
		}
		return n;
	}
}