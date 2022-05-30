import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sala_7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sala_7 extends TileWorld
{
    private Casa c,ct;
    /**
     * Constructor for objects of class Sala_7.
     * 
     */
    public Sala_7(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo5(), spawnX, spawnY,count,false);
        c = new Casa("casa.png");
        addObject(c,78,100);
        ct = new Casa("techo.png");
        addObject(ct,78,0);
        Casa casa,techo;
        casa = new Casa("casa.png");
        techo = new Casa("techo.png");
        addObject(casa,195,100);
        addObject(techo,195,0);
        casa = new Casa("casa.png");
        techo = new Casa("techo.png");
        addObject(casa,403,100);
        addObject(techo,403,0);
        casa = new Casa("casa.png");
        techo = new Casa("techo.png");
        addObject(casa,516,100);
        addObject(techo,516,0);
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
        if(salaDerecha.isHeroOn()){
            World world = new Sala_1(10,150,super.getCounter()); 
            GreenfootSound sonido= new GreenfootSound("Golpe.mp3");
            Greenfoot.setWorld(world);
        }

    }
    @Override
    public void prepareIndividual(){
        
    }
}