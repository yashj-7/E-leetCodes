// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
import java.util.Collections;


class GFG{
    public static void main(String args[]) throws IOException { 
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        
        while(t > 0){
            int N = sc.nextInt();
            int[] Arr = new int[N];
            for (int i = 0; i < N; ++i){
                Arr[i] = sc.nextInt();
            }
            Solution ob = new Solution();
            int ans = ob.minSubset(Arr,N);
            System.out.println(ans);
            t--;
        }
    }
}// } Driver Code Ends


//User function Template for Java

class Solution { 
    int minSubset(int[] Arr,int N) { 
        long sum = 0;
        for(int i=0;i<N;i++){
            sum =sum+Arr[i];
        }
        long ans = 0;
        int res = 0;
        Arrays.sort(Arr);
        for(int i=Arr.length-1;i>=0;i--){
            ans = ans+Arr[i];
            res++;
            if(ans>sum/2){
                return res;
            }
        }
        return res;
    }
}