// { Driver Code Starts
//Initial Template for Java

import java.util.*;
import java.lang.*;
import java.io.*;
class GFG
{
    public static void main(String[] args) throws IOException
    {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine().trim());
        while(T-->0)
        {
            String str = br.readLine().trim();
            Solution ob = new Solution();
            int ans = ob.LongestRepeatingSubsequence(str);
            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


//User function Template for Java

class Solution
{
    public int LongestRepeatingSubsequence(String str)
    {
        int[][] dp = new int[str.length()][str.length()];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(str,str.length()-1,str.length()-1,dp);
    }
    public static int solve(String s,int i1,int i2,int[][] dp){
        if(i1<0 || i2<0){
            return 0;
        }
        if(dp[i1][i2]!=-1){
            return dp[i1][i2];
        }
        int t1 = 0;
        int t2 = 0;
        if(s.charAt(i1)==s.charAt(i2) && i1!=i2){
            t1 = 1+solve(s,i1-1,i2-1,dp);
        }else{
            t1 = solve(s,i1-1,i2,dp);
            t2 = solve(s,i1,i2-1,dp);
        }
        return dp[i1][i2]=Math.max(t1,t2);
    }
}