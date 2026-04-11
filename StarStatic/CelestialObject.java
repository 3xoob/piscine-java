public class CelestialObject {
    public static final double KM_IN_ONE_AU = 150_000_000.0;

    private double x;
    private double y;
    private double z;
    private String name;

    public CelestialObject() {
        this.name = "Soleil";
        this.x = 0.0;
        this.y = 0.0;
        this.z = 0.0;
    }

    public CelestialObject(String name, double x, double y, double z) {
        this.name = name;
        this.x = x;
        this.y = y;
        this.z = z;
    }

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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static double getDistanceBetween(CelestialObject first, CelestialObject second) {
        double dx = first.getX() - second.getX();
        double dy = first.getY() - second.getY();
        double dz = first.getZ() - second.getZ();
        return Math.sqrt(dx * dx + dy * dy + dz * dz);
    }

    public static double getDistanceBetweenInKm(CelestialObject first, CelestialObject second) {
        return getDistanceBetween(first, second) * KM_IN_ONE_AU;
    }
}
