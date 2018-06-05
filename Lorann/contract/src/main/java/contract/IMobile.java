package contract;

import java.awt.*;

public interface IMobile extends IElement {

    void setLocation(Point loc);

<<<<<<< HEAD
    /**
     * Only for mobile element. Get the position on the map before apply motion
     * @return the Abscissa and ordinate of the mobile element
     * @author Dorian
     */
    Point getPos();

    /**
     * @param order
     * Use the order to move the element on the array map removes or decreases the abscissa OR the ordinate frome its actual position
     * @author Dorian
     */
    void move(MobileOrder order);

    /**
     * @return the direction of the element
     * @author Dorian
     */
=======
   
    Point getPos();

   
    void move(MobileOrder order);

    
>>>>>>> 4bbcb42b42179bc7a242e80dc26862a13cd7d2c7
    MobileOrder getDirection();
}
