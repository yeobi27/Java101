package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

import DAO.OrdersDAO;
import DAO.ProductDAO;
import DTO.Orders;
import DTO.Product;
import DTO.Product_Type;

public class Purchase_Product extends JFrame {

	private JPanel contentPane;
	String names[] = { "상품명", "판매금액", "수량", "최종금액", "처리결과" };
	int no;
	JButton[] menuBtn;
	JPanel pCenter;
	Vector<Integer> arr = new Vector<Integer>();
	Vector<Integer> won = new Vector<Integer>();
	JLabel[] lblA;
	JLabel[] lblP;
	JTable table_2;
	DefaultTableModel model;
	private int j = 0;
	private int sum = 0;
	Product list3;
	private JLabel lblwon;
	private ArrayList<Product_Type> list1;
	private String id;
	ArrayList<Product> productList = null;
	String imgaddress;
	Client client;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Purchase_Product frame = new Purchase_Product();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public Purchase_Product(int no, String id, Client client) {
		this.id = id;
		this.no = no;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1200, 900);
		contentPane = new JPanel();
		contentPane.setBackground(Color.DARK_GRAY);
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel pSouth = new JPanel();
		pSouth.setLayout(null);
		pSouth.setPreferredSize(new Dimension(1000, 200));
		contentPane.add(pSouth, BorderLayout.SOUTH);
		pSouth.setLayout(new GridLayout(1, 0, 0, 0));

		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(147, 112, 219));
		pSouth.add(panel_4);
		panel_4.setLayout(new BorderLayout(0, 0));

		JPanel panel_9 = new JPanel();
		panel_4.add(panel_9, BorderLayout.NORTH);
		panel_9.setLayout(new GridLayout(0, 2, 0, 0));
		panel_9.setPreferredSize(new Dimension(800, 33));

		JPanel panel_13 = new JPanel();
		panel_13.setForeground(Color.LIGHT_GRAY);
		panel_13.setBackground(new Color(0, 0, 51));
		panel_9.add(panel_13);
		panel_13.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_1 = new JLabel("   \uC0C1\uD488\uC8FC\uBB38\uBAA9\uB85D");
		lblNewLabel_1.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 12));
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.LEFT);
		panel_13.add(lblNewLabel_1);

		JPanel panel_10 = new JPanel();
		panel_10.setBackground(new Color(0, 0, 51));
		panel_9.add(panel_10);
		panel_10.setLayout(new GridLayout(1, 2, 0, 0));

		JPanel panel_11 = new JPanel();
		panel_11.setBackground(new Color(0, 0, 51));
		panel_11.setForeground(Color.DARK_GRAY);
		panel_10.add(panel_11);
		panel_11.setLayout(new GridLayout(1, 0, 0, 0));

		JLabel lblNewLabel_3 = new JLabel("\uCD5C\uADFC\uC8FC\uBB38\uC644\uB8CC\uB0B4\uC5ED");
		panel_11.add(lblNewLabel_3);
		lblNewLabel_3.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_3.setFont(new Font("Adobe 고딕 Std B", Font.PLAIN, 12));
		lblNewLabel_3.setForeground(Color.WHITE);

		JButton btnmm = new JButton(new ImageIcon("img/minus.png"));
		panel_11.add(btnmm);
		btnmm.setHorizontalAlignment(SwingConstants.RIGHT);
		btnmm.setBorderPainted(false);
		btnmm.setContentAreaFilled(false);

		btnmm.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				model = new DefaultTableModel(names, 0);
				sum = 0;
				lblwon.setText(sum + " 원");

				model.fireTableDataChanged();
				table_2.setModel(model);
				table_2.repaint();
			}
		});

		model = new DefaultTableModel(names, 0);

		table_2 = new JTable(model);
		table_2.setBackground(Color.WHITE);

		table_2.setPreferredScrollableViewportSize(new Dimension(800, 142));
		JScrollPane scrollPane_1 = new JScrollPane(table_2);
		panel_4.add(scrollPane_1, BorderLayout.SOUTH);

		JPanel panel_5 = new JPanel();
		pSouth.add(panel_5);
		panel_5.setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		panel.setPreferredSize(new Dimension(800, 33));
		panel.setBackground(new Color(0, 0, 51));
		panel_5.add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("상품판매 결재선택하기");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("굴림", Font.BOLD, 15));
		panel.add(lblNewLabel);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(112, 128, 144));
		panel_5.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(2, 0, 0, 0));

		ButtonGroup group = new ButtonGroup();
		JRadioButton rdbnt1 = new JRadioButton("선불(현금)");
		rdbnt1.setFont(new Font("굴림", Font.BOLD, 16));
		rdbnt1.setForeground(new Color(255, 255, 255));
		rdbnt1.setBackground(new Color(112, 128, 144));

		JRadioButton rdbnt2 = new JRadioButton("충전시간차감");
		rdbnt2.setFont(new Font("굴림", Font.BOLD, 17));
		rdbnt2.setForeground(new Color(255, 255, 255));
		rdbnt2.setBackground(new Color(112, 128, 144));

		group.add(rdbnt1);
		group.add(rdbnt2);

		panel_1.add(rdbnt1);
		panel_1.add(rdbnt2);

		JPanel panel_6 = new JPanel();
		panel_6.setBackground(new Color(0, 0, 51));
		pSouth.add(panel_6);
		panel_6.setLayout(new GridLayout(2, 0, 0, 0));

		lblwon = new JLabel("0\uC6D0      ");
		lblwon.setForeground(new Color(255, 255, 255));
		lblwon.setBackground(new Color(0, 0, 51));
		lblwon.setFont(new Font("Adobe 고딕 Std B", Font.BOLD, 25));
		lblwon.setHorizontalAlignment(SwingConstants.RIGHT);
		panel_6.add(lblwon);

		JButton btnsale = new JButton("\uC0C1\uD488 \uC8FC\uBB38\uD558\uAE30");
		btnsale.setForeground(Color.WHITE);
		btnsale.setBackground(new Color(255, 69, 0));
		btnsale.setFont(new Font("굴림", Font.BOLD, 25));
		panel_6.add(btnsale);
		btnsale.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				// ArrayList<Orders> orders=new ArrayList<Orders>();
				OrdersDAO dao = OrdersDAO.getInstance();
				ProductDAO Pdao = ProductDAO.getInstance();

				TableModel m = table_2.getModel();
				int rowc = table_2.getRowCount();
				String order = "PURCHASE@" + no + "@" + id;
				// System.out.println(rowc);
				for (int i = 0; i < rowc; i++) {
					Orders or = new Orders();
					int no = Pdao.SearchP_no(m.getValueAt(i, 0).toString());
					or.setId(id);
					or.setP_no(no);
					// System.out.println((int)(m.getValueAt(i,0)));
					// System.out.println(m.getValueAt(i, 3));
					or.setQuantity(Integer.parseInt(m.getValueAt(i, 2).toString()));
					order += "@" + or.getP_no() + "@" + or.getQuantity();
					dao.insertOrdersDAO(or);
					Pdao.productupdate(or.getP_no(), -or.getQuantity());
					// System.out.println(or.getNo());
					// System.out.println(rowc);
					// pr.setStock(pr.getNo((int)(m.getValueAt(i,0)))-Integer.parseInt((m.getValueAt(i,3).toString())));
					// System.out.println((int)(productList.get(rowc).getStock())-Integer.parseInt((m.getValueAt(i,3).toString())));
					// System.out.println((productList.get(i).getStock())-Integer.parseInt((m.getValueAt(i,3).toString())));
					// (Integer.parseInt((productList.get(i).getStock()))-(Integer.parseInt(m.getValueAt(i,3).toString())));

				}
				for (int i = model.getRowCount() - 1; i >= 0; i--) {
					model.removeRow(i);
				}
				model.fireTableDataChanged();
				order += lblwon.getText();
				lblwon.setText("0 원");
				client.send(order);
			}
		});

		JPanel pWest = new JPanel();

		pWest.setLayout(null);
		pWest.setPreferredSize(new Dimension(200, 1200));

		JScrollPane spWest = new JScrollPane(pWest);
		spWest.setPreferredSize(new Dimension(200, 400));
		contentPane.add(spWest, BorderLayout.WEST);

		pCenter = new JPanel();
		pCenter.setLayout(null);
		pCenter.setPreferredSize(new Dimension(1000, 700));

		JScrollPane spCenter = new JScrollPane(pCenter);

		ProductDAO dao = ProductDAO.getInstance();
		list1 = dao.selectAll2();
		menuBtn = new JButton[list1.size()];

		for (int i = 0; i < list1.size(); i++) {
			final int type1 = i + 1;

			menuBtn[i] = new JButton((list1.get(i).getType()));
			menuBtn[i].setSize(200, 80);
			menuBtn[i].setLocation(0, i * 80);
			menuBtn[i].addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					pCenter.removeAll(); // 전체삭제
					pCenter.setVisible(false);

					productList = ProductDAO.getInstance().selectType(type1);
					lblA = new JLabel[productList.size()];
					lblP = new JLabel[productList.size()];
					arr.removeAllElements();
					won.removeAllElements();
					int x = 0, y = 0;

					for (j = 0; j < productList.size(); j++) {
						final int idx = j;
						if (j % 5 == 0) { // 패널 위치 x,y 좌표 설정
							x = 0;
						} else {
							x += 200;
						}
						y = j / 5 * 200;

						Product product = productList.get(j);
						String name = product.getName();
						// System.out.println(product);
						// System.out.println(name);
						won.add(product.getPrice());
						// System.out.println(won.add(product.getPrice()));

						JPanel sp1 = new JPanel();
						sp1.setBackground(new Color(119, 136, 153));
						sp1.setSize(198, 198);
						// sp1.setBounds(0, 0, 100, 100);
						sp1.setLocation(x, y);
						pCenter.add(sp1);
						sp1.setLayout(new BorderLayout(0, 0));

						JLabel lblName = new JLabel("[" + name + "]");
						lblName.setForeground(Color.WHITE);
						lblName.setHorizontalAlignment(SwingConstants.CENTER);
						sp1.add(lblName, BorderLayout.NORTH);

						JPanel sp1_1 = new JPanel();
						sp1.add(sp1_1, BorderLayout.SOUTH);
						sp1_1.setLayout(new GridLayout(1, 0, 0, 0));

						JPanel sp1_11 = new JPanel();
						sp1_11.setBackground(new Color(119, 136, 153));
						sp1_1.add(sp1_11);
						sp1_11.setLayout(new GridLayout(1, 0));

						JButton btnP = new JButton(new ImageIcon("img/plus.png"));
						btnP.setBorderPainted(false);
						btnP.setContentAreaFilled(false); // 뉴 이미지아이콘으로 넣는다
						btnP.setName(j + "");
						sp1_11.add(btnP);
						btnP.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								JButton tmp = (JButton) e.getSource();
								int index = Integer.parseInt(tmp.getName());
								int n = arr.get(index) + 1;
								arr.set(index, n);
								lblA[index].setText(n + "");
								lblP[index].setText(((n * won.get(index)) + " 원"));
								// int a+=(n * won.get(index));

							}

						});

						arr.add(0);
						lblA[j] = new JLabel(arr.get(j) + "");

						lblA[j].setHorizontalAlignment(SwingConstants.RIGHT);
						lblA[j].setForeground(Color.WHITE);
						sp1_11.add(lblA[j]);

						JButton btnM = new JButton(new ImageIcon("img/minus.png"));
						btnM.setBorderPainted(false);
						btnM.setContentAreaFilled(false);
						sp1_11.add(btnM);
						btnM.setName(j + "");
						btnM.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {

								/*
								 * JButton tmp = (JButton) e.getSource(); System.out.println(tmp.getName()); int
								 * index = (Integer.parseInt(tmp.getName())) - 1; int n = arr.get(index);
								 * System.out.println(n); if (n >= 0) { arr.set(index, n); lblA[index].setText(n
								 * + ""); lblP[index].setText(((n * won.get(index)) + " 원")); }
								 */

								JButton tmp = (JButton) e.getSource();
								int index = Integer.parseInt(tmp.getName());
								if (arr.get(index) - 1 != -1) {
									int n = arr.get(index) - 1;
									arr.set(index, n);
									lblA[index].setText(n + "");
									lblP[index].setText(((n * won.get(index)) + " 원"));
									// int a+=(n * won.get(index));
								}

							}
						});

						JPanel sp1_12 = new JPanel();

						sp1_12.setBackground(new Color(119, 136, 153));
						sp1_1.add(sp1_12);
						sp1_12.setLayout(new GridLayout(1, 0));

						lblP[j] = new JLabel(won.get(j) + " 원  ");
						lblP[j].setHorizontalAlignment(SwingConstants.RIGHT);
						lblP[j].setForeground(Color.WHITE);

						sp1_12.add(lblP[j]);
						// System.out.println("count " + j);

						/*
						 * ProductDAO dao = ProductDAO.getInstance(); list1= dao.selectAll2();
						 * menuBtn=new JButton[list1.size()];
						 * 
						 * for (int i = 0; i <list1.size() ; i++) { final int type1 = i + 1;
						 * 
						 * menuBtn[i] = new JButton((list1.get(i).getType())); menuBtn[i].setSize(200,
						 * 80); menuBtn[i].setLocation(0, i * 80); menuBtn[i].addActionListener(new
						 * ActionListener() {
						 * 
						 * @Override public void actionPerformed(ActionEvent e) { // TODO Auto-generated
						 * method stub pCenter.removeAll(); // 전체삭제 pCenter.setVisible(false);
						 * 
						 * productList = ProductDAO.getInstance().selectType(type1); lblA = new
						 * JLabel[productList.size()]; lblP = new JLabel[productList.size()];
						 * arr.removeAllElements(); won.removeAllElements(); int x = 0, y = 0;
						 */
						imgaddress = product.getImgaddress();

						System.out.println(imgaddress);

						// System.out.println(ImageIcon("images/"+list2.getImgaddress()));
						JButton btnIm = new JButton(new ImageIcon("img/" + imgaddress)); // 이미지 파일 데이터가 같이 들어가야한다.

						btnIm.addActionListener(new ActionListener() {

							@Override
							public void actionPerformed(ActionEvent e) {
								// TODO Auto-generated method stub

								Object[] obj = new Object[6];

								obj[0] = product.getName();
								obj[1] = product.getPrice();
								obj[2] = lblA[idx].getText().trim();
								obj[3] = lblP[idx].getText();
								obj[4] = "N";

								if (Integer.parseInt(lblA[idx].getText()) != 0) {
									model.addRow(obj);
								}

								sum += product.getPrice() * (Integer.parseInt(lblA[idx].getText()) - 1);
								lblA[idx].setText("0");
								arr.set(idx, 0);
								lblP[idx].setText(product.getPrice() + " 원");
								sum += product.getPrice();
								lblwon.setText(sum + " 원");

							}

						});
						sp1.add(btnIm, BorderLayout.CENTER);
						pCenter.repaint();
						pCenter.setVisible(true); // 화면 흔들어 주는 것 위에 //pCenter.setVisible(false); 까지
					}
				}

				private String ImageIcon(String string) {
					// TODO Auto-generated method stub
					return null;
				}
			});
			pWest.add(menuBtn[i]);
		}

		spCenter.setPreferredSize(new Dimension(1000, 400));
		contentPane.add(spCenter, BorderLayout.CENTER);

		JPanel pNorth = new JPanel();
		pNorth.setBackground(new Color(0, 0, 51));
		contentPane.add(pNorth, BorderLayout.NORTH);
		pNorth.setLayout(null);
		pNorth.setPreferredSize(new Dimension(30, 50));

		JPanel pn1 = new JPanel();
		pn1.setBackground(new Color(0, 0, 51));
		pn1.setSize(200, 50);
		pn1.setLocation(0, 0);
		pNorth.add(pn1);
		pn1.setLayout(new GridLayout(0, 1, 0, 0));

		JLabel lblNewLabel_4 = new JLabel("Menu Category");
		lblNewLabel_4.setFont(new Font("굴림", Font.BOLD, 15));
		lblNewLabel_4.setBackground(new Color(0, 0, 51));
		lblNewLabel_4.setForeground(new Color(255, 255, 255));
		lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
		pn1.add(lblNewLabel_4);

		JLabel lbl1 = new JLabel(
				"\u203B \uC0C1\uD488 \uC774\uBBF8\uC9C0\uAC00 \uC2E4\uCCB4 \uC0C1\uD488\uACFC \uCC28\uC774\uAC00 \uC788\uC744 \uC218 \uC788\uC2B5\uB2C8\uB2E4.   ");
		lbl1.setForeground(Color.LIGHT_GRAY);
		lbl1.setFont(new Font("굴림", Font.PLAIN, 12));
		pNorth.add(lbl1);
		lbl1.setSize(330, 30);
		lbl1.setLocation(530, 10);

		setVisible(true);

	}
}
