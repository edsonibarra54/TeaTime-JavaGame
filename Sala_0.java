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
    private boolean f;
    
    public Sala_0(boolean b)
    {
        super(ListaDeMundoTiles.TilesMundo0(), 300, 180,1,1);    
        salaAbajo = new PortalTile(0);
        addObject(salaAbajo,300,400);
        this.f = b;
        c = new Casa("casa.png");
        addObject(c,300,125);
        ct = new Casa("techo.png");
        addObject(ct,300,25);
        setPaintOrder(Carta.class,Heroe_animacion.class,Casa.class,Tree.class);
    }
    
    public Sala_0(int spawnX, int spawnY, Counter count, boolean b)
    {
        super(ListaDeMundoTiles.TilesMundo0(), spawnX, spawnY,count,0);    
        salaAbajo = new PortalTile(0);
        addObject(salaAbajo,300,400);
        this.f = b;
        c = new Casa("casa_2.png");
        addObject(c,300,125);
        ct = new Casa("techo.png");
        addObject(ct,300,25);
        setPaintOrder(Casa.class, Counter.class);
    }
    
    public void act(){ 
        if(this.getObjects(Heroe.class).isEmpty()!=true){
            if(salaAbajo.isHeroOn() && f == false){
                World world = new Sala_1(300,1,super.getCounter());
                Greenfoot.setWorld(world);
            } 
        }
        if(this.getObjects(Heroe.class).isEmpty()!=true){
            if(salaAbajo.isHeroOn() && f == true){
                World world = new Sala_1(300,1,new Counter("Ingredientes:"));
                Greenfoot.setWorld(world);
            } 
        }
        
    }
    
    @Override
    public void prepareIndividual() 
    { 
    }
}
