package rhythm16;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.util.ArrayList;

import javax.swing.ImageIcon;

import dao.RecodeDao;
import dto.Recode;

public class Game extends Thread {

	boolean flag = false; // 강제종료
	// 콤보,점수 전역변수
	private int combo;
	private int score;
	// 판정 노트 카운트
	private int perfectCnt;
	private int greatCnt;
	private int goodCnt;
	private int earlyCnt;
	private int lateCnt;
	private int missCnt;

	private Image noteRouteLineImage = new ImageIcon("images/noteRouteLine.png").getImage();
	private Image judgementLineImage = new ImageIcon("images/judgementLine.png").getImage();
	private Image gameInfoImage = new ImageIcon("images/gameInfo.png").getImage();

	// 노트루트 이미지
	private Image noteRouteSImage = new ImageIcon("images/noteRoute.png").getImage();
	private Image noteRouteDImage = new ImageIcon("images/noteRoute.png").getImage();
	private Image noteRouteFImage = new ImageIcon("images/noteRoute.png").getImage();
	private Image noteRouteSpaceImage = new ImageIcon("images/noteRoute2.png").getImage();
	private Image noteRouteJImage = new ImageIcon("images/noteRoute.png").getImage();
	private Image noteRouteKImage = new ImageIcon("images/noteRoute.png").getImage();
	private Image noteRouteLImage = new ImageIcon("images/noteRoute.png").getImage();

	// 엔딩 이미지
	private Image endImage = new ImageIcon("images/MainBackground3.jpg").getImage();

	// 판정 이미지
	private Image judgeImage;

	private String titleName;
	private String difficulty;
	private String musicTitle;

	private Music gameMusic; // Music.java
	private Recode recode;

	ArrayList<Note> noteList = new ArrayList<Note>();

	public Game(String titleName, String difficulty, String musicTitle) {
		this.titleName = titleName;
		this.difficulty = difficulty;
		this.musicTitle = musicTitle;

		gameMusic = new Music(this.musicTitle, false);

	}

