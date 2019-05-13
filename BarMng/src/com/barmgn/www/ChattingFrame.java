package com.barmgn.www;
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.GridLayout;
import javax.swing.JTextArea;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.ComponentOrientation;
import javax.swing.JTextPane;
import java.awt.Rectangle;
import javax.swing.SwingConstants;
import javax.swing.JTabbedPane;
import javax.swing.JTextField;

public class ChattingFrame extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	MainFrame mainframe;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					ChattingFrame frame = new ChattingFrame();
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
	public ChattingFrame(MainFrame mainframe) {
		this.mainframe = mainframe;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(280, 0, 182, 260);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 0, 277, 313);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JButton button = new JButton("<<<");
		button.setPreferredSize(new Dimension(50, 50));
		button.setBounds(127, 205, 76, 25);
		panel_1.add(button);
		
		JButton btnSendAll = new JButton("\uC804\uCCB4 \uBCF4\uB0B4\uAE30");
		btnSendAll.setBounds(78, 229, 125, 25);
		panel_1.add(btnSendAll);
		btnSendAll.setPreferredSize(new Dimension(100, 25));
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.setBounds(0, 0, 274, 200);
		panel_1.add(tabbedPane);
		
		JTextArea txtrNoNoNo = new JTextArea();
		tabbedPane.addTab("전체", null, txtrNoNoNo, null);
		txtrNoNoNo.setTabSize(12);
		txtrNoNoNo.setText("No.1\r\nNo,2\r\nNo.3");
		txtrNoNoNo.setName("");
		
		JTabbedPane tabbedPane_1 = new JTabbedPane(JTabbedPane.RIGHT);
		tabbedPane.addTab("개인", null, tabbedPane_1, null);
		
		textField = new JTextField();
		textField.setBounds(12, 205, 116, 24);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(278, 260, 182, 52);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnBack = new JButton("\uC774\uC804");
		btnBack.setBounds(82, 27, 100, 25);
		btnBack.setComponentOrientation(ComponentOrientation.LEFT_TO_RIGHT);
		panel_2.add(btnBack);
		
		setVisible(true);
		ChattingListener l = new ChattingListener(); 
		btnBack.addActionListener(l);
	}
	
	class ChattingListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String c_cmd = e.getActionCommand();
			
			switch(c_cmd)
			{
			case "이전":
				dispose();
				mainframe.setVisible(true);
				break;
			case "전체":
				break;
			case "개인":
				break;
			}
			
		}
		
	}
}
