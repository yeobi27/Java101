package DTO;

public class Product {
	private int no; // PRODUCT_SEQ 사용
	private String name;
	private String purchase_date;// 구입날짜
	private int price; // 가격
	private int type; // 물품의 종류 구분 product_type 테이블 참조
	private int stock; // 재고 수량
	private String imgaddress;

	public Product() {
		super();
	}

	public Product(int no, String name, String purchase_date, int price, int type, int stock, String imgaddress) {
		super();
		this.no = no;
		this.name = name;
		this.purchase_date = purchase_date;
		this.price = price;
		this.type = type;
		this.stock = stock;
		this.imgaddress = imgaddress;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	public String getImgaddress() {
		return imgaddress;
	}

	public void setImgaddress(String imgaddress) {
		this.imgaddress = imgaddress;
	}

}
