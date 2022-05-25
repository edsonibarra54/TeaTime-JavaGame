import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Button extends Actor
{
    private String image,first,second;
    private int difficulty;
    
    public Button(String s, int d){
        difficulty=d;
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
        /*if(Greenfoot.mousePressed(this)){
            setImage(s);
        }
        else if(Greenfoot.mouseClicked(this)){
            setImage(first);
            clickedAction();
        }*/
    }
    
    public void clickedAction() 
    {
        Dificultad.changeDifficulty(this.difficulty);
        World  w = this.getWorld(); 
        w.getObjects(JukeBox.class).get(0).stop();
        w.removeObject(w.getObjects(JukeBox.class).get(0));
        World world = new Sala_1(1);
        Greenfoot.setWorld(world); 
    }
}
