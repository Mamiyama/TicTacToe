
public enum Cell
{
	X(1), O(-1), EMPTY(0);
	
	private int fixedNum;
	
	private Cell(int number)
	{
		fixedNum = number;
	}
	
	public int getFixedNum()
	{
		return fixedNum;
	}
}