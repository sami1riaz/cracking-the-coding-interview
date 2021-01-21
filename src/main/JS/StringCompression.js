
/**

1.6 String Compression

Implement a method to perform basic string compression using the counts of repeated characters.
For example, the string aabcccccaaa would become a2b1c5a3.
If the "compressed" string would not become smaller than the original string, your method should return
the original string. You can assume the string has only uppercase and lowercase letters (a - z).

**/

/**
Note: From the example above, I can see that if we compress one letter we have to compress all. That is why we have "b1" in the string.
Since we only compress when adjacent letters are the same, this is possible to do in O(n) time.
We will use two pointers to compare adjacent letters. As long as the letters are same, we increment a counter.
When we find a new letter, we compress that substring, and move both pointers to the new letter.

Example 1:
pq
aabcccccaaa, count = 2 => a2
p q 
aabcccccaaa, count = 1 => a2b1
  pq
aabcccccaaa, count = 1 => a2b1
   pq
aabcccccaaa, count = 2
   p q 
aabcccccaaa, count = 3
   p  q 
aabcccccaaa, count = 4
   p   q 
aabcccccaaa, count = 5 => a2b1c5
   p    q 
aabcccccaaa, count = 1
        pq 
aabcccccaaa, count = 2
        p q 
aabcccccaaa, count = 3 => a2b1c5a3

Example2:

aab, since this wil be compressed to a2b1, we will return the original string
So once compressed, compare the lengths of the strings and return the shorter one

**/

// O(n) time and O(1) space

var stringCompression = function(str) {
	
	// no point compressing a string of 2 length.
	// compressed string will always have at least 2 chars
	if (str.length <= 2) return str;
	
	var compressed = "";
	let i = 0;
	while(i < str.length) {
		let curr = str.charAt(i);
		let j = i + 1;
		let count = 1;
		while (j < str.length) {
			if(str.charAt(j) ==  curr) {
				count++;
				j++;
			} else {
				break;
			}
		}
		i = j;
		compressed += curr + count; //
		
	}
	if (compressed.length < str.length)
		return compressed;
	else return str;
};

var assert = require('assert');
console.log("aabcccccaaa"); assert.equal("a2b1c5a3", stringCompression("aabcccccaaa"), "Test Failed");
console.log("aaa =>" + stringCompression("aaa")); 
console.log("aab =>" + stringCompression("aab")); 
console.log("abcdefg =>" + stringCompression("abcdefg")); 
console.log("\' \' =>" + stringCompression(" "));
console.log("a => " + stringCompression("a"));

