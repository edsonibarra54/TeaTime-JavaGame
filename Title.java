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
            Button button_e = new Dificultad_button("boton_e.png","Vidas más que suficientes y los enemigos son casi ciegos, ¡diviertete!",1);
            world.addObject(button_e,160,200);
            Button button_n = new Dificultad_button("boton_n.png","Tendras que cuidar tus vidas, los enemigos son más competentes",2);
            world.addObject(button_n,300,200);
            Button button_h = new Dificultad_button("boton_h.png","No hay espacio para errores, los enemigos comieron zanahoria", 3);
            world.addObject(button_h,440,200); 
            Button button_p = new Jugar_button("circulo_naranja.png");
            world.addObject(button_p,300,400);
        }
    }
}
