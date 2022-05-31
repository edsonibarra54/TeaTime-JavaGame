import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class sala_5 extends TileWorld
{
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    
    public sala_5(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo6(), spawnX, spawnY,count,0); 
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,200);
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,600,200);
    }
    
    public void act() 
    {
        if(ti.animacionFinalizada() == true){
            getObjects(Heroe.class).get(0).setCancelaMovimiento(false);
        }
        
        if(salaIzquierda.isHeroOn()){
            World world = new Sala_6(560,200,super.getCounter());
            Greenfoot.setWorld(world);
        }
        
        if(salaDerecha.isHeroOn()){
            World world = new Sala_7(40,285,super.getCounter()); 
            Greenfoot.setWorld(world);
        }
    }
    
    @Override
    public void prepareIndividual(){
        /*if(Ingredientes_list.checkIngredient(1)==0){
            Ingrediente te = new Ingrediente("planta.png",1);
            addObject(te,400,200);
        */
        if(transicionInicialIniciada == false){
            transicionInicialIniciada = true;
            ti = new Transicion(0);
            addObject(ti,300,200);
        }
    }
}
