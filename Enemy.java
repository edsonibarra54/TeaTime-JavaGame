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
    private int paso=Greenfoot.getRandomNumber(12),veces=Greenfoot.getRandomNumber(100);
    /**
     * Act - do whatever the Enemy wants to do. This method is called whenever
     * the 'Act' or 'Run' button gets pressed in the environment.
     */
    private ArrayList<GifImage> gifs = new ArrayList();
    private int pos=0,esperaforzado=0,dx=0,dy=0,abs_x,abs_y,paso_y,paso_x,persigue=0,espera=0,tempo=0,radioBusqueda=80,heroe_x,heroe_y;
    public Enemy(String[] gifsarreglo)
    {
        super(1,1,"principal_enfrente.gif");
         GifImage gif=new GifImage(gifsarreglo[0]);
        gifs.add(gif);
        gif=new GifImage(gifsarreglo[1]);
        gifs.add(gif);
        gif=new GifImage(gifsarreglo[2]);
        gifs.add(gif);
        gif=new GifImage(gifsarreglo[3]);
        gifs.add(gif);
        gif=new GifImage(gifsarreglo[4]);
        gifs.add(gif);
        gif=new GifImage(gifsarreglo[5]);
        gifs.add(gif);
        gif=new GifImage(gifsarreglo[6]);
        gifs.add(gif);
        gif=new GifImage(gifsarreglo[7]);
        gifs.add(gif);
    }
    public void act()
    {    
        movimiento();
        setImage(gifs.get(pos).getCurrentImage());
    }
    @Override 
    public void movimiento()
    {
        int veloz=(int)velocidad;
            if (isTouching(ColliderTile.class))
            {
                //abs_x=0;
                //abs_y=0;
                setLocation(getX()-dx, getY());
                if(isTouching(ColliderTile.class))
                {
                    setLocation(getX()+dx, getY()-dy);
                    abs_y=0;
                }else
                {
                    abs_x=0;
                }
            }
        dx=0; 
        dy=0;
        tempo++;
        if(persigue()==0 && persigue==0)
        {
            if(espera==0)
            {
                if(tempo==veces)
                {
                    espera=Greenfoot.getRandomNumber(100)+20;
                    tempo=0;
                    veces=Greenfoot.getRandomNumber(100);
                    paso=Greenfoot.getRandomNumber(12);   
                }
                if(paso==0)
                {
                    dy = veloz;
                    dx = veloz;
                    pos=0;
                }
                if (paso==1 || paso==2){
                    dy = -veloz;
                    pos=1;
                    //myGif = gif_espalda;
                }
                if (paso==3 || paso==4){
                    dx = -veloz;
                    pos=3;
                    //myGif = gif_izquierda;
                }
                if (paso==5 || paso==6){
                    dy = veloz;
                    pos=0;
                    //myGif = gif_enfrente;
                }
                if (paso==7 || paso==8){
                    dx = veloz;
                    pos=2;
                    //myGif = gif_derecha;
                }
                if(paso==9)
                    {
                    dx=-veloz;
                    dy=veloz;
                    pos=0;
                }
                if(paso==10)
                {
                    dx=veloz;
                    dy=-veloz;
                    pos=1;
                }
                if(paso==11)
                {
                    dx=-veloz;
                    dy=-veloz;
                    pos=1;
                }
                setLocation(getX()+dx, getY()+dy);
                if (isTouching(ColliderTile.class))
                {
                    paso=Greenfoot.getRandomNumber(12);
                    setLocation(getX()-dx, getY()-dy);
                }
            }else
            {
                if(tempo==espera)
                {
                    espera=0;
                    tempo=0;
                    paso=Greenfoot.getRandomNumber(12); 
                }
            }
        }else
        {
            tempo=0;
            if(esperaforzado>0)
            {
                esperaforzado--;
            }else
            {
            if(abs_x!=0 || abs_y!=0)
            {
                    if(abs_x!=0 && abs_y!=0)
                    {
                        setLocation(getX()+(paso_x/Math.abs(paso_x)),getY()+(paso_y/Math.abs(paso_y)));
                        evaluaGif(paso_x,paso_y);
                        abs_x--;
                        abs_y--;
                        dx=(int)(paso_x/Math.abs(paso_x));
                        dy=(int)(paso_y/Math.abs(paso_y));
                    }else
                    {
                        if(abs_x!=0)
                        {
                            setLocation(getX()+(paso_x/Math.abs(paso_x)),getY());
                            abs_x--;
                            evaluaGif(paso_x,0);
                            dx=(int)(paso_x/Math.abs(paso_x));
                            //dy=(int)(paso_y/Math.abs(paso_y));
                            //paso_y--;
                        }else
                        {
                            setLocation(getX(),getY()+(paso_y/Math.abs(paso_y)));
                        //paso_x--;
                            evaluaGif(0,paso_y);
                            //dx=(int)(paso_x/Math.abs(paso_x));
                            dy=(int)(paso_y/Math.abs(paso_y));
                            abs_y--;
                        }
                    }
                }
                List<Heroe> heroe =getObjectsInRange(radioBusqueda,Heroe.class); 
                if (isTouching(ColliderTile.class))
                {
                    //abs_x=0;
                    //abs_y=0;
                    setLocation(getX()-dx, getY());
                    if(isTouching(ColliderTile.class))
                    {
                        setLocation(getX()+dx, getY()-dy);
                        abs_y=0;
                    }else
                    {
                        abs_x=0;
                    }
                }
            }
        }
    }
    public void evaluaGif(int x,int y)
    {
        if(x>0 && y>0)
        {
            pos=4;
        }else
        {
            if(x==0 && y<0)
            {
                pos=5;
            }else
            {
                if(x<0 && y==0)
                {
                    pos=7;
                }else
                {
                    if(x==0 && y>0)
                    {
                        pos=4;
                    }else
                    {
                        if(x>0 && y==0)
                        {
                            pos=6;   
                        }else
                        {
                            if(x<0 && y>0)
                            {
                                pos=4;
                            }else
                            {
                                if(x>0 && y<0)
                                {
                                    pos=5;
                                }else
                                {
                                    if(x<0 && y<0)
                                    {
                                        pos=5;
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
    public int persigue()
    {
        List<Heroe> heroe =getObjectsInRange(radioBusqueda,Heroe.class); 
        if(heroe.size()>0 && heroe.get(0).tocando()==0)
        {
            persigue=1;
            heroe_y=heroe.get(0).getY();
            heroe_x=heroe.get(0).getX();
            paso_x=heroe_x-getX();
            paso_y=heroe_y-getY();
            abs_x=Math.abs(paso_x);
            abs_y=Math.abs(paso_y);
            radioBusqueda=180;
        }else
        {
            persigue=0;
            radioBusqueda=80;
        }
        return persigue;
    }
    public void setEspera(int espera)
    {
        esperaforzado=espera;
    }
    public void retrocede(int x,int y)
    {
         int posx,posy;
         posx=getX()-x;
         posy=getY()-y;
        if(posx==0 || posy==0)
        {
            if(posx==0 && posy>0)
            {
                impactandoMuro(0,posy/Math.abs(posy));
            }else
            {
                if(posx>0 && posy==0)
                {
                    impactandoMuro(posx/Math.abs(posx),0);
                }else
                {
                    impactandoMuro(0,0);
                }
            }
        }else
        {
            impactandoMuro(posx/Math.abs(posx),posy/Math.abs(posy));
        }
    }
    public void impactandoMuro(int ejex,int ejey)
    {
        int i;
        for(i=0;i<15 && !isTouching(ColliderTile.class);i++)
        {
            setLocation(getX()+ejex,getY()+ejey);  
        }
        if(isTouching(ColliderTile.class))
        {
            setLocation(getX()-ejex,getY()-ejey);
        }
    }
}
