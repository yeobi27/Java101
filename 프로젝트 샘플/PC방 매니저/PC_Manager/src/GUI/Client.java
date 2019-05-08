package GUI;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.Set;

import javax.swing.JOptionPane;

public class Client extends Thread {
	private Selector selector;
	private SocketChannel socketChannel;
	private login login;
	private User_login user_login;

	public Client(login login, User_login user_login) {
		this.login = login;
		this.user_login = user_login;
		try {
			selector = Selector.open();
			socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
			socketChannel.connect(new InetSocketAddress("192.168.0.38", 8000));
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	@Override
	public void run() {

		while (true) {
			try {
				int keyCount = selector.select();
				if (keyCount == 0) {
					continue;
				}
				Set<SelectionKey> selectedKeys = selector.selectedKeys();
				Iterator<SelectionKey> iterator = selectedKeys.iterator();
				while (iterator.hasNext()) {
					SelectionKey selectionKey = iterator.next();
					if (selectionKey.isConnectable()) {
						connect(selectionKey);
					} else if (selectionKey.isReadable()) {
						receive(selectionKey);
					} else if (selectionKey.isWritable()) {
						send(selectionKey);
					}
					iterator.remove();

				}

			} catch (Exception e) {

			}
		}
	}

	void connect(SelectionKey selectionKey) {
		try {
			socketChannel.finishConnect();
			selectionKey.interestOps(SelectionKey.OP_READ);
		} catch (Exception e) {

		}
	}

	void receive(SelectionKey selectionKey) {
		try {
			ByteBuffer byteBuffer = ByteBuffer.allocate(100);

			int byteCount = socketChannel.read(byteBuffer);

			if (byteCount == -1) {
				throw new IOException();
			}

			byteBuffer.flip();
			Charset charset = Charset.forName("UTF-8");
			String data = charset.decode(byteBuffer).toString();
			Command(data);

		} catch (Exception e) {

		}
	}

	void send(SelectionKey selectionKey) {
		try {
			ByteBuffer byteBuffer = (ByteBuffer) selectionKey.attachment();
			socketChannel.write(byteBuffer);

			selectionKey.interestOps(SelectionKey.OP_READ);
		} catch (Exception e) {

		}
	}

	void send(String data) {
		Charset charset = Charset.forName("UTF-8");
		ByteBuffer byteBuffer = charset.encode(data);
		SelectionKey key = socketChannel.keyFor(selector);
		key.attach(byteBuffer);
		key.interestOps(SelectionKey.OP_WRITE);
		selector.wakeup();
	}

	void Command(String data) {
		String values[] = data.split("@");
		if (Integer.parseInt(values[0]) == login.getNo()) {
			if (login.isVisible()) {
				login.setVisible(false);
				user_login.setVisible(true);
				if (values[2].trim().equals("ÈÄºÒ")) {
					user_login.start(values[1].trim(), false, Integer.parseInt(values[3]), Integer.parseInt(values[4]));
				} else {
					user_login.start(values[1].trim(), true, Integer.parseInt(values[3]), Integer.parseInt(values[4]));
				}
			} else {
				switch (values[1].trim()) {
				case "CLOSE":
					user_login.close();
					break;
				case "MESSAGE":
					user_login.setChat();
					break;
				}
			}

		}

	}
}