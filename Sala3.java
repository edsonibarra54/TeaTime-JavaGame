import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sala3 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sala3 extends TileWorld
{
    private Casa c,ct;
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    
    /**
     * Constructor de Sala3, llama al constructor de TileWorld instanciando el cual instancia
     * sus tiles, tambien instancia los portales necesarios para movernos a otras salas
     * e indica que las transiciones de inicio y de salida aun no se han realizado
     * @param spawnX el spawn en x del heroe dentro del mundo
     * @param spawnY el spawn en y del heroe dentro del mundo
     * @param count el contador de los ingredientes que lleva el jugador
     */
    
    public Sala3(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo3(), spawnX, spawnY,count,0);
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,150);
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,600,200);
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
                        World world = new Sala_7(570,275,super.getCounter());
                        Greenfoot.setWorld(world);
                    }
                }
            }
        }

    }
    
    /**
     * Este metodo se encarga de instanciar los enemigos de la sala y
     * de generar la transicion inicial
     */
    
    @Override
    public void prepareIndividual(){
        Actor enemigo1 = new Enemy(ListaDeSprites.pirata,200,1,0,150,100);
        Actor enemigo2 = new Enemy(ListaDeSprites.pirata,200,0,1,425,200);
        Actor enemigo3 = new Enemy(ListaDeSprites.pirata,200,0,1,500,200);
        addObject(enemigo1,150,100);
        addObject(enemigo2,425,200);
        addObject(enemigo3,500,200);
        
        if(transicionInicialIniciada == false){
            transicionInicialIniciada = true;
            ti = new Transicion(0);
            addObject(ti,300,200);
        }
    }
}
