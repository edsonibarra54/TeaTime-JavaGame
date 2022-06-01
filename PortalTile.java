import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class PortalTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class PortalTile extends TileActor
{
    boolean isActive; //Estado en el que se encuentra el portal
    
    /**
     * Constructor de PortalTile 
     * @param x Indica si el portal tendra la posicion vertical u horizontal (0 == horizontal, 1 == vertical) 
     */
    public PortalTile(int x){
        setImage("circulo_naranja.png");
        getImage().setTransparency(0);
        if(x == 1){ //Un 1 significa que el portal sera Vertical 
            getImage().scale(5,50);
        }
        if(x == 0){ //Un 0 significa que el portal sera Horizontal
            getImage().scale(50,5);
        }
    }
    
    /**
     * Metodo que devuelve si se encuentra activo el portal y si un objeto de la
     * clase Heroe lo esta tocando
     */
    public boolean isHeroOn()
    {
        return isActive && getOneIntersectingObject(Heroe.class) != null; 
    }
    
    /**
     * Metodo que devuelve si se encuentra activo el portal y si un objeto de la 
     * clase Heroe_animacion lo esta tocando
     */
    public boolean isHeroAnimationOn()
    {
        return isActive && getOneIntersectingObject(Heroe_animacion.class) != null; 
    }
    
    /**
     * Metodo que marca como activo el portal si se encuentra inactivo y un objeto de la
     * clase heroe o heroe_animacion esta tocando el portal
     */
    public void act()
    {
        //Si el portal aun no esta activado y el heroe toca el portal este metodo cambiara su estado a activo
        if ((!isActive && getOneIntersectingObject(Heroe.class) == null) || (!isActive && getOneIntersectingObject(Heroe_animacion.class) == null)) isActive = true;
    }
}
