import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Title extends Actor
{
    private int dx,dy,tempo;
    
    public Title(){
        dx=dy = 2;
        tempo = 0;
    }
    
    public void act()
    {
        tempo++;
        if(tempo<70){
            setLocation(getX(), getY() + dy);
        }
        else{
            Inicio world = getWorldOfType(Inicio.class);
            TextBox instruction = new TextBox("Presiona SPACE para continuar",20);
            world.addObject(instruction,300,350);
            if (Greenfoot.isKeyDown("SPACE")){
                world.removeObjects(world.getObjects(TextBox.class));
                world.removeObject(this);
                TextBox difficulty = new TextBox("Escoge una dificultad",20);
                world.addObject(difficulty,300,140);
                Button button_e = new Button("boton_e.png",1);
                world.addObject(button_e,300,200);
                Button button_n = new Button("boton_n.png",2);
                world.addObject(button_n,300,275);
                Button button_h = new Button("boton_h.png",3);
                world.addObject(button_h,300,350);
            }
        }
    }
}
