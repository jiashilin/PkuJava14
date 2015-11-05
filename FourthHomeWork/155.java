class MinStack {
    private Stack<Integer> s = new Stack<Integer>();
    private Stack<Integer> smin = new Stack<Integer>();
    
    public void push(int x) {
        s.push(x);
        if(smin.empty()||smin.peek()>=x)
            smin.push(x);
    }

    public void pop() {
        if(smin.peek().equals(s.peek()))
            smin.pop();
        s.pop();
    }

    public int top() {
        return s.peek();
    }

    public int getMin() {
        return smin.peek();
    }
}
