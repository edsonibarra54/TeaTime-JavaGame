import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Personaje here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Personaje extends Actor
{
    protected int vida;
    protected int velocidadX,velocidadY;
    protected String imagen;
    /**
     * Act - do whatever the Personaje wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Personaje(int vida,int velocidadX,int velocidadY,String imagen){
        this.vida = vida;
        this.velocidadX = velocidadX;
        this.velocidadY = velocidadY;
        this.imagen = imagen;
        cambiaImagen(this.imagen);
    }
    public int getvida()
    {
        return vida;
    }
    public void setvida(int x)
    {
        this.vida=x;
    }
    public abstract void act();
        
    
    protected void cambiaImagen(String imagen)
    {
        this.imagen=imagen;
        GifImage nueva = new GifImage(this.imagen);
        setImage(nueva.getCurrentImage());
    }
    /*protected int colisionando()
    {
        Actor a;
        int colision=0;
        a=getOneObjectAtOffset(0,0,TileActor.class);
        if(a!=null)
        {
            if(a instanceof WallTile)
            {
                colision=1;   
            }
        }
        return colision;
    }*/
    public abstract void movimiento();
}
