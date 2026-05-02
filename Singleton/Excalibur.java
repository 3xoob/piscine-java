public class Excalibur {
    private static Excalibur INSTANCE;

    private final String name;

    private Excalibur(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public static Excalibur getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new Excalibur("Sword");
        }
        return INSTANCE;
    }
}
