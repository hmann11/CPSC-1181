/**
 * 
 * @author hmann11
 * 
 *         This creates an object called Invoice which is used to organize the
 *         date required to print a invoice.
 * 
 * @param totalNumberOfLineItems
 * @param totalQuantity
 * @param totalPrice
 * @param totalTax
 *
 */
public class Invoice {
	private long totalNumberOfLineItems;
	private long totalQuantity;
	private double totalPrice;
	private double totalTax;

	/*
	 * This methods saves the various values required to print out the desired structure of the invoice.
	 */
	public Invoice(long totalNumberOfLineItems, long totalQuantity, double totalPrice, double totalTax) {
		this.totalNumberOfLineItems = totalNumberOfLineItems;
		this.totalQuantity = totalQuantity;
		this.totalPrice = totalPrice;
		this.totalTax = totalTax;
	}

	/*
	 * @return returns the total number of line items in the invoice.
	 */
	public long getTotalofLineItems() {
		return totalNumberOfLineItems;

	}

	/*
	 * @return returns the total quantity of items in the invoice
	 */
	public long getTotalQuantity() {
		return totalQuantity;

	}

	/*
	 * @return returns the total price of all the items in the invoice.
	 */
	public double getTotalPrice() {
		return totalPrice;
	}

	/*
	 * @return returns the total amount of tax on the items in the invoice.
	 */
	public double getTotalTax() {
		return totalTax;
	}
}
