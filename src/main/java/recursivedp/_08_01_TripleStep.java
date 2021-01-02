package recursivedp;

import java.util.*;

/**
 * A child is running up a staircase with n steps and can hop either 1 step, 2 steps, or 3 steps at a time.
 * Implement a method to count how many possible ways the child can run up the stairs.
 */
class _08_01_TripleStep {

    ///////////// NAIVE Top-Down Approach /////////////////////
    // The child must end up exactly at te top step for a combination to be valid.

    // since this method is making 3 different recursive calls in each call
    // it takes O(3^n) time and space
//    int countWays(int steps) {
//
//        // we can move backwards from the top step and see if the child starts at the bottom.
//        // from the top, we can take 1, 2, or 3 steps backwards.
//
//        // base case 1
//        // if we end up "behind" the first step, we return 0 (not a possible combination)
//        if (steps < 0) {
//            return 0;
//        }
//        // base case 2: we end up exactly at the bottom of the stairs, we increment our combinations
//        else if (steps == 0) {
//            return 1;
//        }
//        // otherwise we try taking, 1, 2, or 3 steps backwards.
//        else {
//            return countWays(steps - 1) + countWays(steps - 2) + countWays(steps - 3);
//        }
//    }
//
    //////////// Optimizing top-down with Memoization ///////////
    // we can improve the above solution with memoization
    int countWays(int steps) {

        // memo
        int[] memo = new int[steps + 1];
        // we need to fill with -1 because a valid value will be >= 0
        // so if value is > -1, then that means we have already calculated this result.
        Arrays.fill(memo, -1);
        return countWays(steps, memo);
    }

    int countWays(int steps, int[] memo) {
        // base case 1
        // if we end up "behind" the first step, we return 0 (not a possible combination)
        if (steps < 0) {
            return 0;
        }
        // base case 2: we end up exactly at the bottom of the stairs, we increment our combinations
        else if (steps == 0) {
            return 1;
        }
        // check if the result is already saved first:
        else if (memo[steps] > -1) {
            return memo[steps];
        }
        // otherwise we try storing the result of taking 1, 2, or 3 steps backwards.
        else {
            memo[steps] = countWays(steps - 1, memo) + countWays(steps - 2, memo) + countWays(steps - 3, memo);
            return memo[steps];
        }
    }
}
