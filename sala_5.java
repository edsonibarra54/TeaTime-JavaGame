import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class sala_5 extends TileWorld
{
    private Actor halo;
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    
    public sala_5(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo3(), spawnX, spawnY,count); 
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        halo = new HaloTile();
        addObject(halo,spawnX - 8,spawnY + 5);
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,150);
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,150);
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,600,200);
    }
    public void act() 
    {
        if(ti.animacionFinalizada() == true){
            getObjects(Heroe.class).get(0).setCancelaMovimiento(false);
        }
        
        if(salaIzquierda.isHeroOn()){
            World world = new Sala_6(575,200,super.getCounter());
            Greenfoot.setWorld(world);
        }
        
        if(salaDerecha.isHeroOn()){
            World world = new Sala_1(25,150,super.getCounter()); 
            Greenfoot.setWorld(world);
        }
    }
    @Override
    public void prepareIndividual(){
        if(Ingredientes_list.checkIngredient(1)==0){
            Ingrediente te = new Ingrediente("planta.png",1);
            addObject(te,400,200);
        }
        if(transicionInicialIniciada == false){
            transicionInicialIniciada = true;
            ti = new Transicion(0);
            addObject(ti,300,200);
        }
    }
}
