import java.util.Map;

public class MapEquals {
    public static boolean areMapsEqual(Map<String, Integer> map1, Map<String, Integer> map2) {
        return map1 == null ? map2 == null : map1.equals(map2);
    }
}
