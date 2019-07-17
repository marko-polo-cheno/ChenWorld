/*
 * Mark Chen
 * Oct 24 2018
 * This is the Wizard class. It extends the AbstractHuman class and has a
 */
package chenworld;

import TurtleGraphics.Pen;
import java.awt.Color;

public class Wizard extends AbstractHuman {
    //Variables
    private int magicka;
    private static int LOW_MAGICKA = 1;
    private static int HIGH_MAGICKA = 100;
    
    /**
     * Primary constructor sets all attributes to a default value
     */
    public Wizard() {
        super();
        magicka = HIGH_MAGICKA;
    }
    
    /**
     * Secondary constructor takes all attributes of a Wizard and sets them accordingly
     * @param name - the name of the wizard
     * @param age - the age of the wizard
     * @param health - the health of the wizard
     * @param xPos - the x-Pos of the wizard
     * @param yPos - the y-Pos of the wizard
     * @param height - the height of the wizard
     * @param magicka - the magic points of a wizard
     */
    public Wizard(String name, int age, int health, int xPos, int yPos, double height, int magicka) {
        super(name, age, health, xPos, yPos, height);
        
        //Sets the magicka to the boundary if the inputted magicka is not in the allowed range
        if (magicka>HIGH_MAGICKA){
            magicka = HIGH_MAGICKA;
        } else if (magicka<LOW_MAGICKA){
            magicka = LOW_MAGICKA;
        }
        
        this.magicka = magicka;
    }

    /**
     * This method draws the Wizards, setting the color to Blue, and drawing the body
     * @param p - the pen used to draw the people
     */
    public void draw(Pen p) {
        //Blue
        p.setColor(Color.BLUE);
        
        //Draw person
        super.draw(p);
        
        //Moves pen to forehead of head
        p.up();
        p.move(xPos, yPos+height/6.0);
        p.down();
        //Draws triangle wizard hat
        p.move(xPos, yPos+height/6.0);
        p.move(xPos+height/6.0, yPos+height/5.0);
        p.move(xPos, yPos+height/2.0);
        p.move(xPos-height/6.0, yPos+height/5.0);
        p.move(xPos, yPos+height/6.0);
        
    }
    
    /**
     * This method, when invoked will make the wizard do something magical
     */
    public void castSpell() {
        //Check to see if power level is above 20
        if (magicka>19){
            System.out.println("**Pulls a hat out of a rabbit...**");
            magicka-=10; //lose energy over excessive power use
        } else {
            //no power means no magic
            System.out.println("**Pulls a rabbit out of a hat**");
        }
    }

    /**
     * This method makes the object attributes into a string output layout to be displayed
     * @return the string that shows the object's attributes
     */
    public String toString() {
        String str
                = "Name:\tWizard " + name + "\n"
                + "Age:\t" + age + "\n"
                + "Health:\t" + health + " HP\n"
                + "X-Pos:\t" + xPos + "\n"
                + "Y-Pos:\t" + yPos + "\n"
                + "Height:\t" + height + " units\n"
                + "Magicka\t" + magicka + " points";
        return str;
    }

    /**
     * Checks to see if two wizards have the same name, age, health, and height
     *
     * @param w - the wizard to be compared with this one
     * @return true or false if the wizards are similar
     */
    public boolean equals(Wizard w) {
        return  this.name.equals(w.getName()) && 
                this.age == w.getAge() && 
                this.health == w.getHealth() && 
                this.height == w.getHeight();
    }
    
    /**
     * This method clones a wizard with the same attributes
     * @return the cloned wizard
     */
    public Wizard clone() {
        return new Wizard(name, age, health, xPos, yPos, height, magicka);
    }

    /**
     * The method will give the user the allowed range of "magicka" of a wizard
     *
     * @return the message to be displayed with the allowed range
     */
    public String getMagickaRules() {
        String str = "The magicka must be: " + LOW_MAGICKA + " < MAGICKA < + " + HIGH_MAGICKA + ", inclusive.";
        return str;
    }

    /**
     * @return the magicka
     */
    public int getMagicka() {
        return magicka;
    }

    /**
     *
     * @param magicka the magicka to set
     * @return true if the magicka is valid, false if invalid
     */
    public boolean setMagicka(int magicka) {
        boolean changed = true;
        //Sets the magicka to the boundary if the inputted magicka is not in the allowed range
        if (magicka>HIGH_MAGICKA){
            magicka = HIGH_MAGICKA;
            changed = false;
        } else if (magicka<LOW_MAGICKA){
            magicka = LOW_MAGICKA;
            changed = false;
        }
        
        this.magicka = magicka;
        return changed;
    }

}
