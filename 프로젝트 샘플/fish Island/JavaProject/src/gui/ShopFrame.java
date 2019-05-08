package gui;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.StringTokenizer;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import dao.FishDao;
import dao.MemberDao;
import dao.RodDao;
import dto.Fish;
import dto.Member;
import dto.Rod;
import java.awt.GridLayout;
import javax.swing.JLabel;

public class ShopFrame extends JFrame {

	private JPanel contentPane;
	private ImageIcon icon;
	private JTable table, buy_table, salestable, buytable;
	private JLabel laMoney;
	ArrayList<Rod> rod;
	//ArrayList<Member> m;
	JScrollPane sp;
	JPanel store_panel, own_panel, sale_panel;
	private String id;
//	Member member;
	private int money;
	private int salesrow;
	JButton salebtn, buyBtn;
	
	
	Member member=MemberDao.getInstance().selectOne(id);
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShopFrame frame = new ShopFrame("123");
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
	public ShopFrame(String id) {
		this.id=id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 400, Main_.Screen_wide, Main_.Screen_height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
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
	      
	      
	      
	      //사기 버튼
	      JButton buyButton = new JButton("");
	      buyButton.setIcon(new ImageIcon("img/Shop/buybasicbutton.png"));
	      buyButton.setRolloverIcon(new ImageIcon("img/Shop/buypressedbutton.png"));
	      buyButton.setBounds(30, 478, 230, 80);
	      background.add(buyButton);
	      
	      buyButton.setBorderPainted(false);
	      buyButton.setFocusPainted(false);
	      buyButton.setContentAreaFilled(false);
	      
	      buyButton.addActionListener(new ActionListener() {
			
				

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
//				buy_table.setVisible(true);
				if(sale_panel.isVisible()) {
					sale_panel.removeAll();
					sale_panel.setVisible(false);
					store_panel.setOpaque(true);
					store_panel.removeAll();
					RodTable();
					//sale_panel.removeAll();
					//own_panel.setOpaque(true);
					ownRodTable();
					
					store_panel.setVisible(true);
					store_panel.repaint();
				}else {
				store_panel.setOpaque(true);
				RodTable();
				//sale_panel.removeAll();
				//own_panel.setOpaque(true);
				ownRodTable();
				store_panel.repaint();
				store_panel.setVisible(true);
				}
			}
		});
	      
	      
	      
	      //팔기 버튼
	      JButton sellButton = new JButton("");
	      sellButton.setIcon(new ImageIcon("img/Shop/sellbasicbutton.png"));
	      sellButton.setRolloverIcon(new ImageIcon("img/Shop/sellpressedbutton.png"));
	      sellButton.setBounds(280, 478, 230, 80);
	      background.add(sellButton);
	      
	      sellButton.setBorderPainted(false);
	      sellButton.setFocusPainted(false);
	      sellButton.setContentAreaFilled(false);
	      
