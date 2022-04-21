import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Guardia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
import java.util.List;
public class Guardia extends Enemy
{
    /**
     * Act - do whatever the Guardia wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Guardia()
    {
        super(ListaDeMundoTiles.Gifs());
    }
    public void act()
    {
        List<Heroe> heroe =getObjectsInRange(160,Heroe.class); 
        if(heroe.size()>0 && heroe.get(0).tocando()==0)
        {
            super.act();
        }
        
    }
}