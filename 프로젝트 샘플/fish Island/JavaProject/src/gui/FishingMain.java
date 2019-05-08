package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import dao.FishDao;
import dao.MemberDao;
import dao.RodDao;
import dto.Fish;
import dto.Member;
import dto.Rod;

import javax.swing.JButton;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class FishingMain extends JFrame implements ActionListener{
	private Fish f;
	private Member m;
	private JPanel contentPane;
	String id;
	int rno, att, movement;
	String f_stack;
	ArrayList<Fish> list;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					int sea = 1;
					FishingMain frame = new FishingMain("aaa", sea);
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
	public FishingMain(String id,int sea) {
		//id로 낚시대, sea로 물고기 가져오기
		MemberDao memberDao=MemberDao.getInstance();
		m = memberDao.selectOne(id);
		rno = m.getRno();
		RodDao rodDao=RodDao.getInstance();
		Rod r= rodDao.selectOne(rno);
		if(rno==0)
		{
			att=40;
		}else
			att = r.getAtt();
		
		System.out.println(sea);
		
		FishDao fishDao=FishDao.getInstance();
		list = fishDao.selectFish(sea);
		int fishNum = list.size();
		f = list.get((int)(Math.random()*fishNum));
		movement = f.getMovement();
		
		f_stack = m.getF_stack();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		panel.setLayout(new GridLayout(0, 2, 20, 20));
		
		JButton btnGameStart = new JButton("낚시 시작");
		panel.add(btnGameStart);
		btnGameStart.addActionListener(this);
		
		JButton btnExit = new JButton("돌아가기");
		panel.add(btnExit);
		btnExit.addActionListener(this);
		
		setVisible(true);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		String str=e.getActionCommand();
		if(str.equals("낚시 시작"))
		{
			int fishNum = list.size();
			f = list.get((int)(Math.random()*fishNum));
			new FishingGame(m,f,att);
		}else if(str.equals("돌아가기"))
		{
			dispose();
		}
	}
}