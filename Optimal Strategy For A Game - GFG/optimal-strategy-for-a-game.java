// { Driver Code Starts
import java.util.*;
import java.io.*;
import java.lang.*;

class OptimalStrategy
{
    public static void main (String[] args) {
        
        //taking input using Scanner class
        Scanner sc = new Scanner(System.in);
        
        //taking total number of testcases
        int t = sc.nextInt();
        
        while(t-- > 0)
        {
            //taking number of elements
            int n = sc.nextInt();
            int arr[] = new int[n];
            
            //inserting the elements
            for(int i = 0; i < n; i++)
                arr[i] = sc.nextInt();
                
           //calling the countMaximum() method of class solve
           System.out.println(new solve().countMaximum(arr, n)); 
        }
    }
    
    
}// } Driver Code Ends



class solve
{
    //Function to find the maximum possible amount of money we can win.
    static long countMaximum(int nums[], int n)
    {
        int[][] dp = new int[nums.length][nums.length];
        int k =0;
        while(k<nums.length){
            int j =k;
            int i =0;
            while(i<nums.length && j<nums.length){
                if(i==j){
                    dp[i][j] = nums[i];
                }else if(Math.abs(j-i)==1){
                    dp[i][j] = Math.max(nums[i],nums[j]);
                }else{
                    dp[i][j] = Math.max(nums[i]+Math.min(dp[i+2][j],dp[i+1][j-1]),nums[j]+Math.min(dp[i][j-2],dp[i+1][j-1]));
                }
                i++;
                j++;
            }
            k++;
        }
        return dp[0][nums.length-1];
    }
}
