// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    String s = sc.next();
                    Solution obj = new Solution();
                    System.out.println(obj.longestPalinSubseq(s));
                }
                
        }
}// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int longestPalinSubseq(String S)
    {
        int[][] dp = new int[S.length()][S.length()];
        for(int i=0;i<S.length();i++){
            Arrays.fill(dp[i],-1);
        }
        StringBuilder sb = new StringBuilder(S);
        String rev = sb.reverse().toString();
        return solve(S.length()-1,rev.length()-1,S,rev,dp);
        
    }
    public static int solve(int i,int j,String s1,String s2,int[][] dp){
        if(i<0 || j<0){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        int t1 =0;
        int t2 =0;
        if(s1.charAt(i)==s2.charAt(j)){
            t1 = 1+solve(i-1,j-1,s1,s2,dp);
        }else{
            t1 = solve(i-1,j,s1,s2,dp);
            t2 = solve(i,j-1,s1,s2,dp);
        }
        return dp[i][j]=Math.max(t1,t2);
    }
}