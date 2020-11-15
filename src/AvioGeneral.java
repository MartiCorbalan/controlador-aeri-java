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
    private int distanciaMissil;
    private int missils;
    private String bandol;

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
        this.distanciaMissil=distanciaMissil;
        this.missils=missils;
        this.bandol=bandol;

    }


    public String getBandol() {
        return bandol;
    }

    public void setBandol(String bandol) {
        this.bandol = bandol;
    }

    public int getDistanciaMissil() {
        return distanciaMissil;
    }

    public void setDistanciaMissil(int distanciaMissil) {
        this.distanciaMissil = distanciaMissil;
    }

    public int getMissils() {
        return missils;
    }

    public void setMissils(int missils) {
        this.missils = missils;
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




    public ArrayList<AvioGeneral> Gestionarmotor(ArrayList<AvioGeneral> espaiaeri, int i) throws InterruptedException {

        String decisioMenuAvio = m.next();

                System.out.println("ENGEGAR");
                System.out.println("APAGAR");
                String v = m.next();

                switch(v.toUpperCase()){
                    case "ENGEGAR" -> {
                        espaiaeri.get(i).setMotor(true);
                        System.out.println("el motor esta encès ");
                        Thread.sleep(1500);

                    }

                    case "APAGAR" ->{
                        espaiaeri.get(i).setMotor(false);
                        System.out.println("el motor esta apagau ");
                        Thread.sleep(1500);
                    }
                }
                return espaiaeri;
    }


    public ArrayList<AvioGeneral> GestionarVelocitat(ArrayList<AvioGeneral> espaiaeri, int i){

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
        return espaiaeri;
    }


    public ArrayList<AvioGeneral> GestionarPujarAlturaiBaixarAltura(ArrayList<AvioGeneral> espaiaeri, int i){


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
            return espaiaeri;
    }

    public ArrayList<AvioGeneral> GestionarTrenAterratge(ArrayList<AvioGeneral> espaiaeri, int i){

        if (getTrenAterratge()) {

            System.out.println("El tren d'aterratge està baixat, el vols pujar? (S/N)");
            String decisioTren = m.next();

            if (decisioTren.equalsIgnoreCase("s")) {

                espaiaeri.get(i).setTrenAterratge(true);
            }

        } else {

            System.out.println("El tren d'aterratge esta pujat, el vols baixar? (S/N)");
            String decisioTren = m.next();

            if (decisioTren.equalsIgnoreCase("s")) {

                espaiaeri.get(i).setTrenAterratge(false);

            }

        }
return espaiaeri;
    }

    public ArrayList<AvioGeneral> GestionarRumb(ArrayList<AvioGeneral> espaiaeri, int i){
        System.out.println("Estableix el rumb: ");
        int rumb = m.nextInt();
        System.out.println("estas a " + rumb + " graus");
        if (rumb > 0 && rumb < 360) {

            espaiaeri.get(i).setRumb(rumb);

        } else {

            System.out.println("El rumb ha d'estar entre 0 i 360");

        }
return espaiaeri;
    }

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



}
