package gui;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Set;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dto.Fish;
import dto.Member;
import thread.CatchGauge;
import thread.MovingFish;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.SwingConstants;

public class FishingGame extends JFrame {
	String id;
	int movement, att;
	String f_stack;
	JLabel lblFish,lblRod, lblGauge;
	Fish f;
	boolean finishFlag;
	Member m;
	
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					String id = "aaa";
//					Set<Integer> fishSet = Set<Integer>1;
					int fishSet =1;
					int rodPerformance = 100;
					int fishPower = 30;
//					FishingGame frame = new FishingGame(id, fishPower, rodPerformance, "aaa");
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public FishingGame(Member m, Fish f, int att) {
		this.m=m;;
		this.f=f;
		this.att=att;
		
		movement=f.getMovement();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 90, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(20, 60, 30, 300);
		contentPane.add(panel);
		panel.setOpaque(true);
		panel.setBackground(Color.YELLOW);
		panel.setLayout(null);
		
		lblGauge = new JLabel();
		lblGauge.setBounds(10, 200, 20, 100);
		panel.add(lblGauge);
		lblGauge.setOpaque(true);
		lblGauge.setBackground(Color.GREEN);
		
		JPanel panelGame = new JPanel();
		panelGame.setBounds(60, 60, 50, 300);
		contentPane.add(panelGame);
		panelGame.setOpaque(true);
		panelGame.setBackground(Color.ORANGE);
		panelGame.setLayout(null);
		
		lblFish = new JLabel();
		lblFish.setHorizontalAlignment(SwingConstants.CENTER);
		lblFish.setBounds(30, 140, 20, 20);
		panelGame.add(lblFish);
		ImageIcon fish = new ImageIcon("Images\\FishIcon.png");
		
		lblFish.setIcon(fish);
		
		lblRod = new JLabel();
		panelGame.add(lblRod);
		lblRod.setBounds(0, (lblRod.getParent().getHeight()-att)/2, 30, att);
		lblRod.setOpaque(true);
		lblRod.setFocusable(true);
		lblRod.setBackground(Color.RED);
		lblRod.addKeyListener(new KeyListener() {
			
			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub
				int key = e.getKeyCode();
				int x=lblRod.getX();
				int y=lblRod.getY();
				if(key==KeyEvent.VK_UP) {
					if(y<=0) {						
					}
					else
					{
						y-=10;
					}
					lblRod.setLocation(x, y);					
				}
				else if(key==KeyEvent.VK_DOWN) {
					if(y>=lblRod.getParent().getHeight()-att) {
					}
					else
					{
						y+=10;
					}
					lblRod.setLocation(x, y);
				}
			}
		});
		setVisible(true);
		
		Thread movingFish = new MovingFish(movement,lblFish);
		movingFish.start();
	
		Thread catchGauge = new CatchGauge(f,m,lblFish,lblRod,lblGauge, this);
		catchGauge.start();
		
//		this.dispose();
	}
}
