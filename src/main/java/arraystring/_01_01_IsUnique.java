package arraystring;

import java.util.*;

/**
 * Implement an algorithm to determine if a string has all unique characters.
 */

class _01_01_IsUnique {

    // boolean isUnique(String str) {
    //     if (str.length() > 256) {
    //         return false;
    //     }

    //     Set<Character> unique = new HashSet<>();

    //     for (int i = 0; i < str.length(); i++) {
    //         if(unique.contains(str.charAt(i))) {
    //             return false;
    //         } else {
    //             unique.add(str.charAt(i));
    //         }
    //     }
    //     return true;
    // }

    public boolean isUnique(String input) {
		// if the string is longer than 256, return false
		if (input.length() > 256) return false;
		
		int[] exists = new int[256];
		
		for (int i = 0; i < input.length(); i++) {
			int index = input.charAt(i) - 'a';
			if (exists[index] == 1) return false;
			exists[index] = 1;
		}
		return true;
	}

}
