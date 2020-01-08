import java.io.IOException;

public class BankWorker implements Runnable {
	public void handleWithdraw() {
	}

	public void handleDeposit() {
	}

	public void sendFail(int account) {
	}

	public void sendSuccess(int account, double balance) {
	}

	@Override
	public void run() {
		try{
			while (true){
		
			int cmd=this.connection.readInt();
			switch(cmd) {
			case BankProtocol.WITHDRAW;
			this.handleWithdraw();
			break;
			case BankProtocol.DEPOSIT;
			this.handleDeposit();
			break;
			}
		}
		}catch(IOException e) {
			
		} finally {
			this.connection.close();
		}
}
}