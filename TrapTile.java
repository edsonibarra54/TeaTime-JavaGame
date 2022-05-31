import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase Que instancia las trampas
 * 
 * @author Alan
 * @version 20/05/2022
 */
abstract class TrapTile extends TileActor
{
    protected int tiempoReposicion=100,cont=0;
    protected boolean usada=false;
    /**
     * Constructor el cual le da un tiempo de espera a cada trampa antes de lanzar un proyectil
     * @params int un entero que representa 1/50 de segundo el cual simboliza la cantidad de tiempo que va a tardar en lanzar un proyectil
       */
    public TrapTile(int tiempoReposicion)
    {
        this.tiempoReposicion=tiempoReposicion;
        //cont=tiempoReposicion;
    }
    /**
     *  Un metodo el cual va verificando si ya transcurrio el tiempo suficiente para lanzar un proyectil
      */
    public void act()
    {
        getImage().setTransparency(255);
        if(usada==false)
        {
            actua();
        }else
        {
            cont++;
            if(cont==tiempoReposicion)
            {
                usada=false;
                cont=0;
            }
        }
    }
    public abstract void actua();
}