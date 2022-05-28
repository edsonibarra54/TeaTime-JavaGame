import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Casa extends Actor
{
    private String image;
    
    public Casa(String s){
        image = s;
        setImage(image);
    }
    
    public void cambiaCasa(){
        setImage("casa_2.png");
    }
}
