package GUI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ProductDAO;
import DTO.Product_Type;

public class P_Type_Management extends JFrame {

	ArrayList<Product_Type> pList;
	private JPanel contentPane;
	private String[] names = { "前格 锅龋", "前格" };
	JTable table;
	private JTextField tfAdd;
	private JTextField tfNo;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					P_Type_Management frame = new P_Type_Management();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});

	}

	/**
	 * Create the frame.
	 */
	public P_Type_Management() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 226, 302);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);

		DefaultTableModel model = new DefaultTableModel(names, 0);
		Object[] obj = new Object[2];
		ProductDAO pt = ProductDAO.getInstance();
		pList = pt.viewType();
		for (int i = 0; i < pList.size(); i++) {
			Product_Type p = pList.get(i);
			obj[0] = p.getNo();
			obj[1] = p.getType();
			model.addRow(obj);
		}
		contentPane.setLayout(null);

		table = new JTable(model);
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(5, 5, 202, 187);
		contentPane.add(scrollPane);

		JPanel panel = new JPanel();
		panel.setBounds(5, 193, 202, 66);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("\uD0C0\uC785 :");
		lblNewLabel.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel.setBounds(90, 9, 38, 15);
		panel.add(lblNewLabel);

		tfAdd = new JTextField();
		tfAdd.setBounds(133, 6, 57, 21);
		panel.add(tfAdd);
		tfAdd.setColumns(10);

		JButton btnDel = new JButton("\uC0AD\uC81C");
		btnDel.setBounds(119, 37, 71, 23);
		btnDel.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int no = (int) table.getValueAt(table.getSelectedRow(), 0);
				ProductDAO dao = ProductDAO.getInstance();
				System.out.println(no);
				dao.deletetype(no);
				DefaultTableModel model = new DefaultTableModel(names, 0);
				Object[] obj = new Object[2];
				ProductDAO pt = ProductDAO.getInstance();
				pList = pt.viewType();
				for (int i = 0; i < pList.size(); i++) {
					Product_Type p = pList.get(i);
					obj[0] = p.getNo();
					obj[1] = p.getType();
					model.addRow(obj);
				}
				table.setModel(model);
				;
				repaint();

			}
		});
		panel.add(btnDel);

		JButton button = new JButton("\uCD94\uAC00");
		button.setBounds(12, 37, 71, 23);
		panel.add(button);

		JLabel lblNewLabel_1 = new JLabel("\uBC88\uD638 :");
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNewLabel_1.setBounds(-13, 9, 45, 15);
		panel.add(lblNewLabel_1);

		tfNo = new JTextField();
		tfNo.setColumns(10);
		tfNo.setBounds(33, 6, 57, 21);
		panel.add(tfNo);
		button.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String str1 = tfNo.getText();
				String str2 = tfAdd.getText();
				int no = Integer.parseInt(str1);
				ProductDAO dao = ProductDAO.getInstance();
				dao.insertType(no, str2);
				DefaultTableModel model = new DefaultTableModel(names, 0);
				Object[] obj = new Object[2];
				ProductDAO pt = ProductDAO.getInstance();
				pList = pt.viewType();
				for (int i = 0; i < pList.size(); i++) {
					Product_Type p = pList.get(i);
					obj[0] = p.getNo();
					obj[1] = p.getType();
					model.addRow(obj);
				}
				table.setModel(model);
				tfNo.setText("");
				tfAdd.setText("");
				repaint();
			}
		});

		setVisible(true);
	}
}
