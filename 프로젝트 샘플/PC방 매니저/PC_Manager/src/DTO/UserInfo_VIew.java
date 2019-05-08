package DTO;

//조회용 MEMBER_VIEW 테이블 형식
public class UserInfo_VIew {
	private String id;
	private String name;
	private String join_date; // 가입날짜
	private int p_time;
	private int s_price;

	public UserInfo_VIew() {
		super();
	}

	public UserInfo_VIew(String id, String name, String join_date, int p_time, int s_price) {
		super();
		this.id = id;
		this.name = name;
		this.join_date = join_date;
		this.p_time = p_time;
		this.s_price = s_price;
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

	public String getJoin_date() {
		return join_date;
	}

	public void setJoin_date(String join_date) {
		this.join_date = join_date;
	}

	public int getP_time() {
		return p_time;
	}

	public void setP_time(int p_time) {
		this.p_time = p_time;
	}

	public int getS_price() {
		return s_price;
	}

	public void setS_price(int s_price) {
		this.s_price = s_price;
	}

}
