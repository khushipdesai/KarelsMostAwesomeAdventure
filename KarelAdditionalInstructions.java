
import kareltherobot.*;
import java.awt.KeyboardFocusManager;
import java.awt.event.KeyEvent;
import java.awt.KeyEventDispatcher;
import java.awt.Color;

/**
 * The robot does additional instructions: turn right, turn around, moves down, jump up,
 *  glide down, climb stairs, goes down stairs, move left, make left turn, make right turn, 
 *  jump hurdles, race strides, face south, face north, face east, face west, move in opp
 *  direction, checks if right is clear, moves down across and goes to origin
 * 
 * @author  Khushi
 *   With assistance from 
 *
 * @version 06/25/2017
 */
public class KarelAdditionalInstructions extends Robot
{
    /**
     * Creates a KarelAdditionalInstructions object.
     *
     * @param street     specifies the vertical position on the grid
     *                   of this robot.
     * @param avenue     specifies the horizontal position on the grid
     *                   of this robot.
     * @param direction  specifies the direction of this robot.
     * @param beepers    specifies this robot's number of beepers.
     */
    public KarelAdditionalInstructions (int street, int avenue, 
           Direction direction, int beepers)
    {
        super(street, avenue, direction, beepers);
    }
    /* KarelAdditionalInstructions methods: */
    /**
     * karel turns right
     * @precondition none
     * @postcondition turned right
     */
    public void turnRight()
    {
        turnLeft();
        turnLeft();
        turnLeft();
    }
    
     /**
     * karel turns around
     * @precondition none
     * @postcondition turned around
     */
    public void turnAround()
    {
        turnLeft();
        turnLeft();
    }
    
     /**
     * moves down one block facing same direction
     * @precondition facing north
     * @postcondition faces same direstion moved one block down
     */
    public void moveDown()
    {
        turnAround();
        move();
        turnAround();
    }
    
    /**
     * jumps up one block
     * @precondition facing east
     * @postcondition facing east one block up from starting position
     */
    public void jumpUp()
    {
        turnLeft();
        move();
        turnRight();
    }
    
    /**
     * glides down one block
     * @precondition facing east
     * @postcondition facing east one block down from starting position
     */
    public void glideDown()
    {
        turnRight();
        move();
        turnLeft();
    }
    
    /**
     * karel climbs up stairs
     * @precondition none
     * @postcondition climbed up stairs
     */
    public void climbStairs()
    {
        turnLeft();
        move();
        turnRight();
        move();
    }
    
    /**
     * karel goes down stairs
     * @precondition none
     * @postcondition went down the stairs
     */ 
    public void goDownStairs()
    {
        move();
        turnLeft();
        move();
        turnRight();
    }
    
    /**
     * karel moves left
     * @precondition none
     * @postcondition moves left still facing same direction as started
     */ 
    public void moveLeft()
    {
        turnLeft();
        move();
        turnRight();
    }
    
    /**
     * turns left around to face the next row
     * @precondition facing east one block away from end of the first row
     * @postcondition facing second row one block away
     */
    public void makeLeftTurn()
    {
        turnLeft();
        move();
        turnLeft();
    }
    
    /**
     * turns right around to face the next row
     * @precondition facing west one block away from the end of the original row
     * @postcondition facing the next row one block away
     */
    public void makeRightTurn()
    {
        turnRight();
        move();
        turnRight();
    }
    
    /**
     * jumps over a wall hurdle and comes back down
     * @precondition facing east, in front of wall
     * @postcondition facing east, jumped over wall
     */
    public void jumpHurdle()
    {
        jumpUp();
        move();
        glideDown();
    }
    
    /**
     * checks if there is a wall in front of karel and then strides forward
     * @precondition facing east either wall present or not present
     * @postcondition facing east, either moves forward if no wall 
     * or jumps over in presence of wall
     */
    public void raceStride()
    {
        if(frontIsClear())
        {
            move();
        }
        else
        {
            jumpHurdle();
        }
    }
    
    /**
     * faces south
     * @precondition none
     * @postcondition karel faces south
     */
    public void faceSouth()
    {
        while(!facingSouth())
        {
            turnLeft();
        }
    }
    
    /**
     * faces north
     * @precondition none
     * @postcondition karel faces north
     */
    public void faceNorth()
    {
        while(!facingNorth())
        {
            turnLeft();
        }
    }
    
    /**
     * faces east
     * @precondition none
     * @postcondition karel faces east
     */
    public void faceEast()
    {
        while(!facingEast())
        {
            turnLeft();
        }
    }
    
    /**
     * faces west
     * @precondition none
     * @postcondition karel faces west
     */
    public void faceWest()
    {
        while(!facingWest())
        {
            turnLeft();
        }
    }
    
     /**
     * moves down one block facing same direction
     * @precondition facing north
     * @postcondition faces same direstion moved one block down
     */
    public void moveOppDirection()
    {
        turnAround();
        move();
        turnAround();
    }
    
    /**
     * checks if right side is clear
     * @precondition facing any direction 
     * @postcondition facing same direction and has checked if right side is clear
     * 
     * @return true if right side is clear else returns false
     */
    public boolean rightIsClear()
    {
        turnRight();
        if(frontIsClear())
        {
            turnLeft();
            return true;
        }
        else
        {
            turnLeft();
            return false;
        }
    }
    
    /**
     * moves all the way down
     * @precondition facing any direction 
     * @postcondition moved all the way down and facing north
     */
    public void moveDownAcross()
    {
        faceSouth();
        while(frontIsClear())
        {
            move();
        }
        faceNorth();
    }
    
    /**
     * goes to the origin
     * @precondition anywhere on the grid
     * @postcondition at the origin facing north
     */
    public void goToOrigin()
    {
        faceWest();
        while(frontIsClear())
        {
            move();
        }
        moveDownAcross();
    }
    
}
