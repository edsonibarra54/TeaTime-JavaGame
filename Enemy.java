import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.*;
import java.util.ArrayList;

/**
 * El enemigo es el principal obstaculo del juego, persigue y daña al heroe, para esto
 * analiza lo que hay en su rango de vision
 */ 
public class Enemy extends Personaje
{
    
    private ArrayList<GifImage> gifs = new ArrayList(); 
    private LineOfSight los;
    private int songFlag = 0;
    private int spawnX,spawnY;
    private int pathlength,pathcounter;//pl = longitud del path, pc = variable que se modifica para saber cuando ya se recorrio todo el path
    private int radioBusqueda = Dificultad.RadioBusqueda;
    private int velocidadX,velocidadY,rX,rY,vxabs,vyabs;//Variables que permiten modificar la velocidad;
    private int velocidadPersigueX,velocidadPersigueY;//Variables para modificar la velocidad con la que te perigue, util al cambiar dificultad
    private boolean persigue=false,offPath=false,losActive=true;
    /*Si persigue = true, entonces no esta en rango el heroe, si offPath = true, quiere decir que el enemigo persigió al heroe y se 
       salió de su ruta, si losActive = true, entonces el enemigo usa la vista linear en vez de radial*/
    private List<Heroe> heroInRange;
    
    /**
     * Constructor de enemy
     * @param gifsarreglo Un arreglo con los nombres de los sprites correspondientes
     * @param pathL el largo del camino que el enemigo va a recorrer
     * @param speedX la velocidad del enemigo en X
     * @param speedY la velocidad del enemigo en Y
     * @param spawnX el spawn del enemigo en X
     * @param spawnY el spawn del enemigo en Y
     */
    public Enemy(String[] gifsarreglo,int pathL,int speedX,int speedY,int spawnX,int spawnY)
    {
        super(1,speedX,speedY,gifsarreglo[0]);
        this.pathlength=this.pathcounter=pathL;//Definimos el largo del camino que va a hacer
        this.velocidadX=this.rX=this.vxabs=speedX;//vxabs no cambia y permite siempre recordar la velocidad original
        this.velocidadY=this.rY=this.vyabs=speedY;
        this.spawnX=spawnX;
        this.spawnY=spawnY;
        velocidadPersigueX =  Dificultad.velocidadX;
        velocidadPersigueY = Dificultad.velocidadY;
        for(String nombreGif : gifsarreglo){//Este ciclo simplifica el agregar los gifs
            GifImage gif=new GifImage(nombreGif);
            gifs.add(gif);
        }
    }
    
    /**
     * Se añade su linea de vision al mundo
     * @param w el mundo donde se encuentra el enemigo
     */
    protected void addedToWorld(World w){
        this.los = new LineOfSight(this);
    } 
    
    /**
     * Revisa si hay un heroe en rango, cambia su velocidad dependiendo de si lo hay o no
     * Se mueve utilizando la velocidad anterior y cambia su sprite para coincidir hacia donde se mueve
     */
    public void act()
    {   
        revisarRango();
        cambiarVelocidad();
        movimiento();
        cambiaImagen();
    }
    
    /*public void changeSong(String song){
        TileWorld w = this.getWorldOfType(TileWorld.class);
        w.getJB().changeSong(song);
    }*/
    
    /**
     * Utilizando su velocidad actual en los ejes determinamos hacia donde esta viendo y cambiamos
     * su sprite para coincidir, si esta persiguiendo al heroe entonces su sprite es diferente
     */
    public void cambiaImagen(){
        if(persigue){
            if(this.velocidadY==0){
                if(this.velocidadX>0){
                    this.setImage(gifs.get(2).getCurrentImage());
                    this.los.setOrientation(2);
                }else{
                    this.setImage(gifs.get(3).getCurrentImage());
                    this.los.setOrientation(3);
                }
            }
            if(this.velocidadX==0){
                if(this.velocidadY>0){
                    this.setImage(gifs.get(0).getCurrentImage());
                    this.los.setOrientation(0);
                }else{
                    this.setImage(gifs.get(1).getCurrentImage());
                    this.los.setOrientation(1);
                }
            }

        }else{
            if(this.velocidadY>0){
                this.setImage(gifs.get(4).getCurrentImage());
                this.los.setOrientation(0);
            }else if(this.velocidadY<0){
                this.setImage(gifs.get(5).getCurrentImage());
                this.los.setOrientation(1);
            }else{
                if(this.velocidadX>0){
                    this.setImage(gifs.get(6).getCurrentImage());
                    this.los.setOrientation(2);
                }else{
                    this.setImage(gifs.get(7).getCurrentImage());
                    this.los.setOrientation(3);
                }
            }
            
        }
        
    }
    /**
     * Revisa si hay un heroe en el rango, si la los esta activa, utiliza esta para analizar su entorno
     * si se encuentra persiguiendo al heroe, va a utilizar un rango radial para detectar al heroe
     */
    public void revisarRango(){//Revisa si hay algun heroe en el rango
        if(losActive){
            heroInRange = this.los.losClear();
            if(heroInRange.isEmpty()){
                persigue = heroInRange.isEmpty();
                
            }else{
                persigue = heroInRange.get(0).ocultar();
                if(persigue == false){
                    losActive = false;
                    JukeBox.pause();
                    JukeBoxEnemy.play();
                }
            }
            
        }else{
            heroInRange = getObjectsInRange(radioBusqueda,Heroe.class);
            if(heroInRange.isEmpty()){
                persigue = heroInRange.isEmpty();
            }else{
                persigue = heroInRange.get(0).ocultar(); 
            }
    
        }


    }
    
