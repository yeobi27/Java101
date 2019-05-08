package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Rod;

public class RodDao {
	private RodDao() {}
	private static RodDao instance=new RodDao();
	public static RodDao getInstance() {
		return instance;
	}
	
	public Rod selectOne(int rno){
		Rod r=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from rod where rno=?";
		
		try {
			conn=DbConn.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, rno);
			rs=ps.executeQuery();
			if(rs.next()) {
				r = new Rod();
				r.setRno(rs.getInt("rno"));
				r.setRname(rs.getString("rname"));
				r.setPrice(rs.getInt("price"));
				r.setAtt(rs.getInt("att"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbConn.close(conn, ps, rs);
		}
		return r;
	}
	
	//사기 버튼 누르면 낚시대 목록
	public ArrayList<Rod> SelectAll(){
		ArrayList<Rod> rod = new ArrayList<Rod>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql = "select * from rod";
		try {
			conn=DbConn.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			
			while(rs.next()) {
				Rod r= new Rod();
				r.setRno(rs.getInt("rno"));
				r.setRname(rs.getString("rname"));
				r.setPrice(rs.getInt("price"));
				r.setAtt(rs.getInt("att"));
				rod.add(r);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbConn.close(conn, ps, rs);
		}
		return rod;
	}
	
	public Rod selectOwn(int rno) {
		Rod rod=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		
		String sql="select * from rod where rno=?";
		
		try {
			conn=DbConn.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, rno);
			rs=ps.executeQuery();
			if(rs.next()) {
				rod=new Rod();
				rod.setRno(rs.getInt("rno"));
				rod.setRname(rs.getString("rname"));
				rod.setPrice(rs.getInt("price"));
				rod.setAtt(rs.getInt("att"));
				
			}
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbConn.close(conn, ps, rs);
		}
		return rod;
	}
	
}
