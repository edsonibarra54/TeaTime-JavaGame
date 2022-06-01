import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sala_10 extends TileWorld
{   
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private boolean activaFinal;
    private Transicion ti,tf;
    
    /**
     * Constructor de Sala_10, llama al constructor de TileWorld instanciando el cual instancia
     * sus tiles, tambien instancia los portales necesarios para movernos a otras salas,
     * al objeto fuente e indica que las transiciones de inicio y de salida aun no se han realizado
     * asi como tambien que el final esta inactivo
     * @param spawnX el spawn en x del heroe dentro del mundo
     * @param spawnY el spawn en y del heroe dentro del mundo
     * @param count el contador de los ingredientes que lleva el jugador
     */
    
    public Sala_10(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo10(), spawnX, spawnY,count,0); 
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        this.activaFinal = false;
        salaAbajo = new PortalTile(0);
        addObject(salaAbajo,300,399);
        salaArriba = new PortalTile(0);
        addObject(salaArriba,300,51);
    }
    
    /**
     * Metodo que se encarga de verificar si la animacion inicial ya termino, si
     * el jugador a tocado algun portal para teletranportarlo a otra sala o si
     * todos los ingredientes han sido recolectados para poder activar el final
     */
    
    public void act(){
        if(Ingredientes_list.getIngredient0() == 1 && Ingredientes_list.getIngredient1() == 1 && Ingredientes_list.getIngredient2() == 1)
        {
            activaFinal = true;
        }
        
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
            
            if(salaArriba.isHeroOn() && activaFinal == true){ 
                if(transicionFinalIniciada == false){
                    transicionFinalIniciada = true;
                    tf = new Transicion(1); 
                    addObject(tf,300,200);
                }
                if(tf.getWorld() != null){
                    if(tf.animacionFinalizada() == true){
                        World world = new Sala_11();
                        Greenfoot.setWorld(world);
                    }
                }
            }
        }
    }
    
    /**
     * Este metodo se encarga de generar la transicion inicial y de instanciar
     * los objetos fuente y puerta
     */
    
    @Override
    public void prepareIndividual(){
        Fuente fuente = new Fuente();
        addObject(fuente,300,200);
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
