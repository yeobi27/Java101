package com.barmgn.www;

import java.awt.CardLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.sql.Date;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.StringTokenizer;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.Component;

public class OrderFrame extends JFrame {

   private JPanel contentPane;
   CardLayout cards;
   private OrderFrame orderFrame;
   JPanel p_CardLayout=null;
   boolean orderlist_flag = false;
   JLabel lblOrderNum; 
   MainFrame mainFrame;
   // Label Num
   int lblcntNum = 0;
   // 주문 횟수
   int ordnum = 1;
   // Table Number : 전역으로 고정
   int tno = (int)(Math.random()*24)+1;
   private JTextArea ta_totBill;
   ArrayList<String> BufferedList;
   HashMap<String, Integer> hmap_OrderNum;
   private JPanel p_Num;
   private JPanel p_OrderCart;
   private JTextArea ta_totCost;
   private JButton btnPlus;
   private JButton btnMinus;
   private JButton btnOrder;
   private JButton btnOrderCancel;
   BufferedImage myImage;
   
   ImageIcon One_BG = new ImageIcon("images/One_BG.jpg");
   ImageIcon Bill = new ImageIcon("images/Bill.png");
   ImageIcon menubar = new ImageIcon("images/menubar.jpg");
   
   public void setOrderFrame(OrderFrame orderFrame)
   {
      this.orderFrame = orderFrame;
   }
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
//               frame = new OrderFrame();
//               frame.setVisible(true);
            } catch (Exception e) {
               e.printStackTrace();
            }
         }
      });
   }

