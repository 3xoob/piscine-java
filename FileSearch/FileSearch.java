import java.io.File;

public class FileSearch {
    public static String searchFile(String fileName) {
        if (fileName == null) {
            return null;
        }
        File root = new File("documents");
        if (!root.exists() || !root.isDirectory()) {
            return null;
        }
        File found = searchRecursive(root, fileName);
        return found == null ? null : found.getPath();
    }

    private static File searchRecursive(File dir, String fileName) {
        File[] entries = dir.listFiles();
        if (entries == null) {
            return null;
        }
        for (File entry : entries) {
            if (entry.isDirectory()) {
                File found = searchRecursive(entry, fileName);
                if (found != null) {
                    return found;
                }
            } else if (entry.getName().equals(fileName)) {
                return entry;
            }
        }
        return null;
    }
}
