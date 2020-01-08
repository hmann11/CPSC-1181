import java.io.IOException;
import java.net.Socket;

public class ChatroomWorker implements Runnable {
  private Chatroom chatroom;
  private Connection connection;

  public ChatroomWorker(Socket s, Chatroom chatroom) throws IOException {
    this.connection = new Connection(s);
    this.chatroom = chatroom;
  }

  public void handleListen() throws IOException {
    for (Message m : this.chatroom.getMessages()) {
      this.connection.writeMessage(m);
    }
    this.chatroom.attachListener(this.connection);
  }

  private void broadcastMessage(Message m) {
    for (Connection c : this.chatroom.getListeners()) {
      try {
        c.writeMessage(m);
      } catch (Exception e) {
      }
    }
  }

  public void handleSpeak() throws IOException {
    try {
      while (true) {
        int command = this.connection.readInt();
        switch (command) {
          case ChatroomProtocol.MESSAGE:
            this.handleMessage();
            break;
        }
      }
    } finally {
      this.connection.close();
    }
  }

  public void handleMessage() throws IOException {
    String who = this.connection.readUTF();
    String message = this.connection.readUTF();
    Message m = new Message(who, message);
    this.chatroom.addMessage(m);
    this.broadcastMessage(m);
  }

  @Override
  public void run() {
    try {
      int command = this.connection.readInt();
      if (command == ChatroomProtocol.LISTEN) {
        this.handleListen();
      } else if (command == ChatroomProtocol.SPEAK) {
        this.handleSpeak();
      }
    } catch (Exception e) {
      // terminate connection
    }
  }
}
