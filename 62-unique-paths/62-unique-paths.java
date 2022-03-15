class Solution {
    public int uniquePaths(int m, int n) {
        int[][] t = new int[m][n];
        return solve(m-1,n-1,t);
    }
    public static int solve(int m,int n,int[][] t){
        for(int i=0;i<=m;i++){
            for(int j=0;j<=n;j++){
                if(i==0 && j==0){
                    t[i][j] =1;
                }else{
                    int down=0;
                    int right=0;
                    if(i>0){
                        down = t[i-1][j];
                    }
                    if(j>0){
                        right= t[i][j-1]; 
                    }
                      t[i][j] = down+right;
                }
            }
        }
        return t[m][n];
        
    }
}