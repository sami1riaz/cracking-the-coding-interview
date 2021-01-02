/**
1.1 Is Unique

Implement an algorithm to determine if a string has all unique characters. What if you cannot use additional data structures?

With Additional Data Structures:
 If we are allowed to use extra data structures, we can simply use a Hash Set and store all new characters in the Set as we iterate through the string.
 If the character is already present in the set, that means the string is not unique.
 This will take O(n) time and space in the worst case where n is the number of letters in the string.
 
Without Additional Data Structures
  The naive solution without additional data structures is to use two iterators and for each letter in the string, check the entire string for
  another similar letter. This will take O(n^2) time in the worst case as we iterate the string for each letter in the string.
  
  We can improve on this by sorting the string in alphabetical order and then checking only the adjacent letters if they are unique.
  Sorting takes O(nlogn) time and checking adjacent letters requires one loop of the string so O(n). Overall, O(nlogn).
  
  I do not think this can be done in O(n) time without additional data structures.
  
But we can still improve on the solution with additional data structures and solve the questio in O(1) space and O(n) time.
	Instead of using a Hash Set, we can simply use an array where each index represents a letter and each value represents whether that letter
	is present or not.
	
	Another important thing to note is that, if the string is longer than 128 (in ASCII) or 256 (in extended ASCII), then the string cannot be unique.
	This will prevent us from iterating through extremely long strings.
	If you do not remember how many unique characters are there in ASCII or Unicode, just ask your interviewer or at least let them know that you know
	how to improve the solution.
	
**/
	
	
import java.util.Arrays;

public class isUnique {

	public static boolean check(String input) {
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
	
	public static void main(String[] args) {
		
		String test1 = "abc";
		System.out.println(check(test1));
		
		String test2 = "abcdefia";
		System.out.println(check(test2));
		
		String test3 = "abcaduhfljadhglshglshgljsdhgldsf;dksjgldsjhg;dsogsdlghdlsaghasldghalsdgh;lasugh;lsidghosifhglsadghlsdghowureghpq3ruygp943ut09378605708t5-9t 30thgijhrgh3iptu349tu3480tyo3uipti34touhroif8234yt 80u49-tu423-9tuw9uqfy3478y0438534tifddhuehfohfgksdhgfkasdhgfkhgsfkghfksjdgh";
		System.out.println(check(test3));
		
		String test4 = "";
		System.out.println(check(test4));
		
	}
}
