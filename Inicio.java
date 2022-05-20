import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Inicio extends World
{
    public Inicio()
    {   
        super(600, 400, 1); 
        ListaDeMundoTiles.DesactivaLamusica=false;
         ListaDeMundoTiles.ingrediente[2]=0;
        ListaDeMundoTiles.ingrediente[1]=0;
        ListaDeMundoTiles.ingrediente[0]=0;
        setPaintOrder(TextBox.class, Button.class, Nube2.class, Title.class, Nube1.class);
        prepare();
        Dificultad.nivelDificultad=0;
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
        Title title = new Title();
        addObject(title,298,0);
        Nube2 nube_2 = new Nube2("nube_2.gif");
        addObject(nube_2,300,140);
        Nube1 nube_3 = new Nube1("nube_3.gif");
        addObject(nube_3,300,30);
        JukeBox musica_inicial = new JukeBox("PALACIO DE VERSALLES...MUSICA RELAJANTE...NISI DOMINUS (128 kbps).mp3");
        addObject(musica_inicial,0,0);
    }

}
