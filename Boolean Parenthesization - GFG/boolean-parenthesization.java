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
            int N = Integer.parseInt(in.readLine());
            String S = in.readLine();
            
            Solution ob = new Solution();
            System.out.println(ob.countWays(N, S));
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countWays(int N, String S){
        // code here
        int[][][] dp = new int[201][201][2];
        for(int i=0;i<dp.length;i++){
            for(int j=0;j<dp[0].length;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(S,0,S.length()-1,true,dp);
    }
    public static int solve(String s,int i,int j,boolean isTrue,int[][][] dp){
        if(i>j){
            return 0;
        }
        if(i==j){
            if(isTrue==true){
                if(s.charAt(i)=='T'){
                    return 1;
                }
                return 0;
            }else{
                if(s.charAt(i)=='T'){
                    return 0;
                }
                return 1;
            }
        }
        if(isTrue==true && dp[i][j][1]!=-1){
            return dp[i][j][1];
        }else if(isTrue == false && dp[i][j][0]!=-1){
            return dp[i][j][0];
        }
        int ans = 0;
            for(int k=i+1;k<=j-1;k++){
                int lt = solve(s,i,k-1,true,dp);
                int lf = solve(s,i,k-1,false,dp);
                int rt = solve(s,k+1,j,true,dp);
                int rf = solve(s,k+1,j,false,dp);
                if(s.charAt(k)=='&'){
                    if(isTrue == true){
                        ans = ans + lt*rt;    
                    }else{
                        ans = ans+ lf*rf +lf*rt + lt*rf;
                    }
                    
                }else if(s.charAt(k)=='|'){
                    if(isTrue==true){
                        ans = ans + lt*rt + lt*rf + lf*rt ;    
                    }else{
                        ans = ans+lf*rf;
                    }
                    
                }else if(s.charAt(k)=='^'){
                    if(isTrue==true){
                        ans = ans + lt*rf + lf*rt;
                    }else{
                        ans = ans + lt*rt + lf*rf;
                    }
                }
            }
            if(isTrue==true){
                dp[i][j][1]=ans%1003;
            }else if(isTrue == false ){
                dp[i][j][0] = ans%1003;
            }
            return ans%1003;
    }
}