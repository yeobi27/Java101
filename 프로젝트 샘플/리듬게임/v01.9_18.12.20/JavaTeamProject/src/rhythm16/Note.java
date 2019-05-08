package rhythm16;


import java.awt.Graphics2D;
import java.awt.Image;

import javax.swing.ImageIcon;

public class Note extends Thread {

	
	private Image noteBasicImage = new ImageIcon("images/note_blue.png").getImage();
	private Image noteBasicImage2 = new ImageIcon("images/note_red.png").getImage();
	private Image noteBasicImage3 = new ImageIcon("images/note_green.png").getImage();
	//스페이스
	private Image noteBasicImage4 = new ImageIcon("images/note_reds.png").getImage();
	
	//private int x , y = 580 - (1000 / Main.SLEEP_TIME * Main.NOTE_SPEED)* Main.REACH_TIME;
	private int x , y = 30;
	private String noteType;
	private boolean proceeded = true;
	
	
	public String getNoteType() {
		return noteType;
	}
	
	public boolean isProceeded() {
		return proceeded;
	}
	
	public void close() {
		proceeded = false;
	}
	
	//노트 속도
	public void drop() {
		y += Main.NOTE_SPEED;
		if(y > 650) {
			close();//노트 소멸
		}
	}
	
	//노트 스레드 실행
		@Override
		public void run() {
			try {
				while (true) {
					drop();
					if(proceeded) {
						Thread.sleep(Main.SLEEP_TIME);
					}
					else {
						interrupt();
						break;
					}
				}
			} catch(Exception e) {
				System.err.println(e.getMessage());
			}
		}
	
	//노트가 떨어지는 위치
	public Note(String noteType) {
		if(noteType.equals("S")) {
			x = 228;
		}
		else if(noteType.equals("D")) {
			x = 332;
		}
		else if(noteType.equals("F")) {
			x = 436;
		}
		else if(noteType.equals("Space")) {
			x = 540;
		}
		else if(noteType.equals("J")) {
			x = 744;
		}
		else if(noteType.equals("K")) {
			x = 848;
		}
		else if(noteType.equals("L")) {
			x = 952;
		}
		this.noteType = noteType;
	}
	
	public void screenDraw(Graphics2D g) {
		if(noteType.equals("Space"))
		{
			g.drawImage(noteBasicImage4, x, y, null);
		}
		if(noteType.equals("S"))
		{
			g.drawImage(noteBasicImage, x, y, null);
		}
		if(noteType.equals("D"))
		{
			g.drawImage(noteBasicImage2, x, y, null);
		}
		
		if(noteType.equals("F"))
		{
			g.drawImage(noteBasicImage3, x, y, null);
		}
		if(noteType.equals("J"))
		{
			g.drawImage(noteBasicImage3, x, y, null);
		}
		
		if(noteType.equals("K"))
		{
			g.drawImage(noteBasicImage2, x, y, null);
			
		}
		if(noteType.equals("L"))
		{
			g.drawImage(noteBasicImage, x, y, null);
		}
	}
	
	
	//노트 판정
	public String judge() {
		if(y >= 630) {
			System.out.println("Late");
			close();
			return "Late";
		}
		else if(y >= 610) {
			System.out.println("Good");
			close();
			return "Good";
			}
		else if(y >= 590) {
			System.out.println("Great");
			close();
			return "Great";
		}
		else if(y >= 580) {
			System.out.println("Perfect");
			close();
			return "Perfect";
		}
		else if(y >= 570) {
			System.out.println("Great");
			close();
			return "Great";
		}
		else if(y >= 550) {
			System.out.println("Good");
			close();
			return "Good";
		}
		else if(y >= 530) {
			System.out.println("Early");
			close();
			return "Early";
		}		
		return "None";
	}
	
	public int getY() {
		return y;
	}
}
