import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Los recolectables del juego
 * 
 * @author Alan
 * @version 1.5.7
 */
public class Ingrediente extends Actor
{
    private int dx,dy,tempo,correspondiente;
    private int list_position;
    
    /**
     * Constructor para el ingrediente, necesita de el nombre de su imagen y el index, que representa
     * Su posicion en el arreglo estatico de ingredientes
     */
    public Ingrediente(String imagen, int index){ 
        GreenfootImage image = new GreenfootImage(imagen);//Solo para la imagen de prueba;
        image.scale(25,25);
        this.setImage(imagen);
        this.list_position = index; 
        dx=dy=2;
        tempo=0;
    }

    /**
     * Cuando el heroe toca el ingrediente, este es eliminado del mundo
     * se modifica la lista de ingredientes para marcarlo como recogido, emite un sonido
     * y hace al contador cambiar su imagen
     */
    public void Recoger(){
        if(isTouching(Heroe.class)){
            TileWorld world = getWorldOfType(TileWorld.class);
            Ingredientes_list.recolectIngredient(list_position);
            GreenfootSound recogido = new GreenfootSound("Ingrediente.mp3");
            recogido.setVolume(30); 
            recogido.play();
            world.removeObject(this); 
            world.getCounter().add(); 
            
        } 
    }
    
    
    /**
     * metodo para mover el objeto arriba y abajo de manera que parece que levita
     */
    public void act()
    {
        // Add your action code here.
        Recoger();
        tempo++;
        if(tempo==50){
            setLocation(getX(), getY()+dy);
        }else if(tempo==100){
            setLocation(getX(), getY()-dy);
            tempo=0;
        }
        
        
    }

}
