package arraystring;

import java.util.*;

/**
 * Given two strings,write a method to decide if one is a permutation of the other.
 */
class _01_02_CheckPermutation {
//    boolean check(String a, String b) {
//        if (a.length() != b.length()) {
//            return false;
//        }
//
//        Map<Character, Integer> chars = new HashMap<>();
//
//        // Add chars from a in Map
//        for (int i = 0; i < a.length(); i++) {
//            char c = a.charAt(i);
//            if(chars.containsKey(c)) {
//                chars.put(c, chars.get(c) + 1 );
//            } else {
//                chars.put(c,1);
//            }
//        }
//
//        for (int i = 0; i < b.length(); i++) {
//            char c = b.charAt(i);
//            if(chars.containsKey(c)) {
//                chars.put(c, chars.get(c) - 1 );
//            } else {
//                return false;
//            }
//        }
//
//        // check if b had more or less of a char than a
//        for (Integer counter : chars.values()) {
//            if (counter != 0) {
//                return false;
//            }
//        }
//
//        // Have similar chars with same quantity of each
//        return true;
//    }

    boolean check(String s1, String s2) {

        if (s1.length() != s2.length()) return false;

        // assuming only alphabets are used
        int[] occurrences = new int[256];

        for (Character c : s1.toCharArray()) {
            occurrences[c]++;
        }

        for (Character c : s2.toCharArray()) {
            occurrences[c]--;
        }

        for (int i = 0; i < occurrences.length; i++ ) {
            if (occurrences[i] != 0) return false;
        }

        return true;

    }
}
