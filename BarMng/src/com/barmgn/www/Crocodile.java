package com.barmgn.www;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class Crocodile extends JFrame {
   private JPanel contentPane;
   JButton[] btn = new JButton[9]; // 9 teeths
   JLabel la;
   JLabel lblresult;
   int ran = (int)(Math.random()*9);
   GameMenuFrame gamemenuFrame;
   
   int row = 0;
   

   
   /**
    * Launch the application.
    */
   public static void main(String[] args) {
      EventQueue.invokeLater(new Runnable() {
         public void run() {
            try {
//               Crocodile frame = new Crocodile();
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
   public Crocodile(GameMenuFrame gamemenuFrame) {
	   this.gamemenuFrame = gamemenuFrame;
      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
      setBounds(100, 100, 800, 600);

      contentPane = new JPanel();
      contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
      contentPane.setLayout(new BorderLayout());
      setContentPane(contentPane);
      
      ImageIcon icon=new ImageIcon("images/Crocodile.png");
      la =new JLabel(icon);
      la.setBounds(150,-10,470,564); //절대레이아웃(null) : 계단처럼 
   
      //Call Background image
      BufferedImage myImage = null;
      try {
         myImage = ImageIO.read(new File("images/deck2.jpg"));
      } catch (IOException e1) {
         e1.printStackTrace();
      }
      
      // Button teeth location
      for (int i = 0; i < btn.length; i++) {
      if (i < 5) {
         System.out.println("d");
         btn[i] = new JButton();
         btn[i].setBounds(160 + i * 50, 290 + i * 40, 30, 50);
         add(btn[i]);
      } else {
         btn[i] = new JButton();
         row += 2;
         btn[i].setLocation(160 + i * 50, 290 + (i - row) * 40);
         btn[i].setSize(30, 50);
         add(btn[i]);
      }
         // when click buttons
         btn[i].addActionListener(new MyActionListener());
      }
      
   
      ImagePanel pn = new ImagePanel(myImage);   
      contentPane.add(pn);
      pn.add(la);
      //ButtonPanel pb = new ButtonPanel();
      //contentPane.add(pb);
      setVisible(true);
   }
   
   
   class MyActionListener implements ActionListener {

	      @Override
	      public void actionPerformed(ActionEvent e) {
	         JButton b = (JButton) e.getSource();
	         
	         for (int i = 0; i < btn.length; i++) {
	            if (b == btn[i]) {
	               if(i==ran) {
	                  lblresult.setText("Game Over");
	                  ran=(int)(Math.random()*9);
	               }else {
	                  lblresult.setText("You are Lucky");
	               }
	     }
	    }
	 }
   }

class ImagePanel extends JComponent {
   // Show Background image
   private Image deck;

   public ImagePanel(Image deck) {
      this.deck = deck;
      this.setLayout(null);
   }
   protected void paintComponent(Graphics g) {
      super.paintComponents(g); 
      g.drawImage(deck, 0, 0, this); // toy location
   }
}

}


//package com.barmgn.www;
//
//import java.awt.BorderLayout;
//import java.awt.EventQueue;
//import java.awt.Graphics;
//import java.awt.Image;
//import java.awt.event.ActionEvent;
//import java.awt.event.ActionListener;
//import java.awt.image.BufferedImage;
//import java.io.File;
//import java.io.IOException;
//
//import javax.imageio.ImageIO;
//import javax.swing.ImageIcon;
//import javax.swing.JButton;
//import javax.swing.JComponent;
//import javax.swing.JFrame;
//import javax.swing.JLabel;
//import javax.swing.JPanel;
//import javax.swing.border.EmptyBorder;
//
//public class Crocodile extends JFrame {
//   private JPanel contentPane;
//   JButton[] btn = new JButton[9]; // 9 teeths
//   JLabel la;
//   JLabel lblresult;
//   int ran = (int)(Math.random()*9);
//   GameMenuFrame gamemenuFrame;
//   int row = 0;
//  
//   /**
//    * Launch the application.
//    */
//   public static void main(String[] args) {
//      EventQueue.invokeLater(new Runnable() {
//         public void run() {
//            try {
////               Crocodile frame = new Crocodile();
////               frame.setVisible(true);
//            } catch (Exception e) {
//               e.printStackTrace();
//            }
//         }
//      });
//   }
//   
//   /**
//    * Create the frame.
//    */
//   public Crocodile(GameMenuFrame gamemenuFrame) {
//	   this.gamemenuFrame = gamemenuFrame;
//      setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//      setBounds(100, 100, 800, 600);
//
//      contentPane = new JPanel();
//      contentPane.setBorder(new EmptyBorder(0, 0, 0, 0));
//      contentPane.setLayout(new BorderLayout());
//      setContentPane(contentPane);
//      
//      ImageIcon icon=new ImageIcon("images/Crocodile.png");
//      la =new JLabel(icon);
//      la.setBounds(150,-10,470,564); //절대레이아웃(null) : 계단처럼 
//   
//      //Call Background image
//      BufferedImage myImage = null;
//      try {
//         myImage = ImageIO.read(new File("images/deck2.jpg"));
//         System.out.println(myImage);
//      } catch (IOException e1) {
//         e1.printStackTrace();
//      }
//
//      // Button teeth location
//      for (int i = 0; i < btn.length; i++) {
//      if (i < 5) {
//         // 0, 1, 2, 3, 5, 6, 7, 8
//         if(i==4) {  //center teeth
//            continue;
//         }
//         btn[i] = new JButton();
//         btn[i].setBounds(210 + i * 40, 300 + i * 50, 25, 30);
//         getContentPane().add(btn[i]);
//      } else {
//         btn[i] = new JButton();
//         row += 2;
//         btn[i].setLocation(210 + i * 40, 300 + (i - row) * 50);
//         btn[i].setSize(25, 30);
//         getContentPane().add(btn[i]);
//         
//      }
//         // when click buttons
//         btn[i].addActionListener(new MyActionListener());
//      }
//      
//   
//      ImagePanel pn = new ImagePanel(myImage);   
//      contentPane.add(pn);
//      contentPane.setLayout(new BorderLayout(0, 0));
//      pn.add(la);
//      //ButtonPanel pb = new ButtonPanel();
//      //contentPane.add(pb);
//      
//      setVisible(true);
//   }
//   
//   class MyActionListener implements ActionListener {
//
//      @Override
//      public void actionPerformed(ActionEvent e) {
//         JButton b = (JButton) e.getSource();
//         
//         System.out.println(b);
//         
//         for (int i = 0; i < btn.length; i++) {
//            if (b == btn[i]) {
//            	System.out.println(ran);
//               if(i==ran) {
//                  lblresult.setText("Game Over");
////                  ran=(int)(Math.random()*9);
//               }else {
//                  lblresult.setText("You are Lucky");
//               }
//            }
//         }
//      }
//   }
//
//class ImagePanel extends JComponent {
//   // Show Background image
//   private Image deck;
//
//   public ImagePanel(Image deck) {
//      this.deck = deck;
//      this.setLayout(null);
//   }
//   protected void paintComponent(Graphics g) {
//      super.paintComponents(g); 
//      g.drawImage(deck, 0, 0, this); // toy location
//   }
//}
//}