package controller;

import contract.*;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

/**
 * The Class Controller.
 */
public class Controller implements IController, Observer {

    /** The view. */
    private IView view;
    
    
	model.Son son = new model.Son();

    /**
     * tileMap
     */
    private IElement[][] tileMap;

    /** The model. */
    private IModel model;

    /**
     * Hero
     */
    private IHero hero;

    /**
     * Pseudo
     */
    private String pseudo;
    
    String titremap = "MAP1";

    /**
     * Level
     */
    private int level = 1;

    /**
     * Score
     */
    private int score = 0;

    /**
     * Scores
     */
    private String[][] scores = null;

    /**
     * Position of Door
     */
    private Point posDoor = null;

    /**
     * List of monster alive
     */
    private HashMap<String, IMonster> monsters = new HashMap<String, IMonster>();

    /**
     * Fireball
     */
    private IFireball fireBall;

    /**
     * Boolean representing hero
     */
    private boolean dead = false;

    /**
     * Parser
     */
    private boolean parser = false;

    /**
     * @return return tileMap
     */
    public IElement[][] getTileMap() {
        return tileMap;
    }

    /**
     * @return Level
     */
    public int getLevel() {
        return level;
    }

    /**
     * @return Score
     */
    public int getScore() {
        return score;
    }

    /**
     * Instantiates a new controller.
     *
     * @param view
     *          the view
     * @param model
     *          the model
     */
    public Controller(final IView view, final IModel model) {
        model.getObservable().addObserver(this);
        this.setView(view);
        this.setModel(model);

        this.hero = (IHero) model.element('L', new Point());
    }

    /**
     * Entry point of Controller
     * Launch GameLoop
     *
     * @see contract.IController#start()
     */
    public void start() {
        this.orderPerform(ControllerOrder.MENU);
        this.pseudo = this.view.getPseudo();
        System.out.println(this.pseudo);

        int lives = 11;

        // Game Loop
        while (true) {
            if(this.fireBall != null && !this.parser) {
                this.moveFireBall();
            }

            if(this.dead) {
                this.destroyFireBall();
            	lives = lives - 1 ;
            	if(lives <= 0 ) {
            		lives=11;
                this.model.loadMap("MENU");
                this.view.printMessage(String.format("YOU DIED! You made a score of : %d\nPress OK to restart the game", this.score));
                this.model.upNameAndScore(this.score, this.pseudo);
                this.level = 1;
                this.score = 0;
            }
            	   else {

            		   switch (level)
            		   {
            		     case 1:
            		    	 titremap = "MAP1";
            		       break;
            		     case 2:
            		    	 titremap = "MAP2";

            		       break;
            		     case 3:
            		    	 titremap = "MAP3";

            		       break;
            		     case 4:
            		    	 titremap = "MAP4";

            		       break;
            		     case 5:
            		    	 titremap = "MAP5";

            		       break;
            		     case 6:
            		    	 titremap = "MAP6";

            		       break;
            		     case 7:
            		    	 titremap = "MAP7";

            		       break;
            		     case 8:
            		    	 titremap = "MAP8";

            		       break;
            		     case 9:
            		    	 titremap = "MAP9";

            		       break;
            		     default:
            		    	 titremap = "MENU";
            		   }
                       this.view.printMessage(String.format("YOU DIED! You have %d lives left\nPress OK to continue the game", lives));
                       this.model.loadMap(titremap);
                       this.dead = false;
                   }
            }


            if(!this.parser) {
                for (Object o : this.monsters.entrySet()) {
                    Map.Entry pair = (Map.Entry) o;
                    IMonster monster = (IMonster) pair.getValue();
                    this.moveMonster(monster);
                }
            }

            this.view.repaint();

            try {
                Thread.sleep(100);
            } catch(InterruptedException ex) {
                Thread.currentThread().interrupt();
            }
        }
    }


	/**
     * Sets the view.
     *
     * @param view
     *          the new view
     */
    private void setView(final IView view) {
        this.view = view;
    }

    /**
     * Sets the model.
     *
     * @param model
     *          the new model
     */
    private void setModel(final IModel model) {
        this.model = model;
    }


    public String[][] getScores() {
        return scores;
    }

