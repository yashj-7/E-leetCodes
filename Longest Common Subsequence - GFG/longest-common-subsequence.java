// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
	public static void main (String[] args) {

		Scanner sc=new Scanner(System.in);
		int test=sc.nextInt();
		while(test-- > 0){
		    int p=sc.nextInt();             // Take size of both the strings as input
		    int q=sc.nextInt();
		    
		    String s1=sc.next();            // Take both the string as input
	        String s2=sc.next();
		    
		    Solution obj = new Solution();
		    
		    System.out.println(obj.lcs(p, q, s1, s2));
		}
	}
}// } Driver Code Ends


class Solution
{
    //Function to find the length of longest common subsequence in two strings.
    static int lcs(int x, int y, String s1, String s2)
    {
        int[][] dp = new int[s1.length()][s2.length()];
        for(int i=0;i<x;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s1.length()-1,s2.length()-1,s1,s2,dp);
    }
    public static int solve(int i1,int i2,String s1,String s2,int[][] dp){
        if(i1<0 || i2<0){
            return 0;
        }
        if(dp[i1][i2]!=-1){
            return dp[i1][i2];
        }
        int t1 = 0;
        int t2 = 0;
        if(s1.charAt(i1)==s2.charAt(i2)){
            t1 = 1+solve(i1-1,i2-1,s1,s2,dp);
        }else{
            t1 = solve(i1-1,i2,s1,s2,dp);
            t2 = solve(i1,i2-1,s1,s2,dp);
        }
        return dp[i1][i2]=Math.max(t1,t2);
    }
    
}