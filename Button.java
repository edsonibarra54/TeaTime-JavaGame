import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public abstract class Button extends Actor
{
    protected String first;
    protected String second;
    
    public Button(String f, String s){
        first = f;
        second = s;
        setImage(f);
    }
    
    public void act()
    {
        handleMouseClicks();
    }
    
    private void handleMouseClicks(){
        if(Greenfoot.mousePressed(this)){
            setImage(second);
        }
        else if(Greenfoot.mouseClicked(this)){
            setImage(first);
            clickedAction();
        }
    }
    
    public abstract void clickedAction();
}
