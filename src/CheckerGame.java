public class CheckerGame
{
    private CheckerBoard board;

    public CheckerGame()
    {
        board = new CheckerBoard();
    }

    public void move(int row1, int col1, int row2, int col2)
    {
        Space from = getSpace(row1, col1);
        Space to = getSpace(row2, col2);
        
        to.setPiece(from.getPiece());
        from.setPiece(null);
    }

    public Board getBoard()
    {
        return board;
    }
    
    public Space getSpace(int row, int col)
    {
        return board.getSpace(row, col);
    }

    public String toString()
    {
        return board.toString();
    }
}
