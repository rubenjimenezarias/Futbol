import java.util.Random;
/**
 * Write a description of class Capitan here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Capitan extends JugadorCampo
{
    // instance variables - replace the example below with your own
    private int liderazgo;

    /**
     * Constructor for objects of class Capitan
     */
    public Capitan(String nombre)
    {
        // initialise instance variables
        super(nombre);
        Random aleatorio = new Random();
        liderazgo = aleatorio.nextInt(6);
        
    }

    /**
     *
     */
    public int getLiderazgo()
    {
        return liderazgo;
    }
    
    /**
     * 
     */
    public double valoracion(){
        return super.valoracion()+liderazgo;
    }
    
    /**
     * 
     */
    public String toString(){
        return super.toString() + String.format(" Liderazgo %2d ",liderazgo);
    }
    public void addLiderazgo(int porcent){
        
        if(liderazgo * (porcent / 100) < 5){
            liderazgo = liderazgo * (porcent / 100);
        }

    }
    
    public void hacerCrack(){
        super.hacerCrack();
        liderazgo = 5;
    }
}
