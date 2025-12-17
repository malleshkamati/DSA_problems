// Design a stack that supports push, pop, top, and retrieving the minimum element in constant time.

// Implement the MinStack class:

// MinStack() initializes the stack object.
// void push(int val) pushes the element val onto the stack.
// void pop() removes the element on the top of the stack.
// int top() gets the top element of the stack.
// int getMin() retrieves the minimum element in the stack.
// You must implement a solution with O(1) time complexity for each function.

package Stacks;

import java.util.Stack;

class MinStack {

    Stack<Integer> mainstk;
    Stack<Integer> minstk;

    public MinStack() {
        mainstk = new Stack<>();
        minstk = new Stack<>();
    }

    public void push(int val) {
        if (minstk.isEmpty() || val <= minstk.peek()) {
            minstk.push(val);
        } else {
            minstk.push(minstk.peek());
        }
        mainstk.push(val);
    }

    public void pop() {
        if (!mainstk.isEmpty()) {
            mainstk.pop();
            minstk.pop();
        }
    }

    public int top() {
        return mainstk.peek();
    }

    public int getMin() {
        return minstk.peek();
    }
}
