class Solution {
    public int uniquePaths(int m, int n) {
        int[][] t = new int[m][n+1];
        return solve(m,n,t);
    }
    public static int solve(int m,int n,int[][] t){
        
        for(int i=0;i<=n;i++){
            t[0][i] = 1;
        }
        for(int i=1;i<m;i++){
            for(int j=1;j<=n;j++){
                t[i][j] = t[i-1][j]+t[i][j-1];
            }
        }
        return t[m-1][n];
        
    }
}