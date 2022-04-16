// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class GFG
{
    public static void main(String args[])throws IOException
    {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0)
        {
            
            String S = read.readLine().trim();
            Solution ob = new Solution();
            System.out.println(ob.longestPalindrome(S));
        }
    }
}// } Driver Code Ends


class Solution{
    String longestPalindrome(String S){
        boolean[][] dp = new boolean[S.length()][S.length()];
        int k = 0;
        while(k<S.length()){
            int i=0;
            int j = k;
            while(i<S.length() && j<S.length()){
                if(j-i==0){
                    dp[i][j] = true;
                }else if(j-i==1){
                    if(S.charAt(i)==S.charAt(j)){
                        dp[i][j]=true;
                    }else{
                        dp[i][j]=false;
                    }
                }else{
                    if(S.charAt(i)==S.charAt(j)){
                        if(dp[i+1][j-1]==true){
                            dp[i][j]=true;
                        }else{
                            dp[i][j]=false;
                        }
                    }else{
                        dp[i][j]=false;
                    }
                }
                i++;
                j++;
            }
            k++;
        }
        int maxi = 0;
        int maxj = 0;
        for(int i=0;i<S.length();i++){
            for(int j=0;j<S.length();j++){
                if(dp[i][j]==true){
                        if(j-i>(maxj-maxi)){
                        maxj = j;
                        maxi = i;
                    }    
                }
            }
        }
        return S.substring(maxi,maxj+1);
    }
}