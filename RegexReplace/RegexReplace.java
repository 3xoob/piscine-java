public class RegexReplace {
    public static String removeUnits(String s) {
        return s.replaceAll("(?<=\\d)(cm|€)(?=\\s|$)", "");
    }

    public static String obfuscateEmail(String s) {
        int atIndex = s.indexOf('@');
        String username = s.substring(0, atIndex);
        String domain = s.substring(atIndex + 1);

        return obfuscateUsername(username) + "@" + obfuscateDomain(domain);
    }

    private static String obfuscateUsername(String username) {
        int separatorIndex = lastSeparatorIndex(username);
        if (separatorIndex != -1) {
            return username.substring(0, separatorIndex + 1)
                    + stars(username.length() - separatorIndex - 1);
        }
        if (username.length() > 3) {
            return username.substring(0, 3) + stars(username.length() - 3);
        }
        return username;
    }

    private static int lastSeparatorIndex(String username) {
        int index = -1;
        for (char separator : new char[] {'.', '-', '_'}) {
            index = Math.max(index, username.lastIndexOf(separator));
        }
        return index;
    }

    private static String obfuscateDomain(String domain) {
        String[] parts = domain.split("\\.");
        if (parts.length == 3) {
            return stars(parts[0].length()) + "." + parts[1] + "." + stars(parts[2].length());
        }

        String topLevelDomain = parts[parts.length - 1];
        if ("com".equals(topLevelDomain) || "org".equals(topLevelDomain) || "net".equals(topLevelDomain)) {
            return stars(parts[0].length()) + "." + topLevelDomain;
        }
        return stars(parts[0].length()) + "." + stars(topLevelDomain.length());
    }

    private static String stars(int length) {
        return "*".repeat(length);
    }
}
