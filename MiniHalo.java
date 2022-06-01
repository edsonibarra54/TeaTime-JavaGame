import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Un HaloTile el cual se puede mantener parado como una linterna
 */
public class MiniHalo extends HaloTile
{
    private boolean sigue=false;
    private Actor nonulo;
    /**
     * Hereda las caracteristicas de HaloTile
       */
    public MiniHalo()
    {
        super();
    }
    /**
     * Verifica si hay un HaloTile encima de este para cambiar su transparencia y ademas verifica si hay un heroe tocandolo para empezar a seguirlo
       */
    public void act()
    {
        if(sigue==false)
        {
            Actor nulo = getOneObjectAtOffset(0,0,Heroe.class);
            nonulo = nulo;
        }
        if(nonulo!=null && sigue==false)
        {
            sigue=true;
        }else
        {
            if(sigue==true)
            {
                setLocation(nonulo.getX(),nonulo.getY());
            }   
        }
    }
}
