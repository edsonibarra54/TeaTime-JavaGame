import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * Representa a los personajes, contiene vida y velocidad 
 */
public abstract class Personaje extends Actor
{
    protected int vida;
    protected int velocidadX,velocidadY;
    protected String imagen;
    
    /**
     * Constructor de la clase personaje
     * @param vida La vida del personaje
     * @param velocidadX La velocidad del personaje en x
     * @param velocidadY La velocidad del personaje en y
     * @param imagen El nombre de la imagen que se le asigna 
     */
    public Personaje(int vida,int velocidadX,int velocidadY,String imagen){
        this.vida = Dificultad.vidaHeroe;
        this.velocidadX = velocidadX;
        this.velocidadY = velocidadY;
        this.imagen = imagen;
        cambiaImagen(this.imagen);
    }
    
    /**
     * return La vida actual del personaje
     */
    public int getvida()
    {
        return vida;
    } 
    
    /**
     * Setea la vida a la variable x
     * @param x el nuevo valor de la vida
     */
    public void setvida(int x)
    {
        this.vida=x;
    }
    
    /**
     * Cada subclase define su propio act
     */
    public abstract void act();   
    
    /**
     * Cambia la imagen dependiendo de su parametro
     * @param imagen El nombre de la nueva imagen
     */
    protected void cambiaImagen(String imagen)
    {
        this.imagen = imagen;
        GifImage nueva = new GifImage(this.imagen);
        setImage(nueva.getCurrentImage());
    }
    /**
     * Cada subclase define su propio movimiento
     */
    public abstract void movimiento();
}
