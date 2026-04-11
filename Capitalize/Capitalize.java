import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

public class Capitalize {
    public static void capitalize(String[] args) throws IOException {
        if (args == null || args.length < 2) {
            return;
        }
        try (BufferedInputStream in = new BufferedInputStream(new FileInputStream(args[0]));
             BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(args[1]))) {
            boolean newWord = true;
            byte[] buffer = new byte[4096];
            int read;
            while ((read = in.read(buffer)) != -1) {
                for (int i = 0; i < read; i++) {
                    int b = buffer[i] & 0xFF;
                    if (b >= 'A' && b <= 'Z') {
                        if (newWord) {
                            out.write(b);
                        } else {
                            out.write(b + ('a' - 'A'));
                        }
                        newWord = false;
                    } else if (b >= 'a' && b <= 'z') {
                        if (newWord) {
                            out.write(b - ('a' - 'A'));
                        } else {
                            out.write(b);
                        }
                        newWord = false;
                    } else {
                        out.write(b);
                        newWord = true;
                    }
                }
            }
        }
    }
}
