import java.util.Scanner;

public class Player
{
	private static int numOfPlayers;
	private Cell symbol;
	private boolean winnerState;
	
	public Player()
	{
		if (numOfPlayers++ < 2)
			setSymbol();
	}
	
	public void setSymbol()
	{
		if (numOfPlayers == 1)
			symbol = Cell.X;
		else if (numOfPlayers == 2)
			symbol = Cell.O;
	}
	
	public void getMove()
	{
		Scanner input = new Scanner(System.in);
		
		Cell [][] board = TicTacToe.getBoard();
		int row = -1, column = -1;
		boolean invalidInput = true;
		
		System.out.println("$ Give numerical cordinates (xy) : ");
		
		do
		{
			System.out.print("$ ");
			String cords = input.nextLine();
			if (cords.matches("[0-2]{2}"))
			{
				row = Integer.parseInt(String.valueOf(cords.charAt(0)));
				column = Integer.parseInt(String.valueOf(cords.charAt(1)));
				
				if (board[row][column] != Cell.EMPTY) {
					System.out.println("\n$ Cell cordinates ("
							+ row + "" + column + ") are not available");
				}
				else {
					board[row][column] = symbol;
					invalidInput = false;
				}
			}
			else
				System.out.println("\n$ Invalid cordinates!");
			
		}while (invalidInput);
	}
	
	public boolean getWinnerState()
	{
		return winnerState;
	}
	
	public void setWinnerState(boolean winnerState)
	{
		this.winnerState = winnerState;
	}
}
