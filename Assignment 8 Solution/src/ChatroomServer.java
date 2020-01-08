import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class ChatroomServer {
  public final static int PORT = 46464;

  private Chatroom chatroom;

  public ChatroomServer(Chatroom chatroom) {
    this.chatroom = chatroom;
  }

  public void startServer() throws IOException {
    try (ServerSocket serverSocket = new ServerSocket(PORT)) {
      while (true) {
        Socket s = serverSocket.accept();
        new Thread(new ChatroomWorker(s, chatroom)).start();
      }
    }
  }

  public static void main(String[] args) throws IOException {
    new ChatroomServer(new Chatroom()).startServer();
  }
}
