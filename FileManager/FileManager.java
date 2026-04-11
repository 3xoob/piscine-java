import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;

public class FileManager {
    public static void createFile(String fileName, String content) throws IOException {
        if (fileName == null) {
            return;
        }
        byte[] data = content == null ? new byte[0] : content.getBytes();
        Files.write(Paths.get(fileName), data);
    }

    public static String getContentFile(String fileName) throws IOException {
        if (fileName == null) {
            return null;
        }
        byte[] data = Files.readAllBytes(Paths.get(fileName));
        return new String(data);
    }

    public static void deleteFile(String fileName) {
        if (fileName == null) {
            return;
        }
        try {
            Files.deleteIfExists(Paths.get(fileName));
        } catch (IOException e) {
            // Ignore deletion errors
        }
    }
}
