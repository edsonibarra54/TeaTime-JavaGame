import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Derrota extends Actor
{
    private int tempo;
    public Derrota(){
        setImage("Pantalla_derrota.png");
        tempo = 0;
        this.getImage().setTransparency(0);
    }
    
    public void act()
    {
        tempo++;
        if(tempo >= 255 && tempo < 497){ //Esta realiza la animacion donde se aclara 
            this.getImage().setTransparency(this.getImage().getTransparency() + 1);
        }
        if(Greenfoot.isKeyDown("SPACE") && tempo >= 497){
            World w = new Inicio();
            Greenfoot.setWorld(w);
        }
    }
}
