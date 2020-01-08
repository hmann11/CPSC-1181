
public class StationFactory {
	private TransactionProcessing tp;

	public StationFactory(TransactionProcessing tp) {
		this.tp = tp;
	}

	public Station createStation(String name, int location) {
		return new Station()
	}
}
