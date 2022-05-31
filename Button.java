import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Button extends Actor
{
    private int difficulty;
    
    /**
     * Constructor de boton, recibe una cadena que representa la imagen que mostrará
     * @param s la cadena que será mostrada
     */
    public Button(String s){
        setImage(s);
    }
    
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

    public abstract void clickedAction(); 
}
