package login;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

import dao.SignUpDao;
import dto.SignUp;

public class SignUpPage extends JPanel implements MouseListener {

	private JPanel contentPane;
	private JPanel p1, p2, p3;
	private JTextField tfId;
	private JPasswordField tfPw, tfConfirm; // *로 표시해줌
	private JTextField tfNikname;
	private Image imgTit, imgId, imgPw, imgNik, imgSignUp, imgClose, imgConfirm, imgCt, imgCf;
	private SignUpDao sd;
	private String strPw, strConfirm;
	private JLabel lblConfirmRes;
	JButton btnSignUp;
	JButton btnClose;
	JPanel pMain, pSign;	// Main으로 화면 전환용


	public SignUpPage(JPanel pMain) {
		this.pMain = pMain;
		this.pSign = this;
				
		setBounds(0, 0, 450, 600);
		setBackground(Color.RED);
		setLayout(null);
		contentPane=this;
		p1 = new JPanel();
		p1.setBackground(Color.BLACK);
		setLayout(new BorderLayout(5, 5));

		imgTit = new ImageIcon("join_image/MEMBERSHIP.png").getImage();
		imgTit = imgTit.getScaledInstance(300, 120, java.awt.Image.SCALE_SMOOTH); // 이미지 사이즈 조절

		JLabel lbl = new JLabel();
		lbl.setIcon(new ImageIcon(imgTit));
		p1.add(lbl);
		add(p1, BorderLayout.NORTH);

		p2 = new JPanel();
		p2.setLayout(null);
		p2.setBackground(Color.BLACK);

		// 아이디 입력
		imgId = new ImageIcon("join_image/ID.png").getImage();
		imgId = imgId.getScaledInstance(100, 50, Image.SCALE_SMOOTH); // id레이블 이미지

		JLabel lblId = new JLabel();
		lblId.setIcon(new ImageIcon(imgId));
		lblId.setBounds(40, 30, 100, 50);
		p2.add(lblId);

		tfId = new JTextField();
		tfId.setBounds(165, 30, 155, 50);
		tfId.setColumns(10);
		p2.add(tfId);

		// 아이디 중복확인
		JButton btnIdConfirm = new JButton();
		btnIdConfirm.setBackground(Color.GRAY);
		btnIdConfirm.setBounds(320, 31, 20, 49);
		p2.add(btnIdConfirm);
		
		btnIdConfirm.addActionListener(new ActionListener() {			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sd = SignUpDao.getInstance();
				//SignUp su = new SignUp();
				String strId = new String(tfId.getText());
				System.out.println(tfId.getText());
				if(sd.selectId(strId)!= null) {
					btnIdConfirm.setIcon(new ImageIcon(imgCf));
					p2.add(btnIdConfirm);
					System.out.println("중복된 ID 입니다.");
				}else {
					btnIdConfirm.setIcon(new ImageIcon(imgCt));
					p2.add(btnIdConfirm);
					System.out.println("사용가능한 ID 입니다.");
				}
			}
		});
		 
		
		// 패스워드 입력
		imgPw = new ImageIcon("join_image/PW.png").getImage();
		imgPw = imgPw.getScaledInstance(100, 50, Image.SCALE_SMOOTH); // id레이블 이미지

		JLabel lblPw = new JLabel();
		lblPw.setIcon(new ImageIcon(imgPw));
		lblPw.setBounds(40, 110, 100, 50);
		p2.add(lblPw);

		tfPw = new JPasswordField();
		tfPw.setBounds(165, 110, 175, 50);
		p2.add(tfPw);
		tfPw.setColumns(10);

		// 패스워드 확인
		imgConfirm = new ImageIcon("join_image/CONFIRM.png").getImage();
		imgConfirm = imgConfirm.getScaledInstance(100, 50, Image.SCALE_SMOOTH);

		imgCt = new ImageIcon("join_image/true.png").getImage();
		imgCt = imgCt.getScaledInstance(20, 49, Image.SCALE_SMOOTH);

		imgCf = new ImageIcon("join_image/false.png").getImage();
		imgCf = imgCf.getScaledInstance(20, 49, Image.SCALE_SMOOTH);

		JLabel lblConfirm = new JLabel();
		lblConfirm.setIcon(new ImageIcon(imgConfirm));
		lblConfirm.setBounds(40, 190, 100, 50);
		p2.add(lblConfirm);

		tfConfirm = new JPasswordField();
		tfConfirm.setBounds(165, 190, 155, 50);
		p2.add(tfConfirm);
		tfConfirm.setColumns(10);

		lblConfirmRes = new JLabel();
		lblConfirmRes.setBounds(320, 191, 20, 49);
		lblConfirmRes.setOpaque(true);
		lblConfirmRes.setBackground(Color.GRAY);
		p2.add(lblConfirmRes);

		add(p2, BorderLayout.CENTER);
		// 비밀번호 일치, 불일치
		tfConfirm.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyReleased(KeyEvent e) {
				// TODO Auto-generated method stub
			}

