package arraystring;

import java.util.Arrays;

/**
 * There are three types of edits that can be performed on strings:
 * insert a character, remove a character, or replace a character.
 * Given two strings, write a function to check if they are one edit (or zero edits) away.
 * <p>
 * EXAMPLE
 * pale, ple -> true
 * pales, pale -> true
 * pale, bale -> true
 * pale, bake -> false
 */
class _01_05_OneAway {
    public static boolean isOneAway(String a, String b) {
        if (Math.abs(a.length() - b.length()) > 1 ) {
            return false;
        }

        int[] occurrences = new int[26];
        Arrays.fill(occurrences, 0);

        for (int i = 0; i < a.length(); i++) {
            occurrences[a.charAt(i) - 'a']++;
        }

        for (int i = 0; i < b.length(); i++) {
            occurrences[b.charAt(i) - 'a']--;
        }

        int diff = 0;
        for (int i = 0; i < occurrences.length; i++) {
            if (occurrences[i] == 1) {diff++;}
            if (occurrences[i] > 1 || diff > 1) {
                return false;
            }
        }
        return true;
    }
}
