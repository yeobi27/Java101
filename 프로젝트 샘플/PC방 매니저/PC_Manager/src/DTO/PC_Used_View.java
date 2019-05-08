package DTO;
//매출용 VIEW
public class PC_Used_View {
	private String id; // member 참조
	private int no; // computer 참조
	private int c_no; // computer 참조
	private String type; // 후불 선불 구분
	private String s_time; // 사용 시작한 시간 start time
	private int p_time; // 사용 가능 시간 play time
	private int s_price; // sale price
	private String u_date;
	public PC_Used_View() {
		super();
	}
	public PC_Used_View(String id, int no, int c_no, String type, String s_time, int p_time, int s_price,
			String u_date) {
		super();
		this.id = id;
		this.no = no;
		this.c_no = c_no;
		this.type = type;
		this.s_time = s_time;
		this.p_time = p_time;
		this.s_price = s_price;
		this.u_date = u_date;
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
	public int getC_no() {
		return c_no;
	}
	public void setC_no(int c_no) {
		this.c_no = c_no;
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
	public String getU_date() {
		return u_date;
	}
	public void setU_date(String u_date) {
		this.u_date = u_date;
	}


}
