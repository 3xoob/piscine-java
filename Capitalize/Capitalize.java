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
            boolean inWord = false;
            boolean pendingSpace = false;
            boolean wroteAny = false;
            byte[] buffer = new byte[4096];
            int read;
            while ((read = in.read(buffer)) != -1) {
                for (int i = 0; i < read; i++) {
                    int b = buffer[i] & 0xFF;
                    if (isWhitespace(b)) {
                        if (inWord) {
                            pendingSpace = true;
                            inWord = false;
                        }
                        continue;
                    }
                    if (pendingSpace && wroteAny) {
                        out.write(' ');
                        pendingSpace = false;
                    }
                    if (!inWord) {
                        if (b >= 'a' && b <= 'z') {
                            out.write(b - ('a' - 'A'));
                        } else if (b >= 'A' && b <= 'Z') {
                            out.write(b);
                        } else {
                            out.write(b);
                        }
                        inWord = true;
                        wroteAny = true;
                    } else {
                        if (b >= 'A' && b <= 'Z') {
                            out.write(b + ('a' - 'A'));
                        } else {
                            out.write(b);
                        }
                    }
                }
            }
        }
    }

    private static boolean isWhitespace(int b) {
        return b == ' ' || b == '\t' || b == '\n' || b == '\r' || b == '\f';
    }
}
