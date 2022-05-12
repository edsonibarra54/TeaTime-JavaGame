import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

public class Difficulty extends Button
{
    private int diff;
    
    public Difficulty(int d){
        super("circulo_naranja.png","anillo_azul.png");
        diff = d;
        if(diff==1)
        {
            Dificultad.RadioBusqueda=80;
            Dificultad.velocidadX=1;
            Dificultad.velocidadY=1;
        }
        if(diff==2)
        {
            Dificultad.RadioBusqueda=100;
            Dificultad.velocidadX=2;
            Dificultad.velocidadY=1;
        }
        if(diff==3)
        {
            Dificultad.RadioBusqueda=130;
            Dificultad.velocidadX=1;
            Dificultad.velocidadY=2;
        }
    }
    
    @Override
    public void clickedAction(){
        //World world = new Sala_1(diff);
        //Greenfoot.setWorld(world);
    }
}