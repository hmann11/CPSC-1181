
public class Test1 {
	public static void main(String[] args) {
		PaymentProcessing pp=new PaymentProcessing();
		TransactionProcessing tp= new TransactionProcessing(pp);
		StationFactory stationFactory= new StationFactory(tp);
		
		Station vancouver=stationFactory.createStation("Vancouver", 0);
		Station langara= stationFactory.createStation("Langara", 8);
		Station richmond=stationFactory.createStation("Richmond", 16);
		
		CompassCard kyle=new CompassCard("Kyle");
		CompassCard kawhi= new CompassCard("Kawhi");
		
		vancouver.startTrip(kyle);
		vancouver.startTrip(kawhi);
		
		langara.endTrip(kawhi);
		
		richmond.endTrip(kyle);
		langara.startTrip(kawhi);
		richmond.endTrip(kawhi);
		
		tp.prtintTrips();
		
		pp.printInvoices();
}
}
