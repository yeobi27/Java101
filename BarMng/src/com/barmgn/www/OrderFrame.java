package com.barmgn.www;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import java.awt.FlowLayout;
import java.awt.Dimension;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JToolBar;
import javax.swing.JTabbedPane;
import java.awt.Font;
import java.awt.CardLayout;
import java.awt.ComponentOrientation;
import javax.swing.SwingConstants;

public class OrderFrame extends JFrame {

	private JPanel contentPane;
	CardLayout cards;
	private OrderFrame orderFrame;
	MainFrame mainFrame;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
//					frame = new OrderFrame();
//					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public OrderFrame(MainFrame mainFrame) {
		this.mainFrame = mainFrame;
		setBounds(new Rectangle(100, 100, 480, 360));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 480, 360);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel p_Tab = new JPanel();
		p_Tab.setBounds(12, 10, 320, 42);
		contentPane.add(p_Tab);
		p_Tab.setLayout(null);
		
		JButton btnBackFrame = new JButton("\uC774\uC804");
		btnBackFrame.setBounds(0, 10, 56, 28);
		btnBackFrame.setPreferredSize(new Dimension(97, 35));
		p_Tab.add(btnBackFrame);
		
		JButton tp_btnAlcohol = new JButton("\uC220");
		tp_btnAlcohol.setBounds(116, 16, 45, 23);
		p_Tab.add(tp_btnAlcohol);
		
		JButton tp_btnSnack = new JButton("\uC548\uC8FC");
		tp_btnSnack.setBounds(164, 16, 56, 23);
		p_Tab.add(tp_btnSnack);
		
		JButton tp_btnDrinknMeal = new JButton("\uC74C\uB8CC/\uC2DD\uC0AC");
		tp_btnDrinknMeal.setBounds(222, 16, 86, 23);
		p_Tab.add(tp_btnDrinknMeal);
		
		JPanel p_CardLayout = new JPanel();
		p_CardLayout.setBounds(2, 61, 332, 170);
		p_CardLayout.setPreferredSize(new Dimension(340, 180));
		contentPane.add(p_CardLayout);
		cards = new CardLayout(0, 0);
		p_CardLayout.setLayout(cards);
		
		JPanel p_OrderList = new JPanel();
		p_OrderList.setPreferredSize(new Dimension(332, 175));
		p_CardLayout.add(p_OrderList, "name_20130474218538");
		p_OrderList.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
		
		JPanel p_AlcoholList = new JPanel();
		p_AlcoholList.setLayout(null);
		p_AlcoholList.setPreferredSize(new Dimension(106, 165));
		p_OrderList.add(p_AlcoholList);
		
		JLabel lblAlcohol = new JLabel("술");
		lblAlcohol.setHorizontalAlignment(SwingConstants.CENTER);
		lblAlcohol.setBounds(26, 5, 57, 15);
		p_AlcoholList.add(lblAlcohol);
		
		JButton btnSoju = new JButton("소주");
		btnSoju.setBounds(6, 25, 97, 23);
		p_AlcoholList.add(btnSoju);
		
		JButton btnTrdAlcohol = new JButton("전통주");
		btnTrdAlcohol.setBounds(6, 53, 97, 23);
		p_AlcoholList.add(btnTrdAlcohol);
		
		JButton btnLiveBeer = new JButton("생맥주");
		btnLiveBeer.setBounds(6, 81, 97, 23);
		p_AlcoholList.add(btnLiveBeer);
		
		JButton btnBottleBeer = new JButton("병맥주");
		btnBottleBeer.setBounds(6, 109, 97, 23);
		p_AlcoholList.add(btnBottleBeer);
		
		JButton btnNonAlcohol = new JButton("무알콜");
		btnNonAlcohol.setBounds(6, 137, 97, 23);
		p_AlcoholList.add(btnNonAlcohol);
		
		JPanel p_SnackList = new JPanel();
		p_SnackList.setLayout(null);
		p_SnackList.setPreferredSize(new Dimension(106, 165));
		p_OrderList.add(p_SnackList);
		
		JLabel lblSnack = new JLabel("안주");
		lblSnack.setHorizontalAlignment(SwingConstants.CENTER);
		lblSnack.setBounds(26, 5, 57, 15);
		p_SnackList.add(lblSnack);
		
		JButton btnSalad = new JButton("샐러드");
		btnSalad.setBounds(6, 25, 97, 23);
		p_SnackList.add(btnSalad);
		
		JButton btnCheese = new JButton("치즈류");
		btnCheese.setBounds(6, 53, 97, 23);
		p_SnackList.add(btnCheese);
		
		JButton btnBest = new JButton("일품요리류");
		btnBest.setBounds(6, 81, 97, 23);
		p_SnackList.add(btnBest);
		
		JButton btnRoasting = new JButton("볶음류");
		btnRoasting.setBounds(6, 109, 97, 23);
		p_SnackList.add(btnRoasting);
		
		JButton btnSoup = new JButton("탕류");
		btnSoup.setBounds(6, 137, 97, 23);
		p_SnackList.add(btnSoup);
		
		JPanel p_DrinknMealList = new JPanel();
		p_DrinknMealList.setPreferredSize(new Dimension(106, 165));
		p_OrderList.add(p_DrinknMealList);
		p_DrinknMealList.setLayout(null);
		
		JLabel lblDrinknMeal = new JLabel("음료/식사");
		lblDrinknMeal.setBounds(26, 5, 54, 15);
		p_DrinknMealList.add(lblDrinknMeal);
		
		JButton btnDrink = new JButton("음료");
		btnDrink.setBounds(5, 25, 97, 23);
		p_DrinknMealList.add(btnDrink);
		
		JButton btnSelfMenu = new JButton("셀프메뉴");
		btnSelfMenu.setBounds(5, 53, 97, 23);
		p_DrinknMealList.add(btnSelfMenu);
		
		JButton btnSubMenu = new JButton("서브메뉴");
		btnSubMenu.setBounds(5, 81, 97, 23);
		p_DrinknMealList.add(btnSubMenu);
		
		JButton btnAddSari = new JButton("추가사리");
		btnAddSari.setBounds(5, 109, 97, 23);
		p_DrinknMealList.add(btnAddSari);
		
		JPanel p_inAlcohol = new JPanel();
		FlowLayout flowLayout = (FlowLayout) p_inAlcohol.getLayout();
		p_CardLayout.add(p_inAlcohol, "name_20923529610151");
		
		JButton btnBrotherSoju = new JButton("복받은부라더");
		btnBrotherSoju.setPreferredSize(new Dimension(105, 50));
		p_inAlcohol.add(btnBrotherSoju);
		
		JButton btnSunhariApp = new JButton("순하리(사과)");
		btnSunhariApp.setPreferredSize(new Dimension(105, 50));
		p_inAlcohol.add(btnSunhariApp);
		
		JButton btnCharmSoju = new JButton("참이슬");
		btnCharmSoju.setPreferredSize(new Dimension(105, 50));
		p_inAlcohol.add(btnCharmSoju);
		
		JButton btnAsFirst = new JButton("처음처럼");
		btnAsFirst.setPreferredSize(new Dimension(105, 50));
		p_inAlcohol.add(btnAsFirst);
		
		JButton btmCharmJamong = new JButton("참이슬(자몽)");
		btmCharmJamong.setPreferredSize(new Dimension(105, 50));
		p_inAlcohol.add(btmCharmJamong);
		
		JButton btnSunhariBok = new JButton("순하리(복숭아)");
		btnSunhariBok.setPreferredSize(new Dimension(105, 50));
		p_inAlcohol.add(btnSunhariBok);
		
		JPanel p_inSnack = new JPanel();
		p_CardLayout.add(p_inSnack, "name_20920245608460");
		
		JButton btnSnack = new JButton("매운까르르치킨");
		btnSnack.setPreferredSize(new Dimension(105, 50));
		p_inSnack.add(btnSnack);
		
		JButton btnXo = new JButton("XO떡볶이");
		btnXo.setPreferredSize(new Dimension(105, 50));
		p_inSnack.add(btnXo);
		
		JButton btnCrmGangJung = new JButton("크림속매운닭강정");
		btnCrmGangJung.setPreferredSize(new Dimension(105, 50));
		p_inSnack.add(btnCrmGangJung);
		
		JButton btnBigChiken = new JButton("통큰통닭");
		btnBigChiken.setPreferredSize(new Dimension(105, 50));
		p_inSnack.add(btnBigChiken);
		
		JButton btnLol = new JButton("L.O.L");
		btnLol.setPreferredSize(new Dimension(105, 50));
		p_inSnack.add(btnLol);
		
		JButton btnPadak = new JButton("파닭");
		btnPadak.setPreferredSize(new Dimension(105, 50));
		p_inSnack.add(btnPadak);
		
		JPanel p_inDrinknMeal = new JPanel();
		p_CardLayout.add(p_inDrinknMeal, "name_20167251879038");
		
		JButton btnCola = new JButton("콜라");
		btnCola.setPreferredSize(new Dimension(105, 50));
		p_inDrinknMeal.add(btnCola);
		
		JButton btnCider = new JButton("사이다");
		btnCider.setPreferredSize(new Dimension(105, 50));
		p_inDrinknMeal.add(btnCider);
		
		JButton btnOrangJuice = new JButton("오렌지주스");
		btnOrangJuice.setPreferredSize(new Dimension(105, 50));
		p_inDrinknMeal.add(btnOrangJuice);
		
		JButton btnRedBull = new JButton("레드불");
		btnRedBull.setPreferredSize(new Dimension(105, 50));
		p_inDrinknMeal.add(btnRedBull);
		
		JButton btnTonicWater = new JButton("토닉워터");
		btnTonicWater.setPreferredSize(new Dimension(105, 50));
		p_inDrinknMeal.add(btnTonicWater);
		
		JButton btnCoolPeace = new JButton("쿨피스");
		btnCoolPeace.setPreferredSize(new Dimension(105, 50));
		p_inDrinknMeal.add(btnCoolPeace);
		
		JPanel panel_4 = new JPanel();
		panel_4.setLayout(null);
		panel_4.setPreferredSize(new Dimension(300, 35));
		panel_4.setBounds(2, 230, 332, 35);
		contentPane.add(panel_4);
		
		JLabel label = new JLabel("\uC218\uB7C9 :");
		label.setBounds(12, 10, 32, 15);
		panel_4.add(label);
		
		JLabel label_1 = new JLabel("n");
		label_1.setBounds(49, 10, 7, 15);
		panel_4.add(label_1);
		
		JButton button_8 = new JButton("+");
		button_8.setPreferredSize(new Dimension(40, 23));
		button_8.setBounds(120, 6, 40, 23);
		panel_4.add(button_8);
		
		JButton button_12 = new JButton("-");
		button_12.setPreferredSize(new Dimension(40, 23));
		button_12.setBounds(176, 6, 40, 23);
		panel_4.add(button_12);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(334, 10, 130, 300);
		panel_3.setPreferredSize(new Dimension(130, 300));
		contentPane.add(panel_3);
		
		JLabel lblOrderCart = new JLabel("주문카트담기");
		panel_3.add(lblOrderCart);
		
		JTextArea textArea = new JTextArea();
		textArea.setRows(12);
		textArea.setColumns(16);
		panel_3.add(textArea);
		
		JButton btnNewButton_1 = new JButton("\uC8FC\uBB38");
		btnNewButton_1.setPreferredSize(new Dimension(60, 23));
		panel_3.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\uC0AD\uC81C");
		btnNewButton_2.setPreferredSize(new Dimension(60, 23));
		panel_3.add(btnNewButton_2);
		
		JPanel panel_11 = new JPanel();
		panel_11.setBounds(2, 268, 332, 42);
		contentPane.add(panel_11);
		panel_11.setLayout(null);
		
		JButton btnBackPanel = new JButton("<");
		btnBackPanel.setBounds(12, 5, 57, 23);
		panel_11.add(btnBackPanel);
		
		JButton btnInputTextArea = new JButton("\uC8FC\uBB38\uCE74\uD2B8\uB2F4\uAE30");
		btnInputTextArea.setBounds(115, 5, 105, 23);
		panel_11.add(btnInputTextArea);
		
		JButton btnFrontPanel = new JButton(">");
		btnFrontPanel.setBounds(263, 5, 57, 23);
		panel_11.add(btnFrontPanel);
		
		setVisible(true);
		
		OrderListener l = new OrderListener();
		btnBackFrame.addActionListener(l);
		tp_btnAlcohol.addActionListener(l);
		tp_btnSnack.addActionListener(l);
		tp_btnDrinknMeal.addActionListener(l);
	}
	
	public void changePanel() 
	{ 
		cards.next(this.getContentPane()); 
	}

	class OrderListener implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String o_cmd = e.getActionCommand();
			
			switch(o_cmd)
			{
			case "이전":
//				setVisible(false);
				dispose();
				mainFrame.setVisible(true);
				break;
			}
		}
		
	}
	
	
	
}
