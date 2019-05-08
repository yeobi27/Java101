package dto;

public class Member {
	private String id;
	private String pw;
	private String f_stack;
	private int money;
	private int rno;
	private String dic;
	
	public Member() {}
	public Member(String id, String pw, String f_stack, int money, int rno, String dic) {
		super();
		this.id = id;
		this.pw = pw;
		this.f_stack = f_stack;
		this.money = money;
		this.rno = rno;
		this.dic =dic;
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
	public String getF_stack() {
		return f_stack;
	}
	public void setF_stack(String f_stack) {
		this.f_stack = f_stack;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getDic() {
		return dic;
	}
	public void setDic(String dic) {
		this.dic = dic;
	}
	
	
	
	
}
