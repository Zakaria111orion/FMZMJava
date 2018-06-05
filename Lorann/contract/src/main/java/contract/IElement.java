package contract;

import java.awt.image.BufferedImage;

/**
 * Represent a simple Element with a Sprite and a permeability
 *  @author Groupe Messbah EXIA Promo 2017
 */
public interface IElement {
    /**
     * In move, check whether the element at the next destination has a permeability true or false
     * @return permeability
     * @author Groupe Messbah EXIA Promo 2017
     */
    boolean getPermeability();

    /**
     * Get the image for the element.
     * @return image
     * @author Groupe Messbah EXIA Promo 2017
     */
    BufferedImage getImage();
}
