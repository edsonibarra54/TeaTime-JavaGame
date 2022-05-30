import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)
import java.util.List;
/**
 * Write a description of class TileWorld here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
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
    
    public TileWorld(String tiles[][], int sX, int sY, int m, int n)
    {    
        super(600, 400, 1, true);
        spawnX = sX;
        spawnY = sY;
        animationNumber = n; 
        this.WORLD = tiles;
        createWorldFromTiles(); 
        mode = m;
        setPaintOrder(IngredientTile.class,Heroe_animacion.class,Heroe.class,LineOfSight.class,HeartTile.class,Counter.class,ShadowTile.class,Tree.class,ColliderTile.class,Projectile.class,/*TrapTile.class,*/Ingrediente.class,Projectile.class,Personaje.class,NoColliderTile.class);
        prepare();  
    }
    
    public TileWorld(String tiles[][], int sX, int sY,Counter ingCount, int m)
    {    
        super(600, 400, 1, true);
        spawnX = sX;
        spawnY = sY;
        mode = m;
        this.ingCount = ingCount;
        this.WORLD = tiles;
        createWorldFromTiles(); 
        setPaintOrder(IngredientTile.class,Heroe.class,LineOfSight.class,HeartTile.class,Counter.class,ShadowTile.class,Tree.class,ColliderTile.class,Projectile.class,/*TrapTile.class,*/Ingrediente.class,Projectile.class,Personaje.class,NoColliderTile.class);
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
        setPaintOrder(IngredientTile.class,Heroe.class,Counter.class,HeartTile.class,ShadowTile.class,Heroe.class/*,TrapTile.class*/,Ingrediente.class,Projectile.class,Tree.class,ColliderTile.class);
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
        setPaintOrder(IngredientTile.class,Heroe.class,Counter.class,HeartTile.class,ShadowTile.class,Heroe.class,/*TrapTile.class,*/Ingrediente.class,Projectile.class,Tree.class,ColliderTile.class);
        prepare();
    }
    
    private void createWorldFromTiles() {    
        for( int i=0; i < WORLD.length; i++ ) {      
            for( int j=0; j < SWIDTH/TWIDTH; j++ ) {        
                addActorAtTileLocation(WORLD[i][j], j, i);      
            }    
        }  
    }
    
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
                tile_2 = new TallGrass();
                addObject(tile_2, 12+x*TWIDTH, 12+y*THEIGHT);
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
    
    public Counter getCounter(){
        return this.ingCount;
    }
    
    public int getMode(){
        return this.mode;
    }
    
    public void setMode(int m){
        this.mode = m;
    }
    
    public void reset(){
        this.hero.setLocation(spawnX,spawnY);
        for(Enemy enemy : this.getObjects(Enemy.class)){
            enemy.resetPosition();
        }
    }
    
    private void prepare() { 
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
