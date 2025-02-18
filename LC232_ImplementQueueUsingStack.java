// 232 Implement Quue using 2 stacks. 
// use two stacks input and output. 
/**inputStack: Used to push elements.
outputStack: Used for dequeuing (pop/peek operations).
Algorithm:
Push operation (push(x)):

Simply push x onto inputStack.
Pop operation (pop()):

If outputStack is empty, transfer all elements from inputStack to outputStack (this reverses the order to maintain FIFO).
Pop the top element from outputStack.
Peek operation (peek()):

If outputStack is empty, transfer all elements from inputStack to outputStack.
Return the top element

Complexity. for Pop and peek, it is O(n). for push O(1)
*/

class MyQueue {
    Stack<Integer> input = new Stack<Integer>();
    Stack<Integer> output = new Stack<Integer>();

    public MyQueue() {
        
    }
    
    public void push(int x) {
        input.push(x);
        
    }
    
    public int pop() {
        if(output.isEmpty()){
                 while(!input.isEmpty()){
                    output.push(input.pop());
                }
        }
            
        return output.pop();
        
    }
    
    public int peek() {
        if(output.isEmpty()){
            while(!input.isEmpty()){
                output.push(input.pop());
            }
        }

        return output.peek();
        
    }
    
    public boolean empty() {
        return input.isEmpty() && output.isEmpty();
    }
}

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
