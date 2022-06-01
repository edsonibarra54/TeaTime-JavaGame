import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Sala9 extends TileWorld
{

    /**
     * Constructor for objects of class Sala9.
     * 
     */
    private Casa c,ct;
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    
    /**
     * Constructor de Sala9, llama al constructor de TileWorld el cual instancia
     * sus tiles, tambien instancia los portales necesarios para movernos a otras salas
     * e indica que las transiciones de inicio y de salida aun no se han realizado
     * @param spawnX el spawn en x del heroe dentro del mundo
     * @param spawnY el spawn en y del heroe dentro del mundo
     * @param count el contador de los ingredientes que lleva el jugador
     */
    
    public Sala9(int spawnX, int spawnY,Counter count)
    {
        super(ListaDeMundoTiles.TilesMundo7(), spawnX, spawnY,count,0); 
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,200);
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
                        World world = new Sala8(50,225,super.getCounter());
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
                        World world = new Sala8(570,200,super.getCounter());
                        Greenfoot.setWorld(world);
                    }
                }
            }
        }


    }
    
    /**
     * Este metodo se encarga de generar la transicion inicial y de instanciar
     * el objeto de la taza en el mundo
     */
    
    @Override
    public void prepareIndividual(){
        if(Ingredientes_list.checkIngredient(2)==0){
            Ingrediente taza = new Ingrediente("taza.png",2);
            addObject(taza,538,187);
        }
        if(transicionInicialIniciada == false){
            transicionInicialIniciada = true;
            ti = new Transicion(0);
            addObject(ti,300,200);
        }
    }
}
