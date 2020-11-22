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

    String[][] arrayInfo = new String[10][10];

    public void Principal() {

        int opcio;
        boolean sortir = false;
        String esriure;

        while (!sortir) {
            menuPrincipal();

            try {
                System.out.println("Escriu una de les opcions ");
                opcio = m.nextInt();

                switch (opcio) {
                    case 1 -> generarAvio();

                    case 2 -> GestionarAvions();

                    case 3 -> mostrarinfo();

                    // case 4 -> XifrarAvions();

                    // case 5 -> DesxifrarAvions();

                    case 6 -> {
                        sortir = true;
                        System.out.println("El joc s'ha acabau.");
                        return;
                    }
                }

            } catch (InputMismatchException e) {

            }

        }

    }

    public void menuPrincipal() {
        System.out.println("1.Afegir un avió  ");
        System.out.println("2.Gestionar un avió ");
        System.out.println("3.Mostrar info  ");
        System.out.println("4.Xifrar els aviones de combat ");
        System.out.println("5.Desxifrar els avions de combat ");
        System.out.println("6.Sortir");

    }

    //indiquem si podem crear un avio o no
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

            System.out.println("Introdueix el model del avió: ");
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

            //passem totes les dades necessaries per crear un avio.
            switch (opcio.toUpperCase()) {
                case "COMERCIAL" -> {
                    AvioComercial Comercial = new AvioComercial(matricula, marca, model, fabricant, capacitat, tripulants, origen, desti, 100, 100, autonomia, 0, false, 0, 0, true);
                    espaiAeri.add(Comercial);
                }

                case "MILITAR" -> {
                    System.out.println("bandol del avio, ALIAT o ENEMIC? ");
                    opcio = m.next();
                    switch (opcio.toUpperCase()) {
                        case "ALIAT" -> {
                            AvioMilitar AvionMilitar = new AvioMilitar(matricula, marca, model, fabricant, capacitat, tripulants, origen, desti, 100,
                                    100, autonomia, 0, false, 0, 0, true, 0, true);
                            espaiAeri.add(AvionMilitar);
                        }

                        case "ENEMIC" -> {

                            AvioMilitar AvionMilitar = new AvioMilitar(matricula, marca, model, fabricant, capacitat, tripulants, origen, desti, 100,
                                    100, autonomia, 0, false, 0, 0, true, 0, false);
                            espaiAeri.add(AvionMilitar);
                        }
                    }


                }
            }

            //indiquem que com a maxim podem tenir 11 avions
        } else if (!checkPista()) {
            if (espaiAeri.size() == 11) {
                System.out.println("No pots crear més avions");
            }

            System.out.println("No pots crear més avions, la pista esta plena ");

        }

        System.out.println("✈✈✈✈✈✈");

    }

