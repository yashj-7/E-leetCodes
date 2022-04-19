// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;
class GfG
{
    public static void main(String args[])
        {
            Scanner sc = new Scanner(System.in);
            int t = sc.nextInt();
            while(t-->0)
                {
                    int n = sc.nextInt();
                    Solution ob = new Solution();
                    System.out.println(ob.getCount(n));
                }
        }
}    // } Driver Code Ends


//User function Template for Java

class Solution
{
	public long getCount(int N)
	{
	    
	    int[][] data = {
	        {0,8},{1,2,4},{1,2,3,5},{2,3,6},{1,5,4,7},{2,4,5,6,8},{3,6,5,9},{4,7,8},{5,7,8,9,0},{6,9,8}
	    };
	    
// 		ArrayList<Integer>[] data = new ArrayList[10];
// 		data[0] = new ArrayList<>(Arrays.asList({0,8})));
// 		data[1] = new ArrayList<>(Arrays.asList({1,2,4}));
// 		data[2] = new ArrayList<>(Arrays.asList({1,2,3,5}));
// 		data[3] = new ArrayList<>(Arrays.asList({2,3,6}));
// 		data[4] = new ArrayList<>(Arrays.asList({1,5,4,7}));
// 		data[5] = new ArrayList<>(Arrays.asList({2,4,5,6,8}));
// 		data[6] = new ArrayList<>(Arrays.asList({3,6,5,9}));
// 		data[7] = new ArrayList<>(Arrays.asList({4,7,8}));
// 		data[8] = new ArrayList<>(Arrays.asList({5,7,8,9,0}));
// 		data[9] = new ArrayList<>(Arrays.asList({6,9,8}));
		long[][] dp = new long[N+1][10];
		for(int i=0;i<10;i++){
		    dp[0][i]=0;
		    dp[1][i]=1;
		}
		for(int i=2;i<N+1;i++){
		    for(int j=0;j<10;j++){
		        for(int z=0;z<data[j].length;z++){
		            dp[i][j] += dp[i-1][data[j][z]];
		        }
		    }
		}
		long sum = 0;
		for(int i=0;i<10;i++){
		    sum = sum+dp[N][i];
		    //System.out.print(dp[N][i]+" ");
		}
		return sum;
	}
}