package com.barmgn.www;

import java.awt.CardLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.Rectangle;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

public class OrderFrame extends JFrame {

   private JPanel contentPane;
   CardLayout cards;
   private OrderFrame orderFrame;
   JPanel p_CardLayout=null;
   boolean orderlist_flag = false;
   JLabel lblOrderNum; 
   MainFrame mainFrame;
   int s_ChangeNum = 0;
   int order = 0;
   private JTextArea ta_totBill;
   
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
      
      p_CardLayout = new JPanel();
      p_CardLayout.setBounds(2, 61, 332, 170);
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
//      p_CardLayout.add(p_OrderList, "name_20130474218538");
      p_CardLayout.add("OrderListPanel", p_OrderList);
      p_OrderList.setLayout(new FlowLayout(FlowLayout.CENTER, 2, 2));
      
      JPanel p_AlcoholList = new JPanel();
      p_AlcoholList.setLayout(null);
      p_AlcoholList.setPreferredSize(new Dimension(106, 165));
      p_OrderList.add(p_AlcoholList);
      
      JLabel lblAlcohol = new JLabel("술");
      lblAlcohol.setHorizontalAlignment(SwingConstants.CENTER);
      lblAlcohol.setBounds(26, 5, 57, 15);
      p_AlcoholList.add(lblAlcohol);
      
      JButton btnSoju = new JButton("소주/전통주");
      btnSoju.setBounds(6, 25, 97, 23);
      p_AlcoholList.add(btnSoju);
      
      
      btnSoju.addActionListener(l);
      
      JButton btnLiveBeer = new JButton("생맥주");
      btnLiveBeer.setBounds(6, 53, 97, 23);
      p_AlcoholList.add(btnLiveBeer);
      
      btnLiveBeer.addActionListener(l);
      
      
      JButton btnBottleBeer = new JButton("병맥주");
      btnBottleBeer.setBounds(6, 81, 97, 23);
      p_AlcoholList.add(btnBottleBeer);
      
      
      btnBottleBeer.addActionListener(l);
      
      JButton btnFruitAlcohol = new JButton("생과일주");
      btnFruitAlcohol.setBounds(6, 109, 97, 23);
      p_AlcoholList.add(btnFruitAlcohol);
      
      btnFruitAlcohol.addActionListener(l);
      
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
      
      btnSalad.addActionListener(l);
      
      JButton btnCheese = new JButton("치즈류");
      btnCheese.setBounds(6, 53, 97, 23);
      p_SnackList.add(btnCheese);
      
      btnCheese.addActionListener(l);
      
      JButton btnBest = new JButton("일품요리류");
      btnBest.setBounds(6, 81, 97, 23);
      p_SnackList.add(btnBest);
      
      btnBest.addActionListener(l);
      
      JButton btnRoasting = new JButton("볶음류");
      btnRoasting.setBounds(6, 109, 97, 23);
      p_SnackList.add(btnRoasting);
      
      btnRoasting.addActionListener(l);
      
      JButton btnSoup = new JButton("탕류");
      btnSoup.setBounds(6, 137, 97, 23);
      p_SnackList.add(btnSoup);
      
      btnSoup.addActionListener(l);
      
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
      
      btnDrink.addActionListener(l);
      
      JButton btnSelfMenu = new JButton("셀프메뉴");
      btnSelfMenu.setBounds(5, 53, 97, 23);
      p_DrinknMealList.add(btnSelfMenu);
      
      btnSelfMenu.addActionListener(l);
      
      JButton btnSubMenu = new JButton("서브메뉴");
      btnSubMenu.setBounds(5, 81, 97, 23);
      p_DrinknMealList.add(btnSubMenu);
      
      btnSubMenu.addActionListener(l);
      
      JButton btnAddSari = new JButton("추가사리");
      btnAddSari.setBounds(5, 109, 97, 23);
      p_DrinknMealList.add(btnAddSari);
      
