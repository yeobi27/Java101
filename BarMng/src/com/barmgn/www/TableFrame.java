package com.barmgn.www;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.GridLayout;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.Dimension;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Component;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Point;
import javax.swing.JTabbedPane;
import javax.swing.JMenu;

public class TableFrame extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TableFrame frame = new TableFrame();
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
	public TableFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 0, 8));
		
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(480, 20));
		contentPane.add(p1);
		p1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnbefore = new JButton("?Üê ?ù¥?†Ñ?úºÎ°?");
		btnbefore.setMinimumSize(new Dimension(100, 20));
		btnbefore.setMaximumSize(new Dimension(100, 20));
		btnbefore.setAlignmentY(0.0f);
		btnbefore.setIconTextGap(0);
		btnbefore.setMargin(new Insets(0, 0, 0, 0));
		btnbefore.setPreferredSize(new Dimension(100, 15));
		p1.add(btnbefore);
		
		JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(460, 30));
		contentPane.add(p2);
		p2.setLayout(new FlowLayout(FlowLayout.LEFT, 5, 5));
		
		JLabel lblTableFrame = new JLabel("TableFrame");
		p2.add(lblTableFrame);
		
		JPanel p3 = new JPanel();
		p3.setPreferredSize(new Dimension(460, 200));
		contentPane.add(p3);
		p3.setBounds(new Rectangle(0, 0, 0, 0));
		p3.setLayout(new GridLayout(5, 5, 0, 0));
		
		JButton btnNewButton_13 = new JButton("New button");
		p3.add(btnNewButton_13);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.setPreferredSize(new Dimension(50, 50));
		p3.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("New button");
		btnNewButton_1.setPreferredSize(new Dimension(50, 50));
		p3.add(btnNewButton_1);
		
		JButton btnNewButton_23 = new JButton("New button");
		p3.add(btnNewButton_23);
		
		JButton btnNewButton_24 = new JButton("New button");
		p3.add(btnNewButton_24);
		
		JButton btnNewButton_2 = new JButton("New button");
		btnNewButton_2.setPreferredSize(new Dimension(50, 50));
		p3.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("New button");
		btnNewButton_3.setPreferredSize(new Dimension(50, 50));
		p3.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setPreferredSize(new Dimension(50, 50));
		p3.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		p3.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		p3.add(btnNewButton_6);
		
		JButton btnNewButton_21 = new JButton("New button");
		p3.add(btnNewButton_21);
		
		JButton btnNewButton_7 = new JButton("New button");
		p3.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		p3.add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("New button");
		p3.add(btnNewButton_9);
		
		JButton btnNewButton_10 = new JButton("New button");
		p3.add(btnNewButton_10);
		
		JButton btnNewButton_11 = new JButton("New button");
		p3.add(btnNewButton_11);
		
		JButton btnNewButton_12 = new JButton("New button");
		p3.add(btnNewButton_12);
		
		JButton btnNewButton_14 = new JButton("New button");
		p3.add(btnNewButton_14);
		
		JButton btnNewButton_15 = new JButton("New button");
		p3.add(btnNewButton_15);
		
		JButton btnNewButton_16 = new JButton("New button");
		p3.add(btnNewButton_16);
		
		JButton btnNewButton_17 = new JButton("New button");
		p3.add(btnNewButton_17);
		
		JButton btnNewButton_18 = new JButton("New button");
		p3.add(btnNewButton_18);
		
		JButton btnNewButton_19 = new JButton("New button");
		p3.add(btnNewButton_19);
		
		JButton btnNewButton_20 = new JButton("New button");
		p3.add(btnNewButton_20);
		
		JButton btnNewButton_22 = new JButton("New button");
		p3.add(btnNewButton_22);
		
		JPanel p4 = new JPanel();
		p4.setPreferredSize(new Dimension(480, 40));
		contentPane.add(p4);
		p4.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblCall = new JLabel("Î©îÏÑ∏Ïß? Î≥¥ÎÇº ?Öå?ù¥Î∏îÏùÑ ?àÑÎ•¥ÏÑ∏?öî");
		lblCall.setPreferredSize(new Dimension(320, 30));
		p4.add(lblCall);
		
		JButton btnExit = new JButton("?ã´Í∏?");
		btnExit.setActionCommand("New Button");
		p4.add(btnExit);
		btnExit.setAlignmentY(0.0f);
		btnExit.setPreferredSize(new Dimension(100, 30));
		
		btnExit.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();  //?ã´Í∏? 
				
			}
		});
	}

}
