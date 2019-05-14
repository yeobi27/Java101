package com.barmgn.www;

public class Order {
	private int ordnum, tno, pno, price, tot_sales, quantity;
	private String c_date, pname;
	public Order(int ordnum, int tno, int pno, int price, int tot_sales, int quantity, String c_date, String pname) {
		super();
		this.ordnum = ordnum;
		this.tno = tno;
		this.pno = pno;
		this.price = price;
		this.tot_sales = tot_sales;
		this.quantity = quantity;
		this.c_date = c_date;
		this.pname = pname;
	}
	public int getOrdnum() {
		return ordnum;
	}
	public void setOrdnum(int ordnum) {
		this.ordnum = ordnum;
	}
	public int getTno() {
		return tno;
	}
	public void setTno(int tno) {
		this.tno = tno;
	}
	public int getPno() {
		return pno;
	}
	public void setPno(int pno) {
		this.pno = pno;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public int getTot_sales() {
		return tot_sales;
	}
	public void setTot_sales(int tot_sales) {
		this.tot_sales = tot_sales;
	}
	public int getQuantity() {
		return quantity;
	}
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	public String getC_date() {
		return c_date;
	}
	public void setC_date(String c_date) {
		this.c_date = c_date;
	}
	public String getPname() {
		return pname;
	}
	public void setPname(String pname) {
		this.pname = pname;
	}
	@Override
	public String toString() {
		return ordnum + " " + tno + " " + pno + " " + price + " "
				+ tot_sales + " " + quantity + " " + c_date + " " + pname;
	}
	
}
