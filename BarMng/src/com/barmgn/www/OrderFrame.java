package com.barmgn.www;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.ComponentOrientation;

public class OrderFrame extends JFrame {

	private JPanel contentPane;
	MainFrame mainFrame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					frame = new OrderFrame();
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
	public OrderFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		setBounds(new Rectangle(100, 100, 480, 360));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(12, 10, 320, 42);
		contentPane.add(panel_5);
		panel_5.setLayout(null);
		
		JButton btnBackFrame = new JButton("\uC774\uC804");
		btnBackFrame.setBounds(0, 10, 56, 28);
		btnBackFrame.setPreferredSize(new Dimension(97, 35));
		panel_5.add(btnBackFrame);
		
		JButton btnNewButton_12 = new JButton("\uC220");
		btnNewButton_12.setBounds(116, 16, 45, 23);
		panel_5.add(btnNewButton_12);
		
		JButton button_38 = new JButton("\uC548\uC8FC");
		button_38.setBounds(164, 16, 56, 23);
		panel_5.add(button_38);
		
		JButton button_39 = new JButton("\uC74C\uB8CC/\uC2DD\uC0AC");
		button_39.setBounds(222, 16, 86, 23);
		panel_5.add(button_39);
		
		JPanel panel_10 = new JPanel();
		panel_10.setBounds(2, 61, 332, 170);
		panel_10.setPreferredSize(new Dimension(340, 180));
		contentPane.add(panel_10);
		panel_10.setLayout(new CardLayout(0, 0));
		
		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(332, 175));
		panel_10.add(panel, "name_20130474218538");
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
		
		JPanel panel_1 = new JPanel();
		panel_1.setLayout(null);
		panel_1.setPreferredSize(new Dimension(106, 165));
		panel.add(panel_1);
		
		JLabel label_2 = new JLabel("New label");
		label_2.setBounds(26, 5, 57, 15);
		panel_1.add(label_2);
		
		JButton button = new JButton("New button");
		button.setBounds(6, 25, 97, 23);
		panel_1.add(button);
		
		JButton button_1 = new JButton("New button");
		button_1.setBounds(6, 53, 97, 23);
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("New button");
		button_2.setBounds(6, 81, 97, 23);
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("New button");
		button_3.setBounds(6, 109, 97, 23);
		panel_1.add(button_3);
		
		JButton button_4 = new JButton("New button");
		button_4.setBounds(6, 137, 97, 23);
		panel_1.add(button_4);
		
		JPanel panel_2 = new JPanel();
		panel_2.setLayout(null);
		panel_2.setPreferredSize(new Dimension(106, 165));
		panel.add(panel_2);
		
		JLabel label_3 = new JLabel("New label");
		label_3.setBounds(26, 5, 57, 15);
		panel_2.add(label_3);
		
		JButton button_5 = new JButton("New button");
		button_5.setBounds(6, 25, 97, 23);
		panel_2.add(button_5);
		
		JButton button_6 = new JButton("New button");
		button_6.setBounds(6, 53, 97, 23);
		panel_2.add(button_6);
		
		JButton button_7 = new JButton("New button");
		button_7.setBounds(6, 81, 97, 23);
		panel_2.add(button_7);
		
		JButton button_9 = new JButton("New button");
		button_9.setBounds(6, 109, 97, 23);
		panel_2.add(button_9);
		
		JButton button_10 = new JButton("New button");
		button_10.setBounds(6, 137, 97, 23);
		panel_2.add(button_10);
		
		JPanel panel_7 = new JPanel();
		panel_7.setPreferredSize(new Dimension(106, 165));
		panel.add(panel_7);
		
		JLabel label_4 = new JLabel("New label");
		panel_7.add(label_4);
		
		JButton button_11 = new JButton("New button");
		panel_7.add(button_11);
		
		JButton button_13 = new JButton("New button");
		panel_7.add(button_13);
		
		JButton button_14 = new JButton("New button");
		panel_7.add(button_14);
		
		JButton button_15 = new JButton("New button");
		panel_7.add(button_15);
		
		JButton button_17 = new JButton("New button");
		panel_7.add(button_17);
		
		JPanel panel_9 = new JPanel();
		panel_10.add(panel_9, "name_20923529610151");
		
		JButton button_29 = new JButton("\uC220");
		button_29.setPreferredSize(new Dimension(100, 50));
		panel_9.add(button_29);
		
		JButton button_30 = new JButton("New button");
		button_30.setPreferredSize(new Dimension(100, 50));
		panel_9.add(button_30);
		
		JButton button_31 = new JButton("New button");
		button_31.setPreferredSize(new Dimension(100, 50));
		panel_9.add(button_31);
		
		JButton button_32 = new JButton("New button");
		button_32.setPreferredSize(new Dimension(100, 50));
		panel_9.add(button_32);
		
		JButton button_33 = new JButton("New button");
		button_33.setPreferredSize(new Dimension(100, 50));
		panel_9.add(button_33);
		
		JButton button_34 = new JButton("New button");
		button_34.setPreferredSize(new Dimension(100, 50));
		panel_9.add(button_34);
		
		JButton button_35 = new JButton("New button");
		button_35.setPreferredSize(new Dimension(100, 50));
		panel_9.add(button_35);
		
		JButton button_36 = new JButton("New button");
		button_36.setPreferredSize(new Dimension(100, 50));
		panel_9.add(button_36);
		
		JButton button_37 = new JButton("New button");
		button_37.setPreferredSize(new Dimension(100, 50));
		panel_9.add(button_37);
		
		JPanel panel_8 = new JPanel();
		panel_10.add(panel_8, "name_20920245608460");
		
		JButton button_20 = new JButton("\uC548\uC8FC");
		button_20.setPreferredSize(new Dimension(100, 50));
		panel_8.add(button_20);
		
		JButton button_21 = new JButton("New button");
		button_21.setPreferredSize(new Dimension(100, 50));
		panel_8.add(button_21);
		
		JButton button_22 = new JButton("New button");
		button_22.setPreferredSize(new Dimension(100, 50));
		panel_8.add(button_22);
		
		JButton button_23 = new JButton("New button");
		button_23.setPreferredSize(new Dimension(100, 50));
		panel_8.add(button_23);
		
		JButton button_24 = new JButton("New button");
		button_24.setPreferredSize(new Dimension(100, 50));
		panel_8.add(button_24);
		
		JButton button_25 = new JButton("New button");
		button_25.setPreferredSize(new Dimension(100, 50));
		panel_8.add(button_25);
		
		JButton button_26 = new JButton("New button");
		button_26.setPreferredSize(new Dimension(100, 50));
		panel_8.add(button_26);
		
		JButton button_27 = new JButton("New button");
		button_27.setPreferredSize(new Dimension(100, 50));
		panel_8.add(button_27);
		
		JButton button_28 = new JButton("New button");
		button_28.setPreferredSize(new Dimension(100, 50));
		panel_8.add(button_28);
		
		JPanel panel_6 = new JPanel();
		panel_10.add(panel_6, "name_20167251879038");
		
		JButton btnNewButton_3 = new JButton("\uC74C\uB8CC");
		btnNewButton_3.setPreferredSize(new Dimension(100, 50));
		panel_6.add(btnNewButton_3);
		
		JButton btnNewButton_4 = new JButton("New button");
		btnNewButton_4.setPreferredSize(new Dimension(100, 50));
		panel_6.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("New button");
		btnNewButton_5.setPreferredSize(new Dimension(100, 50));
		panel_6.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("New button");
		btnNewButton_6.setPreferredSize(new Dimension(100, 50));
		panel_6.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("New button");
		btnNewButton_7.setPreferredSize(new Dimension(100, 50));
		panel_6.add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("New button");
		btnNewButton_8.setPreferredSize(new Dimension(100, 50));
		panel_6.add(btnNewButton_8);
		
		JButton button_16 = new JButton("New button");
		button_16.setPreferredSize(new Dimension(100, 50));
		panel_6.add(button_16);
		
		JButton button_18 = new JButton("New button");
		button_18.setPreferredSize(new Dimension(100, 50));
		panel_6.add(button_18);
		
		JButton button_19 = new JButton("New button");
		button_19.setPreferredSize(new Dimension(100, 50));
		panel_6.add(button_19);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setPreferredSize(new Dimension(300, 35));
		panel_4.setBounds(2, 230, 332, 35);
		contentPane.add(panel_4);
		
		JLabel label = new JLabel("\uC218\uB7C9 :");
		label.setBounds(12, 10, 32, 15);
		panel_4.add(label);
		
		JLabel label_1 = new JLabel("n");
		label_1.setBounds(49, 10, 7, 15);
		panel_4.add(label_1);
		
		JButton button_8 = new JButton("+");
		button_8.setPreferredSize(new Dimension(40, 23));
		button_8.setBounds(120, 6, 40, 23);
		panel_4.add(button_8);
		
		JButton button_12 = new JButton("-");
		button_12.setPreferredSize(new Dimension(40, 23));
		button_12.setBounds(176, 6, 40, 23);
		panel_4.add(button_12);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(334, 10, 130, 300);
		panel_3.setPreferredSize(new Dimension(130, 300));
		contentPane.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_3.add(lblNewLabel);
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(12);
		textArea.setColumns(13);
		panel_3.add(textArea);
		
		JButton btnNewButton_1 = new JButton("\uC8FC\uBB38");
		btnNewButton_1.setPreferredSize(new Dimension(60, 23));
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC0AD\uC81C");
		btnNewButton_2.setPreferredSize(new Dimension(60, 23));
		panel_3.add(btnNewButton_2);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(2, 268, 332, 42);
		contentPane.add(panel_11);
		panel_11.setLayout(null);
		
		JButton btnBackPanel = new JButton("<");
		btnBackPanel.setBounds(12, 5, 57, 23);
		panel_11.add(btnBackPanel);
		
		JButton btnNewButton_11 = new JButton("\uC8FC\uBB38\uCE74\uD2B8\uB2F4\uAE30");
		btnNewButton_11.setBounds(115, 5, 105, 23);
		panel_11.add(btnNewButton_11);
		
		JButton btnFrontPanel = new JButton(">");
		btnFrontPanel.setBounds(263, 5, 57, 23);
		panel_11.add(btnFrontPanel);
		
		setVisible(true);
		
		OrderListener l = new OrderListener();
		btnBackFrame.addActionListener(l);
	}
	
	class OrderListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String o_cmd = e.getActionCommand();
			
			switch(o_cmd)
			{
			case "¿Ã¿¸":
				setVisible(false);
				mainFrame.setVisible(true);
				break;
			}
		}
		
	}
	
	
	
}
