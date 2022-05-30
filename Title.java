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
            Text difficulty = new Text("dificultad.png"); 
            world.addObject(difficulty,300,100); 
            Button button_e = new Dificultad_button("boton_e.png","Texto_d1.png",1);
            world.addObject(button_e,160,200);
            Button button_n = new Dificultad_button("boton_n.png","Texto_d2.png",2);
            world.addObject(button_n,300,200);
            Button button_h = new Dificultad_button("boton_h.png","Texto_d3.png", 3);
            world.addObject(button_h,440,200); 
            Button button_g = new Guia_button("boton_g.png");
            world.addObject(button_g,220,350); 
            Button button_p = new Jugar_button("boton_j.png");  
            world.addObject(button_p,380,350); 
        }
    }
}
