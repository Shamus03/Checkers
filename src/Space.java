import java.util.Observable;
import java.util.Observer;

public class Space extends Observable
{
    private int row;
    private int col;
    private Piece piece;

    public Space(int row, int col)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow()
    {
        return row;
    }

    public int getCol()
    {
        return col;
    }

    public Piece getPiece()
    {
        return piece;
    }

    public void setPiece(Piece p)
    {
        piece = p;

        setChanged();
        notifyObservers();
    }

    public String toString()
    {
        return "(" + row + ", " + col + "): " + piece;
    }
}
