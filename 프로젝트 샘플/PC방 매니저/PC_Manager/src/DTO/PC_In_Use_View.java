package DTO;

public class PC_In_Use_View {
	private String id; // member 참조
	private int no; // computer 참조
	private String type; // 후불 선불 구분
	private String s_time; // 사용 시작한 시간 start time
	private int p_time; // 사용 가능 시간 play time
	private int s_price; // sale price
	private String status;
	private String c_status;

	public PC_In_Use_View() {
		super();
	}

	public PC_In_Use_View(String id, int no, String type, String s_time, int p_time, int s_price, String status,
			String c_status) {
		super();
		this.id = id;
		this.no = no;
		this.type = type;
		this.s_time = s_time;
		this.p_time = p_time;
		this.s_price = s_price;
		this.status = status;
		this.c_status = c_status;
	}



	public String getC_status() {
		return c_status;
	}



	public void setC_status(String c_status) {
		this.c_status = c_status;
	}



	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getS_time() {
		return s_time;
	}

	public void setS_time(String s_time) {
		this.s_time = s_time;
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
