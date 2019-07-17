/*
 * Mark Chen
 * Oct 24 2018
 * This is the Knight class. It extends the AbstractHuman class and has a horse
 */
package chenworld;

import TurtleGraphics.Pen;
import java.awt.Color;

public class Knight extends AbstractHuman{
    
    private String horseName;
    
    /**
     * Primary constructor sets all the attributes of a knight to a default value
     */
    public Knight() {
        super();
        horseName = "Horsey-thingy";
    }
    
    
    /**
     * Secondary constructor that takes all the attributes and constructs the Knight object with the respective parameters
     * @param name - the name of the knight
     * @param age  - the age of the knight
     * @param health  - the health of the knight
     * @param xPos  - the x-Pos of the knight
     * @param yPos  - the y-Pos of the knight
     * @param height  - the height of the knight
     * @param horseName - the name of the horse of the knight
     */
    public Knight(String name, int age, int health, int xPos, int yPos, double height, String horseName) {
        super(name, age, health, xPos, yPos, height);
        this.horseName = horseName;
    }
    
    
    /**
     * This method draws the Knights, setting the color to Red, and drawing the body
     * @param p - the pen used to draw the people
     */
    public void draw(Pen p){
        
        //Red
        p.setColor(Color.RED);
        
        //Draws outline
        super.draw(p);
        
        
        //Draws the horse
        
        //Head of horse
        //Draws Head as a circle
        double side = 2.0 * Math.PI * height / 120.0;
        p.up();
        p.move(xPos + height, yPos + height / 2.0);
        p.setDirection(90);
        p.down();
        for (int i = 0; i < 120; i++) {
            p.move(side/5);
            p.turn(3);
        }
        
        //Draws body of the horse with legs
        p.up();
        p.move(xPos+height,yPos);
        p.down();
        p.move(xPos+height,yPos-height/3);
        p.move(xPos+height,yPos+height/2);
        p.move(xPos+2.0*height,yPos+height/2);
        p.move(xPos+2.0*height,yPos-height/3);
        p.move(xPos+2.0*height,yPos);
        p.move(xPos+height,yPos);
    
    }
    
    
    /**
     * This method makes the object into a string layout to be displayed
     * @return the string that shows the object's attributes
     */
    public String toString(){
        String str = 
                "Name:\tSir. " + name + "\n" +
                "Age:\t" + age + "\n" +
                "Health:\t" + health  + " HP\n" +
                "X-Pos:\t" + xPos  + "\n" +
                "Y-Pos:\t" + yPos  + "\n" +
                "Height:\t" + height + " units\n" +
                "Horse name:\t" + horseName;
        return str;
    }
    
    
    /**
     * Checks to see if two knights have the same name, age, health, and height
     * @param w - the knight to be compared with this one
     * @return true or false if the knights are similar
     */
    public boolean equals(Knight w){
        return  this.name.equals(w.getName()) && 
                this.age == w.getAge() && 
                this.health == w.getHealth() && 
                this.height == w.getHeight();
    }
    
    
    /**
     * Copies this knight to a new knight with same attributes
     * @return the new knight
     */
    public Knight clone(){
        return new Knight(name, age, health, xPos, yPos, height, horseName);
    }
}
