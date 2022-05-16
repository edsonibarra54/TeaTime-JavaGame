import greenfoot.*;
//import java.awt.Color;

public class TextBox extends Actor {
     private GreenfootImage img;
     private String image;
     private boolean border = false;
     private boolean flag = false;
     private int fontSize;
     private int tempo;
     private Color foreground;
     private Color background;
     
     public TextBox(boolean f, String s){
         flag = f;
         image = s;
         this.setImage(s);
         tempo = 0;
         act();
     }
     
     public TextBox(String s, int fs /*boolean b, Color fg, Color bg*/) {
         super();
         fontSize = fs;
         img = new GreenfootImage(s, fontSize, null, null);
         setImage(img);
     }
    
     public void act(){
         tempo++;
         if(flag == true){
            if(tempo == 50){
                getImage().setTransparency(0);
            }else if(tempo == 100){
                getImage().setTransparency(255);
                tempo=0;
            }
         }
     }
     
     public void setText(String s) {
         img = new GreenfootImage(s, fontSize, foreground, background);
     }
}
