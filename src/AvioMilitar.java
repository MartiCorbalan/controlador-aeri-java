import java.util.PrimitiveIterator;
import java.util.Scanner;

public class AvioMilitar extends AvioGeneral {



    int missils;

    Boolean bandol;

    public AvioMilitar (String matricula, String marca,String model, String fabricant, int capacitat, int tripulants, String origen, String desti, int coordenadesX,
                          int coordenadesY, int autonomia, int rumb, Boolean motor, int velocitat,int alcada, boolean trenAterratge, int missils,  Boolean bandol ){


        super(matricula, marca, model, fabricant, capacitat, tripulants, origen, desti, coordenadesX,coordenadesY, autonomia, rumb, motor, velocitat, alcada, trenAterratge);


    this.missils=missils;
    this.bandol=bandol;

    }
    public Boolean getBandol() {
        return bandol;
    }

    public void setBandol(Boolean bandol) {
        this.bandol = bandol;
    }
    public int getMissils() {
        return missils;
    }

    public void setMissils(int missils) {
        this.missils = missils;
    }



}
