import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sala_2 extends TileWorld
{
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    
    public Sala_2(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo2(), spawnX, spawnY,count,0); 
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,150);
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,600,200);
    }
    
    public void act(){
        if(ti.animacionFinalizada() == true){
            getObjects(Heroe.class).get(0).setCancelaMovimiento(false);
        }
        
        if(salaIzquierda.isHeroOn()){
            World world = new Sala_1(575,200,super.getCounter());
            Greenfoot.setWorld(world);
        }
        
        if(salaDerecha.isHeroOn()){
            World world = new sala_5(25,150,super.getCounter());
            Greenfoot.setWorld(world);
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