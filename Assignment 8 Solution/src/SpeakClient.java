import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class SpeakClient extends Client {
  private Connection connection;

  private void sendMessage(Message message) throws IOException {
    this.connection.writeInt(ChatroomProtocol.MESSAGE);
    this.connection.writeUTF(message.getWho());
    this.connection.writeUTF(message.getMessage());
  }

  public void startClient(String who) throws IOException {
    Socket s = this.connect();
    this.connection = new Connection(s);
    this.connection.writeInt(ChatroomProtocol.SPEAK);

    Scanner scanner = new Scanner(System.in);

    while(true) {
      System.out.print(who + " -> ");
      String text = scanner.nextLine();
      this.sendMessage(new Message(who, text));
    }
  }

  public static void main(String[] args) throws IOException {
    new SpeakClient().startClient(args[0]);
  }
}
