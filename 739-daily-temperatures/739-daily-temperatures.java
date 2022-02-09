class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        
        class helper{
            int val;
            int index;
            helper(int val,int index){
                this.val = val;
                this.index = index;
            }
        }
        
        Stack<helper> s = new Stack();
        int[] arr = new int[temperatures.length];
        for(int i=0;i<temperatures.length;i++){
            if(i==0){
                s.push(new helper(temperatures[i],i));
            }else{
                if(!s.isEmpty() && temperatures[i]<s.peek().val){
                    s.push(new helper(temperatures[i],i));
                }else{
                    while(s.isEmpty()==false && temperatures[i]>s.peek().val){
                        arr[s.peek().index]=i-s.peek().index;
                        s.pop();
                    }
                    s.push(new helper(temperatures[i],i));
                }
            }
        }
        // while(s.isEmpty()==false){
        //     arr[s.pop().index]=0;
        // }
        return arr;
    }
}