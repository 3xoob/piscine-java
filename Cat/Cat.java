import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.InputStream;

public class Cat {
    public static void cat(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            return;
        }
        try (InputStream in = new BufferedInputStream(new java.io.FileInputStream(args[0]))) {
            byte[] buffer = new byte[4096];
            int read;
            while ((read = in.read(buffer)) != -1) {
                System.out.write(buffer, 0, read);
            }
            System.out.flush();
        }
    }
}
