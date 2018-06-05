package contract;

import java.awt.image.BufferedImage;

/**
 * Represent a simple Element with a Sprite and a permeability
 * @author Dorian
 */
public interface IElement {
    /**
     * In move, check whether the element at the next destination has a permeability true or false
     * @return permeability
     * @author Dorian
     */
    boolean getPermeability();

<<<<<<< HEAD
    /**
     * Get the image for the element.
     * @return image
     * @author Dorian
     */
    BufferedImage getImage();
}
=======
    
    BufferedImage getImage();
}
>>>>>>> 4bbcb42b42179bc7a242e80dc26862a13cd7d2c7
