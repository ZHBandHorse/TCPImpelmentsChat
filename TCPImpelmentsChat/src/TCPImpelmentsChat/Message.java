package TCPImpelmentsChat;

import java.io.Serializable;

public class Message implements Serializable{
	public static class MessageType{
		public static final int TO_SERVER = 1;
		public static final int TO_FIRENTDS = 2;
		public static final int TO_ALL = 3;
	}	
	
	int type;
	String content;
	
	public Message(int type,String content) {
		this.content = content;
		this.type = type;
	}

	@Override
	public String toString() {
		return "Message [type=" + type + ", content=" + content + "]";
	}
	
	
	
}
