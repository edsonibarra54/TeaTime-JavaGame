import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Clase que muestra en pantalla las imagenes correspondientes a la guia
 */
public class Guia extends Actor
{
    int index = 0;
    int delay = 20;
    
    public Guia(){
        setImage(Guia_sheets.returnText(index)); 
    }
    
    
    /**
     * Cambia la imagen de la guia para corresponder con el index
     */
    public void cambiaImagen(int index){
        setImage(Guia_sheets.returnText(index));
    }
    /**
     * Cada que se presiona space se cambia la pagina de la guia
     * se usa un delay para evitar que el space se precione constantemente
     */
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
