import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class JukeBox here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JukeBox 
{
    private static GreenfootSound song = new GreenfootSound("Title Theme.mp3");   
     
    /**
     * Cambia la cancion que reproduce jukebox por la que corresponde a el string
     * de su parametro, si hay alguna sonando en ese momento, la detiene antes de empezar
     * la nueva 
     * @param newSong el nombre de la nueva cancion
     */
    public static void changeSong(String newSong){  
        if(song.isPlaying()){
            song.stop();
        }
        song = new GreenfootSound(newSong); 
        song.playLoop();
        song.setVolume(20);
    }
    
    /**
     * Detiene la reproduccion de la cancion en jukebox
     */
    public static void stop(){
        song.stop();
    }
    
    /**
     * Pausa la reproduccion de la cancion en jukebox
     */
    public static void pause(){
        song.pause();
    }
    
    /**
     * Reanuda la reproduccio  de la cancion en jukebox
     */
    public static void play(){
        song.playLoop();
    }
    
    /**
     * Regresa true si la jukebox esta reproduciondo una cancion, false de lo contrario
     */
    public static boolean isPlaying(){
        return song.isPlaying();
    }

}
