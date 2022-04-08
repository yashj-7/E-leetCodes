// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            int N = Integer.parseInt(read.readLine());
            String input_line[] = read.readLine().trim().split("\\s+");
            int A[]= new int[N];
            for(int i = 0; i < N; i++)
                A[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            System.out.println(ob.longestSubsequence(N, A));
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int longestSubsequence(int N, int A[])
    {
        int[][] dp = new int[N][N];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],-1);   
        }
        return solve(0,A,-1,dp);
    }
    public static int solve(int n,int[] A,int prev,int[][] dp){
        if(n>A.length-1){
            return 0;
        }
        if(prev!=-1 && dp[n][prev]!=-1){
            return dp[n][prev];
        }
        int t1 = 0;
        int t2 = 0;
        if(prev==-1 || Math.abs(A[prev]-A[n])==1){
            t1 = 1+solve(n+1,A,n,dp);
            t2 = solve(n+1,A,prev,dp);
        }else{
            t2 = solve(n+1,A,prev,dp);
        }
        if(prev==-1){
            return Math.max(t1,t2);
        }
        return dp[n][prev]=Math.max(t1,t2);
    }
}