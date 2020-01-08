import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ListenClient extends Thread {
	private boolean isQuit=false;
	private Socket socket;
	public Connection connection;
	private Scanner in;
	
	public static void main(String[] args)throws IOException{
		String host="localhost";
		int port= ChatServer.port;
		try(
				Socket socket=new Socket(host,port)){
			new ListenClient(socket).startClient();
		}
	}
	
	public ListenClient(Socket socket) throws IOException {
		this.connection=new Connection(socket);
		
	}
	
	public void startClient() throws IOException {
		
		while(true) {
			this.handleMessage();
		}
	}
	public void handleMessage() {
		connection.writeMessage(m);
	}
}
