import java.util.*;

public class TransactionProcessing {
	private ArrayList<String> tripLog;
	private PaymentProcessing pp;

	public TransactionProcessing(PaymentProcessing pp) {
		this.pp = pp;
		this.tripLog = new ArrayList<String>();
	}

	public void prtintTrips() {
		for(String s:tripLog) {
			System.out.println(s);
		}
	}

	public void reportTrip(CompassCard card, Station startStation, Station endStation) {
		String log="Card("+card.getName()+")"+startStation.getName()+ "->"+endStation.getName();
		this.tripLog.add(log);
		 this.pp.chargeTrip();
	}

}
