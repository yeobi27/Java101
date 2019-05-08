package DTO;

//조회용 MEMBER_VIEW 테이블 형식
public class Member_View {
	private String id;
	private String name;
	private String email; // id, 비밀번호 찾기용
	private String join_date; // 가입날짜
	private String rating;

	public Member_View() {
		super();
	}

	public Member_View(String id, String name, String email, String join_date, String rating) {
		super();
		this.id = id;
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

	public String getRating() {
		return rating;
	}

	public void setRating(String rating) {
		this.rating = rating;
	}

}