	      sellButton.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					if(store_panel.isVisible()) {
						store_panel.removeAll();
						own_panel.removeAll();
						store_panel.setVisible(false);
						own_panel.setVisible(false);
						sale_panel.setOpaque(true);
						store_panel.removeAll();
						salesTable();
						sale_panel.repaint();
						sale_panel.setVisible(true);

					}else {
					sale_panel.setOpaque(true);
					store_panel.removeAll();
					salesTable();
					sale_panel.repaint();
					sale_panel.setVisible(true);
					}
				}
			});	
	      
	      
	      //나가기 버튼
	      JButton exitButton = new JButton("");
	      exitButton.setIcon(new ImageIcon("img/Shop/exitbasicbutton.png"));
	      exitButton.setRolloverIcon(new ImageIcon("img/Shop/exitpressedbutton.png"));
	      exitButton.setBounds(530, 478, 230, 80);
	      background.add(exitButton);
	      	      
	      exitButton.setBorderPainted(false);
	      exitButton.setFocusPainted(false);
	      exitButton.setContentAreaFilled(false);
	         
	      
	      exitButton.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Main_(id);
				ShopFrame.this.dispose();
			}
		});
	      

	      
	      //팔기 패널
	      sale_panel = new JPanel();
	      sale_panel.setBounds(41, 51, 300, 194);
	      background.add(sale_panel);
	      sale_panel.setOpaque(false);
	      sale_panel.setVisible(false);
	      sale_panel.setLayout(new BorderLayout(0, 0));
	      
	    //물고기 판매버튼
		salebtn = new JButton("판매");
		sale_panel.add(salebtn, BorderLayout.SOUTH);
		salebtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				sale_panel.remove(sp);
				sale_panel.setVisible(false);
				MemberDao dao=MemberDao.getInstance();
				int fno=(int) salestable.getValueAt(salesrow,0);
				
				Member member=dao.selectOne(id);
				Fish fish=FishDao.getInstance().selectOne(fno);
								
				if(member != null && fish != null) {
					//Member F_stack update
					String fstack=member.getF_stack();
//					fstack = fstack.replace(fno+",", "");			//손봐야 함
					
					Vector<String> fishingStack=new Vector<String>();
					StringTokenizer st = new StringTokenizer(fstack, ",");
					while(st.hasMoreTokens())
					{
						fishingStack.add(st.nextToken());
					}
					fishingStack.removeElementAt(salesrow);
					
					fstack="";
					for(int i=0;i<fishingStack.size();i++)
					{
						fstack += fishingStack.get(i)+",";
					}
					dao.updatefstack(fstack, member.getId());
					
					//Member money update
					int money=member.getMoney();
					int saleprice=fish.getSaleprice();
					money=money+saleprice;
					dao.updateMoney(money, member.getId());
					
					laMoney.setText("돈 : "+money);
					sale_panel.setVisible(false);
					sale_panel.removeAll();
					salesTable();
					
//					sale_panel.add(salebtn);
					sale_panel.repaint();
					sale_panel.setVisible(true);
										
				}
									
			}
		});
      
      //낚시대 구입 패널
      store_panel = new JPanel();
      store_panel.setBounds(41, 51, 300, 194);
      background.add(store_panel);
      store_panel.setOpaque(false);
      store_panel.setVisible(false);
      store_panel.setLayout(new BorderLayout(0, 0));
      
	      
      //낚시대 구입 버튼
      buyBtn = new JButton("\uAD6C\uB9E4");
      //store_panel.add(buyBtn, BorderLayout.SOUTH);
	      
      buyBtn.addActionListener(new ActionListener() {
		
		private int money;

		@Override
		public void actionPerformed(ActionEvent e) {

			int money;
			
			// TODO Auto-generated method stub
			int row= buy_table.getSelectedRow();
			
			int rno=rod.get(row).getRno();
			System.out.println(rno);
			
			money = member.getMoney();
			int price=rod.get(row).getPrice();
			//MemberDao.getInstance().rnoUpdate(id, rno);
			MemberDao dao = MemberDao.getInstance();
										
			
			if(money>=price) {
				int n= dao.rnoUpdate(id, rno);
				if(n==1) {
				JOptionPane.showMessageDialog(null, "구매 했습니다.");
				money = money-price;}
				int m=dao.moneyUpdate(id, money);
				if(m==1) {
				this.money =money;}
				}else {
					JOptionPane.showMessageDialog(null, "돈이 부족합니다.");
				}

				laMoney.setText("돈 : "+money);
				own_panel.setVisible(false);
				own_panel.removeAll();
				ownRodTable();
				own_panel.repaint();
				own_panel.setVisible(true);
//				ownRodTable();
//				table.repaint();
//				ownRodTable();
//				own_panel.repaint();
//				own_panel.setVisible(true);
				
			}
		});

	      //가지고 있는 낚시대 패널
	      own_panel = new JPanel();
	      own_panel.setBounds(41, 249, 300, 194);
	      background.add(own_panel);
	      own_panel.setOpaque(false);
	      own_panel.setLayout(new BorderLayout(0, 0));
	      own_panel.setVisible(false);

	      // 보유금 라벨
	      
	      member=MemberDao.getInstance().selectOne(id);
	      int money = member.getMoney();
	      
	      laMoney = new JLabel("\uB3C8 : "+ money);
	      laMoney.setBounds(483, 51, 57, 15);
	      background.add(laMoney);

