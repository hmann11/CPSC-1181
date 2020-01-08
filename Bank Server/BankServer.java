import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class BankServer {
	private static final String bank = null;

	public void startServer() throws IOException{
		try(ServerSocket serverSocket=new ServerSocket()){
			while(true) {
				Socket s=serverSocket.accept();
				Runnable r= new BankWorker(this.bank,s);
				new Thread(r).start();
			}
		}
	}
}
