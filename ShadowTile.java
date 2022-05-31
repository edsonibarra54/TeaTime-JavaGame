import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Un objeto el cual cambia su transparencia con HaloTile
 * 
 * @author Alan
 * @version 21/05/2022
 */
public class ShadowTile extends NoColliderTile
{
    /**
     * Un constructor que modifica la transparencia del objeto
       */
    public ShadowTile()
    {
        this.getImage().setTransparency(220);
        this.getImage().scale(25,25);
    }
    /**
     * verifica que no este un HaloTile tocandolo, y si si se vuelve transparente
       */
    public void act()
    {
        if(isTouching(HaloTile.class))
        {
            this.getImage().setTransparency(0);    
        }else
        {
        this.getImage().setTransparency(220);
        }
        
    }
}
