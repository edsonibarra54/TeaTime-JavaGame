import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Trampa que lanza rocas
 * 
 * @author Alan
 * @version 20/05/2022
 */
public class Rock extends TrapTile
{
    /**
     * Constructor que inicializa la trampa con un tiempo de 2 segundos
       */
    public Rock()
    {
        super(100);
        getImage().setTransparency(160);
        setImage("block_2.png");
        getImage().scale(15,15);
    }
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    @Override
    public void act()
    {
    super.act();
    }
    /**
     * Verifica si hay un heroe encima de la trampa, ademas tambien verifica que no haya sido usada en al menos su tiempo de reposicion, en caso de ser cierto, lanza un projectile hacia arriba y que cae hasta la posicion de la roca
       */
    public void actua()
    {
        if(isTouching(Heroe.class) && super.usada==false)
        {
            Projectile roca = new Projectile(getX(),getY());
            World mundo = getWorld();
            mundo.addObject(roca,getX(),getY()-50);
            super.usada=true;
            GreenfootSound sondo= new GreenfootSound("roca.mp3");
            sondo.play();
        }
    }
}