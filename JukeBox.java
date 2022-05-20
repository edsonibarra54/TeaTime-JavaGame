import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JukeBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JukeBox extends Actor
{
    private GreenfootSound intro;    /**
     * Act - do whatever the JukeBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public JukeBox(String cancion)
    {
        intro = new GreenfootSound(cancion);

        getImage().setTransparency(1);
        intro.playLoop();
    }
    public void act()
    {
        if(ListaDeMundoTiles.DesactivaLamusica==true)
        {
            intro.stop();
            ListaDeMundoTiles.DesactivaLamusica=false;
        }
    }
    public void silencio()
    {
                intro.stop();
            ListaDeMundoTiles.DesactivaLamusica=false;
    }
}
