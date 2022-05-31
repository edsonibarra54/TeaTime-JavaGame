import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sala9 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sala9 extends TileWorld
{

    /**
     * Constructor for objects of class Sala9.
     * 
     */
    private Casa c,ct;
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    public Sala9(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo7(), spawnX, spawnY,count,0); 
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,200);
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,600,200);
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
                        World world = new Sala8(50,225,super.getCounter());
                        Greenfoot.setWorld(world);
                    }
                }
            }
            if(salaIzquierda.isHeroOn()){ 
                if(transicionFinalIniciada == false){
                    transicionFinalIniciada = true;
                    tf = new Transicion(1); 
                    addObject(tf,300,200);
                }
                if(tf.getWorld() != null){
                    if(tf.animacionFinalizada() == true){
                        World world = new Sala8(570,200,super.getCounter());
                        Greenfoot.setWorld(world);
                    }
                }
            }
        }


    }
    @Override
    public void prepareIndividual(){
        if(Ingredientes_list.checkIngredient(2)==0){
            Ingrediente taza = new Ingrediente("taza.png",2);
            addObject(taza,538,187);
        }
        if(transicionInicialIniciada == false){
            transicionInicialIniciada = true;
            ti = new Transicion(0);
            addObject(ti,300,200);
        }
    }
}
