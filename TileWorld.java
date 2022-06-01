import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;

/**
 * Clase padre de todas las salas
 */

public abstract class TileWorld extends World 
{
    static Actor hero;
    static Actor hero_animation;
    private int mode; 
    private int animationNumber;
    private int difficulty; 
    protected boolean shadow=false;
    private int xOffset = 0;  
    private int SWIDTH = 600;//Ancho de pantalla 
    private int SHEIGHT = 400;//Alto de pantalla
    protected int TWIDTH = 25;//Ancho de tile  
    protected int THEIGHT = 25;//Alto de tile
    private int spawnX;
    private int spawnY;
    PortalTile salaArriba, salaAbajo, salaIzquierda, salaDerecha;
    private  String[][] WORLD;
    private Counter ingCount;
    
    public TileWorld()
    {
        super(600, 400, 1, true);
    }
    
    /**
     * Constructor de TileWorld, instancia un mundo de celdas y además las
     * pinta de acuerdo a la matriz tiles
     * @param tiles La matriz que incluye la informacion con la que TileWorld va a ser dibujado
     * @param sX el spawn en x del heroe dentro del mundo
     * @param sY el spawn en y del heroe dentro del mundo
     * @param m el modo en el que se encuentra el mundo (0 = modo Animacion, 1 = modo Gameplay)
     * @param n la animacion que van a realizar el personaje
     */
    
    public TileWorld(String tiles[][], int sX, int sY, int m, int n)
    {    
        super(600, 400, 1, true);
        spawnX = sX;
        spawnY = sY;
        animationNumber = n; 
        this.WORLD = tiles;
        createWorldFromTiles(); 
        mode = m;
        setPaintOrder(FinJuego.class,Transicion.class,Tree.class,Heroe_animacion.class,Heroe.class,LineOfSight.class,HeartTile.class,Counter.class,IngredientTile.class,ShadowTile.class,Tree.class,ColliderTile.class,Projectile.class,/*TrapTile.class,*/Ingrediente.class,Projectile.class,Personaje.class,NoColliderTile.class);
        prepare();
    }
    
    /**
     * Constructor de TileWorld, instancia un mundo de celdas y además las
     * pinta de acuerdo a la matriz tiles
     * @param tiles La matriz que incluye la informacion con la que TileWorld va a ser dibujado
     * @param sX el spawn en x del heroe dentro del mundo
     * @param sY el spawn en y del heroe dentro del mundo
     * @param ingCount el contador que lleva la informacion de los ingredientes recogidos
     * @param m el modo en el que se encuentra el mundo (0 = modo Animacion, 1 = modo Gameplay)
     */
    
    public TileWorld(String tiles[][], int sX, int sY,Counter ingCount, int m)
    {    
        super(600, 400, 1, true);
        shadow = false;
        spawnX = sX;
        spawnY = sY;
        mode = m;
        this.ingCount = ingCount;
        this.WORLD = tiles;
        createWorldFromTiles();
        //setPaintOrder(Counter.class,Derrota.class,Transicion.class,HeartTile.class,Tree.class,Heroe.class,LineOfSight.class,ShadowTile.class,ColliderTile.class,Projectile.class,/*TrapTile.class,*/Ingrediente.class,Projectile.class,Personaje.class,NoColliderTile.class);
        setPaintOrder(FinJuego.class,Transicion.class,HeartTile.class,Counter.class,IngredientTile.class,ShadowTile.class,Fuente.class,Casa.class,TrapTile.class,Ingrediente.class,Projectile.class,Tree.class,Heroe.class,ColliderTile.class);
        prepare();
    }
    public TileWorld(String tiles[][], int sX, int sY,Counter ingCount, int m,boolean bool)
    {    
        super(600, 400, 1, true);
        shadow = bool;
        spawnX = sX;
        spawnY = sY;
        mode = m;
        this.ingCount = ingCount;
        this.WORLD = tiles;
        createWorldFromTiles();
        //setPaintOrder(Counter.class,Derrota.class,Transicion.class,HeartTile.class,Tree.class,Heroe.class,LineOfSight.class,ShadowTile.class,ColliderTile.class,Projectile.class,/*TrapTile.class,*/Ingrediente.class,Projectile.class,Personaje.class,NoColliderTile.class);
        setPaintOrder(FinJuego.class,Transicion.class,HeartTile.class,Counter.class,IngredientTile.class,ShadowTile.class,Casa.class,TrapTile.class,Ingrediente.class,Projectile.class,Tree.class,Heroe.class,ColliderTile.class);
        prepare();
    }
    public TileWorld(String tiles[][], int sX, int sY,Counter ingCount)
    {    
        super(600, 400, 1, true);
        spawnX = sX;
        spawnY = sY;
        this.ingCount = ingCount;
        this.WORLD = tiles;
        createWorldFromTiles(); 
        setPaintOrder(FinJuego.class,Counter.class,Heroe.class,HeartTile.class,Counter.class,IngredientTile.class,ShadowTile.class,Fuente.class,Casa.class,TrapTile.class,Ingrediente.class,Projectile.class,Tree.class,Heroe.class,ColliderTile.class);
        prepare();
    }
    