//	      buy_table= new JTable();
//	      store_panel.add(buy_table);
//	      buy_table.setVisible(false); 

	      setVisible(true);
	}

	public void salesTable() {
		String[] salesNames = { "번호", "종류", "가격" };
		DefaultTableModel model = new DefaultTableModel(salesNames, 0);
		
		Member member = MemberDao.getInstance().selectOne(id);
		if (member != null) {
			
			String fstack = member.getF_stack();
			
			if(fstack != null) {
			StringTokenizer st = new StringTokenizer(fstack, ",");

			int cnt = st.countTokens();
			for (int i = 0; i < cnt; i++) {
				int no = Integer.parseInt(st.nextToken());
				System.out.println(no);
				Fish f = FishDao.getInstance().selectOne(no);
				Object[] obj = new Object[3];
				obj[0] = no;
				obj[1] = f.getFname();
				obj[2] = f.getSaleprice();
				model.addRow(obj);
				}
			}else {
				JOptionPane.showMessageDialog(null, "물고기가 없습니다.");
			}
		}

		salestable = new JTable(model);
		salestable.addMouseListener(new MouseListener() {
						
			@Override
			public void mousePressed(MouseEvent e) {
				// TODO Auto-generated method stub
				salesrow=salestable.getSelectedRow();
				
			}

			@Override
			public void mouseClicked(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseEntered(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent e) {
				// TODO Auto-generated method stub
				
			}
		
		});
		sp = new JScrollPane(salestable);
		sp.setPreferredSize(new Dimension(300, 388));

		sale_panel.add(sp);
		sale_panel.add(salebtn,BorderLayout.SOUTH);

		sale_panel.repaint();
		sale_panel.setVisible(true);
	}

	public void RodTable() {
		if(table!=null)
			remove(sp);
		rod=RodDao.getInstance().SelectAll();
  	  	String[] names= {"번호", "낚시대 이름", "가격", "공격력"};
  	  	DefaultTableModel model=new DefaultTableModel(names, 0);
  	  	for(int i=0; i<rod.size(); i++) {
  	  		Rod r=rod.get(i);
  	  		
  	  		
  	  		Object[] obj= new Object[4];
  	  		obj[0]=r.getRno();
  	  		obj[1]=r.getRname();
  	  		obj[2]=r.getPrice();
  	  		obj[3]=r.getAtt();
  	  		model.addRow(obj);
  	  	}
  	  	buy_table=new JTable(model);
  	  	sp=new JScrollPane(buy_table);
  	  	sp.setPreferredSize(new Dimension(300, 194));
  	  	store_panel.add(buyBtn, BorderLayout.SOUTH);
  	  	store_panel.add(sp,BorderLayout.NORTH);
  	  	
  	  	
  	  	store_panel.repaint();
  	  	store_panel.setVisible(true);
  	  	
    }
	
	public void ownRodTable() {
		
		String[] names= {"번호", "낚시대 이름", "공격력"};
  	  	DefaultTableModel model=new DefaultTableModel(names, 0);
		if(table!=null)
			remove(sp);
		Member member=MemberDao.getInstance().selectOne(id);
		if(member!=null) {
			
		
		int rno=member.getRno();
		System.out.println(rno);
		Rod rod=RodDao.getInstance().selectOwn(rno);
	
  	  	
//  	  	for(int i=0; i<1; i++) {
//  	  		Rod r=rod.get(i);
  	  		
  	  		
  	  		Object[] obj= new Object[3];
  	  		obj[0]=rod.getRno();
  	  		obj[1]=rod.getRname();
  	  		obj[2]=rod.getAtt();
  	  		model.addRow(obj);
  	  	}
//		else{
//  	  	Object[] obj= new Object[3];
//	  		obj[0]=null;
//	  		obj[1]=null;
//	  		obj[2]=null;
//	  		model.addRow(obj);
//  	  	}
  	  	table=new JTable(model);
  	  	sp=new JScrollPane(table);
  	  	sp.setPreferredSize(new Dimension(300, 194));
  	  	own_panel.add(sp,BorderLayout.NORTH);
  	  	
  	  	own_panel.repaint();
  	  	own_panel.setVisible(true);
  	  	
    }
}
