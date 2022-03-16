class Solution {
    public int minFallingPathSum(int[][] matrix) {
        int mini =Integer.MAX_VALUE;
        int[][] dp = new int[matrix.length][matrix[0].length];
        // for(int i=0;i<dp.length;i++){
        //     Arrays.fill(dp[i],-1);
        // }
        // for(int j=0;j<matrix[0].length;j++){
        //     mini = Math.min(mini,solve(matrix.length-1,j,matrix,dp));
        // }
        return solve(matrix,dp);
    }
    public int solve(int[][] m,int[][] dp){
        // if(j<0 || j>=m[0].length){
        //     return (int)1e9;
        // }
        // if(i==0){
        //     return m[i][j];
        // }
        // if(dp[i][j]!=-1){
        //     return dp[i][j];
        // }
        // int ch1 = m[i][j] + solve(i-1,j-1,m,dp);
        // int ch2 = m[i][j] + solve(i-1,j,m,dp);
        // int ch3 = m[i][j] + solve(i-1,j+1,m,dp);
        // return dp[i][j]=Math.min(ch1,Math.min(ch2,ch3));
        
        for(int j=0;j<m[0].length;j++){
            dp[0][j] = m[0][j];   
        }
        for(int i=1;i<m.length;i++){
            for(int j=0;j<m[0].length;j++){
                int ch1=0;
                int ch2=0;
                int ch3=0;
                if(j-1>=0){
                    ch1 = m[i][j] + dp[i-1][j-1];
                }else{
                    ch1 = (int)1e9;
                }
                ch2 = m[i][j]+dp[i-1][j];
                if(j+1<m[0].length){
                    ch3 = m[i][j] + dp[i-1][j+1];
                }else{
                    ch3 = (int)1e9;
                }
                dp[i][j] = Math.min(ch1,Math.min(ch2,ch3));
            }
        }
        int mini = Integer.MAX_VALUE;
        for(int j=0;j<m[0].length;j++){
            mini = Math.min(mini,dp[m.length-1][j]);
        }
        return mini;
    }
}