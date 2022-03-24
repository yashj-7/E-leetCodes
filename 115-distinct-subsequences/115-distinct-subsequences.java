class Solution {
    public int numDistinct(String s, String t) {
        int[][] dp = new int[s.length()+1][t.length()+1];
        for(int i=0;i<s.length()+1;i++){
            for(int j=0;j<t.length()+1;j++){
                dp[i][j] =-1;
            }
        }
        return solve(s,t,0,0,dp);
    }
    public static int solve(String s, String t,int ind1,int ind2,int[][] dp){
        if(ind2>t.length()-1){
            return 1;
        }
        if(ind1>s.length()-1){
            return 0;
        }
        if(dp[ind1][ind2]!=-1){
            return dp[ind1][ind2];
        }
        int pick =0;
        int notpick = 0;
        if(s.charAt(ind1)==t.charAt(ind2)){
            pick = solve(s,t,ind1+1,ind2+1,dp);
            notpick = solve(s,t,ind1+1,ind2,dp);
        }else{
            notpick = solve(s,t,ind1+1,ind2,dp);    
        }
        
        return dp[ind1][ind2]=pick+notpick;
    }
}