      btnAddSari.addActionListener(l);
      
      JPanel p_inAlcohol = new JPanel();
      FlowLayout flowLayout = (FlowLayout) p_inAlcohol.getLayout();
//      p_CardLayout.add(p_inAlcohol, "name_20923529610151");
      p_CardLayout.add("inAlcoholPanel",p_inAlcohol);
      
      JButton btnBrotherSoju = new JButton("부라더소주");
      btnBrotherSoju.setPreferredSize(new Dimension(105, 50));
      p_inAlcohol.add(btnBrotherSoju);
      
      btnBrotherSoju.addActionListener(l);
      
      JButton btnSunhariApp = new JButton("순하리(사과)");
      btnSunhariApp.setPreferredSize(new Dimension(105, 50));
      p_inAlcohol.add(btnSunhariApp);
      
      btnSunhariApp.addActionListener(l);
      
      JButton btnCharmSoju = new JButton("참이슬");
      btnCharmSoju.setPreferredSize(new Dimension(105, 50));
      p_inAlcohol.add(btnCharmSoju);
      
      btnCharmSoju.addActionListener(l);
      
      JButton btnAsFirst = new JButton("처음처럼");
      btnAsFirst.setPreferredSize(new Dimension(105, 50));
      p_inAlcohol.add(btnAsFirst);
      
      btnAsFirst.addActionListener(l);
      
      JButton btmCharmJamong = new JButton("참이슬(자몽)");
      btmCharmJamong.setPreferredSize(new Dimension(105, 50));
      p_inAlcohol.add(btmCharmJamong);
      
      btmCharmJamong.addActionListener(l);
      
      JButton btnSunhariBok = new JButton("순하리(복분자)");
      btnSunhariBok.setPreferredSize(new Dimension(105, 50));
      p_inAlcohol.add(btnSunhariBok);
      
      btnSunhariBok.addActionListener(l);
      
      JPanel p_inLiveBeer = new JPanel();
//      p_CardLayout.add(p_inLiveBeer, "name_11613215203093");
      p_CardLayout.add("inLiveBeerPanel",p_inLiveBeer);
      
      JButton btnEngAle = new JButton("잉글리쉬에일");
      btnEngAle.setPreferredSize(new Dimension(105, 50));
      p_inLiveBeer.add(btnEngAle);
      
      btnEngAle.addActionListener(l);
      
      JButton btnLeffeBlonde = new JButton("레페블론드");
      btnLeffeBlonde.setPreferredSize(new Dimension(105, 50));
      p_inLiveBeer.add(btnLeffeBlonde);
      
      btnLeffeBlonde.addActionListener(l);
      
      JButton btnGoldenAle = new JButton("골든에일");
      btnGoldenAle.setPreferredSize(new Dimension(105, 50));
      p_inLiveBeer.add(btnGoldenAle);
      
      btnGoldenAle.addActionListener(l);
      
      JButton btnGuinness = new JButton("기네스");
      btnGuinness.setPreferredSize(new Dimension(105, 50));
      p_inLiveBeer.add(btnGuinness);
      
      btnGuinness.addActionListener(l);
      
      JButton btnCarlsberg = new JButton("칼스버그");
      btnCarlsberg.setPreferredSize(new Dimension(105, 50));
      p_inLiveBeer.add(btnCarlsberg);
      
      btnCarlsberg.addActionListener(l);
      
      JButton btnBaltika = new JButton("발티카");
      btnBaltika.setPreferredSize(new Dimension(105, 50));
      p_inLiveBeer.add(btnBaltika);
      
      btnBaltika.addActionListener(l);
      
      JPanel p_inBottleBeer = new JPanel();
//      p_CardLayout.add(p_inBottleBeer, "name_11755485299816");
      p_CardLayout.add("inBottleBeerPanel",p_inBottleBeer);
      
      JButton btnHite = new JButton("하이트");
      btnHite.setPreferredSize(new Dimension(105, 50));
      p_inBottleBeer.add(btnHite);
      
