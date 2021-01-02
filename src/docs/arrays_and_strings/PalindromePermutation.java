/**

1.4 Palindrome Permutation

Given a string, write a function to check if it is a permutation of a palindrome. 
A palindrome is a word or phrase that is the same forwards and backwards. 
A permutation is a rearrangement of letters. The palindrome does not need to be limited to just dictionary words. 

EXAMPLE 
	Input: Tact Coa 
	Output: True (permutations: "taco cat'; "atco eta·; etc.)


This question might seem complicated, but basically, we need to check the number of occurrences of each char to figure out if the 
the input is a permutation of a palindrome.

A string can only be a permutation of a palindrome in the following two cases:
	If the length of the string is even, and if the number of occurrences of each character is also even
	
	If the length of the string is odd, and if the number of occurrences of all but one character is even.
	

We will need to remove the white space in the input first to make our solution simpler.

**/

import java.util.Arrays;

public class PalindromePermutation {
	
	public static boolean isPP(String input) {
		
		String s = input;
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
	
	
	public static void main (String[] args) {
		
		String s1 = "Tact Coa"; // true
		String s2 = "";      // true
		String s3 = "obb"; // true
		String s4 = "Tact Coat"; // false
		String s5 = "a"; //true
		
		System.out.println(isPP(s1));
		System.out.println(isPP(s2));
		System.out.println(isPP(s3));
		System.out.println(isPP(s4));
		System.out.println(isPP(s5));
		
	}
	
}
