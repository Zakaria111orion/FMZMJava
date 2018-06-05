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
     * @author Groupe Messbah EXIA Promo 2017
     */
    MobileOrder getDirection(Point heroPos, IElement[][] tileMap);
}
