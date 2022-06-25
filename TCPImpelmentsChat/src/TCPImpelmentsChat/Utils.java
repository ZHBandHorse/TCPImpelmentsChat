package TCPImpelmentsChat;

import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.Scanner;

public class Utils {

	public static Message readMsg(InputStream inputStream) throws Exception {
		ObjectInputStream ois = new ObjectInputStream(inputStream);
		Message message = (Message)ois.readObject();
		return message;
	}
	
	public static void writeMsg(OutputStream outputStream,Message message) throws Exception {
		ObjectOutputStream oos = new ObjectOutputStream(outputStream);
		oos.writeObject(message);
		oos.flush();
	}
	
	public static String getContent() {
		Scanner sc = new Scanner(System.in);
		return sc.nextLine();
	}
	
}