      btnHite.addActionListener(l);
      
      JButton btnCorona = new JButton("코로나");
      btnCorona.setPreferredSize(new Dimension(105, 50));
      p_inBottleBeer.add(btnCorona);
      
      btnCorona.addActionListener(l);
      
      JButton btnHeineken = new JButton("하이네켄");
      btnHeineken.setPreferredSize(new Dimension(105, 50));
      p_inBottleBeer.add(btnHeineken);
      
      btnHeineken.addActionListener(l);
      
      JButton btn1644Blanc = new JButton("1664블랑");
      btn1644Blanc.setPreferredSize(new Dimension(105, 50));
      p_inBottleBeer.add(btn1644Blanc);
      
      btn1644Blanc.addActionListener(l);
      
      JButton btnBottleGuinness = new JButton("제주에일");
      btnBottleGuinness.setPreferredSize(new Dimension(105, 50));
      p_inBottleBeer.add(btnBottleGuinness);
      
      btnBottleGuinness.addActionListener(l);
      
      JButton btnHoegaarden = new JButton("호가든");
      btnHoegaarden.setPreferredSize(new Dimension(105, 50));
      p_inBottleBeer.add(btnHoegaarden);
      
      btnHoegaarden.addActionListener(l);
      
      JPanel p_inFruitAlcohol = new JPanel();
//      p_CardLayout.add(p_inFruitAlcohol, "name_11780263085942");
      p_CardLayout.add("inFruitAlcoholPanel",p_inFruitAlcohol);
      p_inFruitAlcohol.setLayout(null);
      
      JButton btnStrawberryJU = new JButton("생딸기주");
      btnStrawberryJU.setBounds(4, 5, 105, 50);
      btnStrawberryJU.setPreferredSize(new Dimension(105, 50));
      p_inFruitAlcohol.add(btnStrawberryJU);
      
      btnStrawberryJU.addActionListener(l);
      
      JButton btnKiwiJU = new JButton("생키위주");
      btnKiwiJU.setBounds(114, 5, 105, 50);
      btnKiwiJU.setPreferredSize(new Dimension(105, 50));
      p_inFruitAlcohol.add(btnKiwiJU);
      
      btnKiwiJU.addActionListener(l);
      
      JButton btnPineappleJU = new JButton("생파인애플주");
      btnPineappleJU.setBounds(224, 5, 105, 50);
      btnPineappleJU.setPreferredSize(new Dimension(105, 50));
      p_inFruitAlcohol.add(btnPineappleJU);
      
      btnPineappleJU.addActionListener(l);
      
      JButton btnAppleJU = new JButton("생사과주");
      btnAppleJU.setBounds(4, 60, 105, 50);
      btnAppleJU.setPreferredSize(new Dimension(105, 50));
      p_inFruitAlcohol.add(btnAppleJU);
      
      btnAppleJU.addActionListener(l);
      
      JButton btnOrangeJU = new JButton("생오렌지주");
      btnOrangeJU.setBounds(114, 60, 105, 50);
      btnOrangeJU.setPreferredSize(new Dimension(105, 50));
      p_inFruitAlcohol.add(btnOrangeJU);
      
      btnOrangeJU.addActionListener(l);
      
      JPanel p_inSalad = new JPanel();
//      p_CardLayout.add(p_inSnack, "name_20920245608460");
      p_CardLayout.add("inSaladPanel",p_inSalad);
      
      JButton btnPongdue = new JButton("과일퐁듀");
      btnPongdue.setPreferredSize(new Dimension(105, 50));
      p_inSalad.add(btnPongdue);
      
      btnPongdue.addActionListener(l);
      
      JButton btnLAMochi = new JButton("LA떡다져쓰");
      btnLAMochi.setPreferredSize(new Dimension(105, 50));
      p_inSalad.add(btnLAMochi);
      
