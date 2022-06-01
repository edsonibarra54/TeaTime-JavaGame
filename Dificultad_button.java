import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Boton que permite seleccionar la dificultad del juego
 */
public class Dificultad_button extends Button
{
    private int dificultad;
    private String mensaje;
    /**
     * Constructor de boton de dificultad, contiene la dificultad que estará representando
     * @param s el nombre de la imagen que se le dara
     * @param mensaje el nombre de la imagen que contiene la informacion de su dificultad
     * @param dificultad la dificultad que el boton representa
     */
    public Dificultad_button(String s,String mensaje,int dificultad){
        super(s);
        this.dificultad = dificultad; 
        this.mensaje = mensaje;
    }
    /**
     * Maneja las acciones a realizar cuando se da click, además, cambia su transparencia
     * cuando el boton ha sido seleccionado
     */
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
    
    /**
     * Cuando se le da click, llama al metodo estatico changeDifficulty con la dificultad del boton
     * Además, se añade la imagen que presenta su descripcion
     */
    @Override
    public void clickedAction(){
        Dificultad.changeDifficulty(this.dificultad);
        addDescription();
    }
        
    /**
     * Añade la descripcion de la dificultad, y si ya hay un objeto de este tipo en la posicion
     * lo elimina
     */
    private void addDescription(){
        World w = this.getWorld();
        if(w.getObjectsAt(300, 270, Text.class).isEmpty() == false){
            w.removeObject(w.getObjectsAt(300, 270, Text.class).get(0)); 
        }
        Text mensaje = new Text(this.mensaje);
        w.addObject(mensaje, 300, 270); 

    }
}
