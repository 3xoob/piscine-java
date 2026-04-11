import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.file.Files;
import java.nio.file.Paths;

public class CatInFile {
    public static void cat(String[] args) throws IOException {
        if (args == null || args.length == 0) {
            return;
        }
        try (InputStream in = new BufferedInputStream(System.in);
             OutputStream out = new BufferedOutputStream(Files.newOutputStream(Paths.get(args[0])))) {
            byte[] buffer = new byte[4096];
            int read;
            while ((read = in.read(buffer)) != -1) {
                out.write(buffer, 0, read);
            }
            out.flush();
        }
    }
}
