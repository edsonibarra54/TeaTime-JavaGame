
import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Que instancia Arrows hacia una direccion segun el constructor
 * 
 * @author Alan
 * @version 20/05/2022
 */
public class ArrowDispenserTile extends TrapTile
{
    private int x,y;
    /**
     * @params int un entero el cual simboliza en que eje ira la flecha lanzada
     * @params int un entero que simboliza el tiempo de espera, se multiplica por 1/50 para conocer los segundos de espera
       */
    public ArrowDispenserTile(int eje,int tiempodeespera)
    {
        super(200);
        setImage("Muro.png");
        if(eje==1)
        {
            x=3;
            y=0;
        }
        if(eje==2)
        {
            x=-3;
            y=0;
        }
        if(eje==3)
        {
            x=0;
            y=3;
        }
        if(eje==4)
        {
            x=0;
            y=-3;
        }
        getImage().scale(25,25);
    }
    /**
     * @params int un entero el cual simboliza en que eje ira la flecha lanzada
       */
    public ArrowDispenserTile(int eje)
    {
        super(200);
        setImage("Muro.png");
        if(eje==1)
        {
            x=3;
            y=0;
        }
        if(eje==2)
        {
            x=-3;
            y=0;
        }
        if(eje==3)
        {
            x=0;
            y=3;
        }
        if(eje==4)
        {
            x=0;
            y=-3;
        }
        getImage().scale(25,25);
    }
     /**
     * Act - do whatever the ArrowDispenserTile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act()
    {
    super.act();
    
    }
    /**
     * Verifica si hay un heroe encima de la trampa, ademas tambien verifica que no haya sido usada en al menos su tiempo de reposicion, en caso de ser cierto, lanza un Arrow hacia el eje indicado
       */
    public void actua()
    {
        if(getNeighbours(300,false,Heroe.class).size()>0 && super.usada==false)
        {
            Arrow arrow = new Arrow(x,y);
            World mundo = getWorld();
            mundo.addObject(arrow,getX()+(x*2),getY()+(y*2));
            super.usada=true;
            GreenfootSound sondo= new GreenfootSound("flecha lanzada.mp3");
            sondo.play();
        }
    }
}