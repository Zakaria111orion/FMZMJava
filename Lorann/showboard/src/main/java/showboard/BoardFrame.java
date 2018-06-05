package showboard;

import java.awt.Dimension;
import java.awt.Rectangle;


import javax.swing.JFrame;



/**
 * <h1>The Class BoardFrame.</h1>
 * <p>
 * This class is just used to load the BoardPanel. It extends JPanel and implements IBoard.
 * </p>
 * <p>
 * As the BoardPanel is a private class, BoardPanel is a Facade.
 * </p>
 *
 * @author Anne-Emilie DIET
 * @version 3.0
 * @see JFrame
 * @see BoardPanel
 * @see Dimension
 * @see Rectangle
 * @see IBoard
 * @see ISquare
 * @see IPawn
 */
public class BoardFrame extends JFrame implements IBoard {

    /** The Constant serialVersionUID. */
    private static final long serialVersionUID = -6563585351564617603L;

    /** The initial frame size. */
    private static final int  X_defaultFrameSize = 635;
    private static final int  Y_defaultFrameSize = 420;

    /** The board panel. */
    private final BoardPanel  boardPanel;

    /**
     * Instantiates a new board frame.
     */
    public BoardFrame() {
        super();
        this.setTitle("Lorann");
        this.setSize(X_defaultFrameSize, Y_defaultFrameSize);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        
        this.boardPanel = new BoardPanel();
        this.setContentPane(this.boardPanel);
        this.setResizable(false);
        this.setVisible(true);
    }

   
    @Override
    public final Observer getObserver() {
        return this.getBoardPanel();
    }
    private BoardPanel getBoardPanel() {
        return this.boardPanel;
    }


	@Override
	public void addSquare(ISquare square, int x, int y) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void addPawn(IPawn pawn) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void setDimension(Dimension dimension) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public Dimension getDimension() {
		// TODO Auto-generated method stub
		return null;
	}


	@Override
	public void setDisplayFrame(Rectangle displayFrame) {
		// TODO Auto-generated method stub
		
	}

    
}
