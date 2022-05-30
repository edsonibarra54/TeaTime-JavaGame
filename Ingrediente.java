import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ingrediente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ingrediente extends Actor
{
    private int dx,dy,tempo;
    private int list_position;

    public Ingrediente(String imagen, int index){
        GreenfootImage image = new GreenfootImage(imagen);//Solo para la imagen de prueba;
        image.scale(25,25);
        this.setImage(imagen);
        this.list_position = index; 
        dx=dy=2;
        tempo=0;
    }

    
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
     * Act - do whatever the Ingrediente wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
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
