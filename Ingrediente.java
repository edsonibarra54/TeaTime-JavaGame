import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Ingrediente here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Ingrediente extends Actor
{
    private int dx,dy,tempo,correspondiente;

    public Ingrediente(String imagen){
        GreenfootImage image = new GreenfootImage(imagen);//Solo para la imagen de prueba;
        image.scale(25,25);
        this.setImage(imagen);
        this.getImage().scale(25,25);
        dx=dy=2;
        tempo=0;
        correspondiente=0;
    }

    
    public void Recoger(){
        if(isTouching(Heroe.class)){
            TileWorld world = getWorldOfType(TileWorld.class);
            GreenfootSound recogido = new GreenfootSound("Ingrediente.mp3");
            recogido.setVolume(45);
            recogido.play();
            ListaDeMundoTiles.ingrediente[correspondiente]=1;
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
    public void setCorrespondiente(int x)
    {
        this.correspondiente=x;
    }
    public int getCorrespondiente()
    {
        return this.correspondiente;
    }
}