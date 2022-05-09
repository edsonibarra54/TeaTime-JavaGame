import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Difficulty extends Button
{
    private int diff;
    
    public Difficulty(int d){
        super("circulo_naranja.png","anillo_azul.png");
        diff = d;
    }
    
    @Override
    public void clickedAction(){
        World world = new Sala_1(diff);
        Greenfoot.setWorld(world);
    }
}
