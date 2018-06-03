package showboard;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import javax.swing.JPanel;

/**
 * <h1>The Class BoardPanel.</h1>
 * <p>
 * This class represents the board as an image. It extends JPanel.
 * </p>
 * <p>
 * It uses an ISquare[][] as board, a List&lt;IPawn&gt; as list of pawns.
 * </p>
 * <p>
 * If an ISquare has not an image, the noImage is used.
 * </p>
 * <p>
 * The same noImage is used to illustrate the board's edge.
 * </p>
 * <p>
 * The class implements Observer interface to observe the Observable who stores the board's data. At
 * each update, the image is build.
 * </p>
 * <p>
 * The all image isn't display, just the zone represented by the display Rectangle is show in the
 * panel. If this Rectangle is higher than the board dimension, the noImage is also used.
 * </p>
 *
 * @author Anne-Emilie DIET
 * @version 3.0
 * @see JPanel
 * @see Dimension
 * @see Rectangle
 * @see Image
 * @see ISquare
 * @see IPawn
 * @see Observer
 * @see Observable
 */
public class BoardPanel extends JPanel implements Observer {

    /** The Constant serialVersionUID. */
    private static final long   serialVersionUID = -3618605287900763008L;

    /** The squares represents the square of the board. */
    private ISquare[][]         squares;

    /** The pawns represents a list of all the pawns on the board. */
    private final List<IPawn>   pawns;

    /**
     * The dimension is used to known the width and the height of the board. It's used principally
     * with the squares property
     */
    private Dimension           dimension;

    /** The center of the board. */
    private Rectangle           displayFrame;

    /** The no image is used to factorize the NoImage loading. */
    private final BufferedImage noImage;

    /** The width looped. */
    private Boolean             widthLooped      = false;

    /** The height looped. */
    private Boolean             heightLooped     = false;

    /**
     * Instantiates a new board panel.
     */
    public BoardPanel() {
        super();
        this.pawns = new ArrayList<>();
        this.noImage = new BufferedImage(1, 1, BufferedImage.TYPE_INT_ARGB);
        final Graphics2D graphics = this.noImage.createGraphics();
        graphics.setColor(Color.BLACK);
        graphics.fillRect(0,0,221,20);
        
    }

	@Override
	public void update(Observable observable, Object arg) {
		// TODO Auto-generated method stub
		
	}

}

    

   