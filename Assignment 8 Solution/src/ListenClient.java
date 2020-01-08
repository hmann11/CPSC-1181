import java.io.IOException;

public class ListenClient extends Client {
  private Connection connection;

  public void handleMessage() throws IOException {
    String who = this.connection.readUTF();
    String message = this.connection.readUTF();
    this.print(new Message(who, message));
  }

  private void print(Message message) {
    System.out.println(message.toString());
  }

  public void startClient() throws IOException {
    this.connection = new Connection(this.connect());
    this.connection.writeInt(ChatroomProtocol.LISTEN);

    while (true) {
      int command = this.connection.readInt();
      switch (command) {
        case ChatroomProtocol.MESSAGE:
          this.handleMessage();
          break;
      }
    }
  }

  public static void main(String[] args) throws IOException {
    new ListenClient().startClient();
  }
}
