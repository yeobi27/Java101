package rhythm16;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



public class MyPage extends JFrame {
	//닫기 버튼 메뉴바 이미지
	private JLabel menuBar = new JLabel(new ImageIcon("images/menuBar.png"));
	private JLabel lbLine = new JLabel();
	private JLabel lbLine2 = new JLabel();
	//닫기 버튼 이미지
	private ImageIcon exitButtonEnteredImage = new ImageIcon("images/exit_1.png");
	private ImageIcon exitButtonBasicImage = new ImageIcon("images/exit_2.png");
	//닫기 버튼
	private JButton exitButton=new JButton(exitButtonBasicImage); 
	//마우스 좌표
	private int mouseX, mouseY;
	//경계 라인
	private ImageIcon line = new ImageIcon("images/line.png");
	
	
	public MyPage() {
		//setUndecorated(true);
		setTitle("MyPage");
		setSize(580,520);
		setResizable(false);
		setLocationRelativeTo(null);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setVisible(true);
		setLayout(null);
		
		lbLine.setBounds(0, 130, 580, 10);
		lbLine2.setBounds(0, 330, 580, 10);
		lbLine.setIcon(line);
		lbLine2.setIcon(line);
		add(lbLine);
		add(lbLine2);
		
		//종료하기 버튼 메뉴바
		menuBar.setBounds(0, 0, 580, 30);
		menuBar.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) 
			{
				mouseX = e.getX();
				mouseY = e.getY();
			}
		});
		menuBar.addMouseMotionListener(new MouseMotionAdapter()
		{
			@Override
			public void mouseDragged(MouseEvent e)
			{
				int x = e.getXOnScreen();
				int y = e.getYOnScreen();
				setLocation(x - mouseX, y - mouseY);
			}
		});
		
		
		//종료하기 버튼
		exitButton.setBounds(545, 0, 30, 30);
		exitButton.setBorderPainted(false);
		exitButton.setContentAreaFilled(false);
		exitButton.setFocusPainted(false);
		exitButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent e)
			{
				exitButton.setIcon(exitButtonEnteredImage);
				//마우스를 버튼 위에 올리면 커서 모양이 손모양으로 바뀜
				exitButton.setCursor(new Cursor(Cursor.HAND_CURSOR));
				Music buttonEnteredMusic = new Music("buttonEnteredMusic.mp3", false);
				buttonEnteredMusic.start();
			}
				@Override
				public void mouseExited(MouseEvent e) 
				{
					exitButton.setIcon(exitButtonBasicImage);
					exitButton.setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
				}
				@Override
				public void mousePressed(MouseEvent e) 
				{
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
		add(menuBar);
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		new MyPage();
	}

}
