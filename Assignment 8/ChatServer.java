import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public class ChatServer {
	public static final int port = 46464;
	private static ServerSocket serverSocket;

	ArrayList<Connection> listeningClients = new ArrayList<>();
	ArrayList<Message> messageList=new ArrayList<>();

	public static void main(String[] args) throws IOException {
		Socket socket = null;
		try (ServerSocket serverSocket = new ServerSocket(port)) {
			while (true) {
				try {
					socket = serverSocket.accept();
				} catch (IOException e) {

				}
				new ListenClient(socket).startServer();
			}
		}
	}

	public void startServer() throws IOException {

	}
}
