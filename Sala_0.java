import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sala_0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sala_0 extends TileWorld
{
    private boolean carta = false; 
    private Casa c,ct;
    
    public Sala_0(int d)
    {
        super(ListaDeMundoTiles.TilesMundo0(), 400, 200,d,1);    
        salaAbajo = new PortalTile(0);
        addObject(salaAbajo,300,400);
        c = new Casa("casa.png");
        addObject(c,300,125);
        ct = new Casa("techo.png");
        addObject(ct,300,25);
        setPaintOrder(Casa.class);;
    }
    
    public Sala_0(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo0(), spawnX, spawnY,count);    
        salaAbajo = new PortalTile(0);
        addObject(salaAbajo,300,400);
        c = new Casa("casa_2.png");
        addObject(c,300,125);
        ct = new Casa("techo.png");
        addObject(ct,300,25);
        setPaintOrder(Casa.class, Counter.class);
    }
    
    public void act(){
        if(carta == true){
            c.cambiaCasa();
        }
        
        if(this.getObjects(Heroe.class).isEmpty()!=true){
            if(salaAbajo.isHeroOn()){
                World world = new Sala_1(300,1,super.getCounter());
                Greenfoot.setWorld(world);
            } 
        }
        
    }
    
    @Override
    public void prepareIndividual() 
    { 
        
    }
}
