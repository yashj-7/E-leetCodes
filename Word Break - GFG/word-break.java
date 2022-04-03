// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
public class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n;
                    n = sc.nextInt();
                    ArrayList<String> arr = new ArrayList<String>();
                    for(int i = 0;i<n;i++)
                        {
                            String p = sc.next();
                            arr.add(p);
                        }
                    String line = sc.next();
                    Sol obj = new Sol();  
                    System.out.println(obj.wordBreak(line,arr));  
                    
                }
        }
}// } Driver Code Ends


//User function Template for Java

class Sol
{
    public static int wordBreak(String A, ArrayList<String> B )
    {
        int[] dp = new int[A.length()];
        Arrays.fill(dp,-1);
        boolean x = solve(A,0,B,"",dp);
        return x==true?1:0;
    }
    
    public static boolean solve(String s,int i,List<String> wordDict,String temp,int[] dp){
        if(wordDict.contains(temp)){
            return true;
        }
        if(i==s.length()){
            return true;
        }
        if(dp[i]!=-1){
            return dp[i]==1?true:false;
        }
        boolean t1 = false;
        for(int j=i;j<s.length();j++){
            temp = temp+Character.toString(s.charAt(j));
            if(wordDict.contains(temp)==true){
                if(solve(s,j+1,wordDict,"",dp)==true){
                    return true;
                }
            }
        }
        if(t1==true){
            dp[i] = 1;
            
        }else{
            dp[i] = 0;
        }
        return false;
    }
    
}