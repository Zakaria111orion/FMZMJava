package contract;

/**
 * Interface Hero
 */
public interface IHero extends IMobile {
    /**
     * @author Groupe Messbah EXIA Promo 2017
     * @param order from the user
     * @param tileMap check elements permeability and size map
     * @param view
     * Override move method from mobile for Hero element
     */
    void move(MobileOrder order, IElement[][] tileMap, IView view);
}
