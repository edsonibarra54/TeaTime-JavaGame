import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Button
{
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Play(){
        super("circulo_naranja.png","anillo_azul.png");
    }
    
    @Override
    public void clickedAction(){
        World world = new Sala_1(1);
        Greenfoot.setWorld(world);
    }
}
