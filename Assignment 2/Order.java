
/**
 * @author hmann11
 * This is the object Order, it is the bundle of all the lineItems or Products the a user has added to their cart.
 * 
 * @param lineItems is the ArrayList the stores the lineItem objects inside itself.
 */
import java.util.ArrayList;

public class Order {
	private ArrayList<LineItem> lineItems;

// Default Constructor.
	public Order() {
		this.lineItems = new ArrayList<LineItem>();
	}
	/*
	 * This method adds a lineItem to the array depending on a few conditions. If a
	 * product is already present in the array then it deletes the entry already
	 * present in the array and adds the new details passed to the method. If their
	 * is no matching product then a new lineItem is created from the details
	 * provided.
	 */

	public void addLineItem(String productName, long quantity, double unitPrice) {
		LineItemPresentHandle(productName, quantity, unitPrice);
	}

	/*
	 * This method is the same as the previous method but goes into action when only
	 * the product name and unit price is passed to the class. It assumes that the
	 * quantity is 1;
	 */
	public void addLineItem(String productName, double unitPrice) {
		long quantity = 1;
		LineItemPresentHandle(productName, quantity, unitPrice);
	}

	/*
	 * Looks for a given product name in the array and removes it if it's found.
	 */
	public void removeLineItem(String productName) {
		int position = findPosition(productName);
		if (position != -1) {
			this.lineItems.remove(position);
		}
	}

	/*
	 * This method passes the entire array of lineItems. Usually used for printing.
	 * 
	 * @return returns the complete order in the form of a Array of Line Items.
	 */
	public LineItem[] getAllLineItems() {
		return this.lineItems.toArray(new LineItem[0]);
	}

	/*
	 * This methods matches the product names of a lineItem to a given string of
	 * characters and returns the position of the line item if present.
	 * 
	 * @param positionOfTarget stores the location of the target string in the
	 * lineItems array.
	 * 
	 * @return returns the position of the target string in the lineItems ArrayList.
	 */
	private int findPosition(String target) {
		int positionOfTarget = -1;
		for (int i = 0; i < this.lineItems.size(); i++) {
			LineItem current = this.lineItems.get(i);
			if (current.getProductName().equals(target)) {
				positionOfTarget = i;
			}
		}
		return positionOfTarget;
	}

	/*
	 * This method handles logic for adding a line item, it takes in the same
	 * details from both the add line item methods above. Then this method checks if
	 * the product is already present in the list and adds the new values
	 * accordingly.
	 * 
	 * @param position stores the position of a already existing product if their is
	 * one.
	 */
	private void LineItemPresentHandle(String productName, long quantity, double unitPrice) {
		int position = findPosition(productName);
		if (position != -1) {
			this.lineItems.remove(position);
			LineItem newItem = new LineItem(productName, quantity, unitPrice);
			this.lineItems.add(newItem);
		} else {
			LineItem newItem = new LineItem(productName, quantity, unitPrice);
			this.lineItems.add(newItem);
		}

	}
}
