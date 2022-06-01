import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.ArrayList;
import java.util.List;
/**
 * El heroe es el personaje principal de la historia
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
    private GifImage gif_tumbado = new GifImage("principal_tumbado.gif");
    private GreenfootSound sonido = new GreenfootSound("pasto.mp3");
    private String checa;
    private int antX,antY;
    private int tiempo=50;
    private boolean cancelaMovimiento; //Indica si el jugador podra mover al heroe 
    private boolean transicionIniciada;
    private Transicion t;
    
    /**
     * Constructor de Heroe
     * @param vida la vida del heroe
     * @param velocidadX la velocidad en X del heroe
     * @param velocidadY la velocidad en Y del heroe
     * @param nombre_imagen nombre del gif con el que inicia
     */
    public Heroe(int vida,int velocidadX,int velocidadY,String nombre_imagen)
    {
        super(vida,velocidadX,velocidadY,nombre_imagen);
        cancelaMovimiento = true;
        transicionIniciada = false;
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
    
    /**
     *  Metodo que reproduce un sonido de pasto mientras el personaje camine
    */
    public void reproduceSonido()
    {
        String imagen;
        Actor Sonido = getOneIntersectingObject(TileActor.class);
        checa=Sonido.getImage().toString();
        imagen=checa;
        if(sonido.isPlaying()==false && tiempo!=0)
        {
            sonido=new GreenfootSound("pasto.mp3");
            sonido.setVolume(30);
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
        antX=getX();
        antY=getY();
    }
    
    /**
     * Metodo que ejecuta su gif propio, si la vida del heroe es mayor a 1 ejecutara los
     * metodos setCorazon, movimiento, ocultar, poder y reproduceSonido, si la vida es 0 
     * el gif cambiara y se vera la pantalla derrota
     */
    @Override
    public void act()
    {
        setImage(myGif.getCurrentImage());
        if(super.getvida()>0)
        {
            setcorazon();
            movimiento();
            ocultar();
            poder();
            reproduceSonido();
        }else
        {
            if(transicionIniciada == false){
                myGif = gif_tumbado;
                transicionIniciada = true;
                World mundo = getWorld();
                t = new Transicion(2);
                FinJuego d = new FinJuego("Pantalla_derrota.png");
                mundo.addObject(d,300,200);
                mundo.addObject(t,300,200);
            }
        }
    }
    
    /**
     * Establece los corazones especificos en la primer instanciaque le corresponden al personaje segun su vida y le modifica la longitud del total de corazones
       */
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
    
 /**
     * Establece los corazones especificos despues de la primer instanciaque le corresponden al personaje segun su vida y le modifica la longitud del total de corazones
       */ 
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
    
    /**
     * Si el heroe esta dentro de una celda de tipo TallGrass, se regresa verdadero y los 
     * enemigos no pueden seguirlo
     * @return Verdadero si el heroe esta oculto
     */
    public boolean ocultar(){
        boolean flag = false;
        if(isTouching(TallGrass.class)){
            this.getImage().setTransparency(150);
            flag = true;
        }else
            this.getImage().setTransparency(255);
        return flag;
    }
    
    /**
     * Utilizando las teclas WASD cambiamos la velocidad correspondientemente,
     * despues, movemos al heroe esa cantidad de pixeles, si esta chocando con una pared
     * no puede atravesarla
     */
    @Override
    public void movimiento() //Deja mover al jugador con las teclas mientras cancelaMovimiento sea false
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
    
    /**
     * Metodo que reproduce sonido de golpe si somos tocados por un proyectil o
     * un enemigo, tambien se encarga de modificar los corazones y de devolvernos 
     * al inicio de la sala si la vida es mayor a 1
     */
    public void poder()
    {
        if(isTouching(Enemy.class) || isTouching(Projectile.class)){
            GreenfootSound sonido = new GreenfootSound("Golpe.mp3");
            sonido.setVolume(60);
            sonido.play();
            TileWorld world = this.getWorldOfType(TileWorld.class);
            
            if(super.getvida() > 1){
                world.reset();
            }
            
            super.setvida(super.getvida()-1);
            Dificultad.vidaHeroe=super.getvida();
            crea_contenedores=1;
            setcorazon_seteado();
        }
    }

    /**
     * Metodo cambia el parametro cancelaMovimiento, si este este es true el personaje no podra moverse
     */
    public void setCancelaMovimiento(boolean band){ //Este metodo se encarga de indicar si el jugador puede moverse o no
        this.cancelaMovimiento = band;
    }
}