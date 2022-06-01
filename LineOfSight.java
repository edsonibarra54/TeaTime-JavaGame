import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.lang.Math;
import java.util.List;
import java.util.ArrayList;
/**
 * Crea una linea de vision para el enemigo, de esta manera solo puede ver hacia enfrente en vez 
 * de tener una vista radial
 */
public class LineOfSight extends Actor
{
    private Enemy owner;
    private int large,width = 10;
    private int cambioLongitud = 0;
    private GreenfootImage image;
    /**
     * Constructor de los, necesita de un enemigo que será el poseedor de la misma
     * Se asignan diversos datos con la informacion del enemigo
     * @param owner El enemigo propietario de la los
     */
    public LineOfSight(Enemy owner){
        this.owner = owner;
        this.large = this.owner.getRadioB();
        this.image = new GreenfootImage(large,width);
        this.setImage(this.image);
        /*this.image.setColor(Color.RED);//Codigo para hacerla visible
        this.image.fill();*/
        this.addToWorld();
    }
    
    /**
     * Se añade al mundo frente a la posicion de su dueño
     */
    public void addToWorld(){
        TileWorld w = this.owner.getWorldOfType(TileWorld.class);
        w.addObject(this,owner.getX()+(this.large/2),owner.getY());
    }
    
    /**
     * Revisa las clases con las que intersecta, si detecta solamente un heroe, se activa el seguimiento
     * del enemigo, si detecta un heroe y una pared, se calcula quien esta más cerca para determinar si en realidad
     * se ve al enemigo o no
     * @return una lista de heroes
     */
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
    
    /**
     * Se usa el teorema de Pitagoras para calcular la distancia entre dos Actores
     * @return la distancia entre el actor y el enemigo 
     */
    public double calDistance(Actor actor){//Se calcula la distancia entre los objetos por el metodo del teorema de pitagoras 
        return Math.sqrt(Math.pow(actor.getX()-this.getX(),2)+Math.pow(actor.getY()-this.getY(),2));
    }
    /**
     * Se reescala la imagen para coincidir con hacia donde ve el enemigo
     * ademas de modificar su posicion para seguirlo
     * @param sprite indica el sprite que tiene el owner en determinado momento
     */
    public void setOrientation(int sprite){//Movemos la orientacion de la linea dependiendo de hacia donde ve el enemigo
        switch(sprite){
            case 0://Enfrente
                if(cambioLongitud == 0){
                    this.image.scale(width,large);
                    cambioLongitud = 1;
                }
                
                this.setLocation(owner.getX(),owner.getY()+(this.large/2));
            break;
            case 1://De espaldas
                if(cambioLongitud == 0){
                    this.image.scale(width,large);
                    cambioLongitud = 1;
                }
                this.setLocation(owner.getX(),owner.getY()-(this.large/2));
            break;
            case 2://Derecha
                if(cambioLongitud == 1){
                    this.image.scale(large,width);
                    cambioLongitud = 0;
                }
                
                this.setLocation(owner.getX()+(this.large/2),owner.getY());
            break; 
            case 3://Izquierda
                if(cambioLongitud == 1){
                    this.image.scale(large,width);
                    cambioLongitud = 0;
                }
                this.setLocation(owner.getX()-(this.large/2),owner.getY());
            break;
        }
        //this.setImage(this.image);
    }
    

}
