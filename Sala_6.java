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
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    private Actor halo;
    
    public Sala_6(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo4(), spawnX, spawnY,count,0,true);
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        //super(ListaDeMundoTiles.TilesMundo4(), spawnX, spawnY,count,0); 
        super.shadow=true;
        halo = new HaloTile();
        addObject(halo,spawnX - 8,spawnY + 5);
        /*Moneda act = new Moneda();
        addObject(act,500,100);*/
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,150);
        salaDerecha = new PortalTile(0);
        addObject(salaDerecha,600,200);
        MiniHalo luz = new MiniHalo();
        addObject(luz,87,337);
        salaDerecha = new PortalTile(0);
        addObject(salaDerecha,599,200);
        if(IngredienteTiles.ingrediente[1]==0)
        {
            Ingrediente ingrediente = new Ingrediente("teprueba.png",1);
            addObject(ingrediente,87,330);
        }    
    }
    public void act(){
        if(ti.animacionFinalizada() == true){
            getObjects(Heroe.class).get(0).setCancelaMovimiento(false);
        }
        if(this.getObjects(Heroe.class).isEmpty()!=true){
            if(salaDerecha.isHeroOn()){
                if(transicionFinalIniciada == false){
                    transicionFinalIniciada = true;
                    tf = new Transicion(1); 
                    addObject(tf,300,200);
                }
                if(tf.getWorld() != null){
                    if(tf.animacionFinalizada() == true){
                        World world = new sala_5(20,190,super.getCounter());
                        Greenfoot.setWorld(world);
                    }
                }
            }
        }
    }
    @Override
    public void prepareIndividual(){
        if(Ingredientes_list.checkIngredient(1)==0){
            Ingrediente te = new Ingrediente("planta.png",1);
            addObject(te,87,330);
        }
        if(transicionInicialIniciada == false){
            transicionInicialIniciada = true;
            ti = new Transicion(0);
            addObject(ti,300,200);
        }
    }
}
