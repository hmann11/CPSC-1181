/**
 * 
 * @author hmann11
 *
 *This method tests for the new invoice generator and tax calculator.
 */
public class Test2 {
	public static void main(String[] args) {
		TaxCalculator taxC = new TaxCalculator();
		InvoiceCalculator invC = new InvoiceCalculator(taxC);
		OrderPrinter op = new OrderPrinter();
		Order order1 = new Order();

		order1.addLineItem("Lord of the Rings", 30, 20.5);
		order1.addLineItem("Bible", 5, 5);
		order1.removeLineItem("Harry Potter");
		order1.addLineItem("Lord of the Rings", 22.5);
		order1.addLineItem("Harry Potter", 3, 10);
		op.print(order1);
		invC.generateInvoice(order1);
		
	}
}
