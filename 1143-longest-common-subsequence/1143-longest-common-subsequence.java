class Solution {
    //tabulation:--
    public int longestCommonSubsequence(String text1, String text2) {
        int[][] dp = new int[text1.length()+1][text2.length()+1];
        
        for(int i=0;i<text1.length()+1;i++){
            dp[i][0] = 0; 
        }
        for(int i=0;i<text2.length()+1;i++){
            dp[0][i] = 0;
        }
        dp[0][0] =0;
        for(int i=1;i<dp.length;i++){
            for(int j=1;j<dp[0].length;j++){
                if(text1.charAt(i-1)==text2.charAt(j-1)){
                    dp[i][j] = 1+dp[i-1][j-1];
                }else{
                    dp[i][j] = Math.max(dp[i-1][j],dp[i][j-1]);
                }
            }
        }
        
        return dp[text1.length()][text2.length()];
    }
    
    //memoization:- 
    // public int solve(String s1,String s2,int ind1,int ind2,int[][] dp){
    //     if(ind1<0 || ind2<0){
    //         return 0;
    //     }
    //     if(dp[ind1][ind2]!=-1){
    //         return dp[ind1][ind2];
    //     }
    //     if(s1.charAt(ind1)==s2.charAt(ind2)){
    //         return 1+solve(s1,s2,ind1-1,ind2-1,dp);
    //     }
    //     return dp[ind1][ind2]=Math.max(solve(s1,s2,ind1-1,ind2,dp),solve(s1,s2,ind1,ind2-1,dp));
    // }
}