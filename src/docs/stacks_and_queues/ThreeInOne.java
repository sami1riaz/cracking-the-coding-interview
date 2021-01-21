3.1 ThreeInOne

Describe how you could use a single array to implement three stacks

[1,2,3,4]

We can assign each stack a fixed space, and fit those 3 stack in an array the size of the combined 3 stacks.
for example, 3 stacks fo size 2:
[1, 2, 3, , 5, 6]
Stack 1 starts at index 0 and ends at 1.
Stack 2 starts at index 2 and ends at 3.
Stack 3 starts at index 4 and ends at 5.

We'll need a push and pop method.
For pushing, we'll need to keep track of the last index at which an element was pushed for a particular stack.
Same for popping.



public class ThreeInOne {
	
	int[] array;
	
	ThreeInOne()
	int size(int stack){
		
	}
	
	void push(int value, int stack) {
		
	}
	
	int pop(int stack) {
	}
}
