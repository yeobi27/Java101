package GUI;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.net.InetAddress;
import java.net.Socket;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.ComputerDAO;
import DAO.MemberDAO;

public class login extends JFrame implements ActionListener {

	private JPanel conp;
	private JPanel pl;
	private JPanel pr;
	private JLabel lblNewLabel;
	private JTextField idtf;
	private JLabel lblNewLabel_3;
	private JTextField pwtf;
	private JButton loginbtn;
	private JPanel panel_4;
	private JButton btnjoin;
	private JButton btnidpw;
	private JButton btncl;
	private JPanel panel_6;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_6;
	private String ip;
	private int no;
	private InetAddress local;
	private boolean type = false;
	private String id;
	private User_login user_login;
	private login login;
	Client client;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 *
	 */
	public int getNo() {
		return no;
	}

	public login() {
		this.login = this;
		getInfo();

		setResizable(false);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage("E:\\khs\\project\\javaProject\\Project1\\img\\bt_navi_0.png"));
		setBackground(new Color(0, 0, 0));
		setTitle("No." + no);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 600);
		conp = new JPanel();
		conp.setBackground(Color.WHITE);
		conp.setBorder(new EmptyBorder(0, 0, 0, 0));
		setContentPane(conp);
		conp.setLayout(new GridLayout(0, 2, 0, 0));

		pl = new JPanel();
		pl.setBackground(Color.BLACK);
		conp.add(pl);
		pl.setLayout(new GridLayout(0, 1, 0, 0));

		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel_3.setIcon(new ImageIcon(".\\img\\bg.jpg"));
		pl.add(lblNewLabel_3);
		lblNewLabel = new JLabel("");
		lblNewLabel.setBackground(Color.WHITE);
		lblNewLabel.setVerticalAlignment(SwingConstants.BOTTOM);
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setIcon(new ImageIcon(".\\img\\bg.jpg"));
		pl.add(lblNewLabel);

		pr = new JPanel();
		pr.setBackground(Color.WHITE);
		conp.add(pr);
		pr.setLayout(new GridLayout(0, 1, 0, 0));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(0, 0, 0));
		pr.add(panel_2);
		panel_2.setLayout(null);

		lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setBounds(0, 0, 447, 398);
		panel_2.add(lblNewLabel_6);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_6.setIcon(new ImageIcon(".\\img\\bg2.png"));

		panel_6 = new JPanel();
		panel_6.setBounds(0, 398, 447, 132);
		panel_2.add(panel_6);
		panel_6.setBackground(new Color(0, 102, 153));
		panel_6.setLayout(null);

		JLabel idlbl = new JLabel("\uD68C\uC6D0");
		idlbl.setFont(new Font("굴림", Font.BOLD, 15));
		idlbl.setBounds(12, 55, 44, 15);
		panel_6.add(idlbl);
		idlbl.setForeground(new Color(0, 255, 255));
		idlbl.setHorizontalAlignment(SwingConstants.CENTER);

		JLabel lblpw = new JLabel("\uBE44\uBC00\uBC88\uD638");
		lblpw.setBounds(126, 101, 56, 15);
		panel_6.add(lblpw);
		lblpw.setForeground(new Color(255, 255, 255));
		lblpw.setHorizontalAlignment(SwingConstants.CENTER);

		idtf = new JTextField();
		idtf.setBounds(194, 67, 136, 21);
		panel_6.add(idtf);
		idtf.setColumns(10);

		pwtf = new JPasswordField();
		pwtf.setBounds(194, 98, 136, 21);
		panel_6.add(pwtf);
		pwtf.setColumns(10);

		loginbtn = new JButton("\uC0AC\uC6A9\uC2DC\uC791");
		loginbtn.setBackground(new Color(0, 191, 255));
		loginbtn.setForeground(new Color(255, 255, 255));
		loginbtn.setBounds(331, 5, 104, 114);
		panel_6.add(loginbtn);
		loginbtn.setFont(new Font("굴림", Font.BOLD, 15));

		JLabel lblid = new JLabel("\uC544\uC774\uB514 ");
		lblid.setHorizontalAlignment(SwingConstants.CENTER);
		lblid.setForeground(new Color(255, 255, 255));
		lblid.setBounds(125, 70, 57, 15);
		panel_6.add(lblid);

		lblNewLabel_2 = new JLabel("\uBE44\uD68C\uC6D0");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setForeground(new Color(0, 255, 255));
		lblNewLabel_2.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_2.setBounds(12, 5, 57, 15);
		panel_6.add(lblNewLabel_2);

		JButton btnGuest = new JButton("\uBE44\uD68C\uC6D0 \uC0AC\uC6A9\uC2DC\uC791");
		btnGuest.setForeground(Color.WHITE);
		btnGuest.setFont(new Font("굴림", Font.BOLD, 15));
		btnGuest.setBackground(SystemColor.activeCaption);
		btnGuest.setBounds(12, 22, 170, 23);
		panel_6.add(btnGuest);

		panel_4 = new JPanel();
		panel_4.setBounds(0, 529, 447, 42);
		panel_2.add(panel_4);
		panel_4.setBackground(new Color(0, 51, 102));
		panel_4.setLayout(null);

		btnjoin = new JButton("\uD68C\uC6D0\uAC00\uC785");
		btnjoin.setForeground(Color.WHITE);
		btnjoin.setBackground(SystemColor.activeCaption);
		btnjoin.setFont(new Font("굴림", Font.BOLD, 15));
		btnjoin.setBounds(12, 10, 97, 23);
		panel_4.add(btnjoin);

		btnidpw = new JButton("\uC544\uC774\uB514/\uBE44\uBC00\uBC88\uD638 \uCC3E\uAE30");
		btnidpw.setBackground(SystemColor.activeCaption);
		btnidpw.setForeground(Color.WHITE);
		btnidpw.setFont(new Font("굴림", Font.BOLD, 15));
		btnidpw.setBounds(151, 10, 187, 22);
		panel_4.add(btnidpw);

		btncl = new JButton("PC \uB044\uAE30");
		btncl.setForeground(Color.WHITE);
		btncl.setBackground(SystemColor.activeCaption);
		btncl.setFont(new Font("굴림", Font.BOLD, 15));
		btncl.setBounds(338, 10, 97, 22);
		panel_4.add(btncl);

		btnGuest.addActionListener(this);
		loginbtn.addActionListener(this);
		btnjoin.addActionListener(this);
		btnidpw.addActionListener(this);
		btncl.addActionListener(this);
		setVisible(true);

		try {
			user_login = new User_login(no, login);

			client = new Client(login, user_login);
			client.start();
			user_login.setClient(client);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		String pw;
		if (str.equals("사용시작")) {
			id = idtf.getText();
			pw = pwtf.getText();
			idtf.setText("");
			pwtf.setText("");
			MemberDAO dao = MemberDAO.getInstance();
			int n = dao.userlogin(id, pw);

			if (n == 1) {
				if (id.equals("ADMIN")) {
					try {
						client.interrupt();
						user_login.dispose();
						new MainFrame();
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				} else {
					login.setVisible(false);
					user_login.setVisible(true);
					user_login.start(id, type, 0, 0);
					client.send("START@" + no + "@" + id);
				}
			} else if (n == 0) {
				JOptionPane.showMessageDialog(null, "패스워드 틀림");
			} else if (n == -1) {
				JOptionPane.showMessageDialog(null, "id 없음");
			}
		} else if (str.equals("비회원 사용시작")) {
			id = "GUEST";
			pw = "1234";
			MemberDAO dao = MemberDAO.getInstance();
			int n = dao.userlogin(id, pw);

			if (n == 1) {
				login.setVisible(false);
				user_login.setVisible(true);
				user_login.start(id, type, 0, 0);
				client.send("START@" + no + "@" + id);
			} else if (n == 0) {
				JOptionPane.showMessageDialog(null, "패스워드 틀림");
			} else if (n == -1) {
				JOptionPane.showMessageDialog(null, "id 없음");
			}
		} else if (str.equals("회원가입")) {
			new Join();
		} else if (str.equals("PC 끄기")) {
			System.exit(0);
		} else if (str.equals("아이디/비밀번호 찾기")) {

			new IDFind();
		}
	}

	private void getInfo() {
		try {
			local = InetAddress.getLocalHost();
			ip = local.getHostAddress();
			ComputerDAO dao = ComputerDAO.getInstance();
			no = dao.searchCom(ip);
		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}
	}

}