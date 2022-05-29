import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PortalTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PortalTile extends TileActor
{
    boolean isActive;
    
    public PortalTile(int x){
        setImage("circulo_naranja.png");
        getImage().setTransparency(150);
        if(x == 1){
            getImage().scale(5,50);
        }
        if(x == 0){ 
            getImage().scale(50,5);
        }
    }
    
    public boolean isHeroOn()
    {
        return isActive && getOneIntersectingObject(Heroe.class) != null;
    }
    
    public void act()
    {
        if (!isActive && getOneIntersectingObject(Heroe.class) == null) isActive = true;
    }
}
