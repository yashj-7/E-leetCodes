class Solution {
    public int coinChange(int[] coins, int amount) {
        
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<amount+1;i++){
            dp[0][i] =(int)1e9;
        }
        for(int i=0;i<coins.length+1;i++){
            dp[i][0] = 0;
        }
        dp[0][0] = 1;
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                int x1 = (int)1e9;
                int x2 = (int)1e9;
                if(coins[i-1]>j){
                    x1 = dp[i-1][j];
                }else{
                    x2 = 1+dp[i][j-coins[i-1]];
                    x1 = dp[i-1][j];
                }
                dp[i][j] = Math.min(x1,x2);
            }
        }
        if(dp[coins.length][amount]>=(int)1e9){
            return -1;
        }
        return dp[coins.length][amount];
//         int ans = solve(coins,amount,coins.length-1,dp);
        
//         if(ans>=(int)1e9){
//             return -1;
//         }
//         return ans;
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