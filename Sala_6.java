import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sala_6 extends TileWorld
{
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    private Actor halo;
    
    /**
     * Constructor de Sala_6, llama al constructor de TileWorld instanciando el cual instancia
     * sus tiles, tambien instancia los portales necesarios para movernos a otras salas,
     * indica que las transiciones de inicio y de salida aun no se han realizado y
     * genera la obscuridad del mundo asi como el anillo de luz que esta sobre el personaje
     * @param spawnX el spawn en x del heroe dentro del mundo
     * @param spawnY el spawn en y del heroe dentro del mundo
     * @param count el contador de los ingredientes que lleva el jugador
     */
    
    public Sala_6(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo4(), spawnX, spawnY,count,0,true);
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        super.shadow = true;
        halo = new HaloTile();
        addObject(halo,spawnX - 8,spawnY + 5);
        MiniHalo luz = new MiniHalo();
        addObject(luz,87,337);
        salaDerecha = new PortalTile(1);
        addObject(salaDerecha,599,200);
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
                        World world = new sala_5(20,190,super.getCounter());
                        Greenfoot.setWorld(world);
                    }
                }
            }
        }
    }
    
    /**
     * Este metodo se encarga de instanciar el objeto planta si
     * aun no ha sido agarrado y de generar la transicion inicial
     */
    
    @Override
    public void prepareIndividual(){
        if(Ingredientes_list.checkIngredient(1)==0){
            Ingrediente te = new Ingrediente("planta.png",1);
            addObject(te,87,330);
        }
        if(transicionInicialIniciada == false){
            transicionInicialIniciada = true;
            ti = new Transicion(0);
            addObject(ti,300,200);
        }
    }
}
