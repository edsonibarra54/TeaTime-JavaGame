import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Nube1 here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Nube1 extends Nube
{
    private GifImage myGif;
    
    public Nube1(String s){
        myGif = new GifImage(s);
    }
    
    public void act(){
        setImage(myGif.getCurrentImage()); //Se encarga que el gif vaya cambiando de frame
    }
}
