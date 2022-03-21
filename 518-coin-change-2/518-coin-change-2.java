class Solution {
    public int change(int amount,int[] coins) {
        
        int[][] dp = new int[coins.length+1][amount+1];
        for(int i=0;i<amount+1;i++){
            dp[0][i] =0;
        }
        for(int i=0;i<coins.length+1;i++){
            dp[i][0] = 1;
        }
        
        for(int i=1;i<coins.length+1;i++){
            for(int j=1;j<amount+1;j++){
                int x1 = 0;
                int x2 = 0;
                if(coins[i-1]>j){
                    x1 = dp[i-1][j];
                }else{
                    x2 = dp[i][j-coins[i-1]];
                    x1 = dp[i-1][j];
                }
                dp[i][j] = x1+x2;
            }
        }
        return dp[coins.length][amount];
    }
}