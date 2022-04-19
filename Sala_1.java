import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sala_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sala_1 extends TileWorld
{
     /**
     * Constructor for objects of class Sala_1.
     * 
     */
    public Sala_1()
    {
        super(ListaDeMundoTiles.TilesMundo1(), 100, 300);    
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,600,200);
    }
    
    public Sala_1(int spawnX, int spawnY)
    {
        super(ListaDeMundoTiles.TilesMundo1(), spawnX, spawnY);    
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,600,200);
    }
    
    
    public void act(){
        if(salaDerecha.isHeroOn()){
            World world = new Sala_2(10,150);
            Greenfoot.setWorld(world);
        }
    }
}