    public TileWorld(String tiles[][], int sX, int sY,Counter ingCount,boolean boleano)
    {    
        super(600, 400, 1, true);
        shadow=boleano;
        spawnX = sX;
        spawnY = sY;
        this.ingCount = ingCount;
        this.WORLD = tiles;
        createWorldFromTiles(); 
        setPaintOrder(FinJuego.class,Counter.class,HeartTile.class,Counter.class,IngredientTile.class,ShadowTile.class,Fuente.class,Heroe.class,Casa.class,TrapTile.class,Ingrediente.class,Projectile.class,Tree.class,ColliderTile.class);
        prepare();
    }
    
    /**
     * Metodo que lee la informacion dentro de la matriz y a su vez llama al metodo 
     * que añade la celda a su ubicacion
     */
    
    private void createWorldFromTiles() {    
        for( int i=0; i < WORLD.length; i++ ) {      
            for( int j=0; j < SWIDTH/TWIDTH; j++ ) {        
                addActorAtTileLocation(WORLD[i][j], j, i);      
            }    
        }  
    }
    
    /**
     * Metodo que añade una celda dentro de su posicion, no sin antes asignarle 
     * el tipo de celda e imagen correspondiete
     * @param c la cadena que indica que tipo de celda va a crearse
     * @param x la posicion en x de la celda
     * @param y la posicion en y de la celda
     */
    
    public void addActorAtTileLocation(String c, int x, int y){
        Actor tile = new NoColliderTile(); 
        Actor tile_2 = new Tree();
        //Actor tallo = new MiniShadowTile();
        switch(c) { 
            case "p01":
                tile.setImage("path_1.png");      
                break;
            case "p02":
                tile.setImage("path_2.png");      
                break;
            case "p03":
                tile.setImage("path_3.png");      
                break;
            case "p04":
                tile.setImage("path_4.png");      
                break;
            case "p05":
                tile.setImage("path_5.png");      
                break;
            case "p06":
                tile.setImage("path_6.png");      
                break;
            case "p07":
                tile.setImage("path_7.png");      
                break;
            case "p08":
                tile.setImage("path_8.png");      
                break;
            case "p09":
                tile.setImage("path_9.png");      
                break;
            case "p10":
                tile.setImage("path_10.png");      
                break;
            case "p11":
                tile.setImage("path_11.png");      
                break;
            case "p12":
                tile.setImage("path_12.png");      
                break;
            case "p13":
                tile.setImage("path_13.png");
                ShadowTile sombra_ = new ShadowTile();
                addObject(sombra_, 12+x*TWIDTH, 12+y*THEIGHT);                
                break;
            case "p14":
                tile.setImage("path_13.png");
                //ShadowTile sombra_ = new ShadowTile();
                //addObject(sombra_, 12+x*TWIDTH, 12+y*THEIGHT);                
                break;
            case "p15":
                tile.setImage("path_13.png");
                //ShadowTile sombra_ = new ShadowTile();
                //addObject(sombra_, 12+x*TWIDTH, 12+y*THEIGHT);                
                tile_2 = new Rock();
                addObject(tile_2, 12+x*TWIDTH, 12+y*THEIGHT);
                break;
            case "g01":
                tile.setImage("grass_1.png");      
                break;
            case "g02":
                tile.setImage("grass_2.png");      
                break;
            case "g03":
                tile.setImage("grass_3.png");      
                break;
            case "g04":
                tile.setImage("grass_4.png");      
                break; 
            case "A01":
                tile = new ColliderTile();
                tile.setImage("arbol_1.png");      
                break; 
            case "A02":
                tile = new ColliderTile();
                tile.setImage("arbol_2.png");      
                break; 
            case "A03":
                tile.setImage("grass_4.png");  
                tile_2.setImage("arbol_3.png");
                addObject(tile_2, 12+x*TWIDTH, 12+y*THEIGHT);
                break;
            case "A04":
                tile.setImage("path_4.png");  
                tile_2.setImage("arbol_3.png");
                addObject(tile_2, 12+x*TWIDTH, 12+y*THEIGHT);
                break;
            case "A05":
                tile.setImage("path_11.png");  
                tile_2.setImage("arbol_3.png");
                addObject(tile_2, 12+x*TWIDTH, 12+y*THEIGHT);
                break;
            case "A06":
                tile.setImage("path_10.png");  
                tile_2.setImage("arbol_3.png");
                addObject(tile_2, 12+x*TWIDTH, 12+y*THEIGHT);
                break;
            case "M00":
                tile = new ColliderTile(); 
                tile.setImage("muro_vacio.png");
                break;     
            case "M01":
                tile = new ColliderTile();
                tile.setImage("muro_1.png");      
                break; 
            case "M02":
                tile.setImage("muro_1.png"); 
                tile_2 = new ColliderTile();
                tile_2.setImage("muro_2.png");
                addObject(tile_2, 12+x*TWIDTH, 12+y*THEIGHT);
                break; 
            case "M03":
                tile.setImage("path_4.png"); 
                tile_2 = new ColliderTile();
                tile_2.setImage("muro_2.png"); 
                addObject(tile_2, 12+x*TWIDTH, 12+y*THEIGHT);
                break; 
            case "M04":
                tile = new ColliderTile();
                tile.setImage("muro_1.png"); 
                tile_2.setImage("arbol_3.png"); 
                addObject(tile_2, 12+x*TWIDTH, 12+y*THEIGHT);
                break;
            case "M05":
                tile = new ColliderTile();
                tile.setImage("muro_1.png"); 
                tile_2.setImage("arbol_3.png"); 
                addObject(tile_2, 12+x*TWIDTH, 12+y*THEIGHT);
                ShadowTile _sombra = new ShadowTile();
                addObject(_sombra, 12+x*TWIDTH, 12+y*THEIGHT);
                break; 
            case "M06":
                tile = new ColliderTile();
                tile.setImage("grass_4.png"); 
                break; 
            case "M07":
                tile = new ColliderTile();
                tile.setImage("muro_3.png"); 
                break;
            case "G01" :
                tile = new TallGrass();
                tile.setImage("tall_grass.png");
                break;
            case "G02":
                tile = new TallGrass();
                
                tile.setImage("tall_grass.png");                
                tile.getImage().scale(35,25);
                break;
            case "J00" :
                tile.setImage("grass_4.png");
                tile_2 = new Rock();
                addObject(tile_2, 12+x*TWIDTH, 12+y*THEIGHT);
                break;
            case "J01" :
                tile.setImage("grass_4.png");
                tile_2 = new ArrowDispenserTile(1);
                addObject(tile_2, 12+x*TWIDTH, 12+y*THEIGHT);
                break;
            case "J02" :
                tile.setImage("grass_4.png");
                tile_2 = new ArrowDispenserTile(4);
                tile_2.getImage().setTransparency(0);
                addObject(tile_2, 12+x*TWIDTH, 12+y*THEIGHT);
                ShadowTile _sombra_ = new ShadowTile();
                addObject(_sombra_, 12+x*TWIDTH, 12+y*THEIGHT);
                break;
            case "J03" :
                tile.setImage("grass_4.png");
                tile_2 = new ArrowDispenserTile(3);
                tile_2.getImage().setTransparency(0);
                addObject(tile_2, 12+x*TWIDTH, 12+y*THEIGHT);
                ShadowTile _sombra__ = new ShadowTile();
                addObject(_sombra__, 12+x*TWIDTH, 12+y*THEIGHT);
                break;
                default : tile = new TallGrass();                
            }    
            if(shadow==true)
            {
                ShadowTile sombra = new ShadowTile();
                addObject(sombra, 12+x*TWIDTH, 12+y*THEIGHT);
            }
            if( tile != null)  
                addObject(tile, 12+x*TWIDTH, 12+y*THEIGHT);  
                //addObject(tallo,12+x*TWIDTH, 12+y*THEIGHT);
    }
    
