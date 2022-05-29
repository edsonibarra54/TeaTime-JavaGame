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
    
    public boolean isHeroOn()
    {
        return isActive && getOneIntersectingObject(Heroe.class) != null; 
    }
    
    public void act()
    {
        //Si el portal aun no esta activado y el heroe toca el portal este metodo cambiara su estado a activo
        if (!isActive && getOneIntersectingObject(Heroe.class) == null) isActive = true;
    }
}
