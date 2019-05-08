package DTO;

public class Product_View {
	private int no;
	private String name;
	private String purchase_date;// 구입날짜
	private int price; // 가격
	private String type; // 물품의 종류 구분 product_type 테이블 참조
	private int stock; // 재고 수량

	public Product_View() {
		super();
	}

	public Product_View(int no, String name, String purchase_date, int price, String type, int stock) {
		super();
		this.no = no;
		this.name = name;
		this.purchase_date = purchase_date;
		this.price = price;
		this.type = type;
		this.stock = stock;
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

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

}
