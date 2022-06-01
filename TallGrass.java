import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Una celda que representa cesped alto
 */
public class TallGrass extends HidingTile
{
    private GifImage myGif = new GifImage("tall_grass.gif");
    /**
     * Setea la imagen de la clase con el gif correspondiente
     */
    public void act()
    {
        setImage(myGif.getCurrentImage());
    }
}
