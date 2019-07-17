/*
 * Mark Chen
 * October 24 2018
 * This is the abstract human class to be extended by concrete human types
 */
package chenworld;

import TurtleGraphics.Pen;

abstract public class AbstractHuman implements HumanInterface {

    //private variables
    public static final double LOW_HEIGHT = 20.0;
    public static final double HIGH_HEIGHT = 100.0;
    public static final int LOW_AGE = 1;
    public static final int HIGH_AGE = 100;
    public static final int LOW_HEALTH = 1;
    public static final int HIGH_HEALTH = 100;
    public static int NUM_HUMANS = 0;

    //protected attributes
    protected String name;
    protected int age, health, xPos, yPos;
    protected double height;

    /**
     * Primary constructor that initializes all attributes to a default value
     */
    public AbstractHuman() {
        name = "No Name";
        age = (int)(Math.random()*80)+20;
        health = (int)(Math.random()*80)+20;
        xPos = (int)(Math.random()*810)-385;
        yPos = (int)(Math.random()*810)-385;
        height = (int)(Math.random()*80)+20;
        NUM_HUMANS++;
    }

    /**
     * Secondary constructor that makes the object with all attributes
     *
     * @param name - the name of the human
     * @param age - the age of the human
     * @param health - the health of the human
     * @param xPos - the x position of the human
     * @param yPos - the y position of the human
     * @param height - the height of the human
     */
    public AbstractHuman(String name, int age, int health, int xPos, int yPos, double height) {
        this();
        
        //If the inputted attribute is outside of the bounds, set the attribute to the bound
        //Age
        if (age>HIGH_AGE){
            age = HIGH_AGE;
        } else if (age<LOW_AGE){
            age = LOW_AGE;
        }
        //Health
        if (health>HIGH_HEALTH){
            health = HIGH_HEALTH;
        } else if (health<LOW_HEALTH){
            health = LOW_HEALTH;
        }
        //Height
        if (height>HIGH_HEIGHT){
            height = HIGH_HEIGHT;
        } else if (height<LOW_HEIGHT){
            height = LOW_HEIGHT;
        }
        
        //Then set the attributes
        this.name = name;
        this.age = age;
        this.health = health;
        this.xPos = xPos;
        this.yPos = yPos;
        this.height = height;
    }

    /**
     * This method moves the positions of the object to a new coordinate
     * @param x - the x position to be moved to
     * @param y - the y position to be moved to
     */
    public void move(int x, int y) {
        xPos = x;
        yPos = y;
    }

    public void draw(Pen p) {
        //Unit to draw with
        double foot = height/5.0;
        double meter = foot * 3.0;

        //Draws Head as a circle
        double side = 2.0 * Math.PI * foot / 120.0;
        p.up();
        p.move(xPos + foot, yPos - side / 2.0);
        p.setDirection(90);
        p.down();
        for (int i = 0; i < 120; i++) {
            p.move(side);
            p.turn(3);
        }

        //Moves pen below head
        p.up();
        p.move(xPos - foot, yPos - meter - foot);
        p.down();
        //Draws rectangle body
        p.move(xPos - foot, yPos - meter - foot);
        p.move(xPos - foot, yPos - foot);
        p.move(xPos + foot, yPos - foot);
        p.move(xPos + foot, yPos - meter - foot);
        p.move(xPos - foot, yPos - meter - foot);

    }

    /**
     * This method makes the object into a string layout to be displayed
     * @return the string that shows the object's attributes
     */
    public String toString() {
        String str
                = "Name:\t" + name + "\n"
                + "Age:\t" + age + "\n"
                + "Height:\t" + health + "\n"
                + "X-Pos:\t" + xPos + "\n"
                + "Y-Pos:\t" + yPos + "\n"
                + "Height:\t" + height;
        return str;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the age
     */
    public int getAge() {
        return age;
    }

    /**
     * @param age the age to set
     * @return true or false if the age is valid
     */
    public boolean setAge(int age) {
        boolean changed = true;
        //If the inputted age is outside of the bounds, set the age to the bound
        if (age>HIGH_AGE){
            age = HIGH_AGE;
            changed = false;
        } else if (age<LOW_AGE){
            changed = false;
            age = LOW_AGE;
        }
        
        this.age = age;
        return changed;
    }

    /**
     * @return the health
     */
    public int getHealth() {
        return health;
    }

    /**
     * @param health the health to set
     * @return true or false if the health is valid
     */
    public boolean setHealth(int health) {
        boolean changed = true;
        //If the inputted health is outside of the bounds, set the health to the bound
        if (health>HIGH_HEALTH){
            health = HIGH_HEALTH;
            changed = false;
        } else if (health<LOW_HEALTH){
            health = LOW_HEALTH;
            changed = false;
        }
        
        this.health = health;
        return changed;
    }

    /**
     * @return the xPos
     */
    public int getXPos() {
        return xPos;
    }

    /**
     * @param xPos the xPos to set
     */
    public void setXPos(int xPos) {
        this.xPos = xPos;
    }

    /**
     * @return the yPos
     */
    public int getYPos() {
        return yPos;
    }

    /**
     * @param yPos the yPos to set
     */
    public void setYPos(int yPos) {
        this.yPos = yPos;
    }

    /**
     * @return the height
     */
    public double getHeight() {
        return height;
    }

    /**
     * @param height the height to set
     * @return true or false if the height is valid
     */
    public boolean setHeight(double height) {
        boolean changed = true;
        //If the inputted height is outside of the bounds, set the height to the bound
        if (height>HIGH_HEIGHT){
            height = HIGH_HEIGHT;
            changed = false;
        } else if (height<LOW_HEIGHT){
            height = LOW_HEIGHT;
            changed = false;
        }
        
        this.height = height;
        return changed;
    }

    /**
     * @return the number of humans
     */
    public static int getNumHumans() {
        return NUM_HUMANS;
    }

    /**
     * @param nums the number of humans to set
     */
    public static void setNumsHumans(int nums) {
        //Human population cannot be negative
        if (NUM_HUMANS<0){
            NUM_HUMANS = 0;
        }
        NUM_HUMANS = nums;
    }

    /**
     * The method will give the user the allowed range of age of a human
     *
     * @return the message to be displayed with the allowed range
     */
    public static String getAgeRules() {
        String str = "The age must be: " + LOW_AGE + " < AGE < " + HIGH_AGE + ", inclusive.";
        return str;
    }

    /**
     * The method will give the user the allowed range of height of a human
     *
     * @return the message to be displayed with the allowed range
     */
    public static String getHeightRules() {
        String str = "The height must be: " + LOW_HEIGHT + " < HEIGHT < " + HIGH_HEIGHT + ", inclusive.";
        return str;
    }

    /**
     * The method will give the user the allowed range of health of a human
     *
     * @return the message to be displayed with the allowed range
     */
    public static String getHealthRules() {
        String str = "The health must be: " + LOW_HEALTH + " < HEALTH < " + HIGH_HEALTH + ", inclusive.";
        return str;
    }

}
