import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;

/**
 * Clase que lleva la cuenta de cuantos ingredientes han sido recogidos
 * además de mostrarlo en pantalla
 */
public class Counter extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private int target;
    private ArrayList<IngredientTile> ingredients = new ArrayList<>();    

    /**
     * Constructor de counter, instancia las siluetas de los ingredientes representados
     * dentro de esta clase y los añade a una lista
     */    
    public Counter()
    {
        IngredientTile azucar = new IngredientTile("azucar_silueta.png");
        IngredientTile te = new IngredientTile("planta_silueta.png");
        IngredientTile taza = new IngredientTile("taza_silueta.png");
        ingredients.add(azucar);
        ingredients.add(te);
        ingredients.add(taza);
    }
    
    /**
     * Se añaden los objetos que componen al contador al mundo
     */
    public void addToWorld(World w){
        w.addObject(ingredients.get(2), 585, 350);
        w.addObject(ingredients.get(1), 545, 350);
        w.addObject(ingredients.get(0), 505, 350); 
    }

    /**
     * Se modifican las siluetas por la imagen completa dependiendo de si el ingrediente fue recogido
     * o no
     */
    public void cambiaSilueta(){
        if(Ingredientes_list.checkIngredient(0)==1){
            ingredients.get(0).setImage("azucar.png");
        }
        if(Ingredientes_list.checkIngredient(1)==1){
            ingredients.get(1).setImage("planta.png");
        }
        if(Ingredientes_list.checkIngredient(2)==1){
            ingredients.get(2).setImage("taza.png"); 
        }
    }

    /**
     * Add a new score to the current counter value.  This will animate
     * the counter over consecutive frames until it reaches the new value.
     */
    public void add()
    {
        cambiaSilueta();
    }

    /**
     * Return the current counter value.
     */
    public int getValue()
    {
        return target;
    }




}