			@Override
			public void keyPressed(KeyEvent e) {
				// 엔터 누를시 비밀번호 일치 여부 확인
				strPw = new String(tfPw.getPassword());
				strConfirm = new String(tfConfirm.getPassword());
				if (e.getKeyCode() == KeyEvent.VK_ENTER) {
					if (strPw.equals(strConfirm)) {
						lblConfirmRes.setIcon(new ImageIcon(imgCt));
						p2.add(lblConfirmRes);
					} else if (strPw != strConfirm) {
						lblConfirmRes.setIcon(new ImageIcon(imgCf));
						p2.add(lblConfirmRes);
					}
				}
			}
		});

		// 닉네임 입력
		imgNik = new ImageIcon("join_image/NICKNAME.png").getImage();
		imgNik = imgNik.getScaledInstance(100, 50, Image.SCALE_SMOOTH); // id레이블 이미지

		JLabel lblNikname = new JLabel("");
		lblNikname.setIcon(new ImageIcon(imgNik));
		lblNikname.setBounds(40, 270, 100, 50);
		p2.add(lblNikname);

		tfNikname = new JTextField();
		tfNikname.setBounds(165, 270, 155, 50);
		p2.add(tfNikname);
		tfNikname.setColumns(10);

		// 넥네임 중복확인
		JButton btnNikConfirm = new JButton();
		btnNikConfirm.setBackground(Color.GRAY);
		btnNikConfirm.setBounds(320, 271, 20, 49);
		p2.add(btnNikConfirm);

		
		btnNikConfirm.addActionListener(new ActionListener() {					
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				sd = SignUpDao.getInstance();
				SignUp su = new SignUp();
				String strNik = new String(tfNikname.getText());
				System.out.println(tfNikname.getText());
				if(sd.selectNik(strNik)!= null) {
					btnNikConfirm.setIcon(new ImageIcon(imgCf));
					p2.add(btnNikConfirm);
					System.out.println("중복된 닉네임 입니다.");
				}else {
					btnNikConfirm.setIcon(new ImageIcon(imgCt));
					p2.add(btnNikConfirm);
					System.out.println("사용가능한 닉네임 입니다.");
				}
			}
		});
		 

		// 버튼
		p3 = new JPanel();
		p3.setBackground(Color.BLACK);
		p3.setBounds(0, 350, 374, 50);
		p3.setLayout(new GridLayout(1, 2, 0, 0));
		add(p3, BorderLayout.SOUTH);

		// 회원가입
		imgSignUp = new ImageIcon("join_image/SIGNUP.png").getImage();
		imgSignUp = imgSignUp.getScaledInstance(120, 50, Image.SCALE_SMOOTH);

		btnSignUp = new JButton();
		btnSignUp.setIcon(new ImageIcon(imgSignUp));
		btnSignUp.setBackground(Color.BLACK);
		btnSignUp.setBorderPainted(false); // 버튼 테두리 설정
		btnSignUp.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		btnSignUp.setFocusPainted(false); // 포커스 표시 설정
		btnSignUp.setName("signup");
		p3.add(btnSignUp);
		
		btnSignUp.addMouseListener(this);
		btnSignUp.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				 if(strPw.equals(strConfirm)) {
					SignUp su = new SignUp();
					sd = SignUpDao.getInstance();
					String pw = new String(tfPw.getPassword());
					su.setId(tfId.getText());
					su.setPw(pw);
					su.setNikname(tfNikname.getText());
					sd.insert(su);
				}else {
					System.out.println("패스워드가 일치하지 않습니다.");
				}				 
				
				System.out.println("가입");
				// main으로 돌아가기 추가
				pSign.setVisible(false);
				pMain.setVisible(true);	
			}
		});

		// 닫기
		imgClose = new ImageIcon("join_image/CLOSE.png").getImage();
		imgClose = imgClose.getScaledInstance(120, 50, Image.SCALE_SMOOTH);

		btnClose = new JButton();
		btnClose.setIcon(new ImageIcon(imgClose));
		btnClose.setBackground(Color.BLACK);
		btnClose.setBorderPainted(false); // 버튼 테두리 설정
		btnClose.setContentAreaFilled(false); // 버튼 영역 배경 표시 설정
		btnClose.setFocusPainted(false); // 포커스 표시 설정
		btnClose.setName("close");

		p3.add(btnClose);
		
		btnClose.addMouseListener(this);
		btnClose.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.out.println("닫기");
				// main으로 돌아가기 추가
				pSign.setVisible(false);
				pMain.setVisible(true);					
			}
		});

		setVisible(true);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton tmp = (JButton) e.getSource();
		if (tmp.getName().equals("signup")) {
			imgSignUp = new ImageIcon("join_image/SIGNUP2.png").getImage();
			imgSignUp = imgSignUp.getScaledInstance(120, 50, Image.SCALE_SMOOTH);
			btnSignUp.setIcon(new ImageIcon(imgSignUp));
		} else {
			imgClose = new ImageIcon("join_image/CLOSE2.png").getImage();
			imgClose = imgClose.getScaledInstance(120, 50, Image.SCALE_SMOOTH);
			btnClose.setIcon(new ImageIcon(imgClose));
		}
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		JButton tmp = (JButton) e.getSource();
		if (tmp.getName().equals("signup")) {
			imgSignUp = new ImageIcon("join_image/SIGNUP.png").getImage();
			imgSignUp = imgSignUp.getScaledInstance(120, 50, Image.SCALE_SMOOTH);
			btnSignUp.setIcon(new ImageIcon(imgSignUp));
		} else {
			imgClose = new ImageIcon("join_image/CLOSE.png").getImage();
			imgClose = imgClose.getScaledInstance(120, 50, Image.SCALE_SMOOTH);
			btnClose.setIcon(new ImageIcon(imgClose));
		}
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

}