      btnLAMochi.addActionListener(l);
      
      JButton btnRawmeat = new JButton("살아있네살아있어");
      btnRawmeat.setPreferredSize(new Dimension(105, 50));
      p_inSalad.add(btnRawmeat);
      
      btnRawmeat.addActionListener(l);
      
      JButton btnChickenSalad = new JButton("콩닭콩닭");
      btnChickenSalad.setPreferredSize(new Dimension(105, 50));
      p_inSalad.add(btnChickenSalad);
      
      btnChickenSalad.addActionListener(l);
      
      JButton btnPhotoTime = new JButton("포토타임");
      btnPhotoTime.setPreferredSize(new Dimension(105, 50));
      p_inSalad.add(btnPhotoTime);
      
      btnPhotoTime.addActionListener(l);
      
      JButton btnNurungji = new JButton("누룽지샐러드");
      btnNurungji.setPreferredSize(new Dimension(105, 50));
      p_inSalad.add(btnNurungji);
      
      btnNurungji.addActionListener(l);
      
      JPanel p_inCheese = new JPanel();
//      p_CardLayout.add(p_inCheese, "name_13441570385332");
      p_CardLayout.add("inCheesePanel",p_inCheese);
      p_inCheese.setLayout(null);
      
      JButton btnVeryBulDak = new JButton("베리베리러블리불닭");
      btnVeryBulDak.setBounds(4, 5, 105, 50);
      btnVeryBulDak.setPreferredSize(new Dimension(105, 50));
      p_inCheese.add(btnVeryBulDak);
      
      btnVeryBulDak.addActionListener(l);
      
      JButton btnBulgogiPizza = new JButton("불고기피자");
      btnBulgogiPizza.setBounds(114, 5, 105, 50);
      btnBulgogiPizza.setPreferredSize(new Dimension(105, 50));
      p_inCheese.add(btnBulgogiPizza);
      
      btnBulgogiPizza.addActionListener(l);
      
      JButton btnGampiTang = new JButton("김피탕");
      btnGampiTang.setBounds(224, 5, 105, 50);
      btnGampiTang.setPreferredSize(new Dimension(105, 50));
      p_inCheese.add(btnGampiTang);
      
      btnGampiTang.addActionListener(l);
      
      JButton btnCheeseGangjung = new JButton("치즈닭강정");
      btnCheeseGangjung.setBounds(4, 60, 105, 50);
      btnCheeseGangjung.setPreferredSize(new Dimension(105, 50));
      p_inCheese.add(btnCheeseGangjung);
      
      btnCheeseGangjung.addActionListener(l);
      
      JButton btnCrmCheeseChicken = new JButton("크림치즈러브미치킨");
      btnCrmCheeseChicken.setBounds(114, 60, 105, 50);
      btnCrmCheeseChicken.setPreferredSize(new Dimension(105, 50));
      p_inCheese.add(btnCrmCheeseChicken);
      
      btnCrmCheeseChicken.addActionListener(l);
      
      JPanel p_inBest = new JPanel();
//      p_CardLayout.add(p_inBest, "name_13466408203397");
      p_CardLayout.add("inBestPanel",p_inBest);
      
      JButton btnHotChicken = new JButton("매운꺄르르치킨");
      btnHotChicken.setPreferredSize(new Dimension(105, 50));
      p_inBest.add(btnHotChicken);
      
      btnHotChicken.addActionListener(l);
      
      JButton btnCrmHotChicken = new JButton("크림속매운닭강정");
      btnCrmHotChicken.setPreferredSize(new Dimension(105, 50));
      p_inBest.add(btnCrmHotChicken);
      
      btnCrmHotChicken.addActionListener(l);
      
      JButton btnPaDak = new JButton("푸다닭파다닭");
      btnPaDak.setPreferredSize(new Dimension(105, 50));
      p_inBest.add(btnPaDak);
      
      btnPaDak.addActionListener(l);
      
