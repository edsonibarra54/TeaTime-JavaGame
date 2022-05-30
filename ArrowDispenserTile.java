import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class ArrowDispenserTile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ArrowDispenserTile extends TrapTile
{
    /**
     * Act - do whatever the ArrowDispenserTile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int x,y;
    public ArrowDispenserTile(int eje,int tiempodeespera)
    {
        super(200);
        setImage("Muro.png");
        if(eje==1)
        {
            x=3;
            y=0;
        }
        if(eje==2)
        {
            x=-3;
            y=0;
        }
        if(eje==3)
        {
            x=0;
            y=3;
        }
        if(eje==4)
        {
            x=0;
            y=-3;
        }
        getImage().scale(25,25);
    }
    public ArrowDispenserTile(int eje)
    {
        super(200);
        setImage("Muro.png");
        if(eje==1)
        {
            x=3;
            y=0;
        }
        if(eje==2)
        {
            x=-3;
            y=0;
        }
        if(eje==3)
        {
            x=0;
            y=3;
        }
        if(eje==4)
        {
            x=0;
            y=-3;
        }
        getImage().scale(25,25);
    }
    @Override
    public void act()
    {
    super.act();
    
    }
    public void actua()
    {
        if(getNeighbours(300,false,Heroe.class).size()>0 && super.usada==false)
        {
            Arrow arrow = new Arrow(x,y);
            World mundo = getWorld();
            mundo.addObject(arrow,getX()+(x*2),getY()+(y*2));
            super.usada=true;
            GreenfootSound sondo= new GreenfootSound("flecha lanzada.mp3");
            sondo.play();
        }
    }
}