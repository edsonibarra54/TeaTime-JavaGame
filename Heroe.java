import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
/**
 * Write a description of class Heroe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heroe extends Personaje
{
    private int num_image,cambio=0,tempo=0;
    private GifImage myGif = new GifImage("principal_enfrente.gif");
    private GifImage gif_enfrente = new GifImage("principal_enfrente.gif");
    private GifImage gif_espalda = new GifImage("principal_espalda.gif");
    private GifImage gif_derecha = new GifImage("principal_derecha.gif");
    private GifImage gif_izquierda = new GifImage("principal_izquierda.gif");
    /**
     * Act - do whatever the Heroe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Heroe(int vida,int velocidad,String nombre_imagen)
    {
        super(vida,velocidad,nombre_imagen);
    }

    public void act()
    {
        // Add your action code here.
        movimiento();
        opacidad();
        setImage(myGif.getCurrentImage());
    }

    public void opacidad(){
        if(isTouching(HidingTile.class)){
            this.getImage().setTransparency(150);
        }else
            this.getImage().setTransparency(255);
    }

    @Override
    public void movimiento()
    {
        int veloz=(int)velocidad;
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("W")){
            dy = -veloz;
            myGif = gif_espalda;
        }
        if (Greenfoot.isKeyDown("A")){
            dx = -veloz;
            myGif = gif_izquierda;
        }
        if (Greenfoot.isKeyDown("S")){
            dy = veloz;
            myGif = gif_enfrente;
        }
        if (Greenfoot.isKeyDown("D")){
            dx = veloz;
            myGif = gif_derecha;
        }
        setLocation(getX()+dx, getY()+dy);
        if (isTouching(ColliderTile.class))
        {
            setLocation(getX()-dx, getY()-dy);
        }   
        /*else
        {
        Heroe copia = new Heroe(vida,(int)velocidad,imagen);
        World w = getWorld();
        w.addObject(copia,getX(),getY());
        copia.setLocation(getX(),getY());
        if(Greenfoot.isKeyDown("left")){
        copia.setLocation(getX()-veloz,getY());
        }
        if(Greenfoot.isKeyDown("right")){
        copia.setLocation(getX()+veloz,getY());
        }
        if(Greenfoot.isKeyDown("up")){
        copia.setLocation(getX(),getY()-veloz);
        }
        if(Greenfoot.isKeyDown("down")){
        copia.setLocation(getX(),getY()+veloz);
        }
        if(copia.colisionando()==0)
        {
        setLocation(copia.getX(),copia.getY());
        }
        w.removeObject(copia);
        }*/
    }
}
