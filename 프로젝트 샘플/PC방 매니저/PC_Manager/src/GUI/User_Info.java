package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.MemberDAO;
import DTO.Member;
import java.awt.FlowLayout;

public class User_Info extends JFrame {

	private JPanel contentPane;
	private String id;
	private JLabel lblid, lblname, lbljoin, lblemail;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// User_info frame = new User_info();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public User_Info(String id) {
		this.id = id;
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lbljoin2 = new JLabel("\uAC00\uC785\uB0A0\uC9DC :");
		lbljoin2.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 15));
		lbljoin2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbljoin2.setBounds(121, 113, 91, 15);
		contentPane.add(lbljoin2);

		JLabel Id = new JLabel("\uC544\uC774\uB514 :");
		Id.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 15));
		Id.setHorizontalAlignment(SwingConstants.RIGHT);
		Id.setBounds(121, 63, 91, 15);
		contentPane.add(Id);

		JLabel lblname2 = new JLabel("\uC774 \uB984 :");
		lblname2.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 15));
		lblname2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblname2.setBounds(121, 88, 91, 15);
		contentPane.add(lblname2);

		JLabel lblemail2 = new JLabel("\uC774\uBA54\uC77C :");
		lblemail2.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 15));
		lblemail2.setHorizontalAlignment(SwingConstants.RIGHT);
		lblemail2.setBounds(121, 138, 91, 15);
		contentPane.add(lblemail2);

		JLabel lblNewLabel_5 = new JLabel("\uD68C\uC6D0 \uC815\uBCF4");
		lblNewLabel_5.setForeground(Color.BLACK);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.LEFT);
		lblNewLabel_5.setFont(new Font("ÈÞ¸Õ¿¢½ºÆ÷", Font.BOLD, 15));
		lblNewLabel_5.setBounds(12, 10, 244, 20);
		contentPane.add(lblNewLabel_5);

		JButton btnclo = new JButton("\uB2EB\uAE30");
		btnclo.setBounds(169, 228, 97, 23);
		contentPane.add(btnclo);
		btnclo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				dispose();
			}
		});

		MemberDAO dao = MemberDAO.getInstance();
		Member m = new Member();
		m = dao.selectOne(id);

		JLabel lblId = new JLabel(m.getId());
		lblId.setBounds(224, 63, 65, 15);
		contentPane.add(lblId);

		JLabel lblname = new JLabel(m.getName());
		lblname.setBounds(224, 88, 65, 15);
		contentPane.add(lblname);

		JLabel lbljoin = new JLabel(m.getJoin_date());
		lbljoin.setBounds(224, 113, 65, 15);
		contentPane.add(lbljoin);

		JLabel lblemail = new JLabel(m.getEmail());
		lblemail.setBounds(224, 138, 65, 15);
		contentPane.add(lblemail);
		setVisible(true);
	}
}
