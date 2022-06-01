import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que muestra el png de la fuente
 */
public class Fuente extends Actor
{
    private GifImage myGif = new GifImage("Fuente.gif");
    
    /**
     * Constructor de clase Fuente
     */
    
    public Fuente(){
        
    }
    
    /**
     * Metodo que ejecuta su gif propio
     */
    
    public void act()
    {
        setImage(myGif.getCurrentImage());
    }
}
