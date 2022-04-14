// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            int N = Integer.parseInt(in.readLine());
            String input_line[] = in.readLine().trim().split("\\s+");
            int arr[] = new int[N];
            for(int i = 0;i < N;i++)
                arr[i] = Integer.parseInt(input_line[i]);
            
            Solution ob = new Solution();
            int x = ob.equalPartition(N, arr);
            if(x == 1)
                System.out.println("YES");
            else
                System.out.println("NO");
        }
    }
}// } Driver Code Ends


// User function Template for Java

class Solution{
    static int equalPartition(int N, int arr[])
    {
        
        int sum = 0;
        for(int i=0;i<N;i++){
            sum = sum +arr[i];
        }
        int dp[][] = new int[N][sum/2+1];
        for(int i=0;i<N;i++){
            Arrays.fill(dp[i],-1);
        }
        if(sum%2!=0){
            return 0;
        }
        int x = solve(arr,0,sum/2,dp);
        if(x!=0){
            return 1;
        }
        return 0;
    }
    public static int solve(int[] arr, int i,int sum,int[][] dp){
        if(sum==0){
            return 1;
        }
        if(i==arr.length-1){
            if(arr[i]==sum){
                return 1;
            }else{
                return 0;
            }
        }
        if(dp[i][sum]!=-1){
            return dp[i][sum];
        }
        int t1 = 0;
        int t2 = 0;
        if(arr[i]<=sum){
            t1 = solve(arr,i+1,sum-arr[i],dp);
            t2 = solve(arr,i+1,sum,dp);
        }else{
            t2 = solve(arr,i+1,sum,dp);
        }
        return dp[i][sum]=t1+t2;
    }
}