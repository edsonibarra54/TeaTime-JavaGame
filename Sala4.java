import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sala4 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sala4 extends TileWorld
{
    private Casa c,ct;
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    /**
     * Constructor for objects of class Sala4.
     * 
     */
    public Sala4(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo2(), spawnX, spawnY,count,0); 
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
                        World world = new Sala3(50,150,super.getCounter());
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
                        World world = new sala_5(570,200,super.getCounter());
                        Greenfoot.setWorld(world);
                    }
                }
            }
        }


    }
    @Override
    public void prepareIndividual(){
        if(transicionInicialIniciada == false){
            transicionInicialIniciada = true;
            ti = new Transicion(0);
            addObject(ti,300,200);
        }
    }
}
