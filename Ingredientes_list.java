/**
 * Write a description of class Ingredientes_list here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ingredientes_list   
{
    private static int ing_checklist[] = {0,0,0};
    private static String sprites1[] = {"azucar.png","planta.png","taza.png"};

    public Ingredientes_list()
    {
    }
    
    public static int checkIngredient(int index){
        return ing_checklist[index];
    }
    
    public static void recolectIngredient(int index){
        ing_checklist[index] = 1;
    }
    
    public static String getSprite(int index){
        return sprites1[index];
    }
    
    public static void resetIngredients(){
        ing_checklist[0] = 0;
        ing_checklist[1] = 0;
        ing_checklist[2] = 0;
    }
}
