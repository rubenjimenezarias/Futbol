import java.util.ArrayList;
import java.util.Random;
/**
 * Write a description of class Liga here.
 * 
 * @author (your name) 
 * @version (a version number or a date)
 */
public class Liga
{

    private int numEquipos;
    private ArrayList<Equipo> equipos;

    /**
     * Constructor for objects of class Liga
     */
    public Liga(int numEquipos)
    {
        equipos = new ArrayList<>();
        if(numEquipos < 2 && numEquipos > 30){
            numEquipos = 10;
        }
        this.numEquipos = numEquipos;
        for(int i = 0; i < numEquipos; i++){
            equipos.add(new Equipo("equipo" + i, 20));
        }
    }

    public void resultadoLIga(){
        for(int i = 0; i < equipos.size(); i++){
            int cont = i + 1;
            for(int indice = 0; i < equipos.size(); i++){
                if(cont < equipos.size()){
                    Partido partido = new Partido(equipos.get(i), equipos.get(cont));
                    System.out.println("reusltado de " + equipos.get(i).getNombre() + " y " + equipos.get(cont).getNombre());
                    partido.posibleResultado();
                    cont++;
                }
            }

        }
    }
}
