class MyQueue {
    Stack<Integer> q1 = new Stack<>();
    Stack<Integer> q2 = new Stack<>();
    
    // Push element x to the back of queue.
    public void push(int x) {
        q1.push(x);
    }

    // Removes the element from in front of queue.
    public void pop() {
        if(!q2.isEmpty()) q2.pop();
        else{
            while(!q1.isEmpty()) q2.push(q1.pop());
            q2.pop();
        }
    }

    // Get the front element.
    public int peek() {
        //if(!q2.isEmpty()) return q2.peek;
        if(!q2.isEmpty()) return q2.peek();
        else{
            while(!q1.isEmpty()) q2.push(q1.pop());
            //return q2.pop();
            return q2.peek();
        }
    }

    // Return whether the queue is empty.
    public boolean empty() {
        return q1.empty() && q2.empty();
    }
}