package contract;

import java.awt.Point;

/**
 * The Interface IController.
 *
 * @author Groupe EXIA Promo 2017
 */
public interface IController {

	/**
	 * Start the main gameloop.
     * @author Groupe Messbah EXIA Promo 2017
	 */
	void start();

	/**
	 * Order perform.
	 * @param controllerOrder
	 * Method use in every mobile object, and also when load map, to execute the predefined order contain in the ControllerOrder list
	 * @author Groupe Messbah EXIA Promo 2017
	 */
	void orderPerform(ControllerOrder controllerOrder);

	/**
     * Dynamically resize the window view according to the map size
	 * @return tileMap
     * @author Groupe Messbah EXIA Promo 2017
	 */
	IElement[][] getTileMap();

	/**
     * Get the score made at the end of the game (win or loose) for POPUP
	 * @return Score
     * @author Groupe Messbah EXIA Promo 2017
	 */
	int getScore();

    /**
     * @param direction
     * @param currentPos
     * @return
     */
    Point computeNextPos(MobileOrder direction, Point currentPos);

	/**
     * Get the level according to the number of the map played for the draw string at the bottom of the window
	 * @return Level
     * @author Groupe Messbah EXIA Promo 2017
	 */
	int getLevel();

    /**
     * @param tilemap String representing map with binding of letter with Element
     * @return 2-dimensional array representing game (map + mobile)
     * @author Groupe Messbah EXIA Promo 2017
     */
    IElement[][] parser(String tilemap);

	String[][] getScores();
}
