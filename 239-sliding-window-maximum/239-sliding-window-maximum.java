class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        class Pair{
            int val;
            int ind;
            Pair(int val,int ind){
                this.val = val;
                this.ind = ind;
            }
        }
        if(k==1){
            return nums;
        }
        int[] arr = new int[nums.length];
        Stack<Pair> s = new Stack<>();
        s.push(new Pair(nums[nums.length-1],nums.length-1));
        arr[nums.length-1] = nums.length;
        for(int j=nums.length-2;j>=0;j--){
            if(nums[j]<s.peek().val){
                arr[j] = s.peek().ind;
                s.push(new Pair(nums[j],j));
            }else {
                while(s.isEmpty()==false && s.peek().val<=nums[j]){
                    s.pop();
                }
                if(s.isEmpty()){
                    arr[j] = nums.length;
                }else{
                    arr[j] = s.peek().ind;
                }
                s.push(new Pair(nums[j],j));
            }
        }
        
        int[] res = new int[nums.length-k+1];
        int j=0;
        int flag = 0;
        for(int i=0;i<nums.length-k+1;i++){
            j=i;
            while(arr[j]<=i+k-1){
                j=arr[j];
                flag =1;
            }
             res[i] = nums[j];
            
        }
        
        return res;
    }
}