class Solution {
    public int findLongestChain(int[][] pairs) {
        Arrays.sort(pairs,(a,b) -> a[1] - b[1]);
        int[][] dp = new int[pairs.length][pairs.length];
        for(int i=0;i<pairs.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(0,-1,pairs,dp);
    }
    public static int solve(int i,int prev,int[][] pairs,int[][] dp){
        if(i>pairs.length-1){
            return 0;
        }
        if(prev!=-1 && dp[i][prev]!=-1){
            return dp[i][prev];
        }
        int t1 = 0;
        int t2 = 0;
        if(prev==-1 || pairs[i][0]>pairs[prev][1]){
            t1 = 1+solve(i+1,i,pairs,dp);
            t2 = solve(i+1,prev,pairs,dp);
        }else{
            t2 = solve(i+1,prev,pairs,dp);
        }
        if(prev==-1){
            return Math.max(t1,t2);
        }
        return dp[i][prev]=Math.max(t1,t2);
    }
}