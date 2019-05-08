package dto;

public class SignUp {
	private String id, nikname, pw;

	public SignUp() {
	}

	public SignUp(String id) {
		this.id = id;
	}

	public SignUp(String id, String pw, String nikname) {
		this.id = id;
		this.pw = pw;
		this.nikname = nikname;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getPw() {
		return pw;
	}

	public void setPw(String pw) {
		this.pw = pw;
	}

	public String getNikname() {
		return nikname;
	}

	public void setNikname(String nikname) {
		this.nikname = nikname;
	}

}
