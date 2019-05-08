package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.FishDao;
import dao.MemberDao;
import dto.Fish;
import dto.Member;
import javax.swing.JLabel;

public class Dic extends JFrame {

	private JPanel contentPane;
	private ImageIcon icon, icon_;
	private String id;
	private int selectRow;
	JPanel list_panel;
	JTable list_table;
	JScrollPane sp;
	Vector<Fish> vector;
	JLabel laPic;
	
	ImageIcon img[]= {new ImageIcon("img/fish/01.png"),
			new ImageIcon("img/fish/02.png"),
			new ImageIcon("img/fish/03.png"),
			new ImageIcon("img/fish/04.png"),
			new ImageIcon("img/fish/05.png"),
			new ImageIcon("img/fish/06.png"),
			new ImageIcon("img/fish/07.png"),
			new ImageIcon("img/fish/08.png"),
			new ImageIcon("img/fish/09.png"),
			new ImageIcon("img/fish/10.png"),
			new ImageIcon("img/fish/11.png"),
			new ImageIcon("img/fish/12.png"),
			new ImageIcon("img/fish/13.png"),
			new ImageIcon("img/fish/14.png"),
			new ImageIcon("img/fish/15.png"),
			new ImageIcon("img/fish/16.png"),
			new ImageIcon("img/fish/17.png"),
			new ImageIcon("img/fish/18.png"),
			new ImageIcon("img/fish/19.png"),
			new ImageIcon("img/fish/20.png"),
			new ImageIcon("img/fish/21.png"),
			new ImageIcon("img/fish/22.png"),
			new ImageIcon("img/fish/23.png"),
			new ImageIcon("img/fish/24.png"),
			new ImageIcon("img/fish/25.png"),
			new ImageIcon("img/fish/26.png"),
			new ImageIcon("img/fish/27.png"),
			new ImageIcon("img/fish/28.png"),
			new ImageIcon("img/fish/29.png"),
			new ImageIcon("img/fish/30.png")
			};
	private JLabel laName;
	private JLabel laExName;
	private JLabel laArea;
	private JLabel laExArea;
	private JLabel laPrice;
	private JLabel laExPrice;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Dic frame = new Dic("123");
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
	public Dic(String id) {
		this.id=id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 400, Main_.Screen_wide, Main_.Screen_height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		setVisible(true);
		
		icon = new ImageIcon("img/Shop/shopbackground.png");
		
		
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
	      
	      
	      list_panel = new JPanel();
	      list_panel.setBounds(40, 51, 300, 390);
	      background.add(list_panel);
	      list_panel.setOpaque(true);
	      list_panel.setVisible(true);
	      list_panel.setLayout(new BorderLayout(0, 0));
	      listTable();
	      
	      JButton btnView = new JButton();
	      btnView.setText("자세히 보기");
	      list_panel.add(btnView, BorderLayout.SOUTH);
	      
	    	      
	      btnView.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int n = list_table.getSelectedRow();
				Fish f = vector.get(n);
				int m = f.getFno();
				String name = f.getFname();
				String area = f.getSea();	
				String sea="";
				StringTokenizer st = new StringTokenizer(area, ",");
				int cnt = st.countTokens();
				for(int i=0; i<cnt; i++) {
					int token = Integer.parseInt(st.nextToken());
					System.out.println(token);
					if(token == 1) {
						area = "인도양";
					}else if(token==2) {
						area ="태평양";
					}else if(token==3) {
						area = "대서양";
					}
					sea +=area;
					if(i<cnt-1) {
						sea +=", ";
					}
				}

				
				int price= f.getSaleprice();
				laPic.setIcon(new ImageIcon("img\\fish\\"+m+".png"));
				laExName.setText(name);
				laExArea.setText(sea);
				laExPrice.setText(price+"원");
			}
		});
	      //list_panel.add(list_table);
	      
	    //설명 패널
	      icon_ = new ImageIcon("img/dic/exPanel.png");  
	      
  		JPanel ex_panel = new JPanel(){
  			public void paintComponent(Graphics g) {
	               // Approach 1: Dispaly image at at full size
	               g.drawImage(icon_.getImage(), 0, 0, null);
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
  		
  	
  		ex_panel.setBounds(406, 51, 341, 390);
  		background.add(ex_panel);
  		ex_panel.setLayout(null);
  		
  		laPic = new JLabel("");
  		
  		laPic.setBounds(46, 33, 198, 123);
  		ex_panel.add(laPic);
  		
  		//이름  탭
  		laName = new JLabel();
  		laName.setIcon(new ImageIcon("img/dic/name.png"));
  		laName.setBounds(46, 192, 57, 26);
  		ex_panel.add(laName);
  		
  		//이름 설명
  		laExName = new JLabel();
  		laExName.setBounds(129, 192, 115, 26);
  		ex_panel.add(laExName);
  		
  		//서식지 탭
  		laArea = new JLabel();
  		laArea.setIcon(new ImageIcon("img/dic/sea.png"));
  		laArea.setBounds(46, 245, 57, 26);
  		ex_panel.add(laArea);
  		
  		//서식지 설명
  		laExArea = new JLabel();
  		laExArea.setBounds(132, 245, 181, 26);
  		ex_panel.add(laExArea);
  		
  		//가격 탭
  		laPrice = new JLabel();
  		laPrice.setIcon(new ImageIcon("img/dic/price.png"));
  		laPrice.setBounds(46, 296, 57, 26);
  		ex_panel.add(laPrice);
  		
  		//가격 설명
  		laExPrice = new JLabel();
  		laExPrice.setBounds(129, 296, 115, 26);
  		ex_panel.add(laExPrice);
  		
  		
  		//뒤로가기버튼
  		JButton btnBack = new JButton();
  		btnBack.setIcon(new ImageIcon("img/dic/back.png"));
  		btnBack.setRolloverIcon(new ImageIcon("img/dic/back2.png"));
  		btnBack.setBounds(406, 475, 140, 31);
  		btnBack.setBorderPainted(false);
  		btnBack.setFocusPainted(false);
  		btnBack.setContentAreaFilled(false);
  		
  		background.add(btnBack);  				
  		btnBack.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Main_(id);
				Dic.this.dispose();
			}
		});
	}
			
	
	
	public void listTable() {
		String[] salesNames = { "번호", "종류"};
		DefaultTableModel model = new DefaultTableModel(salesNames, 0);
		
		Member member = MemberDao.getInstance().selectOne(id);
		if (member != null) {
			
			String dic = member.getDic();
			
			if(dic != null) {
			StringTokenizer st = new StringTokenizer(dic, ",");
			vector=new Vector<Fish>();

			int cnt = st.countTokens();
			for (int i = 0; i < cnt; i++) {
				int no = Integer.parseInt(st.nextToken());
				System.out.println(no);
				Fish f = FishDao.getInstance().selectOne(no);
				vector.add(i,f);
				Object[] obj = new Object[2];
				obj[0] = no;
				obj[1] = f.getFname();
				model.addRow(obj);
				}
			}else {
				JOptionPane.showMessageDialog(null, "도감에 물고기가 없습니다.");
			}
		}

		list_table = new JTable(model);
		
  	  	sp=new JScrollPane(list_table);
  	  	sp.setPreferredSize(new Dimension(300, 194));
  	  	list_panel.add(sp);
  	  		  	
  	  	
  	  	list_panel.repaint();
  	  	list_panel.setVisible(true);
		
	}
}
