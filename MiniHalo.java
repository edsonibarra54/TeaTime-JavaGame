import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class MiniHalo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class MiniHalo extends HaloTile
{
    private boolean sigue=false;
    private Actor nonulo;
    /**
     * Act - do whatever the MiniHalo wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public MiniHalo()
    {
        super();
    }
    public void act()
    {
        if(sigue==false)
        {
            Actor nulo = getOneObjectAtOffset(0,0,Heroe.class);
            nonulo = nulo;
        }
        if(nonulo!=null && sigue==false)
        {
            sigue=true;
        }else
        {
            if(sigue==true)
            {
                setLocation(nonulo.getX(),nonulo.getY());
            }   
        }
    }
}
