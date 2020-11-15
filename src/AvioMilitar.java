import java.util.PrimitiveIterator;
import java.util.Scanner;

public class AvioMilitar extends AvioGeneral {

    int distanciaMissil;
    int missils;
    String bandol;

    public AvioMilitar (String matricula, String marca,String model, String fabricant, int capacitat, int tripulants, String origen, String desti, int coordenadesX,
                          int coordenadesY, int autonomia, int rumb, Boolean motor, int velocitat,int alcada, boolean trenAterratge, int missils, int distanciaMissils, String bandol ){


        super(matricula, marca, model, fabricant, capacitat, tripulants, origen, desti, coordenadesX,coordenadesY, autonomia, rumb, motor, velocitat, alcada, trenAterratge);

    this.distanciaMissil=distanciaMissils;
    this.missils=missils;
    this.bandol=bandol;

    }



}
