import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Boton que permite iniciar el juego   
*/
public class Jugar_button extends Button
{
    /**
     * Constructor que recibe el nombre de la imagen a asignar
     * @param s nombre de la imagen que se asigna
     */
    public Jugar_button(String s){
        super(s);
    }
    
    /**
     * Maneja la accion a realizar con el click
     */
    public void act()
    {
        handleMouseClicks();
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
