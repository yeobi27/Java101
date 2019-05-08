package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.border.EmptyBorder;

import DAO.MemberDAO;
import DTO.Member;

import java.awt.SystemColor;
import java.awt.Color;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.FlowLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.GridLayout;

public class IDFind extends JFrame {

	private JPanel contentPane;
	private JTextField tfName;
	private JTextField tfMail;
	private JTextField tfName2;
	private JTextField tfId;
	private JTextField tfMail2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					IDFind frame = new IDFind();
					//frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public IDFind() {
		setResizable(false);
		
		setIconImage(Toolkit.getDefaultToolkit().getImage("E:\\khs\\project\\javaProject\\Project1\\img\\bt_navi_1.png"));
		setTitle("\uC544\uC774\uB514 \uCC3E\uAE30");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 414, 250);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JTabbedPane tabbedPane = new JTabbedPane(JTabbedPane.TOP);
		tabbedPane.setBounds(12, 10, 384, 201);
		tabbedPane.setFont(new Font("±¼¸²", Font.BOLD, 15));
		contentPane.add(tabbedPane);
		
		JPanel panel = new JPanel();
		tabbedPane.addTab("¾ÆÀÌµð Ã£±â", null, panel, null);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u2605");
		lblNewLabel_1.setBounds(66, 5, 21, 24);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setForeground(Color.RED);
		lblNewLabel_1.setFont(new Font("±¼¸²", Font.BOLD, 20));
		panel.add(lblNewLabel_1);
		
		JLabel label_1 = new JLabel("\uD615\uC2DD\uC5D0 \uB9DE\uAC8C \uC785\uB825\uD558\uC138\uC694");
		label_1.setBounds(92, 5, 226, 24);
		label_1.setForeground(new Color(0, 0, 0));
		label_1.setFont(new Font("±¼¸²", Font.BOLD, 20));
		label_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel.add(label_1);
		
		JLabel label_2 = new JLabel("\u2605");
		label_2.setBounds(323, 5, 21, 24);
		label_2.setHorizontalAlignment(SwingConstants.CENTER);
		label_2.setForeground(Color.RED);
		label_2.setFont(new Font("±¼¸²", Font.BOLD, 20));
		panel.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setLayout(null);
		panel_3.setBounds(49, 26, 284, 80);
		panel.add(panel_3);
		
		tfName = new JTextField();
		tfName.setColumns(10);
		tfName.setBounds(81, 7, 192, 21);
		panel_3.add(tfName);
		
		JLabel label = new JLabel("\uC774\uBA54\uC77C :");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label.setBounds(12, 39, 57, 18);
		panel_3.add(label);
		
		JLabel label_9 = new JLabel("\uC774 \uB984 :");
		label_9.setHorizontalAlignment(SwingConstants.CENTER);
		label_9.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label_9.setBounds(21, 8, 48, 18);
		panel_3.add(label_9);
		
		tfMail = new JTextField();
		tfMail.setColumns(10);
		tfMail.setBounds(81, 38, 192, 21);
		panel_3.add(tfMail);
		
		JLabel label_10 = new JLabel("EX:abcd@abcd.com");
		label_10.setHorizontalAlignment(SwingConstants.CENTER);
		label_10.setForeground(SystemColor.controlDkShadow);
		label_10.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		label_10.setBackground(Color.WHITE);
		label_10.setBounds(130, 58, 143, 25);
		panel_3.add(label_10);
		
		JButton btnNewButton_1 = new JButton("\uC544\uC774\uB514 \uCC3E\uAE30");
		btnNewButton_1.setFont(new Font("±¼¸²", Font.BOLD, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=tfName.getText();
				String mail=tfMail.getText();
				MemberDAO m=MemberDAO.getInstance();
				String msg;

					msg="¾ÆÀÌµð´Â "+m.findingId(name, mail)+"ÀÔ´Ï´Ù.";
					JOptionPane.showMessageDialog(null, msg);
				
			}
		});
		btnNewButton_1.setBounds(0, 142, 379, 27);
		panel.add(btnNewButton_1);
		
		JPanel panel_1 = new JPanel();
		tabbedPane.addTab("ºñ¹Ð¹øÈ£ Ã£±â", null, panel_1, null);
		panel_1.setLayout(null);
		
		JLabel label_5 = new JLabel("\u2605");
		label_5.setBounds(66, 5, 21, 24);
		label_5.setHorizontalAlignment(SwingConstants.CENTER);
		label_5.setForeground(Color.RED);
		label_5.setFont(new Font("±¼¸²", Font.BOLD, 20));
		panel_1.add(label_5);
		
		JLabel label_3 = new JLabel("\uD615\uC2DD\uC5D0 \uB9DE\uAC8C \uC785\uB825\uD558\uC138\uC694");
		label_3.setBounds(92, 5, 226, 24);
		label_3.setHorizontalAlignment(SwingConstants.CENTER);
		label_3.setForeground(Color.BLACK);
		label_3.setFont(new Font("±¼¸²", Font.BOLD, 20));
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("\u2605");
		label_4.setBounds(323, 5, 21, 24);
		label_4.setHorizontalAlignment(SwingConstants.CENTER);
		label_4.setForeground(Color.RED);
		label_4.setFont(new Font("±¼¸²", Font.BOLD, 20));
		panel_1.add(label_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setBounds(49, 26, 284, 112);
		panel_1.add(panel_4);
		
		tfName2 = new JTextField();
		tfName2.setColumns(10);
		tfName2.setBounds(81, 7, 192, 21);
		panel_4.add(tfName2);
		
		JLabel label_11 = new JLabel("\uC774\uBA54\uC77C :");
		label_11.setHorizontalAlignment(SwingConstants.CENTER);
		label_11.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label_11.setBounds(12, 82, 57, 18);
		panel_4.add(label_11);
		
		JLabel label_12 = new JLabel("\uC774 \uB984 :");
		label_12.setHorizontalAlignment(SwingConstants.CENTER);
		label_12.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label_12.setBounds(21, 8, 48, 18);
		panel_4.add(label_12);
		
		tfId = new JTextField();
		tfId.setColumns(10);
		tfId.setBounds(81, 38, 192, 21);
		panel_4.add(tfId);
		
		JLabel label_13 = new JLabel("EX:abcd@abcd.com");
		label_13.setHorizontalAlignment(SwingConstants.CENTER);
		label_13.setForeground(SystemColor.controlDkShadow);
		label_13.setFont(new Font("Yu Gothic", Font.BOLD, 15));
		label_13.setBackground(Color.WHITE);
		label_13.setBounds(130, 58, 143, 25);
		panel_4.add(label_13);
		
		tfMail2 = new JTextField();
		tfMail2.setColumns(10);
		tfMail2.setBounds(81, 81, 192, 21);
		panel_4.add(tfMail2);
		
		JLabel label_6 = new JLabel("\uC544\uC774\uB514 :");
		label_6.setHorizontalAlignment(SwingConstants.CENTER);
		label_6.setFont(new Font("±¼¸²", Font.BOLD, 15));
		label_6.setBounds(12, 41, 57, 18);
		panel_4.add(label_6);
		
		JButton button = new JButton("\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		button.setFont(new Font("±¼¸²", Font.BOLD, 15));
		button.setBounds(0, 142, 379, 27);
		panel_1.add(button);
		setVisible(true);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String name=tfName2.getText();
				String id=tfId.getText();
				String mail=tfMail2.getText();
				MemberDAO m=MemberDAO.getInstance();
				String pw=m.findingPw(name, id, mail);
				JOptionPane.showMessageDialog(null, pw);
			}
		});
	}
}
