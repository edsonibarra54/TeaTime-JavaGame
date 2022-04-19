import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class HidingTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HidingTile extends TileActor
{
    private GifImage myGif = new GifImage("tall_grass.gif");
    /**
     * Act - do whatever the BushTile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        setImage(myGif.getCurrentImage());
    }   
}
