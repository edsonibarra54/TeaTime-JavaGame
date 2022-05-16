import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ShadowTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ShadowTile extends NoColliderTile
{
    /**
     * Act - do whatever the ShadowTile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public ShadowTile()
    {
        this.getImage().setTransparency(220);
        this.getImage().scale(25,25);
    }
    public void act()
    {
        if(isTouching(HaloTile.class))
        {
            this.getImage().setTransparency(0);    
        }else
        {
        this.getImage().setTransparency(220);
        }
        
    }
}
