package arraystring;

/**
 * Write a method to replace all spaces in a string with '%20'
 * You may assume that the string has sufficient space at the end to hold the additional characters,
 * and that you are given the "true" length of the string.
 * (Note: If implementing in Java,please use a character array so that you can perform this operation in place.)
 * <p>
 * EXAMPLE
 * Input:  "Mr John Smith    ", 13
 * Output: "Mr%20John%20Smith"
 */
class _01_03_URLify {
    public static char[] urlify(char[] url, int trueLength) {

        // find number of spaces in the original string
        int spaces = 0;
        for (int i = 0; i < trueLength;  i++) {
            if (url[i] == ' ' ) {
                spaces++;
            }
        }

        int idx = trueLength - 1  + spaces * 2;
        System.out.println("idx = " + idx + " urlLength = " + url.length );
        if (spaces == 0 || idx >= url.length) { return url;}

        for (int trueIdx = trueLength - 1; trueIdx >= 0; trueIdx--)  {
            if (url[trueIdx] == ' ') {
                url[idx] = '0';
                url[idx - 1] = '2';
                url[idx - 2] = '%';
                idx = idx - 3;
            } else {
                url[idx] = url[trueIdx];
                idx--;
            }
        }
        return url;
    }

}
