import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Title extends Actor
{
    private int dx,dy,tempo,flag=0;
    //private GreenfootSound intro= new GreenfootSound("PALACIO DE VERSALLES...MUSICA RELAJANTE...NISI DOMINUS (128 kbps).mp3");
    public Title(){
        dx=dy = 2;
        tempo = 0;
    }
    
    public void act()
    {
        tempo++;
        if(tempo < 70 && flag == 0){
            setLocation(getX(), getY() + dy);
        }
        else if(tempo >= 70 && flag == 0){
            Inicio world = getWorldOfType(Inicio.class);
            Text instruction = new Text("press.png");
            world.addObject(instruction,300,350);
            instruction.act();
            if (Greenfoot.isKeyDown("SPACE")){
                world.removeObjects(world.getObjects(Text.class));
                flag = 1;
                tempo = 0;
            }
        }
        else if(tempo < 86 && flag == 1){
            this.getImage().setTransparency(this.getImage().getTransparency() - 3);
        }
        if(this.getImage().getTransparency() == 0){
            Inicio world = getWorldOfType(Inicio.class);
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
