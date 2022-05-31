import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class FinJuego here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class FinJuego extends Actor
{
    private int tempo;
    
    public FinJuego(String s){
        setImage(s);
        tempo = 0;
        this.getImage().setTransparency(0);
    }
    
    public void act()
    {
        tempo++;
        if(tempo >= 255 && tempo < 497){ //Esta realiza la animacion donde se aclara 
            this.getImage().setTransparency(this.getImage().getTransparency() + 1);
        }
        if(Greenfoot.isKeyDown("SPACE") && tempo >= 497){
            World w = new Inicio();
            Greenfoot.setWorld(w);
        }
    }
}
