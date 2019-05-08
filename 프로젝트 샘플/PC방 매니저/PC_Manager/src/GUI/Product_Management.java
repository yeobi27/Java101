package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ProductDAO;
import DTO.Product;
import DTO.Product_View;

public class Product_Management extends JFrame {
	private String[] ProInfo = { "번호", "이름", "들어온날짜", "가격", "타입", "재고수량" };
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private ArrayList<Product_View> prolist;
	private int row = 0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Product_Management frame = new Product_Management();
					System.out.println(frame);

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Product_Management() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("재고관리");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		table = new JTable();
		try {
			ProDB();
		} catch (Exception e) {

			e.printStackTrace();
		}
		JPanel btnPanel = new JPanel();
		contentPane.add(btnPanel, BorderLayout.SOUTH);

		JButton btntype = new JButton("\uD0C0\uC785\uCD94\uAC00");
		btnPanel.add(btntype);
		btntype.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				new P_Type_Management();
			}
		});

		JButton btnInsert = new JButton("\uCD94\uAC00");
		btnPanel.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InsertPro ip = new InsertPro();
				ip.setting();

			}
		});
		JButton btnDelete = new JButton("\uC0AD\uC81C");
		btnPanel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = (int) table.getValueAt(table.getSelectedRow(), 0);
				ProductDAO dao = ProductDAO.getInstance();
				int n = dao.deletePro(no);
				if (n == -1) {
					JOptionPane.showMessageDialog(null, "삭제 실패", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					ProDB();
				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});

		JButton btnClose = new JButton("\uB2EB\uAE30");
		btnPanel.add(btnClose);
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				dispose();

			}
		});
		scrollPane = new JScrollPane(table);
		contentPane.add(scrollPane, BorderLayout.CENTER);
		setVisible(true);
	}

	private void ProDB() throws Exception {
		ProductDAO dao = ProductDAO.getInstance();
		prolist = dao.select_View_All();
		DefaultTableModel tm = new DefaultTableModel(ProInfo, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if (column == 0 || column == 5)
					return false;
				else
					return true;
			}
		};
		Object[] obj = new Object[6];
		for (int i = 0; i < prolist.size(); i++) {
			Product_View p = prolist.get(i);
			obj[0] = p.getNo();
			obj[1] = p.getName();
			obj[2] = p.getPurchase_date();
			obj[3] = p.getPrice();
			obj[4] = p.getType();
			obj[5] = p.getStock();
			tm.addRow(obj);
		}
		table.setModel(tm);

	}

	private class InsertPro extends JDialog {
		protected static final int String = 0;
		private JPanel contentPane;
		private JTextField tfno;
		private JTextField tfname;
		private JTextField purchase_date;
		private JTextField price;
		private JTextField stock;
		private JComboBox type;
		private int index;

		public void setting() {

			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 320, 270);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);

			JPanel panel = new JPanel();
			contentPane.add(panel, BorderLayout.SOUTH);

			JButton btnInput = new JButton("\uB4F1\uB85D");
			panel.add(btnInput);
			btnInput.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					String name = tfname.getText();
					int prices = Integer.parseInt(price.getText());
					int stocks = Integer.parseInt(stock.getText());

					if (!tfname.getText().equals("") || price.getText().equals("") || stock.getText().equals("")) {
						ProductDAO dao = ProductDAO.getInstance();
						int n = dao.InsertPro(name, prices, index + 1, stocks);
						if (n == -1) {
							JOptionPane.showMessageDialog(null, "등록 실패", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} else
						JOptionPane.showMessageDialog(null, "등록 실패", "Error", JOptionPane.ERROR_MESSAGE);
					try {
						ProDB();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					dispose();
				}
			});

			JButton btnClose = new JButton("\uCDE8\uC18C");
			panel.add(btnClose);
			btnClose.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();

				}
			});
			JPanel panel_1 = new JPanel();
			contentPane.add(panel_1, BorderLayout.CENTER);
			panel_1.setLayout(null);

			tfname = new JTextField();
			tfname.setColumns(10);
			tfname.setBounds(133, 13, 116, 21);
			panel_1.add(tfname);

			price = new JTextField();
			price.setBounds(133, 41, 116, 21);
			panel_1.add(price);
			price.setColumns(10);

			ProductDAO dao = ProductDAO.getInstance();
			Vector temp = dao.selectType();
			type = new JComboBox(temp);
			type.setBounds(133, 72, 116, 21);
			panel_1.add(type);
			type.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					JComboBox cb = (JComboBox) e.getSource();
					index = cb.getSelectedIndex();
				}
			});

			stock = new JTextField();
			stock.setBounds(133, 103, 116, 21);
			panel_1.add(stock);
			stock.setColumns(10);

			JLabel lblname = new JLabel("\uC774\uB984 : ");
			lblname.setHorizontalAlignment(SwingConstants.RIGHT);
			lblname.setFont(new Font("굴림", Font.BOLD, 15));
			lblname.setBounds(12, 13, 104, 21);
			panel_1.add(lblname);

			JLabel lblprice = new JLabel("가격 : ");
			lblprice.setFont(new Font("굴림", Font.BOLD, 15));
			lblprice.setHorizontalAlignment(SwingConstants.RIGHT);
			lblprice.setBounds(0, 41, 116, 21);
			panel_1.add(lblprice);

			JLabel lbltype = new JLabel("타입 : ");
			lbltype.setFont(new Font("굴림", Font.BOLD, 15));
			lbltype.setHorizontalAlignment(SwingConstants.RIGHT);
			lbltype.setBounds(12, 75, 104, 21);
			panel_1.add(lbltype);

			JLabel lblstock = new JLabel("\uC7AC\uACE0 : ");
			lblstock.setFont(new Font("굴림", Font.BOLD, 15));
			lblstock.setHorizontalAlignment(SwingConstants.RIGHT);
			lblstock.setBounds(12, 106, 104, 21);
			panel_1.add(lblstock);

			setVisible(true);
		}
	}

}