    /**
     * Parse tileMap to associate a Letter to a sprite
     *
     * @param tilemap TileMap in text format (with letter)
     * @see contract.IController#parser(String)
     */
    public IElement[][] parser(String tilemap) {
        this.parser = true;
        String[] lines = tilemap.split("\n");
        int x = lines.length;
        int y = lines[0].length();
        IElement[][] map = new IElement[x][y];

        this.monsters.clear();
        this.posDoor = null;

        for(IElement[] row: map)
            Arrays.fill(row, this.model.element(' ', null));


        for(int i = 0; i < x; i++)
        {
            for(int j = 0; j < y; j++)
            {
                char c = lines[i].charAt(j);
                Point pos = new Point(i, j);

                IElement element = this.model.element(c, pos);
                if(c == 'L') {
                    this.dead = false;
                    this.hero = (IHero) element;
                } else if(c == '1' || c == '2' || c == '3' || c == '4') {
                    IMonster monster = (IMonster) element;
                    this.monsters.put(monster.getClass().getSimpleName(), monster);
                } else if(c == 'C') {
                    this.posDoor = pos.getLocation();
                } else if(c == 'S') {
                    this.scores = this.model.getHighScore();
                }
                if (element != null) {
                    map[i][j] = element;
                }
            }
        }
        this.parser = false;
        return map;
    }

    /**
     * @param controllerOrder Load map from model
     *
     * @see contract.IController#orderPerform(contract.ControllerOrder)
     */
    public void orderPerform(final ControllerOrder controllerOrder) {
        if (controllerOrder == null)
            return;

        switch (controllerOrder) {
            case MAP1:
                this.model.loadMap("MAP1");
                this.level = 1;
                break;
            case MAP2:
                this.model.loadMap("MAP2");
                this.level = 2;
                break;
            case MAP3:
                this.model.loadMap("MAP3");
                this.level = 3;
                break;
            case MAP4:
                this.model.loadMap("MAP4");
                this.level = 4;
                break;
            case MAP5:
                this.model.loadMap("MAP5");
                this.level = 5;
                break;
            case MAP6:
                this.model.loadMap("MAP6");
                this.level = 6;
                break;
            case MAP7:
                this.model.loadMap("MAP7");
                this.level = 7;
                break;
            case MAP8:
                this.model.loadMap("MAP8");
                this.level = 8;
                break;
            case MAP9:
                this.model.loadMap("MAP9");
                this.level = 9;
                break;
            case MENU:
                this.model.loadMap("MENU");
                this.level = 0;
                break;
            case WORKSHOP:
                this.model.loadMap("MENU");
                this.level = 0;
                break;
            case MOVEDOWN:
                this.moveHero(MobileOrder.Down);
                break;
            case MOVEUP:
                this.moveHero(MobileOrder.Up);
                break;
            case MOVERIGHT:         
                this.moveHero(MobileOrder.Right);
                break;
            case MOVELEFT:
                this.moveHero(MobileOrder.Left);
                break;
            case FIRE:
                this.fire();
                break;
            default:
                this.model.loadMap("MENU");
                this.level = 0;
                break;
        }
    }

    /**
     * Launch a fireball and prepare animation
     */
    private void fire() {
        if(this.fireBall != null)
            return;
        this.destroyFireBall();
        MobileOrder direction = this.hero.getDirection();
        Point currentPos = this.hero.getPos().getLocation();
        Point nextPos = this.computeNextPosball(direction, currentPos);
        if(!currentPos.equals(nextPos) && !this.tileMap[nextPos.x][nextPos.y].getClass().getSimpleName().contains("Bone")) {
            this.fireBall = (IFireball) this.model.element('F', nextPos);

            switch (direction)
            {
              case Left:
                  direction = MobileOrder.Right ; 	
                  this.fireBall.setDirection( direction);
                  direction = MobileOrder.Left ; 	

                break;
              case Right:
                  direction = MobileOrder.Left ; 	
                  this.fireBall.setDirection( direction);
                  direction = MobileOrder.Right ; 	

                break;
              case Up:
                  direction = MobileOrder.Down ; 	
                  this.fireBall.setDirection( direction);
                  direction = MobileOrder.Up ;	
                  break;

                   
              case Down:
                  direction = MobileOrder.Up ; 
                  this.fireBall.setDirection( direction);
                  direction = MobileOrder.Down ; 	
                  
                break;
			default:
				break;
            }
            son.Shoot();
            this.fireBall.setDirection( direction);

            this.swapFireBall(nextPos);
            this.view.repaint();
            
        }
    }
    /** Function checking if the hero is moving out of the map,
     * then checking if it collides with an object which permeability is false,
     * then applies the changes of position if the hero can move */
    private void moveHero(MobileOrder order) {
        Point pos = this.hero.getPos();
        this.hero.move(order, tileMap, this.view);
        this.tileMap[pos.x][pos.y] = model.element(' ', pos.getLocation());
        pos = this.hero.getPos();
        String elementName = this.tileMap[pos.x][pos.y].getClass().getSimpleName();
        if(elementName.contains("Monster") || elementName.contains("losed")) {
    		son.Death();
            this.dead = true;
        } else if (elementName.contains("Crystal") && this.posDoor != null) {
        	son.Crystal();
            this.tileMap[this.posDoor.x][this.posDoor.y] = model.element('O', this.posDoor);
            this.score += 100;
        } else if (elementName.contains("OpenDoor")) {
        	son.Port();
            this.destroyFireBall();
            this.level++;
            if(this.level > 9) {
                this.model.upNameAndScore(this.score, this.pseudo);
                this.view.printMessage(String.format("WELL DONE %s! Your score is : %d\nPress OK to restart the game", this.pseudo, this.score));
                this.score = 0;
                this.level = 1;
            }
            this.model.loadMap(String.format("MAP%d", this.level));
            return;
        } else if (elementName.contains("Purse")) {
        	son.Consomable();
            this.score += 250;
        }
        this.tileMap[pos.x][pos.y] = this.hero;
        this.view.repaint();
    }

