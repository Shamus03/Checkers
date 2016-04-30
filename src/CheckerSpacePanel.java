import javax.swing.JPanel;
import java.util.Observable;
import java.util.Observer;
import javax.swing.JLabel;
import java.awt.image.BufferedImage;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Color;
import javax.swing.ImageIcon;

public class CheckerSpacePanel extends JPanel implements Observer
{
    public static final int PIECE_SIZE = 60;

    private Space space;
    private JLabel label;

    public CheckerSpacePanel(Space space)
    {
        this.space = space;
        this.label = new JLabel();
        updateLabel();

        if ((space.getRow() + space.getCol()) % 2 == 1)
        {
            setBackground(Color.GRAY);
        }

        space.addObserver(this);

        add(label);
    }
    
    private void updateLabel()
    {
        if (space.getPiece() != null)
        {
            Piece.Team team = space.getPiece().getTeam();
            BufferedImage image = new BufferedImage(PIECE_SIZE, PIECE_SIZE,
                BufferedImage.TYPE_INT_ARGB);
            Graphics2D g = (Graphics2D) image.createGraphics();

            RenderingHints rh = new RenderingHints(
                RenderingHints.KEY_TEXT_ANTIALIASING,
                RenderingHints.VALUE_TEXT_ANTIALIAS_ON);

            g.setRenderingHints(rh);

            switch(team)
            {
                case RED:
                    g.setColor(Color.RED); 
                    break;
                case BLACK:
                    g.setColor(Color.BLACK); 
                    break;
            }
            g.fillOval(0, 0, PIECE_SIZE, PIECE_SIZE);

            label.setIcon(new ImageIcon(image));
        }
        else
        {
            label.setIcon(null);
        }
    }

    public void update(Observable o, Object arg)
    {
        updateLabel();
    }
}
