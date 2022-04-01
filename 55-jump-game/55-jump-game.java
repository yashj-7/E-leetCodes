class Solution {
    public boolean canJump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
       return solve(nums,0,dp); 
    }
    public static boolean solve(int[] nums,int i,int[] dp){
        if(i==nums.length-1){
            return true;
        }
        if(dp[i]!=-1){
            if(dp[i]==0){
                return false;
            }
            return true;
        }
        if(i>nums.length-1){
            return false;
        }
        boolean ans = false;
        for(int j=1;j<=nums[i];j++){
            ans = solve(nums,i+j,dp);
            if(ans==true){
                break;
            }
        }
        if(ans==true){
            dp[i]=1;
        }else{
            dp[i]=0;
        }
        return ans;
    }
}