import java.util.Random;
/**
 * Write a description of class Partido here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Partido
{
    // instance variables - replace the example below with your own
    private Equipo local;
    private Equipo visitante;

    /**
     * Constructor for objects of class Partido
     */
    public Partido(Equipo local, Equipo visitante)
    {
        // initialise instance variables
        this.local = local;
        this.visitante = visitante;
    }

    /**
     * 
     */
    public void mostrarAlineaciones()
    {
        System.out.println("**EQUIPO LOCAL**");
        local.verAlineacion();
        System.out.println("**EQUIPO VISITANTE**");
        visitante.verAlineacion();
    }

    public void posibleResultado(){
        Random rnd = new Random();
        int resultado = rnd.nextInt(3);
        int rGanador = rnd.nextInt(7) + 3;
        if(local.getEstadoFormaE() > visitante.getEstadoFormaE()){
            System.out.println("gana el " + local.getNombre() + " " + rGanador + " - " + resultado);
        }
        else if(local.getEstadoFormaE() < visitante.getEstadoFormaE()){
            System.out.println("gana el " + visitante.getNombre() + " " + rGanador + " - " + resultado);
        }
        else{
            System.out.println("gana el " + local.getNombre() + " " + rGanador + " - " + resultado + " gracias a la fuerza de los aficionados");
        }
    }
}