      JButton btnBigChicken = new JButton("통큰통닭");
      btnBigChicken.setPreferredSize(new Dimension(105, 50));
      p_inBest.add(btnBigChicken);
      
      btnBigChicken.addActionListener(l);
      
      JButton btnXOMochi = new JButton("XO떡볶이");
      btnXOMochi.setPreferredSize(new Dimension(105, 50));
      p_inBest.add(btnXOMochi);
      
      btnXOMochi.addActionListener(l);
      
      JButton btnLol = new JButton("L.O.L");
      btnLol.setPreferredSize(new Dimension(105, 50));
      p_inBest.add(btnLol);
      
      btnLol.addActionListener(l);
      
      JPanel p_inRoasting = new JPanel();
      p_CardLayout.add(p_inRoasting, "name_13487163303938");
      p_CardLayout.add("inRoastingPanel",p_inRoasting);
      
      JButton btnHerbRoasting = new JButton("차도녀숙주볶음");
      btnHerbRoasting.setPreferredSize(new Dimension(105, 50));
      p_inRoasting.add(btnHerbRoasting);
      
      btnHerbRoasting.addActionListener(l);
      
      JButton btnyoyo = new JButton("오돌마yo시켜yo");
      btnyoyo.setPreferredSize(new Dimension(105, 50));
      p_inRoasting.add(btnyoyo);
      
      btnyoyo.addActionListener(l);
      
      JButton btnSandHouseRoasting = new JButton("모래집볶음");
      btnSandHouseRoasting.setPreferredSize(new Dimension(105, 50));
      p_inRoasting.add(btnSandHouseRoasting);
      
      btnSandHouseRoasting.addActionListener(l);
      
      JButton btnHanoisMorning = new JButton("하노이의아침");
      btnHanoisMorning.setPreferredSize(new Dimension(105, 50));
      p_inRoasting.add(btnHanoisMorning);
      
      btnHanoisMorning.addActionListener(l);
      
      JButton btnAnsim = new JButton("안심하드라고");
      btnAnsim.setPreferredSize(new Dimension(105, 50));
      p_inRoasting.add(btnAnsim);
      
      btnAnsim.addActionListener(l);
      
      JButton btnKing = new JButton("힘센삼겹");
      btnKing.setPreferredSize(new Dimension(105, 50));
      p_inRoasting.add(btnKing);
      
      btnKing.addActionListener(l);
      
      JPanel p_inSoup = new JPanel();
//      p_CardLayout.add(p_inSoup, "name_13493518496030");
      p_CardLayout.add("inSoupPanel", p_inSoup);
      
      JButton btnNurungjiTang = new JButton("누룽지탕");
      btnNurungjiTang.setPreferredSize(new Dimension(105, 50));
      p_inSoup.add(btnNurungjiTang);
      
      btnNurungjiTang.addActionListener(l);
      
      JButton btnBuDae = new JButton("부대찌개");
      btnBuDae.setPreferredSize(new Dimension(105, 50));
      p_inSoup.add(btnBuDae);
      
      btnBuDae.addActionListener(l);
      
      JButton btnJJangAJJi = new JButton("고추장찌개");
      btnJJangAJJi.setPreferredSize(new Dimension(105, 50));
      p_inSoup.add(btnJJangAJJi);
      
      btnJJangAJJi.addActionListener(l);
      
      JButton btnUA = new JButton("우아한갈비찜");
      btnUA.setPreferredSize(new Dimension(105, 50));
      p_inSoup.add(btnUA);
      
      btnUA.addActionListener(l);
      
      JButton btnOdeng = new JButton("오뎅탕");
      btnOdeng.setPreferredSize(new Dimension(105, 50));
      p_inSoup.add(btnOdeng);
      
      btnOdeng.addActionListener(l);
      
      JButton btnJJamBBong = new JButton("짬뽕");
      btnJJamBBong.setPreferredSize(new Dimension(105, 50));
      p_inSoup.add(btnJJamBBong);
      
