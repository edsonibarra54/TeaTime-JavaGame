

/**
 * Write a description of class Guia_sheets here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Guia_sheets  
{
    private static String sheets[] = {"guia_0.png","guia_1.png","guia_2.png","guia_3.png","guia_4.png"};

    public Guia_sheets()
    {
    }
    
    public static String returnText(int index){
        return sheets[index];
    }
    
    public static int returnSheetslength(){
        return sheets.length;
    }


}
