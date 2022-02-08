class StockSpanner {
    class pair{
        int val1;
        int val2;
        pair(int val1,int val2){
            this.val1 = val1;
            this.val2 = val2;
        }
    }
    Stack<pair> s;
    public StockSpanner() {
        s = new Stack();
    }
    
    public int next(int price) {
        int count =1;
        if(s.isEmpty()){
            s.push(new pair(price,count));
            return count;
        }else{
            if(s.peek().val1>price){
                s.push(new pair(price,1));
                return 1;
            }else if(s.peek().val1<=price){
                while(s.isEmpty()==false && s.peek().val1<=price){
                   count = count+s.peek().val2;
                    s.pop(); 
                }
                s.push(new pair(price,count));
                return count;
            }
        }
        return count;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner();
 * int param_1 = obj.next(price);
 */