      btnJJamBBong.addActionListener(l);
      
      JPanel p_inDrink = new JPanel();
//      p_CardLayout.add(p_inDrinknMeal, "name_20167251879038");
      p_CardLayout.add("inDrinkPanel", p_inDrink);
      
      JButton btnCola = new JButton("콜라");
      btnCola.setPreferredSize(new Dimension(105, 50));
      p_inDrink.add(btnCola);
      
      btnCola.addActionListener(l);
      
      JButton btnCider = new JButton("사이다");
      btnCider.setPreferredSize(new Dimension(105, 50));
      p_inDrink.add(btnCider);

      btnCider.addActionListener(l);
      
      JButton btnOrangJuice = new JButton("오렌지주스");
      btnOrangJuice.setPreferredSize(new Dimension(105, 50));
      p_inDrink.add(btnOrangJuice);
      
      btnOrangJuice.addActionListener(l);
      
      JButton btnRedBull = new JButton("레드불");
      btnRedBull.setPreferredSize(new Dimension(105, 50));
      p_inDrink.add(btnRedBull);
      
      btnRedBull.addActionListener(l);
      
      JButton btnTonicWater = new JButton("토닉워터");
      btnTonicWater.setPreferredSize(new Dimension(105, 50));
      p_inDrink.add(btnTonicWater);
      
      btnTonicWater.addActionListener(l);
      
      JButton btnCoolPeace = new JButton("쿨피스");
      btnCoolPeace.setPreferredSize(new Dimension(105, 50));
      p_inDrink.add(btnCoolPeace);
      
      btnCoolPeace.addActionListener(l);
      
      JPanel p_inSelfMenu = new JPanel();
//      p_CardLayout.add(p_inSelfMenu, "name_13594833627279");
      p_CardLayout.add("inSelfMenuPanel",p_inSelfMenu);
      p_inSelfMenu.setLayout(null);
      
      JButton btnCondition = new JButton("컨디션");
      btnCondition.setBounds(4, 5, 105, 50);
      btnCondition.setPreferredSize(new Dimension(105, 50));
      p_inSelfMenu.add(btnCondition);
      
      btnCondition.addActionListener(l);
      
      JButton btnOxiWater = new JButton("에스프레소");
      btnOxiWater.setBounds(114, 5, 105, 50);
      btnOxiWater.setPreferredSize(new Dimension(105, 50));
      p_inSelfMenu.add(btnOxiWater);
      
      btnOxiWater.addActionListener(l);
      
      JButton btnAmericano = new JButton("아메리카노");
      btnAmericano.setBounds(224, 5, 105, 50);
      btnAmericano.setPreferredSize(new Dimension(105, 50));
      p_inSelfMenu.add(btnAmericano);
      
      btnAmericano.addActionListener(l);
      
      JButton btnCafelatte = new JButton("카페라떼");
      btnCafelatte.setBounds(4, 60, 105, 50);
      btnCafelatte.setPreferredSize(new Dimension(105, 50));
      p_inSelfMenu.add(btnCafelatte);
      
      btnCafelatte.addActionListener(l);
      
      JButton btnSoftIce = new JButton("소프트아이스크림");
      btnSoftIce.setBounds(114, 60, 105, 50);
      btnSoftIce.setPreferredSize(new Dimension(105, 50));
      p_inSelfMenu.add(btnSoftIce);
      
      btnSoftIce.addActionListener(l);
      
      JPanel p_inSubMenu = new JPanel();
//      p_CardLayout.add(p_inSubMenu, "name_13614852838879");
      p_CardLayout.add("inSubMenuPanel",p_inSubMenu);
      p_inSubMenu.setLayout(null);
      
      JButton btnRamen = new JButton("다줄게라면");
      btnRamen.setBounds(4, 5, 105, 50);
      btnRamen.setPreferredSize(new Dimension(105, 50));
      p_inSubMenu.add(btnRamen);
      
