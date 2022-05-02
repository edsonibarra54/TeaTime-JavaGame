import greenfoot.*;  // (World, Actor, GreenfootImage, Greenfoot and MouseInfo)

/**
 * A Counter class that allows you to display a numerical value on screen.
 * 
 * The Counter is an actor, so you will need to create it, and then add it to
 * the world in Greenfoot.  If you keep a reference to the Counter then you
 * can adjust its value.  Here's an example of a world class that
 * displays a counter with the number of act cycles that have occurred:
 * 
 * <pre>
 * class CountingWorld
 * {
 *     private Counter actCounter;
 *     
 *     public CountingWorld()
 *     {
 *         super(600, 400, 1);
 *         actCounter = new Counter("Act Cycles: ");
 *         addObject(actCounter, 100, 100);
 *     }
 *     
 *     public void act()
 *     {
 *         actCounter.setValue(actCounter.getValue() + 1);
 *     }
 * }
 * </pre>
 * 
 * @author Neil Brown and Michael Kölling 
 * @version 1.0
 */
public class Counter extends Actor
{
    private static final Color transparent = new Color(0,0,0,0);
    private int target;
    //private String prefix;
    private GreenfootImage score0 = new GreenfootImage("ping0.png");
    private GreenfootImage score1 = new GreenfootImage("ping1.png");
    private GreenfootImage score2 = new GreenfootImage("ping2.png");
    private GreenfootImage score3 = new GreenfootImage("ping3.png");
    
    public Counter()
    {
        this(new String());
    }

    /**
     * Create a new counter, initialised to 0.
     */
    public Counter(String prefix)
    {
        target = 0;
        //this.prefix = prefix;
        this.setImage(score0);
    }
    
    /**
     * Animate the display to count up (or down) to the current target value.
     */
    public void act() 
    {
        //this.setImage(new GreenfootImage(prefix+target+"/4",24,Color.BLACK,transparent));
        /*if (value < target) {
            value++;
            updateImage();
        }
        else if (value > target) {
            value--;
            updateImage();
        }*/
    }
    
        
    public void cambiaImagen(){
        switch(this.target){
            case 1:
                this.setImage(score1);
            break;
            case 2:
                this.setImage(score2);
            break;
            case 3:
                this.setImage(score3);
            break;
                
        }
    }

    /**
     * Add a new score to the current counter value.  This will animate
     * the counter over consecutive frames until it reaches the new value.
     */
    public void add()
    {
        target ++;
        cambiaImagen();
    }

    /**
     * Return the current counter value.
     */
    public int getValue()
    {
        return target;
    }




}
