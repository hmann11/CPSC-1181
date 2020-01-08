import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class BankClient {
	private int account;
	private int balance;

	public void handleFail() {
		int account = this.conection.readInt();
		System.out.println("Account " + account + " does not have enough funds.");
	}

	public void handleSucess() {
		int account = this.connection.readInt();
		double balance = this.connection.readDouble();
		System.out.println("Account " + account + " = " + balance);
	}

	public void sendWithdraw(int account, double amount) {
		connection.writeInt(BanckProtocol.WITHDRAW);
		connection.writeInt(account);
		connection.writeDouble(amount);
	}

	public void sendDeposit(int account, double amount) {
	}

	public void startClient() throws IOException{
		try {
			this.connection=new Connection(new Socket("localhost",BankServer.port));
			while(!this.isQuit) {
				String cmd =this.input.nextCommand();
				Scanner lineScanner= new Scanner(cmd);
				if(lineScanner.hasNext("withdraw")) {
					lineScanner.next();
					this.sendWithdraw(lineScanner.nextInt(), lineScanner.nextDouble());
				}else if(lineScanner.hasNext("deposit")) {
					lineScanner.next();
					this.sendDeposit(lineScanner.nextInt(), lineScanner.nextDouble());
				}else if(lineScanner.hasNext("quit")) {
					this.quit();
					continue;
				}
			}
		}
	}
}
