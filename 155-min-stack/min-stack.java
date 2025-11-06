class MinStack {

    private Stack<Long> stack;  // Stores values or markers
    private long min;           // Tracks current minimum

    /** Initialize your data structure. */
    public MinStack() {
        stack = new Stack<>();
        min = Long.MAX_VALUE;
    }

    /** Push element onto the stack. */
    public void push(int val) {
        long value = val;
        if (stack.isEmpty()) {
            min = value;
            stack.push(value);
        } else if (value >= min) {
            stack.push(value);
        } else {
            // New minimum → push marker and update min
            stack.push(2 * value - min);
            min = value;
        }
    }

    /** Remove the top element from the stack. */
    public void pop() {
        if (stack.isEmpty()) return;
        long top = stack.pop();
        if (top < min) {
            // Restore previous minimum
            min = 2 * min - top;
        }
    }

    /** Get the top element. */
    public int top() {
        if (stack.isEmpty()) return -1;
        long top = stack.peek();
        return (int) (top < min ? min : top);
    }

    /** Retrieve the minimum element. */
    public int getMin() {
        return stack.isEmpty() ? -1 : (int) min;
    }
}