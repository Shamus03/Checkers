public class CheckerBoard extends Board
{
    public static void main(String[] args)
    {
        CheckerBoard board = new CheckerBoard();
        System.out.println(board);
    }

    public CheckerBoard()
    {
        super();

        int i;
        int j;
        boolean redRow;
        boolean blackRow;
        Piece.Team team;
        for (i = 0; i < BOARD_SIZE; i++)
        {
            blackRow = i < 3;
            redRow = i > BOARD_SIZE - 4;

            if (redRow || blackRow)
            {
                team = redRow ? Piece.Team.RED : Piece.Team.BLACK;

                for (j = 0; j < BOARD_SIZE; j++)
                {
                    if ((i + j) % 2 == 1)
                    {
                        getSpace(i, j).setPiece(new CheckerPiece(this, team));
                    }
                }
            }
        }
    }
}
