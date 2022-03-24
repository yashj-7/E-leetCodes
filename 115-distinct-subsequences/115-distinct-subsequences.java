class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<dp[0].length;i++){
            dp[0][i] = 0;
        }
        for(int i=0;i<dp.length;i++){
            dp[i][0] = 1;
        }
       for(int i=1;i<dp.length;i++){
           for(int j=1;j<dp[0].length;j++){
               if(s.charAt(i-1)==t.charAt(j-1)){
                   dp[i][j] = dp[i-1][j-1]+dp[i-1][j];
               }else{
                   dp[i][j] = dp[i-1][j];
               }
           }
       }
        return dp[s.length()][t.length()];
    }
    public static int solve(String s, String t,int ind1,int ind2,int[][] dp){
        if(ind2<0){
            return 1;
        }
        if(ind1<0){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        int pick =0;
        int notpick = 0;
        if(s.charAt(ind1)==t.charAt(ind2)){
            pick = solve(s,t,ind1-1,ind2-1,dp);
            notpick = solve(s,t,ind1-1,ind2,dp);
        }else{
            notpick = solve(s,t,ind1-1,ind2,dp);    
        }
        
        return dp[ind1][ind2]=pick+notpick;
    }
}