package contract;

/**
 * The Interface IView.
 *
 *@author Groupe Messbah EXIA Promo 2017
 */
public interface IView {

	/**
	 * @param controller
     * Initialize the controller
     * @author Groupe Messbah EXIA Promo 2017
	 */
	void setController(IController controller);

    /**
     * In the loop, refresh the view for animation, movement, and update made on the map
     * @author Groupe Messbah EXIA Promo 2017
     */
    void repaint();

    /**
     * @return height of the window
     */
    int getHeight();

    /**
     * @return width of the window
     */
    int getWidth();

    /**
     * text area for the user name at the beginning of the game
     * @return pseudo
     * @author Groupe Messbah EXIA Promo 2017
     */
    String getPseudo();

	/**
	 * @param message
     * POPUP to show a message like a println but not in the console
     * @author Groupe Messbah EXIA Promo 2017
	 */
	void printMessage(final String message);
}
