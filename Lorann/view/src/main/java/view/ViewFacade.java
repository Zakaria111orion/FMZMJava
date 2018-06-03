package view;

import javax.swing.JOptionPane;

import showboard.BoardFrame;
import showboard.BoardPanel;

/**
 * <h1>The Class ViewFacade provides a facade of the View component.</h1>
 *
 * @author Jean-Aymeric DIET jadiet@cesi.fr
 * @version 1.0
 */
public class ViewFacade extends BoardFrame implements IView {

	 
	
   
  

    /*
     * (non-Javadoc)
     * @see view.IView#displayMessage(java.lang.String)
     */
    @Override
    public final void displayMessage(final String message) {
      JOptionPane.showMessageDialog(null, message);
    	
    }

    /**
     * Instantiates a new view facade.
     */
	@Override
	public void ViewFacade() {
				
	}

	
	

}
