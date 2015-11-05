class MyStack {
   Queue<Integer> q1=new LinkedList<Integer>();
	Queue<Integer> q2=new LinkedList<Integer>();
    // Push element x onto stack.
    public void push(int x) {
    	 if (q1.isEmpty())  
         {  
             q1.add(x);  
             while(!q2.isEmpty()){  
                 int temp = q2.peek();  
                 q2.remove();  
                 q1.add(temp);  
             }  
         }else{  
             q2.add(x);  
             while(!q1.isEmpty()){  
                 int temp = q1.peek();  
                 q1.remove();  
                 q2.add(temp);  
             }  
         }  
    }

    // Removes the element on top of the stack.
    public void pop() {
    	 if (!q1.isEmpty())  
             q1.remove();  
         if (!q2.isEmpty())  
             q2.remove();  
    }

    // Get the top element.
    public int top() {
    	int temp = 0;
    	if (!q1.isEmpty())  
    		temp=q1.peek();  
        if (!q2.isEmpty())  
        	temp=q2.peek(); 
        return temp;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        boolean falg=true;
        if(q1.isEmpty()&&q2.isEmpty()){
            falg=true;   
        }else{
            falg=false;
        }
        return falg;
    }
}