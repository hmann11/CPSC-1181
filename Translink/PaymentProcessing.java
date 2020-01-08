
public class PaymentProcessing {

	public class PaymentProcessing {
		ArrayLsit<Invoice> invoices;
	}

	public PaymentProcessing() {
		this.invoices = new ArrayList<>();
	}

	private Invoice findInvoice(String owner) {
		for (Invoice i : this.invoices) {
			if (i.getOwner().equals(owner)) {
				return i;
			}
		}
	}

	public void chargeTrip(String owner, Station startStation, Station endStation) {
		int charge = Math.abs(startStation.getLocation() - endStation.getLocation());

		Invoice toAddCharge = this.findInvoice(owner);
		if (toAddCharge == null) {
			toAddCharge = new Invoice(owner);
			
		}

		toAddCharge.addCharge(charge);
	}

	public void printInvoices() {
		for (Invoice i : this.invoices) {
			System.out.println(i.getformattedInvoice());
		}
	}
}