    /**
     * Compute next position and detect collision
     *
     * @see controller.Controller#swapFireBall(Point)
     */
    private void moveFireBall() {
        Point currentPos = this.fireBall.getPos().getLocation();
        MobileOrder direction = this.fireBall.getDirection();
        for (MobileOrder dir : MobileOrder.getValues()) {
            if(!dir.equals(direction)) {
                Point aroundPos = this.computeNextPos(dir, currentPos);
                IElement element = this.tileMap[aroundPos.x][aroundPos.y];
                String elementName = element.getClass().getSimpleName();
                
                if(elementName.contains("Monster")) {
                	son.Deadmonster();
                    this.tileMap[aroundPos.x][aroundPos.y] = model.element(' ', aroundPos);
                    this.monsters.remove(elementName);
                    this.destroyFireBall();
                    return;
                }
                
                if(elementName.contains("Hero")) {
                	son.Recover();
                    this.destroyFireBall();
                    return;
                }
                
                if (elementName.contains("Bone") || elementName.contains("Door")) {
                	
                	direction = this.fireBall.getDirection();
                	switch (direction)
                    {
                      case Left:
                          direction = MobileOrder.Right ; 	
                          this.fireBall.setDirection( direction);

                        break;
                      case Right:
                          direction = MobileOrder.Left ; 	
                          this.fireBall.setDirection( direction);

                        break;
                      case Up:
                          direction = MobileOrder.Down ; 	
                          this.fireBall.setDirection( direction);
                          break;
                          
                          
                      case Down:
                          direction = MobileOrder.Up ; 
                          this.fireBall.setDirection( direction);
                          
                        break;
        			default:
        				break;
                    }
                	
                     if(this.fireBall != null && this.fireBall.getStep() > 200) {
                         this.destroyFireBall();
                     }
                     
                     

                         if(this.fireBall != null && this.fireBall.getStep() > 200) {
                             this.destroyFireBall();
                         }}
            }
        }
        this.fireBall.animate();
        Point nextPos = this.computeNextPosball(this.fireBall.getDirection(), currentPos);

        this.swapFireBall(nextPos);

        this.tileMap[currentPos.x][currentPos.y] = model.element(' ', currentPos.getLocation());

        if(this.fireBall != null && this.fireBall.getStep() > 200) {
            this.destroyFireBall();
        }
    }

    /**
     * Swap the fireball in tileMap
     * @param nextPos
     */
    private void swapFireBall(Point nextPos) {
        String nextElement = this.tileMap[nextPos.x][nextPos.y].getClass().getSimpleName();
        if(nextElement.contains("Monster")) {
            this.fireBall.setLocation(nextPos);
            this.tileMap[nextPos.x][nextPos.y] = this.fireBall;
            this.destroyFireBall();
            IMonster monster = this.monsters.get(nextElement);
            Point monsterPos = monster.getPos().getLocation();
            this.tileMap[monsterPos.x][monsterPos.y] = model.element(' ', monsterPos);
            System.out.println("Monster : " + this.monsters.remove(nextElement));
            this.score += 500;
        } else if(nextElement.contains("Door") ||
                nextElement.contains("Purse") ||
                nextElement.contains("Crystal")) {
            this.fireBall = null;
            this.destroyFireBall();

        }
        else {
            this.fireBall.setLocation(nextPos);
            this.tileMap[nextPos.x][nextPos.y] = this.fireBall;

        }
    }

