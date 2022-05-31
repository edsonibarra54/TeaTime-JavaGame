import greenfoot.*;
/**
 * Write a description of class JukeBoxEnemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JukeBoxEnemy  
{
    // instance variables - replace the example below with your own
   
    private static GreenfootSound song = new GreenfootSound("Battle.mp3");    
    
    
    
    public static void stop(){
        if(song.isPlaying()==true){
            song.stop();
        }
        
    }
    
    public static void pause(){
        if(song.isPlaying()==true){
            song.pause();
        }
        
    }
    
    public static void play(){
        song.setVolume(20);
        song.playLoop(); 
    }
    public JukeBoxEnemy()
    {
    }
 
}
