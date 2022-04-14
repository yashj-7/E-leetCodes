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
                    int w = sc.nextInt();
                    int cost[] = new int[n];
                    for(int i = 0;i<n;i++)
                        cost[i] = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.minimumCost(cost,n,w));
                }
        }
}    // } Driver Code Ends


class Solution
{
	public int minimumCost(int cost[], int N,int W)
	{
	    int[][] dp = new int[N][W+1];
		for(int i=0;i<N;i++){
		    Arrays.fill(dp[i],-1);
		}
		int x = solve(0,cost,W,dp);
		
		if(x>=(int)1e9){
		    return -1;
		}else{
		    return x;
		}
	}
	public static int solve(int i,int[] cost,int w,int[][] dp){
	    if(w==0){
	        return 0;
	    }
	    if(i>cost.length-1 || w<0){
	        return (int)1e9;
	    }
	    if(dp[i][w]!=-1){
	        return dp[i][w];
	    }
	    int t1 = (int)1e9;
	    int t2 = (int)1e9;
	    if(i+1<=w){
	        if(cost[i]!=-1){
	            t1 = cost[i]+solve(i,cost,w-(i+1),dp);
	            t2 = solve(i+1,cost,w,dp);   
	        }else{
	            t2 = solve(i+1,cost,w,dp);
	        }
	        
	    }else{
	        return (int)1e9;
	    }
	    return dp[i][w]=Math.min(t1,t2);
	}
}