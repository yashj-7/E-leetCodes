// { Driver Code Starts
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
            int n = Integer.parseInt(br.readLine().trim());
            int[] nums = new int[n];
            String[] S = br.readLine().trim().split(" ");
            for(int i = 0; i < n; i++)
                nums[i]  =Integer.parseInt(S[i]);
            int k = Integer.parseInt(br.readLine().trim());
            Solution obj = new Solution();
            System.out.println(obj.solveWordWrap(nums, k));
        }
    }
}
// } Driver Code Ends


class Solution
{
    public int solveWordWrap (int[] nums, int k)
    {
        int[] dp = new int[nums.length];
            Arrays.fill(dp,-1);
        return solve(0,nums,k,dp);
    }
    public static int solve(int i,int[] nums,int x,int[] dp){
        if(i>=nums.length){
            return 0;
        }
        if(dp[i]!=-1){
            return dp[i];
        }
        int min = (int)1e9;
        int sum = 0;
        for(int k=i;k<nums.length;k++){
            sum = sum+nums[k];
            if(sum+(k-i)<=x){
                int cost = 0;
                if(k!=nums.length-1){
                    cost = (int)Math.pow(x-sum-k+i,2);
                }
                min = Math.min(min,cost+solve(k+1,nums,x,dp));
            }
        }
        return dp[i]=min;
    }
}