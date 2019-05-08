package dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import dto.Recode;
import dto.SignUp;

public class RecodeDao {
	private SignUp su = new SignUp();
	private Recode r = new Recode();
	private static RecodeDao instance = new RecodeDao();

	public static RecodeDao getInstance() {
		return instance;
	}

	public int insert(SignUp su, Recode r) {
		int n = -1;
		Connection conn = null;
		PreparedStatement ps = null;
		String sql = "insert into recode values(?,?,?,?)";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, su.getId());
			ps.setString(2, r.getTitleName());
			ps.setString(3, r.getDifficulty());
			ps.setInt(4, r.getScore());
			n = ps.executeUpdate();

			System.out.println(su.getId() + " " + r.getTitleName() + " " + r.getDifficulty() + " " + r.getScore());
			System.out.println("데이터 삽입 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("플레이어 데이터 기록 실패...");
		} finally {
			DBConnection.Close(conn, ps);
		}
		return n;
	}

	

	// 전체정보 확인
	public ArrayList<Recode> selectAll() {
		ArrayList<Recode> list = new ArrayList<Recode>();

		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM recode ORDER BY difficulty DESC, score DESC, titlename DESC";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			rs = ps.executeQuery();
			while (rs.next()) {
				Recode r = new Recode();
				r.setId(rs.getString("id"));
				r.setTitleName(rs.getString("titleName"));
				r.setDifficulty(rs.getString("difficulty"));
				r.setScore(rs.getInt("score"));
				list.add(r);
			}
			System.out.println("데이터 조회 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("플레이어 데이터 조회 실패...");
		} finally {
			DBConnection.Close(conn, ps, rs);
		}
		return list;
	}

	// 개인 기록
	public Recode selectOne(SignUp su) {
		Recode res = new Recode();
		Connection conn = null;
		PreparedStatement ps = null;
		ResultSet rs = null;
		String sql = "SELECT * FROM recode WHERE id = ? ORDER BY difficulty DESC, score DESC, titlename DESC";
		try {
			conn = DBConnection.getConnection();
			ps = conn.prepareStatement(sql);
			ps.setString(1, su.getId());
			rs = ps.executeQuery();

			if (rs.next()) {
				Recode r = new Recode();
				r.setId(rs.getString("id"));
				r.setTitleName(rs.getString("titleName"));
				r.setDifficulty(rs.getString("difficulty"));
				r.setScore(rs.getInt("score"));
				res = r;
			}
			
			System.out.println("데이터 조회 성공");
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("플레이어 데이터 조회 실패...");
		} finally {
			DBConnection.Close(conn, ps, rs);
		}
		return res;
	}
}
