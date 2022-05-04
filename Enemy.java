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
    private int spawnX,spawnY;
    private int pathlength,pathcounter;
    private int radioBusqueda = 80;
    private int velocidadX,velocidadY,rX,rY,vxabs,vyabs;//Variables que permiten modificar la velocidad;
    private int velocidadPersigueX,velocidadPersigueY;//Variables para modificar la velocidad con la que te perigue, util al cambiar dificultad
    private boolean persigue=false,offPath=false;
    private List<Heroe> heroInRange;
    public Enemy(String[] gifsarreglo,int pathL,int speedX,int speedY,int spawnX,int spawnY)
    {
        super(1,speedX,speedY,gifsarreglo[0]);
        this.pathlength=this.pathcounter=pathL;//Definimos el largo del camino que va a hacer
        this.velocidadX=this.rX=this.vxabs=speedX;
        this.velocidadY=this.rY=this.vyabs=speedY;
        this.spawnX=spawnX;
        this.spawnY=spawnY;
        velocidadPersigueX = velocidadPersigueY = 1;
        for(String nombreGif : gifsarreglo){//Este ciclo simplifica el agregar los gifs
            GifImage gif=new GifImage(nombreGif);
            gifs.add(gif);
        }
    }
    public void act()
    {   
        revisarRango();
        cambiarVelocidad();
        movimiento();
        cambiaImagen();
    }
    
    public void cambiaImagen(){
        if(persigue){
            if(this.velocidadY==0){
                if(this.velocidadX>0){
                this.setImage(gifs.get(2).getCurrentImage());
                }else{
                    this.setImage(gifs.get(3).getCurrentImage());
                }
            }
            if(this.velocidadX==0){
                if(this.velocidadY>0){
                this.setImage(gifs.get(0).getCurrentImage());
                }else{
                    this.setImage(gifs.get(1).getCurrentImage());
                }
            }

        }else{
            if(this.velocidadY>0){
                this.setImage(gifs.get(4).getCurrentImage());
            }else if(this.velocidadY<0){
                this.setImage(gifs.get(5).getCurrentImage());
            }else{
                if(this.velocidadX>0){
                this.setImage(gifs.get(6).getCurrentImage());
                }else{
                    this.setImage(gifs.get(7).getCurrentImage());
                }
            }
            
        }
        
    }
    
    public void revisarRango(){//Revisa si hay algun heroe en el rango
        heroInRange =getObjectsInRange(radioBusqueda,Heroe.class);
        if(heroInRange.isEmpty()){
            persigue = heroInRange.isEmpty();
        }else{
            persigue = heroInRange.get(0).ocultar();
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
            if(this.spawnX==this.getX()&&this.spawnY==this.getY()){
                this.offPath=false;
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
        this.setLocation(spawnX,spawnY);
        this.pathcounter=this.pathlength;
        this.rX=this.vxabs;
        this.rY=this.vyabs;
    }
}


