public class GameBoard {
	private int[][] board;

	public GameBoard() {
		this("000000000");
	}

	private boolean isValid(char c) {
		return c == '0' || c == '1' || c == '2';
	}

	public GameBoard(String preset) throws IllegalArgumentException {
		this.board = new int[3][3];

		char[] p = preset.trim().toCharArray();
		if (p.length != 9) {
			throw new IllegalArgumentException("Invalid board (" + preset + ")");
		}

		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				int pos = i * 3 + j;
				if (this.isValid(p[pos])) {
					this.set(p[pos] - '0', i, j);
				} else {
					throw new IllegalArgumentException("Invalid board (" + preset + ")");
				}
			}
		}
	}

	public void set(int playerId, int row, int col) {
		this.board[row][col] = playerId;
	}

	public int get(int row, int col) {
		return this.board[row][col];
	}

	public boolean isOccupied(int row, int col) {
		return this.get(row, col) != 0;
	}

	public boolean hasEmpty() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (get(i, j) == 0) {
					return true;
				}
			}
		}
		return false;
	}

	public String asString() {
		String s = "";
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				s += this.board[i][j];
			}
		}
		return s;
	}

	public int allOccupiedAndSame(int r1, int c1, int r2, int c2, int r3, int c3) {
		boolean isSame = get(r1, c1) == get(r2, c2) && get(r1, c1) == get(r3, c3) && get(r2, c2) == get(r3, c3);
		return isSame ? get(r1, c1) : 0;
	}

	private String convertToString(int s) {
		return s == 0 ? " " : s == 1 ? "O" : "X";
	}

	public void printBoard() {
		for (int i = 0; i < 3; i++) {
			System.out.printf(" %s | %s | %s \n", convertToString(get(i, 0)), convertToString(get(i, 1)),
					convertToString(get(i, 2)));
			if (i != 2) {
				System.out.println("----------");
			}
		}
	}

	/*
	 * Test Code
	 */
	public static void main(String[] args) {
		GameBoard g1 = new GameBoard();
		assert g1.hasEmpty();
		assert g1.allOccupiedAndSame(0, 0, 0, 1, 0, 2) == 0;
		assert g1.isOccupied(0, 0) == false;
		g1.printBoard();

		GameBoard g2 = new GameBoard("111111111");
		assert g2.hasEmpty() == false;
		assert g2.allOccupiedAndSame(0, 0, 0, 1, 0, 2) == 1;
		assert g2.isOccupied(0, 0) == true;
		g2.printBoard();

		GameBoard g3 = new GameBoard("012012012");
		assert g3.hasEmpty() == true;
		assert g3.allOccupiedAndSame(0, 0, 0, 1, 0, 2) == 0;
		assert g3.allOccupiedAndSame(0, 1, 1, 1, 2, 1) == 1;
		assert g3.allOccupiedAndSame(0, 2, 1, 2, 2, 2) == 2;
		g3.printBoard();

		GameBoard g4 = new GameBoard("021112012");
		System.out.println();
		g4.printBoard();
		GameBoard g5=new GameBoard("102021210");
		System.out.println();
		g5.printBoard();
		

	}

}
