// { Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total testcases
        int t = sc.nextInt();
        while(t > 0){
            
            //taking size of array
            int n = sc.nextInt();
            int array[] = new int[n];
            
            //inserting elements in the array
            for (int i = 0; i < n; ++i)
            {
                array[i] = sc.nextInt();
            }
            
            //creating an object of class Solution
            Solution ob = new Solution();
            
            //calling longestSubsequence() method of class
            //Solution
            System.out.println(ob.longestSubsequence(n,array));
            t--;
        }
    } 
} // } Driver Code Ends




class Solution 
{
    //Function to find length of longest increasing subsequence.
    static int longestSubsequence(int size, int a[])
    {
        int[][] dp = new int[size][size];
        for(int i=0;i<dp.length;i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(a,0,-1,dp);
    }
    public static int solve(int[] a,int i,int prev,int[][] dp){
        if(i>a.length-1){
            return 0;
        }
        if(prev!=-1 && dp[i][prev]!=-1){
            return dp[i][prev];
        }
        int t1 = 0;
        int t2 = 0;
        if(prev==-1 || a[i]>a[prev]){
            t1 = 1+solve(a,i+1,i,dp);
            t2 = solve(a,i+1,prev,dp);
        }else{
            t2 = solve(a,i+1,prev,dp);
        }
        if(prev==-1){
            return Math.max(t1,t2);
        }
        return dp[i][prev]=Math.max(t1,t2);
    }
} 