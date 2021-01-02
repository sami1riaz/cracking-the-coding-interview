package recursivedp;

/**
 * Magic Index: A magic index in an array A[0...n-1] is defined to be an index such that A[i] = i.
 * Given a sorted array of distinct integers, write a method to find a magic index, if one exists, in array A.
 */
class _08_03_MagicIndex {

    // This solution works for both distinct and non-distinct integers
    // O(logn) time
    int findMagicIndex(int[] arr) {
        return magicIndex(arr, 0, arr.length - 1);
    }

    int magicIndex(int[] arr, int start, int end) {
        // if binary search finishes, return -1
        if (end < start) {
            return -1;
        }

        int midIndex = end + start / 2;
        int midValue = arr[midIndex];
        if (midIndex == midValue) {
            return midIndex;
        }
        // Search right side
        int rightIndex = Math.min(midIndex + 1, midValue);
        int right = magicIndex(arr, rightIndex, end);
        if (right > 0) {
            return right;
        }

        // Search left side
        int leftIndex = Math.min(midIndex - 1, midValue);
        int left = magicIndex(arr, start, leftIndex);

        return left;
    }
}
