package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class SelectPlace extends JFrame {

	private JPanel contentPane;
	private ImageIcon icon;
	private String id;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SelectPlace frame = new SelectPlace("id");
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
	public SelectPlace(String id) {
		this.id=id;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 400, Main_.Screen_wide, Main_.Screen_height);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		
		icon = new ImageIcon("img/place/worldmap.png");
	       
        JPanel background = new JPanel() {
           public void paintComponent(Graphics g) {
               // Approach 1: Dispaly image at at full size
               g.drawImage(icon.getImage(), 0, 0, null);
               setOpaque(false); //그림을 표시하게 설정,투명하게 조절
               super.paintComponent(g);
           }
       };
      contentPane.add(background);
      background.setLayout(null);
      
      JButton btnBack= new JButton();
      btnBack.setBounds(644, 50, 84, 44);
      btnBack.setIcon(new ImageIcon("img/place/back.png"));     
      btnBack.setRolloverIcon(new ImageIcon("img/place/back2.png"));
      background.add(btnBack);
      btnBack.setBorderPainted(false);
      btnBack.setFocusPainted(false);
      btnBack.setContentAreaFilled(false);
      
      btnBack.addActionListener(new ActionListener() {
		
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			new Main_(id);
			SelectPlace.this.dispose();
		}
	});
      
      //인도양 버튼 = 1
      JButton btnIndia = new JButton();
		btnIndia.setBounds(465, 357, 84, 44);
		btnIndia.setIcon(new ImageIcon("img/place/india.png"));
		btnIndia.setRolloverIcon(new ImageIcon("img/place/india2.png"));
		background.add(btnIndia);
		btnIndia.setBorderPainted(false);
		btnIndia.setFocusPainted(false);
		btnIndia.setContentAreaFilled(false);
		
		btnIndia.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FishingMain(id,1);
			}
		});
		
		//태평양 버튼 = 2
		JButton btnPac = new JButton();
		btnPac.setBounds(644, 255, 84, 44);
		btnPac.setIcon(new ImageIcon("img/place/pac.png"));
		btnPac.setRolloverIcon(new ImageIcon("img/place/pac2.png"));
		background.add(btnPac);
		btnPac.setBorderPainted(false);
		btnPac.setFocusPainted(false);
		btnPac.setContentAreaFilled(false);
		
		btnPac.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FishingMain(id,2);
			}
		});
		
		//대서양 버튼 = 3
		JButton btnAtl = new JButton();
		btnAtl.setBounds(286, 255, 84, 44);
		btnAtl.setIcon(new ImageIcon("img/place/atl.png"));
		btnAtl.setRolloverIcon(new ImageIcon("img/place/atl2.png"));
		background.add(btnAtl);
		btnAtl.setBorderPainted(false);
		btnAtl.setFocusPainted(false);
		btnAtl.setContentAreaFilled(false);
		
		btnAtl.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new FishingMain(id,3);
			}
		});
		
		setVisible(true);
	}

}
