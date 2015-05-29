import java.util.Random;
/**
 * Write a description of class Jugador here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public abstract class Jugador
{
    // instance variables - replace the example below with your own
    private String nombre;
    private int edad;
    private int dorsal;
    private int forma;
    
    private int valoracion;
    
    

    /**
     * Constructor for objects of class Jugador
     */
    public Jugador(String nombre)
    {
        // initialise instance variables
        Random aleatorio = new Random();
        this.nombre = nombre;
        edad = aleatorio.nextInt(22)+18;
        forma = aleatorio.nextInt(11);
        
        dorsal = 0;
    }
    
    /**
     * 
     */
    public String getNombre()
    {
        // put your code here
        return nombre;
    }
    
    /**
     * 
     */
    public int getEdad()
    {
        // put your code here
        return edad;
    }
    
    /**
     * 
     */
    public int getDorsal()
    {
        // put your code here
        return dorsal;
    }
    
    /**
     * 
     */
    public int getForma()
    {
        // put your code here
        return forma;
    }
    
    /**
     * Asignar dorsal al jugador
     */
    public void asignarDorsal(int dorsal){
        this.dorsal = dorsal;
    }
    
    public double valoracion(){
        return forma;
    }
    
    public String toString(){
        
        return String.format("Dorsal %2d %-12s (%2d anos) ", dorsal, nombre,edad);
    }
}
