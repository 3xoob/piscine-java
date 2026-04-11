import java.util.Locale;
import java.util.Objects;

public class Planet extends CelestialObject {
    private Star centerStar;

    public Planet() {
        super();
        this.centerStar = new Star();
    }

    public Planet(String name, double x, double y, double z, Star centerStar) {
        super(name, x, y, z);
        this.centerStar = centerStar;
    }

    public Star getCenterStar() {
        return centerStar;
    }

    public void setCenterStar(Star centerStar) {
        this.centerStar = centerStar;
    }

    @Override
    public String toString() {
        double distance = CelestialObject.getDistanceBetween(this, centerStar);
        return String.format(
                Locale.US,
                "%s circles around %s at the %.3f AU",
                getName(),
                centerStar.getName(),
                distance
        );
    }

    @Override
    public boolean equals(Object object) {
        if (this == object) {
            return true;
        }
        if (!(object instanceof Planet)) {
            return false;
        }
        Planet other = (Planet) object;
        return super.equals(other) && Objects.equals(centerStar, other.centerStar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), centerStar);
    }
}
