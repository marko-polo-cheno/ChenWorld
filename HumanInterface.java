/*
 * This is the interface that is to be implemented by the abstract Human class
 * 
 * 
 */
package chenworld;

import TurtleGraphics.Pen;

public interface HumanInterface {
    //return the name of the human
    public String getName();
    //change the name of the human
    public void setName(String name);
    //return the age of the human
    public int getAge();
    //change the age of the human and return false if invalid age
    public boolean setAge(int age);
    //return the height of the human
    public double getHeight();
    //change the height of the human and return false if invalid height
    public boolean setHeight(double height);
    //return the health of the human
    public int getHealth();
    //change the health of the human and return false if invalid health
    public boolean setHealth(int health);
    //draw a human
    public void draw(Pen p);
    //move a  human
    public void move(int x, int y);
    //return the X position of the human
    public int getXPos();
    //return the Y position of the human
    public int getYPos();
    //return a string representation of the human object
    public String toString();
    
}
