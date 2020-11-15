import javax.security.auth.callback.CallbackHandler;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Scanner;

public class main {

    public static void main(String[] args) {

        main Start = new main();
        Start.Principal();

    }

    Scanner m = new Scanner(System.in);
    ArrayList<AvioGeneral> espaiAeri = new ArrayList<AvioGeneral>();
    AvioGeneral AvioGeneral = new AvioGeneral();
    public void Principal(){

        int opcio;
        boolean sortir=false;
        String esriure;

        while (!sortir){
            menuPrincipal();

            try {
                System.out.println("Escriu una de les opcions ");
                opcio=m.nextInt();

                switch (opcio){
                    case 1 -> generarAvio();

                    case 2 -> GestionarAvions();

                    case 3 -> infoAvio();

                    // case 4 -> XifrarAvions();

                    // case 5 -> DesxifrarAvions();

                   case 7 -> {
                        sortir = true;
                        System.out.println("El joc s'ha acabau.");
                        return;
                    }
                }

            }catch (InputMismatchException e){

            }

        }

    }

    public void menuPrincipal(){
        System.out.println("1.Afegir un avió  ");
        System.out.println("2.Gestionar un avió ");
        System.out.println("3.Mostrar l'espai aeri actual  ");
        System.out.println("4.Xifrar els aviones de combat ");
        System.out.println("5.Desxifrar els avions de combate ");
        System.out.println("6.Info ");
        System.out.println("7.Sortir");

    }

    public boolean checkPista() {
        for (AvioGeneral check : espaiAeri) {

            if (check != null) {

                if (check.getCoordenadesX() == 100 && check.getCoordenadesY() == 100) {
        return false;
    }
    }
}
        return true;
    }


    public void generarAvio() {

        if (checkPista()) {
            System.out.println("Introdueix la matricula del avió");
            String matricula = m.next();

            System.out.println("Introdueix la marca del avió: ");
            String model = m.next();

            System.out.println("Introdueix el modelo del avió: ");
            String marca = m.next();

            System.out.println("Introdueix el fabricant: ");
            String fabricant = m.next();

            System.out.println("Introdueix la capacitat de emmagatzematge: ");
            int capacitat = m.nextInt();

            System.out.println("Introdueix la quantitat de tripulants: ");
            int tripulants = m.nextInt();

            System.out.println("Introdueix el origen: ");
            String origen = m.next();

            System.out.println("Introdueix el destí: ");
            String desti = m.next();

            System.out.println("Introdueix la autonomia del avió: ");
            int autonomia = m.nextInt();
            System.out.println("COMERCIAL");
            System.out.println("MILITAR");
            String opcio = m.next();
            switch (opcio.toUpperCase()){
                case "COMERCIAL" -> {
                    AvioComercial Comercial = new AvioComercial(matricula,marca, model, fabricant, capacitat, tripulants, origen,desti,100,100,autonomia,0,false,0,0,true);
                    espaiAeri.add(Comercial);
                }

                case "MILITAR" -> {
                    System.out.println("bandol del avio, ALIAT o ENEMIC? ");
                    opcio = m.next();
                    switch (opcio.toUpperCase()){
                        case "ALIAT" ->{
                            AvioMilitar AvionMilitar = new AvioMilitar( matricula,  marca, model,  fabricant,  capacitat,  tripulants,  origen,  desti,  100,
                                    100,  autonomia,  0,  false,  0, 0,  true,  0,true);
                            espaiAeri.add(AvionMilitar);
                        }

                        case "ENEMIC" ->{

                            AvioMilitar AvionMilitar = new AvioMilitar( matricula,  marca, model,  fabricant,  capacitat,  tripulants,  origen,  desti,  100,
                                    100,  autonomia,  0,  false,  0, 0,  true,  0 ,false);
                            espaiAeri.add(AvionMilitar);
                        }
                    }


                }
            }


        } else if (!checkPista()) {
            if(espaiAeri.size() == 11) {
                System.out.println("No se puede crear más aviones");
            }
            //Si quiero que haga BOOM
            System.out.println("No puedes crear otro avión la pista esta llena");

             }

        System.out.println("✈✈✈✈✈✈");

    }



