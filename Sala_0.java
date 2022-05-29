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
    
    //Se instancia por primera vez esta sala
    public Sala_0()
    {
        super(ListaDeMundoTiles.TilesMundo0(), 300, 180,1,1);    
        salaAbajo = new PortalTile(0);
        addObject(salaAbajo,300,400);
        c = new Casa("casa.png"); //Aqui el sprite de la casa aun tiene la carta en el buzon
        addObject(c,300,125);
        ct = new Casa("techo.png");
        addObject(ct,300,25);
        setPaintOrder(Carta.class,Heroe_animacion.class,Casa.class,Tree.class);
    }
    
    public void act(){
        if(this.getObjects(Heroe_animacion.class).isEmpty()!=true){
            if(salaAbajo.isHeroAnimationOn()){ //Si es la primera vez que se ha instancido esta sala y nos movemos a la sala 1 esta recibira un nuevo contador
                World world = new Sala_1(300,10,new Counter("Ingredientes:"));
                Greenfoot.setWorld(world);
            } 
        }
        
    }
    
    @Override
    public void prepareIndividual() 
    { 
    }
}
