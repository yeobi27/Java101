package GUI;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import DAO.ComputerDAO;
import DAO.MemberDAO;
import DTO.Member_View;

public class Member_Management extends JFrame {
	private String[] comInfo = { "ID", "NAME", "등급", "E-Mail", "가입 날짜" };
	private JPanel contentPane;
	private JTable table;
	private DefaultTableModel model;
	private JScrollPane scrollPane;
	private ArrayList<Member_View> memList;
	private int row = 0;
	private JButton btnRating;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Member_Management frame = new Member_Management();

				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Member_Management() {
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		setTitle("회원 관리");
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		table = new JTable();
		try {
			MemDB();
		} catch (Exception e) {

			e.printStackTrace();
		}
		JPanel btnPanel = new JPanel();
		contentPane.add(btnPanel, BorderLayout.SOUTH);

		btnRating = new JButton("\uD68C\uC6D0 \uB4F1\uAE09 \uBCC0\uACBD");
		btnPanel.add(btnRating);
		btnRating.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub

			}
		});
		JButton btnDelete = new JButton("\uC0AD\uC81C");
		btnPanel.add(btnDelete);
		btnDelete.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				String id = (String) table.getValueAt(table.getSelectedRow(), 0);
				System.out.println(id);
				MemberDAO dao = MemberDAO.getInstance();
				int n = dao.deleteMem(id);
				if (n == -1) {
					JOptionPane.showMessageDialog(null, "삭제 실패", "Error", JOptionPane.ERROR_MESSAGE);
				}
				try {
					MemDB();
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

	private void MemDB() throws Exception {
		MemberDAO dao = MemberDAO.getInstance();
		memList = dao.SelectAll_View();
		DefaultTableModel tm = new DefaultTableModel(comInfo, 0) {
			@Override
			public boolean isCellEditable(int row, int column) {
				// TODO Auto-generated method stub
				if (column < 3 || column == 4)
					return false;
				else
					return true;
			}
		};
		Object[] obj = new Object[5];
		for (int i = 0; i < memList.size(); i++) {
			Member_View c = memList.get(i);
			obj[0] = c.getId();
			obj[1] = c.getName();
			obj[2] = c.getRating();
			obj[3] = c.getEmail();
			obj[4] = c.getJoin_date();
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
					String id = (String) table.getValueAt(table.getSelectedRow(), 0);
					String update = (String) table.getValueAt(table.getSelectedRow(), table.getSelectedColumn());
					MemberDAO dao = MemberDAO.getInstance();
					dao.updateMem(id, update);
				}

			}

			@Override
			public void keyPressed(KeyEvent e) {
				// TODO Auto-generated method stub

			}
		});

	}
}