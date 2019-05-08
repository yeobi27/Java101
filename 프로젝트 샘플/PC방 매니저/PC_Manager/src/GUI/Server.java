package GUI;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.Vector;

import javax.swing.JOptionPane;

public class Server {
	MainFrame main;
	Selector selector;
	ServerSocketChannel serverSocketChannel;
	List<Client> connections = new Vector<Client>();
	final int port = 8000;

	public Server(MainFrame main) {
		this.main = main;
		this.startServer();
	}

	void startServer() {
		try {
			selector = Selector.open();
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.configureBlocking(false);
			serverSocketChannel.bind(new InetSocketAddress(port));
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
		} catch (Exception e) {
			e.printStackTrace();
			if (serverSocketChannel.isOpen()) {
				stopServer();
			}
			return;
		}

		Thread thread = new Thread() {
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
							if (selectionKey.isAcceptable()) {
								accept(selectionKey);
							} else if (selectionKey.isReadable()) {
								Client client = (Client) selectionKey.attachment();
								client.receive(selectionKey);
							} else if (selectionKey.isWritable()) {
								Client client = (Client) selectionKey.attachment();
								client.send(selectionKey);
							}
							iterator.remove();
						}
					} catch (Exception e) {
						if (serverSocketChannel.isOpen()) {
							stopServer();
						}
						break;
					}
				}
			}
		};
		thread.start();

	}

	void send_C(String data) {
		for (Client client : connections) {
			client.sendData = data;
			SelectionKey key = client.socketChannel.keyFor(selector);
			key.interestOps(SelectionKey.OP_WRITE);
		}
		selector.wakeup();
	}

	void stopServer() {
		try {
			Iterator<Client> iterator = connections.iterator();
			while (iterator.hasNext()) {
				Client client = iterator.next();
				client.socketChannel.close();
				iterator.remove();
			}
			if (serverSocketChannel != null && serverSocketChannel.isOpen()) {
				serverSocketChannel.close();
			}
			if (selector != null && selector.isOpen()) {
				selector.close();
			}

		} catch (Exception e) {
		}
	}

	void accept(SelectionKey selectionKey) {
		try {
			ServerSocketChannel serverSocketChannel = (ServerSocketChannel) selectionKey.channel();
			SocketChannel socketChannel = serverSocketChannel.accept();

			Client client = new Client(socketChannel);
			connections.add(client);
		} catch (Exception e) {
			if (serverSocketChannel.isOpen()) {
				stopServer();
			}
		}
	}

	/*
	 * void send(String data) { Charset charset = Charset.forName("UTF-8");
	 * ByteBuffer byteBuffer = charset.encode(data); SelectionKey key =
	 * socketChannel.keyFor(selector); key.attach(byteBuffer);
	 * key.interestOps(SelectionKey.OP_WRITE); selector.wakeup(); }
	 */
	class Client {
		SocketChannel socketChannel;
		String sendData;

		Client(SocketChannel socketChannel) throws IOException {
			this.socketChannel = socketChannel;
			socketChannel.configureBlocking(false);
			SelectionKey selectionKey = socketChannel.register(selector, SelectionKey.OP_READ);
			selectionKey.attach(this);
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

				/*
				 * for (Client client : connections) { client.sendData = data; SelectionKey key
				 * = client.socketChannel.keyFor(selector);
				 * key.interestOps(SelectionKey.OP_WRITE); }
				 */

				selector.wakeup();
			} catch (Exception e) {
				try {
					connections.remove(this);

					socketChannel.close();
				} catch (IOException e2) {
				}
			}
		}

		void send(SelectionKey selectionKey) {
			try {
				Charset charset = Charset.forName("UTF-8");
				System.out.println(sendData);
				ByteBuffer byteBuffer = charset.encode(sendData);
				socketChannel.write(byteBuffer);
				selectionKey.interestOps(SelectionKey.OP_READ);
				selector.wakeup();
			} catch (Exception e) {
				try {

					connections.remove(this);
					socketChannel.close();
				} catch (IOException e2) {
				}
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
			//JOptionPane.showMessageDialog(null, data, "¼­¹ö", JOptionPane.ERROR_MESSAGE);
			switch (values[0]) {
			case "MESSAGE":
				main.setChat(Integer.parseInt(values[1]));
				break;
			case "CALL":
				main.Call(Integer.parseInt(values[1]));
				break;
			case "START":
				main.Start(Integer.parseInt(values[1]), values[2]);
				break;
			case "PURCHASE":
				main.Purchase(data);
				break;
			case "CLOSE":
				main.Close(Integer.parseInt(values[1]));
				break;
			}

		}
	}

}
