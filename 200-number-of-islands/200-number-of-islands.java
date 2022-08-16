class Solution {
    public int numIslands(char[][] grid) {
        int[][] vis = new int[grid.length][grid[0].length];
        int count = 0;
        for(int i=0;i<grid.length;i++){
            for(int j=0;j<grid[0].length;j++){
                if(grid[i][j]=='1'){
                    if(vis[i][j]==0){
                        count++;
                        dfs(i,j,vis,grid);
                    }
                }
                
            }
        }
        return count;
    }
    public static void dfs(int i,int j,int[][] vis,char [][] grid){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length){
            return ;
        }
        if(vis[i][j]==1){
            return;
        }
        if(grid[i][j]=='0'){
            return ;
        }
        vis[i][j]=1;
        dfs(i+1,j,vis,grid);
        dfs(i,j+1,vis,grid);
        dfs(i,j-1,vis,grid);
        dfs(i-1,j,vis,grid);
    }
}