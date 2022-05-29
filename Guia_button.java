import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Guia_button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Guia_button extends Button
{
    public Guia_button(String s){
        super(s);
    }
    /**
     * Act - do whatever the Guia_button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        handleMouseClicks();
        // Add your action code here.
    }
    
    @Override
    public void clickedAction(){
        
    }
}
