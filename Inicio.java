import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Inicio extends World
{
    public Inicio()
    {   
        super(600, 400, 1); 
        prepare();
        //intro.stop();
        //intro.playLoop();
    }
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        ListaDeMundoTiles.DesactivaLamusicaActual=false;

        setBackground("title_screen.png");
        Button button = new Play();
        addObject(button,291,271);
        button.setLocation(301,301);

    }

}
