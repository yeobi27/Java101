package com.barmgn.www;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import javax.swing.JLabel;
import java.awt.Point;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.Insets;

public class MainFrame extends JFrame {

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
		setBounds(new Rectangle(5, 5, 0, 0));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 360);
		getContentPane().setLayout(new BorderLayout(5,5));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(300, 34));
		getContentPane().add(panel, BorderLayout.NORTH);
		
		JButton btnCall = new JButton("호출");
		btnCall.setBounds(349, 10, 100, 25);
		btnCall.setMargin(new Insets(0, 0, 0, 0));
		btnCall.setAlignmentX(Component.RIGHT_ALIGNMENT);
		btnCall.setPreferredSize(new Dimension(100, 25));
		btnCall.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel.setLayout(null);
		panel.add(btnCall);
		
		JButton btnManuLink = new JButton("메뉴링크");
		btnManuLink.setBounds(12, 10, 100, 25);
		btnManuLink.setAlignmentY(0.0f);
		btnManuLink.setMargin(new Insets(0, 0, 0, 0));
		btnManuLink.setHorizontalTextPosition(SwingConstants.CENTER);
		btnManuLink.setPreferredSize(new Dimension(100, 25));
		btnManuLink.setVerticalAlignment(SwingConstants.BOTTOM);
		panel.add(btnManuLink);
		btnManuLink.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			}
		});
		
		JPanel panel_1 = new JPanel();
		panel_1.setPreferredSize(new Dimension(125, 360));
		getContentPane().add(panel_1, BorderLayout.WEST);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblManuImage = new JLabel("\uBA54\uB274\uC774\uBBF8\uC9C0");
		panel_1.add(lblManuImage);
		
		JLabel lblDesc = new JLabel("DESC_LB");
		panel_1.add(lblDesc);
		
		JButton btnWating = new JButton("게임대기");
		btnWating.setPreferredSize(new Dimension(100, 25));
		panel_1.add(btnWating);
		
		JPanel panel_2 = new JPanel();
		getContentPane().add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnOrder = new JButton("주문");
		btnOrder.setPreferredSize(new Dimension(60, 200));
		panel_2.add(btnOrder);
		

		JButton btnGame = new JButton("게임");
		btnGame.setPreferredSize(new Dimension(60, 200));
		panel_2.add(btnGame);
		

		JButton btnChatting = new JButton("채팅");
		btnChatting.setPreferredSize(new Dimension(60, 200));
		panel_2.add(btnChatting);
		
		JPanel panel_3 = new JPanel();
		panel_3.setPreferredSize(new Dimension(125, 360));
		getContentPane().add(panel_3, BorderLayout.EAST);
		
		JButton btnTableService = new JButton("\uD14C\uC774\uBE14\uC11C\uBE44\uC2A4");
		btnTableService.setPreferredSize(new Dimension(100, 25));
		panel_3.add(btnTableService);
		

		JButton btnBill = new JButton("계산서");
		btnBill.setPreferredSize(new Dimension(100, 25));
		btnBill.setAlignmentX(Component.RIGHT_ALIGNMENT);
		panel_3.add(btnBill);
		
		JPanel panel_4 = new JPanel();
		getContentPane().add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton button = new JButton("\uAD11\uACE0&\uC774\uBCA4\uD2B8");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		button.setPreferredSize(new Dimension(100, 25));
		panel_4.add(button);
		button.setSize(new Dimension(0,200));
		
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
				new OrderFrame(frame);
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
