class Solution {
    public int maximalSquare(char[][] matrix) {
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i=0;i<matrix.length;i++){
            dp[i][0] = Character.getNumericValue(matrix[i][0]); 
        }
        for(int i=0;i<matrix[0].length;i++){
            dp[0][i] = Character.getNumericValue(matrix[0][i]);
        }
        for(int i=1;i<matrix.length;i++){
            for(int j=1;j<matrix[0].length;j++){
                if(matrix[i][j]=='0'){
                    dp[i][j]=0;
                }else{
                    dp[i][j] = Math.min(dp[i-1][j-1],Math.min(dp[i-1][j],dp[i][j-1]))+1;
                }
            }
        }
        int ans =0;
        for(int i=0;i<matrix.length;i++){
            for(int j=0;j<matrix[0].length;j++){
                ans = Math.max(ans,dp[i][j]);
            }
        }
        return ans*ans;
    }
}