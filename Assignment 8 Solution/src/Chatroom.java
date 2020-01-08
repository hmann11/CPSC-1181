import java.net.Socket;
import java.util.ArrayList;

public class Chatroom {
  private ArrayList<Message> messages;
  private ArrayList<Connection> listeners;

  public Chatroom() {
    this.messages = new ArrayList<>();
    this.listeners = new ArrayList<>();
  }

  public void addMessage(Message message) {
    this.messages.add(message);
  }

  public ArrayList<Message> getMessages() {
    return new ArrayList<>(messages);
  }

  public void attachListener(Connection s) {
    this.listeners.add(s);
  }

  public ArrayList<Connection> getListeners() {
    return this.listeners;
  }
}
