public class Coordenades {
    private double x;
    private double y;
    private double z;

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    public double getZ() {
        return z;
    }

    public void setZ(double z) {
        this.z = z;
    }

    public Coordenades CoordenadaAterratge() {

        Coordenades coordenadaAterratge = new Coordenades();

        coordenadaAterratge.setX(100);
        coordenadaAterratge.setY(100);
        coordenadaAterratge.setZ(0);

        return coordenadaAterratge;

    }
}
