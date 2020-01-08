import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Arrays;
import java.util.Scanner;

/**
 * 
 * @author hmann11
 * 
 * This class creates a server that the clients can interact with to play the game. This is where a bulk of the work is done.
 *
 */
public class TicTacToeServer {
	private static GameBoard gameBoard;
	static int nextPlayer = 1;

	private static void writeMessage(DataOutputStream output, String str) throws IOException {
		output.writeUTF(str);
		output.flush();
	}

	public static void main(String[] args) throws IOException {
		int port = 22222;
		try (ServerSocket listener = new ServerSocket(port)) {
			System.out.println("Server running on Port " + port);
			try (Socket player1Socket = listener.accept();
					DataInputStream player1Input = new DataInputStream(player1Socket.getInputStream());
					DataOutputStream player1Output = new DataOutputStream(player1Socket.getOutputStream());

					Socket player2Socket = listener.accept();
					DataInputStream player2Input = new DataInputStream(player2Socket.getInputStream());
					DataOutputStream player2Output = new DataOutputStream(player2Socket.getOutputStream());) {
				while (true) {
					TicTacToePlayer player1 = new TicTacToePlayer(player1Socket, 1);
					TicTacToePlayer player2 = new TicTacToePlayer(player2Socket, 2);
					TicTacToeGame ticTacToeGame = new TicTacToeGame(nextPlayer);
					TicTacToeProtocol ticTacToeProtocol = new TicTacToeProtocol();
					writeMessage(player1Output, TicTacToeProtocol.player(player1.getPlayerInt()));
					writeMessage(player2Output, TicTacToeProtocol.player(player2.getPlayerInt()));
					gameBoard = ticTacToeGame.getBoard();
					String p1 = player1Input.readUTF();
					System.out.println("Player 1 sent " + p1);
					int[] formattedPlayer1 = returnColumnAndRows(p1);
					if (isValid(formattedPlayer1)) {
						ticTacToeGame.play(player1.getPlayerInt(), formattedPlayer1[0], formattedPlayer1[1]);

						writeMessage(player2Output, TicTacToeProtocol.move(formattedPlayer1[0], formattedPlayer1[1]));
						String p2 = player2Input.readUTF();
						int[] formattedPlayer2 = returnColumnAndRows(p2);
						if (isValid(formattedPlayer2)) {

							System.out.println("Player 2 sent " + p2);
							ticTacToeGame.play(player2.getPlayerInt(), formattedPlayer2[0], formattedPlayer2[1]);

							gameBoard.printBoard();
							nextPlayer=2;

						}
					}
					// Send back the result
				}
			} catch (IOException e) {

			} catch (InvalidMoveException e) {

			}
		}
	}
	
	/*
	 * returns the row and column number as integers from a string.
	 */

	private static int[] returnColumnAndRows(String s) {
		int[] formatted = new int[3];

		formatted[0] = Character.getNumericValue(s.charAt(5));
		formatted[1] = Character.getNumericValue(s.charAt(7));

		return formatted;
	}
	
	/*
	 * Checks if the input by the user is Valid.
	 */
	private static boolean isValid(int[] i) {
		int row = i[0];
		int colum = i[1];
		int sum = row + colum;
		if (sum < 5 && sum > -1) {
			return true;
		} else
			return false;
	}

}
