import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa una celda con la imagen del ingrediente
 * es usada por el contador para asi generar ingredientes sin sus 
 * correspondientes funciones
 */
public class IngredientTile extends TileActor
{
    /**
     * Se setea la imagen con el nombre correspondiente
     * @param s el nombre de la imagen 
     */
    public IngredientTile(String s){
        setImage(s);
    }

}
