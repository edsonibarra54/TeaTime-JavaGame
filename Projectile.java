import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que instancia objetos que siguen direcciones especificas y lineales
 * 
 * @author Alan
 * @version 20/05/2022
 */
public class Projectile extends Actor
{

    private int destinoX,destinoY,transparency=30;
    /**
     * Constructor que toma dos direcciones en las cuales cuaando llegue este objeto sera removido del mundo
     * @params int lugar de destinoX
     * @params int lugar de destinoY
       */
    public Projectile(int destinoX,int destinoY)
    {
        this.getImage().setTransparency(30);
        this.destinoX=destinoX;
        this.destinoY=destinoY;
    }
    /**
     * verifica si el objeto ha llegado al lugar de destino, si no sigue avanzando en su eje, y si si se elimina
       */
    public void act()
    {
        if(getX()==destinoX && destinoY==getY())
        {
            World mundo = getWorld();
            mundo.removeObject(this);
        }else
        {

        this.getImage().setTransparency(transparency+4);
        transparency+=4;
        turn(5);
        setLocation(getX(),getY()+1);
        }
    }
}
