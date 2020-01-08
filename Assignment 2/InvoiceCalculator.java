import java.util.ArrayList;

/**
 * This method gets all the information form the order and then creates an
 * invoice for that specific order.
 */
public class InvoiceCalculator {

	private ArrayList<Invoice> inv;
	private TaxCalculator tx;

	// This method hooks the calculator passed by the test2 method to the tax
	// calculator tx
	public InvoiceCalculator(TaxCalculator taxCalculator) {
		this.tx = taxCalculator;
	}

	// This method converts all the required items so that they are compatible with
	// storing them into the Invoice arrayList object.
	public Invoice generateInvoice(Order order) {
		this.inv = new ArrayList<Invoice>();
		LineItem[] LineItems = order.getAllLineItems();
		long totalQuantity = 0;
		double totalPrice = 0;
		long totNumItems = 0;
		for (LineItem i : LineItems) {
			double unitPrice = i.getUnitPrice();
			long quantity = i.getQuantity();
			totalQuantity += quantity;
			totalPrice += quantity * unitPrice;
			totNumItems++;
		}
	
		double totalTax = tx.calculateTax(order);
		System.out.println("Total Number of Products " + totNumItems);
		System.out.println("Total Quantity is " + totalQuantity);
		System.out.println("Total Price is " + totalPrice + "$");
		System.out.println("Total Tax "+ totalTax+"$");
		Invoice inve = new Invoice(totNumItems, totalQuantity, totalPrice, totalTax);
		this.inv.add(inve);
		return null;

	}
}