package model.mobile;

import contract.IElement;
import contract.IMonster;
import contract.MobileOrder;

import java.awt.Point;

/**
 * Created by Quentin Strinati on 14/06/2016.
 */

/** Class used to create the monster 3 */
public class Monster3 extends Mobile implements IMonster {

    /** Method that instantiates the Monster3 object
     * @param pos contains the monster's position
     */
    public Monster3(Point pos)
    {
        super("monster_3.png", true, pos);
    }

    @Override
    /** Method used to get the direction of the monster
     * @param heroPos contains the position of the hero so the monster knows what's up
     * @param tileMap contains the map in the memory
     * @return the monster's direction
     */
    public MobileOrder getDirection(Point heroPos, IElement[][] tileMap) {


        Point pos = this.getPos().getLocation();

        MobileOrder direction = MobileOrder.random();

        int distance = 28;

        for (MobileOrder dir : MobileOrder.values()) {
            Point aroundPos = MobileOrder.getPos(pos, dir);
            if (tileMap[aroundPos.x][aroundPos.y].getPermeability()) {
                int aroundDist = (heroPos.x-aroundPos.x)*(heroPos.x-aroundPos.x) +
                        (heroPos.y-aroundPos.y)*(heroPos.y-aroundPos.y);

                if(aroundDist < distance) {
                    distance = aroundDist;
                    direction = dir;
                }
            }
        }

        return direction;
    }
}
