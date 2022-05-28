import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Heroe_animacion here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heroe_animacion extends Personaje
{
    private GifImage myGif = new GifImage("principal_enfrente.gif");
    private GifImage gif_enfrente = new GifImage("principal_enfrente.gif");
    private GifImage gif_espalda = new GifImage("principal_espalda.gif");
    private GifImage gif_derecha = new GifImage("principal_derecha.gif");
    private GifImage gif_izquierda = new GifImage("principal_izquierda.gif");
    private GreenfootSound sonido=new GreenfootSound("pasto.mp3");
    
    public Heroe_animacion(String nombre_imagen)
    {
        super(nombre_imagen);
    }
    
    @Override
    public void movimiento()
    {
        //int veloz=(int)velocidad;
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("W")){
            dy = -this.velocidadY;
            myGif = gif_espalda;
        }
        if (Greenfoot.isKeyDown("A")){
            dx = -this.velocidadX;
            myGif = gif_izquierda;
        }
        if (Greenfoot.isKeyDown("S")){
            dy = this.velocidadY;
            myGif = gif_enfrente;
        }
        if (Greenfoot.isKeyDown("D")){
            dx = this.velocidadX;
            myGif = gif_derecha;
        }
        setLocation(getX()+dx, getY()+dy);
        if (isTouching(ColliderTile.class))
        {
            setLocation(getX()-dx, getY()-dy);
        }   
    }
    
    public void act()
    {
        // Add your action code here.
    }
}
