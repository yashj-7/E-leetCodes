class Solution {
    public int cherryPickup(int[][] grid) {
        int[][][][] dp = new int[grid.length][grid.length][grid.length][grid.length];
        int x=solve(0,0,0,0,grid,dp);
        if(x<=-1e9){
            return 0;
        }
        return x;
    }
    public int solve(int i1,int j1,int i2,int j2,int[][] m,int[][][][] dp){
        if(i1>m.length-1 || i2>m.length-1 || j1>m[0].length-1 || j2>m[0].length-1 || m[i1][j1]==-1 || m[i2][j2]==-1){
            return Integer.MIN_VALUE;
        }
        if(dp[i1][j1][i2][j2]!=0){
            return dp[i1][j1][i2][j2];
        }
        if(i1==m.length-1 && j1==m.length-1){
            return m[i1][j1];
        }
        int value = 0;
        if(j1==j2){
            value = m[i1][j1];
        }else{
            value = m[i1][j1]+m[i2][j2];
        }
        int f1 = value + solve(i1+1,j1,i2+1,j2,m,dp);
        int f2 = value + solve(i1+1,j1,i2,j2+1,m,dp);
        int f3 = value + solve(i1,j1+1,i2,j2+1,m,dp);
        int f4 = value + solve(i1,j1+1,i2+1,j2,m,dp);
        return dp[i1][j1][i2][j2]=Math.max(Math.max(f1,f2),Math.max(f3,f4));
    }
}