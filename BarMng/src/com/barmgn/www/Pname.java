package com.barmgn.www;

public class Pname {
	private String pname;
	private int price;
	
	public Pname() {};
	
	public Pname(String pname, int price) {
		super();
		this.pname = pname;
		this.price = price;
	}

	public String getPname() {
		return pname;
	}

	public void setPname(String pname) {
		this.pname = pname;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	@Override
	public String toString() {
		return pname + " " + price;
	}
}
