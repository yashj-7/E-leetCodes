// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String inline[] = in.readLine().trim().split("\\s+");
            int n = Integer.parseInt(inline[0]);
            int m = Integer.parseInt(inline[1]);
            String inline1[] = in.readLine().trim().split("\\s+");
            int M[][] = new int[n][m];
            for(int i = 0;i < n*m;i++){
                M[i/m][i%m] = Integer.parseInt(inline1[i]);
            }
            
            Solution ob = new Solution();
            System.out.println(ob.maxGold(n, m, M));
        }
    }
} // } Driver Code Ends


//User function Template for Java

class Solution{
    static int maxGold(int n, int m, int M[][])
    {
        int max = 0;
        
        boolean[][] temp = new boolean[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(temp[i],false);
        }
        int[][] dp = new int[n][m];
        for(int i=0;i<n;i++){
            Arrays.fill(dp[i],-1);    
        }
        
        for(int i=0;i<M.length;i++){
            max = Math.max(max,solve(i,0,M,temp,dp));
        }
        
        // int[][] dp = new int[n+2][m+2];
        // for(int i=0;i<dp.length;i++){
        //     dp[0][i]=0;
        // }
        // for(int i=0;i<dp[0].length;i++){
        //     dp[i][0]=0;
        // }
        // for(int i=n+1;i>=0;i--){
        //     dp[i][m+1] = 0;
        // }
        // for(int i=m+1;i>=0;i--){
        //     dp[n+1][i] = 0;
        // }
        // // for(int i=0;i<dp.length;i++){
        // //     for(int j=0;j<dp[0].length;j++){
        // //         System.out.print(dp[i][j]+" ");
        // //     }
        // //     System.out.println();
        // // }
        // for(int i=1;i<dp.length-1;i++){
        //     for(int j=1;j<dp[0].length-1;j++){
        //         dp[i][j] = Math.max(M[i-1][j-1]+dp[i-1][j+1],Math.max(M[i-1][j-1]+dp[i][j+1],M[i-1][j-1]+dp[i+1][j+1]));
        //     }
        // }
        
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         max = Math.max(max,dp[i][j]);
        //     }
        // }
        
        // for(int i=2;i<dp.length-1;i++){
        //     for(int j=1;j<dp[0].length-1;j++){
        //         dp[i][j] = Math.max(M[i-1][j-1]+dp[i-1][j+1],Math.max(M[i-1][j-1]+dp[i][j+1],M[i-1][j-1]+dp[i+1][j+1]));
        //     }
        // }
        
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         max = Math.max(max,dp[i][j]);
        //     }
        // }
        
        // for(int i=3;i<dp.length-1;i++){
        //     for(int j=1;j<dp[0].length-1;j++){
        //         dp[i][j] = Math.max(M[i-1][j-1]+dp[i-1][j+1],Math.max(M[i-1][j-1]+dp[i][j+1],M[i-1][j-1]+dp[i+1][j+1]));
        //     }
        // }
        
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         max = Math.max(max,dp[i][j]);
        //     }
        // }
        
        // for(int i=0;i<dp.length;i++){
        //     for(int j=0;j<dp[0].length;j++){
        //         System.out.print(dp[i][j]+" ");
        //     }
        //     System.out.println();
        // }
        return max;
    }
    public static int solve(int i,int j,int[][] m,boolean[][] temp,int[][] dp){
        if(i<0 || i>m.length-1 || j<0 || j>m[0].length-1 || temp[i][j]==true){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        temp[i][j] = true;
        int t1 = m[i][j]+solve(i-1,j+1,m,temp,dp);
        int t2 = m[i][j]+solve(i,j+1,m,temp,dp);
        int t3 = m[i][j]+solve(i+1,j+1,m,temp,dp);
        temp[i][j] = false;
        return dp[i][j]=Math.max(t1,Math.max(t2,t3));
    }
}