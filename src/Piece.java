public abstract class Piece
{
    public enum Team
    {
        RED("Red"), BLACK("Black");

        private String name;

        Team(String name)
        {
            this.name = name;
        }

        public String toString()
        {
            return name;
        }
    }

    private Team team;
    private Board board;

    public Piece(Board board, Team team)
    {
        if (team == null)
            throw new IllegalArgumentException("Must have a team");

        this.board = board;
        this.team = team;
    }

    public abstract ArrayList<Space> getMoves();

    public boolean canMove(Space space)
    {
        return getMoves().contains(space);
    }

    public Team getTeam()
    {
        return team;
    }

    public Board getBoard()
    {
        return board;
    }

    public Space getSpace()
    {
        return board.getSpace(this);
    }

    public String toString()
    {
        return this.getTeam() + " " + this.getClass().getName();
    }
}
