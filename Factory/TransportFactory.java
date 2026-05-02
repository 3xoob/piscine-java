public class TransportFactory {
    public static Transport getTransport(String type) {
        if ("Car".equals(type)) {
            return new Car();
        }
        if ("Plane".equals(type)) {
            return new Plane();
        }
        return null;
    }
}
