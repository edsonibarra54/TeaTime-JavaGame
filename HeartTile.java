import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class HeartTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HeartTile extends TileActor
{
    /**
     * Act - do whatever the HeartTile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public HeartTile()
    {
        setImage("Corazon_rojo.png");
        getImage().mirrorHorizontally();
    }
    public void act() 
    {
        World mundo = getWorld();
        List<Heroe> heroe = (List<Heroe>)mundo.getObjects(Heroe.class); 
        if(heroe.size()>0)
        {
               
        }
    }
}
