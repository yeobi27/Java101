package com.barmgn.www;

public class Stock {
	private int pno, inven;
	private String pname, exp_date, restck_date;
	public Stock(int pno, int inven, String pname, String exp_date, String restck_date) {
		super();
		this.pno = pno;
		this.inven = inven;
		this.pname = pname;
		this.exp_date = exp_date;
		this.restck_date = restck_date;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getInven() {
		return inven;
	}
	public void setInven(int inven) {
		this.inven = inven;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	public String getExp_date() {
		return exp_date;
	}
	public void setExp_date(String exp_date) {
		this.exp_date = exp_date;
	}
	public String getRestck_date() {
		return restck_date;
	}
	public void setRestck_date(String restck_date) {
		this.restck_date = restck_date;
	}
	@Override
	public String toString() {
		return pno + " " + inven + " " + pname + " " + exp_date
				+ " " + restck_date;
	}
}
