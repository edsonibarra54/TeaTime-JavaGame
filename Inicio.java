import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Inicio extends World
{
    public Inicio()
    {   
        super(600, 400, 1); 
        setPaintOrder(Nube2.class, Title.class, Nube1.class);
        prepare();
    }
    
    /**
     * Prepare the world for the start of the program.
     * That is: create the initial objects and add them to the world.
     */
    private void prepare()
    {
        setBackground("title_screen.png");
        Title title = new Title();
        addObject(title,298,0);
        TextBox instruction = new TextBox("Presiona SPACE para continuar",20);
        addObject(instruction,298,350);
        Nube2 nube_2 = new Nube2("nube_2.gif");
        addObject(nube_2,300,140);
        Nube1 nube_3 = new Nube1("nube_3.gif");
        addObject(nube_3,300,30);
    }
}
