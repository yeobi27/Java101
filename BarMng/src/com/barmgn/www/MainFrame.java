package com.barmgn.www;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	
	// Image Load
	// background
	ImageIcon mainbg_img = new ImageIcon("images/mainbg_img.jpg");
	// button
	ImageIcon games_img = new ImageIcon("images/games_img.png");
	ImageIcon order_img = new ImageIcon("images/order_img.png");
	ImageIcon talking_img = new ImageIcon("images/talking_img.png");
	ImageIcon bell_img = new ImageIcon("images/bell_img.png");
	ImageIcon adbtn_img = new ImageIcon("images/adbtn_img.png");
	ImageIcon menulink = new ImageIcon("images/menulink.png");
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public MainFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setUndecorated(true);
		setBackground(new Color(0, 0, 0, 0));
		setLocationRelativeTo(null);
		setBounds(100, 100, 800, 600);
		contentPane = new JPanel() {
	   	   	public void paintComponent(Graphics g) {
	   	      super.paintComponents(g); 
	   	      System.out.println("왜안나와");
	   	      setOpaque(false);
	   	      g.drawImage(mainbg_img.getImage(), 0, 0, this); // toy location
//	   	      g.drawImage(games_img.getImage(), 334, 10, this); // toy location
//	   	      g.drawImage(order_img.getImage(), 12, 10, this); // toy location
//	   	      g.drawImage(talking_img.getImage(), 12, 10, this); // toy location
//	   	      g.drawImage(bell_img.getImage(), 12, 10, this); // toy location
	   	   }
		};
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p_North = new JPanel();
		p_North.setBackground(new Color(255, 0, 0, 0)); 

		p_North.setBounds(5, 5, 774, 97);
		p_North.setPreferredSize(new Dimension(300, 34));
		contentPane.add(p_North);
		p_North.setLayout(null);
		
		JButton btnCall = new JButton("호출", bell_img);
		// Border remove
		btnCall.setBorderPainted(false);
		// don't do Text to fill 
		btnCall.setContentAreaFilled(false);
		// focus border x
		btnCall.setFocusPainted(false);
		// 투명
		btnCall.setOpaque(false);
		
		btnCall.setBounds(666, 0, 85, 92);
		btnCall.setPreferredSize(new Dimension(85, 92));
		btnCall.setMargin(new Insets(0, 0, 0, 0));
		btnCall.setAlignmentX(1.0f);
		p_North.add(btnCall);
		
		JButton btnManuLink = new JButton("메뉴링크", menulink);
		btnManuLink.setFocusPainted(false);
		btnManuLink.setContentAreaFilled(false);
		btnManuLink.setBorderPainted(false);
		btnManuLink.setBounds(12, 29, 140, 53);
		btnManuLink.setPreferredSize(new Dimension(100, 25));
		btnManuLink.setMargin(new Insets(0, 0, 0, 0));
		btnManuLink.setAlignmentY(0.0f);
		p_North.add(btnManuLink);
		
		JPanel p_West = new JPanel();
		p_North.setBackground(new Color(255,0,0,0));
		p_West.setBounds(5, 104, 220, 390);
		p_West.setPreferredSize(new Dimension(220, 300));
		contentPane.add(p_West);
		p_West.setLayout(null);
		
		JLabel lblManuImage = new JLabel("메뉴이미지");
		lblManuImage.setBounds(31, 10, 160, 15);
		p_West.add(lblManuImage);
		
		JLabel lblDESC = new JLabel("공사중..");
		lblDESC.setBounds(31, 166, 160, 15);
		p_West.add(lblDESC);
		
		JButton btnWating = new JButton("게임대기");
		btnWating.setBorderPainted(false);
		btnWating.setContentAreaFilled(false);
		btnWating.setFocusPainted(false);
		btnWating.setBounds(31, 191, 160, 160);
		btnWating.setPreferredSize(new Dimension(100, 25));
		p_West.add(btnWating);
		
		JPanel p_Center = new JPanel();
		p_Center.setBackground(new Color(255,0,0,0));
		p_Center.setBounds(225, 104, 544, 390);
		contentPane.add(p_Center);
		
		JButton btnOrder = new JButton("주문", order_img);
		btnOrder.setFocusPainted(false);
		btnOrder.setContentAreaFilled(false);
		btnOrder.setBorderPainted(false);
		btnOrder.setPreferredSize(new Dimension(170, 380));
		p_Center.add(btnOrder);
		
		JButton btnGame = new JButton("게임", games_img);
		btnGame.setContentAreaFilled(false);
		btnGame.setBorderPainted(false);
		btnGame.setFocusPainted(false);
		btnGame.setPreferredSize(new Dimension(170, 380));
		p_Center.add(btnGame);
		
		JButton btnChatting = new JButton("채팅", talking_img);
		btnChatting.setFocusPainted(false);
		btnChatting.setContentAreaFilled(false);
		btnChatting.setBorderPainted(false);
		btnChatting.setPreferredSize(new Dimension(170, 380));
		p_Center.add(btnChatting);
		
		JPanel p_South = new JPanel();
		p_South.setBackground(new Color(255,0,0,0));
		p_South.setBounds(5, 494, 774, 63);
		FlowLayout fl_p_South = (FlowLayout) p_South.getLayout();
		fl_p_South.setAlignment(FlowLayout.RIGHT);
		contentPane.add(p_South);
		
		JButton btnEvent = new JButton("광고&이벤트",adbtn_img );
		btnEvent.setContentAreaFilled(false);
		btnEvent.setBorderPainted(false);
		btnEvent.setFocusPainted(false);
		btnEvent.setSize(new Dimension(0, 200));
		btnEvent.setPreferredSize(new Dimension(140, 53));
		p_South.add(btnEvent);
		
		MainListener l = new MainListener(this);
		btnOrder.addActionListener(l);
		btnGame.addActionListener(l);
		btnChatting.addActionListener(l);
	}
	
   class MainListener implements ActionListener{

	      MainFrame frame;
	      MainListener(MainFrame frame)
	      {
	         this.frame = frame;
	      }
	      
	      @Override
	      public void actionPerformed(ActionEvent arg0) {
	         // TODO Auto-generated method stub
         
         String m_cmd = arg0.getActionCommand();
         
         switch(m_cmd)
         {
         case "주문":
            setVisible(false);
            OrderFrame orderFrame = new OrderFrame(frame);
            orderFrame.setOrderFrame(orderFrame);
            break;
         case "게임":
            setVisible(false);
            new GameMenuFrame(frame);
            break;
         case "채팅":
            setVisible(false);
            new ChattingFrame(frame);
            break;
         default:
            break;
         }
      }
      
}  
}
