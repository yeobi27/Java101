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

public class GameMenuFrame extends JFrame {

	private JPanel contentPane;
	private MainFrame fr;
	static GameMenuFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					frame = new GameMenuFrame();
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
	public GameMenuFrame() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(480, 20));
		contentPane.add(p1);
		
		JButton btnBefore = new JButton("?Üê ?ù¥?†Ñ?úºÎ°?");
		btnBefore.setMargin(new Insets(2, 10, 2, 10));
		btnBefore.setPreferredSize(new Dimension(100, 15));
		p1.add(btnBefore);
			
		JButton btncall = new JButton("?ò∏Ï∂úÌïòÍ∏?");
		btncall.setAlignmentY(0.0f);
		btncall.setPreferredSize(new Dimension(100, 15));
		p1.add(btncall);
		
		JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(460, 30));
		contentPane.add(p2);
		p2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Playground");
		p2.add(lblNewLabel);
		
		JPanel pn = new JPanel();
		contentPane.add(pn);
		pn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnNewButton_1 = new JButton("?Öå?ù¥Î∏îÎ??†Ñ");
		pn.add(btnNewButton_1);
		btnNewButton_1.setMargin(new Insets(5, 20, 5, 20));
		btnNewButton_1.setPreferredSize(new Dimension(110, 200));
		
		JButton btnNewButton_2 = new JButton("Î™®Îëê?ùò?ñâ?ö¥");
		pn.add(btnNewButton_2);
		btnNewButton_2.setMargin(new Insets(5, 20, 5, 20));
		btnNewButton_2.setPreferredSize(new Dimension(110, 200));
		
		JButton btnNewButton = new JButton("Î≥µÎ∂àÎ≥µÍ≤å?ûÑ");
		pn.add(btnNewButton);
		btnNewButton.setPreferredSize(new Dimension(110, 200));
		btnNewButton.setMargin(new Insets(5, 20, 5, 20));
		
		JPanel ps = new JPanel();
		contentPane.add(ps);
		ps.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnchoice = new JButton("?Ñ†?Éù?ôÑÎ£?");
		btnchoice.setPreferredSize(new Dimension(640, 40));
		ps.add(btnchoice);
		
		//frame.setVisible(true);
		
		btnBefore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				frame.setVisible(false);
				fr.setVisible(true); //Î©îÏù∏?îÑ?†à?ûÑ ?Üå?ôò	
			}
		});
	}
	
	
}
