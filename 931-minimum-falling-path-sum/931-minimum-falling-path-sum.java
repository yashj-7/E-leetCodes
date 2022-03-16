class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int mini =Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int j=0;j<matrix[0].length;j++){
            mini = Math.min(mini,solve(matrix.length-1,j,matrix,dp));
        }
        return mini;
    }
    public int solve(int i,int j,int[][] m,int[][] dp){
        if(j<0 || j>=m[0].length){
            return (int)1e9;
        }
        if(i==0){
            return m[i][j];
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int ch1 = m[i][j] + solve(i-1,j-1,m,dp);
        int ch2 = m[i][j] + solve(i-1,j,m,dp);
        int ch3 = m[i][j] + solve(i-1,j+1,m,dp);
        return dp[i][j]=Math.min(ch1,Math.min(ch2,ch3));
    }
}