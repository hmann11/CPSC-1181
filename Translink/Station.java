
public class Station {
	private String name;
	private int location;
	private TransactionProcessing tp;
	
	public Station(String name, int location, TransactionProcessing tp) {
		this.name=name;
		this.location=location;
		this.tp=tp;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getLocation() {
		return this.location;
	}
	
	public void startTrip(CompassCard card) {
		card.setStartStation(this);
	}
	
	public void endTrip(CompassCard card) {
		this.tp.reportTrip(card,card.getStartStation(),endStation.this);
		card.resetTrip();
	}
}
