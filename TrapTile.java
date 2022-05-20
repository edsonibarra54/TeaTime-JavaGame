import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class TrapTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
abstract class TrapTile extends TileActor
{
    /**
     * Act - do whatever the TrapTile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    protected int tiempoReposicion=100,cont=0;
    protected boolean usada=false;
    public TrapTile(int tiempoReposicion)
    {
        this.tiempoReposicion=tiempoReposicion;
        //cont=tiempoReposicion;
    }
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
