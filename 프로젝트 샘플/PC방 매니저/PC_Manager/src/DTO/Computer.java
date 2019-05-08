package DTO;

public class Computer {
	private int no; //COMPUTER_SEQ 사용
	private String ip;
	private String purchase_date; // 허전해서 넣은 장비 구입날짜
	private String status; // 컴퓨터 특이사항 체크용 ex.고장
	private int port;

	public Computer() {
		super();
	}

	public Computer(int no, String ip, String purchase_date, String status, int port) {
		super();
		this.no = no;
		this.ip = ip;
		this.purchase_date = purchase_date;
		this.status = status;
		this.port = port;
	}

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}

	public String getPurchase_date() {
		return purchase_date;
	}

	public void setPurchase_date(String purchase_date) {
		this.purchase_date = purchase_date;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public int getPort() {
		return port;
	}

	public void setPort(int port) {
		this.port = port;
	}

	
}
