import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Reina here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Reina extends Personaje
{
    private GifImage myGif = new GifImage("reina_enfrente.gif");
    private GifImage gif_enfrente = new GifImage("reina_enfrente.gif");
    private GifImage gif_c_enfrente = new GifImage("reina_caminando_enfrente.gif");
    private GifImage gif_espalda = new GifImage("reina_espalda.gif");
    private GifImage gif_c_espalda = new GifImage("reina_caminando_espalda.gif");
    private GifImage gif_derecha = new GifImage("reina_derecha.gif");
    private GifImage gif_izquierda = new GifImage("reina_izquierda.gif");
    private int numeroAnimacion,momentoAnimacion = 0;
    private int tempo = 0;
    private int dx = 0,dy = 0;
    
    public Reina(){
        super(1,1,1,"reina_enfrente.gif");
        numeroAnimacion = 1;
    }
    
    @Override
    public void movimiento() //Con este metodo logramos que el personaje se mueva 
    {
       this.setLocation(this.getX()+dx,this.getY()+dy);
    }
    
    public void act()
    {
        tempo++;
        setImage(myGif.getCurrentImage());
        camino(tempo,numeroAnimacion);
    }
    
    public void cambiaImagen(){ //Este metodo cambia el gid del personaje dependiendo de hacia donde se este moviendo
        if(this.dy == 0){
            if(this.dx > 0){
                myGif = gif_derecha;
            }else if(this.dx < 0){
                myGif = gif_izquierda;
            }
        }
        
        if(this.dx == 0){
            if(this.dy > 0){
                myGif = gif_c_enfrente;
            }else if(this.dy < 0){
                myGif = gif_c_espalda;
            }
        }
        
    }
    
    private void camino(int t, int n){ //Este metodo es el que indica hacia donde moverse dependiendo del tiempo
        if(n == 1){ //Indica que esta rezlizando la animacion numero 1
            if(t < 50 && momentoAnimacion == 0){
                dx = 0;
                dy = velocidadY;
                cambiaImagen();
            }
            if(t >= 50 && t < 300 && momentoAnimacion == 0){
                dy = 0;
                dx = -velocidadX;
                cambiaImagen();
            }
            if(t >= 300 && t < 320 && momentoAnimacion == 0){
                dx = 0;
                dy = -velocidadY;
                cambiaImagen();
            }
            if(t == 320 && momentoAnimacion == 0){
                dy = 0;
                dx = 0;
                myGif = gif_enfrente;
                cambiaImagen();
            }
            movimiento();
        }
    }
    
    void setTempo(int t){ //Este metodo tiene la finalidad de reiniciar el tiempo al que nosotros deseemos
        this.tempo = t;
    }
}
