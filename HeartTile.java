import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Corazones ligados al heroe, simboliza su cantidad de errores maximos a cometer
 * 
 * @author Alan
 * @version 10/05/2022
 */
public class HeartTile extends TileActor
{
    /**
     * Se voltea la imagen y se coloca una imagen de corazon completo
       */
    public HeartTile()
    {
        setImage("Corazon_rojo.png");
        getImage().mirrorHorizontally();
    }
    /**
     * verifica si hay heroes en el mundo
       */
    public void act() 
    {
        World mundo = getWorld();
        List<Heroe> heroe = (List<Heroe>)mundo.getObjects(Heroe.class); 
        if(heroe.size()>0)
        {
               
        }
    }
}
