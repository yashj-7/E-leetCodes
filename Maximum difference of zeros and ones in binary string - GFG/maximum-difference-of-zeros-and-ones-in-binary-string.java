// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String args[]) throws IOException {
        BufferedReader read =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while (t-- > 0) {
            
            String s = read.readLine();
            Solution ob = new Solution();
            System.out.println(ob.maxSubstring(s));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int maxSubstring(String s) {
        int[] dp = new int[s.length()];
        if(s.charAt(0)=='0'){
            dp[0]=1;
        }else{
            dp[0]=-1;
        }
        for(int i=1;i<s.length();i++){
            if(dp[i-1]==-1){
                if(s.charAt(i)=='1'){
                    dp[i]=-1;
                }else{
                    dp[i]=1;
                }
            }else{
                if(s.charAt(i)=='0'){
                    dp[i]=dp[i-1]+1;
                }else{
                    dp[i] = dp[i-1]-1;
                }
            }
        }
        int max = (int)-1e9;
        for(int i=0;i<dp.length;i++){
            max = Math.max(max,dp[i]);
        }
        return max;
    }
}