class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<coins.length+1;i++){
            Arrays.fill(dp[i],-1);
        }
        
        int ans = solve(coins,amount,coins.length-1,dp);
        
        if(ans>=(int)1e9){
            return -1;
        }
        return ans;
    }
    public int solve(int[] coins,int amount,int index,int[][] dp){
        if(amount<0){
            return (int)1e9;
        }
        if(amount==0){
            return 0;
        }
        if(index<0){
            
            return (int)1e9;
        }
        if(dp[index][amount]!=-1){
            return dp[index][amount];
        }
        int pick = 1+solve(coins,amount-coins[index],index,dp);
        int notpick = solve(coins,amount,index-1,dp);
        return dp[index][amount] =Math.min(pick,notpick);
    }
}