class Solution {
    public int maxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][prices.length];
        for(int i=0;i<prices.length;i++){
            for(int j=0;j<2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(prices,false,-1,0,dp);
    }
    public static int solve(int[] prices,boolean lastSold,int lastBought,int i,int[][][] dp){
        if(i==prices.length-1){
            if(lastSold){
                return 0;
            }
            if(lastBought!=-1 && prices[i]-prices[lastBought]>=0){
                return prices[i]-prices[lastBought];
            }else{
                return 0;
            }
        }
        if(lastSold==false){
            if(lastBought!=-1 && dp[i][0][lastBought]!=-1){
                return dp[i][0][lastBought];
            }
        }else{
           if(lastBought!=-1 && dp[i][1][lastBought]!=-1){
                return dp[i][1][lastBought];
            } 
        }
        int x = Integer.MIN_VALUE;
        int y = Integer.MIN_VALUE;
        if(lastSold){
            x = solve(prices,false,-1,i+1,dp);
        }
        else if(lastBought!=-1 && prices[i]-prices[lastBought]>0){
            x = prices[i]-prices[lastBought]+solve(prices,true,-1,i+1,dp);
            y = solve(prices,false,lastBought,i+1,dp);
        }else if(lastBought==-1){
            x = solve(prices,false,i,i+1,dp);
            y = solve(prices,false,-1,i+1,dp);
        }
        if(lastSold==false && lastBought!=-1){
            dp[i][0][lastBought] = Math.max(x,y);
        }
        else if(lastSold==true && lastBought!=-1){
            dp[i][1][lastBought] = Math.max(x,y);
        }
        return Math.max(x,y);
    }
}