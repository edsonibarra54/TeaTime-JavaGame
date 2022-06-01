import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que muestra el png de la nube
 */
public class Nube1 extends Nube
{
    private GifImage myGif;
    
    /**
     * Constructor de clase Fuente que indica el gif que mostrara
     * @s nombre del gif que se le asigna
     */
    public Nube1(String s){
        myGif = new GifImage(s);
    }
    
    /**
     * Metodo que ejecuta su gif propio
     */
    public void act(){
        setImage(myGif.getCurrentImage()); //Se encarga que el gif vaya cambiando de frame
    }
}
