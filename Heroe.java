import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Heroe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
//Edson
public class Heroe extends Personaje
{
    private int num_image,cambio=0,tempo=0,crea_contenedores=1,unica=1;
    private ArrayList<HeartTile> corazon = new ArrayList<>();
    private GifImage myGif = new GifImage("principal_enfrente.gif");
    private GifImage gif_enfrente = new GifImage("principal_enfrente.gif");
    private GifImage gif_espalda = new GifImage("principal_espalda.gif");
    private GifImage gif_derecha = new GifImage("principal_derecha.gif");
    private GifImage gif_izquierda = new GifImage("principal_izquierda.gif");
    private GreenfootSound sonido=new GreenfootSound("pasto.mp3");
    private String checa;
    private int antX,antY;
    private int tiempo=50;
    private boolean cancelaMovimiento; //Indica si el jugador podra mover al heroe 
    
    public Heroe(int vida,int velocidadX,int velocidadY,String nombre_imagen)
    {
        super(vida,velocidadX,velocidadY,nombre_imagen);
        cancelaMovimiento = true;
        HeartTile corazones;
        for(int i=0;i<(super.getvida()/2);i++)
        {
            corazones = new HeartTile();
            corazon.add(corazones);
        }
        if(super.getvida()%2!=0)
        {
            corazones = new HeartTile();
            corazones.getImage().mirrorHorizontally();
            corazon.add(corazones);
        }
        antX=antY=300;
    }
    public void addActorAtTileLocation(int i)
    {
        HeartTile contenedor = new HeartTile();
        World mundo = getWorld();
        if(contenedor!=null)
        {
            mundo.addObject(contenedor,0,0);            
        }
    }
    public void reproduceSonido()
    {
        String imagen;
        Actor Sonido = getOneIntersectingObject(TileActor.class);
        checa=Sonido.getImage().toString();
        imagen=checa;
        //World mundo = getWorld();
        //mundo.showText(imagen,300,300);
        if(sonido.isPlaying()==false && tiempo!=0)
        {
            sonido=new GreenfootSound("pasto.mp3");
            sonido.setVolume(50);
            sonido.play();
        }
        if(getX()==antX && getY()==antY && tiempo!=0)
        {
            tiempo--;
        }else
        {
            if(tiempo==0)
            {
                sonido.stop();
            }
            if(getX()!=antX || getY()!=antY)
            {
                tiempo=25;
            }
            
        }
        /*if(imagen=="grass_1.png" || imagen=="grass_2.png" || imagen=="grass_3.png" || imagen=="grass_4.png")
        {
            
            sonido=new GreenfootSound("pasto.mp3");
            sonido.play();
        }*/
        antX=getX();
        antY=getY();
    }
    @Override
    public void act()
    {
        // Add your action code here.
        if(super.getvida()>0)
        {
            setcorazon();
            movimiento();
            ocultar();
            poder();
            setImage(myGif.getCurrentImage());
            reproduceSonido();
            if (Greenfoot.isKeyDown("e") && unica==1){
            super.setvida(super.getvida()+1);
            unica=0;
            setcorazon_seteado();
            
            }
        }else
        {
            World mundo = getWorld();
            mundo.removeObject(this);
        }
    }
    public void setcorazon()
    {
        int i,j=0;
        if(crea_contenedores==1)
        {
        World mundo = getWorld();
        for(i=0;i<(super.getvida()/2);i++){
          
            mundo.addObject(corazon.get(i),mundo.getWidth()-15*(i+1)-corazon.get(i).getImage().getWidth()*i,mundo.getHeight()-20);  
          j=i+1;
        }
        if(super.getvida()%2!=0)
        {
            HeartTile medio_corazon = new HeartTile();
            medio_corazon.setImage("Corazon_mitad_rojo.png");
            medio_corazon.getImage().mirrorHorizontally();
            corazon.add(medio_corazon);
              mundo.addObject(corazon.get(j+1),mundo.getWidth()-15*(j+1)-corazon.get(j).getImage().getWidth()*j,mundo.getHeight()-20);  
 
        }
        if(((super.getvida()/2)+super.getvida()%2)<corazon.size()-1)
        {
            for(i=super.getvida()/2+super.getvida()%2+1;i<corazon.size();i++)
            {
                corazon.get(i).setImage("Corazon_negro.png");
            }
        }
        crea_contenedores=0;
    }
    }
    
    public void setcorazon_seteado()
    {
        int i,j=0;
        if(crea_contenedores==1)
        {
        for(i=0;i<super.getvida()/2;i++)
        {
            corazon.get(i).setImage("Corazon_rojo.png");
        }
        if(super.getvida()==1)
        {
            corazon.get(0).setImage("Corazon_mitad_rojo.png");
            //corazon.get(0).turn(180);
        }
        World mundo = getWorld();
        for(i=0;i<(super.getvida()/2);i++){
          corazon.get(i);  
          j=i+1;
        }
        if(super.getvida()%2!=0)
        {
            HeartTile medio_corazon = new HeartTile();
            corazon.get(super.getvida()%2+(super.getvida()/2)-1).setImage("Corazon_mitad_rojo.png");
            corazon.get(super.getvida()%2+(super.getvida()/2)-1).getImage().mirrorHorizontally();
            //corazon.get(super.getvida()%2+(super.getvida()/2)-1).turn(180);
        }
        if(((super.getvida()/2)+super.getvida()%2)<corazon.size())
        {
            for(i=super.getvida()/2+super.getvida()%2;i<corazon.size();i++)
            {
                corazon.get(i).setImage("Corazon_negro.png");
            }
        }
        crea_contenedores=0;
    }
    }
    
    public boolean ocultar(){
        boolean flag = false;
        if(isTouching(TallGrass.class)){
            this.getImage().setTransparency(150);
            flag = true;
        }else
            this.getImage().setTransparency(255);
        return flag;
    }

    @Override
    public void movimiento()
    {
        //int veloz=(int)velocidad;
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("W") && cancelaMovimiento == false){
            dy = -this.velocidadY;
            myGif = gif_espalda;
        }
        if (Greenfoot.isKeyDown("A") && cancelaMovimiento == false){
            dx = -this.velocidadX;
            myGif = gif_izquierda;
        }
        if (Greenfoot.isKeyDown("S") && cancelaMovimiento == false){
            dy = this.velocidadY;
            myGif = gif_enfrente;
        }
        if (Greenfoot.isKeyDown("D") && cancelaMovimiento == false){
            dx = this.velocidadX;
            myGif = gif_derecha;
        }
        setLocation(getX()+dx, getY()+dy);
        if (isTouching(ColliderTile.class))
        {
            setLocation(getX()-dx, getY()-dy);
        }   
    }
    
    public void poder()
    {
        if(isTouching(Enemy.class) || isTouching(Projectile.class))
        {
            GreenfootSound sonido = new GreenfootSound("Golpe.mp3");
            sonido.setVolume(60);
            sonido.play();
            TileWorld world = this.getWorldOfType(TileWorld.class);
            world.reset();
            super.setvida(super.getvida()-1);
            Dificultad.vidaHeroe=super.getvida();
            crea_contenedores=1;
            setcorazon_seteado();
        }
    }

    public void setCancelaMovimiento(boolean band){
        this.cancelaMovimiento = band;
    }
}