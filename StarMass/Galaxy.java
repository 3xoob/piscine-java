import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Galaxy {
    private final List<CelestialObject> celestialObjects;

    public Galaxy() {
        this.celestialObjects = new ArrayList<>();
    }

    public List<CelestialObject> getCelestialObjects() {
        return celestialObjects;
    }

    public void addCelestialObject(CelestialObject object) {
        celestialObjects.add(object);
    }

    public Map<String, Integer> computeMassRepartition() {
        Map<String, Integer> repartition = new HashMap<>();
        repartition.put("Star", 0);
        repartition.put("Planet", 0);
        repartition.put("Other", 0);

        for (CelestialObject object : celestialObjects) {
            if (object instanceof Star) {
                repartition.put("Star", repartition.get("Star") + object.getMass());
            } else if (object instanceof Planet) {
                repartition.put("Planet", repartition.get("Planet") + object.getMass());
            } else {
                repartition.put("Other", repartition.get("Other") + object.getMass());
            }
        }
        return repartition;
    }
}