/*
    public void infoAvio() {
        if (espaiAeri.size() == 0) {
            System.out.println("No hi ha ningun avió a l'espai aeri ");
        }
        for (int i = 0; i < espaiAeri.size(); i++) {

            AvioGeneral info = espaiAeri.get(i);

            //informem de totes les dades dels avions
            if (info != null) {

                System.out.println("Aeronau " + (i + 1));
                System.out.println("Marca: " + info.getMarca());
                System.out.println("Model: " + info.getModel());

                System.out.println("X: " + info.getCoordenadesX());
                System.out.println("Y: " + info.getCoordenadesY());
                System.out.println("Alçada: " + info.getAlcada());
                System.out.println("Velocitat: " + info.getVelocitat());
                System.out.println("Tren aterratge: " + info.getTrenAterratge());
                System.out.println("Motor: " + info.getMotor());
                System.out.println("Misils: " + (((AvioMilitar) espaiAeri.get(i)).getMissils()));
                System.out.println("Origen: " + info.getOrigen());
                System.out.println("Desti: " + info.getDesti());
                System.out.println("Bandol: " + (((AvioMilitar) espaiAeri.get(i)).getBandol()));
            }
            System.out.println(" ");
        }
    }
*/

        //gestionem els avions, per poguer crear un avio primer has de gestionar el que has creat abans, un cop gestionat ja pots crear mes avions
    public void GestionarAvions() {
        if (espaiAeri.size() == 0) {
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
                            System.out.println("-------------------------------------");
                            System.out.println("Escolleix el mode: ");
                            System.out.println("Motor");
                            System.out.println("velocitat");
                            System.out.println("Altura_i_Baixada");
                            System.out.println("TREN-ATERRATGE");
                            System.out.println("Rumb");
                            System.out.println("Posicionar");
                            System.out.println("Misils");
                            System.out.println("SORTIR");
                            System.out.println("-------------------------------------");
                            try {
                                System.out.println("Escriu una de les opcions");
                                opcion = m.next();
                                switch (opcion.toUpperCase()) {
                                    case "MOTOR" -> {
                                        espaiAeri = espaiAeri.get(i).Gestionarmotor(espaiAeri, i);
                                    }
                                    case "VELOCITAT" -> {
                                        espaiAeri = espaiAeri.get(i).GestionarVelocitat(espaiAeri, i);
                                    }
                                    case "ALTURA" -> {
                                        espaiAeri = espaiAeri.get(i).GestionarPujarAlturaiBaixarAltura(espaiAeri, i);
                                    }
                                    case "TRENATERRATGE" -> {
                                        espaiAeri = espaiAeri.get(i).GestionarTrenAterratge(espaiAeri, i);
                                    }
                                    case "RUMB" -> {
                                        espaiAeri = espaiAeri.get(i).GestionarRumb(espaiAeri, i);
                                    }
                                    case "POSICIONAR" -> {
                                        espaiAeri = espaiAeri.get(i).GestionarCoordenades(espaiAeri, i);
                                    }
                                    case "MISILS" -> {
                                        espaiAeri = espaiAeri.get(i).DispararMissils(espaiAeri, i);
                                    }

                                    case "SORTIR" -> {
                                        salir = true;
                                        System.out.println("Has sortit del menú de gestió d'avions ");
                                        return;
                                    }
                                    default -> System.out.println("Error, torna a introduir el mode de nou. ");
                                }
                            } catch (InputMismatchException | InterruptedException e) {
                                System.out.println("Has d'insertar una opció correcte .");
                                m.next();
                            }
                        }
                    } else {
                        System.out.println("No s'ha trobat cap avió amb aquesta matricula");
                    }
                }
            }
        }
    }


    public void taulaInfo() {
        //mostrem la taula d'informació en l'ordre correcte
        System.out.println("matricula marca model origen desti coordenadesX coordenadesY  motor velocitat alcada ");
        int contador = 0;
        int contador2 = 0;

        for (int i = 0; i < arrayInfo.length && contador < espaiAeri.size(); i++) {
            contador2 = 0;
            for (int j = 0; j < arrayInfo.length && contador < espaiAeri.size() && contador2 != 2; j++) {
                arrayInfo[i][j] = espaiAeri.get(contador).getMatricula();
                arrayInfo[i][j + 1] = espaiAeri.get(contador).getMarca();
                arrayInfo[i][j + 2] = espaiAeri.get(contador).getModel();
                arrayInfo[i][j + 3] = espaiAeri.get(contador).getOrigen();
                arrayInfo[i][j + 4] = espaiAeri.get(contador).getDesti();
                arrayInfo[i][j + 5] = String.valueOf(espaiAeri.get(contador).getCoordenadesX());
                arrayInfo[i][j + 6] = String.valueOf(espaiAeri.get(contador).getCoordenadesY());

                if (espaiAeri.get(contador).getMotor() == false) {
                    arrayInfo[i][j + 7] = "TANCAT";
                } else {
                    if (espaiAeri.get(contador).getMotor() == true) {
                        arrayInfo[i][j + 7] = "OBERT";
                    }
                }
                arrayInfo[i][j + 8] = String.valueOf(espaiAeri.get(contador).getVelocitat());
                arrayInfo[i][j + 9] = String.valueOf(espaiAeri.get(contador).getAlcada());

                contador++;
                contador2 = 2;
            }
            System.out.println();
        }
    }
    //mostrem la informacio dintre de la taula
     public void  mostrarinfo(){
         taulaInfo();

        for (int t=0; t<espaiAeri.size(); t++){

            System.out.print("numero avio " + t + "\t");

            for (int c=0; c<arrayInfo.length; c++){

                System.out.print(arrayInfo[t][c] + "\t\t");

            }

            System.out.println();
        }



     }


}

