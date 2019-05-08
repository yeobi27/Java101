package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;

import javax.swing.JButton;
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

import DAO.ComputerDAO;
import DTO.Computer;

public class Com_Management extends JFrame {
	private String[] comInfo = { "번호", "IP주소", "포트번호", "구입 날짜", "특이사항" };
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private ArrayList<Computer> comList;
	MainFrame main;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// Com_Management frame = new Com_Management();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Com_Management(MainFrame main) {
		this.main = main;
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("컴퓨터관리");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		table = new JTable();
		try {
			comDB();
		} catch (Exception e) {

			e.printStackTrace();
		}
		JPanel btnPanel = new JPanel();
		contentPane.add(btnPanel, BorderLayout.SOUTH);

		JButton btnInsert = new JButton("\uCD94\uAC00");
		btnPanel.add(btnInsert);
		btnInsert.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				InsertCom frame = new InsertCom();
				frame.setting();

			}
		});
		JButton btnDelete = new JButton("\uC0AD\uC81C");
		btnPanel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int no = (int) table.getValueAt(table.getSelectedRow(), 0);
				ComputerDAO dao = ComputerDAO.getInstance();
				int n = dao.deleteCom(no);
				if (n == -1) {
					JOptionPane.showMessageDialog(null, "삭제 실패", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					comDB();
					main.Show();
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

	private void comDB() throws Exception {
		ComputerDAO dao = ComputerDAO.getInstance();
		comList = dao.selectAll();
		DefaultTableModel tm = new DefaultTableModel(comInfo, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if (column == 0 || column == 3)
					return false;
				else
					return true;
			}
		};
		Object[] obj = new Object[5];
		for (int i = 0; i < comList.size(); i++) {
			Computer c = comList.get(i);
			obj[0] = c.getNo();
			obj[1] = c.getIp();
			obj[2] = c.getPort();
			obj[3] = c.getPurchase_date();
			obj[4] = c.getStatus();
			tm.addRow(obj);
		}
		table.setModel(tm);
		table.addKeyListener(new KeyListener() {

			@Override
			public void keyTyped(KeyEvent e) {
				// TODO Auto-generated method stub

			}

			@Override
			public void keyReleased(KeyEvent e) {

				if (e.getKeyCode() == 10) {
					int col = table.getSelectedColumn();
					int no = (int) table.getValueAt(table.getSelectedRow(), 0);
					String update = (String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
					ComputerDAO dao = ComputerDAO.getInstance();
					dao.updateCom(no, col, update);
					main.Show();
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}

	private class InsertCom extends JDialog {
		private JPanel contentPane;
		private JTextField tfIp;
		private JTextField tfPort;

		public InsertCom() {
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					dispose();
				}
			});
		}

		public void setting() {

			setBounds(100, 100, 250, 155);
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
					String input_ip = tfIp.getText();
					int input_port = Integer.parseInt(tfPort.getText());
					if (!input_ip.equals("")) {
						ComputerDAO dao = ComputerDAO.getInstance();
						int n = dao.insertCom(input_ip, input_port);
						if (n == -1) {
							JOptionPane.showMessageDialog(null, "등록 실패", "Error", JOptionPane.ERROR_MESSAGE);
						}
					} else
						JOptionPane.showMessageDialog(null, "등록 실패", "Error", JOptionPane.ERROR_MESSAGE);
					try {
						comDB();
						main.Show();
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

			JLabel lblLabel = new JLabel("IP \uC8FC\uC18C \uC785\uB825 : ");
			lblLabel.setBounds(12, 13, 79, 15);
			panel_1.add(lblLabel);

			tfIp = new JTextField();
			tfIp.setBounds(96, 10, 116, 21);
			panel_1.add(tfIp);
			tfIp.setColumns(10);
			setVisible(true);

			JLabel lblPort = new JLabel("PORT \uBC88\uD638 : ");
			lblPort.setHorizontalAlignment(SwingConstants.RIGHT);
			lblPort.setBounds(12, 41, 79, 15);
			panel_1.add(lblPort);

			tfPort = new JTextField();
			tfPort.setColumns(10);
			tfPort.setBounds(96, 38, 116, 21);
			panel_1.add(tfPort);
		}
	}

}
