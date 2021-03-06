class Solution {
    public int minPathSum(int[][] grid) {
        int[][] dp = new int[grid.length][grid[0].length];
        return solve(grid,dp);
    }
    public int solve(int[][] grid,int[][] dp){
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0){
                    dp[i][j] = grid[i][j];
                }else{
                    int up=0;
                    int left = 0;
                    if(i>0){
                        up = grid[i][j]+dp[i-1][j];
                    }else{
                        up = (int)1e9;
                    }
                    if(j>0){
                        left = grid[i][j]+dp[i][j-1];
                    }else{
                        left = (int)1e9;
                    }
                    dp[i][j] = Math.min(up,left);
                }
            }
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}