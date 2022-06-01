

/**
 * Write a description of class Guia_sheets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Guia_sheets  
{
    private static String sheets[] = {"guia_0.png","guia_1.png","guia_2.png","guia_3.png","guia_4.png","guia_5.png","guia_6.png"};

    public Guia_sheets()
    {
    }
    
    /**
     * Regresa el nombre de la imagen correspondiente a la posicion index en el arreglo
     * @param index la posicion que se busca obtener en el arreglo
     */
    public static String returnText(int index){
        return sheets[index];
    }
    /**
     * Regresa la longitud del arreglo sheets, que representa la cantidad de paginas en la guia
     */
    public static int returnSheetslength(){
        return sheets.length;
    }


}
