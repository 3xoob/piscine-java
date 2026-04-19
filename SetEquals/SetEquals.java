import java.util.Set;

public class SetEquals {
    public static boolean areSetsEqual(Set<String> set1, Set<String> set2) {
        return set1 == null ? set2 == null : set1.equals(set2);
    }
}
