import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sala_7 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sala_7 extends TileWorld
{
    private Casa c,ct;
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    
    public Sala_7(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo5(), spawnX, spawnY,count,0);
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        c = new Casa("casa.png");
        addObject(c,78,100);
        ct = new Casa("techo.png");
        addObject(ct,78,0);
        Casa casa,techo;
        casa = new Casa("casa.png");
        techo = new Casa("techo.png");
        addObject(casa,195,100);
        addObject(techo,195,0);
        casa = new Casa("casa.png");
        techo = new Casa("techo.png");
        addObject(casa,403,100);
        addObject(techo,403,0);
        casa = new Casa("casa.png");
        techo = new Casa("techo.png");
        addObject(casa,516,100);
        addObject(techo,516,0);
        
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,275);
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,600,275);
        salaArriba = new PortalTile(0);
        addObject(salaArriba,300,1);
    }
    
    public void act(){
        if(ti.animacionFinalizada() == true){
            getObjects(Heroe.class).get(0).setCancelaMovimiento(false);
        }
        
        if(this.getObjects(Heroe.class).isEmpty()!=true){
            if(salaIzquierda.isHeroOn()){
                if(transicionFinalIniciada == false){
                    transicionFinalIniciada = true;
                    tf = new Transicion(1); 
                    addObject(tf,300,200);
                }
                if(tf.getWorld() != null){
                    if(tf.animacionFinalizada() == true){
                        World world = new Sala_2(25,150,super.getCounter());
                        Greenfoot.setWorld(world);
                    }
                }
            }
            
            if(salaDerecha.isHeroOn()){
                if(transicionFinalIniciada == false){
                    transicionFinalIniciada = true;
                    tf = new Transicion(1); 
                    addObject(tf,300,200);
                }
                if(tf.getWorld() != null){
                    if(tf.animacionFinalizada() == true){
                        World world = new Sala_1(20,150,super.getCounter());
                        Greenfoot.setWorld(world);
                    }
                }
            }
            
            if(salaArriba.isHeroOn()){
                if(transicionFinalIniciada == false){
                    transicionFinalIniciada = true;
                    tf = new Transicion(1); 
                    addObject(tf,300,200);
                }
                if(tf.getWorld() != null){
                    if(tf.animacionFinalizada() == true){
                        World world = new Sala_10(300,375,super.getCounter());
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