package dto;

public class Recode {
	private String id;
	private String titleName;
	private String difficulty;
	private int score;

	public Recode() {
	}

	public Recode(String titleName, String difficulty, int score) {
		super();
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.score = score;
	}

	public Recode(String id, String titleName, String difficulty, int score) {
		super();
		this.id = id;
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.score = score;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTitleName() {
		return titleName;
	}

	public void setTitleName(String titleName) {
		this.titleName = titleName;
	}

	public String getDifficulty() {
		return difficulty;
	}

	public void setDifficulty(String difficulty) {
		this.difficulty = difficulty;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

}
