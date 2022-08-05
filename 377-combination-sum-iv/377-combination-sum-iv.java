class Solution {
    public int combinationSum4(int[] nums, int target) {
        int[] dp = new int[target+1];
        Arrays.fill(dp,-1);
        return solve(nums,target,dp);
    }
    public static int solve(int[] nums,int target,int[] dp){
        if(dp[target]!=-1){
            return dp[target];
        }
        if(target==0){
            return 1;
        }
        int res = 0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]<=target){
                res += solve(nums,target-nums[i],dp);
            }
        }
        
        dp[target] = res;
        return res;
    }
}