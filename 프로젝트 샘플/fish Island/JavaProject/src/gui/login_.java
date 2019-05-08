package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import dao.MemberDao;
import dto.Member;

public class login_ extends JFrame {

	private JPanel contentPane;
	private ImageIcon icon;
	private JPasswordField pwField;
	private JTextField tfID;
	private JTextField tfRegId;
	private JPasswordField pwFieldReg;
	private JPanel panelReg;
	JButton btnSame;
	JLabel laRegPw, laRegID;
	JButton btnLogin;
	
	
	
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login_ frame = new login_();
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
	public login_() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Main_.Screen_wide, Main_.Screen_height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		
		icon = new ImageIcon("img\\main1.png");
	       
        JPanel background = new JPanel() {
           public void paintComponent(Graphics g) {
               // Approach 1: Dispaly image at at full size
               g.drawImage(icon.getImage(), 0, 0, null);
               // Approach 2: Scale image to size of component
               // Dimension d = getSize();
               // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
               // Approach 3: Fix the image position in the scroll pane
               // Point p = scrollPane.getViewport().getViewPosition();
               // g.drawImage(icon.getImage(), p.x, p.y, null);
               setOpaque(false); //그림을 표시하게 설정,투명하게 조절
               super.paintComponent(g);
           }
       };
      contentPane.add(background);
      background.setLayout(null);
      
      JLabel laID = new JLabel(" I  D ");
      laID.setBackground(Color.CYAN);
//      laID.setIcon(new ImageIcon("E:\\JJW\\project\\javaProject\\FishingGame\\img\\login\\loginId.png"));
      laID.setFont(new Font("서울남산체 B", Font.BOLD, 15));
      laID.setBounds(280, 454, 43, 36);
      background.add(laID);
      
      JLabel laPw = new JLabel(" P  W ");
      laPw.setFont(new Font("서울남산체 B", Font.BOLD, 13));
      laPw.setBounds(280, 500, 43, 36);
      background.add(laPw);
      
      pwField = new JPasswordField();
      pwField.setBounds(335, 508, 111, 22);
      background.add(pwField);
      
      
      //로그인 버튼
      btnLogin = new JButton();
      btnLogin.setIcon(new ImageIcon("img/login/login.png"));
      btnLogin.setRolloverIcon(new ImageIcon("img/login/login2.png"));
      
      btnLogin.setBounds(468, 454, 78, 76);
      background.add(btnLogin);
      
      //주변 투명하게
      btnLogin.setBorderPainted(false);
      btnLogin.setFocusPainted(false);
      btnLogin.setContentAreaFilled(false);
      
      //로그인 액션
      btnLogin.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String id=tfID.getText();
			String pw_="";
			char[] pw=pwField.getPassword();
    		for(char cha : pw) {
    			Character.toString(cha);
    			pw_ += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
    		} 
    		
    		MemberDao dao=MemberDao.getInstance();
    		int n=dao.userConfirm(id, pw_);
    		if(n==-1) {
				JOptionPane.showMessageDialog(null, "id 없음");
			}else if(n==0) {
				JOptionPane.showMessageDialog(null, "비밀번호 틀림");
			}else if(n==1) {
				new Main_(id);
				login_.this.dispose();
			}
    
		}
	});
      
      tfID = new JTextField();
      tfID.setBounds(335, 462, 111, 21);
      background.add(tfID);
      tfID.setColumns(10);
      
      
      //회원가입 버튼
      JButton btnReg = new JButton();
      btnReg.setIcon(new ImageIcon("img/login/res.png"));
      btnReg.setRolloverIcon(new ImageIcon("img/login/res2.png"));
      btnReg.setBounds(558, 496, 90, 36);
      background.add(btnReg);
      
      btnReg.setBorderPainted(false);
      btnReg.setFocusPainted(false);
      btnReg.setContentAreaFilled(false);
      
      btnReg.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			panelReg.repaint();
			panelReg.setVisible(true);
			
			
		}
	});
      
      
      //종료 버튼
      JButton btnQuit = new JButton();
      btnQuit.setBounds(558, 454, 90, 36);
      btnQuit.setIcon(new ImageIcon("img/login/quit.png"));
      btnQuit.setRolloverIcon(new ImageIcon("img/login/quit2.png"));
      background.add(btnQuit);
      
      btnQuit.setBorderPainted(false);
      btnQuit.setFocusPainted(false);
      btnQuit.setContentAreaFilled(false);
      
      btnQuit.addActionListener(new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			System.exit(0);
		}
    	  
      });
      
      
      //
      //여기서부터 회원 가입 창
      panelReg = new JPanel();
      panelReg.setBackground(new Color(0, 204, 255));
      panelReg.setBounds(280, 29, 368, 207);
      background.add(panelReg);
      panelReg.setLayout(null);
      panelReg.setVisible(false);
