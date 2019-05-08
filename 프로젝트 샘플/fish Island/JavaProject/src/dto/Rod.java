package dto;

public class Rod {
	private int rno;
	private String rname;
	private int price;
	private int att;
	
	
	public Rod() {}
	public Rod(int rno, String rname, int price, int att) {
		super();
		this.rno = rno;
		this.rname = rname;
		this.price = price;
		this.att= att;
	}
	public int getRno() {
		return rno;
	}
	public void setRno(int rno) {
		this.rno = rno;
	}
	public String getRname() {
		return rname;
	}
	public void setRname(String rname) {
		this.rname = rname;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getAtt() {
		return att;
	}
	public void setAtt(int att) {
		this.att = att;
	}
	
	
}
