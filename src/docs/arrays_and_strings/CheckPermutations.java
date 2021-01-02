/**

1.2 Check Permutations

Given two strings, write a method to decide if one is a permutation of the other.

To determine if a string is a permutation of another, the two strings must have the same number and type of characters.
So we will need to keep track of the number of occurrences of each character in both strings.

We can do this by iterating through both strings once:
	First, we use an array to keep track of whether a character exists in string1 (s1)
	We iterate through s1 and increment the array at the character's position.
	Then we iterate through s2 and decrement the number at the character's position in the array.
	
	If the array is full of 0's in the end, then the two strings are permutations of each other.
	
This will take O(n) time to iterate both strings and O(1) time as we are using a fixed space array.

**/

public class CheckPermutations {
	
	public static boolean isPermutation(String s1, String s2) {
		
		if (s1.length() != s2.length()) return false;

        int[] occurrences = new int[256];


		// In Java, char is a numeric type ( a char is mapped to an int), so we can directly find the index of a char in an array 
		// by using the char itself as the index.

		// The following code will find the correct position of the char in our 256 length array and incrememnt the value there.
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
	
	public static void main (String[] args) {
		
		// true
		String t1 = ""; String t2 = "";
		System.out.println(isPermutation(t1,t2));
		
		//true
		String t3 = "sami"; String t4 = "imas";
		System.out.println(isPermutation(t3,t4));
		
		
		//false
		String t5 = "samii"; String t6 = "imas";
		System.out.println(isPermutation(t5,t6));
		
		//false
		String t7 = "samI"; String t8 = "imas";
		System.out.println(isPermutation(t7,t8));
		
		//true
		String t9 = "saMi"; String t10 = "iMas";
		System.out.println(isPermutation(t9,t10));
	}
	
}
