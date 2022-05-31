import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sala3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sala3 extends TileWorld
{

    /**
     * Constructor for objects of class Sala3.
     * 
     */
    private Casa c,ct;
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    
    public Sala3(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo3(), spawnX, spawnY,count,0);
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,150);
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,600,200);
        Actor enemigo1 = new Enemy(ListaDeSprites.pirata,200,1,0,150,100);
        Actor enemigo2 = new Enemy(ListaDeSprites.pirata,200,0,1,425,200);
        Actor enemigo3 = new Enemy(ListaDeSprites.pirata,200,0,1,500,200);
        addObject(enemigo1,150,100);
        addObject(enemigo2,425,200);
        addObject(enemigo3,500,200);
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
                        World world = new Sala_1(25,150,super.getCounter());
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
                        World world = new Sala_7(570,300,super.getCounter());
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
