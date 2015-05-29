import java.util.Random;
/**
 * Write a description of class JugadorCampo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class JugadorCampo extends Jugador
{
    // instance variables - replace the example below with your own
    private int pase;
    private int regate;
    private int remate;

    /**
     * Constructor for objects of class JugadorCampo
     */
    public JugadorCampo(String nombre)
    {
        super(nombre);
        Random aleatorio = new Random();
        pase = aleatorio.nextInt(11);
        regate = aleatorio.nextInt(11);
        remate = aleatorio.nextInt(11);
    }

    /**
     *
     */
    public int getPase()
    {
        return pase;
    }
    
    /**
     *
     */
    public int getRegate()
    {
        return regate;
    }
    
    /**
     *
     */
    public int getRemate()
    {
        return remate;
    }
    
    /**
     * Devuelve la valoracion
     */
    public double valoracion(){
        return (super.valoracion()+pase+regate+remate)/4;
    }
    
    /**
     * 
     */
    public String toString(){
        return super.toString() + String.format("Pase %2d Regate %2d Remate %2d Valoracion %.0f", pase,regate,remate,valoracion()) ;
    }
}
