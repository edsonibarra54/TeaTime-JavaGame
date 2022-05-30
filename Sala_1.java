import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sala_1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sala_1 extends TileWorld
{
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;
    
    public Sala_1(int spawnX, int spawnY,Counter count)
    {
        //super(ListaDeMundoTiles.TilesMundo5(), spawnX, spawnY,count,false);
        super(ListaDeMundoTiles.TilesMundo1(), spawnX, spawnY,count,0); 
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
        salaArriba = new PortalTile(0);
        addObject(salaArriba,300,1);
        salaDerecha = new PortalTile(1); 
        addObject(salaDerecha,600,200);
        salaIzquierda = new PortalTile(1);
        addObject(salaIzquierda,1,150);
    }

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
                        World world = new Sala_2(25,150,super.getCounter());
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
                        World world = new sala_5(570,200,super.getCounter());
                        Greenfoot.setWorld(world);
                    }
                }
            }
        }
        
    }
    
    @Override
    public void prepareIndividual() 
    { 
        
        if(Ingredientes_list.checkIngredient(0) == 0){
            Ingrediente azucar = new Ingrediente("azucar.png",0);
            addObject(azucar,300,250);
        }        
        Actor enemigo1 = new Enemy(ListaDeSprites.enemigo1,200,1,0,100,100);
        Actor enemigo2 = new Enemy(ListaDeSprites.pirata,200,0,1,500,100);
        addObject(enemigo1,100,100);
        addObject(enemigo2,500,100);
        if(transicionInicialIniciada == false){
            transicionInicialIniciada = true;
            ti = new Transicion(0);
            addObject(ti,300,200);
        }
    }
}

