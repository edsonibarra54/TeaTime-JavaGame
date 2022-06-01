import greenfoot.*;
/**
 * JukeBox destinada a la reproduccion de la musica de los bandidos
 */
public class JukeBoxEnemy  
{  
    private static GreenfootSound song = new GreenfootSound("Battle.mp3");    
    
    
    /**
     * Detiene la reproduccion de la cancion en jukeboxEnemy siempre y cuando este siendo reproducida
     */
    public static void stop(){
        if(song.isPlaying()==true){
            song.stop(); 
        }
        
    }
    /**
     * Pausa la reproduccion de la cancion en jukeboxEnemy, siempre y cuando este siendo reproducida
     */
    public static void pause(){
        if(song.isPlaying()==true){
            song.pause();
        }
        
    }
    /**
     * Reproduce la cancion correspondeinte de jukeboxEnemy
     */
    public static void play(){
        song.setVolume(30);
        song.playLoop(); 
    }

 
}
