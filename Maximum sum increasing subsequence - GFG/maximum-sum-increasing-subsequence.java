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
                    int n = sc.nextInt();
                    int Arr[] = new int[n];
                    for(int i = 0;i<n;i++)
                        Arr[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.maxSumIS(Arr,n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public int maxSumIS(int arr[], int n)  
	{  
	    int[][] dp = new int[n+1][n+1];
	    for(int i=0;i<n+1;i++){
	        Arrays.fill(dp[i],-1);
	    }
	    return solve(arr,0,-1,dp);
	}
	public static int solve(int[] strs,int ind,int ind2,int[][] dp){
	    if(ind==strs.length){
            return 0;
        }
        if(ind2>=0 && dp[ind][ind2+1]!=-1){
            return dp[ind][ind2+1];
        }
        int pick = 0;
        int notpick = 0;
        if(ind2<0 || strs[ind]>strs[ind2]){
            pick = strs[ind]+solve(strs,ind+1,ind,dp);
            notpick = solve(strs,ind+1,ind2,dp);
        }else{
            notpick = solve(strs,ind+1,ind2,dp);
        }
        return dp[ind][ind2+1]=Math.max(pick,notpick);
	} 
}