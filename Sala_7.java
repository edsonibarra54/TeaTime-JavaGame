import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sala_7 extends TileWorld
{
    private Casa c,ct;
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    
    /**
     * Constructor de Sala_7, llama al constructor de TileWorld instanciando el cual instancia
     * sus tiles, tambien instancia los portales necesarios para movernos a otras salas
     * e indica que las transiciones de inicio y de salida aun no se han realizado
     * @param spawnX el spawn en x del heroe dentro del mundo
     * @param spawnY el spawn en y del heroe dentro del mundo
     * @param count el contador de los ingredientes que lleva el jugador
     */
    
    public Sala_7(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo5(), spawnX, spawnY,count,0);
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,275);
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,600,275);
        salaArriba = new PortalTile(0);
        addObject(salaArriba,300,1);
    }
    
    /**
     * Metodo que se encarga de verificar si la animacion inicial ya termino o si
     * el jugador a tocado algun portal para teletranportarlo a otra sala
     */
    
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
                        World world = new sala_5(570,200,super.getCounter());
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
                        World world = new Sala3(20,150,super.getCounter());
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
    
    /**
     * Este metodo se encarga de instanciar los enemigos de la sala,
     * las casas del mapa junto con sus techos y de generar la 
     * transicion inicial
     */
    
    @Override
    public void prepareIndividual(){
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
        if(transicionInicialIniciada == false){
            transicionInicialIniciada = true;
            ti = new Transicion(0);
            addObject(ti,300,200);
        }
    }
}