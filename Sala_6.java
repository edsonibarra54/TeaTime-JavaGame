import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sala_6 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sala_6 extends TileWorld
{

    /**
     * Constructor for objects of class Sala_6.
     * 
     */
    private Actor halo;
    public Sala_6(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo4(), spawnX, spawnY,count,true); 
        super.shadow=true;
        halo = new HaloTile();
        addObject(halo,spawnX - 8,spawnY + 5);
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,150);
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,150);
        salaDerecha = new PortalTile(0);
        addObject(salaDerecha,600,200);
        MiniHalo luz = new MiniHalo();
        addObject(luz,87,337);
    }
    @Override
    public void prepareIndividual(){
        
    }
}
