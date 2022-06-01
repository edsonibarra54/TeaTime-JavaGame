import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Boton que permite acceder a la guia del juego
 */

public class Guia_button extends Button
{ 
    int index = 0;
    /**
     * Constructor de la clase Guia_button que recibe el nombre 
     * de la imagen a asignar
     * @param s nombre de la imagen que se asigna
     */
    
    public Guia_button(String s){
        super(s);
    }
    /**
     * Se encarga de manejar el click 
     */
    public void act()
    {
        handleMouseClicks();
    }
    /**
     * Cuando se hace click, se intancia un objeto de tipo guia y se añade al mapa
     */
    @Override
    public void clickedAction(){
         Guia guia = new Guia();
         World w = getWorld();
         w.addObject(guia, 300, 200);
    }
}
