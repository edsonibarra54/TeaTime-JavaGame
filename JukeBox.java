import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JukeBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JukeBox 
{
    private static GreenfootSound song = new GreenfootSound("Title Theme.mp3");    /**
     * Act - do whatever the JukeBox wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    
    public static void changeSong(String newSong){  
        if(song.isPlaying()){
            song.stop();
        }
        song = new GreenfootSound(newSong); 
        song.playLoop();
        song.setVolume(20);
    }
    public static void stop(){
        song.stop();
    }
    
    public static void pause(){
        song.pause();
    }
    
    public static void play(){
        song.playLoop();
    }
    
    public static boolean isPlaying(){
        return song.isPlaying();
    }
    public void act()
    {
        
        
    }
    public void silenc() 
    {
        
    }
}