    /**
     * Swap monster in tileMap and detect collision
     * @param monster
     */
    private void moveMonster(IMonster monster) {
        Point pos = monster.getPos().getLocation();
        Point nextPos = this.computeNextPos(
                monster.getDirection(
                        this.hero.getPos().getLocation(),
                        this.tileMap),
                pos);
        if(nextPos != pos) {
            String element = tileMap[nextPos.x][nextPos.y].getClass().getSimpleName();
            if(element.contains("Hero")) {
                this.dead = true;
            } else if(!element.contains("Bone") && !element.contains("Monster") &&
                    !element.contains("Purse") &&
                    !element.contains("Crystal") &&
                    !element.contains("Door")) {
                tileMap[pos.x][pos.y] = model.element(' ', pos.getLocation());
                monster.setLocation(nextPos);
                tileMap[nextPos.x][nextPos.y] = monster;
            }
        }
    }

    /**
     * @param direction
     * @param currentPos
     * @return Position relative to direction and current position
     */
    public Point computeNextPos(MobileOrder direction, Point currentPos) {
        Point nextPos = currentPos.getLocation();

        if(direction == null)
            return nextPos;
        
        switch (direction) {
        case Left:
            if(currentPos.y > 0 &&
                    tileMap[currentPos.x][currentPos.y - 1].getPermeability())
            {
                nextPos = new Point(
                        currentPos.x,
                        currentPos.y - 1);
            }
            break;
        case Right:
            if(currentPos.y < (view.getWidth() / 32) &&
                    tileMap[currentPos.x][currentPos.y + 1].getPermeability())
            {
                nextPos = new Point(
                        currentPos.x,
                        currentPos.y + 1);
            }
            break;
        case Up:
            if(currentPos.x > 0 &&
                    tileMap[currentPos.x - 1][currentPos.y].getPermeability()) {
                nextPos = new Point(
                        currentPos.x - 1,
                        currentPos.y);
            }
            break;
        case Down:
            if(currentPos.x < (view.getHeight() / 32) - 1 &&
                    tileMap[currentPos.x + 1][currentPos.y].getPermeability()) {
                nextPos = new Point(
                        currentPos.x + 1,
                        currentPos.y);
            }
            break;
		default:
			break;
    }
    return nextPos;
    
    }
    
    public Point computeNextPosball(MobileOrder direction, Point currentPos) {
        Point nextPos = currentPos.getLocation();

        if(direction == null)
            return nextPos;

        switch (direction) {
        case Left:
            if(currentPos.y > 0 &&
                    tileMap[currentPos.x][currentPos.y + 1].getPermeability())
            {
                nextPos = new Point(
                        currentPos.x,
                        currentPos.y + 1);
            }
            break;
        case Right:
            if(currentPos.y < (view.getWidth() / 32) - 1 &&
                    tileMap[currentPos.x][currentPos.y - 1].getPermeability())
            {
                nextPos = new Point(
                        currentPos.x,
                        currentPos.y - 1);
            }
            break;
        case Up:
            if(currentPos.x > 0 &&
                    tileMap[currentPos.x + 1][currentPos.y].getPermeability()) {
                nextPos = new Point(
                        currentPos.x + 1,
                        currentPos.y);
            }
            break;
        case Down:
            if(currentPos.x < (view.getHeight() / 32) - 1 &&
                    tileMap[currentPos.x - 1][currentPos.y].getPermeability()) {
                nextPos = new Point(
                        currentPos.x - 1,
                        currentPos.y);
            }
            break;
		default:
			break;
    }
    return nextPos;

    }

    /**
     * Erase fireball from tileMap
     */
    private void destroyFireBall() {
        if(this.fireBall != null) {
            Point pos = this.fireBall.getPos().getLocation();
            this.tileMap[pos.x][pos.y] = this.model.element(' ', pos);
            this.fireBall = null;

        }
    }

    /**
     * Update tileMap
     * @param o
     * @param arg
     */
    public void update(Observable o, Object arg) {
        this.tileMap = parser(model.getMap());
        this.view.repaint();
    }
}
