/**
 * 
 * @author hmann11
 * 
 *         This method calculates the tax of a given order.
 * 
 * @param taxrate  stores the tax rate of the order which changes depending on
 *                 the number of items bought.
 * @param taxTotal stores the total amount of tax calculated.
 */
public class TaxCalculator {

	private double taxRate;
	private double taxTotal;

	// Default Constructor that change the taxRate value the 0.2% which is the
	// default amount.
	public TaxCalculator() {
		this.taxRate = 0.2;
	}

	// This method changes the taxRate if a custom taxRate is provided.
	public TaxCalculator(double taxingRate) {
		taxingRate=taxingRate/100;
		this.taxRate = taxingRate;
	}

	/*
	 * This method uses the taxRate initialized previously to calculate the amount
	 * of tax for a given order and removes the tax if there are more than 6 items
	 * in the order. It returns the totalTax of an order.
	 * 
	 * @return returns the total amount of tax on the items present in the order
	 * provided.
	 */
	public double calculateTax(Order order) {
		LineItem[] LineItems = order.getAllLineItems();
		if (LineItems.length > 6) {
			taxRate = 0;
			for (LineItem i : LineItems) {
				double unitPrice = i.getUnitPrice();
				long quantity = i.getQuantity();
				taxTotal += quantity * unitPrice * taxRate;
			}
		} else {
			for (LineItem i : LineItems) {
				double unitPrice = i.getUnitPrice();
				long quantity = i.getQuantity();
				taxTotal += quantity * unitPrice * taxRate;
			}

		}
		return taxTotal;
	}
}
