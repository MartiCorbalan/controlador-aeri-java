import java.util.ArrayList;
import java.util.Scanner;


public class AvioGeneral{

    
    private String matricula;
    private String marca;
    private String model;
    private String fabricant;
    private int capacitat;
    private int tripulants;
    private String origen;
    private String desti;
    private int coordenadesX;
    private int coordenadesY;
    private int autonomia;
    private int rumb;
    private Boolean motor;
    private int velocitat;
    private int alcada;
    private boolean trenAterratge;


    Scanner m = new Scanner(System.in);


    public AvioGeneral(){

    }



    public AvioGeneral (String matricula, String marca, String model, String fabricant, int capacitat, int tripulants, String origen, String desti,
                        int coordenadesX, int coordenadesY, int autonomia, int rumb, Boolean motor, int velocitat, int alcada, boolean trenAterratge ){


        this.marca=marca;
        this.alcada=alcada;
        this.autonomia=autonomia;
        this.coordenadesX=coordenadesX;
        this.coordenadesY=coordenadesY;
        this.model=model;
        this.motor=motor;
        this.fabricant=fabricant;
        this.capacitat=capacitat;
        this.tripulants=tripulants;
        this.origen=origen;
        this.desti=desti;
        this.rumb=rumb;
        this.velocitat=velocitat;
        this.trenAterratge=trenAterratge;
        this.matricula=matricula;



    }



    public void setMatricula(String matricula){
        this.matricula=matricula;
    }

    public String getMatricula(){
        return this.matricula;
    }

    public void setMarca(String marca){
        this.marca=marca;
    }