    /**
     * Metodo que regresa el contador del mundo
     */
    public Counter getCounter(){
        return this.ingCount;
    }
    
    /**
     * Metodo que regresa el modo en el que se encuentra el mapa
     */
    public int getMode(){
        return this.mode;
    }
    
    /**
     * Metodo para cambiar el modo en el que se encuentra el mapa
     * @param m modo al que se quiere cambiar
     */
    
    public void setMode(int m){
        this.mode = m;
    }
    
    
    /**
     * Metodo que resetea el mundo, regresando al heroe y los enemigos a sus correspondientes spawns
     */
    public void reset(){
        this.hero.setLocation(spawnX,spawnY);
        for(Enemy enemy : this.getObjects(Enemy.class)){
            enemy.resetPosition();
        }
    }
    
    /**
     * Prepara el mundo, haciendo que la musica suene y que el heroe se intancie y añada al mundo
     * Ademas, llama al metodo abstracto prepareIndividual que permite modificar cuantos enemigos
     * hay por sala de manera individual
     */
    private void prepare() { 
        if(JukeBox.isPlaying() == false){
            JukeBoxEnemy.stop();
            JukeBox.play();
        }
        if(mode != 1){
            hero = new Heroe(Dificultad.vidaHeroe,2,2,"principal_enfrente.gif");
            addObject(hero,spawnX,spawnY); 
            ingCount.addToWorld(this); 
        }
        else{ 
            hero_animation = new Heroe_animacion(Dificultad.vidaHeroe,1,1,"principal_enfrente.gif",animationNumber);
            addObject(hero_animation,spawnX,spawnY);
        }
        prepareIndividual();
    }
    
    public abstract void prepareIndividual();
        
    
}
