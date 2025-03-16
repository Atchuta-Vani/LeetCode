/**
155. Min Stack
approach: maintain a minstack that holds minimum value. regular stack for holding values. 
Push - value is pushed to stack, if val is <= top value of minStack, push the value to minStack.
Pop - if popped value is top of min value, pop top of minStack as well.
 */

class MinStack {

    Stack<Integer> minStack;
    Stack<Integer> stack;

    public MinStack() {
        minStack = new Stack<Integer>();
        stack = new Stack<Integer>();
    }
    
    public void push(int val) {
        stack.push(val);
        if(minStack.size() == 0 || val <= minStack.peek() ){ //<= is must here otherwise, minstack will not have repeated number and will give error when we try to getMin
            minStack.push(val);
        }
        
    }
    
    public void pop() {
        int val = stack.pop();
        if(minStack.size() > 0 && minStack.peek() == val){
            minStack.pop();
        }        
    }
    
    public int top() {
        return stack.peek();
        
    }
    
    public int getMin() {

        return minStack.peek();
        
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
