class Solution {
    public int numberOfWays(int startPos, int endPos, int k) {
        int[][] dp = new int[3000][k+1];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(startPos,endPos,k,dp);
    }
    public static int solve(int start,int end,int k,int[][]dp){
        if(k==0){
            if(start==end){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[start+1000][k]!=-1){
            return dp[start+1000][k];
        }
        int t1 = solve(start-1,end,k-1,dp);
        int t2 = solve(start+1,end,k-1,dp);
        return dp[start+1000][k]=(t1+t2)%1000000007;
    }
}