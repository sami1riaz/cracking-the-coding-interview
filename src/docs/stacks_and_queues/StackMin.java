package stacks_and_queues;
/**
3.2 Stack Min

How would you design a stack which, in addition to push and pop, has a function min which returns the minimum element? 
Push, pop and min should all operate in 0(1) time.


push() and pop() are already O(1) time in Java. min() is the tricky part because if the min value is not on top of the stack, we will need more than 1 time.

To deal with this, we will use 2 stacks. One as a regular stack, and one that just stores minimum values.

When we push an element, we check if it is smaller than the previous minimum number, 
if yes, we push that number to the minStack as well.
The min() function will just return the top of the minStack.
**/

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.EmptyStackException;

public class StackMin {
	
	Deque<Integer> stack = new ArrayDeque<>();
	ArrayDeque<Integer> minStack = new ArrayDeque<>();
	
	void push(int value){
		stack.push(value);
		if(minStack.isEmpty() || minStack.peek() > value) {
			minStack.push(value);
		}
	}
	
	int pop() {
		if (stack.isEmpty()) {
            throw new EmptyStackException();
        } else {
			int popped = stack.pop();
			if (popped == minStack.peek()) {
				minStack.pop();
			}
			return popped;
		}
	}
	
	int min(){
		if (minStack.isEmpty()) {
            throw new EmptyStackException();
        } else {
			return minStack.peek();
		}
	}
}

