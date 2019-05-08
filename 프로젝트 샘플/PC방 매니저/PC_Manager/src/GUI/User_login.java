package GUI;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;

import DAO.PC_In_UseDAO;
import GUI.User_login.ChatListenerThread;

public class User_login extends JFrame {
	private JPanel contentPane;
	private int time = 0;

	private JLabel lblP_Time, lblPrice, lblId, lblS_Time;
	private String id;
	private int no;
	private int port = 8000;
	private boolean type;
	Client client;
	login login;
	User_login user_login;
	TimeThread time_th;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					// User_login frame = new User_login();
					// frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */

	public User_login(int no, login login) {

		this.no = no;
		this.login = login;
		this.user_login = this;
		try {

			if (type) {
				PC_In_UseDAO dao = PC_In_UseDAO.getInstance();
				time = dao.getTime(no, id);
			}

		} catch (Exception e2) {
			// TODO Auto-generated catch block
			e2.printStackTrace();
		}

		setTitle("No." + no);
		setBounds(100, 100, 550, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(new BorderLayout(0, 0));

		JPanel titlePanel = new JPanel();
		titlePanel.setBackground(Color.DARK_GRAY);
		contentPane.add(titlePanel, BorderLayout.NORTH);
		titlePanel.setLayout(new GridLayout(1, 2));

		JLabel lblNo = new JLabel("No." + no);
		lblNo.setFont(new Font("±¼¸²", Font.BOLD, 14));
		lblNo.setForeground(Color.WHITE);
		lblNo.setHorizontalAlignment(SwingConstants.CENTER);
		titlePanel.add(lblNo);

		JPanel btnPanel = new JPanel();
		contentPane.add(btnPanel, BorderLayout.SOUTH);
		btnPanel.setLayout(new GridLayout(2, 2));

		JPanel btnPanel1 = new JPanel();
		btnPanel.add(btnPanel1);
		btnPanel1.setLayout(new GridLayout(1, 2, 0, 0));

		JButton btnOrder = new JButton("\uC0C1\uD488/\uBA39\uAC70\uB9AC\uC8FC\uBB38");
		btnPanel1.add(btnOrder);
		btnOrder.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new Purchase_Product(no,id,client);

			}
		});

		JButton btnLogout = new JButton("\uB85C\uADF8\uC544\uC6C3");
		btnPanel1.add(btnLogout);
		btnLogout.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					client.send("CLOSE@" + no);
					time_th.interrupt();
					login.setVisible(true);
					user_login.setVisible(false);

				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});

		JPanel btnPanel2 = new JPanel();
		btnPanel.add(btnPanel2);
		btnPanel2.setLayout(new GridLayout(1, 3, 0, 0));

		JButton btnInfo = new JButton("\uD68C\uC6D0\uC815\uBCF4");
		btnPanel2.add(btnInfo);
		btnInfo.setVerticalAlignment(SwingConstants.BOTTOM);
		btnInfo.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				new User_Info(id);

			}
		});
		JButton btnMessage = new JButton("\uBA54\uC138\uC9C0");
		btnPanel2.add(btnMessage);
		btnMessage.setVerticalAlignment(SwingConstants.BOTTOM);
		btnMessage.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					client.send("MESSAGE@" + no);

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});
		JButton btnCall = new JButton("\uD638\uCD9C");
		btnPanel2.add(btnCall);
		btnCall.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {

				try {
					client.send("CALL@" + no);

				} catch (Exception e1) {

					e1.printStackTrace();
				}

			}
		});

		JPanel MainPanel = new JPanel();
		MainPanel.setBackground(Color.DARK_GRAY);
		contentPane.add(MainPanel, BorderLayout.CENTER);
		MainPanel.setLayout(new BorderLayout(0, 0));

		JPanel InfoPanel = new JPanel();
		InfoPanel.setBackground(Color.DARK_GRAY);
		MainPanel.add(InfoPanel, BorderLayout.CENTER);
		InfoPanel.setLayout(null);

		JLabel lbl1 = new JLabel("\uC544  \uC774  \uB514 : ");
		lbl1.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl1.setBounds(83, 25, 80, 40);
		lbl1.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lbl1.setForeground(Color.WHITE);
		InfoPanel.add(lbl1);

		lblId = new JLabel(id);
		lblId.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblId.setForeground(Color.WHITE);
		lblId.setHorizontalAlignment(SwingConstants.LEFT);
		lblId.setBounds(164, 25, 150, 40);
		InfoPanel.add(lblId);

		JLabel lbl2 = new JLabel("\uC0AC\uC6A9 \uC694\uAE08 : ");
		lbl2.setHorizontalAlignment(SwingConstants.RIGHT);
		lbl2.setBounds(83, 64, 80, 40);
		lbl2.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lbl2.setForeground(Color.WHITE);
		InfoPanel.add(lbl2);

		lblPrice = new JLabel("TEST");
		lblPrice.setHorizontalAlignment(SwingConstants.LEFT);
		lblPrice.setForeground(Color.WHITE);
		lblPrice.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblPrice.setBounds(164, 64, 150, 40);
		InfoPanel.add(lblPrice);

		JLabel label_4 = new JLabel("\uC2DC\uC791 \uC2DC\uAC04 : ");
		label_4.setHorizontalAlignment(SwingConstants.RIGHT);
		label_4.setBounds(83, 106, 80, 40);
		label_4.setForeground(Color.WHITE);
		label_4.setFont(new Font("±¼¸²", Font.BOLD, 12));
		InfoPanel.add(label_4);

		lblS_Time = new JLabel("TEST");
		lblS_Time.setHorizontalAlignment(SwingConstants.LEFT);
		lblS_Time.setForeground(Color.WHITE);
		lblS_Time.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblS_Time.setBounds(164, 106, 150, 40);
		InfoPanel.add(lblS_Time);

		JLabel label_5 = new JLabel("\uC0AC\uC6A9 \uC2DC\uAC04 : ");
		label_5.setHorizontalAlignment(SwingConstants.RIGHT);
		label_5.setBounds(293, 106, 80, 40);
		label_5.setFont(new Font("±¼¸²", Font.BOLD, 12));
		label_5.setForeground(Color.WHITE);
		InfoPanel.add(label_5);

		lblP_Time = new JLabel("TEST");
		lblP_Time.setHorizontalAlignment(SwingConstants.LEFT);
		lblP_Time.setForeground(Color.WHITE);
		lblP_Time.setFont(new Font("±¼¸²", Font.BOLD, 12));
		lblP_Time.setBounds(373, 106, 150, 40);
		InfoPanel.add(lblP_Time);

		// time_th.start();
		setVisible(false);

	}

	public void start(String id, boolean type, int time, int price) {

		this.id = id;
		this.type = type;

		long start_time = System.currentTimeMillis();
		SimpleDateFormat dayTime = new SimpleDateFormat("hh:mm");
		String str = dayTime.format(new Date(start_time));

		lblS_Time.setText(str);

		lblId.setText(id);

		if (!type) {
			lblPrice.setText("ÈÄºÒ");
			this.time = 0;
		} else {
			lblPrice.setText("¼±ºÒ : " + price + "¿ø");
			this.time = time;
		}

		try {
			time_th = new TimeThread();
			time_th.start();
		} catch (Exception e) {

			e.printStackTrace();
		}

	}

	public void close() {
		time_th.interrupt();
		login.setVisible(true);
		user_login.setVisible(false);
	}

	public void setClient(Client client) {
		this.client = client;
	}

	class TimeThread extends Thread {

		public TimeThread() throws IOException {

		}

		@Override
		public void run() {
			try {

				if (!type) {

					while (true) {
						sleep(1000);
						lblP_Time.setText("" + time++);
					}
				} else {

					while (true) {
						sleep(1000);
						lblP_Time.setText("" + time--);
						if (time == 0) {
							client.send("CLOSE@" + no);
							time_th.interrupt();
							login.setVisible(true);
							user_login.setVisible(false);
						}
					}
				}
			} catch (InterruptedException e) {
				return;
			}

		}
	}

	public void setChat() {
		ChatListenerThread ch;
		try {
			ch = new ChatListenerThread();
			ch.start();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	class ChatListenerThread extends Thread {

		public ChatListenerThread() throws IOException {

		}

		@Override
		public void run() {
			try {
				sleep(100);
				new Client_Chat(port + no);

			} catch (Exception e1) {
				e1.printStackTrace();
			}

		}

	}

	public class Client_Chat extends JDialog implements ActionListener {

		private JPanel contentPane;
		private JTextField TF;
		private Receiver TA;
		private BufferedReader in = null;
		private BufferedWriter out = null;
		private Socket socket = null;
		private JPanel panel;
		private JButton btnClose;
		private int port;

		public Client_Chat(int port) {
			this.port = port;
			System.out.println(this.port);
			setTitle("Ã¤ÆÃ");
			setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
			setBounds(100, 100, 450, 300);
			contentPane = new JPanel();
			contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
			contentPane.setLayout(new BorderLayout(0, 0));
			setContentPane(contentPane);

			TA = new Receiver();
			JScrollPane sp = new JScrollPane(TA);
			contentPane.add(sp, BorderLayout.CENTER);
			TA.setEditable(false);

			panel = new JPanel();
			contentPane.add(panel, BorderLayout.SOUTH);

			TF = new JTextField();
			panel.add(TF);
			TF.setColumns(30);

			btnClose = new JButton("\uB2EB\uAE30");
			panel.add(btnClose);
			btnClose.addActionListener(new ActionListener() {

				@Override
				public void actionPerformed(ActionEvent e) {
					// TODO Auto-generated method stub
					try {
						out.write("CLOSE" + "\n");
						out.flush();
						dispose();
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}
			});
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
					TA.append("\nNo."+no+" : " + msg);
					int pos = TA.getText().length();
					TA.setCaretPosition(pos);
					TF.setText("");
				} catch (IOException e1) {
					handleError(e1.getMessage());
				}
			}
		}

		private void setupConnection() throws IOException {

			socket = new Socket("192.168.0.38", port);
			TA.append("¼­¹ö ¿¬°á ¿Ï·á");
			int pos = TA.getText().length();
			TA.setCaretPosition(pos);
			in = new BufferedReader(new InputStreamReader(socket.getInputStream()));
			out = new BufferedWriter(new OutputStreamWriter(socket.getOutputStream()));

		}

		private void handleError(String str) {

		}

		private class Receiver extends JTextArea implements Runnable {

			@Override
			public void run() {
				String msg = null;
				while (true) {
					try {
						msg = in.readLine();
					} catch (IOException e) {
						handleError(e.getMessage());
						e.printStackTrace();
					}
					TA.append("\n°ü¸®ÀÚ : " + msg);
					int pos = this.getText().length();
					TA.setCaretPosition(pos);

				}
			}
		}
	}

}
