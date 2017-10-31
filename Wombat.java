import greenfoot.*;  // (World, Actor, GreenfootImage, and Greenfoot)

/**
 * Wombat. A Wombat moves forward until it hits the edge of the world, at
 * which point it turns left. If a wombat finds a leaf, it eats it.
 * 
 * @author Michael Kölling
 * @version 2.0
 */
public class Wombat extends Actor
{
    private int leavesEaten;

    public Wombat()
    {
        leavesEaten = 0;
    }

    /**
     * Do whatever the wombat likes to to just now.
     */
    public void act()
    {
        if( Greenfoot.getRandomNumber(300) < 5 )
        {
            turnLeft();
        }
        
        if( foundLeaf() == true )
        {
            eatLeaf();
        }
        else if( canMove() == true )
        {
            move();
        }
    }

    /**
     * Move one step forward.
     */
    private void move()
    {
        move(1);
    }

    /**
     * Turn left by 90 degrees.
     */
    private void turnLeft()
    {
        turn(-90);
    }

    /**
     * Set the direction we're facing. The 'direction' parameter must
     * be in the range [0..3].
     */
    private void setDirection(int direction)
    {
        if ((direction >= 0) && (direction <= 3)) 
        {
            setRotation(direction * 90);
        }
    }

    /**
     * Tell how many leaves we have eaten.
     */
    private int getLeavesEaten()
    {
        return leavesEaten;
    }
    
    private boolean foundLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        boolean found = false;
        
        if( leaf == null )
        {
            found = false;
        }
        else
        {
            found = true;
        }
        
        return found;
    }
    
    private void eatLeaf()
    {
        Actor leaf = getOneObjectAtOffset(0, 0, Leaf.class);
        
        if( leaf != null )
        {
            getWorld().removeObject(leaf);
            leavesEaten++;
        }
    }
    
    private boolean canMove()
    {
        int rotation = getRotation();
        int x = getX();
        int y = getY();
        boolean facingEdge = false;
        
        if( rotation == 0 )
        {
            facingEdge = ( x == getWorld().getWidth() - 1 );
        }
        else if( rotation == 90 )
        {
            facingEdge = ( y == getWorld().getHeight() - 1 );
        }
        else if( rotation == 180 )
        {
            facingEdge = ( x == 0 );
        }
        else
        {
            facingEdge = ( y == 0 );
        }
    }
    
    
    
    
    
    
    
    
    
}
