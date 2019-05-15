package com.barmgn.www;

import java.sql.Date;

public class Order {
	private int ordnum, tno, pno, price, tot_sales, quantity;
	private String pname;
	private Date c_date;
	public Order(int ordnum, int tno, int pno, String pname,int price, int tot_sales, int quantity, Date c_date) {
		super();
		this.ordnum = ordnum;
		this.tno = tno;
		this.pno = pno;
		this.pname = pname;
		this.price = price;
		this.tot_sales = tot_sales;
		this.quantity = quantity;
		this.c_date = c_date;
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
	public Date getC_date() {
		return c_date;
	}
	public void setC_date(Date c_date) {
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
		return ordnum + " " + c_date + " " + tno + " " + pno + " " + pname + " "
				+ price + " " + quantity + " " + tot_sales;
	}
	
}
