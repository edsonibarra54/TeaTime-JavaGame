import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Transicion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Transicion extends Actor
{
    private int mode; //Indicara si el fondo negro se oscurecera o aclarara
    private int tempo;
    private String image;
    
    
    public Transicion(int m){
        setImage("Transicion.png");
        tempo = 0;
        mode = m;
        if(m == 1){
            this.getImage().setTransparency(0);
        }
    }
    
    public void act(){
        tempo++;
        if(this.mode == 0 && tempo < 50){ //Esta realiza la animacion donde se aclara
            this.getImage().setTransparency(this.getImage().getTransparency() - 5);
        }
        
        if(this.mode == 1 && tempo < 50){ //Esta realiza la animacion donde se oscurece
            this.getImage().setTransparency(this.getImage().getTransparency() + 5);
        }
    }
    
    public boolean animacionFinalizada(){ //Indica si la animacion de transicion a sido finalizada
        if(tempo >= 50){
            return true;
        }
        else{
            return false;
        }
    }
}
