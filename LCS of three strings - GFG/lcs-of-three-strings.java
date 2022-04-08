// { Driver Code Starts
//Initial Template for Java
import java.io.*;
import java.util.*; 
class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        while(t-- > 0){
            String input_line[] = read.readLine().trim().split("\\s+");
            int n1 = Integer.parseInt(input_line[0]);
            int n2 = Integer.parseInt(input_line[1]);
            int n3 = Integer.parseInt(input_line[2]);
            input_line = read.readLine().trim().split("\\s+");
            String A = input_line[0];
            String B = input_line[1];
            String C = input_line[2];
            Solution obj = new Solution();
            System.out.println(obj.LCSof3(A, B, C, n1, n2, n3));
        }
    } 
} // } Driver Code Ends


//User function Template for Java
class Solution 
{ 
    int LCSof3(String A, String B, String C, int n1, int n2, int n3) 
    { 
        int[][][] dp = new int[n1][n2][n3];
        for(int i=0;i<n1;i++){
            for(int j=0;j<n2;j++){
                Arrays.fill(dp[i][j],-1);
            }
        }
        return solve(n1-1,n2-1,n3-1,A,B,C,dp);
    }
    public static int solve(int i1,int i2,int i3,String s1,String s2,String s3,int[][][] dp){
        if(i1<0 || i2<0 || i3<0){
            return 0;
        }
        if(dp[i1][i2][i3]!=-1){
            return dp[i1][i2][i3];
        }
        int t1 =0;
        int t2 =0;
        int t3 =0;
        if(s1.charAt(i1)==s2.charAt(i2) && s2.charAt(i2)==s3.charAt(i3)){
            t1 = 1+solve(i1-1,i2-1,i3-1,s1,s2,s3,dp);
        }else{
            t1 = solve(i1-1,i2,i3,s1,s2,s3,dp);
            t2 = solve(i1,i2-1,i3,s1,s2,s3,dp);
            t3 = solve(i1,i2,i3-1,s1,s2,s3,dp);
        }
        return dp[i1][i2][i3]=Math.max(t1,Math.max(t2,t3));
    }
} 