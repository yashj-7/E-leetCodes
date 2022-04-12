// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int Matrix[][] = new int[N][N];
            for(int i = 0; i < N*N; i++)
                Matrix[(i/N)][i%N] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.maximumPath(N, Matrix));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int maximumPath(int N, int Matrix[][])
    {
        int max = 0;
        int[][] dp = new int[Matrix.length][Matrix[0].length];
        for(int i=0;i<Matrix.length;i++){
            Arrays.fill(dp[i],-1);
        }
        for(int i=0;i<Matrix[0].length;i++){
            max = Math.max(max,solve(0,i,Matrix,dp));
        }
        return max;
    }
    public static int solve(int i,int j,int[][] mat,int[][] dp){
        if(i>mat.length-1 || j>mat[0].length-1 || i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int t1 =0;
        int t2 =0;
        int t3 =0;
        t1 = mat[i][j]+solve(i+1,j,mat,dp);
        t2 = mat[i][j]+solve(i+1,j-1,mat,dp);
        t3 = mat[i][j]+solve(i+1,j+1,mat,dp);
        return dp[i][j]=Math.max(t1,Math.max(t2,t3));
    }
}