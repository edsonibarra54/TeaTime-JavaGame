import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Text extends Actor
{
    private String image;
    private int tempo;
    
    public Text(String s){
        image = s;
        tempo = 0; 
        setImage(s);
        //getImage().setTransparency(0);
    }
    
    public void act(){
        /*tempo++;
        
        if(tempo == 5){
            getImage().setTransparency(1);
        }else if(tempo == 10){
            getImage().setTransparency(254);
            tempo=0;
        }*/
    }
}
