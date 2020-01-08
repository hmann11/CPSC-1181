/**
 * 
 * @author hmann11
 * 
 *         CPSC Test 1.java
 * This class tests the core of the shopping cart application by:-
 * 1) Making a new object called order1 to put the items into.
 * 2) The Order class stores the details for each of the addLineItem calls into lineItems.
 * 3) Finally it tests if both the remove item logics are working and prints out the resulting order1 using the OrderPrinter op.
 *
 */
public class Test1 {
	public static void main(String[] args) {
		Order order1 = new Order();
		OrderPrinter op = new OrderPrinter();

		order1.addLineItem("Lord of the Rings", 30, 20.5);
		order1.addLineItem("Bible", 50, 5);
		order1.addLineItem("Lord of the Rings", 22.5);
		order1.addLineItem("Harry Potter", 300, 10);
		order1.removeLineItem("Harry Potter");

		op.print(order1);
	}
}
