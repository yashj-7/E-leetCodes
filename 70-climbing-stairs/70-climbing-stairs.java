class Solution {
    public int climbStairs(int n) {
        int[] dp = new int[n];
        Arrays.fill(dp,-1);
        return solve(0,n,dp);
    }
    public static int solve(int i,int n,int[] dp){
        
        if(i==n){
            return 1;
        }
        if(i>n){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int x = solve(i+1,n,dp);
        int y = solve(i+2,n,dp);
        return dp[i]=x+y;
    }
}