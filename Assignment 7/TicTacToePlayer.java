import java.net.Socket;
/**
 * 
 *@author hmann11
 *
 *
 *This is a small class to store details regarding the player character.
 */
public class TicTacToePlayer {
	
	public Socket socket;
	public int playerInt;
/*
 * Main constructor to make a player object by taking in the socket registered to the player, the playerID
 */
	public TicTacToePlayer(Socket socket, int playerInt) {
		this.socket = socket;
		this.playerInt = playerInt;
		
	}

	public Socket getSocket() {
		return this.socket;
	}

	public int getPlayerInt() {
		return this.playerInt;
	}
}
