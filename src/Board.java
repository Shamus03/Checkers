import java.util.Observable;
import java.util.Observer;

public class Board extends Observable implements Observer
{
    public static final int BOARD_SIZE = 8;

    private Space[][] board;
    
    public Board()
    {
        board = new Space[BOARD_SIZE][BOARD_SIZE];

        Space s;
        int i;
        int j;
        for (i = 0; i < BOARD_SIZE; i++)
        {
            for (j = 0; j < BOARD_SIZE; j++)
            {
                s = new Space(i, j);
                board[i][j] = s;
                s.addObserver(this);
            }
        }
    }

    public Space getSpace(int row, int col)
    {
        return board[row][col];
    }

    public Space getSpace(Piece p)
    {
        int i;
        int j;
        for (i = 0; i < BOARD_SIZE; i++)
        {
            for (j = 0; j < BOARD_SIZE; j++)
            {
                if (board[i][j].getPiece() == p)
                {
                    return board[i][j];
                }
            }
        }

        return null;
    }

    public void update(Observable o, Object arg)
    {
        setChanged();
        notifyObservers();
    }

    public String toString()
    {
        String result = "";
        int i;
        int j;
        for (i = 0; i < BOARD_SIZE; i++)
        {
            result += "\t" + i;
        }

        for (i = 0; i < BOARD_SIZE; i++)
        {
            result += "\n\n\n\n" + i;
            for (j = 0; j < BOARD_SIZE; j++)
            {
                result += "\t";
                if (board[i][j] != null)
                {
                    result += board[i][j].getPiece();
                }
            }
        }

        return result;
    }
}
