import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
import java.util.*;
import java.util.ArrayList;

/**
 * Write a description of class Enemy here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Enemy extends Personaje
{
    
    private ArrayList<GifImage> gifs = new ArrayList();
    private LineOfSight los;
    private int songFlag = 0;
    private int spawnX,spawnY;
    private int pathlength,pathcounter;
    private int radioBusqueda = Dificultad.RadioBusqueda;
    private int velocidadX,velocidadY,rX,rY,vxabs,vyabs;//Variables que permiten modificar la velocidad;
    private int velocidadPersigueX,velocidadPersigueY;//Variables para modificar la velocidad con la que te perigue, util al cambiar dificultad
    private boolean persigue=false,offPath=false,losActive=true;
    /*Si persigue = true, entonces no esta en rango el heroe, si offPath = true, quiere decir que el enemigo persigió al heroe y se 
       salió de su ruta, si losActive = true, entonces el enemigo usa la vista linear en vez de radial*/
    private List<Heroe> heroInRange;
    public Enemy(String[] gifsarreglo,int pathL,int speedX,int speedY,int spawnX,int spawnY)
    {
        super(1,speedX,speedY,gifsarreglo[0]);
        this.pathlength=this.pathcounter=pathL;//Definimos el largo del camino que va a hacer
        this.velocidadX=this.rX=this.vxabs=speedX;
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
    
    protected void addedToWorld(World w){
        this.los = new LineOfSight(this);
    } 
    
    public void act()
    {   
        revisarRango();
        cambiarVelocidad();
        movimiento();
        cambiaImagen();
    }
    
    public void changeSong(String song){
        TileWorld w = this.getWorldOfType(TileWorld.class);
        w.getJB().changeSong(song);
    }
    
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
    
    public void revisarRango(){//Revisa si hay algun heroe en el rango
        if(losActive){
            heroInRange = this.los.losClear();
            if(heroInRange.isEmpty()){
                persigue = heroInRange.isEmpty();
                
            }else{
                persigue = heroInRange.get(0).ocultar();
                if(persigue == false){
                    losActive = false;
                    changeSong("Battle.mp3"); 
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
    
    public void regresarASpawn(){
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
    
    public void cambiarVelocidad(){
        if(persigue && pathlength != 0){
            if(!offPath){
                this.velocidadX = this.rX;
                this.velocidadY = this.rY;
                this.pathcounter--;
                if(pathcounter == 0){//Si ya terminó de recorrer el camino, hacemos que se de la media vuelta
                    this.pathcounter = this.pathlength;
                    this.velocidadX = this.rX = -this.velocidadX;
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
    
    @Override 
    public void movimiento(){
        this.setLocation(this.getX()+velocidadX,this.getY()+velocidadY);
        if(isTouching(ColliderTile.class)){
            this.setLocation(this.getX()-velocidadX,this.getY()-velocidadY);
        }
    }
    
    public void resetPosition(){//Regresa al enemigo a su spawn
        changeSong("Take some rest.mp3"); 
        this.setLocation(spawnX,spawnY);
        this.pathcounter=this.pathlength;
        this.rX=this.vxabs;
        this.rY=this.vyabs;
    }
    
    public int getVelX(){
        return rX;
    }
    
    public int getVelY(){
        return rY;
    }
    
    public int getRadioB(){
        return this.radioBusqueda;
    }
    
    public int getPathCounter(){
        return this.pathcounter;
    }
}


