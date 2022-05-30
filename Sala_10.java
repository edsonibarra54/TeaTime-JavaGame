import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sala_10 extends TileWorld
{   
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    
    public Sala_10(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo10(), spawnX, spawnY,count,0); 
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        salaAbajo = new PortalTile(0);
        addObject(salaAbajo,300,1);
    }
    
    public void act(){
        if(ti.animacionFinalizada() == true){
            getObjects(Heroe.class).get(0).setCancelaMovimiento(false);
        }
        
        if(this.getObjects(Heroe.class).isEmpty()!=true){
            if(salaAbajo.isHeroOn()){ 
                if(transicionFinalIniciada == false){
                    transicionFinalIniciada = true;
                    tf = new Transicion(1); 
                    addObject(tf,300,200);
                }
                if(tf.getWorld() != null){
                    if(tf.animacionFinalizada() == true){
                        World world = new Sala_7(570,270,super.getCounter());
                        Greenfoot.setWorld(world);
                    }
                }
            }
        }
    }
    
    @Override
    public void prepareIndividual(){
        TileActor puerta = new ColliderTile();
        puerta.setImage("Puerta.png");
        addObject(puerta,300,25);
        if(transicionInicialIniciada == false){
            transicionInicialIniciada = true;
            ti = new Transicion(0);
            addObject(ti,300,200);
        }
    }
}
