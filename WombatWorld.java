import greenfoot.*;  // imports Actor, World, Greenfoot, GreenfootImage

/**
 * A world where wombats live.
 * 
 * @author Michael Kölling
 * @version 2.0
 */
public class WombatWorld extends World
{
    /**
     * Create a new world with 10x10 cells and
     * with a cell size of 60x60 pixels.
     */
    public WombatWorld() 
    {
        super(10, 10, 60);        
        setBackground("cell.jpg");
        setPaintOrder(Wombat.class, Leaf.class);  // draw wombat on top of leaf
        populate();
    }

    /**
     * Populate the world with a fixed scenario of wombats and leaves.
     */    
    private void populate()
    {
        addObject(new Wombat(), 7, 1);
        addObject(new Wombat(), 6, 6);
        addObject(new Wombat(), 1, 7);
    }
    
}