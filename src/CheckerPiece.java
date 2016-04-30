public class CheckerPiece extends Piece
{
    private boolean king;

    public CheckerPiece(Board board, Team team)
    {
        super(board, team);
    }

    public boolean isKing()
    {
        return king;
    }

    public void setKing(boolean k)
    {
        king = k;
    }

    public ArrayList<Space> getMoves()
    {
        return null;
    }
}
