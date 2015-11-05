class MinStack {
	Stack<Integer> stack = new Stack<Integer>();
	Stack<Integer> minstack = new Stack<Integer>();

	{
		minstack.push(Integer.MAX_VALUE);
	}

	public void push(int x) {
		stack.push(x);
		if (x <= minstack.peek()) {
			minstack.push(x);
		}
	}

	public void pop() {
		if (stack.peek().equals(minstack.peek())){
			minstack.pop();
			stack.pop();
		} else {
			stack.pop();
		}
	}

	public int top() {
		return stack.peek();
	}

	public int getMin() {
		return minstack.peek();
	}
}