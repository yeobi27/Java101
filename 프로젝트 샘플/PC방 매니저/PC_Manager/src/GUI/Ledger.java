package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.util.ArrayList;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.OrdersDAO;
import DAO.PC_In_UseDAO;
import DTO.Orders;
import DTO.Orders_View;
import DTO.PC_In_Use;
import DTO.PC_Used_View;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.awt.FlowLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Ledger extends JFrame {

	private JPanel contentPane;
	String[] od = { "거래 번호", "id", "상품명", "품목", "수량", "가격", "거래 날짜" };
	JTable table, table1;
	ArrayList<Orders_View> orderList;
	ArrayList<PC_Used_View> pList;
	ArrayList<Integer> calArr;
	Calendar cal;
	String[] use = { "거래 번호", "id", "PC 번호", "지불 방법", "시작 시간", "사용 시간", "거래 날짜", "금액" };
	private JPanel p4;
	int month, date, lastDay;
	int year;
	private JPanel panel_1;
	private JPanel panel_2;
	private JButton btnYear;
	private JLabel lblMonth;
	private JButton btnNext;
	private JPanel panel_3;
	private JPanel panel_4;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblNewLabel_3;
	private JLabel lblNewLabel_4;
	private JLabel lblNewLabel_5;
	private JLabel lblNewLabel_6;
	JButton[] tempBtn;
	private JButton btnSelectYear;
	private JButton btnSelectMonth;
	private JPanel panel;
	JLabel lblTotalP, lblTotalO, lblTotal;
	int tp, to, t;

	/**
	 * Launch the application.
	 */
	public void setCal(int year, int month) {
		cal = Calendar.getInstance();
		this.year = year;
		this.month = month;
		// year=cal.get(Calendar.YEAR);
		cal.set(Calendar.YEAR, year);
		cal.set(Calendar.MONTH, month);
		month = cal.get(Calendar.MONTH);
		date = cal.get(Calendar.DATE);
		lastDay = cal.getActualMaximum(Calendar.DATE);
		calArr = new ArrayList<Integer>();
		for (int i = 0; i < lastDay; i++) {
			calArr.add(i + 1);
		}
		cal.set(Calendar.DATE, 1);
		int day = cal.get(Calendar.DAY_OF_WEEK);
		int numOfPreMonth = day - 1;
		cal.add(Calendar.MONTH, -1);
		lastDay = cal.getActualMaximum(Calendar.DATE);
		for (int i = 0; i < numOfPreMonth; i++) {
			calArr.add(0, 0);
			lastDay--;
		}
		cal.add(Calendar.MONTH, 1);
		lastDay = cal.getActualMaximum(Calendar.DATE);
		cal.set(Calendar.DATE, lastDay);
		day = cal.get(Calendar.DAY_OF_WEEK);

		int numOfNextMonth = 7 - day;
		for (int i = 0; i < 14; i++) {
			calArr.add(0);
		}
		/*
		 * for(int i=0; i<calArr.size();i++) { System.out.print(calArr.get(i)+", ");
		 * if(i%7==6) { System.out.println(); } }
		 */
		for (int i = 0; i < 42; i++) {
			// myFrame.add(new Button(calArr.get(i)+""));

			tempBtn[i].setText(calArr.get(i) + "");
			if (i % 7 == 0) {
				tempBtn[i].setForeground(Color.RED);
			} else if (i % 7 == 6) {
				tempBtn[i].setForeground(Color.BLUE);
			}
			if (calArr.get(i) == 0) {
				tempBtn[i].setText("");
				tempBtn[i].setEnabled(false);
			} else {
				tempBtn[i].setEnabled(true);

			}

		}
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Ledger frame = new Ledger();
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

	public Ledger() {
		cal = Calendar.getInstance();
		year = cal.get(Calendar.YEAR);
		month = cal.get(Calendar.MONTH);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1365, 781);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		OrdersDAO ordersDao = OrdersDAO.getInstance();
		orderList = ordersDao.selectAll();

		Object[] obj = new Object[7];
		DefaultTableModel model = new DefaultTableModel(od, 0);
		to = 0;
		for (int i = 0; i < orderList.size(); i++) {
			Orders_View orders = orderList.get(i);
			obj[0] = orders.getNo();
			obj[1] = orders.getId();
			obj[2] = orders.getName();
			obj[3] = orders.getType();
			obj[4] = orders.getQuantity();
			obj[5] = orders.getPrice();
			obj[6] = orders.getS_date();
			model.addRow(obj);
			to += Integer.parseInt(obj[5].toString());
		}
		tempBtn = new JButton[42];
		PC_In_UseDAO pc_in_useDao = PC_In_UseDAO.getInstance();
		pList = pc_in_useDao.selectAll2();
		Object[] obj1 = new Object[8];
		DefaultTableModel model1 = new DefaultTableModel(use, 0);
		tp = 0;
		for (int i = 0; i < pList.size(); i++) {
			PC_Used_View piu = pList.get(i);
			obj1[0] = piu.getNo();
			obj1[1] = piu.getId();
			obj1[2] = piu.getC_no();
			obj1[3] = piu.getType();
			obj1[4] = piu.getS_time();
			obj1[5] = piu.getP_time();
			obj1[6] = piu.getU_date();
			obj1[7] = piu.getS_price();
			model1.addRow(obj1);
			tp += Integer.parseInt(obj1[7].toString());
		}
		contentPane.setLayout(null);

		panel_1 = new JPanel();
		panel_1.setBounds(5, 5, 869, 732);
		contentPane.add(panel_1);
		panel_1.setLayout(new BorderLayout(0, 0));

		panel_2 = new JPanel();
		panel_1.add(panel_2, BorderLayout.NORTH);
		panel_2.setLayout(new BorderLayout(0, 0));

		panel_3 = new JPanel();
		panel_2.add(panel_3, BorderLayout.CENTER);
		panel_3.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JButton btnPre = new JButton("\uC774\uC804");
		panel_3.add(btnPre);
		btnPre.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cal.add(Calendar.MONTH, -1);
				int m = cal.get(Calendar.MONTH) + 1;
				System.out.println(m);
				year = cal.get(Calendar.YEAR);
				System.out.println(year);
				btnYear.setText(year + "");
				lblMonth.setText(m + "월");
				setCal(year, m - 1);
			}
		});

		btnYear = new JButton(year + "");
		panel_3.add(btnYear);
		btnYear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new Set_Year();

				// panel_1.repaint();
			}
		});

		lblMonth = new JLabel(month + 1 + "월");
		panel_3.add(lblMonth);

		btnNext = new JButton("\uB2E4\uC74C");
		panel_3.add(btnNext);

		btnSelectYear = new JButton("\uC62C\uD574 \uB9E4\uCD9C \uC870\uD68C");
		panel_3.add(btnSelectYear);
		btnSelectYear.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String y = Integer.toString(cal.get(Calendar.YEAR));
				PC_In_UseDAO p = PC_In_UseDAO.getInstance();
				String y1 = y.substring(2);
				pList = p.selectYear(y1);
				System.out.println(y1);
				DefaultTableModel model1 = new DefaultTableModel(use, 0);
				tp = 0;
				to = 0;
				for (int i = 0; i < pList.size(); i++) {
					PC_Used_View piu = pList.get(i);
					obj1[0] = piu.getNo();
					obj1[1] = piu.getId();
					obj1[2] = piu.getC_no();
					obj1[3] = piu.getType();
					obj1[4] = piu.getS_time();
					obj1[5] = piu.getP_time();
					obj1[6] = piu.getU_date();
					obj1[7] = piu.getS_price();
					model1.addRow(obj1);
					tp += Integer.parseInt(obj1[7].toString());
				}
				table1.setModel(model1);
				repaint();

				OrdersDAO o = OrdersDAO.getInstance();
				orderList = o.selectYear(y1);
				DefaultTableModel model = new DefaultTableModel(od, 0);
				for (int i = 0; i < orderList.size(); i++) {
					Orders_View orders = orderList.get(i);
					obj[0] = orders.getNo();
					obj[1] = orders.getId();
					obj[2] = orders.getName();
					obj[3] = orders.getType();
					obj[4] = orders.getQuantity();
					obj[5] = orders.getPrice();
					obj[6] = orders.getS_date();
					model.addRow(obj);
					to += Integer.parseInt(obj[5].toString());
				}
				table.setModel(model);
				System.out.println(tp + ", " + to);
				setTotal(tp, to);
				repaint();

			}
		});

		btnSelectMonth = new JButton("\uC6D4 \uB9E4\uCD9C \uC870\uD68C");
		panel_3.add(btnSelectMonth);
		btnSelectMonth.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String y = Integer.toString(cal.get(Calendar.YEAR));
				String m = Integer.toString(cal.get(Calendar.MONTH) + 1);
				PC_In_UseDAO p = PC_In_UseDAO.getInstance();
				String y1 = y.substring(2);
				String str = y1 + "/" + m;
				pList = p.selectMonth(str);
				System.out.println(str);
				to = 0;
				tp = 0;
				DefaultTableModel model1 = new DefaultTableModel(use, 0);
				for (int i = 0; i < pList.size(); i++) {
					PC_Used_View piu = pList.get(i);
					obj1[0] = piu.getNo();
					obj1[1] = piu.getId();
					obj1[2] = piu.getC_no();
					obj1[3] = piu.getType();
					obj1[4] = piu.getS_time();
					obj1[5] = piu.getP_time();
					obj1[6] = piu.getU_date();
					obj1[7] = piu.getS_price();
					model1.addRow(obj1);
					tp += Integer.parseInt(obj1[7].toString());
				}
				table1.setModel(model1);
				System.out.println("tp : " + tp);
				repaint();

				OrdersDAO o = OrdersDAO.getInstance();
				orderList = o.selectMonth(str);
				DefaultTableModel model = new DefaultTableModel(od, 0);
				for (int i = 0; i < orderList.size(); i++) {
					Orders_View orders = orderList.get(i);
					obj[0] = orders.getNo();
					obj[1] = orders.getId();
					obj[2] = orders.getName();
					obj[3] = orders.getType();
					obj[4] = orders.getQuantity();
					obj[5] = orders.getPrice();
					obj[6] = orders.getS_date();
					model.addRow(obj);
					to += Integer.parseInt(obj[5].toString());
				}
				table.setModel(model);
				System.out.println(tp + ", " + to);
				setTotal(tp, to);
				repaint();
			}
		});

		btnNext.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				cal.add(Calendar.MONTH, 1);
				int m = cal.get(Calendar.MONTH) + 1;
				System.out.println(m);
				year = cal.get(Calendar.YEAR);
				System.out.println(year);
				btnYear.setText(year + "");
				lblMonth.setText(m + "월");
				setCal(year, m - 1);
			}
		});

		panel_4 = new JPanel();
		panel_2.add(panel_4, BorderLayout.SOUTH);
		panel_4.setLayout(new GridLayout(1, 7, 0, 0));

		lblNewLabel = new JLabel("\uC77C");
		lblNewLabel.setForeground(Color.RED);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel);

		lblNewLabel_1 = new JLabel("\uC6D4");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_1);

		lblNewLabel_2 = new JLabel("\uD654");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_2);

		lblNewLabel_3 = new JLabel("\uC218");
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_3);

		lblNewLabel_4 = new JLabel("\uBAA9");
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_4);

		lblNewLabel_5 = new JLabel("\uAE08");
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_5);

		lblNewLabel_6 = new JLabel("\uD1A0");
		lblNewLabel_6.setForeground(Color.BLUE);
		lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
		panel_4.add(lblNewLabel_6);

		p4 = new JPanel();
		panel_1.add(p4);

		GridLayout gridLayout = new GridLayout(6, 7);
		p4.setLayout(gridLayout);
		table1 = new JTable(model1);

		JScrollPane sp1 = new JScrollPane(table1);
		sp1.setBounds(879, 5, 470, 320);
		contentPane.add(sp1);

		JPanel panel_5 = new JPanel();
		panel_5.setBounds(879, 326, 470, 32);
		contentPane.add(panel_5);
		panel_5.setLayout(null);

		lblTotalP = new JLabel("PC \uB9E4\uCD9C : " + tp + "원");
		lblTotalP.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalP.setBounds(327, 10, 131, 15);

		panel_5.add(lblTotalP);
		table = new JTable(model);

		JScrollPane sp = new JScrollPane(table);
		sp.setBounds(879, 358, 470, 312);
		contentPane.add(sp);

		panel = new JPanel();
		panel.setBounds(879, 677, 470, 55);
		contentPane.add(panel);
		panel.setLayout(null);

		lblTotalO = new JLabel("\uC0C1\uD488 \uB9E4\uCD9C : " + to + "원");
		lblTotalO.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotalO.setBounds(316, 0, 154, 30);
		panel.add(lblTotalO);

		t = to + tp;
		lblTotal = new JLabel("\uCD1D \uB9E4\uCD9C : " + t + "원");
		lblTotal.setHorizontalAlignment(SwingConstants.RIGHT);
		lblTotal.setBounds(351, 35, 119, 20);
		panel.add(lblTotal);

		for (int i = 0; i < 42; i++) {
			// myFrame.add(new Button(calArr.get(i)+""));

			tempBtn[i] = new JButton("");
			if (i % 7 == 0) {
				tempBtn[i].setForeground(Color.RED);
			} else if (i % 7 == 6) {
				tempBtn[i].setForeground(Color.BLUE);
			}
			p4.add(tempBtn[i]);
			tempBtn[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					int d = Integer.parseInt(e.getActionCommand());
					int y = cal.get(Calendar.YEAR);
					int m = cal.get(Calendar.MONTH);
					String str = y + "년" + (m + 1) + "월" + d + "일";
					System.out.println(str);
					String y1 = Integer.toString(y).substring(2);
					String dt = y1 + "/" + (m + 1) + "/" + d;
					System.out.println(dt);

					PC_In_UseDAO p = PC_In_UseDAO.getInstance();

					// model1.fireTableDataChanged();
					pList = p.selectDay(dt);
					tp = 0;
					to = 0;
					DefaultTableModel model1 = new DefaultTableModel(use, 0);
					for (int i = 0; i < pList.size(); i++) {
						PC_Used_View piu = pList.get(i);
						obj1[0] = piu.getNo();
						obj1[1] = piu.getId();
						obj1[2] = piu.getC_no();
						obj1[3] = piu.getType();
						obj1[4] = piu.getS_time();
						obj1[5] = piu.getP_time();
						obj1[6] = piu.getU_date();
						obj1[7] = piu.getS_price();
						model1.addRow(obj1);
						tp += Integer.parseInt(obj1[7].toString());
					}
					table1.setModel(model1);
					repaint();

					OrdersDAO o = OrdersDAO.getInstance();
					orderList = o.selectDay(dt);
					DefaultTableModel model = new DefaultTableModel(od, 0);
					for (int i = 0; i < orderList.size(); i++) {
						Orders_View orders = orderList.get(i);
						obj[0] = orders.getNo();
						obj[1] = orders.getId();
						obj[2] = orders.getName();
						obj[3] = orders.getType();
						obj[4] = orders.getQuantity();
						obj[5] = orders.getPrice();
						obj[6] = orders.getS_date();
						model.addRow(obj);
						to += Integer.parseInt(obj[5].toString());
					}
					System.out.println(tp + ", " + to);
					setTotal(tp, to);
					table.setModel(model);
					repaint();
				}
			});
		}

		setCal(2018, 11);
		setVisible(true);
	}

	private class Set_Year extends JDialog implements WindowListener {

		private JPanel contentPane;
		// Calendar cal;
		ArrayList<Integer> yList;
		int years, date, lastDay;

		public void setYear() {
			cal = Calendar.getInstance();
			years = cal.get(Calendar.YEAR);
			yList = new ArrayList<Integer>();
			for (int i = (years - 8); i <= years; i++) {
				yList.add(i);
				// year--;
			}
			GridLayout gridLayout = new GridLayout(yList.size() / 3, 3);
			contentPane.setLayout(gridLayout);
			for (int i = 0; i < yList.size(); i++) {
				JButton tempBtn = new JButton(yList.get(i) + "");
				contentPane.add(tempBtn);
				tempBtn.addActionListener(new ActionListener() {

					@Override
					public void actionPerformed(ActionEvent e) {
						// TODO Auto-generated method stub
						String y = e.getActionCommand();
						int ny = Integer.parseInt(y);
						setCal(ny, month);
						// cal.set(Calendar.YEAR, Integer.parseInt(y));
						System.out.println(ny);
						btnYear.setText(year + "");
						lblMonth.setText(month + 1 + "월");
						dispose();
					}
				});
			}

		}

		/**
		 * Launch the application.
		 */

		/**
		 * Create the frame.
		 */
		public Set_Year() {
			setBounds(100, 100, 300, 310);
			contentPane = new JPanel();
			setYear();
			setContentPane(contentPane);
			setVisible(true);

		}

		@Override
		public void windowActivated(WindowEvent e) {
		}

		@Override
		public void windowClosed(WindowEvent e) {
		}

		@Override
		public void windowClosing(WindowEvent e) {
			// TODO Auto-generated method stub
			dispose();
		}

		@Override
		public void windowDeactivated(WindowEvent e) {
		}

		@Override
		public void windowDeiconified(WindowEvent e) {
		}

		@Override
		public void windowIconified(WindowEvent e) {
		}

		@Override
		public void windowOpened(WindowEvent e) {
		}

	}

	public void setTotal(int tp, int to) {
		int t = tp + to;
		lblTotalP.setText("PC 매출 : " + tp + "원");
		lblTotalO.setText("상품 매출 : " + to + "원");
		lblTotal.setText("총 매출 : " + t + "원");
	}
}
