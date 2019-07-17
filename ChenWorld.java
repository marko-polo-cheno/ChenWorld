/*
 * Mark Chen
 * October 24 2018
 * Welcome to a world of Knights and Wizards and Farmers.
 * This game will draw the humans on the terrain of ChenWorld.
 */
package chenworld;

import TurtleGraphics.*;
import javax.swing.JOptionPane;

public class ChenWorld {

    public static void main(String[] args) {
        //Hi
        JOptionPane.showMessageDialog(null,"<html><font face='Calibri' size='15' color='red'>Hello\nWelcome to CHENWORLD!");
        
        //Creates a new pen to draw with
        Pen p = new StandardPen(900, 900);
        
        //Declares 5 humans
        AbstractHuman guy1,guy2,guy3,guy4;
        
        //Instantiates a knight
        //Name:Age:Health:X-Pos:Y-Pos:Height:Horse name
        guy1 = new Knight("Albertus Tangus",getRandStat(),getRandStat(),getRandPosition(),getRandPosition(), (double) getRandStat(),"Candy");
        
        //Instantiates a wizard and moves it
        guy2 = new Wizard("Harry", getRandStat(), getRandStat(), getRandPosition(), getRandPosition(), (double) getRandStat(), getRandStat());
        guy2.move(getRandPosition(), getRandPosition());
        
        //Clones the knight and changes its name
        guy3 = ((Knight) guy1).clone();
        guy3.setName("Not-Albertus Tangus");
        
        //Checks if the Knight clone is not equal to the original Knight, and if so: Moves clone
        if (!((Knight)guy3).equals((Knight)guy1)){

            guy3.move(getRandPosition(), getRandPosition());
        }
        
        //Clones the Wizard 
        guy4 = ((Wizard) guy2).clone();
        
        //Checks if the Knight clone is equal to the original Knight, and if so: Moves clone
        if (((Wizard)guy4).equals((Wizard)guy2)){
            guy4.move(getRandPosition(), getRandPosition());
        }
        
        //Extra farmer boi
        AbstractHuman guy5 = new Farmer("Bill", getRandStat(), getRandStat(), getRandPosition(), getRandPosition(), (double) getRandStat(), getRandStat());
        AbstractHuman guy6 = new Farmer("Old MD", getRandStat(), getRandStat(), getRandPosition(), getRandPosition(), (double) getRandStat(), getRandStat());
        AbstractHuman guy7 = new Farmer("Brown", getRandStat(), getRandStat(), getRandPosition(), getRandPosition(), (double) getRandStat(), getRandStat());
        AbstractHuman guy8 = new Farmer("Bob", getRandStat(), getRandStat(), getRandPosition(), getRandPosition(), (double) getRandStat(), getRandStat());
        
        
        //Draws both Knights and both Wizards (and Farmers)
        guy1.draw(p);
        guy2.draw(p);
        guy3.draw(p);
        guy4.draw(p);
        guy5.draw(p);
        guy6.draw(p);
        guy7.draw(p);
        guy8.draw(p);
        
        //Prints the total number of Humans living in ChenWorld.
        System.out.println("Total population of Chen World:\t" + AbstractHuman.getNumHumans());
        
        //Prints a description of all Humans to the console
        System.out.println(guy1);
        System.out.println(guy2);
        System.out.println(guy3);
        System.out.println(guy4);
        System.out.println(guy5);
        System.out.println(guy6);
        System.out.println(guy7);
        System.out.println(guy8);
    }
    
    /**
     * This method will create the random number from within the range of ABOUT -400 to +400 for a position on the canvas
     * @return the position
     */
    public static int getRandPosition(){
        int position = (int)(Math.random()*810)-385;
        return position;
    }
    
    /**
     * This method will create the random number from within the range of most attributes to initialize values for an object
     * @return the random value
     */
    public static int getRandStat(){
        int position = (int)(Math.random()*80)+20;
        return position;
    }

}
