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
        super(ListaDeMundoTiles.TilesMundo1(), 100, 300,new Counter("Ingredientes:"));    
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,600,200);
    }
    public Sala_1(int spawnX, int spawnY)
    {
        super(ListaDeMundoTiles.TilesMundo1(), spawnX, spawnY,new Counter("Ingredientes:"));    
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,600,200);
    }
    
    public Sala_1(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo1(), spawnX, spawnY,count);    
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,600,200);
    }

    public void act(){
        if(salaDerecha.isHeroOn()){
            World world = new Sala_2(10,150,super.getCounter());
            Greenfoot.setWorld(world);
        }
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        Guardia guardia = new Guardia();
        addObject(guardia,532,160);
        Guardia guardia2 = new Guardia();
        addObject(guardia2,534,235);
        Pirate pirate = new Pirate();
        addObject(pirate,469,266);
        Pirate pirate2 = new Pirate();
        addObject(pirate2,468,135);
    }
}

