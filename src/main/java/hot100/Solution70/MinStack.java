package hot100.Solution70;

import java.util.ArrayDeque;
import java.util.Deque;

public class MinStack {

    private Deque<Integer> stack;
    private Deque<Integer> minValue;

    public MinStack() {
        stack = new ArrayDeque<>();
        minValue = new ArrayDeque<>();
    }

    public void push(int val) {
        stack.push(val);
        if (minValue.isEmpty() || val < minValue.peek()) {
            minValue.push(val);
        } else {
            minValue.push(minValue.peek());
        }
    }

    public void pop() {
        stack.pop();
        minValue.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return minValue.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(val);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */