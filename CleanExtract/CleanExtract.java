public class CleanExtract {
    public static String extract(String s) {
        if (s == null || s.isEmpty()) {
            return "";
        }
        String[] parts = s.split("\\|");
        StringBuilder result = new StringBuilder();
        for (String part : parts) {
            if (part == null) {
                continue;
            }
            String extracted = extractPart(part);
            if (!extracted.isEmpty()) {
                if (result.length() > 0) {
                    result.append(' ');
                }
                result.append(extracted);
            }
        }
        return result.toString();
    }

    private static String extractPart(String part) {
        int firstDot = part.indexOf('.');
        int lastDot = part.lastIndexOf('.');
        String extracted;
        if (firstDot == -1) {
            extracted = part;
        } else if (firstDot == lastDot) {
            extracted = part.substring(firstDot + 1);
        } else {
            extracted = part.substring(firstDot + 1, lastDot);
        }
        return extracted.trim();
    }
}
