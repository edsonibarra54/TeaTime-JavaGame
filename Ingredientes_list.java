/**
 * Esta clase permite saber el estado de determinado ingrediente y si este debe ser
 * agregado a una sala o no
 */
public class Ingredientes_list   
{
    private static int ing_checklist[] = {0,0,0};
    private static String sprites1[] = {"azucar.png","planta.png","taza.png"};


    /**
     * Retorna el valor que se encuentra en la posicion index del arreglo, si esta es 0,
     * el ingrediente aun no es recogido, si es 1, el ingrediente ya se recogio
     * @return el valor de la posicion index en ing_checklist
     */
    public static int checkIngredient(int index){
        return ing_checklist[index];
    }
    /**
     * Cuando un ingrediente que representa la posicion index en el arreglo es recogido
     * se modifica el valor en la posicion index del arreglo a 1
     * @param index la posicion que representa a determinado ingrediente
     */
    public static void recolectIngredient(int index){
        ing_checklist[index] = 1;
    }
    /**
     * Regresa el nombre de la imagen correspondiente a la posicion index en el arreglo
     * sprites1
     * @return el nombre del sprite correspondient
     */
    public static String getSprite(int index){
        return sprites1[index];
    }
    /**
     * Resetea el arreglo de ingredientes a 0 cada que se empieza un nuevo juego
     */
    public static void resetIngredients(){
        ing_checklist[0] = 0;
        ing_checklist[1] = 0;
        ing_checklist[2] = 0;
    }
    /**
     * regresa si el ingrediente correspondiente a 0 ya se recogio
     * @return 1 si ya fue recogido
     */
    public static int getIngredient0(){
        return ing_checklist[0];
    }
    /**
     * regresa si el ingrediente correspondiente a 1 ya se recogio
     * @return 1 si ya fue recogido
     */
    public static int getIngredient1(){
        return ing_checklist[1];
    }
    /**
     * regresa si el ingrediente correspondiente a 2 ya se recogio
     * @return 1 si ya fue recogido
     */
    public static int getIngredient2(){
        return ing_checklist[2];
    }
}