      btnRamen.addActionListener(l);
      
      JButton btnJJapa = new JButton("속타는짜파게티");
      btnJJapa.setBounds(114, 5, 105, 50);
      btnJJapa.setPreferredSize(new Dimension(105, 50));
      p_inSubMenu.add(btnJJapa);
      
      btnJJapa.addActionListener(l);
      
      JButton btnLunchBox = new JButton("유혹의도시락");
      btnLunchBox.setBounds(224, 5, 105, 50);
      btnLunchBox.setPreferredSize(new Dimension(105, 50));
      p_inSubMenu.add(btnLunchBox);
      
      btnLunchBox.addActionListener(l);
      
      JButton btnMayo = new JButton("마요주먹밥");
      btnMayo.setBounds(4, 60, 105, 50);
      btnMayo.setPreferredSize(new Dimension(105, 50));
      p_inSubMenu.add(btnMayo);
      
      btnMayo.addActionListener(l);
      
      JButton btnCKR = new JButton("치즈김치볶음밥");
      btnCKR.setBounds(114, 60, 105, 50);
      btnCKR.setPreferredSize(new Dimension(105, 50));
      p_inSubMenu.add(btnCKR);
      
      btnCKR.addActionListener(l);
      
      JPanel p_inAddSari = new JPanel();
//      p_CardLayout.add(p_inAddSari, "name_13629004426024");
      p_CardLayout.add("inAddSariPanel", p_inAddSari);
      
      JButton btnRemenSari = new JButton("라면사리");
      btnRemenSari.setPreferredSize(new Dimension(105, 50));
      p_inAddSari.add(btnRemenSari);
      
      btnRemenSari.addActionListener(l);
      
      JButton btnUdongSari = new JButton("우동사리");
      btnUdongSari.setPreferredSize(new Dimension(105, 50));
      p_inAddSari.add(btnUdongSari);
      
      btnUdongSari.addActionListener(l);
      
      JButton btnJJolMen = new JButton("쫄면사리");
      btnJJolMen.setPreferredSize(new Dimension(105, 50));
      p_inAddSari.add(btnJJolMen);
      
      btnJJolMen.addActionListener(l);
      
      JPanel p_Num = new JPanel();
      p_Num.setLayout(null);
      p_Num.setPreferredSize(new Dimension(300, 35));
      p_Num.setBounds(2, 230, 332, 35);
      contentPane.add(p_Num);
      
      JLabel lbldisplayOrderNum = new JLabel("\uC218\uB7C9 :");
      lbldisplayOrderNum.setBounds(12, 10, 32, 15);
      p_Num.add(lbldisplayOrderNum);
      
      lblOrderNum = new JLabel("n");
      lblOrderNum.setBounds(49, 10, 7, 15);
      p_Num.add(lblOrderNum);
      
      JButton btnPlus = new JButton("+");
      btnPlus.setPreferredSize(new Dimension(40, 23));
      btnPlus.setBounds(120, 6, 40, 23);
      p_Num.add(btnPlus);
      
      JButton btnMinus = new JButton("-");
      btnMinus.setPreferredSize(new Dimension(40, 23));
      btnMinus.setBounds(176, 6, 40, 23);
      p_Num.add(btnMinus);
      
      JPanel p_Payment = new JPanel();
      p_Payment.setBounds(334, 10, 130, 300);
      p_Payment.setPreferredSize(new Dimension(130, 300));
      contentPane.add(p_Payment);
      
      JLabel lblOrderCart = new JLabel("주문계산서");
      p_Payment.add(lblOrderCart);
      
      ta_totBill = new JTextArea();
      ta_totBill.setRows(10);
      ta_totBill.setColumns(16);
      p_Payment.add(ta_totBill);
      
      JTextArea ta_totCost = new JTextArea();
      ta_totCost.setColumns(16);
      p_Payment.add(ta_totCost);
      
