package com.barmgn.www;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class Roulette extends JFrame {
	
	private bottlePanel bp;
	GameMenuFrame gamemenuFrame;
	boolean b_flag = false;
	JButton btnStart;
	JButton btnClose;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					Roulette frame = new Roulette();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
		
	class bottlePanel extends JComponent{

		double d=0;
		double d_plus;
		double x = (Math.random()*500)+10;
		
		protected void paintComponent(Graphics g) {
			
			super.paintComponent(g);
	
			if(d == 0)
			{
				d_plus = 13;
			}
			else if(d > 2000 && d < 3500)
			{
				d_plus = 6;
			}
			else if(d > 3500 && d < 3999)
			{
				d_plus = 3;
			}
			else if(d > 4000+x)
			{
				d_plus = 0;
				b_flag = false;
//				getContentPane().add(btnStart);
//				btnStart.setVisible(true);
//				getContentPane().add(btnClose);
//				btnClose.setVisible(true);
			}
			
			BufferedImage bottle=LoadImage("images/bottle.png");
			BufferedImage deck=LoadImage("images/deck.jpg");
//			Image bottle=LoadImage("images/bottle.png");
//			Image deck=LoadImage("images/deck.jpg");
	
			AffineTransform at=AffineTransform.getTranslateInstance(230, 80);
			at.rotate(Math.toRadians(d = d + d_plus), bottle.getWidth()/2, bottle.getHeight()/2);	
			
			System.out.println(d);
			
			Graphics2D g2d = (Graphics2D) g;

			// 바탕화면
			g2d.drawImage(deck, 0, 0, null);
			
			// 맥주병
			g2d.drawImage(bottle, at , null);
			
			g2d.dispose();
			
			if(b_flag==false)
			{
				getContentPane().add(btnStart);
				btnStart.setVisible(true);
				getContentPane().add(btnClose);
				btnClose.setVisible(true);
			}

			if(b_flag==true) {
				repaint();
			}

		}
	}
	
	private BufferedImage LoadImage(String bottlerun) {
		// TODO Auto-generated method stub
		
		
		BufferedImage img=null;
		
		try {
			
			img=ImageIO.read(new File(bottlerun));
			
		}catch(Exception e) {
			
		}
		return img;
	}

	/**
	 * Create the frame.
	 */
	public Roulette(GameMenuFrame gamemenuFrame) {
		this.gamemenuFrame = gamemenuFrame;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 600);
		
		bp = new bottlePanel();
		
		bp.setBorder(new EmptyBorder(5, 5, 5, 5));
		bp.setLayout(new BorderLayout(0, 0));
		setContentPane(bp);
		
		getContentPane().setLayout(null);

		setVisible(true);
		
		btnStart = new JButton("시작");
		btnStart.setBounds(340, 520, 100, 30);
		getContentPane().add(btnStart);
		btnStart.setVisible(true);
		
		btnClose = new JButton("닫기");
		btnClose.setBounds(12, 10, 97, 23);
		getContentPane().add(btnClose);
		btnClose.setVisible(true);
		
		BottleListner l = new BottleListner();
		btnStart.addActionListener(l);
		btnClose.addActionListener(l);
	}
	
	class BottleListner implements ActionListener{
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String b_cmd = e.getActionCommand();
			
			switch(b_cmd)
			{
			case "시작":
				b_flag = true;
				bp = new bottlePanel();
				add(bp);
				repaint();
				break;
			case "닫기":
				dispose();
				gamemenuFrame.setVisible(true);
				break;
			}
		}
		
	}
