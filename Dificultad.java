/**
 * Write a description of class Dificultad here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dificultad  
{
    // instance variables - replace the example below with your own
    private int x;
    public static int vidaHeroe=6;
    public static int nivelDificultad=0;
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
                Dificultad.RadioBusqueda=100;
                Dificultad.velocidadX=2;
                Dificultad.velocidadY=1;
                Dificultad.vidaHeroe=6;
                Dificultad.nivelDificultad=2;
            break;
            case 3:
                Dificultad.RadioBusqueda=130;
                Dificultad.velocidadX=1;
                Dificultad.velocidadY=2;
                Dificultad.vidaHeroe=2;
                Dificultad.nivelDificultad=3;
            break;
        }
    } 

}
