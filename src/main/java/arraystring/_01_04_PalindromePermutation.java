package arraystring;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, write a function to check if it is a permutation of a palindrome.
 * A palindrome is a word or phrase that is the same forwards and backwards.
 * A permutation is a rearrangement of letters.
 * The palindrome does not need to be limited to just dictionary words.
 * <p>
 * EXAMPLE
 * Input: Tact Coa
 * Output: True (permutations: "taco cat", "atco cta", etc.)
 */
class _01_04_PalindromePermutation {
    boolean check(String s) {
//        if(s.length() <= 1) {
//            return true;
//        }
//
//        Set<Character> odds = new HashSet<>();
//        int numOfChars = 0;
//        for (int i = 0; i < s.length(); i++) {
//            char c = s.charAt(i);
//            if (c == ' ') {
//                continue;
//            }
//            if(odds.contains(c)) {
//                odds.remove(c);
//            } else {
//                odds.add(c);
//            }
//            numOfChars++;
//        }
//
//        System.out.print(odds);
//        boolean oddLength = false;
//        if (numOfChars % 2 != 0 ) {
//            oddLength = true;
//        }
//        if (oddLength && odds.size() == 1) {
//            return true;
//        }
//        if (!oddLength && odds.size() == 0) {
//            return true;
//        }
//        return false;


        /////// SOLUTION 2////////
        s = s.replaceAll("\\s+","");
        s = s.toLowerCase();
        int[] occurrences = new int[256];

        for (Character c : s.toCharArray()) {
            occurrences[c]++;
        }

        if (s.length() % 2 == 0) {
            for (Integer i : occurrences) {
                if (i % 2 != 0) return false;
            }
        } else {
            int odds = 0;
            for (Integer i : occurrences) {
                if (i != 0 && i % 2 != 0) {
                    odds++;
                    if (odds > 1) return false;
                }
            }
        }
        return true;
    }
}
