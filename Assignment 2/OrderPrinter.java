/**
 * 
 * @author hmann11
 *
 *         This class prints out the Order by accessing the bundle of line Items
 *         in the lineItems ArrayList.
 */

public class OrderPrinter {

	/*
	 * @param lineItems calls the Order method to get the list of lineItems that
	 * need to be printed and stores them.
	 * 
	 * The for loop iterates through the array and to print every lineItem with the
	 * appropriate formating
	 */
	public void print(Order order) {
		printHeader();
		LineItem[] lineItems = order.getAllLineItems();
		for (LineItem postion : lineItems) {
			System.out.printf("%-25s %-13s %s$\n", postion.getProductName(), postion.getQuantity(),
					postion.getUnitPrice());
		}
	}

	/*
	 * The printHeader method stores the headers for the table of contents that show
	 * the order.
	 * 
	 * @return returns null because it only prints out the order table header.
	 */
	private String printHeader() {

		System.out.printf("%-24s| %-10s| %s\n", "Product Name", "Quantitiy", "Unit Price");
		return null;
	}
}
