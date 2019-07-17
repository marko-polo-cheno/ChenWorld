/*
 * Mark Chen
 * Oct 24 2018
 * This is the Farmer class. It extends the AbstractHuman class and has a amount of wheat attribute
 */

package chenworld;

import TurtleGraphics.Pen;
import java.awt.Color;

public class Farmer extends AbstractHuman{
    
    
    private final int LOW_WHEAT = 0;
    private int amtWheat;
    
    /**
     * Primary constructor sets all attributes to a default value
     */
    public Farmer() {
        super();
        amtWheat = 1;
    }
    
    
    /**
     * Secondary constructor takes all attributes of a Farmer and sets them accordingly
     * @param name - the name of the farmer
     * @param age - the age of the farmer
     * @param health - the health of the farmer
     * @param xPos - the x-Pos of the farmer
     * @param yPos - the y-Pos of the farmer
     * @param height - the height of the farmer
     * @param amtWheat - the amount of wheat a farmer has
     */
    public Farmer(String name, int age, int health, int xPos, int yPos, double height, int amtWheat) {
        super(name, age, health, xPos, yPos, height);
        
        //If the wheat amount is less than or equal to what is allowed, se the wheat value to a minimum
        if (amtWheat<=LOW_WHEAT){
            amtWheat = LOW_WHEAT;
        }
        this.amtWheat = amtWheat;
    }
    
    
    /**
     * This method draws the Farmer, setting the color to Green, and drawing the body
     * @param p - the pen used to draw the people
     */
    public void draw(Pen p) {
        p.setColor(Color.GREEN);
        super.draw(p);
        
        //Draw arm
        
        //Unit to draw with
        double foot = height/5.0;
        double meter = foot * 3.0;

        //Moves pen to arm
        p.up();
        p.move(xPos + foot, yPos - foot - foot);
        p.down();
        //Draws arm and fork (fork size based on wheat amt and height)
        p.move(xPos + meter, yPos - foot);
        foot = height/5.0 + amtWheat/8;
        p.move(xPos + meter, yPos - meter-foot);
        p.move(xPos + meter, yPos + 2.42 * foot);
        p.move(xPos + meter, yPos + foot);
        p.move(xPos + meter-foot, yPos +foot + foot);
        p.move(xPos + meter, yPos + foot);
        p.move(xPos + meter+foot, yPos +foot + foot);
        
    }
    
    
    /**
     * This method makes the object into a string layout to be displayed
     * @return the string that shows the object's attributes
     */
    public String toString() {
        String str
                = "Name:\tFarmer " + name + "\n"
                + "Age:\t" + age + "\n"
                + "Health:\t" + health + " HP\n"
                + "X-Pos:\t" + xPos + "\n"
                + "Y-Pos:\t" + yPos + "\n"
                + "Height:\t" + height + " units\n"
                + "Wheat:\t" + amtWheat + " pounds of wheat";
        return str;
    }
    
    
    /**
     * Checks to see if two farmers have the same name, age, health, and height
     * @param f - the farmer to be compared with this one
     * @return true or false if the farmers are similar
     */
    public boolean equals(Farmer f) {
        return  this.name.equals(f.getName()) && 
                this.age == f.getAge() && 
                this.health == f.getHealth() && 
                this.height == f.getHeight();
    }
    
    
    /**
     * This method clones a farmers with the same attributes
     * @return the cloned farmer
     */
    public Wizard clone() {
        return new Wizard(name, age, health, xPos, yPos, height, amtWheat);
    }
    
    
    /**
     * The method will give the user the allowed range of "amtWheat" of a farmer
     * @return the message to be displayed with the allowed range
     */
    public String getAmtWheatRules() {
        String str = "The amtWheat must be: 0 < " + LOW_WHEAT + ".";
        return str;
    }
    

    /**
     * @return the amtWheat
     */
    public int getAmtWheat() {
        return amtWheat;
    }
    

    /**
     *
     * @param amtWheat the amtWheat to set
     * @return true or false if the amtWheat is valid
     */
    public boolean setAmtWheat(int amtWheat) {
        boolean changed = true;
        //If the wheat amount is less than what is allowed, se the wheat value to a minimum
        if (amtWheat<LOW_WHEAT){
            changed = false;
            amtWheat = LOW_WHEAT;
        }
        this.amtWheat = amtWheat;
        return changed;
    }
    
}
