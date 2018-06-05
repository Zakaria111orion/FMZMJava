package contract;

import java.awt.*;

/**
 * Interface Monster
 */
public interface IMonster extends IMobile {
    /**
     * @param heroPos for Monster 1, act as an pathfinder, an "AI" for the monster
     * @param tileMap check elements permeability and size map
     * @return direction (change position of the monster on the map)
     * @author Dorian
     */
    MobileOrder getDirection(Point heroPos, IElement[][] tileMap);
<<<<<<< HEAD
}
=======
}
>>>>>>> 4bbcb42b42179bc7a242e80dc26862a13cd7d2c7
