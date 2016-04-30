import javax.swing.JPanel;
import java.awt.GridLayout;
import java.awt.Dimension;

public class CheckerPanel extends JPanel
{
    public static final int PAD = 5;

    private CheckerGame game;

    public CheckerPanel(CheckerGame game)
    {
        this.game = game;

        setLayout(new GridLayout(Board.BOARD_SIZE, Board.BOARD_SIZE));

        int i;
        int j;
        for (i = 0; i < Board.BOARD_SIZE; i++)
        {
            for (j = 0; j < Board.BOARD_SIZE; j++)
            {
                add(new CheckerSpacePanel(game.getSpace(i, j)));
            }
        }

        int size = (CheckerSpacePanel.PIECE_SIZE + PAD * 2) * Board.BOARD_SIZE;
        setPreferredSize(new Dimension(size, size));
    }
}
