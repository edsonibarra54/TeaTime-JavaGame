import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class sala_5 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class sala_5 extends TileWorld
{
private Actor halo;
    /**
     * Constructor for objects of class sala_5.
     * 
     */
    public sala_5(int spawnX, int spawnY,Counter count,JukeBox jb)
    {
        super(ListaDeMundoTiles.TilesMundo3(), spawnX, spawnY,count,jb); 
        halo = new HaloTile();
        addObject(halo,spawnX - 8,spawnY + 5);
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,150);
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,150);
        salaDerecha = new PortalTile(0);
        addObject(salaDerecha,600,200);
    }
    public void act()
    {
        if(salaIzquierda.isHeroOn()){
            World world = new Sala_6(575,200,super.getCounter());
            GreenfootSound sonido= new GreenfootSound("Golpe.mp3");
            Greenfoot.setWorld(world);
        }

    }
    @Override
    public void prepareIndividual(){
        
    }
}
