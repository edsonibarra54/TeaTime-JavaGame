import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Guia here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Guia extends Actor
{
    int index = 0;
    int delay = 20;
    public Guia(){
        setImage(Guia_sheets.returnText(index)); 
    }
    
    public void cambiaImagen(int index){
        setImage(Guia_sheets.returnText(index));
    }
    public void act()
    {
        delay++;
        if(Greenfoot.isKeyDown("SPACE") && delay>20){
            index++;
            delay = 0;
            if(index<Guia_sheets.returnSheetslength() ){
                cambiaImagen(index);
            }else{
                World w = getWorld();
                w.removeObject(this); 
            }
        }

    }
}