//      panelReg.setOpaque(false);
      
      laRegID = new JLabel("\uC544 \uC774 \uB514");
      laRegID.setBounds(60, 50, 57, 15);
      panelReg.add(laRegID);
      
      tfRegId = new JTextField();
      tfRegId.setBounds(129, 47, 139, 21);
      panelReg.add(tfRegId);
      tfRegId.setColumns(10);
      
      laRegPw = new JLabel("\uBE44\uBC00\uBC88\uD638");
      laRegPw.setBounds(60, 90, 57, 15);
      panelReg.add(laRegPw);
      
      pwFieldReg = new JPasswordField();
      pwFieldReg.setBounds(129, 87, 139, 21);
      panelReg.add(pwFieldReg);
      
      
      //아이디 중복검사
      btnSame = new JButton();
      btnSame.setIcon(new ImageIcon("img/login/same.png"));
      btnSame.setRolloverIcon(new ImageIcon("img/login/same2.png"));
      btnSame.setBounds(280, 47,50,21);
      panelReg.add(btnSame);
      btnSame.setBorderPainted(false);
      btnSame.setFocusPainted(false);
      btnSame.setContentAreaFilled(false);
      
      btnSame.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			MemberDao dao =MemberDao.getInstance();
			
			//Member m =new Member();
			String id_=tfRegId.getText();
			
			
			if(dao.duplicateId(id_)== 0)
			{
				if(id_.isEmpty()) {
					JOptionPane.showMessageDialog(null, "아이디를 입력하세요");
				}else {
				JOptionPane.showMessageDialog(null, "아이디 사용가능");}
			}else {
				JOptionPane.showMessageDialog(null, "아이디 사용불가");}
			
			
		}
	});
      
      
      //회원가입 등록 버튼
      JButton btnRegSubmit = new JButton();
      btnRegSubmit.setIcon(new ImageIcon("img/login/submit.png"));
      btnRegSubmit.setRolloverIcon(new ImageIcon("img/login/submit2.png"));
      btnRegSubmit.setBounds(60, 118, 81, 79);
      panelReg.add(btnRegSubmit);
      
      btnRegSubmit.setBorderPainted(false);
      btnRegSubmit.setFocusPainted(false);
      btnRegSubmit.setContentAreaFilled(false);
      
      btnRegSubmit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String pw_="";
	    	Member m=new Member();
	    	String id_=tfRegId.getText();
	    	char[] pw=pwFieldReg.getPassword();
	    		for(char cha : pw) {
	    			Character.toString(cha);
	    			pw_ += (pw.equals("")) ? ""+cha+"" : ""+cha+"";
	    		}
	    	
	    	m.setId(tfRegId.getText());
	    	m.setPw(pw_);
	    	MemberDao dao=MemberDao.getInstance();
	    	int n=dao.insert(m);
	    	if(n==1) {
	    		JOptionPane.showMessageDialog(null, "데이터 저장 성공");
	    	}else {if(dao.duplicateId(id_)>=1) {
	    		JOptionPane.showMessageDialog(null, "사용 중인 아이디입니다.");
	    	}else {
	    		JOptionPane.showMessageDialog(null, "데이터 저장 실패");
	    	}
	    	}
	    	
	    	
		}
	});
      
      //회원가입 종료 버튼
      JButton btnRegQuit = new JButton();
      btnRegQuit.setIcon(new ImageIcon("img/login/close.png"));
      btnRegQuit.setRolloverIcon(new ImageIcon("img/login/close2.png"));
      btnRegQuit.setBounds(185, 118, 81, 79);
      panelReg.add(btnRegQuit);
      
      btnRegQuit.setBorderPainted(false);
      btnRegQuit.setFocusPainted(false);
      btnRegQuit.setContentAreaFilled(false);
      
      btnRegQuit.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			tfRegId.setText(null);
			pwFieldReg.setText(null);
			
			panelReg.setVisible(false);
			
		}
	});
     
    
	}
	 

}
