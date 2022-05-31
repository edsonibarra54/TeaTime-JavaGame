/**
 * Write a description of class Dificultad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dificultad  
{
    // instance variables - replace the example below with your own
    public static int vidaHeroe=6;
    public static int nivelDificultad=2;
    public static int RadioBusqueda=80;
    public static int velocidadX,velocidadY;
    
    public static void changeDifficulty(int difficulty){ 
        switch(difficulty){
            case 1:
                Dificultad.RadioBusqueda=80;
                Dificultad.velocidadX=1;
                Dificultad.velocidadY=1;
                Dificultad.vidaHeroe=10;
                Dificultad.nivelDificultad=1;  
            break;
            case 2:
                Dificultad.RadioBusqueda=120;
                Dificultad.velocidadX=1;
                Dificultad.velocidadY=1;
                Dificultad.vidaHeroe=6;
                Dificultad.nivelDificultad=2;
            break;
            case 3:
                Dificultad.RadioBusqueda=160;
                Dificultad.velocidadX=1;
                Dificultad.velocidadY=1;
                Dificultad.vidaHeroe=2;
                Dificultad.nivelDificultad=3;
            break;
        }
    } 
    
    public static void resetDificulty(){
        vidaHeroe=6;
        nivelDificultad=2;
        RadioBusqueda=120;
        velocidadX = velocidadY = 1;
    }

}
