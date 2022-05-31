import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Sala_11 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Sala_11 extends TileWorld
{
    private boolean transicionInicialIniciada, transicionFinalIniciada; 
    private Transicion ti,tf;

    public Sala_11(String s)
    {
        super(ListaDeMundoTiles.TilesMundo11(), 300, 375,1,2); 
        setBackground(s);
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
    }
    public Sala_11()
    {
        super(ListaDeMundoTiles.TilesMundo11(), 300, 375,1,2); 
        this.transicionInicialIniciada = false;
        this.transicionFinalIniciada = false;
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
