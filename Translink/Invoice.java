
public class Invoice {
	private String owner;
	private double balance;
	public Invoice(String owner) {
		this.owner=owner;
		balance=0;
	}
	
	public void addCharge(double amount) {
		this.balance+=amount;
	}
	
	public String getOwner() {
		return this.owner;
	}
	
	public String getformattedInvoice() {
		return "Invoice("+this.owner
	}
}
