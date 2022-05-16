import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Projectile here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Projectile extends Actor
{
    /**
     * Act - do whatever the Projectile wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int destinoX,destinoY,transparency=30;
    public Projectile(int destinoX,int destinoY)
    {
        this.getImage().setTransparency(30);
        this.destinoX=destinoX;
        this.destinoY=destinoY;
    }
    public void act()
    {
        if(getX()==destinoX && destinoY==getY())
        {
            World mundo = getWorld();
            mundo.removeObject(this);
        }else
        {

        this.getImage().setTransparency(transparency+4);
        transparency+=4;
        turn(5);
        setLocation(getX(),getY()+1);
        }
    }
}
