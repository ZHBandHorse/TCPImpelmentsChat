package TCPImpelmentsChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.Socket;


public class Client {

	public static void startClient(int port) throws Exception {
		Socket socket = new Socket();
		socket.connect(new InetSocketAddress(port));
		String content = " ";
		
		OutputStream output = socket.getOutputStream();
		InputStream input = socket.getInputStream();
		
		while (!content.equals("exit")) {
			System.out.println("服务端：");
			content = Utils.getContent();
			Message message = new Message(Message.MessageType.TO_SERVER, content);
			Utils.writeMsg(output, message);
			
			Message message2 = Utils.readMsg(input);
			System.out.println("客户端：\n"+message2.content);			
		}
		input.close();
		output.close();
		socket.close();
	}
}
