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
    
    int sum =0;
        for(int i=0;i<N;i++){
            sum = sum+arr[i];
        }
        if(sum%2!=0){
            return 0;
        }
        int s = sum/2;
        int[][] dp = new int[N+1][s+1];
        for(int i=0;i<N+1;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(arr.length-1,arr,s,dp)==true?1:0;
        
    }
    public static boolean solve(int N,int[] arr,int sum,int[][] dp){
        if(N==0){
            if(arr[N]==sum){
                return true;
            }
            return false;
        }
        if(dp[N][sum]!=-1){
            return dp[N][sum]==0?false:true;
        }
        boolean t1 = false;
        boolean t2 = false;
        if(arr[N]<=sum){
            t1 = solve(N-1,arr,sum-arr[N],dp);
            t2 = solve(N-1,arr,sum,dp);
        }else{
            t2 = solve(N-1,arr,sum,dp);
        }
        if(t1||t2==true){
            dp[N][sum]=1;
        }else{
            dp[N][sum] = 0;
        }
        return t1||t2;
    }
}