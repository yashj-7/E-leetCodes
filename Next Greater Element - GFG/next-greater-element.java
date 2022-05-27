// { Driver Code Starts
/*package whatever //do not write package name here */

import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    int n = Integer.parseInt(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    long[] res = new Solution().nextLargerElement(arr, n);
		    for (int i = 0; i < n; i++) 
		        System.out.print(res[i] + " ");
		    System.out.println();
		}
	}
}



// } Driver Code Ends


class Solution
{
    
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        Stack<Long> s = new Stack<>();
        long[] ans = new long[arr.length];
        ans[arr.length-1] = -1;
        s.push(arr[arr.length-1]);
        for(int i=arr.length-2;i>=0;i--){
           if(arr[i]<s.peek()){
               ans[i] = s.peek();
               s.push(arr[i]);
           } else{
               while(s.isEmpty()==false && s.peek()<arr[i]){
                   s.pop();
               }
               if(s.isEmpty()){
                   ans[i] = -1;
               }else{
                   ans[i] = s.peek();
                   
               }
               s.push(arr[i]);
           }
        }
        return ans;
    } 
}