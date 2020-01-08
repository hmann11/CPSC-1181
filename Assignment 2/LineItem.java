/**
 * @author hmann11
 * 
 *         This class represents a item in a ArrayList. Its stores the 3 details
 *         of a product provided.
 * @param prodName  this parameter stores the Product Name of the item.
 * @param quantity  this parameter stores the Quantity of the item.
 * @param unitPrice this parameter stores the price of 1 unit of the item.
 */
public class LineItem {
	private String prodName;
	private long quantity;
	private double unitPrice;

	/*
	 * This class records the value for a given lineItem or product.
	 */
	public LineItem(String prodName, long quantity, double unitPrice) {
		this.prodName = prodName;
		this.quantity = quantity;
		this.unitPrice = unitPrice;
	}

	/*
	 * getter for Product Name of a line item.
	 * 
	 * @return returns the product name for a given line item.
	 */
	public String getProductName() {
		return prodName;
	}

	/*
	 * Getter for the quantity of a line item.
	 * 
	 * @return returns the quantity for a given line item.
	 */
	public long getQuantity() {
		return quantity;
	}

	/*
	 * Getter for the price of one unit of a line item.
	 * 
	 * @return returns the unit price for a given line item.
	 */
	public double getUnitPrice() {
		return unitPrice;
	}

}
