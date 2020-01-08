
public class TicTacToeProtocol {
	public TicTacToeProtocol() {
		
	}
	public static String player(int playerId) {
		return "player "+playerId;
	}
	public static String turn(int playerId, GameBoard gameBoard) {
		return "turn "+playerId+" "+gameBoard.asString();
	}
	public static String move(int row,int col) {
		return "move "+row+" "+col;
	}
	public static String gameend(int playerId) {
		if(playerId==0) {
			return "gameend "+playerId;
		}
		return "gameend "+playerId;
	}
	public static final String quit="quit";
}
