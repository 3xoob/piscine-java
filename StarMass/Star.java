import java.util.Locale;
import java.util.Objects;

public class Star extends CelestialObject {
    private double magnitude;

    public Star() {
        super();
    }

    public Star(String name, double x, double y, double z, double magnitude, int mass) {
        super(name, x, y, z, mass);
        this.magnitude = magnitude;
    }

    public double getMagnitude() {
        return magnitude;
    }

    public void setMagnitude(double magnitude) {
        this.magnitude = magnitude;
    }

    @Override
    public String toString() {
        return String.format(Locale.US, "%s shines at the %.3f magnitude", getName(), magnitude);
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Star)) {
            return false;
        }
        Star other = (Star) object;
        return super.equals(other) && Double.compare(other.magnitude, magnitude) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), magnitude);
    }
}
