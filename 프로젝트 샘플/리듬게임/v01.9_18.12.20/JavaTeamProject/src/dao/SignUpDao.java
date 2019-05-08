package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import dto.SignUp;

public class SignUpDao {
	private SignUpDao() {
	}

	private static SignUpDao instance = new SignUpDao();

	public static SignUpDao getInstance() {
		return instance;
	}

	public SignUp selectId(String id) {
		SignUp su = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select id from player where id=?";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, id);
			rs = ps.executeQuery();
			if (rs.next()) {
				su = new SignUp();
				su.setId(rs.getString("id"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.Close(conn, ps, rs);
		}
		return su;

	}

	public SignUp selectNik(String Nik) {
		SignUp su = null;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "select nickname from player where nickname=?";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, Nik);
			rs = ps.executeQuery();
			if (rs.next()) {
				su = new SignUp();
				su.setId(rs.getString("nickname"));
			}
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.Close(conn, ps, rs);
		}
		return su;

	}

	public int insert(SignUp su) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into player values(player_sq.nextval, ?, ?, ?)";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, su.getId());
			ps.setString(2, su.getPw());
			ps.setString(3, su.getNikname());
			n = ps.executeUpdate();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("id 또는 닉네임 중복됩니다.");
		} finally {
			DBConnection.Close(conn, ps);
		}
		return n;
	}

	// 회원 확인
	public int userComfirm(String id, String pw) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT pw FROM player WHERE id=?";
		try {
			conn = DBConnection.getConnection();
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
		}
		return n;

	}
}
