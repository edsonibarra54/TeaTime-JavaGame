import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Button extends Actor
{
    private int difficulty;
    
    public Button(String s){
        setImage(s);
    }
    
    public void act() 
    {
        handleMouseClicks();
    }
     
    protected void handleMouseClicks(){
        if(Greenfoot.mousePressed(this)){
            clickedAction();
        }
    } 
    
    public abstract void clickedAction(); 
  
}
