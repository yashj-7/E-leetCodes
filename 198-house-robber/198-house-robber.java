class Solution {
    public int rob(int[] nums) {
        int[] t = new int[nums.length+1];
        return solve(0,nums,t);
    }
    public static int solve(int index,int[] nums,int t[]){
        
        t[0] = 0;
        t[1]=nums[0];
        for(int i=2;i<nums.length+1;i++){
             	t[i] = Math.max(nums[i-1]+t[i-2],t[i-1]);   
        }
        return t[nums.length];
    }
}