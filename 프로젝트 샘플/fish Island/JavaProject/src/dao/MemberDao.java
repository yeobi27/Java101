package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.StringTokenizer;

import dto.Member;


public class MemberDao {
	private MemberDao() {}
	private static MemberDao instance=new MemberDao();
	public static MemberDao getInstance() {
		return instance;
	}
	
	public ArrayList<Member> selectAll(){
		ArrayList<Member> list=new ArrayList<Member>();
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from member";
		
		try {
			conn=DbConn.getConnection();
			ps=conn.prepareStatement(sql);
			rs=ps.executeQuery();
			while(rs.next()) {
				Member m=new Member();
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
				m.setF_stack(rs.getString("pno"));
				m.setMoney(rs.getInt("money"));
				m.setRno(rs.getInt("rod"));
				m.setDic(rs.getString("dic"));
				list.add(m);
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbConn.close(conn, ps, rs);
		}
		return list;
	}	
	
	public Member selectOne(String id){
		Member member=null;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select * from member where id=?";
		
		try {
			conn=DbConn.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			if(rs.next()) {
				member=new Member();
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setF_stack(rs.getString("f_stack"));
				member.setMoney(rs.getInt("money"));
				member.setRno(rs.getInt("rno"));
				member.setDic(rs.getString("dic"));
			}
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbConn.close(conn, ps, rs);
		}
		return member;
	}
	
	public int insert(Member m) {
		int n=-1;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql="insert into member values(?,?,?,?,?,?)";
		
		try {
			conn=DbConn.getConnection();
			System.out.println(conn);
			ps=conn.prepareStatement(sql);
			ps.setString(1, m.getId());
			ps.setString(2, m.getPw());
			ps.setString(3, m.getF_stack());
			ps.setInt(4, m.getMoney());
			ps.setInt(5, 1);
			ps.setString(6, m.getDic());
			n=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbConn.close(conn, ps);
		}
		return n;
	}
	
	public int userConfirm(String id, String pw_) {
		int n=-1;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="select pw from member where id=?";
		try {
			conn=DbConn.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, id);
			rs=ps.executeQuery();
			
			if(rs.next()) {
				if(pw_.equals(rs.getString("pw"))) {
					n=1;
				}else {
					n=0;
				}
			}
			
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbConn.close(conn, ps, rs);
		}
		return n;
	}
	
	public int SuccessFishing(String f_stack,String id, int fno)
	{
		int n=-1;
		System.out.println("f_stack : " +f_stack);
		if(f_stack==null)
			f_stack="";
		f_stack=f_stack+Integer.toString(fno)+",";
		System.out.println("fno : " +fno);
//		f_stack=Integer.toString(fno)+",";
		System.out.println("f_stack + fno : "+ f_stack);
		System.out.println("id : " + id);

		Connection conn=null;
		PreparedStatement ps=null;
		String sql="update member set f_stack=? where id=?";
		
		try {
			conn=DbConn.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, f_stack);
			ps.setString(2, id);
			
			n=ps.executeUpdate();
			System.out.println("물고기 낚시 완료");
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}finally
		{
			DbConn.close(conn, ps);
		}
		return n;		
	}
	
	
	//도감 물고기 넣는 거
	public int DicFish(String dic, String id, int fno) {
		int n=-1;
		Connection conn=null;
		PreparedStatement ps=null;
//		String dic_=selectOne(id).getDic();
//		StringTokenizer st = new StringTokenizer(dic_, ",");
//		
//		for(int i=0;i<st.countTokens();i++) {
//			int fno_ = Integer.parseInt(st.nextToken());
//			if(fno != fno_ ) {
//				
//			}
//		}

		
		//if(selectOne(id))
		String sql= "update member set dic=? where id=?";
		
		if(dic==null)
			dic="";
		
		dic=dic+Integer.toString(fno)+",";
		//if(selectOne(id))
		
		try {
			conn=DbConn.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, dic);
			ps.setString(2, id);
			n=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbConn.close(conn, ps);
		}
		return n;
	}
	
	
	
	
	public int rnoUpdate(String id, int rno) {
		int n=-1;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql= "update member set rno=? where id=?";
		
		try {
			conn=DbConn.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, rno);
			ps.setString(2, id);
			n=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbConn.close(conn, ps);
		}
		return n;
	}
	
	public int moneyUpdate(String id, int money) {
		int m=-1;
		Connection conn=null;
		PreparedStatement ps=null;
		String sql= "update member set money=? where id=?";
		
		try {
			conn=DbConn.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setString(2, id);
			m=ps.executeUpdate();
		}catch(Exception e) {
			e.printStackTrace();
		}finally {
			DbConn.close(conn, ps);
		}
		return m;
	}
	public int updateMoney(int money,String id) {
		int n=-1;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		String sql="update member set money=? where id=?";
		
		try {
			conn=DbConn.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setInt(1, money);
			ps.setString(2, id);
			n=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbConn.close(conn, ps);
		}
		
		return n;
	}
	public int updatefstack(String fstack, String id) {
		int n=-1;
		Connection conn=null;
		PreparedStatement ps=null;
		ResultSet rs=null;
		System.out.println(fstack);
		String sql="update member set f_stack=? where id=?";
		
		try {
			conn=DbConn.getConnection();
			ps=conn.prepareStatement(sql);
			ps.setString(1, fstack);
			ps.setString(2, id);
			n=ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DbConn.close(conn, ps);
		}
		
		return n;
	}
	
	public int duplicateId(String id){
        Connection con = DbConn.getConnection(); 
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        StringBuffer sql = null;
        int retVal = 0;
        
        try{
            sql = new StringBuffer();
            sql.append(" SELECT COUNT(id) as cnt");
            sql.append(" FROM member");
            sql.append(" WHERE id = ?");
            
            pstmt = con.prepareStatement(sql.toString());
            
            pstmt.setString(1, id); // 첫번째 ?에 id 변수값 지정
            
            rs = pstmt.executeQuery(); // SQL 실행
            
            if ( rs.next() == true ) { // 최초 첫번째 레코드로 이동
                retVal = rs.getInt("cnt");
            }            
        }catch(Exception e){
            System.out.println(e.toString());
        }finally{
            DbConn.close(con, pstmt, rs);
        }
        
        return retVal;
    }
	
}



