/**
225. Implement Stack using Queues
We rotate the queue after every push to make sure the top of the stack is always at the front of the queue.

push: O(n)

pop: O(1)

top: O(1)

empty: O(1)
 */

class MyStack {
    Queue<Integer> q;
    public MyStack() {
        q = new LinkedList();
    }
    
    public void push(int x) {
        q.offer(x);
        int size = q.size();
        for(int j = 0;j<size-1;j++){
            q.offer(q.poll());
        }
    }
    
    public int pop() {
        return q.poll();
    }
    
    public int top() {
        return q.peek();
    }
    
    public boolean empty() {
        return q.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */
