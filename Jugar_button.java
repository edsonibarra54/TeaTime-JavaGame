import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Jugar_button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Jugar_button extends Button
{
    public Jugar_button(String s){
        super(s);
    }
    /**
     * Act - do whatever the Jugar_button wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public void act()
    {
        handleMouseClicks();        // Add your action code here. 
    } 
    
    
    /**
     * Cuando se hace click, se resetean diversos datos estaticos, además de instanciar la animacion inicial
     */
    @Override
    public void clickedAction(){
        Ingredientes_list.resetIngredients();
        World  w = this.getWorld();
        JukeBox.changeSong("Animacion.mp3");
        World world = new Sala_0(); 
        Greenfoot.setWorld(world);
    }
}
