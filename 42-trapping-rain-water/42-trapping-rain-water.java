class Solution {
    public int trap(int[] height) {
        
        class Pair{
            int val;
            int ind;
            Pair(int val,int ind){
                this.val = val;
                this.ind = ind;
            }
        }
        
        int[] arr1 = new int[height.length];
        int[] arr2 = new int[height.length];
        Stack<Pair> s = new Stack();
        s.push(new Pair(height[0],0));
        arr1[0] = 0;
        for(int i=1;i<height.length;i++){
            if(s.peek().val>=height[i]){
                arr1[i] = s.peek().ind;
            }else{
                arr1[i] = i;
                s.pop();
                s.push(new Pair(height[i],i));
            }
        }
        s.clear();
        s.push(new Pair(height[height.length-1],height.length-1));
        arr2[height.length-1]=height.length-1;
        for(int j=height.length-2;j>=0;j--){
            if(s.peek().val>=height[j]){
                arr2[j] = s.peek().ind;
            }else{
                arr2[j] = j;
                s.pop();
                s.push(new Pair(height[j],j));
            }
        }
        
        int ans = 0;
        for(int i=0;i<height.length;i++){
            int x = Math.min(height[arr1[i]],height[arr2[i]]);
            ans = ans + x-height[i];
        }
        
        return ans;
    }
}