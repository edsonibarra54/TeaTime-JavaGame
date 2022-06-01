import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que muestra el png de la casa
 */

public class Casa extends Actor
{
    private String image;
    
    /**
     * Constructor de clase Casa
     * @s nombre de la imagen que se asigna
     */
    
    public Casa(String s){
        image = s;
        setImage(image);
    }
    
    /**
     * Cambia el png de la casa a al de casa_2
     */
    
    public void cambiaCasa(){ //Este metodo cambia el sprite de la casa a cuando ya no tiene carta
        setImage("casa_2.png");
    }
}
