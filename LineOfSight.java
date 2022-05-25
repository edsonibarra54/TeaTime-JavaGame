import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
/**
 * Write a description of class LineOfSight here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class LineOfSight extends Actor
{
    private Enemy owner;
    private int large,width = 10;
    private GreenfootImage image;
    
    public LineOfSight(Enemy owner){
        this.owner = owner;
        this.large = this.owner.getRadioB();
        this.image = new GreenfootImage(large,width);
        this.setImage(this.image);
        this.image.setColor(Color.RED);//Codigo para hacerla visible
        this.image.fill();
        this.addToWorld();
    }
    
    public void addToWorld(){
        TileWorld w = this.owner.getWorldOfType(TileWorld.class);
        w.addObject(this,owner.getX()+(this.large/2),owner.getY());
    }
    
    public void act()
    {
        
    }
    
    public List<Heroe> losClear(){//Revisamos lo que esta dentro del area de vision
        List<Heroe> heroAtlos = new ArrayList<Heroe>();
        if(getOneIntersectingObject(ColliderTile.class) == null && getIntersectingObjects(Heroe.class).isEmpty() == false){//Si solamente hay heroe
            heroAtlos = getIntersectingObjects(Heroe.class);
        }else if(getIntersectingObjects(Heroe.class).isEmpty() == false){//Si no hay heroe
            heroAtlos.clear();
        }else if(getOneIntersectingObject(ColliderTile.class) != null && getIntersectingObjects(Heroe.class).isEmpty() == false){//Si hay un heroe y una pared
            if(calDistance(getOneIntersectingObject(Heroe.class)) < calDistance(getOneIntersectingObject(ColliderTile.class))){
                //Revisamos quien esta más cerca, la pared o el heroe, si el heroe esta más cerca, quiere decir que el enemigo lo puede ver
                heroAtlos = getIntersectingObjects(Heroe.class);
            }else
                heroAtlos.clear();//Si la pared esta más cerca, entonces no lo ve
        }
        return heroAtlos; 
    }
    
    public double calDistance(Actor actor){//Se calcula la distancia entre los objetos por el metodo del teorema de pitagoras 
        return Math.sqrt(Math.pow(actor.getX()-this.getX(),2)+Math.pow(actor.getY()-this.getY(),2));
    }
    
    public void setOrientation(int sprite){//Movemos la orientacion de la linea dependiendo de hacia donde ve el enemigo
        switch(sprite){
            case 0://Enfrente
                this.image.scale(width,large);
                this.setLocation(owner.getX(),owner.getY()+(this.large/2));
            break;
            case 1://De espaldas
                this.image.scale(width,large);
                this.setLocation(owner.getX(),owner.getY()-(this.large/2));
            break;
            case 2://Derecha
                this.image.scale(large,width);
                this.setLocation(owner.getX()+(this.large/2),owner.getY());
            break;
            case 3://Izquierda
                this.image.scale(large,width);
                this.setLocation(owner.getX()-(this.large/2),owner.getY());
            break;
        }
        //this.setImage(this.image);
    }
    

}
