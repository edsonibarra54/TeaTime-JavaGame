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
    
    /**
     * Metodo que se encarga de realizar los movimientos de la animacion
     * @param m Indica para que se usara la transicion(0 == transicion de entrada, 1 == transicion de salida, 2 == transicion de fin de juego )
     */
    public Transicion(int m){
        setImage("Transicion.png");
        tempo = 0;
        mode = m;
        if(m == 1 || m == 2){
            this.getImage().setTransparency(0);
        }
    }
    
    /**
     * Metodo que cambia la tranparencia para hacer el efeto de transicion, la transparencia
     * se modificara dependiendo del valor de mode
     */
    public void act(){
        tempo++;
        if(this.mode == 0 && tempo < 50){ //Esta realiza la animacion donde se aclara
            this.getImage().setTransparency(this.getImage().getTransparency() - 5);
        }
        
        if(this.mode == 1 && tempo < 50){ //Esta realiza la animacion donde se oscurece
            this.getImage().setTransparency(this.getImage().getTransparency() + 5);
        }
        
        if(this.mode == 2 && tempo < 254){ //Esta realiza la animacion donde se oscurece para la pantalla de derrota
            this.getImage().setTransparency(this.getImage().getTransparency() + 1);
        }
    }
    
    /**
     * Metodo que devuelve un true si la animacion de la transicion
     * ya ha terminado, devuelve un false si no es asi
     */
    public boolean animacionFinalizada(){ //Indica si la animacion de transicion a sido finalizada
        if(tempo >= 50 && mode < 2){
            return true;
        }
        
        if(tempo >= 254 && mode == 2){
            return true;
        }
        
        return false;
    }
}
