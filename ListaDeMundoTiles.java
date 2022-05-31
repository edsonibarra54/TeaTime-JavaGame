/**
 * Write a description of class ListaDeMundoTiles here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class ListaDeMundoTiles  
{
    // instance variables - replace the example below with your own
    private int x;
    public static boolean DesactivaLamusicaActual=false;
    
    private static final String Tiles0[][] = {  {"A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02"},    
                                                {"A02","A02","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","g04","M00","M00","M00","M00","g04","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","g04","M00","M00","M00","M00","g04","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","g04","M00","M00","M00","M00","g04","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g03","g04","g04","g04","M00","M00","M00","M00","g04","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","g04","M00","M00","M00","M00","g04","g04","g04","g03","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","g04","M00","M00","M00","M00","g04","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","g04","g04","p05","p07","g04","g04","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","g04","g04","p01","p02","g03","g04","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g02","g04","g04","g04","g04","p01","p02","g04","g04","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","g04","g04","p01","p02","g04","g04","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","g04","g04","p01","p02","g04","g04","g04","g04","g04","g04","g04","g04","g01","A02","A02"},    
                                                {"A02","A02","A03","A03","A03","A03","A03","A03","A03","A03","A03","p01","p02","A03","A03","A03","A03","A03","A03","A03","A03","A03","A02","A02"},    
                                                {"A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","p01","p02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02"},    
                                                {"A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","p01","p02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02"}};
    
    private static final String Tiles1[][] = {  {"A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02"},    
                                                {"A02","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A02"},    
                                                {"A02","g04","g04","G01","G01","g04","g04","g04","g04","G01","G01","g04","g04","G01","G01","g04","g04","g04","g04","G01","G01","g01","g04","A02"},    
                                                {"A02","g01","g04","p05","p03","p03","p03","p03","p03","p03","p03","p03","p03","p03","p03","p03","p03","p03","p03","p03","p07","g04","g04","A02"},    
                                                {"A01","g04","g04","p01","p06","p04","p04","p04","p04","p04","p04","p04","p04","p04","p08","p06","p04","p04","p04","p08","p02","g04","g02","A02"},    
                                                {"p03","p03","p03","p09","p02","M03","M03","M03","M03","M03","M03","M03","M03","M03","p01","p02","M03","M03","M03","p01","p02","g04","g01","A02"},    
                                                {"A04","p04","p04","p04","p10","M02","M02","M02","M02","M02","M02","M02","M02","M02","p01","p02","M02","M02","M02","p01","p02","g04","g04","A01"},    
                                                {"A02","M02","M02","M02","M02","M02","M02","M02","M02","M02","M02","M02","M02","M02","p01","p02","M02","M02","M02","p01","p12","p03","p03","p03"},    
                                                {"A02","M01","M01","M01","M01","M01","M01","M01","M01","M02","M02","M02","M02","M02","p01","p02","M02","M02","M02","p01","p06","p04","p04","A04"},    
                                                {"A02","g04","g04","g04","g04","p03","p03","p03","p07","M02","M02","M02","M02","M02","p01","p02","M02","M02","M02","p01","p02","g04","g03","A02"},    
                                                {"A02","g04","g04","g04","g04","p04","p04","p08","p02","M02","M02","M02","M02","M02","p01","p02","M02","M02","M02","p01","p02","g04","g01","A02"},    
                                                {"A02","g02","g04","g04","g04","M03","M03","p01","p02","M01","M01","M01","M01","M01","p01","p02","M01","M02","M02","p01","p02","g04","g04","A02"},    
                                                {"A02","g04","g01","g04","g04","M02","M02","p01","p12","p03","p03","p03","p03","p03","p09","p12","p03","M02","M02","p11","p10","g01","g04","A02"},    
                                                {"A02","A03","A03","A03","A03","M04","M04","A04","A04","A04","A04","A04","A04","A04","A04","A04","A04","M04","M04","A03","A03","A03","A03","A02"},    
                                                {"A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02"},    
                                                {"A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01"}};
   
    private static final String Tiles2[][] = {  {"A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01"},    
                                                {"A02","g04","g02","g04","g04","g04","g04","g02","g04","g04","g04","g04","g01","g03","g04","g04","g04","g03","g02","g04","g04","g04","g04","A02"},    
                                                {"A02","g04","g04","G01","G01","G01","G01","G01","G01","G01","G01","G01","G01","G01","G01","G01","G01","G01","G01","G01","G01","g01","g04","A02"},    
                                                {"A02","g01","g04","p05","p03","p03","p03","p03","p03","p03","p03","p03","p03","p03","p03","p03","p03","p03","p03","p03","p07","g04","g04","A02"},    
                                                {"A01","g04","g04","p01","p06","p04","p04","p04","p04","p04","p04","p04","p04","p04","p04","p04","p04","p04","p04","p08","p02","g04","g02","A02"},    
                                                {"p03","p03","p03","p09","p02","g04","g03","g04","g04","g04","g02","g04","g04","g03","g04","g03","g04","g04","g04","p01","p02","g04","g01","A02"},    
                                                {"A04","p04","p04","p08","p02","g04","g04","M03","M03","M03","M03","M03","M03","M03","M03","M03","M03","g04","g04","p01","p02","g04","g04","A01"},    
                                                {"A02","g04","g01","p01","p02","g03","g04","M02","M02","M01","M01","M01","M01","M01","M01","M02","M02","g04","g04","p01","p02","g04","g04","p03"},    
                                                {"A02","g04","g04","p01","p02","G01","G01","M02","M02","G01","G01","G01","G01","G01","G01","M02","M02","g01","g04","p01","p02","g01","g04","A03"},    
                                                {"A02","g04","g04","p01","p02","G01","G01","M02","M02","G01","G01","G01","G01","G01","G01","M02","M02","g04","g04","p01","p02","g01","g04","A02"},    
                                                {"A02","g04","g04","p01","p02","G01","G01","M01","M01","G01","G01","p01","p02","G01","G01","M02","M02","g04","g02","p01","p02","g04","g01","A02"},    
                                                {"A02","g02","g04","p01","p12","G01","G01","G01","G01","G01","G01","p01","p02","G01","G01","M01","M01","g04","g04","p01","p02","g04","g04","A02"},    
                                                {"A02","g04","g02","p11","p04","G01","G01","G01","G01","G01","G01","p01","p02","G01","G01","g04","g04","g03","g04","p01","p02","g01","g04","A02"},    
                                                {"A02","g03","g04","g04","g04","g04","g04","M02","M02","g04","g04","p01","p12","p03","p03","p03","p03","p03","p03","p09","p02","g01","g04","A02"},    
                                                {"A02","A03","A03","A03","A03","A03","A03","M04","M04","A03","A03","A05","A04","A04","A04","A04","A04","A04","A04","A04","A06","A03","A03","A02"},    
                                                {"A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01"}};
                                                
    private static final String Tiles3[][] = {  {"A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A01","A01","A01","A02"},    
                                                {"A02","A02","A02","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","g04","g01","g01","A01"},    
                                                {"A02","A02","A01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g02","A02"},    
                                                {"A02","A01","g04","g02","g04","g04","g03","g03","g02","G02","g04","g01","g03","g02","g02","g02","g04","g03","g03","g03","g02","g01","g02","A02"},    
                                                {"A01","g04","g04","g01","A03","J00","J00","J00","J00","A03","g04","g04","g04","g04","G02","G02","G02","G02","G02","G02","G02","G02","G02","A02"},    
                                                {"p03","g03","g03","A03","A01","g04","g03","g04","g01","A02","g04","g02","g04","g04","G02","G02","G02","G02","G02","G02","G02","G02","G02","A02"},    
                                                {"A04","g04","g04","A02","g04","g04","g04","g04","g02","A01","g03","g04","g03","g04","G02","G02","p05","p03","p03","p03","p07","G02","G02","A01"},    
                                                {"A02","g04","g01","A01","g04","g03","g04","g01","g02","g01","g01","g03","g04","g04","G02","G02","p01","p06","p09","p08","p02","G02","G02","p03"},    
                                                {"A02","g04","g04","M02","M01","M01","p12","p12","M01","M01","M02","A03","A03","g04","G02","G02","p01","p12","p08","p08","p02","G02","G02","A04"},    
                                                {"A02","g01","g02","M02","p12","p12","p12","p12","p12","p12","M02","A02","A02","g03","G02","G02","p01","p12","p12","p09","p02","G02","G02","A02"},    
                                                {"A02","g04","g04","M02","p12","p12","p12","p12","p12","p12","M02","A01","A01","g04","G02","G02","p11","p04","p04","p04","p10","G02","G02","A02"},    
                                                {"A02","g02","g04","M02","p12","p12","p12","p12","p12","p12","M02","g04","g04","g03","G02","G02","G02","G02","G02","G02","G02","G02","G02","A02"},    
                                                {"A02","A03","g01","M02","p12","p12","p12","p12","p12","p12","M02","g01","g04","g02","G02","G02","G02","G02","G02","G02","G02","G02","G02","A02"},    
                                                {"A02","A02","A03","M02","p12","p12","p12","p12","p12","p12","M02","g04","g02","g01","g04","g04","g04","g04","g03","g04","g04","g02","g04","A02"},    
                                                {"A02","A02","A02","M02","p12","p12","p12","p12","p12","p12","M02","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A02"},    
                                                {"A01","A01","A01","M04","M04","M04","M04","M04","M04","M04","M04","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01"}};
                                                
    private static final String Tiles4[][] = {  {"M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01"},    
                                                {"J01","g02","g02","g01","g01","g01","g01","g01","g01","g01","g01","g01","g02","p12","p12","p12","p12","p12","p12","p12","M02","p12","p12","M01"},    
                                                {"J01","g02","g02","g01","g01","g01","g01","g01","g01","g01","g01","g01","g02","p12","p12","p12","p12","p12","p12","p12","M02","p12","p12","M02"},    
                                                {"M01","g01","M01","M02","M02","M02","M02","M02","M02","M02","M02","M02","M02","M02","M02","M02","M02","M02","p12","p12","M02","p12","p12","M02"},    
                                                {"M01","g04","M02","p12","J00","J00","J00","J00","J00","J00","p12","M02","p12","p12","M02","p12","p12","p12","p12","p12","M02","p12","p12","M02"},    
                                                {"M01","g03","M01","p12","M01","M04","M01","M01","M01","M02","M01","M02","p12","p12","M02","p12","p12","p12","p12","p12","M02","p12","p12","M02"},    
                                                {"M01","g04","M01","p12","p12","p12","p12","p12","p12","p12","p12","M02","p12","p12","M02","p12","p12","M02","p12","p12","M02","p12","p12","p03"},    
                                                {"M01","g04","M01","M01","M02","M01","M01","M01","M02","M01","p12","M02","p12","p12","p12","p12","p12","M02","p12","p12","M02","p12","p12","p03"},    
                                                {"M01","g04","M04","p12","p12","p12","p12","p12","p12","p12","p12","M02","p12","p12","p12","p12","p12","M02","p12","p12","M02","p12","p12","p03"},    
                                                {"M01","g01","M02","p12","M01","M01","M01","M01","M02","M02","M02","M02","p12","p12","M02","p12","p12","M02","p12","p12","M02","p12","p12","M02"},    
                                                {"M01","g04","M02","p12","p12","p12","p12","p12","M02","p12","p12","p12","p12","p12","M02","p12","p12","M02","p12","p12","M02","p12","p12","M02"},    
                                                {"M01","g04","M02","M02","M02","M02","p12","p12","M02","p12","p12","p12","p12","p12","M02","p12","p12","M02","p12","p12","M02","p12","p12","M02"},    
                                                {"M01","g04","g02","g01","g02","M02","p12","p12","M02","p12","p12","M02","M02","M02","M02","p12","p12","M02","M02","M02","M02","p12","p12","M02"},    
                                                {"M01","g04","g01","p12","g01","M02","p12","p12","p12","p12","p12","M02","p12","p12","p12","p12","p12","p12","p12","p12","p12","p12","p12","M02"},    
                                                {"M01","g04","g02","g01","g02","M02","p12","p12","p12","p12","p12","M02","p12","p12","p12","p12","p12","p12","p12","p12","p12","p12","p12","M02"},    
                                                {"M01","M04","M04","M04","M04","M04","M04","M04","M04","M04","M04","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01"}};
                                                
    private static final String Tiles5[][] = {  {"A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","g04","g04","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02"},    
                                                {"A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","g04","g04","A02","p12","A02","A02","A02","A02","A02","A02","A02","A02","A02"},    
                                                {"A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","g04","g04","A02","p12","p12","p12","p12","p12","p12","M02","p12","A02","A02"},    
                                                {"A02","A02","M01","M02","M02","M02","M02","M02","M02","p12","A02","g04","g04","A02","M02","M02","M02","M02","p12","p12","M02","p12","A02","A02"},    
                                                {"A02","g04","M02","p12","p12","p12","p12","J00","J00","p12","A02","g04","g04","A02","g02","p12","p12","p12","p12","p12","M02","p12","A02","A02"},    
                                                {"A02","g03","M01","p12","p12","p12","p12","M01","M01","p12","A02","g04","g04","A02","g02","g02","g02","g02","p12","g02","g02","p12","g02","A02"},    
                                                {"A02","M00","M00","M00","M00","M00","M00","M00","M00","M00","A01","g04","g04","A01","M00","M00","M00","M00","M00","M00","M00","M00","M00","A02"},    
                                                {"A02","g01","g01","g01","g01","g01","g01","g01","g02","g01","g01","g04","g04","g01","g02","g02","g02","g02","g01","g02","g02","g02","g02","A02"},    
                                                {"A02","A03","A03","A03","g01","g01","g01","g01","g02","g03","g03","g04","g04","g01","g02","g02","g02","g02","g02","g02","A03","A03","A03","A02"},    
                                                {"A02","A01","A01","A02","g01","g01","g01","g01","g02","g03","g03","g04","g04","g03","g02","g02","g02","g02","g02","g02","A02","A01","A01","A01"},    
                                                {"g03","g03","g02","A02","g01","g01","g01","g01","g01","g01","g01","g04","g04","g01","g01","g01","g01","g01","g01","g01","A02","g03","g02","g03"},    
                                                {"A03","g02","g03","A02","A03","A03","A03","A03","A03","A03","A03","g02","g02","A03","A03","A03","A03","A03","A03","A03","A02","g02","g03","A03"},    
                                                {"A02","g01","g01","A01","A01","A01","A01","A01","A01","A01","A01","g02","g02","A01","A01","A01","A01","A01","A01","A01","A01","g01","g01","A02"},    
                                                {"A02","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","A02"},    
                                                {"A02","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A02"},
                                                {"A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01"}};

    private static final String Tiles6[][] ={    {"M02","M02","M02","M02","M02","M02","A01","A01","A01","A01","A01","g04","g04","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01"},    
                                                {"M01","M01","M01","M01","M01","p13","p07","g04","g03","g01","g01","g04","g04","g04","g04","g04","g04","g04","g04","g04","g02","g02","g02","A02"},    
                                                {"M01","M01","M01","M01","p13","p13","p02","g04","g02","g01","g01","g01","g01","g01","g01","g04","g02","A03","A03","g01","g03","g03","g03","A02"},    
                                                {"M01","M01","M01","p13","p13","p13","p02","g04","g03","g01","g01","g01","g01","A03","A03","g02","J00","A02","A02","g01","g01","g01","g01","A02"},    
                                                {"M01","M01","M01","p13","p13","p14","p02","g04","g02","A03","A03","g01","g01","A02","A02","g02","g02","A01","A01","g02","g01","A03","A03","A02"},    
                                                {"M01","M01","J03","p13","p13","p14","p02","g04","g03","A02","A02","g01","g01","A01","A01","g02","g02","g04","g04","g02","g01","A02","A02","A02"},    
                                                {"M01","p13","p13","p13","p14","p14","p02","g04","g02","A01","A01","g01","g01","g01","g01","g01","g02","g01","g01","g01","g01","A01","A01","A02"},    
                                                {"p13","p13","p13","p13","p14","p14","p02","g04","g03","g01","g01","g04","g01","g01","g01","g01","g02","A03","A03","g02","g01","g01","g01","A02"},    
                                                {"p13","p13","p13","p13","p14","p14","p02","g04","g02","g03","g02","g04","g01","A03","A03","g01","g02","A02","A02","g02","g03","g03","g03","A02"},    
                                                {"M01","p13","p13","p13","p14","p14","p02","g04","g03","g01","g01","g01","g01","A02","A02","g01","g02","A01","A01","g02","g02","A03","A03","A01"},    
                                                {"M01","M01","p13","p13","p13","p14","p02","g04","g02","A03","A03","g01","g01","A01","A01","g01","g01","g01","J00","g01","g01","A02","A02","g03"},    
                                                {"M01","M01","J02","p13","p13","p14","p02","g04","g02","A02","A02","g01","g02","g03","g03","g03","g02","A03","A03","g03","g02","A01","A01","g02"},    
                                                {"M01","M01","M01","p13","p13","p13","p02","g04","g02","A01","A01","g01","g02","g01","g01","g01","g01","A01","A01","g01","g01","g01","g01","A03"},    
                                                {"M01","M01","M01","M01","p13","p13","p02","g04","g03","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","g01","A02"},    
                                                {"M01","M01","M01","M01","M01","p13","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A03","A02"},    
                                                {"M01","M01","M01","M01","M01","M01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01"}};
                                                
    private static final String Tiles10[][] = { {"M07","M07","M07","M07","M07","M07","M07","M07","M07","M07","M07","M07","M07","M07","M07","M07","M07","M07","M07","M07","M07","M07","M07","M07"},    
                                                {"M04","M04","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M04","M04"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","g04","g04","p01","p02","g04","g04","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","g04","g04","p01","p02","g04","g04","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","g04","g04","p01","p02","g04","g04","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g03","g04","g04","p05","p03","p09","p12","p03","p07","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","p01","p06","p04","p04","p08","p02","g04","g04","g03","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","p01","p02","M06","M06","p01","p02","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","p01","p02","M06","M06","p01","p02","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","p01","p12","p03","p03","p09","p02","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g02","g04","g04","p11","p04","p08","p06","p04","p10","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","g04","g04","p01","p02","g04","g04","g04","g04","g04","g04","g04","g04","g04","A02","A02"},    
                                                {"A02","A02","g04","g04","g04","g04","g04","g04","g04","g04","g04","p01","p02","g04","g04","g04","g04","g04","g04","g04","g04","g01","A02","A02"},    
                                                {"A02","A02","A03","A03","A03","A03","A03","A03","A03","A03","A03","p01","p02","A03","A03","A03","A03","A03","A03","A03","A03","A03","A02","A02"},    
                                                {"A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","p01","p02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02"},    
                                                {"A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","p01","p02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02"}};
                                                
    private static final String Tiles11[][] = { {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"},
                                                {"M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00","M00"}};
 
    public static final String Tiles7[][] ={  {"M04","M01","M01","M01","J03","M02","J03","M02","J03","M02","J03","M02","J03","M02","J03","M02","J03","M02","J03","M02","J03","M04","M04","M02"},    
                                                {"A02","g03","g03","g03","p01","p15","p14","p15","p14","p14","p14","p15","p14","p15","p14","p14","p14","p15","p14","p15","p14","A02","A02","M02"},    
                                                {"A02","g04","g04","g04","p01","p15","p14","p14","p14","p14","p14","p15","p14","p14","p14","p15","p14","p15","p14","p14","p14","A02","A02","M02"},    
                                                {"A02","g04","g01","g04","p01","p15","p14","p15","p14","p15","p14","p15","p14","p14","p14","p14","p14","p14","p14","p14","p14","A02","A02","M02"},    
                                                {"A02","g04","g04","g04","p01","p15","p14","p14","p14","p15","p14","p14","p14","p14","p14","p14","p14","p14","p14","p15","p14","A02","A02","M02"},    
                                                {"A02","g04","g02","g04","p01","p14","p14","p15","p14","p15","p14","p14","p14","p14","p14","p14","p14","p14","p14","p14","p14","A01","A01","M02"},    
                                                {"A02","g04","g04","g04","p01","p14","p14","p14","p14","p15","p14","p14","p14","p14","p14","p14","p14","p14","p14","p14","p14","g03","g03","M02"},    
                                                {"A01","g04","g03","g04","p01","p14","p14","p15","p14","p14","p14","p14","p14","p15","p14","p15","p14","p14","p14","p15","p14","g01","g01","M02"},    
                                                {"g04","g04","g04","g04","p01","p14","p14","p14","p14","p14","p14","p14","p14","p15","p14","p15","p14","p14","p14","p15","p14","g03","g03","M02"},    
                                                {"A03","g04","g03","g04","p01","p14","p14","p15","p14","p14","p14","p15","p14","p14","p14","p14","p14","p14","p14","p14","p14","A03","A03","M02"},    
                                                {"A02","g04","g04","g04","p01","p14","p14","p14","p14","p14","p14","p15","p14","p14","p14","p14","p14","p14","p14","p14","p14","A02","A02","M02"},    
                                                {"A02","g04","g02","g04","p01","p14","p14","p15","p14","p15","p14","p15","p14","p14","p14","p14","p14","p14","p14","p15","p14","A02","A02","M02"},    
                                                {"A02","g04","g04","g04","p01","p14","p14","p14","p14","p15","p14","p15","p14","p14","p14","p14","p14","p14","p14","p14","p14","A02","A02","M02"},    
                                                {"A02","g04","g01","g04","p01","p14","p14","p15","p14","p15","p14","p14","p14","p14","p14","p15","p14","p15","p14","p14","p14","A02","A02","M02"},    
                                                {"A01","g04","g04","g04","p01","p14","p14","p14","p14","p15","p14","p14","p14","p15","p14","p14","p14","p15","p14","p15","p14","A01","A01","M02"},    
                                                {"M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01","M01"}};
                                                
    public static final String Tiles8[][] ={  {"A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","g04","g04","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02"},    
                                                {"A02","A02","A02","A02","A02","A01","A01","A01","A01","A01","A01","g03","g04","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A02"},    
                                                {"A02","A02","A02","A02","A01","g02","g04","g04","g02","g01","g01","g01","g01","g01","g01","g04","g02","A03","A03","g01","g03","g03","g03","A02"},    
                                                {"A02","A02","A02","A01","g03","g03","g01","g04","g03","g01","g01","A03","g01","A03","A03","g02","J00","A02","A02","g01","g01","g01","g01","A02"},    
                                                {"A02","A01","A01","g03","g03","g02","g02","g04","G01","G01","G01","A02","g01","A02","A02","g02","g02","A01","A01","g02","g01","A03","A03","A02"},    
                                                {"A02","g01","g01","A03","g02","g03","g03","A03","G01","G01","G01","A01","g01","A01","A01","g02","g02","g04","g04","g02","g01","A02","A02","A02"},    
                                                {"A01","g01","g01","A02","G01","G01","G01","A02","g02","g01","g01","g01","g01","G01","G01","g01","g02","g01","g01","g01","g01","A01","A01","A01"},    
                                                {"g04","g01","g01","A01","G01","G01","G01","A02","g03","g01","g01","g04","g01","G01","G01","g01","g02","A03","A03","g02","g01","g01","g01","g04"},    
                                                {"g04","g01","g01","g01","g01","A03","g03","A02","g02","g03","g02","g04","g01","A03","A03","g01","g02","A02","A02","g02","g03","g03","g03","g04"},    
                                                {"A03","g01","g01","g01","g01","A02","g01","A01","g03","g01","g01","g01","g01","A02","A02","g01","g02","A01","A01","g02","g02","A03","A03","A03"},    
                                                {"A02","A03","A03","A03","g01","A01","g03","g02","g02","g03","g03","g01","A03","A01","A01","g01","g01","g01","J00","g01","g01","A02","A02","A02"},    
                                                {"A02","A02","A02","A02","A03","g02","g01","A03","g02","G01","G01","G01","A02","g03","g03","g03","g02","A03","A03","g03","g02","A01","A01","A02"},    
                                                {"A02","A02","A02","A02","A02","g03","g02","A02","g02","G01","G01","G01","A01","A03","A03","g01","g01","A01","A01","g01","A03","g01","A03","A02"},    
                                                {"A02","A02","A02","A02","A02","g03","g04","A01","g03","g01","g01","g01","g01","A02","A02","A03","g01","g01","g01","A03","A02","A03","A02","A02"},    
                                                {"A02","A02","A02","A02","A02","A03","A03","A03","A03","A03","A03","A03","A03","A02","A02","A02","A03","A03","A03","A02","A02","A02","A02","A02"},    
                                                {"A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01"}};   
    
    public static final String Tiles9[][] ={  {"A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","g04","g04","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02","A02"},    
                                                {"A02","A02","A02","A02","A02","A01","A01","A01","A01","A01","A01","g03","g04","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A02"},    
                                                {"A02","A02","A02","A02","A01","g02","g04","g04","g02","g01","g01","g01","g01","g01","g01","g04","g02","A03","A03","g01","g03","g03","g03","A02"},    
                                                {"A02","A02","A02","A01","g03","g03","g01","g04","g03","g01","g01","A03","g01","A03","A03","g02","J00","A02","A02","g01","g01","g01","g01","A02"},    
                                                {"A02","A01","A01","g03","g03","g02","M01","M01","M01","M01","M01","M01","M01","M01","M01","g02","g02","A01","A01","g02","g01","A03","A03","A02"},    
                                                {"A02","g01","g01","A03","g02","g03","M01","g01","g01","g01","g01","g01","g01","g01","M01","g02","g02","g04","g04","g02","g01","A02","A02","A02"},    
                                                {"A01","g01","g01","A02","G01","G01","M01","g01","g02","g01","g01","g01","g01","g01","M01","g01","g02","g01","g01","g01","g01","A01","A01","A02"},    
                                                {"g04","g01","g01","A01","G01","G01","M01","g01","g03","g01","g01","g04","g01","g01","M01","g01","g02","A03","A03","g02","g01","g01","g01","A02"},    
                                                {"g04","g01","g01","g01","g01","A03","M01","g01","g02","g03","g02","g04","g01","g01","M01","g01","g02","A02","A02","g02","g03","g03","g03","A02"},    
                                                {"A03","g01","g01","g01","g01","A02","M01","g01","g03","g01","g01","g01","g01","g01","M01","g01","g02","A01","A01","g02","g02","A03","A03","A02"},    
                                                {"A02","A03","A03","A03","g01","A01","M01","g01","g02","g03","g03","g03","g03","g01","M01","g01","g01","g01","J00","g01","g01","A02","A02","A02"},    
                                                {"A02","A02","A02","A02","A03","g02","M01","M01","M01","M01","g04","g04","M01","M01","M01","g03","g02","A03","A03","g03","g02","A01","A01","A02"},    
                                                {"A02","A02","A02","A02","A02","g03","g02","A02","g02","G01","G01","G01","A01","A03","A03","g01","g01","A01","A01","g01","A03","g01","A03","A02"},    
                                                {"A02","A02","A02","A02","A02","g03","g04","A01","g03","g01","g01","g01","g01","A02","A02","A03","g01","g01","g01","A03","A02","A03","A02","A02"},    
                                                {"A02","A02","A02","A02","A02","A03","A03","A03","A03","A03","A03","A03","A03","A02","A02","A02","A03","A03","A03","A02","A02","A02","A02","A02"},    
                                                {"A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01","A01"}};   
  
                                                /**
     * Constructor for objects of class ListaDeMundoTiles
     */
    public ListaDeMundoTiles()
    {
    }

    public static String[][] TilesMundo0()
    {
        return Tiles0;    
    }
    
    public static String[][] TilesMundo1()
    {
        return Tiles1;
    }
    
    public static String[][] TilesMundo2()
    {
        return Tiles2;
    }
    
    public static String[][] TilesMundo3()
    {
        return Tiles3;
    }
    
    public static String[][] TilesMundo4()
    {
        return Tiles4;
    }
    
    public static String[][] TilesMundo5()
    {
        return Tiles5;
    }

    public static String[][] TilesMundo6()
    {
        return Tiles6;
    }
    
    public static String[][] TilesMundo10()
    {
        return Tiles10;
    }
    
    public static String[][] TilesMundo11()
    {
        return Tiles11;
    }
    
    public static String[][] TilesMundo7()
    {
        return Tiles7;
    }
    
    public static String[][] TilesMundo8()
    {
        return Tiles8;
    }
}
