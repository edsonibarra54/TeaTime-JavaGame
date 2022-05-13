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
            setLocation(getX(), getY() + dy);
        }
        else{
            if (Greenfoot.isKeyDown("SPACE")){
                Inicio world = getWorldOfType(Inicio.class);
                world.removeObject(this);
                Button button = new Play();
                world.addObject(button,291,271);
                button.setLocation(301,301);
            }
        }
    }
}
