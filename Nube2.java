import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nube2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nube2 extends Nube
{
    private GifImage myGif;
    private int tempo;
    
    public Nube2(String s){
        myGif = new GifImage(s);
    }
    
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
