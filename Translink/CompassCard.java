
public class CompassCard {
	private String owner;
	private Station startStation;
	
	public CompassCard(String name) {
		this.owner=name;
	}
	
	public String getName() {
		return this.owner;
	}
	
	public Station getStartStation() {
		return this.startStation;
	}
	
	public void setStartStation(Station s) {
		this.startStation=s;
	}
	
	public void resetTrip() {
		this.startStation=null;
	}
	
}
