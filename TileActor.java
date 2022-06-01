import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * El tileactor es el componente con el cual estan dibujados los mapas
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
    /**
     * se pone la ubicacion de la tile
     */
    public void setAbsoluteLocation(int dx) {    
        setLocation(getX()+dx, getY());  
    }
}
