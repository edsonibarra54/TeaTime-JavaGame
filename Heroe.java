import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * Write a description of class Heroe here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Heroe extends Personaje
{
    private int num_image,cambio=0,tempo=0,crea_contenedores=1,unica=1;
    private ArrayList<HeartTile> corazon = new ArrayList<>();
    private GifImage myGif = new GifImage("principal_enfrente.gif");
    private GifImage gif_enfrente = new GifImage("principal_enfrente.gif");
    private GifImage gif_espalda = new GifImage("principal_espalda.gif");
    private GifImage gif_derecha = new GifImage("principal_derecha.gif");
    private GifImage gif_izquierda = new GifImage("principal_izquierda.gif");
    /**
     * Act - do whatever the Heroe wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    public Heroe(int vida,int velocidad,String nombre_imagen)
    {
        super(vida,velocidad,nombre_imagen);
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
    public void act()
    {
        // Add your action code here.
        if(super.getvida()>0)
        {
            setcorazon();
            movimiento();
            opacidad();
            poder();
            setImage(myGif.getCurrentImage());
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
    public void opacidad(){
        if(isTouching(TallGrass.class)){
            this.getImage().setTransparency(150);
        }else
            this.getImage().setTransparency(255);
    }

    @Override
    public void movimiento()
    {
        int veloz=(int)velocidad;
        int dx = 0, dy = 0;
        if (Greenfoot.isKeyDown("W")){
            dy = -veloz;
            myGif = gif_espalda;
        }
        if (Greenfoot.isKeyDown("A")){
            dx = -veloz;
            myGif = gif_izquierda;
        }
        if (Greenfoot.isKeyDown("S")){
            dy = veloz;
            myGif = gif_enfrente;
        }
        if (Greenfoot.isKeyDown("D")){
            dx = veloz;
            myGif = gif_derecha;
        }
        setLocation(getX()+dx, getY()+dy);
        if (isTouching(ColliderTile.class))
        {
            setLocation(getX()-dx, getY()-dy);
        }   
        /*else
        {
        Heroe copia = new Heroe(vida,(int)velocidad,imagen);
        World w = getWorld();
        w.addObject(copia,getX(),getY());
        copia.setLocation(getX(),getY());
        if(Greenfoot.isKeyDown("left")){
        copia.setLocation(getX()-veloz,getY());
        }
        if(Greenfoot.isKeyDown("right")){
        copia.setLocation(getX()+veloz,getY());
        }
        if(Greenfoot.isKeyDown("up")){
        copia.setLocation(getX(),getY()-veloz);
        }
        if(Greenfoot.isKeyDown("down")){
        copia.setLocation(getX(),getY()+veloz);
        }
        if(copia.colisionando()==0)
        {
        setLocation(copia.getX(),copia.getY());
        }
        w.removeObject(copia);
        }*/
    }
    public void poder()
    {
        if(isTouching(Enemy.class))
        {
             List<Enemy> enemigos =getObjectsInRange(80,Enemy.class);
            for(Enemy enemigo:enemigos)
            {
                enemigo.setEspera(100);
                enemigo.retrocede(getX(),getY());
            }   
            super.setvida(super.getvida()-1);
            crea_contenedores=1;
            setcorazon_seteado();
        }

    }
    public int tocando(){
        if(isTouching(HidingTile.class)){
            return 1;
        }else
            return 0;
    }
}