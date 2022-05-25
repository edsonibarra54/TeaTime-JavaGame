import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JukeBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JukeBox extends Actor
{
    private GreenfootSound song;    /**
     * Act - do whatever the JukeBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public JukeBox(String cancion)
    {
        song = new GreenfootSound(cancion);
        getImage().setTransparency(1);
        song.playLoop();
    }
    
    public void changeSong(String newSong){ 
        song.stop();
        song = new GreenfootSound(newSong);
        song.playLoop();
    }
    public void stop(){
        song.stop();
    }
    public void act()
    {
        
        
    }
    public void silencio()
    {
            
    }
}
