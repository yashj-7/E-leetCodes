// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG{
    public static void main(String args[])throws IOException
    {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(in.readLine());
        while(t-- > 0){
            String str = in.readLine();
            Solution ob = new Solution();
            System.out.println(ob.palindromicPartition(str));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int palindromicPartition(String s)
    {
        // code here
        int[][] dp = new int[s.length()][s.length()];
        for(int i=0;i<s.length();i++){
            Arrays.fill(dp[i],-1);
        }
        return solve(s,0,s.length()-1,dp);
    }
    public static int solve(String s,int i,int j,int[][] dp){
        if(i>=j){
            return 0;
        }
        if(dp[i][j]!=-1){
            return dp[i][j];
        }
        if(isPalindrome(s,i,j)==true){
            return 0;
        }
        
        int min = Integer.MAX_VALUE;
        for(int k=i;k<=j-1;k++){
            int temp1 =0;
            int temp2 = 0;
            if(dp[i][k]!=-1){
                temp1 = dp[i][k];
            }else{
                temp1 = solve(s,i,k,dp);
                dp[i][k]=temp1;
            }
            if(dp[k+1][j]!=-1){
                temp2 = dp[k+1][j];
            }else{
                temp2 = solve(s,k+1,j,dp);
                dp[k+1][j] = temp2;
            }
            
            min = Math.min(min,temp1+temp2+1);
        }
        return dp[i][j]=min;
    }
    public static boolean isPalindrome(String s,int i,int j){
        while(i<=j){
            if(s.charAt(i)!=s.charAt(j)){
                return false;
            }
            i++;
            j--;
        }
        return true;
    }
}