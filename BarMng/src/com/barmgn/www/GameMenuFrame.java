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
	MainFrame mainframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					frame = new GameMenuFrame();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GameMenuFrame(MainFrame mainframe) {
		this.mainframe = mainframe;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JPanel p1 = new JPanel();
		p1.setPreferredSize(new Dimension(480, 20));
		contentPane.add(p1);
		
		JButton btnBefore = new JButton("\uC774\uC804");
		btnBefore.setMargin(new Insets(2, 10, 2, 10));
		btnBefore.setPreferredSize(new Dimension(100, 15));
		p1.add(btnBefore);
			
		JButton btnCall = new JButton("호출");
		btnCall.setAlignmentY(0.0f);
		btnCall.setPreferredSize(new Dimension(100, 15));
		p1.add(btnCall);
		
		JPanel p2 = new JPanel();
		p2.setPreferredSize(new Dimension(460, 30));
		contentPane.add(p2);
		p2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("Playground");
		p2.add(lblNewLabel);
		
		JPanel pn = new JPanel();
		contentPane.add(pn);
		pn.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JButton btnTableVS = new JButton("테이블대전");
		pn.add(btnTableVS);
		btnTableVS.setMargin(new Insets(5, 20, 5, 20));
		btnTableVS.setPreferredSize(new Dimension(110, 200));
		
		JButton btnHam = new JButton("복불복게임");
		pn.add(btnHam);
		btnHam.setMargin(new Insets(5, 20, 5, 20));
		btnHam.setPreferredSize(new Dimension(110, 200));
		
		JButton btnRoulette = new JButton("러시안룰렛");
		pn.add(btnRoulette);
		btnRoulette.setPreferredSize(new Dimension(110, 200));
		btnRoulette.setMargin(new Insets(5, 20, 5, 20));
		
		JPanel ps = new JPanel();
		contentPane.add(ps);
		ps.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton btnChoice = new JButton("선택완료");
		btnChoice.setPreferredSize(new Dimension(640, 40));
		ps.add(btnChoice);
		
		setVisible(true);
		
		SelectedGameListener l = new SelectedGameListener(this);
		btnTableVS.addActionListener(l);
		btnHam.addActionListener(l);
		btnRoulette.addActionListener(l);
		
		btnBefore.addActionListener(l);
		btnCall.addActionListener(l);
	}
	
	class SelectedGameListener implements ActionListener{

		GameMenuFrame gframe;
		SelectedGameListener(GameMenuFrame gframe){
			this.gframe = gframe;
		}
		
		@Override
		public void actionPerformed(ActionEvent arg0) {
			// TODO Auto-generated method stub
			String g_cmd = arg0.getActionCommand();
			
			switch(g_cmd)
			{
			case "테이블대전":
				break;
			case "복불복게임":
				setVisible(false);
				new Crocodile(gframe);
				break;
			case "러시안룰렛":
				setVisible(false);
				new Roulette(gframe);
				break;
			case "이전":
				dispose();
				mainframe.setVisible(true);
				break;
			}
		
			
			
		}
	}
	
	
}
