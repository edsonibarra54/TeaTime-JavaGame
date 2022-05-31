import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Fuente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Fuente extends Actor
{
    private GifImage myGif = new GifImage("Fuente.gif");
    
    public Fuente(){
        
    }
    
    public void act()
    {
        setImage(myGif.getCurrentImage());
    }
}
