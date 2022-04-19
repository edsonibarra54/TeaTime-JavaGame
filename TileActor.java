import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TileActor here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class TileActor extends Actor
{
    protected String imagen;
    /**
     * Act - do whatever the TileActor wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        // Add your action code here.
    }
    public void setAbsoluteLocation(int dx) {    
        setLocation(getX()+dx, getY());  
    }
}