    public String getMarca(){
        return this.marca;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getFabricant() {
        return fabricant;
    }

    public void setFabricant(String fabricant) {
        this.fabricant = fabricant;
    }

    public int getCapacitat() {
        return capacitat;
    }

    public void setCapacitat(int capacitat) {
        this.capacitat = capacitat;
    }

    public int getTripulants() {
        return tripulants;
    }

    public void setTripulants(int tripulants) {
        this.tripulants = tripulants;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDesti() {
        return desti;
    }

    public void setDesti(String desti) {
        this.desti = desti;
    }

    public int getCoordenadesX(){
        return coordenadesX;
    }

   public void setCoordenadesX(int coordenadesX){
        this.coordenadesX=coordenadesX;
   }

    public int getCoordenadesY(){
        return coordenadesY;
    }

    public void setCoordenadesY(int coordenadesY){
        this.coordenadesY=coordenadesY;
    }


    public int getAutonomia() {
        return autonomia;
    }

    public void setAutonomia(int autonomia) {
        this.autonomia = autonomia;
    }

    public int getRumb() {
        return rumb;
    }

    public void setRumb(int rumb) {
        this.rumb = rumb;
    }

    public Boolean getMotor() {
        return motor;
    }

    public void setMotor(Boolean motor) {
        this.motor = motor;
    }

    public int getVelocitat() {
        return velocitat;
    }

    public void setVelocitat(int velocitat) {
        this.velocitat = velocitat;
    }

    public int getAlcada() {
        return alcada;
    }

    public void setAlcada(int alcada) {
        this.alcada = alcada;
    }

    public boolean getTrenAterratge() {
        return trenAterratge;
    }

    public void setTrenAterratge(boolean trenAterratge) {
        this.trenAterratge = trenAterratge;
    }


    //metode per gestionar el motor
    public ArrayList<AvioGeneral> Gestionarmotor(ArrayList<AvioGeneral> espaiaeri, int i) throws InterruptedException {



                System.out.println("ENGEGAR");
                System.out.println("APAGAR");
                String v = m.next();

                switch(v.toUpperCase()){
                    case "ENGEGAR" -> {
                        if(!espaiaeri.get(i).getMotor()){

                            espaiaeri.get(i).setMotor(true);
                            System.out.println("el motor esta encès ");
                            Thread.sleep(1500);
                        }else {
                            System.out.println("el motor ja esta ences melon! ");
                        }

                    }

                    case "APAGAR" ->{
                            if (!espaiaeri.get(i).getMotor()){
                                espaiaeri.get(i).setMotor(false);
                                System.out.println("el motor esta apagau ");
                                Thread.sleep(1500);
                            }else{
                                System.out.println("el motor ja esta apagat!!");
                            }
                    }
                }
                return espaiaeri;
    }

    //metode per gestionar la velocitat
    public ArrayList<AvioGeneral> GestionarVelocitat(ArrayList<AvioGeneral> espaiaeri, int i){

        if (!espaiaeri.get(i).getMotor()){
            System.out.println("si el motor no esta ences no pots modificar la velocity ");
        }else {
            System.out.println("A quina velocitat vols accelerar?");
            int velocitatAccel = m.nextInt();
            System.out.println("vas a " + velocitatAccel);

            if (velocitatAccel > getVelocitat()) {
                espaiaeri.get(i).setVelocitat(velocitatAccel);
            } else {

                System.out.println("No pots anar més lent si acceleres");

            }

            System.out.println("A quina velocitat vols frenar?");

            int velocitatFrenar = m.nextInt();

            if (velocitatFrenar < getVelocitat()) {
                System.out.println("vas a " + velocitatFrenar);
                espaiaeri.get(i).setVelocitat(velocitatFrenar);

            } else {

                System.out.println("No pots anar més ràpid si vols frenar");

            }
        }


        return espaiaeri;
    }

    ////metode per gestionar la alçada
    public ArrayList<AvioGeneral> GestionarPujarAlturaiBaixarAltura(ArrayList<AvioGeneral> espaiaeri, int i){

        if (!espaiaeri.get(i).getMotor()){
            System.out.println("no pots modificar la altura si no tens el motor ences ");
            if (espaiaeri.get(i).getVelocitat()<180){
                System.out.println("no pots enlairar-te ");
            }
        }else{
            System.out.println("A quina alçada vols pujar?");

            int alcadapujar = m.nextInt();
            System.out.println("estas a  " + alcadapujar + " metres ");
            if (alcadapujar > getAlcada()) {

                espaiaeri.get(i).setAlcada(alcadapujar);

            } else if (alcadapujar > 50000) {

                System.out.println("No pots anar a la estratosfera");

            } else {

                System.out.println("No pots anar a una alçada inferior si pujes");

            }

            System.out.println("A quina alçada vols baixar?");

            int alcadabaixar = m.nextInt();
            System.out.println("estas a " + alcadabaixar + " metres ");
            if (alcadabaixar < getAlcada()) {

                espaiaeri.get(i).setAlcada(alcadabaixar);

            } else if (alcadabaixar < 0) {

                System.out.println("No pots baixar més abaix que 0");

            } else {

                System.out.println("No pots anar a una alçada superior si baixes");

            }
        }
            return espaiaeri;
    }
    //metode per gestionar el tren d'aterratge del avio
    public ArrayList<AvioGeneral> GestionarTrenAterratge(ArrayList<AvioGeneral> espaiaeri, int i) {

        if (!espaiaeri.get(i).getMotor()) {
            System.out.println("No pots modificar el tren d'aterratge si el motor no esta ences ");
            if (espaiaeri.get(i).getAlcada() < 500) {
                System.out.println("No pots modificar el tren d'aterratge si no tens una alçaad minima de 500");
            }
            if (espaiaeri.get(i).getAlcada() > 500 && espaiaeri.get(i).getVelocitat() > 300) {
                System.out.println("No pots modificar el tren d'aterratge a aquesta altitud/velocidad");
            }
        } else {

            if (getTrenAterratge()) {

                System.out.println("El tren d'aterratge està baixat, el vols pujar? (S/N)");
                String decisioTren = m.next();

                if (decisioTren.equalsIgnoreCase("s")) {

                    espaiaeri.get(i).setTrenAterratge(true);
                }

            } else {

                if (espaiaeri.get(i).getAlcada() >= 500 && espaiaeri.get(i).getVelocitat() >= 300) {
                } else {
                    System.out.println("El tren d'aterratge esta pujat, el vols baixar? (S/N)");
                    String decisioTren = m.next();

                    if (decisioTren.equalsIgnoreCase("s")) {

                        espaiaeri.get(i).setTrenAterratge(false);

                    }
                }

            }
        }
        return espaiaeri;
    }

    //metode per gestionar el rumb
    public ArrayList<AvioGeneral> GestionarRumb(ArrayList<AvioGeneral> espaiaeri, int i){

       if (!espaiaeri.get(i).getMotor()){
           System.out.println("no pots gestionar el rumb si el motor no esta ences ");
       }else {
           System.out.println("Estableix el rumb: ");
           int rumb = m.nextInt();
           System.out.println("estas a " + rumb + " graus");
           if (rumb > 0 && rumb < 360) {

               espaiaeri.get(i).setRumb(rumb);

           } else {

               System.out.println("El rumb ha d'estar entre 0 i 360");

           }
       }
   return espaiaeri;
    }

    //metode per gestionar les coordenades
    public ArrayList<AvioGeneral> GestionarCoordenades(ArrayList<AvioGeneral> espaiaeri, int i){
        System.out.println("Posiciona la X i la Y del avió");
        System.out.println("X:");
        int x = m.nextInt();
        System.out.println("Y:");
        int y = m.nextInt();

        espaiaeri.get(i).setCoordenadesX(x);
        espaiaeri.get(i).setCoordenadesY(y);

        return espaiaeri;
    }

    //metode per gestionar els missils
    public ArrayList<AvioGeneral> DispararMissils(ArrayList<AvioGeneral> espaiaeri, int i){
        int numX1 = espaiaeri.get(i).getCoordenadesX()-100;
        int numX2 = espaiaeri.get(i).getCoordenadesX()+100;
        int numY1 = espaiaeri.get(i).getCoordenadesY()-100;
        int numY2 = espaiaeri.get(i).getCoordenadesY()+100;
        int cont = -1;

        for(int buscarenemic = 0; buscarenemic < espaiaeri.size() ; buscarenemic++){
            if(((AvioMilitar)espaiaeri.get(buscarenemic)).getBandol() == false) {
                cont = buscarenemic;
            }
        }

        //si l'avio troba un enemic aprop disparara directament
        if(cont != -1) {
            if((espaiaeri.get(cont).getCoordenadesX()>= numX1 && espaiaeri.get(cont).getCoordenadesX()<=numX2) && (espaiaeri.get(cont).getCoordenadesY()>=numY1 && espaiaeri.get(cont).getCoordenadesY()<=numY2)) {
                if(((AvioMilitar)espaiaeri.get(cont)).getBandol() == false) {
                    System.out.println("Enemic trobat, disparant...");
                    espaiaeri.remove(cont);
                    System.out.println("Destruit");
                } else {
                    System.out.println("No hem trobat a cap enemic");
                }
            }
        }

        return espaiaeri;
    }


}
