
import kareltherobot.*;
import java.awt.Color;

/**
 * Write a concise summary of class KarelAwesomeAdventureTester here.
 * 
 * @author  (your name) 
 *   With assistance from (list of people who helped)
 *
 * @version (a version number or a date) 
 */
public class KarelAwesomeAdventureTester implements Directions
{
    /**
     * Creates and positions a robot.
     *
     * @param args arguments from the command line
     */
    public static void main(String [] args)
    {    
        World.reset();
        //World.readWorld("C:/Program Files (x86)/BlueJ/Karel/worldFilesDOS/fig3-2.kwld");  // use for PC
        //World.readWorld("/worldFilesDOS/fig3-2.kwld");    // use for MAC 
        
        /* Sets up the GUI for the Karel world. */
        World.setVisible(true);
        World.setDelay(20);
        World.setSize(10,10);
        //World.showSpeedControl(true); // use setDelay method as above
        WorldBuilder myBuilder = new WorldBuilder(false); 
        
        /* Creates a robot */
        Robot karel = new Robot(1, 1, East, 0);
        
        karel.setUserPause(true); //enables use of userPause
        karel.userPause("start. Press [enter/return] to start");//pauses
        
        /* Calls the method(s)to be tested. */
    }
}