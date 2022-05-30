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
        /*Moneda act = new Moneda();
        addObject(act,500,100);*/
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,150);
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,150);
        salaDerecha = new PortalTile(0);
        addObject(salaDerecha,600,200);
        MiniHalo luz = new MiniHalo();
        addObject(luz,87,337);
        salaDerecha = new PortalTile(0);
        addObject(salaDerecha,600,200);
        if(IngredienteTiles.ingrediente[1]==0)
        {
            Ingrediente ingrediente = new Ingrediente("teprueba.png");
            addObject(ingrediente,87,330);
            ingrediente.getImage().scale(30,30);
            ingrediente.setCorrespondiente(1);
        }    
    }
    @Override
    public void prepareIndividual(){
        Actor enemigo1 = new Enemy(ListaDeSprites.enemigo1,200,1,0,100,100);
    }
}
