package arraystring;

/**
 * Implement a method to perform basic string compression using the counts of repeated characters.
 * For example, the string aabcccccaaa would become a2blc5a3.
 * If the "compressed" string would not become smaller than the original string, your method should return
 * the original string. You can assume the string has only uppercase and lowercase letters (a - z).
 */
class _01_06_StringCompression {
    public static String compress(String s) {

        if (s.length() < 2) {
            return s;
        }

        int count = 0;
        StringBuilder compressed = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            count++;
            if (i+1 >= s.length() || s.charAt(i) != s.charAt(i+1)) {
                compressed.append(s.charAt(i));
                compressed.append(count);
                count = 0;
            }
        }

        String result = compressed.toString();
        if (result.length() >= s.length()) {
            return s;
        }
        return result;
    }
}
