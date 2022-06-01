import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que muestra si perdiste o ganaste
 */
public class FinJuego extends Actor
{
    private int tempo;
    
    /**
     * Constructor de clase FinJuego donde se le asigna a tempo el
     * valor de 0 y hacemos transparente el png
     * @s nombre de la imagen que se asigna
     */
    
    public FinJuego(String s){
        setImage(s);
        tempo = 0;
        this.getImage().setTransparency(0);
    }
    
    /**
     * Metodo que se encarga de ir cambiando la transparencia hasta que llegue
     * a 255 que es el maximo
     */
    
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
