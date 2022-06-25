package TCPImpelmentsChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {

	public static void startServer(int port) throws Exception {
		ServerSocket server = new ServerSocket();
		server.bind(new InetSocketAddress(port));
		Socket accept = server.accept();
		String content = " ";
				
		InputStream input = accept.getInputStream();		
		OutputStream output = accept.getOutputStream();
		
		while (!content.equals("exit")) {
			Message message = Utils.readMsg(input);
			System.out.println("服务端：\n"+message.content);
			
			System.out.println("客户端：");
			content = Utils.getContent();
			Message message2 = new Message(Message.MessageType.TO_FIRENTDS, content);
			Utils.writeMsg(output, message2);
		}
		output.close();
		input.close();
		server.close();
		
		
	}
}
