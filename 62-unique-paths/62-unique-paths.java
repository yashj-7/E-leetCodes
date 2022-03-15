class Solution {
    public int uniquePaths(int m, int n) {
        int[][] t = new int[m+1][n+1];
        for(int i=0;i<m;i++){
            Arrays.fill(t[i],-1);
        }
        return solve(0,0,m,n,t);
    }
    public static int solve(int i,int j,int m,int n,int[][] t){
        if(t[i][j]!=-1){
            return t[i][j];
        }
        if(i==m-1 || j==n-1){
            return t[i][j]=1;
        }
        if(i>=m || j>=n){
            return t[i][j]=0;
        }
        //System.out.print(i,j);
        int l = solve(i+1,j,m,n,t);
        int r = solve(i,j+1,m,n,t);
        return t[i][j]=l+r;
    }
}