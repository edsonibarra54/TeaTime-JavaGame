import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
/**
 * Clase que representa la funcionalidad de un boton
 * al cual se le puede dar click
 */
public abstract class Button extends Actor
{
    
    /**
     * Constructor de boton, recibe una cadena que representa la imagen que mostrará
     * @param s la cadena que será mostrada
     */
    public Button(String s){
        setImage(s);
    }
    /**
     * Se encarga de manejar el click 
     */
    public void act() 
    {
        handleMouseClicks();
    }
    
    /**
     * Metodo que maneja la accion que cada boton va a realizar cuando se da un click
     */ 
    protected void handleMouseClicks(){
        if(Greenfoot.mousePressed(this)){
            clickedAction();
        }
    } 
    /**
     * Accion a realizar cuando se da click, cada subclase define su propia accion 
     */
    public abstract void clickedAction(); 
}
