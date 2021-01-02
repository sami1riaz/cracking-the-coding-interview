package stackqueue;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

/**
 * How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? Push, pop and min should all operate in 0(1) time.
 */
class _03_02_MinStack {

    private ArrayDeque<Integer> myStack = new ArrayDeque<>();
    private ArrayDeque<Integer> mins = new ArrayDeque<>();


    void push(int val) {
        if (mins.isEmpty() || val < mins.peek()) {
            mins.push(val);
        }
        myStack.push(val);
    }

    int pop() {
        if (myStack.isEmpty()) {
            throw new EmptyStackException();
        } else {
            int popped = myStack.pop();
            if (popped == mins.peek()) {
                mins.pop();
            }
            return popped;
        }
    }

    int min() {
        if (mins.isEmpty()) {
            throw new EmptyStackException();
        } else {
            return mins.peek();
        }
    }
}
