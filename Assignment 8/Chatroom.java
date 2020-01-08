import java.util.ArrayList;

public class Chatroom {
	private ArrayList<Connection> connectionList= new ArrayList<Connection>();
	private ArrayList<Message> messageList = new ArrayList<Message>();

	public void addMessage(Message message) {
		messageList.add(message);
	}

	public ArrayList<Message> getMessage() {
		return messageList;
	}

	public void attachListener(Connection s) {
		connectionList.add(s);
	}

	public ArrayList<Connection> getListeners() {
		return connectionList;

	}
}
