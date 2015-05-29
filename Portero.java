import java.util.Random;
/**
 * Write a description of class Portero here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Portero extends Jugador
{
    // instance variables - replace the example below with your own
    private int agilidad;
    private int fortalezaMental;

    /**
     * Constructor for objects of class Portero
     */
    public Portero(String nombre)
    {
        super(nombre);
        Random aleatorio = new Random();
        agilidad = aleatorio.nextInt(11);
        fortalezaMental = aleatorio.nextInt(11);
        
    }

    /**
     *
     */
    public int getAgilidad()
    {
        return agilidad;
    }
    
    /**
     *
     */
    public int getFortalezaMental()
    {
        return fortalezaMental;
    }
    
    /**
     * Valoracion del portero
     */
    public double valoracion(){
        return (super.valoracion()+agilidad + fortalezaMental)/3;
    }
    
    /**
     * 
     */
    public String toString(){
        return super.toString() + String.format("Agilidad %2d Fortaleza %2d Valoracion %.0f", agilidad, fortalezaMental, valoracion());
    }
}
