package contract;

/**
 *Interface fireball
 */
public interface IFireball extends IMobile {
    /**
     * @param direction
     * Initialize a direction
     * @author Groupe Messbah EXIA Promo 2017
     */
    void setDirection(MobileOrder direction);

    /**
     * The step is the speed of the fireball
     * @return step : int for number of case the fireball pass
     * @author Groupe Messbah EXIA Promo 2017
     */
    int getStep();

    /**
     * Method that changes the fireball sprite at each case of the array, so it's multicolour
     * @author Groupe Messbah EXIA Promo 2017
     */
    void animate();
}
