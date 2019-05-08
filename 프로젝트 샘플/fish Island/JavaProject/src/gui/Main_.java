package gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Main_ extends JFrame {

	public static final int Screen_wide = 800;
	public static final int Screen_height=600;
	
	private JPanel contentPane;
	private ImageIcon icon;
	String id;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_ frame = new Main_("id");
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
	public Main_(String user) {
		this.id=user;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, Screen_wide, Screen_height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
//		JPanel panel = new JPanel();
//		panel.setBackground(Color.WHITE);
//		contentPane.add(panel, BorderLayout.NORTH);
		
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
       
       
       //낚시터 선택 아이콘
       JButton btnFish = new JButton();
		btnFish.setIcon(new ImageIcon("img\\menu\\Fish.png"));
		btnFish.setRolloverIcon(new ImageIcon("img/menu/Fish2.png"));
		btnFish.setBounds(100, 450, 106, 90);
		background.add(btnFish);
		
		setVisible(true);
		
		btnFish.setBorderPainted(false);
		btnFish.setFocusPainted(false);
		btnFish.setContentAreaFilled(false);
		
		btnFish.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new SelectPlace(id);
				Main_.this.dispose();
			}
			
		});
		
		//상점 아이콘
		JButton btnStore = new JButton();
		btnStore.setIcon(new ImageIcon("img/menu/store.png"));
		btnStore.setRolloverIcon(new ImageIcon("img/menu/store2.png"));
		btnStore.setBounds(250, 450, 106, 90);
		background.add(btnStore);
		
		btnStore.setBorderPainted(false);
		btnStore.setFocusPainted(false);
		btnStore.setContentAreaFilled(false);
		
		btnStore.setVisible(true);
		
		btnStore.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new ShopFrame(id);
				Main_.this.dispose();
			}
		});
		
		
//		//물고기 저장소 아이콘
//		JButton btnInven = new JButton();
//		btnInven.setIcon(new ImageIcon("img/menu/inven.png"));
//		btnInven.setRolloverIcon(new ImageIcon("img/menu/inven2.png"));
//		btnInven.setBounds(400, 450, 106, 90);
//		background.add(btnInven);
//		
//		
//		btnInven.setBorderPainted(false);
//		btnInven.setFocusPainted(false);
//		btnInven.setContentAreaFilled(false);
		//도감 아이콘
		JButton btnDic = new JButton();
		btnDic.setIcon(new ImageIcon("img/menu/dic.png"));
		btnDic.setRolloverIcon(new ImageIcon("img/menu/dic2.png"));
		
		btnDic.setBounds(400, 450, 106,90);
		background.add(btnDic);
		
		btnDic.setBorderPainted(false);
		btnDic.setFocusPainted(false);
		btnDic.setContentAreaFilled(false);
		
		btnDic.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Dic(id);
				Main_.this.dispose();
			}
		});
		
		//나가기 아이콘
		JButton btnQuit = new JButton();
		btnQuit.setIcon(new ImageIcon("img/menu/quit.png"));
		btnQuit.setRolloverIcon(new ImageIcon("img/menu/quit2.png"));
		
		btnQuit.setBounds(550, 450, 106,90);
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
			
		});setVisible(true);
	}
	
}
