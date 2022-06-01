/**
 * Clase Que modifica la velocidad y rango de enemigos
 * y la vida del heroe
 */
public class Dificultad  
{
    // instance variables - replace the example below with your own
    public static int vidaHeroe=6;
    public static int nivelDificultad=2;
    public static int RadioBusqueda=80;
    public static int velocidadX,velocidadY;
    /**
     * Constructor el cual cambia la dificultad del juego segun el nivel
    @params int que representa la dificultad elegida, la cual va de 1 a 3
    */
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
    /**
       *metodo que inicializa la dificultad al nivel 2 al momento de perder o ganar una partida, esto para evitar
       *que si alguna de las variables estaticas fue modificada con anterioridad se quede este cambio en la partida actual
       *además de seleccionar la dificultad normal como predefinida
       */
    public static void resetDificulty(){
        vidaHeroe=6;
        nivelDificultad=2;
        RadioBusqueda=120;
        velocidadX = velocidadY = 1;
    }

}
