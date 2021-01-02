package stackqueue;

import java.awt.image.AreaAveragingScaleFilter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.EmptyStackException;

class _03_03_StackOfPlates {

    private final ArrayList<ArrayDeque<Integer>> setOfStacks;
    private final int threshold;


    _03_03_StackOfPlates(int threshold) {
        setOfStacks = new ArrayList<>(threshold);
        this.threshold = threshold;
    }


    void push(int val) {
        if (setOfStacks.isEmpty() || getLast().size() == threshold) {
            setOfStacks.add(new ArrayDeque<>());
        }
        getLast().push(val);
    }

    ArrayDeque<Integer> getLast() {
        return setOfStacks.get(setOfStacks.size() - 1);
    }

    int pop() {
        if (setOfStacks.isEmpty()) {
            throw new EmptyStackException();
        }
        ArrayDeque<Integer> curr = getLast();
        int popped = curr.pop();
        if (curr.isEmpty()) {
            setOfStacks.remove(setOfStacks.size() - 1);
        }
        return popped;

    }



   /* int popAt(int stackNum) {
        throw new UnsupportedOperationException();
    }

    */

}
