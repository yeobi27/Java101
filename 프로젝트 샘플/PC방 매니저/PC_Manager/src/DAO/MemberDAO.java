package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import DTO.Member;
import DTO.Member_View;

//MEMBER 목록 조회시 MEMBER_VIEW 사용
public class MemberDAO {
	private MemberDAO() {
	}

	private static MemberDAO instance = new MemberDAO();

	public static MemberDAO getInstance() {
		return instance;
	}

	public int updateMem(String id, String update) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		System.out.println(id);
		String sql = "UPDATE member SET email=? WHERE  id=? ";

		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, update);
			ps.setString(2, id);
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}

		return n;
	}

	public int deleteMem(String id) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "DELETE FROM member WHERE id=?";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			n = ps.executeUpdate();

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}
		return n;
	}

	public ArrayList<Member_View> SelectAll_View() {
		ArrayList<Member_View> list = new ArrayList<Member_View>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member_view";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Member_View m = new Member_View();
				m.setId(rs.getString("id"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));
				m.setJoin_date(rs.getString("join_date"));
				m.setRating(rs.getString("rating"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}

		return list;
	}

	public ArrayList<Member> SelectAll() {
		ArrayList<Member> list = new ArrayList<Member>();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Member m = new Member();
				m.setId(rs.getString("id"));
				m.setPw(rs.getString("pw"));
				m.setName(rs.getString("name"));
				m.setEmail(rs.getString("email"));

				m.setJoin_date(rs.getString("join_date"));
				m.setRating(rs.getInt("rating"));
				list.add(m);
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}

		return list;
	}

	public Member selectOne(String id) {
		Member member = new Member();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select * from member where id=?";
		try {
			conn = DB_Connection.getConnection();

			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				member.setId(rs.getString("id"));
				member.setPw(rs.getString("pw"));
				member.setName(rs.getString("name"));
				member.setEmail(rs.getString("Email"));

				member.setJoin_date(rs.getString("join_date"));
				member.setRating(rs.getInt("rating"));
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return member;

	}

	public int insert(Member m) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into member(id,pw,name,email) values(?,?,?,?)";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, m.getId());
			ps.setString(2, m.getPw());
			ps.setString(3, m.getName());
			ps.setString(4, m.getEmail());
			n = ps.executeUpdate();
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps);
		}
		return n;
	}

	public int userlogin(String id, String pw) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select pw from member where id=?";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (pw.equals(rs.getString("pw"))) {
					n = 1;
				} else {
					n = 0;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return n;
	}

	public int userComfirm(String id) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id from member where id=?";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				if (id.equals(rs.getString("id"))) {
					n = 1;
				} else {
					n = 0;
				}
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return n;
	}

	public boolean getIdByCheck(String id) {
		boolean result = true;
		Connection conn = DB_Connection.getConnection();
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id from member where id like ?";
		try {
			ps = conn.prepareStatement(sql);
			System.out.println(id);
			ps.setString(1, id);
			rs = ps.executeQuery(); // 실행

			if (rs.next())
				result = false; // 레코드가 존재하면 false

		} catch (Exception e) {
			System.out.println(e + "=>  getIdByCheck fail");
		} finally {
			DB_Connection.close(conn, ps, rs);
		}

		return result;

	}// getIdByCheck()

	public String findingId(String name, String mail) {
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id from member where name like ? and email like ?";
		// String ok=null;
		String id = "정보를 잘 못 입력하셨거나 아이디가 존재하지 않습니다.";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			System.out.println(name + ", " + mail);
			ps.setString(1, name);
			ps.setString(2, mail);
			rs = ps.executeQuery(); // 실행

			if (rs.next()) {
				id = rs.getString("id");
			}

		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DB_Connection.close(conn, ps, rs);
		}
		return id;

	}

	public String findingPw(String name, String id, String mail) {
		String pw = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id, pw from member where name like? and id like ? and email like ?";
		pw = "정보를 잘못 입력하셨습니다.";
		try {
			conn = DB_Connection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, name);
			ps.setString(2, id);
			ps.setString(3, mail);
			rs = ps.executeQuery();
			if (rs.next()) {
				pw = name + "님의 비밀번호는 " + rs.getString("pw") + "입니다.";
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return pw;
	}
}