//   class ImagePanel extends JComponent {
//	   // Show Background image
////	   private Image back;
////
////	   public ImagePanel(Image back) {
////	      this.back = back;
////	      this.setLayout(null);
////	   }
//	   protected void paintComponent(Graphics g) {
//	      super.paintComponents(g); 
//	      System.out.println("왜안나와");
//	      setOpaque(false);
//	      g.drawImage(One_BG.getImage(), 0, 0, this); // toy location
//	      g.drawImage(Bill.getImage(), 334, 10, this); // toy location
//	      g.drawImage(menubar.getImage(), 12, 10, this); // toy location
//	   }
//	}
   /**
    * Create the frame.
    */
   public OrderFrame(MainFrame mainFrame) {
      this.mainFrame = mainFrame;
      BufferedList = new ArrayList<>();
      hmap_OrderNum = new HashMap<>();
      setBounds(new Rectangle(100, 100, 800, 600));
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setUndecorated(true);
      setBackground(new Color(0, 0, 0, 0));
      setBounds(100, 100, 800, 600);
      
//      icon = new ImageIcon("images/One_BG.jpg");
      
      contentPane = new JPanel() {
   	   	public void paintComponent(Graphics g) {
 	      super.paintComponents(g); 
 	      System.out.println("왜안나와");
 	      setOpaque(false);
 	      g.drawImage(One_BG.getImage(), 0, 0, this); // toy location
 	      g.drawImage(Bill.getImage(), 584, 0, this); // toy location
 	      g.drawImage(menubar.getImage(), 12, 10, this); // toy location
 	   }
      };
      
      contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
      setContentPane(contentPane);
      contentPane.setLayout(null);
      // 생성자에 ico 호출 하고 이미지 경로 지정...(상대경로로 안될경우 절대경로 지정)
//      icon = new ImageIcon("C:\\ddddd.JPG");

//      // 백그라운드 이미지 삽입할 메소드에 이름없는 클래스로 구현
//      JPanel panel = new JPanel() {
//       public void paintComponent(Graphics g) {
//        // Approach 1: Dispaly image at at full size
//        g.drawImage(icon.getImage(), 0, 0, null);
//        // Approach 2: Scale image to size of component
//        // Dimension d = getSize();
//        // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
//        // Approach 3: Fix the image position in the scroll pane
//        // Point p = scrollPane.getViewport().getViewPosition();
//        // g.drawImage(icon.getImage(), p.x, p.y, null);
//        setOpaque(false);
//        super.paintComponent(g);
//       }
//      };
//      icon = new ImageIcon("images/menubar.jpg");
      
      JPanel p_Tab = new JPanel();
      p_Tab.setBackground(new Color(255,0,0,0));
      p_Tab.setBounds(0, 10, 800, 60);
      contentPane.add(p_Tab);
      p_Tab.setLayout(null);
      
      JButton btnBackFrame = new JButton("\uC774\uC804");
      btnBackFrame.setFocusPainted(false);
      btnBackFrame.setContentAreaFilled(false);
      btnBackFrame.setBorderPainted(false);
      btnBackFrame.setIcon(new ImageIcon("images/before_img.png"));
      btnBackFrame.setBounds(12, 10, 104, 49);
      btnBackFrame.setPreferredSize(new Dimension(97, 35));
      p_Tab.add(btnBackFrame);
      
      JButton tp_btnAlcohol = new JButton("\uC220");
      tp_btnAlcohol.setFocusPainted(false);
      tp_btnAlcohol.setContentAreaFilled(false);
      tp_btnAlcohol.setBorderPainted(false);
      tp_btnAlcohol.setIcon(new ImageIcon("images/sul_img.png"));
      tp_btnAlcohol.setBounds(234, 10, 100, 49);
      p_Tab.add(tp_btnAlcohol);
      
      JButton tp_btnSnack = new JButton("\uC548\uC8FC");
      tp_btnSnack.setFocusPainted(false);
      tp_btnSnack.setContentAreaFilled(false);
      tp_btnSnack.setBorderPainted(false);
      tp_btnSnack.setIcon(new ImageIcon("images/anju_img.png"));
      tp_btnSnack.setBounds(350, 10, 100, 49);
      p_Tab.add(tp_btnSnack);
      
      JButton tp_btnDrinknMeal = new JButton("\uC74C\uB8CC/\uC2DD\uC0AC");
      tp_btnDrinknMeal.setFocusPainted(false);
      tp_btnDrinknMeal.setContentAreaFilled(false);
      tp_btnDrinknMeal.setBorderPainted(false);
      tp_btnDrinknMeal.setIcon(new ImageIcon("images/drinkndinner_img.png"));
      tp_btnDrinknMeal.setBounds(466, 10, 100, 49);
      p_Tab.add(tp_btnDrinknMeal);
      
      p_CardLayout = new JPanel();
      p_CardLayout.setBackground(new Color(255,0,0,0));
      p_CardLayout.setBounds(0, 68, 570, 340);
      p_CardLayout.setPreferredSize(new Dimension(340, 180));
      contentPane.add(p_CardLayout);
      
      cards = new CardLayout(0, 0);
      
      p_CardLayout.setLayout(cards);

      // 버튼에 대한 리스너 작성
      OrderListener l = new OrderListener();
      btnBackFrame.addActionListener(l);
      tp_btnAlcohol.addActionListener(l);
      tp_btnSnack.addActionListener(l);
      tp_btnDrinknMeal.addActionListener(l);
      
      JPanel p_OrderList = new JPanel();
      p_OrderList.setPreferredSize(new Dimension(332, 175));
      p_OrderList.setBackground(new Color(255,0,0,0));
//      p_CardLayout.add(p_OrderList, "name_20130474218538");
      p_CardLayout.add("OrderListPanel", p_OrderList);
      p_OrderList.setLayout(null);
      
      JPanel p_AlcoholList = new JPanel();
      p_AlcoholList.setBackground(new Color(255,0,0,0));
      p_AlcoholList.setBounds(12, 10, 180, 330);
      p_AlcoholList.setPreferredSize(new Dimension(106, 165));
      p_OrderList.add(p_AlcoholList);
      p_AlcoholList.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
      
      JLabel lblAlcohol = new JLabel("술");
      lblAlcohol.setPreferredSize(new Dimension(170, 20));
      lblAlcohol.setHorizontalAlignment(SwingConstants.CENTER);
      p_AlcoholList.add(lblAlcohol);
      
      JButton btnSoju = new JButton("소주/전통주");
      btnSoju.setPreferredSize(new Dimension(170, 50));
      p_AlcoholList.add(btnSoju);
      
      
      btnSoju.addActionListener(l);
      
      JButton btnLiveBeer = new JButton("생맥주");
      btnLiveBeer.setPreferredSize(new Dimension(170, 50));
      p_AlcoholList.add(btnLiveBeer);
      
      btnLiveBeer.addActionListener(l);
      
      
      JButton btnBottleBeer = new JButton("병맥주");
      btnBottleBeer.setPreferredSize(new Dimension(170, 50));
      p_AlcoholList.add(btnBottleBeer);
      
      
      btnBottleBeer.addActionListener(l);
      
      JButton btnFruitAlcohol = new JButton("생과일주");
      btnFruitAlcohol.setPreferredSize(new Dimension(170, 50));
      p_AlcoholList.add(btnFruitAlcohol);
      
      btnFruitAlcohol.addActionListener(l);
      
      JPanel p_SnackList = new JPanel();
      p_SnackList.setBackground(new Color(255,0,0,0));
      p_SnackList.setBounds(196, 10, 180, 330);
      p_SnackList.setPreferredSize(new Dimension(106, 165));
      p_OrderList.add(p_SnackList);
      p_SnackList.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
      
      JLabel lblSnack = new JLabel("안주");
      lblSnack.setPreferredSize(new Dimension(170, 20));
      lblSnack.setHorizontalAlignment(SwingConstants.CENTER);
      p_SnackList.add(lblSnack);
      
      JButton btnSalad = new JButton("샐러드");
      btnSalad.setPreferredSize(new Dimension(170, 50));
      p_SnackList.add(btnSalad);
      
      btnSalad.addActionListener(l);
      
      JButton btnCheese = new JButton("치즈류");
      btnCheese.setPreferredSize(new Dimension(170, 50));
      p_SnackList.add(btnCheese);
      
      btnCheese.addActionListener(l);
      
      JButton btnBest = new JButton("일품요리류");
      btnBest.setPreferredSize(new Dimension(170, 50));
      p_SnackList.add(btnBest);
      
      btnBest.addActionListener(l);
      
      JButton btnRoasting = new JButton("볶음류");
      btnRoasting.setPreferredSize(new Dimension(170, 50));
      p_SnackList.add(btnRoasting);
      
      btnRoasting.addActionListener(l);
      
      JButton btnSoup = new JButton("탕류");
      btnSoup.setPreferredSize(new Dimension(170, 50));
      p_SnackList.add(btnSoup);
      
      btnSoup.addActionListener(l);
      
      JPanel p_DrinknMealList = new JPanel();
      p_DrinknMealList.setBackground(new Color(255,0,0,0));
      p_DrinknMealList.setBounds(378, 10, 180, 330);
      p_DrinknMealList.setPreferredSize(new Dimension(106, 165));
      p_OrderList.add(p_DrinknMealList);
      p_DrinknMealList.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
      
      JLabel lblDrinknMeal = new JLabel("음료/식사");
      lblDrinknMeal.setPreferredSize(new Dimension(170, 20));
      lblDrinknMeal.setHorizontalAlignment(SwingConstants.CENTER);
      p_DrinknMealList.add(lblDrinknMeal);
      
      JButton btnDrink = new JButton("음료");
      btnDrink.setPreferredSize(new Dimension(170, 50));
      p_DrinknMealList.add(btnDrink);
      
      btnDrink.addActionListener(l);
      
      JButton btnSelfMenu = new JButton("셀프메뉴");
      btnSelfMenu.setPreferredSize(new Dimension(170, 50));
      p_DrinknMealList.add(btnSelfMenu);
      
      btnSelfMenu.addActionListener(l);
      
      JButton btnSubMenu = new JButton("서브메뉴");
      btnSubMenu.setPreferredSize(new Dimension(170, 50));
      p_DrinknMealList.add(btnSubMenu);
      
      btnSubMenu.addActionListener(l);
      
      JButton btnAddSari = new JButton("추가사리");
      btnAddSari.setPreferredSize(new Dimension(170, 50));
      p_DrinknMealList.add(btnAddSari);
      
      btnAddSari.addActionListener(l);
      
      JPanel p_inAlcohol = new JPanel();
      p_inAlcohol.setBackground(new Color(255,0,0,0));
//      p_CardLayout.add(p_inAlcohol, "name_20923529610151");
      p_CardLayout.add("inAlcoholPanel",p_inAlcohol);
      
      JButton btnBrotherSoju = new JButton("부라더소주");
      btnBrotherSoju.setFocusPainted(false);
      btnBrotherSoju.setContentAreaFilled(false);
      btnBrotherSoju.setBorderPainted(false);
      btnBrotherSoju.setIcon(new ImageIcon("images/brothersoju.png"));
      btnBrotherSoju.setPreferredSize(new Dimension(180, 145));
      p_inAlcohol.add(btnBrotherSoju);
      
      btnBrotherSoju.addActionListener(l);
      
      JButton btnSunhariApp = new JButton("순하리(사과)");
      btnSunhariApp.setFocusPainted(false);
      btnSunhariApp.setContentAreaFilled(false);
      btnSunhariApp.setBorderPainted(false);
      btnSunhariApp.setIcon(new ImageIcon("images/pureapple.png"));
      btnSunhariApp.setPreferredSize(new Dimension(180, 145));
      p_inAlcohol.add(btnSunhariApp);
      
      btnSunhariApp.addActionListener(l);
      
      JButton btnCharmSoju = new JButton("참이슬");
      btnCharmSoju.setFocusPainted(false);
      btnCharmSoju.setContentAreaFilled(false);
      btnCharmSoju.setBorderPainted(false);
      btnCharmSoju.setIcon(new ImageIcon("images/truedew.png"));
      btnCharmSoju.setPreferredSize(new Dimension(180, 145));
      p_inAlcohol.add(btnCharmSoju);
      
      btnCharmSoju.addActionListener(l);
      
      JButton btnAsFirst = new JButton("처음처럼");
      btnAsFirst.setFocusPainted(false);
      btnAsFirst.setContentAreaFilled(false);
      btnAsFirst.setBorderPainted(false);
      btnAsFirst.setIcon(new ImageIcon("images/first.png"));
      btnAsFirst.setPreferredSize(new Dimension(180, 145));
      p_inAlcohol.add(btnAsFirst);
      
      btnAsFirst.addActionListener(l);
      
      JButton btmCharmJamong = new JButton("참이슬(자몽)");
      btmCharmJamong.setFocusPainted(false);
      btmCharmJamong.setContentAreaFilled(false);
      btmCharmJamong.setBorderPainted(false);
      btmCharmJamong.setIcon(new ImageIcon("images/truedewgf.png"));
      btmCharmJamong.setPreferredSize(new Dimension(180, 145));
      p_inAlcohol.add(btmCharmJamong);
      
      btmCharmJamong.addActionListener(l);
      
      JButton btnSunhariBok = new JButton("순하리(복분자)");
      btnSunhariBok.setFocusPainted(false);
      btnSunhariBok.setContentAreaFilled(false);
      btnSunhariBok.setBorderPainted(false);
      btnSunhariBok.setIcon(new ImageIcon("images/firstpeach.png"));
      btnSunhariBok.setPreferredSize(new Dimension(180, 145));
      p_inAlcohol.add(btnSunhariBok);
      
      btnSunhariBok.addActionListener(l);
      
      JPanel p_inLiveBeer = new JPanel();
//      p_CardLayout.add(p_inLiveBeer, "name_11613215203093");
      p_inLiveBeer.setBackground(new Color(255,0,0,0));
      p_CardLayout.add("inLiveBeerPanel",p_inLiveBeer);
      
      JButton btnEngAle = new JButton("잉글리쉬에일");
      btnEngAle.setIcon(new ImageIcon("images/englisyale.png"));
      btnEngAle.setFocusPainted(false);
      btnEngAle.setContentAreaFilled(false);
      btnEngAle.setBorderPainted(false);
      btnEngAle.setPreferredSize(new Dimension(180, 145));
      p_inLiveBeer.add(btnEngAle);
      
      btnEngAle.addActionListener(l);
      
      JButton btnLeffeBlonde = new JButton("레페블론드");
      btnLeffeBlonde.setIcon(new ImageIcon("images/leffeblond_img.png"));
      btnLeffeBlonde.setFocusPainted(false);
      btnLeffeBlonde.setContentAreaFilled(false);
      btnLeffeBlonde.setBorderPainted(false);
      btnLeffeBlonde.setPreferredSize(new Dimension(180, 145));
      p_inLiveBeer.add(btnLeffeBlonde);
      
      btnLeffeBlonde.addActionListener(l);
      
      JButton btnGoldenAle = new JButton("골든에일");
      btnGoldenAle.setIcon(new ImageIcon("images/goledenale_img.png"));
      btnGoldenAle.setFocusPainted(false);
      btnGoldenAle.setContentAreaFilled(false);
      btnGoldenAle.setBorderPainted(false);
      btnGoldenAle.setPreferredSize(new Dimension(180, 145));
      p_inLiveBeer.add(btnGoldenAle);
      
      btnGoldenAle.addActionListener(l);
      
      JButton btnGuinness = new JButton("기네스");
      btnGuinness.setIcon(new ImageIcon("images/guinness_img.png"));
      btnGuinness.setFocusPainted(false);
      btnGuinness.setContentAreaFilled(false);
      btnGuinness.setBorderPainted(false);
      btnGuinness.setPreferredSize(new Dimension(180, 145));
      p_inLiveBeer.add(btnGuinness);
      
      btnGuinness.addActionListener(l);
      
      JButton btnCarlsberg = new JButton("칼스버그");
      btnCarlsberg.setIcon(new ImageIcon("images/carlsberg.png"));
      btnCarlsberg.setFocusPainted(false);
      btnCarlsberg.setContentAreaFilled(false);
      btnCarlsberg.setBorderPainted(false);
      btnCarlsberg.setPreferredSize(new Dimension(180, 145));
      p_inLiveBeer.add(btnCarlsberg);
      
      btnCarlsberg.addActionListener(l);
      
      JButton btnBaltika = new JButton("발티카");
      btnBaltika.setFocusPainted(false);
      btnBaltika.setContentAreaFilled(false);
      btnBaltika.setBorderPainted(false);
      btnBaltika.setIcon(new ImageIcon("images/baltika.png"));
      btnBaltika.setPreferredSize(new Dimension(180, 145));
      p_inLiveBeer.add(btnBaltika);
      
      btnBaltika.addActionListener(l);
      
      JPanel p_inBottleBeer = new JPanel();
//      p_CardLayout.add(p_inBottleBeer, "name_11755485299816");
      p_inBottleBeer.setBackground(new Color(255,0,0,0));
      p_CardLayout.add("inBottleBeerPanel",p_inBottleBeer);
      
      JButton btnHite = new JButton("하이트");
      btnHite.setIcon(new ImageIcon("images/hite.png"));
      btnHite.setFocusPainted(false);
      btnHite.setBorderPainted(false);
      btnHite.setContentAreaFilled(false);
      btnHite.setPreferredSize(new Dimension(180, 145));
      p_inBottleBeer.add(btnHite);
      
      btnHite.addActionListener(l);
      
      JButton btnCorona = new JButton("코로나");
      btnCorona.setIcon(new ImageIcon("images/corona.png"));
      btnCorona.setFocusPainted(false);
      btnCorona.setBorderPainted(false);
      btnCorona.setContentAreaFilled(false);
      btnCorona.setPreferredSize(new Dimension(180, 145));
      p_inBottleBeer.add(btnCorona);
      
      btnCorona.addActionListener(l);
      
      JButton btnHeineken = new JButton("하이네켄");
      btnHeineken.setIcon(new ImageIcon("images/heineken.png"));
      btnHeineken.setFocusPainted(false);
      btnHeineken.setBorderPainted(false);
      btnHeineken.setContentAreaFilled(false);
      btnHeineken.setPreferredSize(new Dimension(180, 145));
      p_inBottleBeer.add(btnHeineken);
      
      btnHeineken.addActionListener(l);
      
      JButton btn1644Blanc = new JButton("1664블랑");
      btn1644Blanc.setFocusPainted(false);
      btn1644Blanc.setBorderPainted(false);
      btn1644Blanc.setContentAreaFilled(false);
      btn1644Blanc.setIcon(new ImageIcon("images/blanc.png"));
      btn1644Blanc.setPreferredSize(new Dimension(180, 145));
      p_inBottleBeer.add(btn1644Blanc);
      
      btn1644Blanc.addActionListener(l);
      
      JButton btnBottleGuinness = new JButton("제주에일");
      btnBottleGuinness.setIcon(new ImageIcon("images/jejuale_img.png"));
      btnBottleGuinness.setFocusPainted(false);
      btnBottleGuinness.setBorderPainted(false);
      btnBottleGuinness.setContentAreaFilled(false);
      btnBottleGuinness.setPreferredSize(new Dimension(180, 145));
      p_inBottleBeer.add(btnBottleGuinness);
      
      btnBottleGuinness.addActionListener(l);
      
      JButton btnHoegaarden = new JButton("호가든");
      btnHoegaarden.setIcon(new ImageIcon("images/hoegaarden.png"));
      btnHoegaarden.setFocusPainted(false);
      btnHoegaarden.setBorderPainted(false);
      btnHoegaarden.setContentAreaFilled(false);
      btnHoegaarden.setPreferredSize(new Dimension(180, 145));
      p_inBottleBeer.add(btnHoegaarden);
      
      btnHoegaarden.addActionListener(l);
      
      JPanel p_inFruitAlcohol = new JPanel();
//      p_CardLayout.add(p_inFruitAlcohol, "name_11780263085942");
      p_inFruitAlcohol.setBackground(new Color(255,0,0,0));
      p_CardLayout.add("inFruitAlcoholPanel",p_inFruitAlcohol);
      p_inFruitAlcohol.setLayout(null);
      
      JButton btnStrawberryJU = new JButton("생딸기주");
      btnStrawberryJU.setFocusPainted(false);
      btnStrawberryJU.setContentAreaFilled(false);
      btnStrawberryJU.setBorderPainted(false);
      btnStrawberryJU.setBounds(10, 5, 180, 145);
      btnStrawberryJU.setPreferredSize(new Dimension(180, 145));
      p_inFruitAlcohol.add(btnStrawberryJU);
      
      btnStrawberryJU.addActionListener(l);
      
      JButton btnKiwiJU = new JButton("생키위주");
      btnKiwiJU.setFocusPainted(false);
      btnKiwiJU.setContentAreaFilled(false);
      btnKiwiJU.setBorderPainted(false);
      btnKiwiJU.setBounds(195, 5, 180, 145);
      btnKiwiJU.setPreferredSize(new Dimension(180, 145));
      p_inFruitAlcohol.add(btnKiwiJU);
      
      btnKiwiJU.addActionListener(l);
      
      JButton btnPineappleJU = new JButton("생파인애플주");
      btnPineappleJU.setFocusPainted(false);
      btnPineappleJU.setContentAreaFilled(false);
      btnPineappleJU.setBorderPainted(false);
      btnPineappleJU.setBounds(380, 5, 180, 145);
      btnPineappleJU.setPreferredSize(new Dimension(180, 145));
      p_inFruitAlcohol.add(btnPineappleJU);
      
      btnPineappleJU.addActionListener(l);
      
      JButton btnAppleJU = new JButton("생사과주");
      btnAppleJU.setFocusPainted(false);
      btnAppleJU.setContentAreaFilled(false);
      btnAppleJU.setBorderPainted(false);
      btnAppleJU.setBounds(10, 155, 180, 145);
      btnAppleJU.setPreferredSize(new Dimension(180, 145));
      p_inFruitAlcohol.add(btnAppleJU);
      
      btnAppleJU.addActionListener(l);
      
      JButton btnOrangeJU = new JButton("생오렌지주");
      btnOrangeJU.setFocusPainted(false);
      btnOrangeJU.setContentAreaFilled(false);
      btnOrangeJU.setBorderPainted(false);
      btnOrangeJU.setBounds(195, 155, 180, 145);
      btnOrangeJU.setPreferredSize(new Dimension(180, 145));
      p_inFruitAlcohol.add(btnOrangeJU);
      
      btnOrangeJU.addActionListener(l);
      
      JPanel p_inSalad = new JPanel();
//      p_CardLayout.add(p_inSnack, "name_20920245608460");
      p_inSalad.setBackground(new Color(255,0,0,0));
      p_CardLayout.add("inSaladPanel",p_inSalad);
      
      JButton btnPongdue = new JButton("과일퐁듀");
      btnPongdue.setFocusPainted(false);
      btnPongdue.setContentAreaFilled(false);
      btnPongdue.setBorderPainted(false);
      btnPongdue.setPreferredSize(new Dimension(180, 145));
      p_inSalad.add(btnPongdue);
      
      btnPongdue.addActionListener(l);
      
      JButton btnLAMochi = new JButton("LA떡다져쓰");
      btnLAMochi.setFocusPainted(false);
      btnLAMochi.setContentAreaFilled(false);
      btnLAMochi.setBorderPainted(false);
      btnLAMochi.setPreferredSize(new Dimension(180, 145));
      p_inSalad.add(btnLAMochi);
      
      btnLAMochi.addActionListener(l);
      
      JButton btnRawmeat = new JButton("살아있네살아있어");
      btnRawmeat.setFocusPainted(false);
      btnRawmeat.setContentAreaFilled(false);
      btnRawmeat.setBorderPainted(false);
      btnRawmeat.setPreferredSize(new Dimension(180, 145));
      p_inSalad.add(btnRawmeat);
      
      btnRawmeat.addActionListener(l);
      
      JButton btnChickenSalad = new JButton("콩닭콩닭");
      btnChickenSalad.setFocusPainted(false);
      btnChickenSalad.setContentAreaFilled(false);
      btnChickenSalad.setBorderPainted(false);
      btnChickenSalad.setPreferredSize(new Dimension(180, 145));
      p_inSalad.add(btnChickenSalad);
      
      btnChickenSalad.addActionListener(l);
      
      JButton btnPhotoTime = new JButton("포토타임");
      btnPhotoTime.setFocusPainted(false);
      btnPhotoTime.setContentAreaFilled(false);
      btnPhotoTime.setBorderPainted(false);
      btnPhotoTime.setPreferredSize(new Dimension(180, 145));
      p_inSalad.add(btnPhotoTime);
      
      btnPhotoTime.addActionListener(l);
      
      JButton btnNurungji = new JButton("누룽지샐러드");
      btnNurungji.setFocusPainted(false);
      btnNurungji.setContentAreaFilled(false);
      btnNurungji.setBorderPainted(false);
      btnNurungji.setPreferredSize(new Dimension(180, 145));
      p_inSalad.add(btnNurungji);
      
      btnNurungji.addActionListener(l);
      
      JPanel p_inCheese = new JPanel();
      p_inCheese.setBackground(new Color(255,0,0,0));
//      p_CardLayout.add(p_inCheese, "name_13441570385332");
      p_CardLayout.add("inCheesePanel",p_inCheese);
      p_inCheese.setLayout(null);
      
      JButton btnVeryBulDak = new JButton("베리베리러블리불닭");
      btnVeryBulDak.setIcon(new ImageIcon("images/lovehotchicken.png"));
      btnVeryBulDak.setFocusPainted(false);
      btnVeryBulDak.setContentAreaFilled(false);
      btnVeryBulDak.setBorderPainted(false);
      btnVeryBulDak.setBounds(10, 5, 180, 145);
      btnVeryBulDak.setPreferredSize(new Dimension(180, 145));
      p_inCheese.add(btnVeryBulDak);
      
      btnVeryBulDak.addActionListener(l);
      
      JButton btnBulgogiPizza = new JButton("불고기피자");
      btnBulgogiPizza.setIcon(new ImageIcon("images/bulgogipizza.png"));
      btnBulgogiPizza.setFocusPainted(false);
      btnBulgogiPizza.setContentAreaFilled(false);
      btnBulgogiPizza.setBorderPainted(false);
      btnBulgogiPizza.setBounds(195, 5, 180, 145);
      btnBulgogiPizza.setPreferredSize(new Dimension(180, 145));
      p_inCheese.add(btnBulgogiPizza);
      
      btnBulgogiPizza.addActionListener(l);
      
      JButton btnGampiTang = new JButton("김피탕");
      btnGampiTang.setIcon(new ImageIcon("images/gimpitang.png"));
      btnGampiTang.setFocusPainted(false);
      btnGampiTang.setContentAreaFilled(false);
      btnGampiTang.setBorderPainted(false);
      btnGampiTang.setBounds(380, 5, 180, 145);
      btnGampiTang.setPreferredSize(new Dimension(180, 145));
      p_inCheese.add(btnGampiTang);
      
      btnGampiTang.addActionListener(l);
      
      JButton btnCheeseGangjung = new JButton("치즈닭강정");
      btnCheeseGangjung.setIcon(new ImageIcon("images/cheesegang.png"));
      btnCheeseGangjung.setFocusPainted(false);
      btnCheeseGangjung.setContentAreaFilled(false);
      btnCheeseGangjung.setBorderPainted(false);
      btnCheeseGangjung.setBounds(10, 155, 180, 145);
      btnCheeseGangjung.setPreferredSize(new Dimension(180, 145));
      p_inCheese.add(btnCheeseGangjung);
      
      btnCheeseGangjung.addActionListener(l);
      
      JButton btnCrmCheeseChicken = new JButton("크림치즈러브미치킨");
      btnCrmCheeseChicken.setIcon(new ImageIcon("images/creamcheesechicken.png"));
      btnCrmCheeseChicken.setFocusPainted(false);
      btnCrmCheeseChicken.setContentAreaFilled(false);
      btnCrmCheeseChicken.setBorderPainted(false);
      btnCrmCheeseChicken.setBounds(195, 155, 180, 145);
      btnCrmCheeseChicken.setPreferredSize(new Dimension(180, 145));
      p_inCheese.add(btnCrmCheeseChicken);
      
      btnCrmCheeseChicken.addActionListener(l);
      
      JPanel p_inBest = new JPanel();
//      p_CardLayout.add(p_inBest, "name_13466408203397");
      p_inBest.setBackground(new Color(255,0,0,0));
      p_CardLayout.add("inBestPanel",p_inBest);
      
      JButton btnHotChicken = new JButton("매운꺄르르치킨");
      btnHotChicken.setFocusPainted(false);
      btnHotChicken.setContentAreaFilled(false);
      btnHotChicken.setBorderPainted(false);
      btnHotChicken.setPreferredSize(new Dimension(180, 145));
      p_inBest.add(btnHotChicken);
      
      btnHotChicken.addActionListener(l);
      
      JButton btnCrmHotChicken = new JButton("크림속매운닭강정");
      btnCrmHotChicken.setFocusPainted(false);
      btnCrmHotChicken.setContentAreaFilled(false);
      btnCrmHotChicken.setBorderPainted(false);
      btnCrmHotChicken.setPreferredSize(new Dimension(180, 145));
      p_inBest.add(btnCrmHotChicken);
      
      btnCrmHotChicken.addActionListener(l);
      
      JButton btnPaDak = new JButton("푸다닭파다닭");
      btnPaDak.setFocusPainted(false);
      btnPaDak.setContentAreaFilled(false);
      btnPaDak.setBorderPainted(false);
      btnPaDak.setPreferredSize(new Dimension(180, 145));
      p_inBest.add(btnPaDak);
      
      btnPaDak.addActionListener(l);
      
      JButton btnBigChicken = new JButton("통큰통닭");
      btnBigChicken.setFocusPainted(false);
      btnBigChicken.setContentAreaFilled(false);
      btnBigChicken.setBorderPainted(false);
      btnBigChicken.setPreferredSize(new Dimension(180, 145));
      p_inBest.add(btnBigChicken);
      
      btnBigChicken.addActionListener(l);
      
      JButton btnXOMochi = new JButton("XO떡볶이");
      btnXOMochi.setFocusPainted(false);
      btnXOMochi.setContentAreaFilled(false);
      btnXOMochi.setBorderPainted(false);
      btnXOMochi.setPreferredSize(new Dimension(180, 145));
      p_inBest.add(btnXOMochi);
      
      btnXOMochi.addActionListener(l);
      
      JButton btnLol = new JButton("L.O.L");
      btnLol.setFocusPainted(false);
      btnLol.setContentAreaFilled(false);
      btnLol.setBorderPainted(false);
      btnLol.setPreferredSize(new Dimension(180, 145));
      p_inBest.add(btnLol);
      
      btnLol.addActionListener(l);
      
      JPanel p_inRoasting = new JPanel();
//      p_CardLayout.add(p_inRoasting, "name_13487163303938");
      p_inRoasting.setBackground(new Color(255,0,0,0));
      p_CardLayout.add("inRoastingPanel",p_inRoasting);
      
      JButton btnHerbRoasting = new JButton("차도녀숙주볶음");
      btnHerbRoasting.setFocusPainted(false);
      btnHerbRoasting.setBorderPainted(false);
      btnHerbRoasting.setContentAreaFilled(false);
      btnHerbRoasting.setPreferredSize(new Dimension(180, 145));
      p_inRoasting.add(btnHerbRoasting);
      
      btnHerbRoasting.addActionListener(l);
      
      JButton btnyoyo = new JButton("오돌마yo시켜yo");
      btnyoyo.setFocusPainted(false);
      btnyoyo.setBorderPainted(false);
      btnyoyo.setContentAreaFilled(false);
      btnyoyo.setPreferredSize(new Dimension(180, 145));
      p_inRoasting.add(btnyoyo);
      
      btnyoyo.addActionListener(l);
      
      JButton btnSandHouseRoasting = new JButton("모래집볶음");
      btnSandHouseRoasting.setFocusPainted(false);
      btnSandHouseRoasting.setBorderPainted(false);
      btnSandHouseRoasting.setContentAreaFilled(false);
      btnSandHouseRoasting.setPreferredSize(new Dimension(180, 145));
      p_inRoasting.add(btnSandHouseRoasting);
      
      btnSandHouseRoasting.addActionListener(l);
      
      JButton btnHanoisMorning = new JButton("하노이의아침");
      btnHanoisMorning.setFocusPainted(false);
      btnHanoisMorning.setBorderPainted(false);
      btnHanoisMorning.setContentAreaFilled(false);
      btnHanoisMorning.setPreferredSize(new Dimension(180, 145));
      p_inRoasting.add(btnHanoisMorning);
      
      btnHanoisMorning.addActionListener(l);
      
      JButton btnAnsim = new JButton("안심하드라고");
      btnAnsim.setFocusPainted(false);
      btnAnsim.setBorderPainted(false);
      btnAnsim.setContentAreaFilled(false);
      btnAnsim.setPreferredSize(new Dimension(180, 145));
      btnAnsim.setIcon(new ImageIcon("images/ansim.jpg"));
      p_inRoasting.add(btnAnsim);
      
      btnAnsim.addActionListener(l);
      
      JButton btnKing = new JButton("힘센삼겹");
      btnKing.setFocusPainted(false);
      btnKing.setBorderPainted(false);
      btnKing.setContentAreaFilled(false);
      btnKing.setPreferredSize(new Dimension(180, 145));
      p_inRoasting.add(btnKing);
      
      btnKing.addActionListener(l);
      
      JPanel p_inSoup = new JPanel();
//      p_CardLayout.add(p_inSoup, "name_13493518496030");
      p_inSoup.setBackground(new Color(255,0,0,0));
      p_CardLayout.add("inSoupPanel", p_inSoup);
      
      JButton btnNurungjiTang = new JButton("누룽지탕");
      btnNurungjiTang.setFocusPainted(false);
      btnNurungjiTang.setContentAreaFilled(false);
      btnNurungjiTang.setBorderPainted(false);
      btnNurungjiTang.setPreferredSize(new Dimension(180, 145));
      p_inSoup.add(btnNurungjiTang);
      
      btnNurungjiTang.addActionListener(l);
      
      JButton btnBuDae = new JButton("부대찌개");
      btnBuDae.setFocusPainted(false);
      btnBuDae.setContentAreaFilled(false);
      btnBuDae.setBorderPainted(false);
      btnBuDae.setPreferredSize(new Dimension(180, 145));
      p_inSoup.add(btnBuDae);
      
      btnBuDae.addActionListener(l);
      
      JButton btnJJangAJJi = new JButton("고추장찌개");
      btnJJangAJJi.setFocusPainted(false);
      btnJJangAJJi.setContentAreaFilled(false);
      btnJJangAJJi.setBorderPainted(false);
      btnJJangAJJi.setPreferredSize(new Dimension(180, 145));
      p_inSoup.add(btnJJangAJJi);
      
      btnJJangAJJi.addActionListener(l);
      
      JButton btnUA = new JButton("우아한갈비찜");
      btnUA.setFocusPainted(false);
      btnUA.setContentAreaFilled(false);
      btnUA.setBorderPainted(false);
      btnUA.setPreferredSize(new Dimension(180, 145));
      p_inSoup.add(btnUA);
      
      btnUA.addActionListener(l);
      
      JButton btnOdeng = new JButton("오뎅탕");
      btnOdeng.setFocusPainted(false);
      btnOdeng.setContentAreaFilled(false);
      btnOdeng.setBorderPainted(false);
      btnOdeng.setPreferredSize(new Dimension(180, 145));
      p_inSoup.add(btnOdeng);
      
      btnOdeng.addActionListener(l);
      
      JButton btnJJamBBong = new JButton("짬뽕");
      btnJJamBBong.setFocusPainted(false);
      btnJJamBBong.setContentAreaFilled(false);
      btnJJamBBong.setBorderPainted(false);
      btnJJamBBong.setPreferredSize(new Dimension(180, 145));
      p_inSoup.add(btnJJamBBong);
      
      btnJJamBBong.addActionListener(l);
      
      JPanel p_inDrink = new JPanel();
//      p_CardLayout.add(p_inDrinknMeal, "name_20167251879038");
      p_inDrink.setBackground(new Color(255,0,0,0));
      p_CardLayout.add("inDrinkPanel", p_inDrink);
      
      JButton btnCola = new JButton("콜라");
      btnCola.setFocusPainted(false);
      btnCola.setContentAreaFilled(false);
      btnCola.setBorderPainted(false);
      btnCola.setPreferredSize(new Dimension(180, 145));
      p_inDrink.add(btnCola);
      
      btnCola.addActionListener(l);
      
      JButton btnCider = new JButton("사이다");
      btnCider.setFocusPainted(false);
      btnCider.setContentAreaFilled(false);
      btnCider.setBorderPainted(false);
      btnCider.setPreferredSize(new Dimension(180, 145));
      p_inDrink.add(btnCider);

      btnCider.addActionListener(l);
      
      JButton btnOrangJuice = new JButton("오렌지주스");
      btnOrangJuice.setFocusPainted(false);
      btnOrangJuice.setContentAreaFilled(false);
      btnOrangJuice.setBorderPainted(false);
      btnOrangJuice.setPreferredSize(new Dimension(180, 145));
      p_inDrink.add(btnOrangJuice);
      
      btnOrangJuice.addActionListener(l);
      
      JButton btnRedBull = new JButton("레드불");
      btnRedBull.setFocusPainted(false);
      btnRedBull.setContentAreaFilled(false);
      btnRedBull.setBorderPainted(false);
      btnRedBull.setPreferredSize(new Dimension(180, 145));
      p_inDrink.add(btnRedBull);
      
      btnRedBull.addActionListener(l);
      
      JButton btnTonicWater = new JButton("토닉워터");
      btnTonicWater.setFocusPainted(false);
      btnTonicWater.setContentAreaFilled(false);
      btnTonicWater.setBorderPainted(false);
      btnTonicWater.setPreferredSize(new Dimension(180, 145));
      p_inDrink.add(btnTonicWater);
      
      btnTonicWater.addActionListener(l);
      
      JButton btnCoolPeace = new JButton("쿨피스");
      btnCoolPeace.setFocusPainted(false);
      btnCoolPeace.setContentAreaFilled(false);
      btnCoolPeace.setBorderPainted(false);
      btnCoolPeace.setPreferredSize(new Dimension(180, 145));
      p_inDrink.add(btnCoolPeace);
      
      btnCoolPeace.addActionListener(l);
      
      JPanel p_inSelfMenu = new JPanel();
//      p_CardLayout.add(p_inSelfMenu, "name_13594833627279");
      p_inSelfMenu.setBackground(new Color(255,0,0,0));
      p_CardLayout.add("inSelfMenuPanel",p_inSelfMenu);
      p_inSelfMenu.setLayout(null);
      
      JButton btnCondition = new JButton("컨디션");
      btnCondition.setFocusPainted(false);
      btnCondition.setContentAreaFilled(false);
      btnCondition.setBorderPainted(false);
      btnCondition.setBounds(10, 5, 180, 145);
      btnCondition.setPreferredSize(new Dimension(180, 145));
      p_inSelfMenu.add(btnCondition);
      
      btnCondition.addActionListener(l);
      
      JButton btnOxiWater = new JButton("에스프레소");
      btnOxiWater.setFocusPainted(false);
      btnOxiWater.setContentAreaFilled(false);
      btnOxiWater.setBorderPainted(false);
      btnOxiWater.setBounds(195, 5, 180, 145);
      btnOxiWater.setPreferredSize(new Dimension(180, 145));
      p_inSelfMenu.add(btnOxiWater);
      
      btnOxiWater.addActionListener(l);
      
      JButton btnAmericano = new JButton("아메리카노");
      btnAmericano.setFocusPainted(false);
      btnAmericano.setContentAreaFilled(false);
      btnAmericano.setBorderPainted(false);
      btnAmericano.setBounds(380, 5, 180, 145);
      btnAmericano.setPreferredSize(new Dimension(180, 145));
      p_inSelfMenu.add(btnAmericano);
      
      btnAmericano.addActionListener(l);
      
      JButton btnCafelatte = new JButton("카페라떼");
      btnCafelatte.setFocusPainted(false);
      btnCafelatte.setContentAreaFilled(false);
      btnCafelatte.setBorderPainted(false);
      btnCafelatte.setBounds(10, 155, 180, 145);
      btnCafelatte.setPreferredSize(new Dimension(180, 145));
      p_inSelfMenu.add(btnCafelatte);
      
      btnCafelatte.addActionListener(l);
      
      JButton btnSoftIce = new JButton("소프트아이스크림");
      btnSoftIce.setFocusPainted(false);
      btnSoftIce.setContentAreaFilled(false);
      btnSoftIce.setBorderPainted(false);
      btnSoftIce.setBounds(195, 155, 180, 145);
      btnSoftIce.setPreferredSize(new Dimension(180, 145));
      p_inSelfMenu.add(btnSoftIce);
      
      btnSoftIce.addActionListener(l);
      
      JPanel p_inSubMenu = new JPanel();
//      p_CardLayout.add(p_inSubMenu, "name_13614852838879");
      p_inSubMenu.setBackground(new Color(255,0,0,0));
      p_CardLayout.add("inSubMenuPanel",p_inSubMenu);
      p_inSubMenu.setLayout(null);
      
      JButton btnRamen = new JButton("다줄게라면");
      btnRamen.setFocusPainted(false);
      btnRamen.setContentAreaFilled(false);
      btnRamen.setBorderPainted(false);
      btnRamen.setBounds(10, 5, 180, 145);
      btnRamen.setPreferredSize(new Dimension(180, 145));
      p_inSubMenu.add(btnRamen);
      
      btnRamen.addActionListener(l);
      
      JButton btnJJapa = new JButton("속타는짜파게티");
      btnJJapa.setFocusPainted(false);
      btnJJapa.setContentAreaFilled(false);
      btnJJapa.setBorderPainted(false);
      btnJJapa.setBounds(195, 5, 180, 145);
      btnJJapa.setPreferredSize(new Dimension(180, 145));
      p_inSubMenu.add(btnJJapa);
      
      btnJJapa.addActionListener(l);
      
      JButton btnLunchBox = new JButton("유혹의도시락");
      btnLunchBox.setFocusPainted(false);
      btnLunchBox.setContentAreaFilled(false);
      btnLunchBox.setBorderPainted(false);
      btnLunchBox.setBounds(380, 5, 180, 145);
      btnLunchBox.setPreferredSize(new Dimension(180, 145));
      p_inSubMenu.add(btnLunchBox);
      
      btnLunchBox.addActionListener(l);
      
      JButton btnMayo = new JButton("마요주먹밥");
      btnMayo.setFocusPainted(false);
      btnMayo.setContentAreaFilled(false);
      btnMayo.setBorderPainted(false);
      btnMayo.setBounds(10, 155, 180, 145);
      btnMayo.setPreferredSize(new Dimension(180, 145));
      p_inSubMenu.add(btnMayo);
      
      btnMayo.addActionListener(l);
      
      JButton btnCKR = new JButton("치즈김치볶음밥");
      btnCKR.setIcon(new ImageIcon("images/kimchibob.png"));
      btnCKR.setFocusPainted(false);
      btnCKR.setContentAreaFilled(false);
      btnCKR.setBorderPainted(false);
      btnCKR.setBounds(195, 155, 180, 145);
      btnCKR.setPreferredSize(new Dimension(180, 145));
      p_inSubMenu.add(btnCKR);
      
      btnCKR.addActionListener(l);
      
      JPanel p_inAddSari = new JPanel();
//      p_CardLayout.add(p_inAddSari, "name_13629004426024");
      p_inAddSari.setBackground(new Color(255,0,0,0));
      p_CardLayout.add("inAddSariPanel", p_inAddSari);
      
      JButton btnRemenSari = new JButton("라면사리");
      btnRemenSari.setFocusPainted(false);
      btnRemenSari.setContentAreaFilled(false);
      btnRemenSari.setBorderPainted(false);
      btnRemenSari.setPreferredSize(new Dimension(180, 145));
      p_inAddSari.add(btnRemenSari);
      
      btnRemenSari.addActionListener(l);
      
      JButton btnUdongSari = new JButton("우동사리");
      btnUdongSari.setFocusPainted(false);
      btnUdongSari.setContentAreaFilled(false);
      btnUdongSari.setBorderPainted(false);
      btnUdongSari.setPreferredSize(new Dimension(180, 145));
      p_inAddSari.add(btnUdongSari);
      
      btnUdongSari.addActionListener(l);
      
      JButton btnJJolMen = new JButton("쫄면사리");
      btnJJolMen.setFocusPainted(false);
      btnJJolMen.setContentAreaFilled(false);
      btnJJolMen.setBorderPainted(false);
      btnJJolMen.setPreferredSize(new Dimension(180, 145));
      p_inAddSari.add(btnJJolMen);
      
      btnJJolMen.addActionListener(l);
      
      p_Num = new JPanel();
      p_Num.setLayout(null);
      p_Num.setPreferredSize(new Dimension(300, 35));
      p_Num.setBounds(0, 408, 570, 70);
      p_Num.setBackground(new Color(255,0,0,0));
      contentPane.add(p_Num);
      
      JLabel lbldisplayOrderNum = new JLabel("\uC218\uB7C9 :");
      lbldisplayOrderNum.setBounds(12, 45, 32, 15);
      p_Num.add(lbldisplayOrderNum);
      
      lblOrderNum = new JLabel("0");
      lblOrderNum.setBounds(49, 45, 20, 15);
      p_Num.add(lblOrderNum);
      
      btnPlus = new JButton("+");
      btnPlus.setPreferredSize(new Dimension(40, 23));
      btnPlus.setBounds(183, 41, 90, 23);
      p_Num.add(btnPlus);
      
      btnPlus.addActionListener(l);
      
      btnMinus = new JButton("-");
      btnMinus.setPreferredSize(new Dimension(40, 23));
      btnMinus.setBounds(285, 41, 90, 23);
      p_Num.add(btnMinus);
      
      btnMinus.addActionListener(l);
      
//      icon1 = new ImageIcon("images/Bill.png");
      
      JPanel p_Payment = new JPanel();
      p_Payment.setBounds(584, 70, 200, 490);
      p_Payment.setPreferredSize(new Dimension(130, 300));
      p_Payment.setBackground(new Color(255,0,0,0));
      contentPane.add(p_Payment);
      p_Payment.setLayout(null);
      
      JLabel lblOrderCart = new JLabel();
      lblOrderCart.setBounds(8, 108, 0, 0);
      p_Payment.add(lblOrderCart);
      
      JScrollPane scrollPane = new JScrollPane();
      scrollPane.setBounds(8, 47, 180, 290);
      p_Payment.add(scrollPane);
      
      ta_totBill = new JTextArea();
      scrollPane.setViewportView(ta_totBill);
      ta_totBill.setRows(10);
      ta_totBill.setColumns(12);
      
      ta_totCost = new JTextArea();
      ta_totCost.setBounds(8, 338, 180, 40);
      ta_totCost.setColumns(12);
      p_Payment.add(ta_totCost);
      
      btnOrder = new JButton("\uC8FC\uBB38");
      btnOrder.setFocusPainted(false);
      btnOrder.setContentAreaFilled(false);
      btnOrder.setBorderPainted(false);
      btnOrder.setIcon(new ImageIcon("images/orderbtn_img.png"));
      btnOrder.setBounds(8, 440, 88, 40);
      btnOrder.setPreferredSize(new Dimension(60, 23));
      p_Payment.add(btnOrder);
      
      btnOrder.addActionListener(l);
      
      btnOrderCancel = new JButton("\uC0AD\uC81C");
      btnOrderCancel.setContentAreaFilled(false);
      btnOrderCancel.setBorderPainted(false);
      btnOrderCancel.setFocusPainted(false);
      btnOrderCancel.setIcon(new ImageIcon("images/cancel_img.png"));
      btnOrderCancel.setBounds(100, 440, 88, 40);
      btnOrderCancel.setPreferredSize(new Dimension(60, 23));
      p_Payment.add(btnOrderCancel);
      
      btnOrderCancel.addActionListener(l);
      
      p_OrderCart = new JPanel();
      p_OrderCart.setPreferredSize(new Dimension(300, 35));
      p_OrderCart.setBounds(0, 482, 570, 80);
      p_OrderCart.setBackground(new Color(255,0,0,0));
      contentPane.add(p_OrderCart);
      p_OrderCart.setLayout(null);
      
      JButton btnBackPanel = new JButton("<");
      btnBackPanel.setBounds(12, 47, 57, 23);
      p_OrderCart.add(btnBackPanel);
      
      JButton btnInputTextArea = new JButton("주문담기");
      btnInputTextArea.setContentAreaFilled(false);
      btnInputTextArea.setBorderPainted(false);
      btnInputTextArea.setFocusPainted(false);
      btnInputTextArea.setIcon(new ImageIcon("images/cart_img.png"));
      btnInputTextArea.setBounds(180, 20, 200, 50);
      p_OrderCart.add(btnInputTextArea);
      
      JButton btnFrontPanel = new JButton(">");
      btnFrontPanel.setBounds(481, 47, 57, 23);
      p_OrderCart.add(btnFrontPanel);
      
      setVisible(true);
      
//      //Call Background image
//      myImage = null;
//      try {
//         myImage = ImageIO.read(new File("images/One_BG.jpg"));
//      } catch (IOException e1) {
//         e1.printStackTrace();
//      }
      
//      ImagePanel pn = new ImagePanel(myImage);   
//      contentPane.add(pn);
      
      btnInputTextArea.addActionListener(l);
      
      p_Num.setVisible(false);
      p_OrderCart.setVisible(false);
   }
   
   public void changePanel(String sChangePanel) 
   {
      if(sChangePanel.equals("OrderListPanel"))
      {
    	  lblcntNum=0;
    	  
         orderlist_flag = true;
         cards.show(p_CardLayout, "OrderListPanel");
         
         BufferedList.clear();
         hmap_OrderNum.clear();
         
         // p_Num
         // p_OrderCart
         // 가 안보이게
         p_Num.setVisible(false);
         p_OrderCart.setVisible(false);
         
         revalidate();
         repaint();
      }
      else if(sChangePanel.equals("inAlcoholPanel"))
      {
         orderlist_flag = false;
         cards.show(p_CardLayout, "inAlcoholPanel");
         revalidate();
         repaint();
      }
      else if(sChangePanel.equals("inLiveBeerPanel"))
      {
         orderlist_flag = false;
         cards.show(p_CardLayout, "inLiveBeerPanel");
         revalidate();
         repaint();
      }
      else if(sChangePanel.equals("inBottleBeerPanel"))
      {
         orderlist_flag = false;
         cards.show(p_CardLayout, "inBottleBeerPanel");
         revalidate();
         repaint();
      }

      else if(sChangePanel.equals("inFruitAlcoholPanel"))
      {
         orderlist_flag = false;
         cards.show(p_CardLayout, "inFruitAlcoholPanel");
         revalidate();
         repaint();
      }
      else if(sChangePanel.equals("inSaladPanel"))
      {
         orderlist_flag = false;
         cards.show(p_CardLayout, "inSaladPanel");
         revalidate();
         repaint();
      }
      else if(sChangePanel.equals("inCheesePanel"))
      {
         orderlist_flag = false;
         cards.show(p_CardLayout, "inCheesePanel");
         revalidate();
         repaint();
      }
      else if(sChangePanel.equals("inBestPanel"))
      {
         orderlist_flag = false;
         cards.show(p_CardLayout, "inBestPanel");
         revalidate();
         repaint();
      }
      else if(sChangePanel.equals("inRoastingPanel"))
      {
         orderlist_flag = false;
         cards.show(p_CardLayout, "inRoastingPanel");
         revalidate();
         repaint();
      }
      else if(sChangePanel.equals("inSoupPanel"))
      {
         orderlist_flag = false;
         cards.show(p_CardLayout, "inSoupPanel");
         revalidate();
         repaint();
      }
      else if(sChangePanel.equals("inDrinkPanel"))
      {
         orderlist_flag = false;
         cards.show(p_CardLayout, "inDrinkPanel");
         revalidate();
         repaint();
      }
      else if(sChangePanel.equals("inSelfMenuPanel"))
      {
         orderlist_flag = false;
         cards.show(p_CardLayout, "inSelfMenuPanel");
         revalidate();
         repaint();
      }
      else if(sChangePanel.equals("inSubMenuPanel"))
      {
         orderlist_flag = false;
         cards.show(p_CardLayout, "inSubMenuPanel");
         revalidate();
         repaint();
      }
      else if(sChangePanel.equals("inAddSariPanel"))
      {
         orderlist_flag = false;
         cards.show(p_CardLayout, "inAddSariPanel");
         revalidate();
         repaint();
      }

   }

   class OrderListener implements ActionListener{
	  String pi;
      @Override
      public void actionPerformed(ActionEvent e) {
         // TODO Auto-generated method stub
         String o_cmd = e.getActionCommand();
         DBConnection db = DBConnection.getInstance();
         
         switch(o_cmd)
         {
         case "이전":
            if(orderlist_flag)
            {
               dispose();
               mainFrame.setVisible(true);            
            }
            else
            {
            	// HashMap
            	// Buffered 는 비워줘야함
            	changePanel("OrderListPanel");
           	 	BufferedList.clear();
           	 	hmap_OrderNum.clear();
           	 	lblOrderNum.setText("0");
            }
            break;
            // Card Panel
         case "술":
            changePanel("inAlcoholPanel");
            p_Num.setVisible(true);
            p_OrderCart.setVisible(true);
            break;
         case "안주":
            changePanel("inSaladPanel");
            p_Num.setVisible(true);
            p_OrderCart.setVisible(true);
            break;
         case "음료/식사":
            changePanel("inDrinkPanel");
            p_Num.setVisible(true);
            p_OrderCart.setVisible(true);
            break;
         case "소주/전통주":
             changePanel("inAlcoholPanel");
             p_Num.setVisible(true);
             p_OrderCart.setVisible(true);
             break; 
         case "생맥주":
             changePanel("inLiveBeerPanel");
             p_Num.setVisible(true);
             p_OrderCart.setVisible(true);
             break; 
         case "병맥주":
             changePanel("inBottleBeerPanel");
             p_Num.setVisible(true);
             p_OrderCart.setVisible(true);
             break; 
         case "생과일주":
             changePanel("inFruitAlcoholPanel");
             p_Num.setVisible(true);
             p_OrderCart.setVisible(true);
             break; 
         case "샐러드":
             changePanel("inSaladPanel");
             p_Num.setVisible(true);
             p_OrderCart.setVisible(true);
             break; 
         case "치즈류":
             changePanel("inCheesePanel");
             p_Num.setVisible(true);
             p_OrderCart.setVisible(true);
             break; 
         case "일품요리류":
             changePanel("inBestPanel");
             p_Num.setVisible(true);
             p_OrderCart.setVisible(true);
             break; 
         case "볶음류":
             changePanel("inRoastingPanel");
             p_Num.setVisible(true);
             p_OrderCart.setVisible(true);
             break; 
         case "탕류":
             changePanel("inSoupPanel");
             p_Num.setVisible(true);
             p_OrderCart.setVisible(true);
             break; 
         case "음료":
             changePanel("inDrinkPanel");
             p_Num.setVisible(true);
             p_OrderCart.setVisible(true);
             break; 
         case "셀프메뉴":
             changePanel("inSelfMenuPanel");
             p_Num.setVisible(true);
             p_OrderCart.setVisible(true);
             break; 
         case "서브메뉴":
             changePanel("inSubMenuPanel");
             p_Num.setVisible(true);
             p_OrderCart.setVisible(true);
             break; 
         case "추가사리":
             changePanel("inAddSariPanel");
             p_Num.setVisible(true);
             p_OrderCart.setVisible(true);
             break; 
         // Soju sub List
         case "부라더소주":
        	 break;
         case "순하리(사과)":
        	 break;
         case "참이슬":
        	 break;
         case "참이슬(자몽)":
        	 System.out.println("!!!!!");
        	 // get number
        	 lblcntNum++;
        	 pi = lblcntNum + ""; 
        	 lblOrderNum.setText(pi);
        	 
    		 if(BufferedList.size() == 0 )
    		 {
    			 BufferedList.add("참이슬(자몽)");
    		 }
        	 
        	 // 참 참 일때
        	 // 들어가있으면 안되게끔
        	 for(int i = 0 ; i < BufferedList.size() ; i++)
        	 {
        		 // 존재하지 않으면 add
        		 if( !(BufferedList.get(i).equals("참이슬(자몽)")) )
        		 {
        			 BufferedList.add("참이슬(자몽)");
        		 }
        	 }
        	 
        	 // 키를 포함하고있으면 true 리턴
        	 if(hmap_OrderNum.containsKey("참이슬(자몽)"))
        	 {
        		 // 원래 value 에 +1
        		 int tempNum = hmap_OrderNum.get("참이슬(자몽)");
        		 hmap_OrderNum.put("참이슬(자몽)", tempNum+1);
        	 }
        	 else
        	 {
        		 hmap_OrderNum.put("참이슬(자몽)", 1);
        	 }
        	 
        	 break;
         case "순하리(복분자)":
        	 break;
         // LiveBeer sub List
         case "잉글리쉬에일":
        	 break;
         case "레페블론드":
        	 break;
         case "골든에일":
        	 break;
         case "기네스":
        	 break;
         case "칼스버그":
        	 break;
         case "발티카":
        	 break;
         //  sub bottle beer
         case "하이트":
        	 break;
         case "코로나":
        	 break;
         case "하이네켄":
        	 break;
         case "1664블랑":
        	 break;
         case "제주에일":
        	 break;
         case "호가든":
        	 break;
         // sub Fruit Soju
         case "생딸기주":
        	 break;
         case "생키위주":
        	 break;
         case "생파인애플주":
        	 break;
         case "생사과주":
        	 break;
         case "생오렌지주":
        	 break;
        // sub salad
         case "과일퐁듀":
        	 break;
         case "LA떡다져쓰":
        	 break;
         case "살아있네살아있어":
        	 break;
         case "콩닭콩닭":
        	 break;
         case "포토타임":
        	 break;
         case "누룽지샐러드":
        	 break;
        // sub cheese
         case "베리베리러블리불닭":
        	 System.out.println("!!!!!");
        	 // get number
        	 lblcntNum++;
        	 pi = lblcntNum + ""; 
        	 lblOrderNum.setText(pi);

    		 if(BufferedList.size() == 0 )
    		 {
    			 BufferedList.add("베리베리러블리불닭");
    		 }
        	 
        	 // 참 참 일때
        	 // 들어가있으면 안되게끔
        	 for(int i = 0 ; i < BufferedList.size() ; i++)
        	 {
        		 // 존재하지 않으면 add
        		 if( !(BufferedList.get(i).equals("베리베리러블리불닭")) )
        		 {
        			 BufferedList.add("베리베리러블리불닭");
        		 }
        	 }
        	 // 키를 포함하고있으면 true 리턴
        	 if(hmap_OrderNum.containsKey("베리베리러블리불닭"))
        	 {
        		 // 원래 value 에 +1
        		 int tempNum = hmap_OrderNum.get("베리베리러블리불닭");
        		 hmap_OrderNum.put("베리베리러블리불닭", tempNum+1);
        	 }
        	 else
        	 {
        		 hmap_OrderNum.put("베리베리러블리불닭", 1);
        	 }
        	 
        	 break;
         case "불고기피자":
        	 break;
         case "김피탕":
        	 break;
         case "치즈닭강정":
        	 break;
         case "크림치즈러브미치킨":
        	 break;
        // sub best
         case "매운꺄르르치킨":
        	 break;
         case "크림속매운닭강정":
        	 break;
         case "푸다닭파다닭":
        	 break;
         case "통큰통닭":
        	 break;
         case "XO떡볶이":
        	 break;
         case "L.O.L":
        	 break;
        // sub Roasting
         case "차도녀숙주볶음":
        	 break;
         case "오돌마yo시켜yo":
        	 break;
         case "모래집볶음":
        	 break;
         case "하노이의아침":
        	 break;
         case "안심하드라고":
        	 System.out.println("!!!!!");
        	 // get number
        	 lblcntNum++;
        	 pi = lblcntNum + "";
        	 // pi 는 전체갯수
        	 lblOrderNum.setText(pi);

    		 if(BufferedList.size() == 0 )
    		 {
    			 BufferedList.add("안심하드라고");
    		 }
        	 // 참 참 일때
        	 // 들어가있으면 안되게끔
        	 for(int i = 0 ; i < BufferedList.size() ; i++)
        	 {
        		 // 존재하지 않으면 add
        		 if( !(BufferedList.get(i).equals("안심하드라고")) )
        		 {
        			 BufferedList.add("안심하드라고");
        		 }
        		 
        	 }
        	 
        	 // 키를 포함하고있으면 true 리턴
        	 if(hmap_OrderNum.containsKey("안심하드라고"))
        	 {
        		 // 원래 value 에 +1
        		 int tempNum = hmap_OrderNum.get("안심하드라고");
        		 hmap_OrderNum.put("안심하드라고", tempNum+1);
        	 }
        	 else
        	 {
        		 hmap_OrderNum.put("안심하드라고", 1);
        	 }
        	 
        	 break;
         case "힘센삼겹":
        	 break;
        // sub soup
         case "누룽지탕":
        	 break;
         case "부대찌개":
        	 break;
         case "고추장찌개":
        	 break;
         case "우아한갈비찜":
        	 break;
         case "오뎅탕":
        	 break;
         case "짬뽕":
        	 break;
        // sub drink
         case "콜라":
        	 break;
         case "사이다":
        	 break;
         case "오렌지주스":
        	 break;
         case "레드불":
        	 break;
         case "토닉워터":
        	 break;
         case "쿨피스":
        	 break;
         case "컨디션":
        	 break;
         case "에스프레스":
        	 break;
         case "아메리카노":
        	 break;
         case "카페라떼":
        	 break;
         case "소프트아이스크림":
        	 break;
        // sub submenu
         case "다줄게라면":
        	 break;
         case "속타는짜파게티":
        	 break;
         case "유혹의도시락":
        	 break;
         case "마요주먹밥":
        	 break;
         case "치즈김치볶음밥":
        	 break;
        // sub add sari
         case "라면사리":
        	 break;
         case "우동사리":
        	 break;
         case "쫄면사리":
        	 break;
         case "주문담기":
			ArrayList<Product> list = db.select();

			for( int i = 0 ; i < BufferedList.size() ; i++ )
			{	
				
				for( int j = 0 ; j < list.size() ; j++ )
				{			
					StringTokenizer st = new StringTokenizer(list.get(j).toString()," ");
					// 참참
					// 안안
					// 베베
					// HashMap<String,Int> hmap_OrderNum = new HashMap<>();
					// 주문완료하면 둘다 비워줘, BufferedList 와 HashMap
					
//					for(int n = 0 ; n < 2 ; n++ )
					while(st.hasMoreTokens())
					{
						if(BufferedList.get(i).toString().equals(st.nextToken()))
						{	
							System.out.println(list.get(j).toString()+" x"+hmap_OrderNum.get(BufferedList.get(i).toString())+"\n");
							ta_totBill.append(list.get(j).toString()+" x"+hmap_OrderNum.get(BufferedList.get(i).toString())+"\n");
							break;
						}
					}				
				}
			}
			
			BufferedList.clear();
			hmap_OrderNum.clear();
			lblcntNum=0;
			lblOrderNum.setText("0");
			break;
         case "주문":
        	StringTokenizer st = new StringTokenizer(ta_totBill.getText()," x\n");
        	int TokenCnt = 0;
        	
        	String BufferToken = "";
        	String NameToken = "";
        	String PriceToken = "";
        	String QuantityToken = "";
        	
        	while(st.hasMoreTokens())
        	{
        		BufferToken = st.nextToken();
        		TokenCnt++;
        		
        		// 이름 토큰
        		if(TokenCnt%3 == 1)
        		{
        			NameToken = BufferToken;
        		}
        		
        		// 가격 토큰
        		if(TokenCnt%3 == 2)
        		{
        			PriceToken = BufferToken;
        		}
        		
        		// 갯수 토큰
        		if(TokenCnt%3 == 0)
        		{
        			// 세번째에 있는 갯수를 토큰으로 가져온다.
        			QuantityToken = BufferToken;
        		}
        		
        		// 이름, 가격, 갯수가 다 있어야 클래스에 넣을수 있다.
        		if(TokenCnt%3 == 0)
        		{
        			ArrayList<Product> p_list = db.selectPno(NameToken);
        			int pno = p_list.get(0).getPno();
        			String pname = NameToken;
        			int price = Integer.parseInt(PriceToken);
        			int quantity = Integer.parseInt(QuantityToken);
        			int tot_sales = price*quantity;
        			// 이것 내일 해결 하자
        			Date c_date = Date.valueOf("DEFAULT");
        			
        			Order order = new Order(ordnum, tno, pno, pname, price, tot_sales, quantity, c_date);
        			db.insert(order);
        		}
        	}
        	ordnum++;
        	ta_totBill.setText("");
        	 break;
         case "삭제":
        	 
        	 break;
         case "+":
        	 break;
         case "-":
        	 break;
         }
      }
   }
}