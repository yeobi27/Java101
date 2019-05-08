package DTO;

public class Product_Type {
	private int no; 
	private String type;

	public Product_Type() {
		super();
	}

	public Product_Type(int no, String type) {
		super();
		this.no = no;
		this.type = type;
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

}
