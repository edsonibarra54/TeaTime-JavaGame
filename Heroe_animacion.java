import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heroe_animacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heroe_animacion extends Personaje
{
    private GreenfootSound sound;
    private GifImage myGif = new GifImage("principal_enfrente.gif");
    private GifImage gif_enfrente = new GifImage("principal_enfrente.gif");
    private GifImage gif_espalda = new GifImage("principal_espalda.gif");
    private GifImage gif_derecha = new GifImage("principal_derecha.gif");
    private GifImage gif_izquierda = new GifImage("principal_izquierda.gif");
    private GreenfootSound sonido=new GreenfootSound("pasto.mp3");
    private int numeroAnimacion,momentoAnimacion = 0;
    private int tempo = 0;
    private int dx = 0,dy = 0;
    
    public Heroe_animacion(int vida,int velocidadX,int velocidadY,String nombre_imagen,int n)
    {
        super(vida,velocidadX,velocidadY,nombre_imagen);
        numeroAnimacion = n;
    }
    
    @Override
    public void movimiento()
    {
       this.setLocation(this.getX()+dx,this.getY()+dy);
    }
    
    public void act()
    {
        tempo++;
        setImage(myGif.getCurrentImage());
        camino(tempo,numeroAnimacion);
        if(getWorld() == null) return;
    }
    
    public void cambiaImagen(){
        if(this.dy == 0){
            if(this.dx > 0){
                myGif = gif_derecha;
            }else{
                myGif = gif_izquierda;
            }
        }
        
        if(this.dx == 0){
            if(this.dy > 0){
                myGif = gif_enfrente;
            }else{
                myGif = gif_espalda;
            }
        }
        
    }
    
    private void camino(int t, int n){
        if(n == 1){
            if(t < 40 && momentoAnimacion == 0){
                myGif = gif_espalda;
            }
            if(t >= 40 && t < 80 && momentoAnimacion == 0){
                myGif = gif_enfrente;
            }
            if(t >= 80 && t < 120 && momentoAnimacion == 0){
                myGif = gif_derecha;
            }
            if(t >= 120 && t < 160 && momentoAnimacion == 0){
                myGif = gif_enfrente;
            }
            if(t >= 160 && t < 172 && momentoAnimacion == 0){
                dy = velocidadY;
                cambiaImagen();
            }
            if(t >= 172 && t < 199 && momentoAnimacion == 0){
                dy = 0;
                dx = velocidadX;
                cambiaImagen();
            }
            if(t >= 199 && t < 211 && momentoAnimacion == 0){
                dx = 0;
                dy = -velocidadY;
                cambiaImagen();
            }
            if(t == 211 && momentoAnimacion == 0){
                dx = dy = 0;
            }
            if(t == 220 && momentoAnimacion == 0){
                sound = new GreenfootSound("Carta.mp3");
                Carta carta = new Carta();
                World  w = this.getWorld();
                w.addObject(carta,300,200);
                sound.setVolume(100);
                sound.play();
            }
            if(Greenfoot.isKeyDown("SPACE") && t > 220 && momentoAnimacion == 0){
                sound.setVolume(100);
                sound.play();
                World w = this.getWorld();
                Casa casa = w.getObjects(Casa.class).get(0);
                casa.cambiaCasa();
                w.removeObjects(w.getObjects(Carta.class));
                momentoAnimacion = 1;
                setTempo(0);
            }
            if(t < 20 && momentoAnimacion == 1){
                myGif = gif_enfrente;
            }
            if(t >= 20 && t < 32 && momentoAnimacion == 1){
                dx = 0;
                dy = velocidadY;
                cambiaImagen();
            }
            if(t >= 32 && t < 59 && momentoAnimacion == 1){
                dx = -velocidadX;
                dy = 0;
                cambiaImagen();
            }
            if(t >= 59 && t < 78 && momentoAnimacion == 1){
                dx = 0;
                dy = velocidadY;
                cambiaImagen();
            }
            if(t == 78 && momentoAnimacion == 1){
                dx = dy = 0;
                World w = this.getWorld();
                Heroe hero = new Heroe(Dificultad.vidaHeroe,2,2,"principal_enfrente.gif");
                w.addObject(hero,this.getX(),this.getY());
                w.removeObject(this);
                if(getWorld() == null) return;
            }
            movimiento();
        }
    }
    
    void setTempo(int t){
        this.tempo = t;
    }
}
    

