// { Driver Code Starts
import java.util.*;
import java.lang.*;
import java.io.*;

class GFG {
    
    
	public static void main (String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int t = Integer.parseInt(br.readLine().trim());
		while(t-->0){
		    long n = Long.parseLong(br.readLine().trim());
		    String inputLine[] = br.readLine().trim().split(" ");
		    long[] arr = new long[(int)n];
		    for(int i=0; i<n; i++)arr[i]=Long.parseLong(inputLine[i]);
		    System.out.println(new Solution().getMaxArea(arr, n));
		}
	}
}



// } Driver Code Ends


class Solution
{
    //Function to find largest rectangular area possible in a given histogram.
    public static long getMaxArea(long hist[], long n) 
    {
        // your code here
        long ps[] = prevSmallest(hist, (int)n);
        long ns[] = nextSmallest(hist, (int)n);
        long big = 0L;
        for(int i=0; i<n; i++) {
            long area = (ns[i]-ps[i]-1) * hist[i];
            big = Math.max(area, big);
        }
        
        return big;
    }
    
    static long[] prevSmallest(long arr[], int n) {
        Stack<Long> s = new Stack<>();
        long out[] = new long[n];
        
        for(int i=0; i<n; i++) {
            while(!s.isEmpty() && arr[i] <= arr[(int) (long)s.peek()]) {
                s.pop();
            }
            
            if(s.isEmpty()) {
                out[i] = -1;
            } else {
                out[i] = s.peek();
            }
            
            s.push(Long.valueOf(i));
        }
        
        return out;
    }
    
    static long[] nextSmallest(long arr[], int n) {
        Stack<Long> s = new Stack<>();
        long out[] = new long[n];
        
        for(int i=n-1; i>=0; i--) {
            while(!s.isEmpty() && arr[i] <= arr[(int) (long)s.peek()]) {
                s.pop();
            }
            
            if(s.isEmpty()) {
                out[i] = n;
            } else {
                out[i] = s.peek();
            }
            
            s.push(Long.valueOf(i));
        }
        
        return out;
    }
        
}