      JButton btnOrder = new JButton("\uC8FC\uBB38");
      btnOrder.setPreferredSize(new Dimension(60, 23));
      p_Payment.add(btnOrder);
      
      JButton btnOrderCancel = new JButton("\uC0AD\uC81C");
      btnOrderCancel.setPreferredSize(new Dimension(60, 23));
      p_Payment.add(btnOrderCancel);
      
      JPanel p_OrderCart = new JPanel();
      p_OrderCart.setBounds(2, 268, 332, 42);
      contentPane.add(p_OrderCart);
      p_OrderCart.setLayout(null);
      
      JButton btnBackPanel = new JButton("<");
      btnBackPanel.setBounds(12, 5, 57, 23);
      p_OrderCart.add(btnBackPanel);
      
      JButton btnInputTextArea = new JButton("주문담기");
      btnInputTextArea.setBounds(115, 5, 105, 23);
      p_OrderCart.add(btnInputTextArea);
      
      JButton btnFrontPanel = new JButton(">");
      btnFrontPanel.setBounds(263, 5, 57, 23);
      p_OrderCart.add(btnFrontPanel);
      
      setVisible(true);
      
      btnInputTextArea.addActionListener(l);
      
   }
   
   public void changePanel(String sChangePanel) 
   {
      if(sChangePanel.equals("OrderListPanel"))
      {
         orderlist_flag = true;
         cards.show(p_CardLayout, "OrderListPanel");
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
               changePanel("OrderListPanel");
            }
            break;
            // Card Panel
         case "술":
            changePanel("inAlcoholPanel");
            break;
         case "안주":
            changePanel("inSaladPanel");
            break;
         case "음료/식사":
            changePanel("inDrinknPanel");
            break;
         case "소주/전통주":
             changePanel("inAlcoholPanel");
             break; 
         case "생맥주":
             changePanel("inLiveBeerPanel");
             break; 
         case "병맥주":
             changePanel("inBottleBeerPanel");
             break; 
         case "생과일주":
             changePanel("inFruitAlcoholPanel");
             break; 
         case "샐러드":
             changePanel("inSaladPanel");
             break; 
         case "치즈류":
             changePanel("inCheesePanel");
             break; 
         case "일품요리류":
             changePanel("inBestPanel");
             break; 
         case "볶음류":
             changePanel("inRoastingPanel");
             break; 
         case "탕류":
             changePanel("inSoupPanel");
             break; 
         case "음료":
             changePanel("inDrinkPanel");
             break; 
         case "셀프메뉴":
             changePanel("inSelfMenuPanel");
             break; 
         case "서브메뉴":
             changePanel("inSubMenuPanel");
             break; 
         case "추가사리":
             changePanel("inAddSariPanel");
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
        	 s_ChangeNum++;
        	 pi = s_ChangeNum + ""; 
        	 lblOrderNum.setText(pi);
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
        	 s_ChangeNum++;
        	 pi = s_ChangeNum + ""; 
        	 lblOrderNum.setText(pi);
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
        	 s_ChangeNum++;
        	 pi = s_ChangeNum + ""; 
        	 lblOrderNum.setText(pi);
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
//        	 s_ChangeNum=0;
//        	order++;
//        	String c_date = "DEFAULT";
//        	int tno = (int)(Math.random()*24)+1;
//        	System.out.println(tno);
//        	
//			String name = tfName.getText();
//			String dept = tfDept.getText();
//			//DB, ta �߰����¸޼���
//			StudentInfo s = new StudentInfo(sno, name, dept);
//			
//			db.insert(s);
        	 
//        	Product prod = new Product();
        	 
			ArrayList<Product> list = db.select();
//			ta.setText("");
			for( int i = 0 ; i < list.size() ; i++ )
			{
				ta_totBill.append(list.get(i).toString()+"\n");
			}
        	 
        	break;
         }
      }
      
   }
}