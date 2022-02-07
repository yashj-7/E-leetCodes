class MinStack {
    
    class temp{
        int val;
        int min;
        temp(int val,int min){
            this.val = val;
            this.min = min;
        }
    }

    Stack<temp> s ;
    public MinStack() {
        s = new Stack();
    }
    
    public void push(int val) {
        if(s.isEmpty()){
            //temp t = new temp(val,val);
            s.push(new temp(val,val));
        }else{
            temp t2 = s.peek();
            if(val<t2.min){
                s.push(new temp(val,val));
            }else{
                s.push(new temp(val,t2.min));
            }
        }        
    }
    
    public void pop() {
        s.pop();
    }
    
    public int top() {
        return s.peek().val;
    }
    
    public int getMin() {
        return s.peek().min;
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