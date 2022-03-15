class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] t = new int[obstacleGrid.length][obstacleGrid[0].length];
        for(int i=0;i<obstacleGrid.length;i++){
            Arrays.fill(t[i],-1);
        }
        return solve(obstacleGrid.length-1,obstacleGrid[0].length-1,obstacleGrid,t);
    }
    public static int solve(int i,int j,int[][] grid,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(grid[i][j]==1){
            return 0;
        }
        if(i==0 && j==0){
            return 1;
        }
        if(dp[i][j] !=-1){
            return dp[i][j];
        }
        int up = solve(i-1,j,grid,dp);
        int left = solve(i,j-1,grid,dp);
        return dp[i][j]=up+left;
        
    }
}