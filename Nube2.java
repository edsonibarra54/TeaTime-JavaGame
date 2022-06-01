import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que muestra el png de la nube y genera una nube
 * de la clase Nube2
 */
public class Nube2 extends Nube
{
    private GifImage myGif;
    private int tempo;
    
    public Nube2(String s){
        myGif = new GifImage(s);
    }
    
    /**
     * Metodo que ejecuta su gif propio, despues de cierto tiempo agrega otra nube
     */
    public void act(){
        setImage(myGif.getCurrentImage()); //Se encarga que el gif vaya cambiando de frame
        tempo++;
        
        if(tempo == 500){ //Aqui se instancia un nuevo objeto nube_1 para evitar que todas las nubes salgan al mismo tiempo (Solo es estetico)
            Inicio world = getWorldOfType(Inicio.class);
            Nube1 nube_1 = new Nube1("nube_1.gif");
            world.addObject(nube_1,300,80);
        }
    }
}
