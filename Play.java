import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Write a description of class Play here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Play extends Button
{
    private GreenfootSound intro= new GreenfootSound("PALACIO DE VERSALLES...MUSICA RELAJANTE...NISI DOMINUS (128 kbps).mp3");
    /**
     * Act - do whatever the Play wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private int tiempo=100;
    public Play(){
        super("circulo_naranja.png","anillo_azul.png");
        intro.playLoop();
    }
    public void stop()
    {
        intro.stop();
    }
    public void act()
    {
        super.act();
        if(tiempo<100)
        {
            tiempo++;
            if(tiempo==100)
            {
            World mundo = getWorld();
            mundo.showText("",300,350);
            tiempo=0;                
            }
        }
    }
    @Override
    public void clickedAction(){
        if(Dificultad.nivelDificultad!=0)
        {
        ListaDeMundoTiles.DesactivaLamusicaActual=true;
        World world= getWorld();
        stop();
        intro=new GreenfootSound("Chin chin (brindis) - Efecto de sonido _ Toast - Sound effect (128 kbps).mp3");
        intro.play();
        world.stopped();
        world = new Sala_1(1);
        Greenfoot.setWorld(world);
        }else
        {
            World mundo = getWorld();
            mundo.showText("Debes elegir una dificultad!",300,350);
            tiempo=0;
            GreenfootSound intra=new GreenfootSound("Efecto de sonido audiencia sorprendida (128 kbps).mp3");
            intra.play();
        }
    }
}
