import javax.swing.JFrame;

public class CheckerGui extends JFrame
{
    private CheckerGame game;
    private CheckerPanel checkerPanel;

    public static void main(String[] args)
    {
        CheckerGui window = new CheckerGui();
        window.setVisible(true);
    }

    public CheckerGui()
    {
        super("Checkers");
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        game = new CheckerGame();

        checkerPanel = new CheckerPanel(game);
        add(checkerPanel);

        setResizable(false);
        pack();
        setLocationRelativeTo(null);
    }

    public CheckerGame getGame()
    {
        return game;
    }
}
