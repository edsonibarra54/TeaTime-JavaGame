import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Title here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Title extends Actor
{
    private int dx,dy,tempo;
    
    public Title(){
        dx=dy = 2;
        tempo = 0;
    }
    
    public void act()
    {
        tempo++;
        if(tempo<70){
            setLocation(getX(), getY()+dy);
        }
    }
}
