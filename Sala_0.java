import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sala_0 extends TileWorld
{
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    private Casa c,ct;
    
    //Se instancia por primera vez esta sala
    public Sala_0()
    {
        super(ListaDeMundoTiles.TilesMundo0(), 300, 180,1,1); 
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        salaAbajo = new PortalTile(0);
        addObject(salaAbajo,300,400);
        c = new Casa("casa.png"); //Aqui el sprite de la casa aun tiene la carta en el buzon
        addObject(c,300,125);
        ct = new Casa("techo.png");
        addObject(ct,300,25);
        setPaintOrder(Carta.class,Transicion.class,Heroe_animacion.class,Casa.class,Tree.class);
    }
    
    public void act(){
        if(this.getObjects(Heroe_animacion.class).isEmpty()!=true){
            if(salaAbajo.isHeroAnimationOn()){
                if(transicionFinalIniciada == false){
                    transicionFinalIniciada = true;
                    tf = new Transicion(1); 
                    addObject(tf,300,200);
                }
                if(tf.getWorld() != null){
                    if(tf.animacionFinalizada() == true){
                        World world = new Sala_1(300,10,new Counter("Ingredientes:"));
                        Greenfoot.setWorld(world);
                    }
                }
            } 
        }
    }
    
    @Override
    public void prepareIndividual() 
    { 
        if(transicionInicialIniciada == false){
            transicionInicialIniciada = true;
            ti = new Transicion(0);
            addObject(ti,300,200);
        }
    }
}
