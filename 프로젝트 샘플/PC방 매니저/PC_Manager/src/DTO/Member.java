package DTO;

public class Member {
	private String id;
	private String pw;
	private String name;
	private String email; // id, 비밀번호 찾기용
	private String join_date; // 가입날짜
	private int rating; // 회원등급 rating 테이블 참조

	public Member() {
		super();
	}

	public Member(String id, String pw, String name, String email, String join_date, int rating) {
		super();
		this.id = id;
		this.pw = pw;
		this.name = name;
		this.email = email;
		this.join_date = join_date;
		this.rating = rating;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}


	
}
