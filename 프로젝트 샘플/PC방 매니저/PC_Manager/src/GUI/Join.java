package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.MemberDAO;
import DTO.Member;

public class Join extends JFrame implements ActionListener {

	private JPanel contentPane;
	private JTextField tfname;
	private JPasswordField tfpw1;
	private JTextField tfid;
	private JTextField tfemail;
	private JPasswordField tfpw2;
	private Object panel_1;
	JCheckBox chAgr;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Join frame = new Join();
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
	public Join() {
		setResizable(false);
		setIconImage(
				Toolkit.getDefaultToolkit().getImage("E:\\khs\\project\\javaProject\\Project1\\img\\bt_navi_1.png"));
		setTitle("\uD68C\uC6D0\uAC00\uC785");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 520, 611);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 102, 153));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setLayout(null);
		contentPane.add(panel);

		JLabel lbl = new JLabel("\uD68C\uC6D0\uAC00\uC785");
		lbl.setBackground(Color.WHITE);
		lbl.setHorizontalAlignment(SwingConstants.CENTER);
		lbl.setForeground(Color.BLACK);
		lbl.setFont(new Font("굴림", Font.BOLD, 20));
		lbl.setBounds(0, 0, 480, 24);
		panel.add(lbl);

		JLabel lbl1 = new JLabel(
				"\uD68C\uC6D0\uC73C\uB85C \uB85C\uADF8\uC778 \uD558\uC2DC\uB824\uBA74 \uD68C\uC6D0\uAC00\uC785\uC744 \uD558\uC154\uC57C \uC774\uC6A9 \uD558\uC2E4 \uC218 \uC788\uC2B5\uB2C8\uB2E4.");
		lbl1.setHorizontalAlignment(SwingConstants.CENTER);
		lbl1.setFont(new Font("굴림", Font.BOLD, 12));
		lbl1.setBounds(0, 480, 480, 15);
		panel.add(lbl1);

		JLabel lblid = new JLabel("\uC544\uC774\uB514 :");
		lblid.setFont(new Font("굴림", Font.BOLD, 15));
		lblid.setHorizontalAlignment(SwingConstants.RIGHT);
		lblid.setBounds(73, 83, 69, 24);
		panel.add(lblid);

		tfname = new JTextField();
		tfname.setBounds(166, 48, 136, 24);
		panel.add(tfname);
		tfname.setColumns(20);

		JLabel lblpw = new JLabel("\uBE44\uBC00\uBC88\uD638 :");
		lblpw.setFont(new Font("굴림", Font.BOLD, 15));
		lblpw.setHorizontalAlignment(SwingConstants.RIGHT);
		lblpw.setBounds(61, 117, 81, 24);
		panel.add(lblpw);

		tfpw1 = new JPasswordField();
		tfpw1.setColumns(10);
		tfpw1.setBounds(166, 118, 136, 24);
		panel.add(tfpw1);

		JButton btn1 = new JButton("\uC911\uBCF5\uD655\uC778");
		btn1.setFont(new Font("굴림", Font.BOLD, 12));
		btn1.setBounds(314, 83, 97, 24);
		panel.add(btn1);
		btn1.addActionListener(this);

		JLabel label = new JLabel("\uC774 \uB984 :");
		label.setHorizontalAlignment(SwingConstants.RIGHT);
		label.setFont(new Font("굴림", Font.BOLD, 15));
		label.setBounds(73, 49, 69, 24);
		panel.add(label);

		tfid = new JTextField();
		tfid.setColumns(20);
		tfid.setBounds(166, 84, 136, 24);
		panel.add(tfid);

		JLabel label_1 = new JLabel("\uC774\uBA54\uC77C :");
		label_1.setHorizontalAlignment(SwingConstants.RIGHT);
		label_1.setFont(new Font("굴림", Font.BOLD, 15));
		label_1.setBounds(73, 185, 69, 24);
		panel.add(label_1);

		tfemail = new JTextField();
		tfemail.setColumns(20);
		tfemail.setBounds(166, 186, 136, 24);
		panel.add(tfemail);

		JLabel label_2 = new JLabel("\uBE44\uBC00\uBC88\uD638 \uC7AC\uC785\uB825 :");
		label_2.setHorizontalAlignment(SwingConstants.RIGHT);
		label_2.setFont(new Font("굴림", Font.BOLD, 15));
		label_2.setBounds(11, 151, 131, 24);
		panel.add(label_2);

		tfpw2 = new JPasswordField();
		tfpw2.setColumns(10);
		tfpw2.setBounds(166, 152, 136, 24);
		panel.add(tfpw2);

		chAgr = new JCheckBox("");
		chAgr.setVerticalAlignment(SwingConstants.TOP);
		chAgr.setBounds(269, 378, 21, 23);
		panel.add(chAgr);

		JLabel lblNewLabel = new JLabel("이용 약관의 동의하시겠습니까?");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(288, 378, 185, 23);
		panel.add(lblNewLabel);

		JScrollPane scrollPane = new JScrollPane();

		scrollPane.setBounds(10, 230, 456, 142);

		panel.add(scrollPane);

		JTextArea textArea = new JTextArea();
		textArea.setLineWrap(true);
		textArea.setEditable(false);
		textArea.setText("");
		scrollPane.setViewportView(textArea);
		textArea.setCaretPosition(0);

		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 407, 480, 33);
		panel.add(panel_1);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnjo = new JButton("\uAC00 \uC785");
		panel_1.add(btnjo);

		JButton btncl = new JButton("\uCDE8 \uC18C");
		panel_1.add(btncl);
		btncl.addActionListener(this);
		setVisible(true);
		btnjo.addActionListener(this);
		//btn1.addActionListener(this);

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str = e.getActionCommand();
		if (str.equals("취 소")) {
			dispose();
		} else if (str.equals("가 입")) {
			if(agree()) {
				MemberDAO dao = MemberDAO.getInstance();
				Member m = new Member();
				m.setId(tfid.getText());
				m.setPw(String.valueOf(tfpw1.getPassword()));
				m.setName(tfname.getText());
				m.setEmail(tfemail.getText());
				String pw1=String.valueOf(tfpw1.getPassword());
				String pw2=String.valueOf(tfpw2.getPassword());
				if(tfid.getText().equals("")||tfname.getText().equals("")||tfemail.getText().equals("")||pw1.equals("")||pw2.equals("")) {
					JOptionPane.showMessageDialog(null, "빈칸을 입력해주세요", "필수 정보 입력 오류", JOptionPane.ERROR_MESSAGE);
					return;
				}
				if(pw1.equals(pw2)) {
				int n = dao.insert(m);
				if (n == 1) {
					JOptionPane.showMessageDialog(null, "가입성공");
					dispose();
				
				} else if (n == -1) {
					JOptionPane.showMessageDialog(null, "이미 존재하는 이메일 계정입니다.");
				}
				}else {
					JOptionPane.showMessageDialog(null, "비밀번호가 일치하지 않습니다.", "비밀번호 재확인 오류", JOptionPane.ERROR_MESSAGE);
				}
			}else {
				JOptionPane.showMessageDialog(null, "약관 동의에 체크 해주세요.", "약관 미동의", JOptionPane.ERROR_MESSAGE);
			}
		} else if (str.equals("중복확인")) {
			if(tfid.getText().trim().equals("")){
		        
		        //tfid.requestFocus();
			//String s = new String();
				JOptionPane.showMessageDialog(null, "id를 입력하세요!");
			}else {
				MemberDAO dao = MemberDAO.getInstance();
			if (dao.getIdByCheck(tfid.getText())) {
				JOptionPane.showMessageDialog(null, "사용가능");
			} else{
				JOptionPane.showMessageDialog(null,"사용불가");
			}
			
			}

		}
	}


	public boolean agree() {
		if(chAgr.isSelected())
			return true;
		else
			return false;
		
	}
}
