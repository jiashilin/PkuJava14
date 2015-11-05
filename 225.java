class MyStack {
    
    List<Integer> s = new ArrayList<>();
    
    // Push element x onto stack.
    public void push(int x) {
        s.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        if(!empty()){
            s.remove(s.size()-1);
        }
    }

    // Get the top element.
    public int top() {
        if(!empty()){
            return s.get(s.size()-1);
        }
        return -1;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        if(s.size() == 0) return true;
        return false;
    }
}