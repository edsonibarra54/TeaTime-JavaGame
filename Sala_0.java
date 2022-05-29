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
    private boolean f; //Indica si es la primera vez que se ha instanciado esta sala
    
    //Se instancia por primera vez esta sala
    public Sala_0(boolean b)
    {
        super(ListaDeMundoTiles.TilesMundo0(), 300, 180,1,1);    
        salaAbajo = new PortalTile(0);
        addObject(salaAbajo,300,400);
        this.f = b;
        c = new Casa("casa.png"); //Aqui el sprite de la casa aun tiene la carta en el buzon
        addObject(c,300,125);
        ct = new Casa("techo.png");
        addObject(ct,300,25);
        setPaintOrder(Carta.class,Heroe_animacion.class,Casa.class,Tree.class);
    }
    
    //Ya se ha instanciado esta sala anteriormente
    public Sala_0(int spawnX, int spawnY, Counter count, boolean b)
    {
        super(ListaDeMundoTiles.TilesMundo0(), spawnX, spawnY,count,0);    
        salaAbajo = new PortalTile(0);
        addObject(salaAbajo,300,400);
        this.f = b;
        c = new Casa("casa_2.png"); //Aqui el sprite de la casa ya no tiene la carta
        addObject(c,300,125);
        ct = new Casa("techo.png");
        addObject(ct,300,25);
        setPaintOrder(Casa.class, Heroe.class, Counter.class, Tree.class);
    }
    
    public void act(){ 
        if(this.getObjects(Heroe.class).isEmpty()!=true){
            if(salaAbajo.isHeroOn() && f == false){ //Si ya se habia instanciado esta sala anteriormente ya no se crea un nuevo contador
                World world = new Sala_1(300,1,super.getCounter());
                Greenfoot.setWorld(world);
            } 
        }
        if(this.getObjects(Heroe.class).isEmpty()!=true){
            if(salaAbajo.isHeroOn() && f == true){ //Si es la primera vez que se ha instancido esta sala y nos movemos a la sala 1 esta recibira un nuevo contador
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
