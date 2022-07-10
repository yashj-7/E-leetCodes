class Solution {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = new int[cost.length];
        Arrays.fill(dp,-1);
        return Math.min(solve(cost,0,dp),solve(cost,1,dp));
    }
    public static int solve(int[] cost,int i,int[] dp){
        if(i==cost.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int t1 = Integer.MAX_VALUE;
        int t2 = Integer.MAX_VALUE;
        if(i+1<=cost.length){
            t1 = cost[i]+solve(cost,i+1,dp);    
        }
        if(i+2<=cost.length){
            t2 = cost[i]+solve(cost,i+2,dp);
        }
        
        return dp[i]=Math.min(t1,t2);
    }
}