//
//	private JPanel Jp;
//	boolean b_flag = false;
//	GameMenuFrame gamemenuFrame;
//	private bottlePanel bp;
//
//	/**
//	 * Launch the application.
//	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
////					Roulette frame = new Roulette();
////					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}
//		
//	class bottleThread extends Thread{
//		
//		boolean flag = false;
//		
//		public void finish() {
//			flag = true;
//		}
//		
//		
//		public void run() {
//			
//			while(true) {
//				try {
//					bottlePanel B_panel = new bottlePanel();
//					B_panel.setBounds(0, 0, 800, 600);
//					Jp.add(B_panel);
//					
//				} catch ( Exception e ) {
//					// TODO Auto-generated catch block
//					e.printStackTrace();
//				}
//				
//				if(flag == true) 
//				{
//					return;
//				}
//				
//				repaint();
//			}
//		}
//	}
//	
//	class bottlePanel extends JPanel{
//		int i=0;
//		public void paintComponent(Graphics g) {
//
//			super.paintComponent(g);
//
//			BufferedImage deck=LoadImage("images/deck.jpg");
//			BufferedImage bottle=LoadImage("images/bottle.png");
//	
//			AffineTransform at=AffineTransform.getTranslateInstance(230, 50);
//			at.rotate(Math.toRadians(i), bottle.getWidth()/2, bottle.getHeight()/2);	
//
//			Graphics2D g2d = (Graphics2D) g;
//			
//			g2d.drawImage(deck, 0, 0, null);
//			g2d.drawImage(bottle, at , null);
//			
//			g2d.dispose();
//			
//			if(b_flag == true)
//			{
//				repaint();
//			}
//		}
//	}
//	
////	class backPanel extends JPanel{
////		
////		public void paintComponent(Graphics g) {
////
////			super.paintComponent(g);
////
////			BufferedImage deck=LoadImage("images/deck.jpg");
////		
////			Graphics2D g2d = (Graphics2D) g;
////			
////			g2d.drawImage(deck, 0, 0, null);
////
////			
////			g2d.dispose();
////			
//////			repaint();
////		}
////	}
//	
//		
////	public void paintComponent(Graphics g) {
////	
////		super.paintComponents(g);
////		BufferedImage deck=LoadImage("images/deck.jpg");
////
////		Graphics2D g2d = (Graphics2D) g;
////		
////		g2d.drawImage(deck, 0, 0, null);
////		
////		g2d.dispose();
////	}
//	
//	
//	private BufferedImage LoadImage(String bottlerun) {
//		// TODO Auto-generated method stub
//		
//		BufferedImage img=null;
//		
//		try {
//			img=ImageIO.read(new File(bottlerun));
//			
//		}catch(Exception e) {
//			
//		}
//		return img;
//	}
//
//	/**
//	 * Create the frame.
//	 */
//	public Roulette(GameMenuFrame gamemenuFrame) {
//		this.gamemenuFrame = gamemenuFrame;
//		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		setBounds(100, 100, 800, 600);
//		Jp = new JPanel();
//		Jp.setBorder(new EmptyBorder(5, 5, 5, 5));
//		setContentPane(Jp);
//		
//		bp = new bottlePanel();
//		getContentPane().add(bp);
//		Jp.setLayout(null);
//		
//		JButton btnClose = new JButton("\uB2EB\uAE30");
//		btnClose.setBounds(12, 10, 97, 25);
//		getContentPane().add(btnClose);
//		
//		JButton btnStart = new JButton("\uC2DC\uC791");
//		btnStart.setBounds(343, 526, 100, 25);
//		getContentPane().add(btnStart);
//		
//		setVisible(true);
//		
//		BottleListner l = new BottleListner();
//		btnStart.addActionListener(l);
//		btnClose.addActionListener(l);
//	}
//	
//	class BottleListner implements ActionListener{
//		
//		@Override
//		public void actionPerformed(ActionEvent e) {
//			// TODO Auto-generated method stub
//			String b_cmd = e.getActionCommand();
//			
//			switch(b_cmd)
//			{
//			case "시작":
//				System.out.println("시작버튼있는곳");
//				b_flag = true;
//				bp = new bottlePanel();
//				Jp.add(bp);
//				Jp.repaint();
////				bp.repaint();
//				System.out.println(b_flag);
////				System.out.println("시작버튼쪽");
////				bThread = new bottleThread();
////				bThread.start();
//				break;
//			case "닫기":
//				dispose();
//				new GameMenuFrame();
//				break;
//			}
//		}
//		
//	}
}