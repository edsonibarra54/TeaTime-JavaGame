import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sala_0 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sala_0 extends TileWorld
{

    /**
     * Constructor for objects of class Sala_0.
     * 
     */
    public Sala_0(int d)
    {
        super(ListaDeMundoTiles.TilesMundo1(), 100, 300,new Counter("Ingredientes:"),d);    
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,100,300);
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,100,300);

    }
    public void act()
    {
        if(this.getObjects(Heroe.class).isEmpty()!=true){
            if(salaDerecha.isHeroOn()){
                World world = new Sala_1(100,300,super.getCounter());
                Greenfoot.setWorld(world);
            } 
            if(salaIzquierda.isHeroOn()){       
                World world = new Sala_1(100,300,super.getCounter());
                Greenfoot.setWorld(world);
            }
        }
    }
    @Override
    public void prepareIndividual() 
    { 
        Actor ingrediente = new Ingrediente("objeto.png");
        addObject(ingrediente,300,250);
        Actor enemigo1 = new Enemy(ListaDeSprites.enemigo1,200,1,0,100,100);
        Actor enemigo2 = new Enemy(ListaDeSprites.pirata,200,0,1,500,100);
        addObject(enemigo1,100,100);
        addObject(enemigo2,500,100);/*
        World world = new Sala_1(100,300,super.getCounter()); 
        Greenfoot.setWorld(world); */
    }
}
