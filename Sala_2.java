import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sala_2 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sala_2 extends TileWorld
{
    private Actor halo;
    /**
     * Constructor for objects of class Sala_2.
     * 
     */
    public Sala_2(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo2(), spawnX, spawnY,count); 
        halo = new HaloTile();
        addObject(halo,spawnX - 8,spawnY + 5);
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,150);
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,600,200);
    }
    
    public void act(){
        if(salaIzquierda.isHeroOn()){
            World world = new Sala_1(570,200,super.getCounter());
            Greenfoot.setWorld(world);
        }
        if(salaDerecha.isHeroOn()){
            World world = new sala_5(10,150,super.getCounter());
            Greenfoot.setWorld(world);
        } 
    }
    
    @Override
    public void prepareIndividual(){
        if(Ingredientes_list.checkIngredient(2)==0){
            Ingrediente taza = new Ingrediente("taza.png",2);
            addObject(taza,300,100);
        }
    }
}