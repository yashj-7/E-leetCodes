class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[][] t = new int[obstacleGrid.length][obstacleGrid[0].length];
        return solve(obstacleGrid,t);
    }
    public static int solve(int[][] grid,int[][] dp){
        
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(i==0 && j==0){
                    if(grid[0][0]==0){
                        dp[i][j]=1;
                    }else{
                        dp[i][j]=0;
                    }
                }else if(grid[i][j]==1){
                    dp[i][j] = 0;
                }else{
                    int up = 0;
                    int left = 0;
                    if(i>0){
                        up = dp[i-1][j];
                    }
                    if(j>0){
                        left = dp[i][j-1];
                    }
                    dp[i][j] = up+left;
                }
            }
        }
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                System.out.print(dp[i][j]+" ");
            }
            System.out.println();
        }
        return dp[grid.length-1][grid[0].length-1];
    }
}