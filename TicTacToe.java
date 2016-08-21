
public class TicTacToe
{
	private static Cell[][] board;
	private static final int LENGTH = 3;
	private static int moveCount;
	private static int turn;
	private static Player playerOne, playerTwo;
	
	public TicTacToe()
	{
		board = new Cell[LENGTH][LENGTH];
		
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < LENGTH; j++)
				board[i][j] = Cell.EMPTY;
		}
		
		turn = 1;
	}
	
	public void startGame()
	{
		boolean winner = false;
		playerOne = new Player();
		playerTwo = new Player();

		printCords();
		
		while (!winner && moveCount++ < 9) {
			if (turn == 1)
			{
				playerOne.getMove();
				setTurn(2);
			}
			else
			{
				playerTwo.getMove();
				setTurn(1);
			}
			
			if (checkCellsForWinner() == true)
				winner = true;
			
			printBoard(board);
		}
		
		finishGame();
	}
	
	public static boolean checkCellsForWinner()
	{
		boolean winner = false;
		int[] sums = {	board[0][0].getFixedNum() + board[0][1].getFixedNum() + board[0][2].getFixedNum(),
						board[1][0].getFixedNum() + board[1][1].getFixedNum() + board[1][2].getFixedNum(),
						board[2][0].getFixedNum() + board[2][1].getFixedNum() + board[2][2].getFixedNum(),
						board[0][0].getFixedNum() + board[1][1].getFixedNum() + board[2][2].getFixedNum(),
						board[0][2].getFixedNum() + board[1][1].getFixedNum() + board[2][0].getFixedNum(),
						board[0][0].getFixedNum() + board[1][0].getFixedNum() + board[2][0].getFixedNum(),
						board[0][1].getFixedNum() + board[1][1].getFixedNum() + board[2][2].getFixedNum(),
						board[0][2].getFixedNum() + board[1][2].getFixedNum() + board[2][2].getFixedNum()	};
					 																						
		for (int sum : sums) {
			if (sum == -LENGTH) {
				playerTwo.setWinnerState(true);
				winner = true;
				break;
			}
			
			if (sum == LENGTH) {
				playerOne.setWinnerState(true);
				winner = true;
				break;
			}
		}
		
		return winner;
	}
	
	public static void finishGame()
	{
		 System.out.println("Finish!");
		 
		 if (playerOne.getWinnerState() == true)
			 System.out.println("win,\nPlayer one is the winner!");
		 else if (playerTwo.getWinnerState() == true)
			 System.out.println("win,\nPlayer two is the winner!");
		 else
			 System.out.println("draw");
		 
		 System.out.println("Game finished in " + moveCount + " moves");
	}
	
	public static void printBoard(Cell[][] board)
	{
		System.out.println();
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < LENGTH; j++)
				System.out.printf("%-4s ", board[i][j]);
			System.out.println();
		}
		System.out.println();
	}
	
	public void printCords()
	{
		System.out.println();
		for (int i = 0; i < LENGTH; i++) {
			for (int j = 0; j < LENGTH; j++)
				System.out.print(i + "" + j + "  ");
			System.out.println();
		}
		System.out.println();
	}
	
	public void setTurn(int value)
	{
		turn = value;
	}
	
	public static Cell[][] getBoard()
	{
		return board;
	}
}