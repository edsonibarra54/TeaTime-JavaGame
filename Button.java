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
    }
    
    public void clickedAction() 
    {
        Dificultad.changeDifficulty(this.difficulty);
        World  w = this.getWorld();
        JukeBox.changeSong("Take some rest.mp3");
        World world = new Sala_0(); 
        Greenfoot.setWorld(world); 
        /*
        World world = new Sala_1(1); 
        Greenfoot.setWorld(world); 
        */
    }
}
