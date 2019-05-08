package rhythm16;

import java.awt.Button;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.util.ArrayList;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class DynamicBeat extends JFrame {

	private Image screenImage;
	private Graphics screenGraphic;
	

	// 버튼 이미지
	private ImageIcon exitButtonEnteredImage = new ImageIcon("images/exit_1.png");
	private ImageIcon exitButtonBasicImage = new ImageIcon("images/exit_2.png");
	private ImageIcon pageButtonEnteredImage = new ImageIcon("images/MYPAGE2.png");
	private ImageIcon pageButtonBasicImage = new ImageIcon("images/MYPAGE.png");
	private ImageIcon startButtonEnteredImage = new ImageIcon("images/start7.png");
	private ImageIcon startButtonBasicImage = new ImageIcon("images/start6.png");
	private ImageIcon quitButtonEnteredImage = new ImageIcon("images/quit7.png");
	private ImageIcon quitButtonBasicImage = new ImageIcon("images/quit6.png");
	private ImageIcon leftButtonEnteredImage = new ImageIcon("images/buttonclickleft2.png");
	private ImageIcon leftButtonBasicImage = new ImageIcon("images/button_left.png");
	private ImageIcon rightButtonEnteredImage = new ImageIcon("images/buttonclickright2.png");
	private ImageIcon rightButtonBasicImage = new ImageIcon("images/button_right.png");
	private ImageIcon easyButtonEnteredImage = new ImageIcon("images/easy3.png");
	private ImageIcon easyButtonBasicImage = new ImageIcon("images/easy4.png");
	private ImageIcon hardButtonEnteredImage = new ImageIcon("images/hard3.png");
	private ImageIcon hardButtonBasicImage = new ImageIcon("images/hard4.png");
	private ImageIcon backButtonEnteredImage = new ImageIcon("images/buttonclickleft2.png");
	private ImageIcon backButtonBasicImage = new ImageIcon("images/button_clickleft.png");

	// 시작화면 배경
	private Image background = new ImageIcon("images/introBackgroundTitle.jpg").getImage();
	// 닫기버튼 메뉴바
	private JLabel menuBar = new JLabel(new ImageIcon("images/menuBar.png"));

	// 버튼
	private JButton exitButton = new JButton(exitButtonBasicImage);

	private JButton pageButton = new JButton(pageButtonBasicImage);
	private JButton startButton = new JButton(startButtonBasicImage);
	private JButton quitButton = new JButton(quitButtonBasicImage);

	private JButton leftButton = new JButton(leftButtonBasicImage);
	private JButton rightButton = new JButton(rightButtonBasicImage);
	private JButton easyButton = new JButton(easyButtonBasicImage);
	private JButton hardButton = new JButton(hardButtonBasicImage);

	private JButton backButton = new JButton(backButtonBasicImage);
	private JButton backMainButton = new JButton(backButtonBasicImage);

	// 마우스 좌표
	private int mouseX, mouseY;

	private boolean isMyScreen = false;
	private boolean isMainScreen = false;
	private boolean isGameScreen = false;

	private Image titleImage;
	private Image myPageImage;
	private Image selectedImage;
	private Music selectedMusic;
	private Music introMusic = new Music("introMusic.mp3", true);
	private int nowSelected = 0;

	ArrayList<Track> trackList = new ArrayList<Track>();

	public static Game game;

	public DynamicBeat() {

		trackList.add(new Track("SecondRunTitle.png", "Reminiscence3.png", "second_run3.jpg",
				"Vanilla Mood-01-Second Run.mp3", "Vanilla Mood-01-Second Run.mp3", "Vanilla Mood - Second Run"));
		trackList.add(new Track("ReminiscenceTitle2.png", "Reminiscence.jpg", "Reminiscence2.jpg",
				"Vanilla Mood-05-Reminiscence.mp3", "Vanilla Mood-05-Reminiscence.mp3", "Vanilla Mood - Reminiscence"));

		setFocusable(true); // 현재창에 포커스
		setUndecorated(true);
		// setTitle("MINI GAME");
		setSize(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT); // 스크린 사이즈
		setResizable(false);
		setLocationRelativeTo(null); // 사이즈 고정
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setVisible(true);
		setBackground(new Color(0, 0, 0, 0));
		setLayout(null);

		// 키 이벤트
		addKeyListener(new KeyListener());

		introMusic.start();

		// 종료하기 버튼
		exitButton.setBounds(1245, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				exitButton.setIcon(exitButtonEnteredImage);
				// 마우스를 버튼 위에 올리면 커서 모양이 손모양으로 바뀜
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				exitButton.setIcon(exitButtonBasicImage);
				exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(exitButton);

		// mypage 버튼
		pageButton.setBounds(900, 290, 400, 100);
		pageButton.setBorderPainted(false);
		pageButton.setContentAreaFilled(false);
		pageButton.setFocusPainted(false);
		pageButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				pageButton.setIcon(pageButtonEnteredImage);
				pageButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				pageButton.setIcon(pageButtonBasicImage);
				pageButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				// mypage 내용: 프로필, 개인 랭킹 등 구현 예정
				mypageMain();
				
			}
		});

		add(pageButton);

		// 시작하기 버튼
		startButton.setBounds(900, 420, 325, 100);
		startButton.setBorderPainted(false);
		startButton.setContentAreaFilled(false);
		startButton.setFocusPainted(false);
		startButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				startButton.setIcon(startButtonEnteredImage);
				startButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				startButton.setIcon(startButtonBasicImage);
				startButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				enterMain();
			}
		});

		add(startButton);

		// 종료하기 버튼2
		quitButton.setBounds(900, 550, 325, 100);
		quitButton.setBorderPainted(false);
		quitButton.setContentAreaFilled(false);
		quitButton.setFocusPainted(false);
		quitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				quitButton.setIcon(quitButtonEnteredImage);
				quitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				quitButton.setIcon(quitButtonBasicImage);
				quitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				try {
					Thread.sleep(1000);
				} catch (InterruptedException ex) {
					ex.printStackTrace();
				}
				System.exit(0);
			}
		});
		add(quitButton);

		// 메인화면으로 뒤로 가기 버튼
		backMainButton.setVisible(false);
		backMainButton.setBounds(20, 50, 60, 60);
		backMainButton.setBorderPainted(false);
		backMainButton.setContentAreaFilled(false);
		backMainButton.setFocusPainted(false);
		backMainButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backMainButton.setIcon(backButtonEnteredImage);
				backMainButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backMainButton.setIcon(backButtonBasicImage);
				backMainButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				startMain();
			}
		});
		add(backMainButton);

		// 왼쪽으로 이동 버튼
		leftButton.setVisible(false);
		leftButton.setBounds(140, 310, 60, 60);
		leftButton.setBorderPainted(false);
		leftButton.setContentAreaFilled(false);
		leftButton.setFocusPainted(false);
		leftButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				leftButton.setIcon(leftButtonEnteredImage);
				leftButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				leftButton.setIcon(leftButtonBasicImage);
				leftButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectLeft();
			}
		});
		add(leftButton);

		// 오른쪽으로 이동 버튼
		rightButton.setVisible(false);
		rightButton.setBounds(1080, 310, 60, 60);
		rightButton.setBorderPainted(false);
		rightButton.setContentAreaFilled(false);
		rightButton.setFocusPainted(false);
		rightButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				rightButton.setIcon(rightButtonEnteredImage);
				rightButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				rightButton.setIcon(rightButtonBasicImage);
				rightButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				selectRight();
			}
		});
		add(rightButton);

		// 난이도 쉬움 버튼
		easyButton.setVisible(false);
		easyButton.setBounds(375, 580, 250, 67);
		easyButton.setBorderPainted(false);
		easyButton.setContentAreaFilled(false);
		easyButton.setFocusPainted(false);
		easyButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				easyButton.setIcon(easyButtonEnteredImage);
				easyButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				easyButton.setIcon(easyButtonBasicImage);
				easyButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				gameStart(nowSelected, "Easy");
			}
		});
		add(easyButton);

		// 난이도 어려움 버튼
		hardButton.setVisible(false);
		hardButton.setBounds(655, 580, 250, 67);
		hardButton.setBorderPainted(false);
		hardButton.setContentAreaFilled(false);
		hardButton.setFocusPainted(false);
		hardButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				hardButton.setIcon(hardButtonEnteredImage);
				hardButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				hardButton.setIcon(hardButtonBasicImage);
				hardButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				gameStart(nowSelected, "Hard");
			}
		});
		add(hardButton);

		// 뒤로 가기 버튼
		backButton.setVisible(false);
		backButton.setBounds(20, 50, 60, 60);
		backButton.setBorderPainted(false);
		backButton.setContentAreaFilled(false);
		backButton.setFocusPainted(false);
		backButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e) {
				backButton.setIcon(backButtonEnteredImage);
				backButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}

			@Override
			public void mouseExited(MouseEvent e) {
				backButton.setIcon(backButtonBasicImage);
				backButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
			}

			@Override
			public void mousePressed(MouseEvent e) {
				Music buttonEnteredMusic = new Music("buttonPressedMusic.mp3", false);
				buttonEnteredMusic.start();
				backMain();
				// startMain();
			}
		});
		add(backButton);

		// 종료하기 버튼 메뉴바
		menuBar.setBounds(0, 0, 1280, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		add(menuBar);
	}

	public void paint(Graphics g) {
		
		screenImage = createImage(Main.SCREEN_WIDTH, Main.SCREEN_HEIGHT);
		screenGraphic = screenImage.getGraphics();
		screenDraw((Graphics2D) screenGraphic);
		g.drawImage(screenImage, 0, 0, null);
	}

	public void screenDraw(Graphics2D g) {
		g.drawImage(background, 0, 0, null);
		if (isMyScreen) {
			int xBox = 500;
			int yBox = 500;

			Color c = new Color(0.5f, 0.5f, 0.5f, 0.5f);
			g.setPaint(c);
			g.fillRoundRect(Main.SCREEN_WIDTH / 2 - xBox / 2, Main.SCREEN_HEIGHT / 2 - yBox / 2, xBox, yBox, 20, 20);

			g.setFont(new Font("고딕", Font.BOLD, 30));
			g.setColor(Color.white);
			
			Image imgProfile = new ImageIcon("E:\\njh\\project\\javaProject\\JavaTeamProject\\Profile_image\\Profile.png").getImage();
			g.drawImage(imgProfile, Main.SCREEN_WIDTH / 2 - xBox / 2- 80, Main.SCREEN_HEIGHT / 2 - yBox / 2 , null);
			// 내 프로필 정보(구현 예정)
			
			Image imgRank = new ImageIcon("E:\\njh\\project\\javaProject\\JavaTeamProject\\Profile_image\\Ranking.png").getImage();
			g.drawImage(imgRank, Main.SCREEN_WIDTH / 2 - xBox / 2- 80, Main.SCREEN_HEIGHT / 2 - yBox / 2 + 180, null);			
			// 내 랭킹 정보(구현 예정)
			
		}
		if (isMainScreen) {
			g.drawImage(selectedImage, 340, 100, null);
			g.drawImage(titleImage, 340, 70, null);
		}
		if (isGameScreen) {
			game.screenDraw(g);
		}
		paintComponents(g);
		try {
			Thread.sleep(5);
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.repaint();
	}

	public void selectTrack(int nowSelected) {
		if (selectedMusic != null)
			selectedMusic.close();
		titleImage = new ImageIcon("images/" + trackList.get(nowSelected).getTitleImage()).getImage();
		selectedImage = new ImageIcon("images/" + trackList.get(nowSelected).getStartImage()).getImage();
		selectedMusic = new Music(trackList.get(nowSelected).getStartMusic(), true);
		selectedMusic.start();
	}

	public void selectLeft() {
		if (nowSelected == 0)
			nowSelected = trackList.size() - 1;
		else
			nowSelected--;
		selectTrack(nowSelected);
	}

	public void selectRight() {
		if (nowSelected == trackList.size() - 1)
			nowSelected = 0;
		else
			nowSelected++;
		selectTrack(nowSelected);
	}

	public void gameStart(int nowSelected, String difficulty) {
		System.out.println("gameStart");
		if (selectedMusic != null)
			selectedMusic.close();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		background = new ImageIcon("images/" + trackList.get(nowSelected).getGameImage()).getImage();
		backButton.setVisible(true);
		isGameScreen = true;
		game = new Game(trackList.get(nowSelected).getTitleName(), difficulty,
				trackList.get(nowSelected).getGameMusic());
		game.start();
		setFocusable(true);
	}

	public void startMain() {
		// my page, start, quit 선택화면
		System.out.println("startMain");
		isMyScreen = false;
		backMainButton.setVisible(false);
		pageButton.setVisible(true);
		startButton.setVisible(true);
		quitButton.setVisible(true);
		background = new ImageIcon("images/introBackGroundTitle.jpg").getImage();
		isMainScreen = false;
		leftButton.setVisible(false);
		rightButton.setVisible(false);
		easyButton.setVisible(false);
		hardButton.setVisible(false);
		introMusic.close();
		selectTrack(0);
		game.close(); // 선택화면 갈 시 게임 종료
	}

	// 곡, 난이도 선택 화면
	public void backMain() {
		System.out.println("backMain");		
		game.close(); // 선택화면 갈 시 게임 종료
		isMainScreen = true;
		isMyScreen = false;
		backMainButton.setVisible(true);
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		background = new ImageIcon("images/mainBackground3.jpg").getImage();
		backButton.setVisible(false);
		selectTrack(nowSelected);
		isGameScreen = false;
	}

	//

	public void mypageMain() {
		System.out.println("mypageMain");

		background = new ImageIcon("images/Space.jpg").getImage();
		isMyScreen = true;

		introMusic.close();
		selectTrack(0);
	}

	public void enterMain() {
		// 곡 선택 화면
		System.out.println("enterMain");
		backButton.setVisible(true);
		pageButton.setVisible(false);
		startButton.setVisible(false);
		quitButton.setVisible(false);
		background = new ImageIcon("images/mainBackground3.jpg").getImage();
		isMainScreen = true;
		isMyScreen = false;
		leftButton.setVisible(true);
		rightButton.setVisible(true);
		easyButton.setVisible(true);
		hardButton.setVisible(true);
		introMusic.close();
		selectTrack(0);
	}

	
}