    public void infoAvio(){
        if(espaiAeri.size() == 0) {
            System.out.println("No hay ningun avio en el espacio aereo");
        }
        for (int i = 0; i < espaiAeri.size(); i++) {

            AvioGeneral info = espaiAeri.get(i);

            if (info != null) {

                System.out.println("Aeronau "+ (i+1));
                System.out.println("Marca: " + info.getMarca());
                System.out.println("Model: " + info.getModel());
                /* if (info.getxifrat()) {
                    System.out.println("Matricula: ENCRIPTAT");
                } else {
                    System.out.println("Matrícula: " + info.getMatricula());
                }*/
                System.out.println("X: " + info.getCoordenadesX());
                System.out.println("Y: " + info.getCoordenadesY());
                System.out.println("Alçada: " + info.getAlcada());
                System.out.println("Velocitat: " + info.getVelocitat());
                System.out.println("Tren aterratge: " + info.getTrenAterratge());
                System.out.println("Motor: " + info.getMotor());
                System.out.println("Misils: " + (((AvioMilitar)espaiAeri.get(i)).getMissils()));
                System.out.println("Origen: " + info.getOrigen());
                System.out.println("Desti: " + info.getDesti());
                System.out.println("Bandol: " + (((AvioMilitar)espaiAeri.get(i)).getBandol()));
            }
            System.out.println(" ");
        }
    }

    public void GestionarAvions(){
        if(espaiAeri.size() == 0){
            System.out.println("no hi ha cap avio, no pots crear res");
        } else {
            String matricula;
            System.out.println("Introdueix la matricula de l'avió: ");
            matricula = m.next();

            for (int i = 0; i < espaiAeri.size(); i++) {
                AvioGeneral verify = espaiAeri.get(i);
                if (verify != null) {
                    if (matricula.equals(verify.getMatricula())) {

                        String opcion;
                        boolean salir = false;
                        while (!salir) {
                            System.out.println( "-------------------------------------");
                            System.out.println( "Escolleix el mode: ");
                            System.out.println( "Motor");
                            System.out.println( "velocitat");
                            System.out.println( "Altura_i_Baixada");
                            System.out.println( "TREN-ATERRATGE");
                            System.out.println( "Rumb");
                            System.out.println( "Posicionar");
                            System.out.println( "Misils");
                            System.out.println( "SORTIR");
                            System.out.println( "-------------------------------------");
                            try {
                                System.out.println( "Escriu una de les opcions");
                                opcion = m.next();
                                switch (opcion.toUpperCase()) {
                                    case "MOTOR" -> {
                                        espaiAeri = espaiAeri.get(i).Gestionarmotor(espaiAeri,i);
                                    }
                                    case "VELOCITAT" -> {
                                        espaiAeri = espaiAeri.get(i).GestionarVelocitat(espaiAeri,i);
                                    }
                                    case "ALTURA" -> {
                                        espaiAeri = espaiAeri.get(i).GestionarPujarAlturaiBaixarAltura(espaiAeri,i);
                                    }
                                    case "TRENATERRATGE" -> {
                                        espaiAeri = espaiAeri.get(i).GestionarTrenAterratge(espaiAeri,i);
                                    }
                                    case "RUMB" -> {
                                        espaiAeri = espaiAeri.get(i).GestionarRumb(espaiAeri,i);
                                    }
                                    case "POSICIONAR" -> {
                                        espaiAeri = espaiAeri.get(i).GestionarCoordenades(espaiAeri,i);
                                    }
                                    case "MISILS" ->{
                                        espaiAeri = espaiAeri.get(i).DispararMissils(espaiAeri,i);
                                    }

                                    case "SORTIR" -> {
                                        salir = true;
                                        System.out.println("Has salido de la gestión del avión");
                                        return;
                                    }
                                    default -> System.out.println( "Error, vuelve a introducir el modo nuevamente.");
                                }
                            } catch (InputMismatchException | InterruptedException e) {
                                System.out.println("Debes insertar un número correspondiente al que se te indica.");
                                m.next();
                            }
                        }
                    } else {
                        System.out.println("No se ha encontrado ningun avión con esa matricula");
                    }
                }
            }
        }
    }


    public void moureAvio(){
        String moure = m.next();

    }

}

