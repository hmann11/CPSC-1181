/**
 * 
 * @author hmann11
 *
 *This method handles the layer on top of the GameBoard and adds moves to main stage and decides when a player wins or if the game if a tie.
 */
public class TicTacToeGame {
	public GameBoard gameBoard;
	private int nextPlayer;

	public TicTacToeGame(int nextPlayer) {
		this.gameBoard = new GameBoard();
		this.nextPlayer = nextPlayer;
	}

	private void flipPlayer() {
		if (nextPlayer == 1) {
			nextPlayer = 2;
		} else {
			nextPlayer = 1;
		}
	}

	public int getNextPlayer() {
		return nextPlayer;
	}

	public void play(int playerId, int row, int col) throws InvalidMoveException {
		if (gameBoard.isOccupied(row, col) == true) {
			throw new InvalidMoveException();
		} else {
			gameBoard.set(playerId, row, col);
			flipPlayer();
		}
	}

	public GameBoard getBoard() {
		return gameBoard;
	}

	/*
	 * 
	 * Using for loops, dividing the matches into 3 sections based on the type of combination category which can be
	 * straight, horizontal, cross.
	 */
	public static int hasWinner(GameBoard gameBoard) {
		int whoWon = 0;
		// Checking for Horizontal Matches
		for (int i = 0; i < 3; i++) {
			whoWon = gameBoard.allOccupiedAndSame(i, 0, i, 1, i, 2);
			}
		if (whoWon == 0) {
			// Checking for Vertical Matches
			for (int i = 0; i < 3; i++) {
				whoWon = gameBoard.allOccupiedAndSame(0, i, 1, i, 2, i);
			}
		}
		// Checking for Diagonal Matches
		if (whoWon == 0) {
			whoWon = gameBoard.allOccupiedAndSame(0, 0, 1, 1, 2, 2);
			if (whoWon == 0) {
				whoWon = gameBoard.allOccupiedAndSame(0, 2, 1, 1, 2, 0);
			}
		}
		return whoWon;
	}
	/*
	 * 2 for loops used with the get and isOccupied method from GameBoard to make
	 * sure the entire board is full.
	 */
	private boolean isTie() {
		int occupied = 0;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (gameBoard.isOccupied(i, j)) {
					occupied++;
				}
			}
		}
		if (occupied == 9) {
			return true;
		}
		return false;
	}
}
