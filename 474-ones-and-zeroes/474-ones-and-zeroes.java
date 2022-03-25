class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][][] dp = new int[strs.length+1][m+1][n+1];
        for(int i=0;i<strs.length+1;i++){
            for(int j=0;j<m+1;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(strs,0,m,n,dp);
    }
    public int solve(String[] strs,int ind,int m,int n,int[][][] dp){
        if(ind==strs.length){
            return 0;
        }
        if(dp[ind][m][n]!=-1){
            return dp[ind][m][n];
        }
        if(m==0 && n==0){
            return 0;
        }
        String s = strs[ind];
        int count1 = 0;
        int count0 = 0;
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='1'){
                count1++;
            }else{
                count0++;
            }
        }
        int pick = (int)-1e9;
        int notpick = (int)-1e9;
        if(count1<=n && count0<=m){
            pick = 1+solve(strs,ind+1,m-count0,n-count1,dp);
            notpick = solve(strs,ind+1,m,n,dp);
        }else{
            notpick = solve(strs,ind+1,m,n,dp);
        }
        return dp[ind][m][n]=Math.max(pick,notpick);
    }
}