import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class HaloTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class HaloTile extends NoColliderTile
{
    private int existe=1;
    private Heroe heroe = null;
    /**
     * Act - do whatever the HaloTile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
    */
    public HaloTile()
    {
        setImage("circulo_naranja.png");
        getImage().setTransparency(0);
        getImage().scale(60,50);
    }
    public void act()
    {
        World mundo = getWorld();
        List<Heroe> heroe = (List<Heroe>)mundo.getObjects(Heroe.class); 
        if(heroe.size()>0)
        {
            setLocation(heroe.get(0).getX(),heroe.get(0).getY());
        }
    }
}
