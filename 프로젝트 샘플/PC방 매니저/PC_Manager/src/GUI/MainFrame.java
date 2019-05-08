package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.ListModel;
import javax.swing.border.EmptyBorder;

import DAO.PC_In_UseDAO;
import DAO.ProductDAO;
import DTO.PC_In_Use;
import DTO.PC_In_Use_View;

public class MainFrame extends JFrame {

	private JPanel contentPane;
	private Vector<String>[] v;
	private JList<String>[] comList;
	private JPanel ComPane;
	private int price = 1000;
	private TimeThread[] time_th;
	final int port = 8000;
	private Server server;
	MainFrame main;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MainFrame frame = new MainFrame();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * 
	 * @throws IOException
	 */
	public MainFrame() throws IOException {
		this.main = this;
		setTitle("PC 관리 프로그램");
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 700, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);

		JPanel btnPanel = new JPanel();

		contentPane.add(btnPanel, BorderLayout.EAST);
		btnPanel.setLayout(new GridLayout(10, 1, 3, 3));

		JLabel lblPrice = new JLabel("");
		btnPanel.add(lblPrice);

		JButton btnMember = new JButton("\uD68C\uC6D0\uAD00\uB9AC");
		btnPanel.add(btnMember);
		btnMember.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Member_Management();

			}
		});

		JButton btnOrders = new JButton("\uB9E4\uCD9C\uAD00\uB9AC");
		btnPanel.add(btnOrders);
		btnOrders.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Ledger();

			}
		});

		// 시간당 금액 설정
		JButton btnSetting = new JButton("\uAE08\uC561\uC124\uC815");
		btnPanel.add(btnSetting);
		btnSetting.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					double tmp = Double.parseDouble((JOptionPane.showInputDialog(null, "시간당")));

					if (JOptionPane.showConfirmDialog(null, "시간당 : " + (int) tmp + " 분당 :" + (int) Math.ceil(tmp / 60),
							"입력 확인", 2) == 0) {
						price = (int) tmp;
						lblPrice.setText("시간당 : " + price);
					}

				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1.toString(), "Error", JOptionPane.ERROR_MESSAGE);

				}

			}
		});

		JButton btnProduct = new JButton("\uC7AC\uACE0\uAD00\uB9AC");
		btnPanel.add(btnProduct);
		btnProduct.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Product_Management();

			}
		});

		JPanel mainPanel = new JPanel();
		contentPane.add(mainPanel, BorderLayout.CENTER);

		mainPanel.setLayout(new BorderLayout(0, 0));

		ComPane = new JPanel();
		ComPane.setLayout(new FlowLayout(FlowLayout.LEFT, 10, 20));
		mainPanel.add(ComPane, BorderLayout.CENTER);

		lblPrice.setText("시간당 : " + price);

		// 컴퓨터 관리창
		JButton btnComputer = new JButton("\uCEF4\uD4E8\uD130\uAD00\uB9AC");
		btnPanel.add(btnComputer);

		JButton btnClose = new JButton("\uC885 \uB8CC");
		btnPanel.add(btnClose);
		btnComputer.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Com_Management(main);
			}
		});
		btnClose.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				System.exit(0);

			}
		});

		// 디스플레이 초기화
		init();
		// DB접속 내용 읽어서 디스플레이
		Show();

		try {
			server = new Server(this);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	private void init() {
		PC_In_UseDAO dao = PC_In_UseDAO.getInstance();
		ArrayList<PC_In_Use_View> list = dao.selectAll();
		comList = new JList[list.size()];
		v = new Vector[list.size()];
		time_th = new TimeThread[list.size()];

		for (int i = 0; i < list.size(); i++) {
			v[i] = new Vector<String>();
			comList[i] = new JList<String>(v[i]);
			comList[i].setFixedCellWidth(100);
			comList[i].setFixedCellHeight(15);

			ComPane.add(comList[i]);
			comList[i].addMouseListener(new MouseListener() {

				@Override
				public void mouseReleased(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mousePressed(MouseEvent e) {
					JList temp = (JList) e.getSource();
					ListModel tmp = temp.getModel();

					if (tmp.getElementAt(1) == null || !tmp.getElementAt(1).equals("고장")) {
						try {
							String[] values = tmp.getElementAt(0).toString().split("No.");

							if (tmp.getElementAt(2) == null) {
								InsertUsePC frame = new InsertUsePC(new JFrame(), Integer.parseInt(values[1]), price);
								frame.setting();

							} else {
								// 강제중지

								int time = 0;
								PC_In_UseDAO dao = PC_In_UseDAO.getInstance();
								if (JOptionPane.showConfirmDialog(null, "강제로 중지", "입력 확인", 2) == 0) {
									if (time_th[Integer.parseInt(values[1]) - 1].isAlive()) {
										time = time_th[Integer.parseInt(values[1]) - 1].getTime();
										time_th[Integer.parseInt(values[1]) - 1].interrupt();

										if (tmp.getElementAt(2).equals("후불")) {
											int after_price = (price * (time / 60))
													+ ((int) Math.ceil(price / 60) * time % 60);
											dao.WaitPc_in_use(Integer.parseInt(values[1]), time, after_price);
											server.send_C(Integer.parseInt(values[1]) + "@CLOSE");
										} else {

											dao.DonePc_in_use(Integer.parseInt(values[1]));
											server.send_C(Integer.parseInt(values[1]) + "@CLOSE");
										}

									} else {
										dao.DonePc_in_use(Integer.parseInt(values[1]));

									}

									Show();
									temp.setVisible(false);
									contentPane.getParent().repaint();
									temp.setVisible(true);

								}
							}

						} catch (Exception e1) {

						}
					}
					temp.clearSelection();
				}

				@Override
				public void mouseExited(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseEntered(MouseEvent e) {
					// TODO Auto-generated method stub

				}

				@Override
				public void mouseClicked(MouseEvent e) {
					// TODO Auto-generated method stub

				}
			});

		}

	}

	public void Show() {

		try {
			PC_In_UseDAO dao = PC_In_UseDAO.getInstance();

			ArrayList<PC_In_Use_View> list = dao.selectAll();

			for (int i = 0; i < list.size(); i++) {
				comList[i].removeAll();
				v[i].removeAllElements();
				PC_In_Use_View tmp = list.get(i);
				v[i].add("No." + tmp.getNo());
				int h, m;

				if (tmp.getC_status() != null) {
					v[i].add(tmp.getC_status());
					for (int j = 0; j < 4; j++) {
						v[i].add("");
					}
				} else {

					v[i].add(tmp.getId());

					v[i].add(tmp.getType());
					if (tmp.getS_time() != null)
						v[i].add("시작시간:" + tmp.getS_time());
					else
						v[i].add("");

					if (tmp.getType() != null) {
						if (tmp.getType().equals("후불")) {
							if (tmp.getP_time() != 0)
								m = tmp.getP_time();
							else
								m = 0;
							v[i].add("사용시간:" + m);
						} else {
							h = tmp.getP_time() / 60;
							m = tmp.getP_time() % 60;
							v[i].add("남은시간:" + h + ":" + m);
						}
					} else
						v[i].add("");
					if (tmp.getS_price() != 0)
						v[i].add("결제금액:" + tmp.getS_price());
					else
						v[i].add("");
				}
				if (tmp.getStatus() != null)
					switch ((tmp.getStatus())) {
					case "WAIT":
						comList[i].setBackground(Color.BLUE);
						comList[i].setForeground(Color.WHITE);
						break;
					case "USE":
						comList[i].setBackground(Color.GREEN);
						comList[i].setForeground(Color.BLACK);
						break;

					}
				else {
					comList[i].setBackground(Color.WHITE);
					comList[i].setForeground(Color.BLACK);
				}
				if (tmp.getC_status() != null) {
					comList[i].setBackground(Color.RED);
					comList[i].setForeground(Color.WHITE);
				}

			}

		} catch (Exception e1) {
			System.out.println("SHOW");
			e1.printStackTrace();
		}
	}

	private class InsertUsePC extends JDialog {
		private JPanel contentPane;
		private JTextField tfId;
		private String[] types = { "후불", "선불" };
		private JTextField tfH;
		private JTextField tfM;
		private JComboBox cbType;
		private int no, price;

		public InsertUsePC(JFrame frame, int no, int price) {

			super(frame, "No." + no);
			this.no = no;
			this.price = price;
			addWindowListener(new WindowAdapter() {
				public void windowClosing(WindowEvent evt) {
					dispose();
				}
			});
		}

		public void setting() {
			setTitle("No." + no);
			setBounds(100, 100, 166, 195);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			setContentPane(contentPane);
			contentPane.setLayout(null);

			tfId = new JTextField("GUEST");
			tfId.setBounds(10, 10, 115, 25);
			tfId.setName("GUEST");
			contentPane.add(tfId);
			tfId.setColumns(10);
			tfId.addFocusListener(new tfFocusListener());

			cbType = new JComboBox(types);
			cbType.setBounds(10, 41, 60, 25);
			contentPane.add(cbType);

			tfH = new JTextField();
			tfH.setBounds(10, 72, 60, 25);
			tfH.setText("\uC2DC\uAC04");
			contentPane.add(tfH);
			tfH.setColumns(5);
			tfH.setName("시간");
			tfH.addFocusListener(new tfFocusListener());

			tfM = new JTextField();
			tfM.setBounds(77, 72, 60, 25);
			tfM.setText("\uBD84");
			contentPane.add(tfM);
			tfM.setColumns(5);
			tfM.setName("분");
			tfM.addFocusListener(new tfFocusListener());

			tfH.setEnabled(false);
			tfM.setEnabled(false);

			cbType.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					if (cbType.getSelectedIndex() == 0) {
						tfH.setEnabled(false);
						tfM.setEnabled(false);
					} else {
						tfH.setEnabled(true);
						tfM.setEnabled(true);
					}
				}
			});
			JButton btnConfirm = new JButton("\uD655\uC778");
			btnConfirm.setBounds(10, 103, 60, 25);
			contentPane.add(btnConfirm);
			btnConfirm.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {

					PC_In_Use input = new PC_In_Use();
					input.setId(tfId.getText());
					input.setC_no(no);
					input.setType((String) cbType.getSelectedItem());
					String type = "";

					if (input.getType().equals("후불")) {
						type = "후불";
						input.setP_time(0);
						input.setS_price(0);
					} else {
						type = "선불";
						input.setP_time(Integer.parseInt(tfH.getText()) * 60 + Integer.parseInt(tfM.getText()));
						input.setS_price(((input.getP_time() / 60) * price) + ((input.getP_time() % 60) * price / 60));
					}

					try {

						PC_In_UseDAO dao = PC_In_UseDAO.getInstance();
						int n = dao.insertPc_in_use(input);
						if (n == -1) {
							JOptionPane.showMessageDialog(null, "입력실패", "Error", JOptionPane.ERROR_MESSAGE);
						}
						server.send_C(no + "@" + input.getId() + "@" + type + "@" + input.getP_time() + "@"
								+ input.getS_price());
						Show();
						time_th[no - 1] = new TimeThread(no - 1);
						time_th[no - 1].start();

					} catch (Exception e1) {
						e1.printStackTrace();
						JOptionPane.showMessageDialog(null, e1.toString(), "Error", JOptionPane.ERROR_MESSAGE);
					} finally {
						dispose();
					}
				}
			});

			JButton btnCancle = new JButton("\uCDE8\uC18C");
			btnCancle.setBounds(77, 103, 60, 25);
			contentPane.add(btnCancle);
			btnCancle.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					dispose();

				}
			});

			setVisible(true);
		}

		class tfFocusListener implements FocusListener {

			@Override
			public void focusGained(FocusEvent e) {
				JTextField tmp = (JTextField) e.getSource();
				tmp.setText("");

			}

			@Override
			public void focusLost(FocusEvent e) {
				JTextField tmp = (JTextField) e.getSource();
				if (tmp.getText().equals(""))
					tmp.setText(tmp.getName());
			}

		}
	}

	class TimeThread extends Thread {
		private int n;
		private int time;

		public TimeThread(int n) {
			this.n = n;
		}
		@Override
		public void run() {

			if (v[n].get(2).equals("후"
					+ "불")) {
				time = 0;
				while (true) {
					v[n].set(4, "사용시간 : " + time++);
					comList[n].setVisible(false);
					comList[n].setVisible(true);

					try {
						Thread.sleep(1000);

					} catch (InterruptedException e) {
						return;
					}
				}
			} else {
				String[] values = v[n].get(4).split(":");

				time = Integer.parseInt(values[1]) * 60 + Integer.parseInt(values[2]);
				while (true) {
					if (time != 0) {
						v[n].set(4, "사용시간 : " + time--);
						comList[n].setVisible(false);
						comList[n].setVisible(true);
					} else {

						PC_In_UseDAO dao = PC_In_UseDAO.getInstance();
						dao.DonePc_in_use(n + 1);
						Show();
						return;
					}
					try {
						Thread.sleep(1000);

					} catch (InterruptedException e) {
						return;
					}

				}
			}
		}

		public int getTime() {
			return time;
		}

	}

	public void Message() {

	}

	public void Start(int no, String id) {
		id = id.trim();
		PC_In_Use input = new PC_In_Use();
		input.setId(id);
		input.setC_no(no);
		input.setType("후불");
		input.setP_time(0);
		input.setS_price(0);
		try {
			PC_In_UseDAO dao1 = PC_In_UseDAO.getInstance();
			int n = dao1.insertPc_in_use(input);
			if (n == -1) {
				JOptionPane.showMessageDialog(null, "입력실패", "Error", JOptionPane.ERROR_MESSAGE);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		Show();
		time_th[no - 1] = new TimeThread(no - 1);
		time_th[no - 1].start();

	}

	public void Close(int no) {
		int time = 0;
		time = time_th[no - 1].getTime();
		time_th[no - 1].interrupt();

		PC_In_UseDAO dao3 = PC_In_UseDAO.getInstance();

		int after_price = (price * (time / 60)) + ((int) Math.ceil(price / 60) * time % 60);
		dao3.WaitPc_in_use(no, time, after_price);

		Show();
	}

	public void Purchase(String data) {
		PurchaseThread Purchase = new PurchaseThread(data);
		Purchase.start();
	}

	class PurchaseThread extends Thread {
		String data;

		PurchaseThread(String data) {
			this.data = data;
		}

		@Override
		public void run() {
			String values[] = data.split("@");
			String order = "";
			ProductDAO dao=ProductDAO.getInstance();
			for (int i = 3; i < values.length-1; i += 2) {
				String name=dao.SearchP_name(Integer.parseInt(values[i].toString()));
				order +=  name + " " + values[i + 1] + "개\n";
			}
			JOptionPane.showMessageDialog(null, "No." + values[1] + " 번에서 구매\n" + order+"총 "+values[values.length-1], "No." + values[1],
					JOptionPane.INFORMATION_MESSAGE, null);

		}
	}

	public void Call(int no) {
		CallThread call = new CallThread(no);
		call.start();
	}

	class CallThread extends Thread {
		int no;

		CallThread(int no) {
			this.no = no;
		}

		@Override
		public void run() {
			JOptionPane.showMessageDialog(null, "No." + no + " 번에서 호출", "No." + no, JOptionPane.INFORMATION_MESSAGE,
					null);

		}
	}

	public void setChat(int no) {
		ChatThread cth = new ChatThread(no);
		cth.start();
		server.send_C(no + "@MESSAGE");

	}

	class ChatThread extends Thread {

		int no;

		ChatThread(int no) {
			this.no = no;
		}

		@Override
		public void run() {
			new Server_Chat(port,no);

		}
	}

	public class Server_Chat extends JDialog implements ActionListener {

		private JPanel contentPane;
		private JTextField TF;
		private Receiver TA;
		private BufferedReader in = null;
		private BufferedWriter out = null;
		private ServerSocket listener = null;
		private Socket socket = null;
		private int port;
		private int no;

		public Server_Chat(int port,int no) {
			this.port = port+no;
			this.no=no;
			System.out.println(this.port);
			setTitle("No."+no);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);

			TA = new Receiver();
			JScrollPane sp = new JScrollPane(TA);
			contentPane.add(sp, BorderLayout.CENTER);
			TA.setEditable(false);

			TF = new JTextField();
			contentPane.add(TF, BorderLayout.SOUTH);
			TF.setColumns(10);
			TF.addActionListener(this);
			setVisible(true);
			try {
				setupConnection();
			} catch (Exception e) {
				handleError(e.getMessage());
			}
			Thread th = new Thread(TA);
			th.start();
		}

		@Override
		public void actionPerformed(ActionEvent e) {
			if (e.getSource() == TF) {
				String msg = TF.getText();
				try {
					out.write(msg + "\n");
					out.flush();
					TA.append("\n관리자 : " + msg);
					int pos = TA.getText().length();
					TA.setCaretPosition(pos);
					TF.setText("");
				} catch (IOException e1) {
					handleError(e1.getMessage());
				}
			}
		}

		private void setupConnection() throws IOException {

			listener = new ServerSocket(port);
			socket = listener.accept();
			TA.append("클라이언트 연결 완료");
			int pos = TA.getText().length();
			TA.setCaretPosition(pos);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		}

		private void handleError(String str) {
			System.out.println(str);
			System.out.println(1);
		}

		private class Receiver extends JTextArea implements Runnable {

			@Override
			public void run() {
				String msg = null;
				while (true) {
					try {
						msg = in.readLine();
						if (msg.equals("CLOSE")) {
							System.out.println("클라이언트 요청으로 연결 종료");
							socket.close();
							listener.close();
							TA.append("종료");
							dispose();
						}

					} catch (IOException e) {
						handleError(e.getMessage());
					}
					TA.append("\nNo."+no+" : " + msg);
					int pos = this.getText().length();
					TA.setCaretPosition(pos);

				}
			}
		}
	}
}
