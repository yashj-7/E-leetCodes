class Solution {
    public int jump(int[] nums) {
        int[] dp = new int[nums.length];
        Arrays.fill(dp,-1);
        return solve(nums,0,dp);
    }
    public static int solve(int[] nums,int i,int[] dp){
        if(i>=nums.length-1){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int min=(int)1e9;
        for(int j=1;j<=nums[i];j++){
            int x = 1+ solve(nums,i+j,dp);
            min = Math.min(min,x);
        }
        return dp[i]=min;
    }
}