	public void screenDraw(Graphics2D g) {
		// 노트루트 배경 위치
		g.drawImage(noteRouteSImage, 228, 30, null);
		g.drawImage(noteRouteDImage, 332, 30, null);
		g.drawImage(noteRouteFImage, 436, 30, null);
		g.drawImage(noteRouteSpaceImage, 540, 30, null);
		g.drawImage(noteRouteJImage, 744, 30, null);
		g.drawImage(noteRouteKImage, 848, 30, null);
		g.drawImage(noteRouteLImage, 952, 30, null);

		// 경계선 위치
		g.drawImage(noteRouteLineImage, 224, 30, null);
		g.drawImage(noteRouteLineImage, 328, 30, null);
		g.drawImage(noteRouteLineImage, 432, 30, null);
		g.drawImage(noteRouteLineImage, 536, 30, null);
		g.drawImage(noteRouteLineImage, 740, 30, null);
		g.drawImage(noteRouteLineImage, 844, 30, null);
		g.drawImage(noteRouteLineImage, 948, 30, null);
		g.drawImage(noteRouteLineImage, 1052, 30, null);

		// 게임 정보 위치
		g.drawImage(gameInfoImage, 0, 660, null);

		// 키보드 입력 라인 위치
		g.drawImage(judgementLineImage, 0, 580, null);

		g.setColor(Color.white);
		g.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

		// 노래제목, 난이도 표시 위치
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(titleName, 20, 702);
		g.drawString(difficulty, 1190, 702);

		// 조작키 표시 위치
		g.setFont(new Font("Arial", Font.PLAIN, 30));
		g.setColor(Color.DARK_GRAY);
		g.drawString("S", 270, 609);
		g.drawString("D", 374, 609);
		g.drawString("F", 478, 609);
		g.drawString("Space Bar", 580, 609);
		g.drawString("J", 784, 609);
		g.drawString("K", 889, 609);
		g.drawString("L", 993, 609);

		// 콤보 위치
		g.setColor(Color.ORANGE);
		g.setFont(new Font("Arial", Font.BOLD, 50));
		g.drawString(combo + "", 630, 370);

		// 점수 위치
		g.setColor(Color.WHITE);
		g.setFont(new Font("Arial", Font.BOLD, 30));
		g.drawString(score + "", 620, 702);
		g.setColor(Color.LIGHT_GRAY);
		g.setFont(new Font("Elephant", Font.BOLD, 30));

		// 판정 위치
		g.drawImage(judgeImage, 460, 420, null);

		// 판정 배경 투명
		Color c = new Color(0.0f, 0.0f, 0.0f, 0.5f);
		g.setPaint(c);
		g.fillRoundRect(1120, 80, 140, 280, 20, 20);

		// 판정 노트 카운트 이미지 위치
		g.setFont(new Font("고딕", Font.BOLD, 30));
		g.setColor(Color.RED);
		g.drawString("P", 1150, 130);
		g.setColor(Color.BLUE);
		g.drawString("G", 1150, 170);
		g.setColor(Color.GREEN);
		g.drawString("G", 1150, 210);
		g.setColor(Color.CYAN);
		g.drawString("E", 1150, 250);
		g.setColor(Color.ORANGE);
		g.drawString("L", 1150, 290);
		g.setColor(Color.LIGHT_GRAY);
		g.drawString("M", 1150, 330);

		// 판정 노트 카운트 위치
		g.setColor(Color.WHITE);
		g.drawString(perfectCnt + "", 1200, 130);
		g.drawString(greatCnt + "", 1200, 170);
		g.drawString(goodCnt + "", 1200, 210);
		g.drawString(earlyCnt + "", 1200, 250);
		g.drawString(lateCnt + "", 1200, 290);
		g.drawString(missCnt + "", 1200, 330);

		// miss 판정
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (note.getY() > 650) {
				judgeImage = new ImageIcon("images/judgeMiss.png").getImage();
				combo = 0;
				missCnt++;
				System.out.println("Miss");
			}
			if (!note.isProceeded()) {
				noteList.remove(i);
				i--;
			} else {
				note.screenDraw(g);
			}
		}
	}

	public void pressS() {
		judge("S");
		noteRouteSImage = new ImageIcon("images/noteRoutePressed.png").getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseS() {
		noteRouteSImage = new ImageIcon("images/noteRoute.png").getImage();
	}

	public void pressD() {
		judge("D");
		noteRouteDImage = new ImageIcon("images/noteRoutePressed3.png").getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseD() {
		noteRouteDImage = new ImageIcon("images/noteRoute.png").getImage();
	}

	public void pressF() {
		judge("F");
		noteRouteFImage = new ImageIcon("images/noteRoutePressed2.png").getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseF() {
		noteRouteFImage = new ImageIcon("images/noteRoute.png").getImage();
	}

	public void pressSpace() {
		judge("Space");
		noteRouteSpaceImage = new ImageIcon("images/noteRoutePressed4.png").getImage();
		new Music("drumBig1.mp3", false).start();
	}

	public void releaseSpace() {
		noteRouteSpaceImage = new ImageIcon("images/noteRoute2.png").getImage();
	}

	public void pressJ() {
		judge("J");
		noteRouteJImage = new ImageIcon("images/noteRoutePressed2.png").getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseJ() {
		noteRouteJImage = new ImageIcon("images/noteRoute.png").getImage();
	}

	public void pressK() {
		judge("K");
		noteRouteKImage = new ImageIcon("images/noteRoutePressed3.png").getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseK() {
		noteRouteKImage = new ImageIcon("images/noteRoute.png").getImage();
	}

	public void pressL() {
		judge("L");
		noteRouteLImage = new ImageIcon("images/noteRoutePressed.png").getImage();
		new Music("drumSmall1.mp3", false).start();
	}

	public void releaseL() {
		noteRouteLImage = new ImageIcon("images/noteRoute.png").getImage();
	}

	public void pressQ() {
		judge("Q");
		try {
			sleep(200);
			flag = true;
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			// endGame();

		}

	}

	// 키보드 버튼 입력 값이 들어감
	public void judge(String input) {
		for (int i = 0; i < noteList.size(); i++) {
			Note note = noteList.get(i);
			if (input.equals(note.getNoteType())) {
				judgeEvent(note.judge());
				break;
			}
		}
	}

	// 노트 판정, 점수, 콤보
	public void judgeEvent(String judge) {

		if (judge.equals("Late")) {
			judgeImage = new ImageIcon("images/judgeLate.png").getImage();
			combo++;
			lateCnt++;
			score += 3;
		} else if (judge.equals("Good")) {
			judgeImage = new ImageIcon("images/judgeGood.png").getImage();
			combo++;
			goodCnt++;
			score += 5;
		} else if (judge.equals("Great")) {
			judgeImage = new ImageIcon("images/judgeGreat.png").getImage();
			combo++;
			greatCnt++;
			score += 7;
		} else if (judge.equals("Perfect")) {
			judgeImage = new ImageIcon("images/judgePerfect.png").getImage();
			combo++;
			perfectCnt++;
			score += 10;
		} else if (judge.equals("Early")) {
			judgeImage = new ImageIcon("images/judgeEarly.png").getImage();
			combo++;
			earlyCnt++;
			score += 3;
		}
	}

	@Override
	public void run() {
		dropNotes(this.titleName);
	}

	// 음악종료
	public void close() {
		gameMusic.close();
		System.out.println("back button clicked");
		this.interrupt();
	}

/*
	// 게임 종료 후 종료화면 출력
	public void endGame(Graphics2D eg) {
		System.out.println("끝나나나나나" + score);
		// endImage 이미지 불러오기

		int xBox = 500;
		int yBox = 500;

		// Graphics2D g = null;
		Color c = new Color(1.0f, 0.0f, 0.0f);
		eg.setPaint(c);
		eg.fillRoundRect(Main.SCREEN_WIDTH / 2 - xBox / 2, Main.SCREEN_HEIGHT / 2 - yBox / 2, xBox, yBox, 20, 20);

		eg.setFont(new Font("고딕", Font.BOLD, 30));
		eg.setColor(Color.white);
		eg.drawString(" My Score: ", Main.SCREEN_WIDTH / 2 - xBox / 2, Main.SCREEN_HEIGHT / 2 - yBox / 2 + 30);
		eg.drawString(" Ranking", Main.SCREEN_WIDTH / 2 - xBox / 2, Main.SCREEN_HEIGHT / 2 - yBox / 2 + 200);

	}
*/
	public void dropNotes(String titleName) {
		Beat[] beats = null;

		if (titleName.equals("Vanilla Mood - Second Run") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] { // new Bear(밀리초, 키 자리)
					new Beat(startTime, "Space"), new Beat(startTime + gap * 10, "S"),
					new Beat(startTime + gap * 14, "S"), new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 18, "F"), new Beat(startTime + gap * 26, "Space"),
					new Beat(startTime + gap * 28, "K"), new Beat(startTime + gap * 32, "K"),
					new Beat(startTime + gap * 42, "D"), new Beat(startTime + gap * 49, "K"),
					new Beat(startTime + gap * 52, "Space"), new Beat(startTime + gap * 56, "D"),
					new Beat(startTime + gap * 59, "K"), new Beat(startTime + gap * 61, "L"),
					new Beat(startTime + gap * 65, "Space"), new Beat(startTime + gap * 65, "J"),
					new Beat(startTime + gap * 74, "S"), new Beat(startTime + gap * 85, "S"),
					new Beat(startTime + gap * 91, "D"), new Beat(startTime + gap * 98, "J"),
					new Beat(startTime + gap * 100, "Space"), new Beat(startTime + gap * 109, "Space"),
					new Beat(startTime + gap * 118, "S"), new Beat(startTime + gap * 120, "F"),
					new Beat(startTime + gap * 123, "S"), new Beat(startTime + gap * 125, "F"),
					new Beat(startTime + gap * 126, "J"), new Beat(startTime + gap * 133, "K"),
					new Beat(startTime + gap * 136, "L"), new Beat(startTime + gap * 144, "Space"),
					new Beat(startTime + gap * 152, "Space"), new Beat(startTime + gap * 153, "Space"),
					new Beat(startTime + gap * 154, "Space"), new Beat(startTime + gap * 155, "Space"),
					new Beat(startTime + gap * 156, "Space"), new Beat(startTime + gap * 157, "Space"),
					new Beat(startTime + gap * 157, "J"), new Beat(startTime + gap * 165, "L"),
					new Beat(startTime + gap * 167, "S"), new Beat(startTime + gap * 171, "F"),
					new Beat(startTime + gap * 176, "D"), new Beat(startTime + gap * 178, "F"),
					new Beat(startTime + gap * 181, "L"), new Beat(startTime + gap * 184, "Space"),
					new Beat(startTime + gap * 189, "J"), new Beat(startTime + gap * 196, "D"),
					new Beat(startTime + gap * 196, "Space"), new Beat(startTime + gap * 200, "Space"),
					new Beat(startTime + gap * 207, "J"), new Beat(startTime + gap * 211, "K"),
					new Beat(startTime + gap * 216, "L"), new Beat(startTime + gap * 218, "Space"),
					new Beat(startTime + gap * 221, "J"), new Beat(startTime + gap * 227, "Space"),
					new Beat(startTime + gap * 231, "D"), new Beat(startTime + gap * 235, "Space"),
					new Beat(startTime + gap * 242, "Spcae"), new Beat(startTime + gap * 246, "D"),
					new Beat(startTime + gap * 246, "K"), new Beat(startTime + gap * 250, "J"),
					new Beat(startTime + gap * 259, "K"), new Beat(startTime + gap * 262, "S"),
					new Beat(startTime + gap * 266, "Space"), new Beat(startTime + gap * 270, "Space"),
					new Beat(startTime + gap * 277, "K"), new Beat(startTime + gap * 282, "J"),
					new Beat(startTime + gap * 289, "J"), new Beat(startTime + gap * 291, "K"),
					new Beat(startTime + gap * 297, "F"), new Beat(startTime + gap * 299, "D"),
					new Beat(startTime + gap * 301, "S"), new Beat(startTime + gap * 306, "D"),
					new Beat(startTime + gap * 312, "D"), new Beat(startTime + gap * 319, "D"),
					new Beat(startTime + gap * 321, "S"), new Beat(startTime + gap * 330, "F"),
					new Beat(startTime + gap * 336, "D"), new Beat(startTime + gap * 336, "Space"),
					new Beat(startTime + gap * 340, "S"), new Beat(startTime + gap * 340, "Space"),
					new Beat(startTime + gap * 336, "D"), new Beat(startTime + gap * 336, "Space"),
					new Beat(startTime + gap * 340, "S"), new Beat(startTime + gap * 340, "Space"),
					new Beat(startTime + gap * 343, "S"), new Beat(startTime + gap * 346, "S"),
					new Beat(startTime + gap * 349, "S"), new Beat(startTime + gap * 350, "S"),
					new Beat(startTime + gap * 351, "S"), new Beat(startTime + gap * 352, "S"),
					new Beat(startTime + gap * 353, "S"), new Beat(startTime + gap * 354, "S"),
					new Beat(startTime + gap * 355, "J"), new Beat(startTime + gap * 360, "Space"),
					new Beat(startTime + gap * 361, "Space"), new Beat(startTime + gap * 362, "Space"),
					new Beat(startTime + gap * 363, "Space"), new Beat(startTime + gap * 364, "Space"),
					new Beat(startTime + gap * 365, "Space"), new Beat(startTime + gap * 366, "Space"),
					new Beat(startTime + gap * 370, "L"), new Beat(startTime + gap * 371, "D"),
					new Beat(startTime + gap * 372, "S"), new Beat(startTime + gap * 373, "D"),
					new Beat(startTime + gap * 374, "F"), new Beat(startTime + gap * 375, "Space"),
					new Beat(startTime + gap * 376, "J"), new Beat(startTime + gap * 377, "K"),
					new Beat(startTime + gap * 378, "L"), new Beat(startTime + gap * 379, "L"),
					new Beat(startTime + gap * 380, "L"), new Beat(startTime + gap * 381, "L"),
					new Beat(startTime + gap * 382, "L"), new Beat(startTime + gap * 385, "Space"),
					new Beat(startTime + gap * 388, "F"), new Beat(startTime + gap * 390, "Space"),
					new Beat(startTime + gap * 392, "Space"), new Beat(startTime + gap * 399, "F"),
					new Beat(startTime + gap * 402, "D"), new Beat(startTime + gap * 405, "S"),
					new Beat(startTime + gap * 408, "J"), new Beat(startTime + gap * 411, "K"),
					new Beat(startTime + gap * 414, "L"), new Beat(startTime + gap * 417, "L"),
					new Beat(startTime + gap * 420, "K"), new Beat(startTime + gap * 423, "J"),
					new Beat(startTime + gap * 428, "Space"), new Beat(startTime + gap * 431, "F"),
					new Beat(startTime + gap * 435, "D"), new Beat(startTime + gap * 439, "S"),
					new Beat(startTime + gap * 443, "D"), new Beat(startTime + gap * 448, "F"),
					new Beat(startTime + gap * 449, "Space"), new Beat(startTime + gap * 454, "J"),
					new Beat(startTime + gap * 458, "K"), new Beat(startTime + gap * 461, "L"),
					new Beat(startTime + gap * 464, "K"), new Beat(startTime + gap * 468, "K"),
					new Beat(startTime + gap * 472, "K"), new Beat(startTime + gap * 473, "K"),
					new Beat(startTime + gap * 478, "K"), new Beat(startTime + gap * 481, "L"),
					new Beat(startTime + gap * 484, "L"), new Beat(startTime + gap * 489, "L"),
					new Beat(startTime + gap * 493, "L"), new Beat(startTime + gap * 495, "S"),
					new Beat(startTime + gap * 496, "S"), new Beat(startTime + gap * 499, "S"),
					new Beat(startTime + gap * 503, "S"), new Beat(startTime + gap * 509, "S"),
					new Beat(startTime + gap * 514, "S"), new Beat(startTime + gap * 517, "S"),
					new Beat(startTime + gap * 521, "S"), new Beat(startTime + gap * 524, "K"),
					new Beat(startTime + gap * 528, "K"), new Beat(startTime + gap * 529, "K"),
					new Beat(startTime + gap * 533, "K"), new Beat(startTime + gap * 537, "K"),
					new Beat(startTime + gap * 537, "K"), new Beat(startTime + gap * 537, "K"),
					new Beat(startTime + gap * 537, "D"), new Beat(startTime + gap * 537, "D"),
					new Beat(startTime + gap * 537, "D"), new Beat(startTime + gap * 537, "D"),
					new Beat(startTime + gap * 537, "D"), new Beat(startTime + gap * 537, "D"),
					new Beat(startTime + gap * 537, "Space"), new Beat(startTime + gap * 543, "Space"),
					new Beat(startTime + gap * 549, "S"), new Beat(startTime + gap * 552, "D"),
					new Beat(startTime + gap * 557, "F"), new Beat(startTime + gap * 561, "Space"),
					new Beat(startTime + gap * 563, "J"), new Beat(startTime + gap * 568, "K"),
					new Beat(startTime + gap * 571, "L"), new Beat(startTime + gap * 575, "K"),
					new Beat(startTime + gap * 579, "J"), new Beat(startTime + gap * 583, "F"),
					new Beat(startTime + gap * 586, "D"), new Beat(startTime + gap * 589, "F"),
					new Beat(startTime + gap * 592, "F"), new Beat(startTime + gap * 595, "F"),
					new Beat(startTime + gap * 599, "F"), new Beat(startTime + gap * 603, "F"),
					new Beat(startTime + gap * 607, "S"), new Beat(startTime + gap * 610, "D"),
					new Beat(startTime + gap * 615, "F"), new Beat(startTime + gap * 618, "Space"),
					new Beat(startTime + gap * 621, "J"), new Beat(startTime + gap * 624, "K"),
					new Beat(startTime + gap * 627, "L"), new Beat(startTime + gap * 630, "K"),
					new Beat(startTime + gap * 632, "J"), new Beat(startTime + gap * 637, "Space"),
					new Beat(startTime + gap * 639, "F"), new Beat(startTime + gap * 641, "D"),
					new Beat(startTime + gap * 643, "S"), new Beat(startTime + gap * 644, "D"),
					new Beat(startTime + gap * 646, "F"), new Beat(startTime + gap * 648, "Space"),
					new Beat(startTime + gap * 651, "D"), new Beat(startTime + gap * 653, "S"),
					new Beat(startTime + gap * 656, "D"), new Beat(startTime + gap * 659, "F"),
					new Beat(startTime + gap * 659, "J"), new Beat(startTime + gap * 663, "F"),
					new Beat(startTime + gap * 663, "J"), new Beat(startTime + gap * 666, "F"),
					new Beat(startTime + gap * 666, "J"), new Beat(startTime + gap * 668, "F"),
					new Beat(startTime + gap * 668, "J"), new Beat(startTime + gap * 668, "Space"),
					new Beat(startTime + gap * 670, "F"), new Beat(startTime + gap * 670, "J"),
					new Beat(startTime + gap * 670, "Space"), new Beat(startTime + gap * 672, "F"),
					new Beat(startTime + gap * 672, "J"), new Beat(startTime + gap * 672, "Space"),
					new Beat(startTime + gap * 675, "D"), new Beat(startTime + gap * 678, "S"),
					new Beat(startTime + gap * 681, "D"), new Beat(startTime + gap * 683, "S"),
					new Beat(startTime + gap * 685, "D"), new Beat(startTime + gap * 688, "S"),
					new Beat(startTime + gap * 691, "D"), new Beat(startTime + gap * 694, "J"),
					new Beat(startTime + gap * 697, "K"), new Beat(startTime + gap * 700, "J"),
					new Beat(startTime + gap * 702, "K"), new Beat(startTime + gap * 705, "J"),
					new Beat(startTime + gap * 708, "K"), new Beat(startTime + gap * 711, "J"),
					new Beat(startTime + gap * 714, "K"), new Beat(startTime + gap * 717, "S"),
					new Beat(startTime + gap * 720, "D"), new Beat(startTime + gap * 723, "S"),
					new Beat(startTime + gap * 726, "D"), new Beat(startTime + gap * 729, "S"),
					new Beat(startTime + gap * 731, "D"), new Beat(startTime + gap * 734, "J"),
					new Beat(startTime + gap * 737, "K"), new Beat(startTime + gap * 740, "L"),
					new Beat(startTime + gap * 743, "F"), new Beat(startTime + gap * 747, "Space"),
					new Beat(startTime + gap * 750, "J"), new Beat(startTime + gap * 753, "S"),
					new Beat(startTime + gap * 755, "D"), new Beat(startTime + gap * 757, "F"),
					new Beat(startTime + gap * 760, "Space"), new Beat(startTime + gap * 762, "J"),
					new Beat(startTime + gap * 765, "L"), new Beat(startTime + gap * 768, "K"),
					new Beat(startTime + gap * 771, "F"), new Beat(startTime + gap * 774, "Space"),
					new Beat(startTime + gap * 777, "J"), new Beat(startTime + gap * 779, "S"),
					new Beat(startTime + gap * 781, "S"), new Beat(startTime + gap * 784, "S"),
					new Beat(startTime + gap * 787, "L"), new Beat(startTime + gap * 789, "Space"),
					new Beat(startTime + gap * 791, "S"), new Beat(startTime + gap * 793, "D"),
					new Beat(startTime + gap * 796, "S"), new Beat(startTime + gap * 799, "D"),
					new Beat(startTime + gap * 802, "F"), new Beat(startTime + gap * 805, "Space"),
					new Beat(startTime + gap * 808, "L"), new Beat(startTime + gap * 811, "Space"),
					new Beat(startTime + gap * 814, "S"), new Beat(startTime + gap * 817, "D"),
					new Beat(startTime + gap * 820, "Space"), new Beat(startTime + gap * 823, "Space"),
					new Beat(startTime + gap * 826, "Space"), new Beat(startTime + gap * 829, "Space"),
					new Beat(startTime + gap * 832, "S"), new Beat(startTime + gap * 835, "D"),
					new Beat(startTime + gap * 837, "F"), new Beat(startTime + gap * 840, "S"),
					new Beat(startTime + gap * 842, "D"), new Beat(startTime + gap * 845, "F"),
					new Beat(startTime + gap * 848, "J"), new Beat(startTime + gap * 851, "K"),
					new Beat(startTime + gap * 854, "J"), new Beat(startTime + gap * 857, "K"),
					new Beat(startTime + gap * 860, "L"), new Beat(startTime + gap * 863, "S"),
					new Beat(startTime + gap * 866, "Space"), new Beat(startTime + gap * 868, "S"),
					new Beat(startTime + gap * 871, "Space"), new Beat(startTime + gap * 874, "Space"),
					new Beat(startTime + gap * 876, "Space"), new Beat(startTime + gap * 879, "Space"),
					new Beat(startTime + gap * 881, "J"), new Beat(startTime + gap * 884, "K"),
					new Beat(startTime + gap * 888, "L"), new Beat(startTime + gap * 891, "S"),
					new Beat(startTime + gap * 894, "D"), new Beat(startTime + gap * 897, "F"),
					new Beat(startTime + gap * 900, "S"), new Beat(startTime + gap * 901, "D"),
					new Beat(startTime + gap * 903, "F"), new Beat(startTime + gap * 905, "Space"),
					new Beat(startTime + gap * 908, "L"), new Beat(startTime + gap * 911, "Space"),
					new Beat(startTime + gap * 914, "L"), new Beat(startTime + gap * 917, "K"),
					new Beat(startTime + gap * 920, "J"), new Beat(startTime + gap * 923, "S"),
					new Beat(startTime + gap * 926, "Space"), new Beat(startTime + gap * 929, "D"),
					new Beat(startTime + gap * 931, "Space"), new Beat(startTime + gap * 934, "S"),
					new Beat(startTime + gap * 937, "Space"), new Beat(startTime + gap * 940, "J"),
					new Beat(startTime + gap * 943, "Space"), new Beat(startTime + gap * 946, "K"),
					new Beat(startTime + gap * 947, "Space"), new Beat(startTime + gap * 949, "L"),
					new Beat(startTime + gap * 951, "Space"), new Beat(startTime + gap * 954, "Space"),
					new Beat(startTime + gap * 957, "J"), new Beat(startTime + gap * 960, "K"),
					new Beat(startTime + gap * 963, "L"), new Beat(startTime + gap * 967, "Space"),
					new Beat(startTime + gap * 970, "D"), new Beat(startTime + gap * 974, "Space"),
					new Beat(startTime + gap * 977, "S"), new Beat(startTime + gap * 980, "Space"),
					new Beat(startTime + gap * 983, "S"), new Beat(startTime + gap * 986, "Spcae"),
					new Beat(startTime + gap * 989, "L"), new Beat(startTime + gap * 991, "D"),
					new Beat(startTime + gap * 994, "Space"), new Beat(startTime + gap * 997, "K"),
					new Beat(startTime + gap * 1000, "F") };

		} else if (titleName.equals("Vanilla Mood - Second Run") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime, "Space"), new Beat(startTime + gap * 2, "D"),
					new Beat(startTime + gap * 4, "S"), new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 8, "S"), new Beat(startTime + gap * 10, "D"),
					new Beat(startTime + gap * 12, "S"), new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 18, "J"), new Beat(startTime + gap * 20, "K"),
					new Beat(startTime + gap * 22, "J"), new Beat(startTime + gap * 24, "K"),
					new Beat(startTime + gap * 26, "J"), new Beat(startTime + gap * 28, "K"),
					new Beat(startTime + gap * 30, "J"), new Beat(startTime + gap * 32, "K"),
					new Beat(startTime + gap * 36, "S"), new Beat(startTime + gap * 38, "D"),
					new Beat(startTime + gap * 40, "S"), new Beat(startTime + gap * 42, "D"),
					new Beat(startTime + gap * 44, "S"), new Beat(startTime + gap * 46, "D"),
					new Beat(startTime + gap * 48, "J"), new Beat(startTime + gap * 49, "K"),
					new Beat(startTime + gap * 50, "L"), new Beat(startTime + gap * 52, "F"),
					new Beat(startTime + gap * 52, "Space"), new Beat(startTime + gap * 52, "J"),
					new Beat(startTime + gap * 54, "S"), new Beat(startTime + gap * 56, "D"),
					new Beat(startTime + gap * 59, "F"), new Beat(startTime + gap * 59, "Space"),
					new Beat(startTime + gap * 59, "J"), new Beat(startTime + gap * 61, "L"),
					new Beat(startTime + gap * 63, "K"), new Beat(startTime + gap * 65, "F"),
					new Beat(startTime + gap * 65, "Space"), new Beat(startTime + gap * 65, "J"),
					new Beat(startTime + gap * 70, "S"), new Beat(startTime + gap * 72, "S"),
					new Beat(startTime + gap * 74, "S"), new Beat(startTime + gap * 80, "L"),
					new Beat(startTime + gap * 83, "Space"), new Beat(startTime + gap * 85, "S"),
					new Beat(startTime + gap * 87, "D"), new Beat(startTime + gap * 89, "S"),
					new Beat(startTime + gap * 91, "D"), new Beat(startTime + gap * 93, "F"),
					new Beat(startTime + gap * 96, "Space"), new Beat(startTime + gap * 98, "L"),
					new Beat(startTime + gap * 100, "Space"), new Beat(startTime + gap * 102, "S"),
					new Beat(startTime + gap * 104, "D"), new Beat(startTime + gap * 106, "Space"),
					new Beat(startTime + gap * 109, "Space"), new Beat(startTime + gap * 111, "Space"),
					new Beat(startTime + gap * 116, "Space"), new Beat(startTime + gap * 118, "S"),
					new Beat(startTime + gap * 119, "D"), new Beat(startTime + gap * 120, "F"),
					new Beat(startTime + gap * 123, "S"), new Beat(startTime + gap * 124, "D"),
					new Beat(startTime + gap * 125, "F"), new Beat(startTime + gap * 126, "J"),
					new Beat(startTime + gap * 127, "K"), new Beat(startTime + gap * 130, "J"),
					new Beat(startTime + gap * 133, "K"), new Beat(startTime + gap * 136, "L"),
					new Beat(startTime + gap * 138, "S"), new Beat(startTime + gap * 140, "Space"),
					new Beat(startTime + gap * 142, "S"), new Beat(startTime + gap * 144, "Space"),
					new Beat(startTime + gap * 146, "Space"), new Beat(startTime + gap * 150, "Space"),
					new Beat(startTime + gap * 152, "Space"), new Beat(startTime + gap * 157, "J"),
					new Beat(startTime + gap * 161, "K"), new Beat(startTime + gap * 165, "L"),
					new Beat(startTime + gap * 167, "S"), new Beat(startTime + gap * 169, "D"),
					new Beat(startTime + gap * 171, "F"), new Beat(startTime + gap * 174, "S"),
					new Beat(startTime + gap * 176, "D"), new Beat(startTime + gap * 178, "F"),
					new Beat(startTime + gap * 180, "Space"), new Beat(startTime + gap * 181, "L"),
					new Beat(startTime + gap * 184, "Space"), new Beat(startTime + gap * 187, "L"),
					new Beat(startTime + gap * 188, "K"), new Beat(startTime + gap * 189, "J"),
					new Beat(startTime + gap * 192, "S"), new Beat(startTime + gap * 192, "Space"),
					new Beat(startTime + gap * 196, "D"), new Beat(startTime + gap * 196, "Space"),
					new Beat(startTime + gap * 200, "S"), new Beat(startTime + gap * 200, "Space"),
					new Beat(startTime + gap * 207, "J"), new Beat(startTime + gap * 207, "Space"),
					new Beat(startTime + gap * 211, "K"), new Beat(startTime + gap * 211, "Space"),
					new Beat(startTime + gap * 216, "L"), new Beat(startTime + gap * 216, "Space"),
					new Beat(startTime + gap * 218, "Space"), new Beat(startTime + gap * 221, "J"),
					new Beat(startTime + gap * 223, "K"), new Beat(startTime + gap * 225, "L"),
					new Beat(startTime + gap * 227, "Space"), new Beat(startTime + gap * 231, "D"),
					new Beat(startTime + gap * 231, "Space"), new Beat(startTime + gap * 235, "S"),
					new Beat(startTime + gap * 235, "Space"), new Beat(startTime + gap * 242, "S"),
					new Beat(startTime + gap * 242, "Spcae"), new Beat(startTime + gap * 242, "L"),
					new Beat(startTime + gap * 246, "D"), new Beat(startTime + gap * 246, "Space"),
					new Beat(startTime + gap * 246, "K"), new Beat(startTime + gap * 250, "F"),
					new Beat(startTime + gap * 250, "Space"), new Beat(startTime + gap * 250, "J"),
					new Beat(startTime + gap * 255, "J"), new Beat(startTime + gap * 257, "K"),
					new Beat(startTime + gap * 259, "K"), new Beat(startTime + gap * 262, "S"),
					new Beat(startTime + gap * 262, "Space"), new Beat(startTime + gap * 262, "D"),
					new Beat(startTime + gap * 266, "Space"), new Beat(startTime + gap * 270, "Space"),
					new Beat(startTime + gap * 275, "J"), new Beat(startTime + gap * 277, "K"),
					new Beat(startTime + gap * 279, "L"), new Beat(startTime + gap * 282, "J"),
					new Beat(startTime + gap * 284, "K"), new Beat(startTime + gap * 286, "L"),
					new Beat(startTime + gap * 289, "J"), new Beat(startTime + gap * 291, "K"),
					new Beat(startTime + gap * 293, "L"), new Beat(startTime + gap * 295, "J"),
					new Beat(startTime + gap * 297, "F"), new Beat(startTime + gap * 299, "D"),
					new Beat(startTime + gap * 301, "S"), new Beat(startTime + gap * 304, "F"),
					new Beat(startTime + gap * 306, "D"), new Beat(startTime + gap * 308, "S"),
					new Beat(startTime + gap * 310, "F"), new Beat(startTime + gap * 312, "D"),
					new Beat(startTime + gap * 314, "S"), new Beat(startTime + gap * 317, "F"),
					new Beat(startTime + gap * 319, "D"), new Beat(startTime + gap * 321, "S"),
					new Beat(startTime + gap * 323, "F"), new Beat(startTime + gap * 325, "D"),
					new Beat(startTime + gap * 327, "S"), new Beat(startTime + gap * 330, "F"),
					new Beat(startTime + gap * 332, "S"), new Beat(startTime + gap * 332, "Space"),
					new Beat(startTime + gap * 336, "D"), new Beat(startTime + gap * 336, "Space"),
					new Beat(startTime + gap * 340, "S"), new Beat(startTime + gap * 340, "Space"),
					new Beat(startTime + gap * 336, "D"), new Beat(startTime + gap * 336, "Space"),
					new Beat(startTime + gap * 340, "S"), new Beat(startTime + gap * 340, "Space"),
					new Beat(startTime + gap * 343, "S"), new Beat(startTime + gap * 346, "S"),
					new Beat(startTime + gap * 349, "S"), new Beat(startTime + gap * 350, "S"),
					new Beat(startTime + gap * 351, "S"), new Beat(startTime + gap * 352, "S"),
					new Beat(startTime + gap * 353, "S"), new Beat(startTime + gap * 354, "S"),
					new Beat(startTime + gap * 355, "J"), new Beat(startTime + gap * 360, "Space"),
					new Beat(startTime + gap * 361, "Space"), new Beat(startTime + gap * 362, "Space"),
					new Beat(startTime + gap * 363, "Space"), new Beat(startTime + gap * 364, "Space"),
					new Beat(startTime + gap * 365, "Space"), new Beat(startTime + gap * 366, "Space"),
					new Beat(startTime + gap * 370, "L"), new Beat(startTime + gap * 371, "D"),
					new Beat(startTime + gap * 372, "S"), new Beat(startTime + gap * 373, "D"),
					new Beat(startTime + gap * 374, "F"), new Beat(startTime + gap * 375, "Space"),
					new Beat(startTime + gap * 376, "J"), new Beat(startTime + gap * 377, "K"),
					new Beat(startTime + gap * 378, "L"), new Beat(startTime + gap * 379, "L"),
					new Beat(startTime + gap * 380, "L"), new Beat(startTime + gap * 381, "L"),
					new Beat(startTime + gap * 382, "L"), new Beat(startTime + gap * 385, "Space"),
					new Beat(startTime + gap * 388, "F"), new Beat(startTime + gap * 390, "Space"),
					new Beat(startTime + gap * 392, "Space"), new Beat(startTime + gap * 399, "F"),
					new Beat(startTime + gap * 402, "D"), new Beat(startTime + gap * 405, "S"),
					new Beat(startTime + gap * 408, "J"), new Beat(startTime + gap * 411, "K"),
					new Beat(startTime + gap * 414, "L"), new Beat(startTime + gap * 417, "L"),
					new Beat(startTime + gap * 420, "K"), new Beat(startTime + gap * 423, "J"),
					new Beat(startTime + gap * 428, "Space"), new Beat(startTime + gap * 431, "F"),
					new Beat(startTime + gap * 435, "D"), new Beat(startTime + gap * 439, "S"),
					new Beat(startTime + gap * 443, "D"), new Beat(startTime + gap * 448, "F"),
					new Beat(startTime + gap * 449, "Space"), new Beat(startTime + gap * 454, "J"),
					new Beat(startTime + gap * 458, "K"), new Beat(startTime + gap * 461, "L"),
					new Beat(startTime + gap * 464, "K"), new Beat(startTime + gap * 468, "K"),
					new Beat(startTime + gap * 472, "K"), new Beat(startTime + gap * 473, "K"),
					new Beat(startTime + gap * 478, "K"), new Beat(startTime + gap * 481, "L"),
					new Beat(startTime + gap * 484, "L"), new Beat(startTime + gap * 489, "L"),
					new Beat(startTime + gap * 493, "L"), new Beat(startTime + gap * 495, "S"),
					new Beat(startTime + gap * 496, "S"), new Beat(startTime + gap * 499, "S"),
					new Beat(startTime + gap * 503, "S"), new Beat(startTime + gap * 509, "S"),
					new Beat(startTime + gap * 514, "S"), new Beat(startTime + gap * 517, "S"),
					new Beat(startTime + gap * 521, "S"), new Beat(startTime + gap * 524, "K"),
					new Beat(startTime + gap * 528, "K"), new Beat(startTime + gap * 529, "K"),
					new Beat(startTime + gap * 533, "K"), new Beat(startTime + gap * 537, "K"),
					new Beat(startTime + gap * 537, "K"), new Beat(startTime + gap * 537, "K"),
					new Beat(startTime + gap * 537, "D"), new Beat(startTime + gap * 537, "D"),
					new Beat(startTime + gap * 537, "D"), new Beat(startTime + gap * 537, "D"),
					new Beat(startTime + gap * 537, "D"), new Beat(startTime + gap * 537, "D"),
					new Beat(startTime + gap * 537, "Space"), new Beat(startTime + gap * 543, "Space"),
					new Beat(startTime + gap * 549, "S"), new Beat(startTime + gap * 552, "D"),
					new Beat(startTime + gap * 557, "F"), new Beat(startTime + gap * 561, "Space"),
					new Beat(startTime + gap * 563, "J"), new Beat(startTime + gap * 568, "K"),
					new Beat(startTime + gap * 571, "L"), new Beat(startTime + gap * 575, "K"),
					new Beat(startTime + gap * 579, "J"), new Beat(startTime + gap * 583, "F"),
					new Beat(startTime + gap * 586, "D"), new Beat(startTime + gap * 589, "F"),
					new Beat(startTime + gap * 592, "F"), new Beat(startTime + gap * 595, "F"),
					new Beat(startTime + gap * 599, "F"), new Beat(startTime + gap * 603, "F"),
					new Beat(startTime + gap * 607, "S"), new Beat(startTime + gap * 610, "D"),
					new Beat(startTime + gap * 615, "F"), new Beat(startTime + gap * 618, "Space"),
					new Beat(startTime + gap * 621, "J"), new Beat(startTime + gap * 624, "K"),
					new Beat(startTime + gap * 627, "L"), new Beat(startTime + gap * 630, "K"),
					new Beat(startTime + gap * 632, "J"), new Beat(startTime + gap * 637, "Space"),
					new Beat(startTime + gap * 639, "F"), new Beat(startTime + gap * 641, "D"),
					new Beat(startTime + gap * 643, "S"), new Beat(startTime + gap * 644, "D"),
					new Beat(startTime + gap * 646, "F"), new Beat(startTime + gap * 648, "Space"),
					new Beat(startTime + gap * 651, "D"), new Beat(startTime + gap * 653, "S"),
					new Beat(startTime + gap * 656, "D"), new Beat(startTime + gap * 659, "F"),
					new Beat(startTime + gap * 659, "J"), new Beat(startTime + gap * 663, "F"),
					new Beat(startTime + gap * 663, "J"), new Beat(startTime + gap * 666, "F"),
					new Beat(startTime + gap * 666, "J"), new Beat(startTime + gap * 668, "F"),
					new Beat(startTime + gap * 668, "J"), new Beat(startTime + gap * 668, "Space"),
					new Beat(startTime + gap * 670, "F"), new Beat(startTime + gap * 670, "J"),
					new Beat(startTime + gap * 670, "Space"), new Beat(startTime + gap * 672, "F"),
					new Beat(startTime + gap * 672, "J"), new Beat(startTime + gap * 672, "Space"),
					new Beat(startTime + gap * 675, "D"), new Beat(startTime + gap * 678, "S"),
					new Beat(startTime + gap * 681, "D"), new Beat(startTime + gap * 683, "S"),
					new Beat(startTime + gap * 685, "D"), new Beat(startTime + gap * 688, "S"),
					new Beat(startTime + gap * 691, "D"), new Beat(startTime + gap * 694, "J"),
					new Beat(startTime + gap * 697, "K"), new Beat(startTime + gap * 700, "J"),
					new Beat(startTime + gap * 702, "K"), new Beat(startTime + gap * 705, "J"),
					new Beat(startTime + gap * 708, "K"), new Beat(startTime + gap * 711, "J"),
					new Beat(startTime + gap * 714, "K"), new Beat(startTime + gap * 717, "S"),
					new Beat(startTime + gap * 720, "D"), new Beat(startTime + gap * 723, "S"),
					new Beat(startTime + gap * 726, "D"), new Beat(startTime + gap * 729, "S"),
					new Beat(startTime + gap * 731, "D"), new Beat(startTime + gap * 734, "J"),
					new Beat(startTime + gap * 737, "K"), new Beat(startTime + gap * 740, "L"),
					new Beat(startTime + gap * 743, "F"), new Beat(startTime + gap * 747, "Space"),
					new Beat(startTime + gap * 750, "J"), new Beat(startTime + gap * 753, "S"),
					new Beat(startTime + gap * 755, "D"), new Beat(startTime + gap * 757, "F"),
					new Beat(startTime + gap * 760, "Space"), new Beat(startTime + gap * 762, "J"),
					new Beat(startTime + gap * 765, "L"), new Beat(startTime + gap * 768, "K"),
					new Beat(startTime + gap * 771, "F"), new Beat(startTime + gap * 774, "Space"),
					new Beat(startTime + gap * 777, "J"), new Beat(startTime + gap * 779, "S"),
					new Beat(startTime + gap * 781, "S"), new Beat(startTime + gap * 784, "S"),
					new Beat(startTime + gap * 787, "L"), new Beat(startTime + gap * 789, "Space"),
					new Beat(startTime + gap * 791, "S"), new Beat(startTime + gap * 793, "D"),
					new Beat(startTime + gap * 796, "S"), new Beat(startTime + gap * 799, "D"),
					new Beat(startTime + gap * 802, "F"), new Beat(startTime + gap * 805, "Space"),
					new Beat(startTime + gap * 808, "L"), new Beat(startTime + gap * 811, "Space"),
					new Beat(startTime + gap * 814, "S"), new Beat(startTime + gap * 817, "D"),
					new Beat(startTime + gap * 820, "Space"), new Beat(startTime + gap * 823, "Space"),
					new Beat(startTime + gap * 826, "Space"), new Beat(startTime + gap * 829, "Space"),
					new Beat(startTime + gap * 832, "S"), new Beat(startTime + gap * 835, "D"),
					new Beat(startTime + gap * 837, "F"), new Beat(startTime + gap * 840, "S"),
					new Beat(startTime + gap * 842, "D"), new Beat(startTime + gap * 845, "F"),
					new Beat(startTime + gap * 848, "J"), new Beat(startTime + gap * 851, "K"),
					new Beat(startTime + gap * 854, "J"), new Beat(startTime + gap * 857, "K"),
					new Beat(startTime + gap * 860, "L"), new Beat(startTime + gap * 863, "S"),
					new Beat(startTime + gap * 866, "Space"), new Beat(startTime + gap * 868, "S"),
					new Beat(startTime + gap * 871, "Space"), new Beat(startTime + gap * 874, "Space"),
					new Beat(startTime + gap * 876, "Space"), new Beat(startTime + gap * 879, "Space"),
					new Beat(startTime + gap * 881, "J"), new Beat(startTime + gap * 884, "K"),
					new Beat(startTime + gap * 888, "L"), new Beat(startTime + gap * 891, "S"),
					new Beat(startTime + gap * 894, "D"), new Beat(startTime + gap * 897, "F"),
					new Beat(startTime + gap * 900, "S"), new Beat(startTime + gap * 901, "D"),
					new Beat(startTime + gap * 903, "F"), new Beat(startTime + gap * 905, "Space"),
					new Beat(startTime + gap * 908, "L"), new Beat(startTime + gap * 911, "Space"),
					new Beat(startTime + gap * 914, "L"), new Beat(startTime + gap * 917, "K"),
					new Beat(startTime + gap * 920, "J"), new Beat(startTime + gap * 923, "S"),
					new Beat(startTime + gap * 926, "Space"), new Beat(startTime + gap * 929, "D"),
					new Beat(startTime + gap * 931, "Space"), new Beat(startTime + gap * 934, "S"),
					new Beat(startTime + gap * 937, "Space"), new Beat(startTime + gap * 940, "J"),
					new Beat(startTime + gap * 943, "Space"), new Beat(startTime + gap * 946, "K"),
					new Beat(startTime + gap * 947, "Space"), new Beat(startTime + gap * 949, "L"),
					new Beat(startTime + gap * 951, "Space"), new Beat(startTime + gap * 954, "Space"),
					new Beat(startTime + gap * 957, "J"), new Beat(startTime + gap * 960, "K"),
					new Beat(startTime + gap * 963, "L"), new Beat(startTime + gap * 967, "Space"),
					new Beat(startTime + gap * 970, "D"), new Beat(startTime + gap * 974, "Space"),
					new Beat(startTime + gap * 977, "S"), new Beat(startTime + gap * 980, "Space"),
					new Beat(startTime + gap * 983, "S"), new Beat(startTime + gap * 986, "Spcae"),
					new Beat(startTime + gap * 989, "L"), new Beat(startTime + gap * 991, "D"),
					new Beat(startTime + gap * 994, "Space"), new Beat(startTime + gap * 997, "K"),
					new Beat(startTime + gap * 1000, "F")

			};
		} else if (titleName.equals("Vanilla Mood - Reminiscence") && difficulty.equals("Easy")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime, "Space"), new Beat(startTime + gap * 2, "D"),
					new Beat(startTime + gap * 4, "S"), new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 8, "S"), new Beat(startTime + gap * 10, "D"),
					new Beat(startTime + gap * 12, "S"), new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 18, "J"), new Beat(startTime + gap * 20, "K"),
					new Beat(startTime + gap * 22, "J"), new Beat(startTime + gap * 24, "K"),
					new Beat(startTime + gap * 26, "J"), new Beat(startTime + gap * 28, "K"),
					new Beat(startTime + gap * 30, "J"), new Beat(startTime + gap * 32, "K"),
					new Beat(startTime + gap * 36, "S"), new Beat(startTime + gap * 38, "D"),
					new Beat(startTime + gap * 40, "S"), new Beat(startTime + gap * 42, "D"),
					new Beat(startTime + gap * 44, "S"), new Beat(startTime + gap * 46, "D"),
					new Beat(startTime + gap * 48, "J"), new Beat(startTime + gap * 49, "K"),
					new Beat(startTime + gap * 50, "L"), new Beat(startTime + gap * 52, "F"),
					new Beat(startTime + gap * 52, "Space"), new Beat(startTime + gap * 52, "J"),
					new Beat(startTime + gap * 54, "S"), new Beat(startTime + gap * 56, "D"),
					new Beat(startTime + gap * 59, "F"), new Beat(startTime + gap * 59, "Space"),
					new Beat(startTime + gap * 59, "J"), new Beat(startTime + gap * 61, "L"),
					new Beat(startTime + gap * 63, "K"), new Beat(startTime + gap * 65, "F"),
					new Beat(startTime + gap * 65, "Space"), new Beat(startTime + gap * 65, "J"),
					new Beat(startTime + gap * 70, "S"), new Beat(startTime + gap * 72, "S"),
					new Beat(startTime + gap * 74, "S"), new Beat(startTime + gap * 80, "L"),
					new Beat(startTime + gap * 83, "Space"), new Beat(startTime + gap * 85, "S"),
					new Beat(startTime + gap * 87, "D"), new Beat(startTime + gap * 89, "S"),
					new Beat(startTime + gap * 91, "D"), new Beat(startTime + gap * 93, "F"),
					new Beat(startTime + gap * 96, "Space"), new Beat(startTime + gap * 98, "L"),
					new Beat(startTime + gap * 100, "Space"), new Beat(startTime + gap * 102, "S"),
					new Beat(startTime + gap * 104, "D"), new Beat(startTime + gap * 106, "Space"),
					new Beat(startTime + gap * 109, "Space"), new Beat(startTime + gap * 111, "Space"),
					new Beat(startTime + gap * 116, "Space"), new Beat(startTime + gap * 118, "S"),
					new Beat(startTime + gap * 119, "D"), new Beat(startTime + gap * 120, "F"),
					new Beat(startTime + gap * 123, "S"), new Beat(startTime + gap * 124, "D"),
					new Beat(startTime + gap * 125, "F"), new Beat(startTime + gap * 126, "J"),
					new Beat(startTime + gap * 127, "K"), new Beat(startTime + gap * 130, "J"),
					new Beat(startTime + gap * 133, "K"), new Beat(startTime + gap * 136, "L"),
					new Beat(startTime + gap * 138, "S"), new Beat(startTime + gap * 140, "Space"),
					new Beat(startTime + gap * 142, "S"), new Beat(startTime + gap * 144, "Space"),
					new Beat(startTime + gap * 146, "Space"), new Beat(startTime + gap * 150, "Space"),
					new Beat(startTime + gap * 152, "Space"), new Beat(startTime + gap * 157, "J"),
					new Beat(startTime + gap * 161, "K"), new Beat(startTime + gap * 165, "L"),
					new Beat(startTime + gap * 167, "S"), new Beat(startTime + gap * 169, "D"),
					new Beat(startTime + gap * 171, "F"), new Beat(startTime + gap * 174, "S"),
					new Beat(startTime + gap * 176, "D"), new Beat(startTime + gap * 178, "F"),
					new Beat(startTime + gap * 180, "Space"), new Beat(startTime + gap * 181, "L"),
					new Beat(startTime + gap * 184, "Space"), new Beat(startTime + gap * 187, "L"),
					new Beat(startTime + gap * 188, "K"), new Beat(startTime + gap * 189, "J"),
					new Beat(startTime + gap * 192, "S"), new Beat(startTime + gap * 192, "Space"),
					new Beat(startTime + gap * 196, "D"), new Beat(startTime + gap * 196, "Space"),
					new Beat(startTime + gap * 200, "S"), new Beat(startTime + gap * 200, "Space"),
					new Beat(startTime + gap * 207, "J"), new Beat(startTime + gap * 207, "Space"),
					new Beat(startTime + gap * 211, "K"), new Beat(startTime + gap * 211, "Space"),
					new Beat(startTime + gap * 216, "L"), new Beat(startTime + gap * 216, "Space"),
					new Beat(startTime + gap * 218, "Space"), new Beat(startTime + gap * 221, "J"),
					new Beat(startTime + gap * 223, "K"), new Beat(startTime + gap * 225, "L"),
					new Beat(startTime + gap * 227, "Space"), new Beat(startTime + gap * 231, "D"),
					new Beat(startTime + gap * 231, "Space"), new Beat(startTime + gap * 235, "S"),
					new Beat(startTime + gap * 235, "Space"), new Beat(startTime + gap * 242, "S"),
					new Beat(startTime + gap * 242, "Spcae"), new Beat(startTime + gap * 242, "L"),
					new Beat(startTime + gap * 246, "D"), new Beat(startTime + gap * 246, "Space"),
					new Beat(startTime + gap * 246, "K"), new Beat(startTime + gap * 250, "F"),
					new Beat(startTime + gap * 250, "Space"), new Beat(startTime + gap * 250, "J"),
					new Beat(startTime + gap * 255, "J"), new Beat(startTime + gap * 257, "K"),
					new Beat(startTime + gap * 259, "K"), new Beat(startTime + gap * 262, "S"),
					new Beat(startTime + gap * 262, "Space"), new Beat(startTime + gap * 262, "D"),
					new Beat(startTime + gap * 266, "Space"), new Beat(startTime + gap * 270, "Space"),
					new Beat(startTime + gap * 275, "J"), new Beat(startTime + gap * 277, "K"),
					new Beat(startTime + gap * 279, "L"), new Beat(startTime + gap * 282, "J"),
					new Beat(startTime + gap * 284, "K"), new Beat(startTime + gap * 286, "L"),
					new Beat(startTime + gap * 289, "J"), new Beat(startTime + gap * 291, "K"),
					new Beat(startTime + gap * 293, "L"), new Beat(startTime + gap * 295, "J"),
					new Beat(startTime + gap * 297, "F"), new Beat(startTime + gap * 299, "D"),
					new Beat(startTime + gap * 301, "S"), new Beat(startTime + gap * 304, "F"),
					new Beat(startTime + gap * 306, "D"), new Beat(startTime + gap * 308, "S"),
					new Beat(startTime + gap * 310, "F"), new Beat(startTime + gap * 312, "D"),
					new Beat(startTime + gap * 314, "S"), new Beat(startTime + gap * 317, "F"),
					new Beat(startTime + gap * 319, "D"), new Beat(startTime + gap * 321, "S"),
					new Beat(startTime + gap * 323, "F"), new Beat(startTime + gap * 325, "D"),
					new Beat(startTime + gap * 327, "S"), new Beat(startTime + gap * 330, "F"),
					new Beat(startTime + gap * 332, "S"), new Beat(startTime + gap * 332, "Space"),
					new Beat(startTime + gap * 336, "D"), new Beat(startTime + gap * 336, "Space"),
					new Beat(startTime + gap * 340, "S"), new Beat(startTime + gap * 340, "Space") };
		} else if (titleName.equals("Vanilla Mood - Reminiscence") && difficulty.equals("Hard")) {
			int startTime = 1000 - Main.REACH_TIME * 1000;
			int gap = 125;
			beats = new Beat[] { new Beat(startTime, "Space"), new Beat(startTime + gap * 2, "D"),
					new Beat(startTime + gap * 4, "S"), new Beat(startTime + gap * 6, "D"),
					new Beat(startTime + gap * 8, "S"), new Beat(startTime + gap * 10, "D"),
					new Beat(startTime + gap * 12, "S"), new Beat(startTime + gap * 14, "D"),
					new Beat(startTime + gap * 18, "J"), new Beat(startTime + gap * 20, "K"),
					new Beat(startTime + gap * 22, "J"), new Beat(startTime + gap * 24, "K"),
					new Beat(startTime + gap * 26, "J"), new Beat(startTime + gap * 28, "K"),
					new Beat(startTime + gap * 30, "J"), new Beat(startTime + gap * 32, "K"),
					new Beat(startTime + gap * 36, "S"), new Beat(startTime + gap * 38, "D"),
					new Beat(startTime + gap * 40, "S"), new Beat(startTime + gap * 42, "D"),
					new Beat(startTime + gap * 44, "S"), new Beat(startTime + gap * 46, "D"),
					new Beat(startTime + gap * 48, "J"), new Beat(startTime + gap * 49, "K"),
					new Beat(startTime + gap * 50, "L"), new Beat(startTime + gap * 52, "F"),
					new Beat(startTime + gap * 52, "Space"), new Beat(startTime + gap * 52, "J"),
					new Beat(startTime + gap * 54, "S"), new Beat(startTime + gap * 56, "D"),
					new Beat(startTime + gap * 59, "F"), new Beat(startTime + gap * 59, "Space"),
					new Beat(startTime + gap * 59, "J"), new Beat(startTime + gap * 61, "L"),
					new Beat(startTime + gap * 63, "K"), new Beat(startTime + gap * 65, "F"),
					new Beat(startTime + gap * 65, "Space"), new Beat(startTime + gap * 65, "J"),
					new Beat(startTime + gap * 70, "S"), new Beat(startTime + gap * 72, "S"),
					new Beat(startTime + gap * 74, "S"), new Beat(startTime + gap * 80, "L"),
					new Beat(startTime + gap * 83, "Space"), new Beat(startTime + gap * 85, "S"),
					new Beat(startTime + gap * 87, "D"), new Beat(startTime + gap * 89, "S"),
					new Beat(startTime + gap * 91, "D"), new Beat(startTime + gap * 93, "F"),
					new Beat(startTime + gap * 96, "Space"), new Beat(startTime + gap * 98, "L"),
					new Beat(startTime + gap * 100, "Space"), new Beat(startTime + gap * 102, "S"),
					new Beat(startTime + gap * 104, "D"), new Beat(startTime + gap * 106, "Space"),
					new Beat(startTime + gap * 109, "Space"), new Beat(startTime + gap * 111, "Space"),
					new Beat(startTime + gap * 116, "Space"), new Beat(startTime + gap * 118, "S"),
					new Beat(startTime + gap * 119, "D"), new Beat(startTime + gap * 120, "F"),
					new Beat(startTime + gap * 123, "S"), new Beat(startTime + gap * 124, "D"),
					new Beat(startTime + gap * 125, "F"), new Beat(startTime + gap * 126, "J"),
					new Beat(startTime + gap * 127, "K"), new Beat(startTime + gap * 130, "J"),
					new Beat(startTime + gap * 133, "K"), new Beat(startTime + gap * 136, "L"),
					new Beat(startTime + gap * 138, "S"), new Beat(startTime + gap * 140, "Space"),
					new Beat(startTime + gap * 142, "S"), new Beat(startTime + gap * 144, "Space"),
					new Beat(startTime + gap * 146, "Space"), new Beat(startTime + gap * 150, "Space"),
					new Beat(startTime + gap * 152, "Space"), new Beat(startTime + gap * 157, "J"),
					new Beat(startTime + gap * 161, "K"), new Beat(startTime + gap * 165, "L"),
					new Beat(startTime + gap * 167, "S"), new Beat(startTime + gap * 169, "D"),
					new Beat(startTime + gap * 171, "F"), new Beat(startTime + gap * 174, "S"),
					new Beat(startTime + gap * 176, "D"), new Beat(startTime + gap * 178, "F"),
					new Beat(startTime + gap * 180, "Space"), new Beat(startTime + gap * 181, "L"),
					new Beat(startTime + gap * 184, "Space"), new Beat(startTime + gap * 187, "L"),
					new Beat(startTime + gap * 188, "K"), new Beat(startTime + gap * 189, "J"),
					new Beat(startTime + gap * 192, "S"), new Beat(startTime + gap * 192, "Space"),
					new Beat(startTime + gap * 196, "D"), new Beat(startTime + gap * 196, "Space"),
					new Beat(startTime + gap * 200, "S"), new Beat(startTime + gap * 200, "Space"),
					new Beat(startTime + gap * 207, "J"), new Beat(startTime + gap * 207, "Space"),
					new Beat(startTime + gap * 211, "K"), new Beat(startTime + gap * 211, "Space"),
					new Beat(startTime + gap * 216, "L"), new Beat(startTime + gap * 216, "Space"),
					new Beat(startTime + gap * 218, "Space"), new Beat(startTime + gap * 221, "J"),
					new Beat(startTime + gap * 223, "K"), new Beat(startTime + gap * 225, "L"),
					new Beat(startTime + gap * 227, "Space"), new Beat(startTime + gap * 231, "D"),
					new Beat(startTime + gap * 231, "Space"), new Beat(startTime + gap * 235, "S"),
					new Beat(startTime + gap * 235, "Space"), new Beat(startTime + gap * 242, "S"),
					new Beat(startTime + gap * 242, "Spcae"), new Beat(startTime + gap * 242, "L"),
					new Beat(startTime + gap * 246, "D"), new Beat(startTime + gap * 246, "Space"),
					new Beat(startTime + gap * 246, "K"), new Beat(startTime + gap * 250, "F"),
					new Beat(startTime + gap * 250, "Space"), new Beat(startTime + gap * 250, "J"),
					new Beat(startTime + gap * 255, "J"), new Beat(startTime + gap * 257, "K"),
					new Beat(startTime + gap * 259, "K"), new Beat(startTime + gap * 262, "S"),
					new Beat(startTime + gap * 262, "Space"), new Beat(startTime + gap * 262, "D"),
					new Beat(startTime + gap * 266, "Space"), new Beat(startTime + gap * 270, "Space"),
					new Beat(startTime + gap * 275, "J"), new Beat(startTime + gap * 277, "K"),
					new Beat(startTime + gap * 279, "L"), new Beat(startTime + gap * 282, "J"),
					new Beat(startTime + gap * 284, "K"), new Beat(startTime + gap * 286, "L"),
					new Beat(startTime + gap * 289, "J"), new Beat(startTime + gap * 291, "K"),
					new Beat(startTime + gap * 293, "L"), new Beat(startTime + gap * 295, "J"),
					new Beat(startTime + gap * 297, "F"), new Beat(startTime + gap * 299, "D"),
					new Beat(startTime + gap * 301, "S"), new Beat(startTime + gap * 304, "F"),
					new Beat(startTime + gap * 306, "D"), new Beat(startTime + gap * 308, "S"),
					new Beat(startTime + gap * 310, "F"), new Beat(startTime + gap * 312, "D"),
					new Beat(startTime + gap * 314, "S"), new Beat(startTime + gap * 317, "F"),
					new Beat(startTime + gap * 319, "D"), new Beat(startTime + gap * 321, "S"),
					new Beat(startTime + gap * 323, "F"), new Beat(startTime + gap * 325, "D"),
					new Beat(startTime + gap * 327, "S"), new Beat(startTime + gap * 330, "F"),
					new Beat(startTime + gap * 332, "S"), new Beat(startTime + gap * 332, "Space"),
					new Beat(startTime + gap * 336, "D"), new Beat(startTime + gap * 336, "Space"),
					new Beat(startTime + gap * 340, "S"), new Beat(startTime + gap * 340, "Space")

			};
		}

		int i = 0;
		gameMusic.start();
		// 게임 play
		while (i < beats.length && !isInterrupted()) {
			if (flag) // 강제종료
				break;
			boolean dropped = false;
			if (beats[i].getTime() <= gameMusic.getTime()) {
				Note note = new Note(beats[i].getNoteName());
				note.start();
				noteList.add(note);
				i++;
				dropped = true;
				System.out.println("비트 스코어" + score);
			}
			if (!dropped) {
				try {
					Thread.sleep(5);
				} catch (InterruptedException e) {

				}
			}

		}

		try {
			sleep(1000);
			System.out.println("게임 종료");
			System.out.println("최종점수 : " + score);

			RecodeDao recodeDao = RecodeDao.getInstance();

			recode = new Recode(titleName, difficulty, score);			
			recodeDao.insert(login.Start.su, recode);
			recodeDao.selectAll();
			// 작업중
			//recodeDao.selectOne(login.Start.su);
			try {
				new result.LastRank();
				
				System.out.println("rank 출력");
			}catch(Exception e) {
				System.out.println("rank 출력실패");
			}
			//endGame();
		} catch (Exception e) {

		}

	}

}
