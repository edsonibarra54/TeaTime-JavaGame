import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor
{
    private String image;
    private int difficulty;
    
    public Button(String s, int d){
        image = s;
        difficulty = d;
        setImage(s);
    }
    
    public void act()
    {
        handleMouseClicks();
    }
    
    private void handleMouseClicks(){
        if(Greenfoot.mousePressed(this)){
            clickedAction();
        }
    }
    
    public void clickedAction(){
        World world = new Sala_1(1);
        Greenfoot.setWorld(world);
    }
}
