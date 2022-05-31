import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Un objeto que sigue un camino unidireccional en una direccion
 * 
 * @author Alan
 * @version 10.0
 */
public class Arrow extends Projectile
{
    /**
     * Act - do whatever the Arrow wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x,y;
    public Arrow(int x,int y)
    {
        
        super(0,0);
        setImage("muro_1.png");
        getImage().scale(15,15);
        this.getImage().setTransparency(255);
        this.x=x;
        this.y=y;
        /*GifImage nueva = new GifImage("pixil-gif-drawing.gif");
        setImage(nueva.getCurrentImage());*/
    }
    /**
     * verifica si el objeto ha llegado ha tocado un collidertile o al heroe o esta en el limite del mapa, si no sigue avanzando en su eje, y si si se elimina
       */
    public void act()
    {
        if(!isTouching(ColliderTile.class) && !isAtEdge() && !isTouching(Heroe.class))
        {
            setLocation(getX()+x,getY()+y);
        }else
        {
            World objeto = getWorld();
            objeto.removeObject(this);
        }
        //setImage(getImage());
    }
}

