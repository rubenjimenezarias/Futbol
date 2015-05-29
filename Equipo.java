import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Equipo here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Equipo
{
    // instance variables - replace the example below with your own
    private String nombre;
    private ArrayList<Jugador> plantilla;
    private static int dorsal;
    private int numJugadores;
    private double valoracionMedia;
    private String nombres[] = {"Ramon", "Pedro", "Juan", "Mario", "Marcos", "Miguel", "Luis", "Carlos", "Jose Ramon", "Federico", "Alberto", "Roberto", "Ruben", "Guillermo", "Hector","Mario", "Felipe", "Manuel", "Tomas", "Agustin", "Jose Manuel", "Juan Jesus","Pepe", "Ricardo", "Fernando", "Antonio", "Jose Alberto", "Jose Luis", "David","Emilio", "Cesar", "German", "Raul", "Pablo"};
    // creamos la array de la alineacion titular
        ArrayList<Jugador> alineacion = new ArrayList();
        
    /**
     * Constructor for objects of class Equipo
     */
    public Equipo(String nombre, int numJugadores)
    {
        dorsal = 1;
        this.nombre = nombre;
        valoracionMedia = 0;
        if (numJugadores > 34 || numJugadores < 11){
            this.numJugadores = 25;
        }
        else{
            this.numJugadores = numJugadores;
        }
        plantilla = new ArrayList<>();
        crearPlantilla();
    }

    /**
     * Introducimos un jugador al equipo
     */
    public void addJugador(Jugador jugador){
        jugador.asignarDorsal(dorsal);
        dorsal++;
        plantilla.add(jugador);
    }
    
    /**
     * 
     */
    private void crearPlantilla(){
        int cont = 0;
        Random aleatorio = new Random();
        int numeroAleatorio;
        boolean hayCapitan = false;
        int capitan = (aleatorio.nextInt(numJugadores+1));
        //Creo la lista que vamos a ir eliminando nombres.
        ArrayList<String> lista = new ArrayList();
        for(int i = 0; i< nombres.length; i++){
            lista.add(nombres[i]);
        }
        
        while (cont < numJugadores){
            numeroAleatorio = aleatorio.nextInt(lista.size());
            if(cont == 0){
                addJugador(new Portero(nombres[numeroAleatorio]));
            }
            else if (!hayCapitan && (cont == capitan || cont == numJugadores-1)){
                addJugador(new Capitan(nombres[numeroAleatorio]));
                hayCapitan = true;
            }
            else{
                addJugador(new JugadorCampo(nombres[numeroAleatorio]));
            }
            lista.remove(numeroAleatorio);
            cont++;
        }
    }
    
    /**
     * 
     */
    private void crearAlineacion(){
        //Creamos una copia de la plantilla para ir elminando jugadores
        ArrayList<Jugador> lista = new ArrayList();
        lista = (ArrayList)plantilla.clone();
        
        //Metemos al portero que es fijo
        alineacion.add(lista.get(0));
        lista.remove(0);
        // Metemos al capitan que tiene que jugar fijo
        boolean encontrado = false;
        int cont = 0;
        while (cont < lista.size() && !encontrado){
                if(lista.get(cont) instanceof Capitan){
                    alineacion.add(lista.get(cont));
                    lista.remove(cont);
                }
                cont++;
            }
        
        //Metemos a los mejores jugadores.
        
        cont = 0;
        int posicion = 0;
        while(cont < 9){
            int cont2 = 0;
            posicion = 0;
            Jugador mejor = lista.get(0);
            while (cont2 < lista.size()){
                if(lista.get(cont2).valoracion() > mejor.valoracion()){
                    mejor = lista.get(cont2);
                    posicion = cont2;
                }
                cont2++;
            }
            alineacion.add(mejor);
            lista.remove(posicion);
            cont++;
        }
        
        // Metemos a los suplentes
        for (Jugador jugador : lista){
            alineacion.add(jugador);
        }
    }
    
    /**
     * 
     */
    public void verAlineacion(){
        crearAlineacion();
        System.out.println("**" + nombre + "**");
        System.out.println("~ ~ TITULARES ~ ~");
        int cont = 0;
        while(cont <= 11){
            switch(cont){
                case 0:
                System.out.println("Por- " + alineacion.get(cont));
                break;
                case 1:
                System.out.println("Df(C)" + alineacion.get(cont));
                break;
                case 2: case 3: case 4:
                System.out.println("Def- " + alineacion.get(cont));
                break;
                case 5: case 6: case 7: case8:
                System.out.println("Med- " + alineacion.get(cont));
                break;
                case 9: case 10:
                System.out.println("Del- " + alineacion.get(cont));
                break;
            }
            valoracionMedia += alineacion.get(cont).valoracion();
            cont++;
        }
        String.format("--------------------Valoracion Media del equipo titular es de %.2f --------------------",valoracionMedia/11);
        System.out.println("~ ~ SUPLENTES ~ ~");
        while (cont < numJugadores){
            System.out.println("     " + alineacion.get(cont));
            cont++;
        }
        System.out.println("***********************************" + "\n");
    }
}
