import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Dificultad_button here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Dificultad_button extends Button
{
    private int dificultad;
    private String mensaje;
    public Dificultad_button(String s,String mensaje,int dificultad){
        super(s);
        this.dificultad = dificultad; 
        this.mensaje = mensaje;
    }
    public void act()
    { 
        if(Dificultad.nivelDificultad == this.dificultad){
            this.getImage().setTransparency(255);
            addDescription();
        }else{
            this.getImage().setTransparency(150);
        } 
        super.act();
        // Add your action code here.
    }
    
    @Override
    public void clickedAction(){
        Dificultad.changeDifficulty(this.dificultad);
        addDescription();
    }
    
    private void addDescription(){
        World w = this.getWorld();
        if(w.getObjectsAt(300, 270, Text.class).isEmpty() == false){
            w.removeObject(w.getObjectsAt(300, 270, Text.class).get(0)); 
        }
        Text mensaje = new Text(this.mensaje);
        w.addObject(mensaje, 300, 270); 

    }
}
