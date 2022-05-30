import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Rock here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Rock extends TrapTile
{
    /**
     * Act - do whatever the Rock wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Rock()
    {
        super(100);
        setImage("circulo_naranja.png");
        getImage().scale(25,25);
    }
    @Override
    public void act()
    {
    super.act();
    }
    public void actua()
    {
        if(isTouching(Heroe.class) && super.usada==false)
        {
            Projectile roca = new Projectile(getX(),getY());
            World mundo = getWorld();
            mundo.addObject(roca,getX(),getY()-50);
            super.usada=true;
            GreenfootSound sondo= new GreenfootSound("roca.mp3");
            sondo.play();
        }
    }
}