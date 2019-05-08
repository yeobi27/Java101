package DTO;
//∏≈√‚øÎ VIEW
public class Orders_View {
	private int no;
	private String id;
	private String name;
	private String type;
	private int quantity;
	private int price;
	private String s_date;

	public Orders_View() {
		super();
	}

	public Orders_View(int no, String id, String name, String type, int quantity, int price, String s_date) {
		super();
		this.no=no;
		this.id = id;
		this.name = name;
		this.type = type;
		this.quantity = quantity;
		this.price = price;
		this.s_date = s_date;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public String getS_date() {
		return s_date;
	}

	public void setS_date(String s_date) {
		this.s_date = s_date;
	}

}