    /**
     * Cuando se detecta que salió de su camino para perseguir al heroe y después lo pierde
     * va a regresar a su spawn definido
     */
    public void regresarASpawn(){
        /*Se usan las velocidades de persecucion por que puede ser que el enemigo no tenga velocidad en algun eje*/
            if(this.spawnX>this.getX()){
                this.velocidadX = this.velocidadPersigueX;
            }else if(this.spawnX==this.getX()){
                this.velocidadX=0;
            }else{
                this.velocidadX = -this.velocidadPersigueX;
            }
            if(this.spawnY>this.getY()){
                this.velocidadY = this.velocidadPersigueY;
            }else if(this.spawnY==this.getY()){
                this.velocidadY=0;
            }else {
                this.velocidadY = -this.velocidadPersigueY;
            }
            if(Math.abs(this.spawnX-this.getX())<=5&&Math.abs(this.spawnY-this.getY())<=5){
                this.offPath=false;
                this.losActive=true;
                this.resetPosition();
            }
    }
    /**
     * Dependiendo de si esta siguiendo o no al heroe, va a modificar su velocidad para 
     * continuar su camino predefinido o para hacercarse al heroe
     */
    public void cambiarVelocidad(){
        if(persigue && pathlength != 0){
            if(!offPath){
                this.velocidadX = this.rX;
                this.velocidadY = this.rY;
                this.pathcounter--;
                if(pathcounter == 0){//Si ya terminó de recorrer el camino, hacemos que se de la media vuelta
                    this.pathcounter = this.pathlength;
                    this.velocidadX = this.rX = -this.velocidadX;//Se inverte la velocidad por que regresa sobre sus pasos
                    this.velocidadY = this.rY = -this.velocidadY;
                }
            }else{   
                regresarASpawn();
            } 
            
        }else{
            if(heroInRange.get(0).getX()>this.getX()){
                this.velocidadX = this.velocidadPersigueX;
            }else{
                this.velocidadX = -this.velocidadPersigueX;
            }
            if(heroInRange.get(0).getY()>this.getY()){
                this.velocidadY = this.velocidadPersigueY;
            }else if(heroInRange.get(0).getY()==this.getY()){
                this.velocidadY = 0;
            }else {
                this.velocidadY = -this.velocidadPersigueY;
            }
            offPath=true;
        }
    }
    
    /**
     * El movimiento del enemigo es sencillo, se mueve en velocidad pixeles, la velocidad varia con su propio metodo
     * tambien cuenta con colision en las paredes
     */
    @Override 
    public void movimiento(){
        this.setLocation(this.getX()+velocidadX,this.getY()+velocidadY);
        if(isTouching(ColliderTile.class)){
            this.setLocation(this.getX()-velocidadX,this.getY()-velocidadY);
        }
    }
    /**
     * Resetea la informacion del enemigo cuando este regresa a su spawn
     */
    public void resetPosition(){//Regresa al enemigo a su spawn
        JukeBoxEnemy.stop();
        JukeBox.play(); 
        this.setLocation(spawnX,spawnY);
        this.pathcounter=this.pathlength;
        this.rX=this.vxabs;
        this.rY=this.vyabs;
    }
    
    /**
     * @return la velocidad en X
     */
    public int getVelX(){
        return rX;
    }
    
    /**
     * @return la velocidad en Y
     */
    public int getVelY(){
        return rY;
    }
    
    /**
     * @return su radio de busqueda
     */
    public int getRadioB(){
        return this.radioBusqueda;
    }
    
    /**
     * @return el pathcounter
     */
    public int getPathCounter(){
        return this.pathcounter;
    }
}



