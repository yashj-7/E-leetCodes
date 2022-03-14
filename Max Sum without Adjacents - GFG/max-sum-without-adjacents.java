// { Driver Code Starts
//Initial Template for Java



import java.util.*;
import java.io.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            String[] inputLine;
            int n = Integer.parseInt(br.readLine().trim());
            int[] arr = new int[n];
            inputLine = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                arr[i] = Integer.parseInt(inputLine[i]);
            }

            int ans = new Solution().findMaxSum(arr, n);
            System.out.println(ans);
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution {
    int findMaxSum(int arr[], int n) {
        int[] t = new int[arr.length+1];
        return solve(0,arr,t);
    }
    public static int solve(int index,int[] nums,int t[]){
        
        t[0] = 0;
        t[1]=nums[0];
        for(int i=2;i<nums.length+1;i++){
             	t[i] = Math.max(nums[i-1]+t[i-2],t[i-1]);   
        }
        return t[nums.length];
    }
}