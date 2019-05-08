package dto;

public class Fish {
	private int fno;
	private String fname;
	private String sea;
	private int saleprice;
	private int movement;
	
	public int getMovement() {
		return movement;
	}
	public void setMovement(int movement) {
		this.movement = movement;
	}
	public Fish() {}
	public Fish(int fno, String fname, String sea, int saleprice) {
		super();
		this.fno = fno;
		this.fname = fname;
		this.sea = sea;
		this.saleprice = saleprice;
	}
	public int getFno() {
		return fno;
	}
	public void setFno(int fno) {
		this.fno = fno;
	}
	public String getFname() {
		return fname;
	}
	public void setFname(String fname) {
		this.fname = fname;
	}
	public String getSea() {
		return sea;
	}
	public void setSea(String sea) {
		this.sea = sea;
	}
	public int getSaleprice() {
		return saleprice;
	}
	public void setSaleprice(int saleprice) {
		this.saleprice = saleprice;
	}
	
	
	
}
